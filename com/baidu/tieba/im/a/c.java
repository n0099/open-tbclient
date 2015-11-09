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
    private static final HashMap<String, Long> bDH = new HashMap<>();
    private static final HashMap<String, Integer> bDI = new HashMap<>();
    private static final HashMap<String, Long> bDJ = new HashMap<>();
    private static c bDP;
    private List<b> bDK;
    private List<a> bDL;
    private String bDM = null;
    private String bDN = null;
    private long wN = -1;
    private boolean bDO = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bDQ = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bDR = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bDS = new g(this, 202003);
    private final CustomMessageListener bDT = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xl = new i(this, 2000994);

    static {
        bDH.put("2g", 60L);
        bDH.put("3g", 40L);
        bDH.put("4g", 40L);
        bDH.put("wifi", 10L);
        bDI.put("2g", 10);
        bDI.put("3g", 10);
        bDI.put("4g", 10);
        bDI.put("wifi", 10);
        bDJ.put("2g", 300L);
        bDJ.put("3g", 60L);
        bDJ.put("4g", 60L);
        bDJ.put("wifi", 5L);
        bDP = null;
    }

    public String VU() {
        return this.bDN;
    }

    public String VV() {
        return this.bDM;
    }

    public void VW() {
        this.bDM = null;
        this.bDN = null;
    }

    public static synchronized c VX() {
        c cVar;
        synchronized (c.class) {
            if (bDP == null) {
                bDP = new c();
            }
            cVar = bDP;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Wl());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Wj());
    }

    public c() {
        this.bDK = null;
        this.bDL = null;
        VY();
        this.bDL = new ArrayList();
        this.bDK = new ArrayList();
    }

    private void VY() {
        MessageManager.getInstance().registerListener(this.xl);
        MessageManager.getInstance().registerListener(this.bDQ);
        MessageManager.getInstance().registerListener(this.bDR);
        MessageManager.getInstance().registerListener(this.bDS);
        MessageManager.getInstance().registerListener(this.bDT);
    }

    public void VZ() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void ig(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Wh() && System.currentTimeMillis() - this.wN > Wj()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Wa() {
        return String.valueOf(com.baidu.adp.lib.util.i.iT());
    }

    public String Wb() {
        switch (com.baidu.adp.lib.util.i.iT()) {
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

    public int Wc() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wd() {
        if (!this.bDO) {
            if (this.bDK != null && this.bDK.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bDK.size()) {
                        break;
                    }
                    b bVar = this.bDK.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bDF = bVar.bDF;
                        aVar.bDG = bVar.bDG;
                        aVar.bDE = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bDK.size(); i3++) {
                            b bVar2 = this.bDK.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bDF != null && aVar.bDF != null && bVar2.bDF.equals(aVar.bDF) && bVar2.bDG == aVar.bDG) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bDE++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bDL.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bDK.clear();
            if (this.bDL.size() > Wk() && Wg() && com.baidu.adp.lib.util.i.iN()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bDL.size() > 100 && !Wh() && !Wg()) {
                this.bDL.clear();
            }
        }
    }

    public void We() {
        if (this.bDL.size() > 0) {
            this.bDO = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bDL) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bDF;
                builder.pushcnt = Integer.valueOf(aVar.bDE);
                builder.process_type = Integer.valueOf(aVar.bDG);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wf() {
        String str;
        com.baidu.tbadk.data.c Wi = Wi();
        return (Wi == null || (str = Wi.anE) == null || !str.equals("1")) ? false : true;
    }

    private boolean Wg() {
        String str;
        com.baidu.tbadk.data.c Wi = Wi();
        return Wi == null || (str = Wi.anC.get(Wb())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wh() {
        String str;
        com.baidu.tbadk.data.c Wi = Wi();
        return Wi == null || (str = Wi.anB.get(Wb())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Wi() {
        return com.baidu.tbadk.data.c.zX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Wj() {
        String str;
        com.baidu.tbadk.data.c Wi = Wi();
        if (Wi != null && (str = Wi.anB.get(Wb())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bDH.get(Wb()).longValue() * 1000;
    }

    private int Wk() {
        String str;
        int g;
        com.baidu.tbadk.data.c Wi = Wi();
        return (Wi == null || (str = Wi.anC.get(Wb())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDI.get(Wb()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Wl() {
        String str;
        int g;
        com.baidu.tbadk.data.c Wi = Wi();
        return (Wi == null || (str = Wi.anD.get(Wb())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bDJ.get(Wb()).longValue() * 1000 : g * 1000;
    }
}
