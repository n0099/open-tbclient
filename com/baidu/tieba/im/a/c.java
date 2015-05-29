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
    private static final HashMap<String, Long> blF = new HashMap<>();
    private static final HashMap<String, Integer> blG = new HashMap<>();
    private static final HashMap<String, Long> blH = new HashMap<>();
    private static c blN;
    private List<b> blI;
    private List<a> blJ;
    private String blK = null;
    private String blL = null;
    private long mLastUploadTime = -1;
    private boolean blM = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e blO = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e blP = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e blQ = new g(this, 202003);
    private final CustomMessageListener blR = new h(this, 2001011);

    static {
        blF.put("2g", 60L);
        blF.put("3g", 40L);
        blF.put("4g", 40L);
        blF.put("wifi", 10L);
        blG.put("2g", 10);
        blG.put("3g", 10);
        blG.put("4g", 10);
        blG.put("wifi", 10);
        blH.put("2g", 300L);
        blH.put("3g", 60L);
        blH.put("4g", 60L);
        blH.put("wifi", 5L);
        blN = null;
    }

    public String Tk() {
        return this.blL;
    }

    public String Tl() {
        return this.blK;
    }

    public void Tm() {
        this.blK = null;
        this.blL = null;
    }

    public static synchronized c Tn() {
        c cVar;
        synchronized (c.class) {
            if (blN == null) {
                blN = new c();
            }
            cVar = blN;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TB());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Tz());
    }

    public c() {
        this.blI = null;
        this.blJ = null;
        To();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.blJ = new ArrayList();
        this.blI = new ArrayList();
    }

    private void To() {
        MessageManager.getInstance().registerListener(this.blO);
        MessageManager.getInstance().registerListener(this.blP);
        MessageManager.getInstance().registerListener(this.blQ);
        MessageManager.getInstance().registerListener(this.blR);
    }

    public void Tp() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void ho(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Tx() && System.currentTimeMillis() - this.mLastUploadTime > Tz()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Tq() {
        return String.valueOf(k.jc());
    }

    public String Tr() {
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

    public int Ts() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (!this.blM) {
            if (this.blI != null && this.blI.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.blI.size()) {
                        break;
                    }
                    b bVar = this.blI.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.blD = bVar.blD;
                        aVar.blE = bVar.blE;
                        aVar.blC = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.blI.size(); i3++) {
                            b bVar2 = this.blI.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.blD != null && aVar.blD != null && bVar2.blD.equals(aVar.blD) && bVar2.blE == aVar.blE) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.blC++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.blJ.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.blI.clear();
            if (this.blJ.size() > TA() && Tw() && k.iX()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.blJ.size() > 100 && !Tx() && !Tw()) {
                this.blJ.clear();
            }
        }
    }

    public void Tu() {
        if (this.blJ.size() > 0) {
            this.blM = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.blJ) {
                builder.et = aVar.emitTime;
                builder.net = aVar.blD;
                builder.pushcnt = Integer.valueOf(aVar.blC);
                builder.process_type = Integer.valueOf(aVar.blE);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tv() {
        String str;
        com.baidu.tbadk.data.c Ty = Ty();
        return (Ty == null || (str = Ty.aie) == null || !str.equals("1")) ? false : true;
    }

    private boolean Tw() {
        String str;
        com.baidu.tbadk.data.c Ty = Ty();
        return Ty == null || (str = Ty.aic.get(Tr())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tx() {
        String str;
        com.baidu.tbadk.data.c Ty = Ty();
        return Ty == null || (str = Ty.aib.get(Tr())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Ty() {
        return com.baidu.tbadk.data.c.yI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Tz() {
        String str;
        com.baidu.tbadk.data.c Ty = Ty();
        if (Ty != null && (str = Ty.aib.get(Tr())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.c.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return blF.get(Tr()).longValue() * 1000;
    }

    private int TA() {
        String str;
        int i;
        com.baidu.tbadk.data.c Ty = Ty();
        return (Ty == null || (str = Ty.aic.get(Tr())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? blG.get(Tr()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long TB() {
        String str;
        int i;
        com.baidu.tbadk.data.c Ty = Ty();
        return (Ty == null || (str = Ty.aid.get(Tr())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? blH.get(Tr()).longValue() * 1000 : i * 1000;
    }
}
