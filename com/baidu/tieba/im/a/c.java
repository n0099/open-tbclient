package com.baidu.tieba.im.a;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> dbN = new HashMap<>();
    private static final HashMap<String, Integer> dbO = new HashMap<>();
    private static final HashMap<String, Long> dbP = new HashMap<>();
    private static c dbV;
    private List<b> dbQ;
    private List<a> dbR;
    private String dbS = null;
    private String dbT = null;
    private long xI = -1;
    private boolean dbU = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dbW = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dbX = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dbY = new g(this, 202003);
    private final CustomMessageListener dbZ = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        dbN.put("2g", 60L);
        dbN.put("3g", 40L);
        dbN.put("4g", 40L);
        dbN.put("wifi", 10L);
        dbO.put("2g", 10);
        dbO.put("3g", 10);
        dbO.put("4g", 10);
        dbO.put("wifi", 10);
        dbP.put("2g", 300L);
        dbP.put("3g", 60L);
        dbP.put("4g", 60L);
        dbP.put("wifi", 5L);
        dbV = null;
    }

    public String arP() {
        return this.dbT;
    }

    public String arQ() {
        return this.dbS;
    }

    public void arR() {
        this.dbS = null;
        this.dbT = null;
    }

    public static synchronized c arS() {
        c cVar;
        synchronized (c.class) {
            if (dbV == null) {
                dbV = new c();
            }
            cVar = dbV;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), asg());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), ase());
    }

    public c() {
        this.dbQ = null;
        this.dbR = null;
        arT();
        this.dbR = new ArrayList();
        this.dbQ = new ArrayList();
    }

    private void arT() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dbW);
        MessageManager.getInstance().registerListener(this.dbX);
        MessageManager.getInstance().registerListener(this.dbY);
        MessageManager.getInstance().registerListener(this.dbZ);
    }

    public void arU() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kB(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (asc() && System.currentTimeMillis() - this.xI > ase()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String arV() {
        return String.valueOf(com.baidu.adp.lib.util.i.hk());
    }

    public String arW() {
        switch (com.baidu.adp.lib.util.i.hk()) {
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

    public int arX() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arY() {
        if (!this.dbU) {
            if (this.dbQ != null && this.dbQ.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dbQ.size()) {
                        break;
                    }
                    b bVar = this.dbQ.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dbM = bVar.dbM;
                        aVar.dbL = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dbQ.size(); i3++) {
                            b bVar2 = this.dbQ.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dbM == aVar.dbM) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dbL++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dbR.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dbQ.clear();
            if (this.dbR.size() > asf() && asb() && com.baidu.adp.lib.util.i.he()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dbR.size() > 100 && !asc() && !asb()) {
                this.dbR.clear();
            }
        }
    }

    public void arZ() {
        if (this.dbR.size() > 0) {
            this.dbU = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dbR) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dbL);
                builder.process_type = Integer.valueOf(aVar.dbM);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asa() {
        String str;
        com.baidu.tbadk.data.f asd = asd();
        return (asd == null || (str = asd.axr) == null || !str.equals("1")) ? false : true;
    }

    private boolean asb() {
        String str;
        com.baidu.tbadk.data.f asd = asd();
        return asd == null || (str = asd.axp.get(arW())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asc() {
        String str;
        com.baidu.tbadk.data.f asd = asd();
        return asd == null || (str = asd.axo.get(arW())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f asd() {
        return com.baidu.tbadk.data.f.Ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ase() {
        String str;
        com.baidu.tbadk.data.f asd = asd();
        if (asd != null && (str = asd.axo.get(arW())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dbN.get(arW()).longValue() * 1000;
    }

    private int asf() {
        String str;
        int g;
        com.baidu.tbadk.data.f asd = asd();
        return (asd == null || (str = asd.axp.get(arW())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dbO.get(arW()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long asg() {
        String str;
        int g;
        com.baidu.tbadk.data.f asd = asd();
        return (asd == null || (str = asd.axq.get(arW())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dbP.get(arW()).longValue() * 1000 : g * 1000;
    }
}
