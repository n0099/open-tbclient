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
    private static c bWD;
    private static final HashMap<String, Long> bWv = new HashMap<>();
    private static final HashMap<String, Integer> bWw = new HashMap<>();
    private static final HashMap<String, Long> bWx = new HashMap<>();
    private List<b> bWy;
    private List<a> bWz;
    private String bWA = null;
    private String bWB = null;
    private long wV = -1;
    private boolean bWC = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bWE = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bWF = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bWG = new g(this, 202003);
    private final CustomMessageListener bWH = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xt = new i(this, 2000994);

    static {
        bWv.put("2g", 60L);
        bWv.put("3g", 40L);
        bWv.put("4g", 40L);
        bWv.put("wifi", 10L);
        bWw.put("2g", 10);
        bWw.put("3g", 10);
        bWw.put("4g", 10);
        bWw.put("wifi", 10);
        bWx.put("2g", 300L);
        bWx.put("3g", 60L);
        bWx.put("4g", 60L);
        bWx.put("wifi", 5L);
        bWD = null;
    }

    public String aaf() {
        return this.bWB;
    }

    public String aag() {
        return this.bWA;
    }

    public void aah() {
        this.bWA = null;
        this.bWB = null;
    }

    public static synchronized c aai() {
        c cVar;
        synchronized (c.class) {
            if (bWD == null) {
                bWD = new c();
            }
            cVar = bWD;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), aaw());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), aau());
    }

    public c() {
        this.bWy = null;
        this.bWz = null;
        aaj();
        this.bWz = new ArrayList();
        this.bWy = new ArrayList();
    }

    private void aaj() {
        MessageManager.getInstance().registerListener(this.xt);
        MessageManager.getInstance().registerListener(this.bWE);
        MessageManager.getInstance().registerListener(this.bWF);
        MessageManager.getInstance().registerListener(this.bWG);
        MessageManager.getInstance().registerListener(this.bWH);
    }

    public void aak() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void iN(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (aas() && System.currentTimeMillis() - this.wV > aau()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String aal() {
        return String.valueOf(com.baidu.adp.lib.util.i.iW());
    }

    public String aam() {
        switch (com.baidu.adp.lib.util.i.iW()) {
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

    public int aan() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        if (!this.bWC) {
            if (this.bWy != null && this.bWy.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bWy.size()) {
                        break;
                    }
                    b bVar = this.bWy.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bWt = bVar.bWt;
                        aVar.bWu = bVar.bWu;
                        aVar.bWs = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bWy.size(); i3++) {
                            b bVar2 = this.bWy.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bWt != null && aVar.bWt != null && bVar2.bWt.equals(aVar.bWt) && bVar2.bWu == aVar.bWu) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bWs++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bWz.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bWy.clear();
            if (this.bWz.size() > aav() && aar() && com.baidu.adp.lib.util.i.iQ()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bWz.size() > 100 && !aas() && !aar()) {
                this.bWz.clear();
            }
        }
    }

    public void aap() {
        if (this.bWz.size() > 0) {
            this.bWC = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bWz) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bWt;
                builder.pushcnt = Integer.valueOf(aVar.bWs);
                builder.process_type = Integer.valueOf(aVar.bWu);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaq() {
        String str;
        com.baidu.tbadk.data.c aat = aat();
        return (aat == null || (str = aat.aqW) == null || !str.equals("1")) ? false : true;
    }

    private boolean aar() {
        String str;
        com.baidu.tbadk.data.c aat = aat();
        return aat == null || (str = aat.aqU.get(aam())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aas() {
        String str;
        com.baidu.tbadk.data.c aat = aat();
        return aat == null || (str = aat.aqT.get(aam())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c aat() {
        return com.baidu.tbadk.data.c.AJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aau() {
        String str;
        com.baidu.tbadk.data.c aat = aat();
        if (aat != null && (str = aat.aqT.get(aam())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bWv.get(aam()).longValue() * 1000;
    }

    private int aav() {
        String str;
        int g;
        com.baidu.tbadk.data.c aat = aat();
        return (aat == null || (str = aat.aqU.get(aam())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? bWw.get(aam()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aaw() {
        String str;
        int g;
        com.baidu.tbadk.data.c aat = aat();
        return (aat == null || (str = aat.aqV.get(aam())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? bWx.get(aam()).longValue() * 1000 : g * 1000;
    }
}
