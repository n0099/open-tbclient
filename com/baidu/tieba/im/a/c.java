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
    private static final HashMap<String, Long> cmr = new HashMap<>();
    private static final HashMap<String, Integer> cms = new HashMap<>();
    private static final HashMap<String, Long> cmt = new HashMap<>();
    private static c cmz;
    private List<b> cmu;
    private List<a> cmv;
    private String cmw = null;
    private String cmx = null;
    private long nv = -1;
    private boolean cmy = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cmA = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cmB = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cmC = new g(this, 202003);
    private final CustomMessageListener cmD = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener nT = new i(this, 2000994);

    static {
        cmr.put("2g", 60L);
        cmr.put("3g", 40L);
        cmr.put("4g", 40L);
        cmr.put("wifi", 10L);
        cms.put("2g", 10);
        cms.put("3g", 10);
        cms.put("4g", 10);
        cms.put("wifi", 10);
        cmt.put("2g", 300L);
        cmt.put("3g", 60L);
        cmt.put("4g", 60L);
        cmt.put("wifi", 5L);
        cmz = null;
    }

    public String agG() {
        return this.cmx;
    }

    public String agH() {
        return this.cmw;
    }

    public void agI() {
        this.cmw = null;
        this.cmx = null;
    }

    public static synchronized c agJ() {
        c cVar;
        synchronized (c.class) {
            if (cmz == null) {
                cmz = new c();
            }
            cVar = cmz;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), agX());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), agV());
    }

    public c() {
        this.cmu = null;
        this.cmv = null;
        agK();
        this.cmv = new ArrayList();
        this.cmu = new ArrayList();
    }

    private void agK() {
        MessageManager.getInstance().registerListener(this.nT);
        MessageManager.getInstance().registerListener(this.cmA);
        MessageManager.getInstance().registerListener(this.cmB);
        MessageManager.getInstance().registerListener(this.cmC);
        MessageManager.getInstance().registerListener(this.cmD);
    }

    public void agL() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void jB(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (agT() && System.currentTimeMillis() - this.nv > agV()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String agM() {
        return String.valueOf(com.baidu.adp.lib.util.i.fw());
    }

    public String agN() {
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

    public int agO() {
        return TbadkCoreApplication.m11getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agP() {
        if (!this.cmy) {
            if (this.cmu != null && this.cmu.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cmu.size()) {
                        break;
                    }
                    b bVar = this.cmu.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.cmp = bVar.cmp;
                        aVar.cmq = bVar.cmq;
                        aVar.cmo = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cmu.size(); i3++) {
                            b bVar2 = this.cmu.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.cmp != null && aVar.cmp != null && bVar2.cmp.equals(aVar.cmp) && bVar2.cmq == aVar.cmq) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cmo++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cmv.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cmu.clear();
            if (this.cmv.size() > agW() && agS() && com.baidu.adp.lib.util.i.fq()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cmv.size() > 100 && !agT() && !agS()) {
                this.cmv.clear();
            }
        }
    }

    public void agQ() {
        if (this.cmv.size() > 0) {
            this.cmy = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cmv) {
                builder.et = aVar.emitTime;
                builder.net = aVar.cmp;
                builder.pushcnt = Integer.valueOf(aVar.cmo);
                builder.process_type = Integer.valueOf(aVar.cmq);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agR() {
        String str;
        com.baidu.tbadk.data.e agU = agU();
        return (agU == null || (str = agU.anY) == null || !str.equals("1")) ? false : true;
    }

    private boolean agS() {
        String str;
        com.baidu.tbadk.data.e agU = agU();
        return agU == null || (str = agU.anW.get(agN())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agT() {
        String str;
        com.baidu.tbadk.data.e agU = agU();
        return agU == null || (str = agU.anV.get(agN())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.e agU() {
        return com.baidu.tbadk.data.e.Az();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long agV() {
        String str;
        com.baidu.tbadk.data.e agU = agU();
        if (agU != null && (str = agU.anV.get(agN())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cmr.get(agN()).longValue() * 1000;
    }

    private int agW() {
        String str;
        int g;
        com.baidu.tbadk.data.e agU = agU();
        return (agU == null || (str = agU.anW.get(agN())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cms.get(agN()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long agX() {
        String str;
        int g;
        com.baidu.tbadk.data.e agU = agU();
        return (agU == null || (str = agU.anX.get(agN())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cmt.get(agN()).longValue() * 1000 : g * 1000;
    }
}
