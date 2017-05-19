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
    private static final HashMap<String, Long> cWD = new HashMap<>();
    private static final HashMap<String, Integer> cWE = new HashMap<>();
    private static final HashMap<String, Long> cWF = new HashMap<>();
    private static c cWL;
    private List<b> cWG;
    private List<a> cWH;
    private String cWI = null;
    private String cWJ = null;
    private long xn = -1;
    private boolean cWK = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cWM = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cWN = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cWO = new g(this, 202003);
    private final CustomMessageListener cWP = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        cWD.put("2g", 60L);
        cWD.put("3g", 40L);
        cWD.put("4g", 40L);
        cWD.put("wifi", 10L);
        cWE.put("2g", 10);
        cWE.put("3g", 10);
        cWE.put("4g", 10);
        cWE.put("wifi", 10);
        cWF.put("2g", 300L);
        cWF.put("3g", 60L);
        cWF.put("4g", 60L);
        cWF.put("wifi", 5L);
        cWL = null;
    }

    public String apD() {
        return this.cWJ;
    }

    public String apE() {
        return this.cWI;
    }

    public void apF() {
        this.cWI = null;
        this.cWJ = null;
    }

    public static synchronized c apG() {
        c cVar;
        synchronized (c.class) {
            if (cWL == null) {
                cWL = new c();
            }
            cVar = cWL;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), apU());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), apS());
    }

    public c() {
        this.cWG = null;
        this.cWH = null;
        apH();
        this.cWH = new ArrayList();
        this.cWG = new ArrayList();
    }

    private void apH() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.cWM);
        MessageManager.getInstance().registerListener(this.cWN);
        MessageManager.getInstance().registerListener(this.cWO);
        MessageManager.getInstance().registerListener(this.cWP);
    }

    public void apI() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kM(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (apQ() && System.currentTimeMillis() - this.xn > apS()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String apJ() {
        return String.valueOf(com.baidu.adp.lib.util.i.hq());
    }

    public String apK() {
        switch (com.baidu.adp.lib.util.i.hq()) {
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

    public int apL() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apM() {
        if (!this.cWK) {
            if (this.cWG != null && this.cWG.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cWG.size()) {
                        break;
                    }
                    b bVar = this.cWG.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.cWC = bVar.cWC;
                        aVar.cWB = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cWG.size(); i3++) {
                            b bVar2 = this.cWG.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.cWC == aVar.cWC) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cWB++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cWH.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cWG.clear();
            if (this.cWH.size() > apT() && apP() && com.baidu.adp.lib.util.i.hk()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cWH.size() > 100 && !apQ() && !apP()) {
                this.cWH.clear();
            }
        }
    }

    public void apN() {
        if (this.cWH.size() > 0) {
            this.cWK = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cWH) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.cWB);
                builder.process_type = Integer.valueOf(aVar.cWC);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apO() {
        String str;
        com.baidu.tbadk.data.e apR = apR();
        return (apR == null || (str = apR.axG) == null || !str.equals("1")) ? false : true;
    }

    private boolean apP() {
        String str;
        com.baidu.tbadk.data.e apR = apR();
        return apR == null || (str = apR.axE.get(apK())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apQ() {
        String str;
        com.baidu.tbadk.data.e apR = apR();
        return apR == null || (str = apR.axD.get(apK())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.e apR() {
        return com.baidu.tbadk.data.e.BM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long apS() {
        String str;
        com.baidu.tbadk.data.e apR = apR();
        if (apR != null && (str = apR.axD.get(apK())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cWD.get(apK()).longValue() * 1000;
    }

    private int apT() {
        String str;
        int g;
        com.baidu.tbadk.data.e apR = apR();
        return (apR == null || (str = apR.axE.get(apK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? cWE.get(apK()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long apU() {
        String str;
        int g;
        com.baidu.tbadk.data.e apR = apR();
        return (apR == null || (str = apR.axF.get(apK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? cWF.get(apK()).longValue() * 1000 : g * 1000;
    }
}
