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
    private static c cZC;
    private static final HashMap<String, Long> cZu = new HashMap<>();
    private static final HashMap<String, Integer> cZv = new HashMap<>();
    private static final HashMap<String, Long> cZw = new HashMap<>();
    private List<b> cZx;
    private List<a> cZy;
    private String cZz = null;
    private String cZA = null;
    private long qm = -1;
    private boolean cZB = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cZD = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cZE = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cZF = new g(this, 202003);
    private final CustomMessageListener cZG = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        cZu.put("2g", 60L);
        cZu.put("3g", 40L);
        cZu.put("4g", 40L);
        cZu.put("wifi", 10L);
        cZv.put("2g", 10);
        cZv.put("3g", 10);
        cZv.put("4g", 10);
        cZv.put("wifi", 10);
        cZw.put("2g", 300L);
        cZw.put("3g", 60L);
        cZw.put("4g", 60L);
        cZw.put("wifi", 5L);
        cZC = null;
    }

    public String asu() {
        return this.cZA;
    }

    public String asv() {
        return this.cZz;
    }

    public void asw() {
        this.cZz = null;
        this.cZA = null;
    }

    public static synchronized c asx() {
        c cVar;
        synchronized (c.class) {
            if (cZC == null) {
                cZC = new c();
            }
            cVar = cZC;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), asL());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), asJ());
    }

    public c() {
        this.cZx = null;
        this.cZy = null;
        asy();
        this.cZy = new ArrayList();
        this.cZx = new ArrayList();
    }

    private void asy() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.cZD);
        MessageManager.getInstance().registerListener(this.cZE);
        MessageManager.getInstance().registerListener(this.cZF);
        MessageManager.getInstance().registerListener(this.cZG);
    }

    public void asz() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void la(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (asH() && System.currentTimeMillis() - this.qm > asJ()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String asA() {
        return String.valueOf(com.baidu.adp.lib.util.i.gq());
    }

    public String asB() {
        switch (com.baidu.adp.lib.util.i.gq()) {
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

    public int asC() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asD() {
        if (!this.cZB) {
            if (this.cZx != null && this.cZx.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cZx.size()) {
                        break;
                    }
                    b bVar = this.cZx.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.cZt = bVar.cZt;
                        aVar.cZs = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cZx.size(); i3++) {
                            b bVar2 = this.cZx.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.cZt == aVar.cZt) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cZs++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cZy.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cZx.clear();
            if (this.cZy.size() > asK() && asG() && com.baidu.adp.lib.util.i.gk()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cZy.size() > 100 && !asH() && !asG()) {
                this.cZy.clear();
            }
        }
    }

    public void asE() {
        if (this.cZy.size() > 0) {
            this.cZB = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cZy) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.cZs);
                builder.process_type = Integer.valueOf(aVar.cZt);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asF() {
        String str;
        com.baidu.tbadk.data.f asI = asI();
        return (asI == null || (str = asI.arW) == null || !str.equals("1")) ? false : true;
    }

    private boolean asG() {
        String str;
        com.baidu.tbadk.data.f asI = asI();
        return asI == null || (str = asI.arU.get(asB())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asH() {
        String str;
        com.baidu.tbadk.data.f asI = asI();
        return asI == null || (str = asI.arT.get(asB())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f asI() {
        return com.baidu.tbadk.data.f.BO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long asJ() {
        String str;
        com.baidu.tbadk.data.f asI = asI();
        if (asI != null && (str = asI.arT.get(asB())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cZu.get(asB()).longValue() * 1000;
    }

    private int asK() {
        String str;
        int g;
        com.baidu.tbadk.data.f asI = asI();
        return (asI == null || (str = asI.arU.get(asB())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? cZv.get(asB()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long asL() {
        String str;
        int g;
        com.baidu.tbadk.data.f asI = asI();
        return (asI == null || (str = asI.arV.get(asB())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? cZw.get(asB()).longValue() * 1000 : g * 1000;
    }
}
