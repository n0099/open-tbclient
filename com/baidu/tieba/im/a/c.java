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
    private static final HashMap<String, Long> cRG = new HashMap<>();
    private static final HashMap<String, Integer> cRH = new HashMap<>();
    private static final HashMap<String, Long> cRI = new HashMap<>();
    private static c cRO;
    private List<b> cRJ;
    private List<a> cRK;
    private String cRL = null;
    private String cRM = null;
    private long nv = -1;
    private boolean cRN = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cRP = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cRQ = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cRR = new g(this, 202003);
    private final CustomMessageListener cRS = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener nT = new i(this, 2000994);

    static {
        cRG.put("2g", 60L);
        cRG.put("3g", 40L);
        cRG.put("4g", 40L);
        cRG.put("wifi", 10L);
        cRH.put("2g", 10);
        cRH.put("3g", 10);
        cRH.put("4g", 10);
        cRH.put("wifi", 10);
        cRI.put("2g", 300L);
        cRI.put("3g", 60L);
        cRI.put("4g", 60L);
        cRI.put("wifi", 5L);
        cRO = null;
    }

    public String aoT() {
        return this.cRM;
    }

    public String aoU() {
        return this.cRL;
    }

    public void aoV() {
        this.cRL = null;
        this.cRM = null;
    }

    public static synchronized c aoW() {
        c cVar;
        synchronized (c.class) {
            if (cRO == null) {
                cRO = new c();
            }
            cVar = cRO;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), apk());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), api());
    }

    public c() {
        this.cRJ = null;
        this.cRK = null;
        aoX();
        this.cRK = new ArrayList();
        this.cRJ = new ArrayList();
    }

    private void aoX() {
        MessageManager.getInstance().registerListener(this.nT);
        MessageManager.getInstance().registerListener(this.cRP);
        MessageManager.getInstance().registerListener(this.cRQ);
        MessageManager.getInstance().registerListener(this.cRR);
        MessageManager.getInstance().registerListener(this.cRS);
    }

    public void aoY() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kU(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (apg() && System.currentTimeMillis() - this.nv > api()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String aoZ() {
        return String.valueOf(com.baidu.adp.lib.util.i.fx());
    }

    public String apa() {
        switch (com.baidu.adp.lib.util.i.fx()) {
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

    public int apb() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apc() {
        if (!this.cRN) {
            if (this.cRJ != null && this.cRJ.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cRJ.size()) {
                        break;
                    }
                    b bVar = this.cRJ.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.cRE = bVar.cRE;
                        aVar.cRF = bVar.cRF;
                        aVar.cRD = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cRJ.size(); i3++) {
                            b bVar2 = this.cRJ.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.cRE != null && aVar.cRE != null && bVar2.cRE.equals(aVar.cRE) && bVar2.cRF == aVar.cRF) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cRD++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cRK.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cRJ.clear();
            if (this.cRK.size() > apj() && apf() && com.baidu.adp.lib.util.i.fr()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cRK.size() > 100 && !apg() && !apf()) {
                this.cRK.clear();
            }
        }
    }

    public void apd() {
        if (this.cRK.size() > 0) {
            this.cRN = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cRK) {
                builder.et = aVar.emitTime;
                builder.net = aVar.cRE;
                builder.pushcnt = Integer.valueOf(aVar.cRD);
                builder.process_type = Integer.valueOf(aVar.cRF);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ape() {
        String str;
        com.baidu.tbadk.data.f aph = aph();
        return (aph == null || (str = aph.aoN) == null || !str.equals("1")) ? false : true;
    }

    private boolean apf() {
        String str;
        com.baidu.tbadk.data.f aph = aph();
        return aph == null || (str = aph.aoL.get(apa())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apg() {
        String str;
        com.baidu.tbadk.data.f aph = aph();
        return aph == null || (str = aph.aoK.get(apa())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f aph() {
        return com.baidu.tbadk.data.f.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long api() {
        String str;
        com.baidu.tbadk.data.f aph = aph();
        if (aph != null && (str = aph.aoK.get(apa())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cRG.get(apa()).longValue() * 1000;
    }

    private int apj() {
        String str;
        int g;
        com.baidu.tbadk.data.f aph = aph();
        return (aph == null || (str = aph.aoL.get(apa())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cRH.get(apa()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long apk() {
        String str;
        int g;
        com.baidu.tbadk.data.f aph = aph();
        return (aph == null || (str = aph.aoM.get(apa())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cRI.get(apa()).longValue() * 1000 : g * 1000;
    }
}
