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
    private static final HashMap<String, Long> bDb = new HashMap<>();
    private static final HashMap<String, Integer> bDc = new HashMap<>();
    private static final HashMap<String, Long> bDd = new HashMap<>();
    private static c bDj;
    private List<b> bDe;
    private List<a> bDf;
    private String bDg = null;
    private String bDh = null;
    private long wN = -1;
    private boolean bDi = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bDk = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bDl = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bDm = new g(this, 202003);
    private final CustomMessageListener bDn = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xl = new i(this, 2000994);

    static {
        bDb.put("2g", 60L);
        bDb.put("3g", 40L);
        bDb.put("4g", 40L);
        bDb.put("wifi", 10L);
        bDc.put("2g", 10);
        bDc.put("3g", 10);
        bDc.put("4g", 10);
        bDc.put("wifi", 10);
        bDd.put("2g", 300L);
        bDd.put("3g", 60L);
        bDd.put("4g", 60L);
        bDd.put("wifi", 5L);
        bDj = null;
    }

    public String VD() {
        return this.bDh;
    }

    public String VE() {
        return this.bDg;
    }

    public void VF() {
        this.bDg = null;
        this.bDh = null;
    }

    public static synchronized c VG() {
        c cVar;
        synchronized (c.class) {
            if (bDj == null) {
                bDj = new c();
            }
            cVar = bDj;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), VU());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), VS());
    }

    public c() {
        this.bDe = null;
        this.bDf = null;
        VH();
        this.bDf = new ArrayList();
        this.bDe = new ArrayList();
    }

    private void VH() {
        MessageManager.getInstance().registerListener(this.xl);
        MessageManager.getInstance().registerListener(this.bDk);
        MessageManager.getInstance().registerListener(this.bDl);
        MessageManager.getInstance().registerListener(this.bDm);
        MessageManager.getInstance().registerListener(this.bDn);
    }

    public void VI() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void id(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (VQ() && System.currentTimeMillis() - this.wN > VS()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String VJ() {
        return String.valueOf(com.baidu.adp.lib.util.i.iS());
    }

    public String VK() {
        switch (com.baidu.adp.lib.util.i.iS()) {
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

    public int VL() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VM() {
        if (!this.bDi) {
            if (this.bDe != null && this.bDe.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bDe.size()) {
                        break;
                    }
                    b bVar = this.bDe.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bCZ = bVar.bCZ;
                        aVar.bDa = bVar.bDa;
                        aVar.bCY = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bDe.size(); i3++) {
                            b bVar2 = this.bDe.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bCZ != null && aVar.bCZ != null && bVar2.bCZ.equals(aVar.bCZ) && bVar2.bDa == aVar.bDa) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bCY++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bDf.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bDe.clear();
            if (this.bDf.size() > VT() && VP() && com.baidu.adp.lib.util.i.iM()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bDf.size() > 100 && !VQ() && !VP()) {
                this.bDf.clear();
            }
        }
    }

    public void VN() {
        if (this.bDf.size() > 0) {
            this.bDi = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bDf) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bCZ;
                builder.pushcnt = Integer.valueOf(aVar.bCY);
                builder.process_type = Integer.valueOf(aVar.bDa);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VO() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        return (VR == null || (str = VR.any) == null || !str.equals("1")) ? false : true;
    }

    private boolean VP() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        return VR == null || (str = VR.anw.get(VK())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VQ() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        return VR == null || (str = VR.anv.get(VK())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c VR() {
        return com.baidu.tbadk.data.c.zV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long VS() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        if (VR != null && (str = VR.anv.get(VK())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bDb.get(VK()).longValue() * 1000;
    }

    private int VT() {
        String str;
        int g;
        com.baidu.tbadk.data.c VR = VR();
        return (VR == null || (str = VR.anw.get(VK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDc.get(VK()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long VU() {
        String str;
        int g;
        com.baidu.tbadk.data.c VR = VR();
        return (VR == null || (str = VR.anx.get(VK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDd.get(VK()).longValue() * 1000 : g * 1000;
    }
}
