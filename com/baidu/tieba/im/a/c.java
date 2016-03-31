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
    private static c clB;
    private static final HashMap<String, Long> clt = new HashMap<>();
    private static final HashMap<String, Integer> clu = new HashMap<>();
    private static final HashMap<String, Long> clv = new HashMap<>();
    private List<b> clw;
    private List<a> clx;
    private String cly = null;
    private String clz = null;
    private long xv = -1;
    private boolean clA = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e clC = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e clD = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e clE = new g(this, 202003);
    private final CustomMessageListener clF = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xT = new i(this, 2000994);

    static {
        clt.put("2g", 60L);
        clt.put("3g", 40L);
        clt.put("4g", 40L);
        clt.put("wifi", 10L);
        clu.put("2g", 10);
        clu.put("3g", 10);
        clu.put("4g", 10);
        clu.put("wifi", 10);
        clv.put("2g", 300L);
        clv.put("3g", 60L);
        clv.put("4g", 60L);
        clv.put("wifi", 5L);
        clB = null;
    }

    public String agx() {
        return this.clz;
    }

    public String agy() {
        return this.cly;
    }

    public void agz() {
        this.cly = null;
        this.clz = null;
    }

    public static synchronized c agA() {
        c cVar;
        synchronized (c.class) {
            if (clB == null) {
                clB = new c();
            }
            cVar = clB;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), agO());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), agM());
    }

    public c() {
        this.clw = null;
        this.clx = null;
        agB();
        this.clx = new ArrayList();
        this.clw = new ArrayList();
    }

    private void agB() {
        MessageManager.getInstance().registerListener(this.xT);
        MessageManager.getInstance().registerListener(this.clC);
        MessageManager.getInstance().registerListener(this.clD);
        MessageManager.getInstance().registerListener(this.clE);
        MessageManager.getInstance().registerListener(this.clF);
    }

    public void agC() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void jy(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (agK() && System.currentTimeMillis() - this.xv > agM()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String agD() {
        return String.valueOf(com.baidu.adp.lib.util.i.jl());
    }

    public String agE() {
        switch (com.baidu.adp.lib.util.i.jl()) {
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

    public int agF() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agG() {
        if (!this.clA) {
            if (this.clw != null && this.clw.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.clw.size()) {
                        break;
                    }
                    b bVar = this.clw.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.clq = bVar.clq;
                        aVar.clr = bVar.clr;
                        aVar.clp = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.clw.size(); i3++) {
                            b bVar2 = this.clw.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.clq != null && aVar.clq != null && bVar2.clq.equals(aVar.clq) && bVar2.clr == aVar.clr) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.clp++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.clx.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.clw.clear();
            if (this.clx.size() > agN() && agJ() && com.baidu.adp.lib.util.i.jf()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.clx.size() > 100 && !agK() && !agJ()) {
                this.clx.clear();
            }
        }
    }

    public void agH() {
        if (this.clx.size() > 0) {
            this.clA = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.clx) {
                builder.et = aVar.emitTime;
                builder.net = aVar.clq;
                builder.pushcnt = Integer.valueOf(aVar.clp);
                builder.process_type = Integer.valueOf(aVar.clr);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agI() {
        String str;
        com.baidu.tbadk.data.d agL = agL();
        return (agL == null || (str = agL.asi) == null || !str.equals("1")) ? false : true;
    }

    private boolean agJ() {
        String str;
        com.baidu.tbadk.data.d agL = agL();
        return agL == null || (str = agL.asg.get(agE())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agK() {
        String str;
        com.baidu.tbadk.data.d agL = agL();
        return agL == null || (str = agL.asf.get(agE())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.d agL() {
        return com.baidu.tbadk.data.d.CE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long agM() {
        String str;
        com.baidu.tbadk.data.d agL = agL();
        if (agL != null && (str = agL.asf.get(agE())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return clt.get(agE()).longValue() * 1000;
    }

    private int agN() {
        String str;
        int g;
        com.baidu.tbadk.data.d agL = agL();
        return (agL == null || (str = agL.asg.get(agE())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? clu.get(agE()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long agO() {
        String str;
        int g;
        com.baidu.tbadk.data.d agL = agL();
        return (agL == null || (str = agL.ash.get(agE())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? clv.get(agE()).longValue() * 1000 : g * 1000;
    }
}
