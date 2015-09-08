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
    private static c bAh;
    private List<b> bAc;
    private List<a> bAd;
    private static final HashMap<String, Long> bzZ = new HashMap<>();
    private static final HashMap<String, Integer> bAa = new HashMap<>();
    private static final HashMap<String, Long> bAb = new HashMap<>();
    private String bAe = null;
    private String bAf = null;
    private long wM = -1;
    private boolean bAg = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bAi = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bAj = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bAk = new g(this, 202003);
    private final CustomMessageListener bAl = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xk = new i(this, 2000994);

    static {
        bzZ.put("2g", 60L);
        bzZ.put("3g", 40L);
        bzZ.put("4g", 40L);
        bzZ.put("wifi", 10L);
        bAa.put("2g", 10);
        bAa.put("3g", 10);
        bAa.put("4g", 10);
        bAa.put("wifi", 10);
        bAb.put("2g", 300L);
        bAb.put("3g", 60L);
        bAb.put("4g", 60L);
        bAb.put("wifi", 5L);
        bAh = null;
    }

    public String UU() {
        return this.bAf;
    }

    public String UV() {
        return this.bAe;
    }

    public void UW() {
        this.bAe = null;
        this.bAf = null;
    }

    public static synchronized c UX() {
        c cVar;
        synchronized (c.class) {
            if (bAh == null) {
                bAh = new c();
            }
            cVar = bAh;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Vl());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Vj());
    }

    public c() {
        this.bAc = null;
        this.bAd = null;
        UY();
        this.bAd = new ArrayList();
        this.bAc = new ArrayList();
    }

    private void UY() {
        MessageManager.getInstance().registerListener(this.xk);
        MessageManager.getInstance().registerListener(this.bAi);
        MessageManager.getInstance().registerListener(this.bAj);
        MessageManager.getInstance().registerListener(this.bAk);
        MessageManager.getInstance().registerListener(this.bAl);
    }

    public void UZ() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void hZ(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Vh() && System.currentTimeMillis() - this.wM > Vj()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Va() {
        return String.valueOf(com.baidu.adp.lib.util.i.iR());
    }

    public String Vb() {
        switch (com.baidu.adp.lib.util.i.iR()) {
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

    public int Vc() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (!this.bAg) {
            if (this.bAc != null && this.bAc.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bAc.size()) {
                        break;
                    }
                    b bVar = this.bAc.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bzX = bVar.bzX;
                        aVar.bzY = bVar.bzY;
                        aVar.bzW = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bAc.size(); i3++) {
                            b bVar2 = this.bAc.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bzX != null && aVar.bzX != null && bVar2.bzX.equals(aVar.bzX) && bVar2.bzY == aVar.bzY) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bzW++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bAd.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bAc.clear();
            if (this.bAd.size() > Vk() && Vg() && com.baidu.adp.lib.util.i.iL()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bAd.size() > 100 && !Vh() && !Vg()) {
                this.bAd.clear();
            }
        }
    }

    public void Ve() {
        if (this.bAd.size() > 0) {
            this.bAg = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bAd) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bzX;
                builder.pushcnt = Integer.valueOf(aVar.bzW);
                builder.process_type = Integer.valueOf(aVar.bzY);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vf() {
        String str;
        com.baidu.tbadk.data.c Vi = Vi();
        return (Vi == null || (str = Vi.aoW) == null || !str.equals("1")) ? false : true;
    }

    private boolean Vg() {
        String str;
        com.baidu.tbadk.data.c Vi = Vi();
        return Vi == null || (str = Vi.aoU.get(Vb())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vh() {
        String str;
        com.baidu.tbadk.data.c Vi = Vi();
        return Vi == null || (str = Vi.aoT.get(Vb())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Vi() {
        return com.baidu.tbadk.data.c.Ag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Vj() {
        String str;
        com.baidu.tbadk.data.c Vi = Vi();
        if (Vi != null && (str = Vi.aoT.get(Vb())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bzZ.get(Vb()).longValue() * 1000;
    }

    private int Vk() {
        String str;
        int g;
        com.baidu.tbadk.data.c Vi = Vi();
        return (Vi == null || (str = Vi.aoU.get(Vb())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bAa.get(Vb()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Vl() {
        String str;
        int g;
        com.baidu.tbadk.data.c Vi = Vi();
        return (Vi == null || (str = Vi.aoV.get(Vb())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bAb.get(Vb()).longValue() * 1000 : g * 1000;
    }
}
