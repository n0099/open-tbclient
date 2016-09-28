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
    private static final HashMap<String, Long> dhI = new HashMap<>();
    private static final HashMap<String, Integer> dhJ = new HashMap<>();
    private static final HashMap<String, Long> dhK = new HashMap<>();
    private static c dhQ;
    private List<b> dhL;
    private List<a> dhM;
    private String dhN = null;
    private String dhO = null;
    private long qs = -1;
    private boolean dhP = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dhR = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dhS = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dhT = new g(this, 202003);
    private final CustomMessageListener dhU = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener qQ = new i(this, 2000994);

    static {
        dhI.put("2g", 60L);
        dhI.put("3g", 40L);
        dhI.put("4g", 40L);
        dhI.put("wifi", 10L);
        dhJ.put("2g", 10);
        dhJ.put("3g", 10);
        dhJ.put("4g", 10);
        dhJ.put("wifi", 10);
        dhK.put("2g", 300L);
        dhK.put("3g", 60L);
        dhK.put("4g", 60L);
        dhK.put("wifi", 5L);
        dhQ = null;
    }

    public String auS() {
        return this.dhO;
    }

    public String auT() {
        return this.dhN;
    }

    public void auU() {
        this.dhN = null;
        this.dhO = null;
    }

    public static synchronized c auV() {
        c cVar;
        synchronized (c.class) {
            if (dhQ == null) {
                dhQ = new c();
            }
            cVar = dhQ;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), avj());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), avh());
    }

    public c() {
        this.dhL = null;
        this.dhM = null;
        auW();
        this.dhM = new ArrayList();
        this.dhL = new ArrayList();
    }

    private void auW() {
        MessageManager.getInstance().registerListener(this.qQ);
        MessageManager.getInstance().registerListener(this.dhR);
        MessageManager.getInstance().registerListener(this.dhS);
        MessageManager.getInstance().registerListener(this.dhT);
        MessageManager.getInstance().registerListener(this.dhU);
    }

    public void auX() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void lX(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (avf() && System.currentTimeMillis() - this.qs > avh()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String auY() {
        return String.valueOf(com.baidu.adp.lib.util.i.gs());
    }

    public String auZ() {
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

    public int ava() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avb() {
        if (!this.dhP) {
            if (this.dhL != null && this.dhL.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dhL.size()) {
                        break;
                    }
                    b bVar = this.dhL.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.dhG = bVar.dhG;
                        aVar.dhH = bVar.dhH;
                        aVar.dhF = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dhL.size(); i3++) {
                            b bVar2 = this.dhL.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.dhG != null && aVar.dhG != null && bVar2.dhG.equals(aVar.dhG) && bVar2.dhH == aVar.dhH) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dhF++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dhM.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dhL.clear();
            if (this.dhM.size() > avi() && ave() && com.baidu.adp.lib.util.i.gm()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dhM.size() > 100 && !avf() && !ave()) {
                this.dhM.clear();
            }
        }
    }

    public void avc() {
        if (this.dhM.size() > 0) {
            this.dhP = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dhM) {
                builder.et = aVar.emitTime;
                builder.net = aVar.dhG;
                builder.pushcnt = Integer.valueOf(aVar.dhF);
                builder.process_type = Integer.valueOf(aVar.dhH);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avd() {
        String str;
        com.baidu.tbadk.data.f avg = avg();
        return (avg == null || (str = avg.asu) == null || !str.equals("1")) ? false : true;
    }

    private boolean ave() {
        String str;
        com.baidu.tbadk.data.f avg = avg();
        return avg == null || (str = avg.ass.get(auZ())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avf() {
        String str;
        com.baidu.tbadk.data.f avg = avg();
        return avg == null || (str = avg.asr.get(auZ())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f avg() {
        return com.baidu.tbadk.data.f.Ca();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long avh() {
        String str;
        com.baidu.tbadk.data.f avg = avg();
        if (avg != null && (str = avg.asr.get(auZ())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dhI.get(auZ()).longValue() * 1000;
    }

    private int avi() {
        String str;
        int g;
        com.baidu.tbadk.data.f avg = avg();
        return (avg == null || (str = avg.ass.get(auZ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dhJ.get(auZ()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long avj() {
        String str;
        int g;
        com.baidu.tbadk.data.f avg = avg();
        return (avg == null || (str = avg.ast.get(auZ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dhK.get(auZ()).longValue() * 1000 : g * 1000;
    }
}
