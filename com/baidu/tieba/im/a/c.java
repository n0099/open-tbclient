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
    private static final HashMap<String, Long> bDm = new HashMap<>();
    private static final HashMap<String, Integer> bDn = new HashMap<>();
    private static final HashMap<String, Long> bDo = new HashMap<>();
    private static c bDu;
    private List<b> bDp;
    private List<a> bDq;
    private String bDr = null;
    private String bDs = null;
    private long wN = -1;
    private boolean bDt = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bDv = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bDw = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bDx = new g(this, 202003);
    private final CustomMessageListener bDy = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xl = new i(this, 2000994);

    static {
        bDm.put("2g", 60L);
        bDm.put("3g", 40L);
        bDm.put("4g", 40L);
        bDm.put("wifi", 10L);
        bDn.put("2g", 10);
        bDn.put("3g", 10);
        bDn.put("4g", 10);
        bDn.put("wifi", 10);
        bDo.put("2g", 300L);
        bDo.put("3g", 60L);
        bDo.put("4g", 60L);
        bDo.put("wifi", 5L);
        bDu = null;
    }

    public String VD() {
        return this.bDs;
    }

    public String VE() {
        return this.bDr;
    }

    public void VF() {
        this.bDr = null;
        this.bDs = null;
    }

    public static synchronized c VG() {
        c cVar;
        synchronized (c.class) {
            if (bDu == null) {
                bDu = new c();
            }
            cVar = bDu;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), VU());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), VS());
    }

    public c() {
        this.bDp = null;
        this.bDq = null;
        VH();
        this.bDq = new ArrayList();
        this.bDp = new ArrayList();
    }

    private void VH() {
        MessageManager.getInstance().registerListener(this.xl);
        MessageManager.getInstance().registerListener(this.bDv);
        MessageManager.getInstance().registerListener(this.bDw);
        MessageManager.getInstance().registerListener(this.bDx);
        MessageManager.getInstance().registerListener(this.bDy);
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
        if (!this.bDt) {
            if (this.bDp != null && this.bDp.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bDp.size()) {
                        break;
                    }
                    b bVar = this.bDp.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bDk = bVar.bDk;
                        aVar.bDl = bVar.bDl;
                        aVar.bDj = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bDp.size(); i3++) {
                            b bVar2 = this.bDp.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bDk != null && aVar.bDk != null && bVar2.bDk.equals(aVar.bDk) && bVar2.bDl == aVar.bDl) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bDj++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bDq.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bDp.clear();
            if (this.bDq.size() > VT() && VP() && com.baidu.adp.lib.util.i.iM()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bDq.size() > 100 && !VQ() && !VP()) {
                this.bDq.clear();
            }
        }
    }

    public void VN() {
        if (this.bDq.size() > 0) {
            this.bDt = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bDq) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bDk;
                builder.pushcnt = Integer.valueOf(aVar.bDj);
                builder.process_type = Integer.valueOf(aVar.bDl);
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
        return (VR == null || (str = VR.anz) == null || !str.equals("1")) ? false : true;
    }

    private boolean VP() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        return VR == null || (str = VR.anx.get(VK())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VQ() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        return VR == null || (str = VR.anw.get(VK())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c VR() {
        return com.baidu.tbadk.data.c.zV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long VS() {
        String str;
        com.baidu.tbadk.data.c VR = VR();
        if (VR != null && (str = VR.anw.get(VK())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bDm.get(VK()).longValue() * 1000;
    }

    private int VT() {
        String str;
        int g;
        com.baidu.tbadk.data.c VR = VR();
        return (VR == null || (str = VR.anx.get(VK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDn.get(VK()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long VU() {
        String str;
        int g;
        com.baidu.tbadk.data.c VR = VR();
        return (VR == null || (str = VR.any.get(VK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDo.get(VK()).longValue() * 1000 : g * 1000;
    }
}
