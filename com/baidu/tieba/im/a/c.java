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
    private static c bzA;
    private static final HashMap<String, Long> bzs = new HashMap<>();
    private static final HashMap<String, Integer> bzt = new HashMap<>();
    private static final HashMap<String, Long> bzu = new HashMap<>();
    private List<b> bzv;
    private List<a> bzw;
    private String bzx = null;
    private String bzy = null;
    private long wO = -1;
    private boolean bzz = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bzB = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bzC = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bzD = new g(this, 202003);
    private final CustomMessageListener bzE = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xm = new i(this, 2000994);

    static {
        bzs.put("2g", 60L);
        bzs.put("3g", 40L);
        bzs.put("4g", 40L);
        bzs.put("wifi", 10L);
        bzt.put("2g", 10);
        bzt.put("3g", 10);
        bzt.put("4g", 10);
        bzt.put("wifi", 10);
        bzu.put("2g", 300L);
        bzu.put("3g", 60L);
        bzu.put("4g", 60L);
        bzu.put("wifi", 5L);
        bzA = null;
    }

    public String US() {
        return this.bzy;
    }

    public String UT() {
        return this.bzx;
    }

    public void UU() {
        this.bzx = null;
        this.bzy = null;
    }

    public static synchronized c UV() {
        c cVar;
        synchronized (c.class) {
            if (bzA == null) {
                bzA = new c();
            }
            cVar = bzA;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Vj());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Vh());
    }

    public c() {
        this.bzv = null;
        this.bzw = null;
        UW();
        this.bzw = new ArrayList();
        this.bzv = new ArrayList();
    }

    private void UW() {
        MessageManager.getInstance().registerListener(this.xm);
        MessageManager.getInstance().registerListener(this.bzB);
        MessageManager.getInstance().registerListener(this.bzC);
        MessageManager.getInstance().registerListener(this.bzD);
        MessageManager.getInstance().registerListener(this.bzE);
    }

    public void UX() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void hQ(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Vf() && System.currentTimeMillis() - this.wO > Vh()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String UY() {
        return String.valueOf(com.baidu.adp.lib.util.i.iU());
    }

    public String UZ() {
        switch (com.baidu.adp.lib.util.i.iU()) {
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

    public int Va() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vb() {
        if (!this.bzz) {
            if (this.bzv != null && this.bzv.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bzv.size()) {
                        break;
                    }
                    b bVar = this.bzv.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bzq = bVar.bzq;
                        aVar.bzr = bVar.bzr;
                        aVar.bzp = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bzv.size(); i3++) {
                            b bVar2 = this.bzv.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bzq != null && aVar.bzq != null && bVar2.bzq.equals(aVar.bzq) && bVar2.bzr == aVar.bzr) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bzp++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bzw.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bzv.clear();
            if (this.bzw.size() > Vi() && Ve() && com.baidu.adp.lib.util.i.iO()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bzw.size() > 100 && !Vf() && !Ve()) {
                this.bzw.clear();
            }
        }
    }

    public void Vc() {
        if (this.bzw.size() > 0) {
            this.bzz = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bzw) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bzq;
                builder.pushcnt = Integer.valueOf(aVar.bzp);
                builder.process_type = Integer.valueOf(aVar.bzr);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vd() {
        String str;
        com.baidu.tbadk.data.c Vg = Vg();
        return (Vg == null || (str = Vg.ank) == null || !str.equals("1")) ? false : true;
    }

    private boolean Ve() {
        String str;
        com.baidu.tbadk.data.c Vg = Vg();
        return Vg == null || (str = Vg.ani.get(UZ())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vf() {
        String str;
        com.baidu.tbadk.data.c Vg = Vg();
        return Vg == null || (str = Vg.anh.get(UZ())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Vg() {
        return com.baidu.tbadk.data.c.zT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Vh() {
        String str;
        com.baidu.tbadk.data.c Vg = Vg();
        if (Vg != null && (str = Vg.anh.get(UZ())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bzs.get(UZ()).longValue() * 1000;
    }

    private int Vi() {
        String str;
        int g;
        com.baidu.tbadk.data.c Vg = Vg();
        return (Vg == null || (str = Vg.ani.get(UZ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bzt.get(UZ()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Vj() {
        String str;
        int g;
        com.baidu.tbadk.data.c Vg = Vg();
        return (Vg == null || (str = Vg.anj.get(UZ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? bzu.get(UZ()).longValue() * 1000 : g * 1000;
    }
}
