package com.baidu.tieba.im.a;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> blG = new HashMap<>();
    private static final HashMap<String, Integer> blH = new HashMap<>();
    private static final HashMap<String, Long> blI = new HashMap<>();
    private static c blO;
    private List<b> blJ;
    private List<a> blK;
    private String blL = null;
    private String blM = null;
    private long mLastUploadTime = -1;
    private boolean blN = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e blP = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e blQ = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e blR = new g(this, 202003);
    private final CustomMessageListener blS = new h(this, 2001011);

    static {
        blG.put("2g", 60L);
        blG.put("3g", 40L);
        blG.put("4g", 40L);
        blG.put("wifi", 10L);
        blH.put("2g", 10);
        blH.put("3g", 10);
        blH.put("4g", 10);
        blH.put("wifi", 10);
        blI.put("2g", 300L);
        blI.put("3g", 60L);
        blI.put("4g", 60L);
        blI.put("wifi", 5L);
        blO = null;
    }

    public String Tl() {
        return this.blM;
    }

    public String Tm() {
        return this.blL;
    }

    public void Tn() {
        this.blL = null;
        this.blM = null;
    }

    public static synchronized c To() {
        c cVar;
        synchronized (c.class) {
            if (blO == null) {
                blO = new c();
            }
            cVar = blO;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TC());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), TA());
    }

    public c() {
        this.blJ = null;
        this.blK = null;
        Tp();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.blK = new ArrayList();
        this.blJ = new ArrayList();
    }

    private void Tp() {
        MessageManager.getInstance().registerListener(this.blP);
        MessageManager.getInstance().registerListener(this.blQ);
        MessageManager.getInstance().registerListener(this.blR);
        MessageManager.getInstance().registerListener(this.blS);
    }

    public void Tq() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void ho(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Ty() && System.currentTimeMillis() - this.mLastUploadTime > TA()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Tr() {
        return String.valueOf(k.jc());
    }

    public String Ts() {
        switch (k.jc()) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "2g";
        }
    }

    public int Tt() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tu() {
        if (!this.blN) {
            if (this.blJ != null && this.blJ.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.blJ.size()) {
                        break;
                    }
                    b bVar = this.blJ.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.blE = bVar.blE;
                        aVar.blF = bVar.blF;
                        aVar.blD = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.blJ.size(); i3++) {
                            b bVar2 = this.blJ.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.blE != null && aVar.blE != null && bVar2.blE.equals(aVar.blE) && bVar2.blF == aVar.blF) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.blD++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.blK.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.blJ.clear();
            if (this.blK.size() > TB() && Tx() && k.iX()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.blK.size() > 100 && !Ty() && !Tx()) {
                this.blK.clear();
            }
        }
    }

    public void Tv() {
        if (this.blK.size() > 0) {
            this.blN = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.blK) {
                builder.et = aVar.emitTime;
                builder.net = aVar.blE;
                builder.pushcnt = Integer.valueOf(aVar.blD);
                builder.process_type = Integer.valueOf(aVar.blF);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tw() {
        String str;
        com.baidu.tbadk.data.c Tz = Tz();
        return (Tz == null || (str = Tz.aie) == null || !str.equals("1")) ? false : true;
    }

    private boolean Tx() {
        String str;
        com.baidu.tbadk.data.c Tz = Tz();
        return Tz == null || (str = Tz.aic.get(Ts())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ty() {
        String str;
        com.baidu.tbadk.data.c Tz = Tz();
        return Tz == null || (str = Tz.aib.get(Ts())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Tz() {
        return com.baidu.tbadk.data.c.yJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long TA() {
        String str;
        com.baidu.tbadk.data.c Tz = Tz();
        if (Tz != null && (str = Tz.aib.get(Ts())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.c.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return blG.get(Ts()).longValue() * 1000;
    }

    private int TB() {
        String str;
        int i;
        com.baidu.tbadk.data.c Tz = Tz();
        return (Tz == null || (str = Tz.aic.get(Ts())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? blH.get(Ts()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long TC() {
        String str;
        int i;
        com.baidu.tbadk.data.c Tz = Tz();
        return (Tz == null || (str = Tz.aid.get(Ts())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? blI.get(Ts()).longValue() * 1000 : i * 1000;
    }
}
