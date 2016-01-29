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
    private static final HashMap<String, Long> caP = new HashMap<>();
    private static final HashMap<String, Integer> caQ = new HashMap<>();
    private static final HashMap<String, Long> caR = new HashMap<>();
    private static c caX;
    private List<b> caS;
    private List<a> caT;
    private String caU = null;
    private String caV = null;
    private long xe = -1;
    private boolean caW = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e caY = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e caZ = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cba = new g(this, 202003);
    private final CustomMessageListener cbb = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xC = new i(this, 2000994);

    static {
        caP.put("2g", 60L);
        caP.put("3g", 40L);
        caP.put("4g", 40L);
        caP.put("wifi", 10L);
        caQ.put("2g", 10);
        caQ.put("3g", 10);
        caQ.put("4g", 10);
        caQ.put("wifi", 10);
        caR.put("2g", 300L);
        caR.put("3g", 60L);
        caR.put("4g", 60L);
        caR.put("wifi", 5L);
        caX = null;
    }

    public String ade() {
        return this.caV;
    }

    public String adf() {
        return this.caU;
    }

    public void adg() {
        this.caU = null;
        this.caV = null;
    }

    public static synchronized c adh() {
        c cVar;
        synchronized (c.class) {
            if (caX == null) {
                caX = new c();
            }
            cVar = caX;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), adv());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), adt());
    }

    public c() {
        this.caS = null;
        this.caT = null;
        adi();
        this.caT = new ArrayList();
        this.caS = new ArrayList();
    }

    private void adi() {
        MessageManager.getInstance().registerListener(this.xC);
        MessageManager.getInstance().registerListener(this.caY);
        MessageManager.getInstance().registerListener(this.caZ);
        MessageManager.getInstance().registerListener(this.cba);
        MessageManager.getInstance().registerListener(this.cbb);
    }

    public void adj() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void iP(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (adr() && System.currentTimeMillis() - this.xe > adt()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String adk() {
        return String.valueOf(com.baidu.adp.lib.util.i.jf());
    }

    public String adl() {
        switch (com.baidu.adp.lib.util.i.jf()) {
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

    public int adm() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adn() {
        if (!this.caW) {
            if (this.caS != null && this.caS.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.caS.size()) {
                        break;
                    }
                    b bVar = this.caS.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.caN = bVar.caN;
                        aVar.caO = bVar.caO;
                        aVar.caM = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.caS.size(); i3++) {
                            b bVar2 = this.caS.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.caN != null && aVar.caN != null && bVar2.caN.equals(aVar.caN) && bVar2.caO == aVar.caO) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.caM++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.caT.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.caS.clear();
            if (this.caT.size() > adu() && adq() && com.baidu.adp.lib.util.i.iZ()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.caT.size() > 100 && !adr() && !adq()) {
                this.caT.clear();
            }
        }
    }

    public void ado() {
        if (this.caT.size() > 0) {
            this.caW = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.caT) {
                builder.et = aVar.emitTime;
                builder.net = aVar.caN;
                builder.pushcnt = Integer.valueOf(aVar.caM);
                builder.process_type = Integer.valueOf(aVar.caO);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adp() {
        String str;
        com.baidu.tbadk.data.c ads = ads();
        return (ads == null || (str = ads.arP) == null || !str.equals("1")) ? false : true;
    }

    private boolean adq() {
        String str;
        com.baidu.tbadk.data.c ads = ads();
        return ads == null || (str = ads.arN.get(adl())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adr() {
        String str;
        com.baidu.tbadk.data.c ads = ads();
        return ads == null || (str = ads.arM.get(adl())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c ads() {
        return com.baidu.tbadk.data.c.BZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long adt() {
        String str;
        com.baidu.tbadk.data.c ads = ads();
        if (ads != null && (str = ads.arM.get(adl())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return caP.get(adl()).longValue() * 1000;
    }

    private int adu() {
        String str;
        int g;
        com.baidu.tbadk.data.c ads = ads();
        return (ads == null || (str = ads.arN.get(adl())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? caQ.get(adl()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long adv() {
        String str;
        int g;
        com.baidu.tbadk.data.c ads = ads();
        return (ads == null || (str = ads.arO.get(adl())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? caR.get(adl()).longValue() * 1000 : g * 1000;
    }
}
