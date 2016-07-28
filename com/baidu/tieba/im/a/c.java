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
    private static final HashMap<String, Long> cUB = new HashMap<>();
    private static final HashMap<String, Integer> cUC = new HashMap<>();
    private static final HashMap<String, Long> cUD = new HashMap<>();
    private static c cUJ;
    private List<b> cUE;
    private List<a> cUF;
    private String cUG = null;
    private String cUH = null;
    private long nX = -1;
    private boolean cUI = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cUK = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cUL = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cUM = new g(this, 202003);
    private final CustomMessageListener cUN = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener oz = new i(this, 2000994);

    static {
        cUB.put("2g", 60L);
        cUB.put("3g", 40L);
        cUB.put("4g", 40L);
        cUB.put("wifi", 10L);
        cUC.put("2g", 10);
        cUC.put("3g", 10);
        cUC.put("4g", 10);
        cUC.put("wifi", 10);
        cUD.put("2g", 300L);
        cUD.put("3g", 60L);
        cUD.put("4g", 60L);
        cUD.put("wifi", 5L);
        cUJ = null;
    }

    public String apF() {
        return this.cUH;
    }

    public String apG() {
        return this.cUG;
    }

    public void apH() {
        this.cUG = null;
        this.cUH = null;
    }

    public static synchronized c apI() {
        c cVar;
        synchronized (c.class) {
            if (cUJ == null) {
                cUJ = new c();
            }
            cVar = cUJ;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), apW());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), apU());
    }

    public c() {
        this.cUE = null;
        this.cUF = null;
        apJ();
        this.cUF = new ArrayList();
        this.cUE = new ArrayList();
    }

    private void apJ() {
        MessageManager.getInstance().registerListener(this.oz);
        MessageManager.getInstance().registerListener(this.cUK);
        MessageManager.getInstance().registerListener(this.cUL);
        MessageManager.getInstance().registerListener(this.cUM);
        MessageManager.getInstance().registerListener(this.cUN);
    }

    public void apK() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void lb(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (apS() && System.currentTimeMillis() - this.nX > apU()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String apL() {
        return String.valueOf(com.baidu.adp.lib.util.i.fw());
    }

    public String apM() {
        switch (com.baidu.adp.lib.util.i.fw()) {
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

    public int apN() {
        return TbadkCoreApplication.m10getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apO() {
        if (!this.cUI) {
            if (this.cUE != null && this.cUE.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cUE.size()) {
                        break;
                    }
                    b bVar = this.cUE.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.cUz = bVar.cUz;
                        aVar.cUA = bVar.cUA;
                        aVar.cUy = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cUE.size(); i3++) {
                            b bVar2 = this.cUE.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.cUz != null && aVar.cUz != null && bVar2.cUz.equals(aVar.cUz) && bVar2.cUA == aVar.cUA) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cUy++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cUF.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cUE.clear();
            if (this.cUF.size() > apV() && apR() && com.baidu.adp.lib.util.i.fq()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cUF.size() > 100 && !apS() && !apR()) {
                this.cUF.clear();
            }
        }
    }

    public void apP() {
        if (this.cUF.size() > 0) {
            this.cUI = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cUF) {
                builder.et = aVar.emitTime;
                builder.net = aVar.cUz;
                builder.pushcnt = Integer.valueOf(aVar.cUy);
                builder.process_type = Integer.valueOf(aVar.cUA);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apQ() {
        String str;
        com.baidu.tbadk.data.f apT = apT();
        return (apT == null || (str = apT.apD) == null || !str.equals("1")) ? false : true;
    }

    private boolean apR() {
        String str;
        com.baidu.tbadk.data.f apT = apT();
        return apT == null || (str = apT.apB.get(apM())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apS() {
        String str;
        com.baidu.tbadk.data.f apT = apT();
        return apT == null || (str = apT.apA.get(apM())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f apT() {
        return com.baidu.tbadk.data.f.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long apU() {
        String str;
        com.baidu.tbadk.data.f apT = apT();
        if (apT != null && (str = apT.apA.get(apM())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cUB.get(apM()).longValue() * 1000;
    }

    private int apV() {
        String str;
        int g;
        com.baidu.tbadk.data.f apT = apT();
        return (apT == null || (str = apT.apB.get(apM())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cUC.get(apM()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long apW() {
        String str;
        int g;
        com.baidu.tbadk.data.f apT = apT();
        return (apT == null || (str = apT.apC.get(apM())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cUD.get(apM()).longValue() * 1000 : g * 1000;
    }
}
