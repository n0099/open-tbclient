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
    private static final HashMap<String, Long> dgl = new HashMap<>();
    private static final HashMap<String, Integer> dgm = new HashMap<>();
    private static final HashMap<String, Long> dgn = new HashMap<>();
    private static c dgt;
    private List<b> dgo;
    private List<a> dgp;
    private String dgq = null;
    private String dgr = null;
    private long qs = -1;
    private boolean dgs = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dgu = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dgv = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dgw = new g(this, 202003);
    private final CustomMessageListener dgx = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener qQ = new i(this, 2000994);

    static {
        dgl.put("2g", 60L);
        dgl.put("3g", 40L);
        dgl.put("4g", 40L);
        dgl.put("wifi", 10L);
        dgm.put("2g", 10);
        dgm.put("3g", 10);
        dgm.put("4g", 10);
        dgm.put("wifi", 10);
        dgn.put("2g", 300L);
        dgn.put("3g", 60L);
        dgn.put("4g", 60L);
        dgn.put("wifi", 5L);
        dgt = null;
    }

    public String aut() {
        return this.dgr;
    }

    public String auu() {
        return this.dgq;
    }

    public void auv() {
        this.dgq = null;
        this.dgr = null;
    }

    public static synchronized c auw() {
        c cVar;
        synchronized (c.class) {
            if (dgt == null) {
                dgt = new c();
            }
            cVar = dgt;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), auK());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), auI());
    }

    public c() {
        this.dgo = null;
        this.dgp = null;
        aux();
        this.dgp = new ArrayList();
        this.dgo = new ArrayList();
    }

    private void aux() {
        MessageManager.getInstance().registerListener(this.qQ);
        MessageManager.getInstance().registerListener(this.dgu);
        MessageManager.getInstance().registerListener(this.dgv);
        MessageManager.getInstance().registerListener(this.dgw);
        MessageManager.getInstance().registerListener(this.dgx);
    }

    public void auy() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void lK(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (auG() && System.currentTimeMillis() - this.qs > auI()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String auz() {
        return String.valueOf(com.baidu.adp.lib.util.i.gs());
    }

    public String auA() {
        switch (com.baidu.adp.lib.util.i.gs()) {
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

    public int auB() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auC() {
        if (!this.dgs) {
            if (this.dgo != null && this.dgo.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dgo.size()) {
                        break;
                    }
                    b bVar = this.dgo.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.dgj = bVar.dgj;
                        aVar.dgk = bVar.dgk;
                        aVar.dgi = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dgo.size(); i3++) {
                            b bVar2 = this.dgo.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.dgj != null && aVar.dgj != null && bVar2.dgj.equals(aVar.dgj) && bVar2.dgk == aVar.dgk) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dgi++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dgp.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dgo.clear();
            if (this.dgp.size() > auJ() && auF() && com.baidu.adp.lib.util.i.gm()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dgp.size() > 100 && !auG() && !auF()) {
                this.dgp.clear();
            }
        }
    }

    public void auD() {
        if (this.dgp.size() > 0) {
            this.dgs = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dgp) {
                builder.et = aVar.emitTime;
                builder.net = aVar.dgj;
                builder.pushcnt = Integer.valueOf(aVar.dgi);
                builder.process_type = Integer.valueOf(aVar.dgk);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auE() {
        String str;
        com.baidu.tbadk.data.f auH = auH();
        return (auH == null || (str = auH.asJ) == null || !str.equals("1")) ? false : true;
    }

    private boolean auF() {
        String str;
        com.baidu.tbadk.data.f auH = auH();
        return auH == null || (str = auH.asH.get(auA())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auG() {
        String str;
        com.baidu.tbadk.data.f auH = auH();
        return auH == null || (str = auH.asG.get(auA())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f auH() {
        return com.baidu.tbadk.data.f.BX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long auI() {
        String str;
        com.baidu.tbadk.data.f auH = auH();
        if (auH != null && (str = auH.asG.get(auA())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dgl.get(auA()).longValue() * 1000;
    }

    private int auJ() {
        String str;
        int g;
        com.baidu.tbadk.data.f auH = auH();
        return (auH == null || (str = auH.asH.get(auA())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dgm.get(auA()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long auK() {
        String str;
        int g;
        com.baidu.tbadk.data.f auH = auH();
        return (auH == null || (str = auH.asI.get(auA())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dgn.get(auA()).longValue() * 1000 : g * 1000;
    }
}
