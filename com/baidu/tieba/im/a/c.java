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
    private static final HashMap<String, Long> dcb = new HashMap<>();
    private static final HashMap<String, Integer> dcc = new HashMap<>();
    private static final HashMap<String, Long> dcd = new HashMap<>();
    private static c dcj;
    private List<b> dce;
    private List<a> dcf;
    private String dcg = null;
    private String dch = null;
    private long xn = -1;
    private boolean dci = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dck = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dcl = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dcm = new g(this, 202003);
    private final CustomMessageListener dcn = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        dcb.put("2g", 60L);
        dcb.put("3g", 40L);
        dcb.put("4g", 40L);
        dcb.put("wifi", 10L);
        dcc.put("2g", 10);
        dcc.put("3g", 10);
        dcc.put("4g", 10);
        dcc.put("wifi", 10);
        dcd.put("2g", 300L);
        dcd.put("3g", 60L);
        dcd.put("4g", 60L);
        dcd.put("wifi", 5L);
        dcj = null;
    }

    public String aqD() {
        return this.dch;
    }

    public String aqE() {
        return this.dcg;
    }

    public void aqF() {
        this.dcg = null;
        this.dch = null;
    }

    public static synchronized c aqG() {
        c cVar;
        synchronized (c.class) {
            if (dcj == null) {
                dcj = new c();
            }
            cVar = dcj;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), aqU());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), aqS());
    }

    public c() {
        this.dce = null;
        this.dcf = null;
        aqH();
        this.dcf = new ArrayList();
        this.dce = new ArrayList();
    }

    private void aqH() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dck);
        MessageManager.getInstance().registerListener(this.dcl);
        MessageManager.getInstance().registerListener(this.dcm);
        MessageManager.getInstance().registerListener(this.dcn);
    }

    public void aqI() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kW(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (aqQ() && System.currentTimeMillis() - this.xn > aqS()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String aqJ() {
        return String.valueOf(com.baidu.adp.lib.util.i.hq());
    }

    public String aqK() {
        switch (com.baidu.adp.lib.util.i.hq()) {
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

    public int aqL() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqM() {
        if (!this.dci) {
            if (this.dce != null && this.dce.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dce.size()) {
                        break;
                    }
                    b bVar = this.dce.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dca = bVar.dca;
                        aVar.dbZ = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dce.size(); i3++) {
                            b bVar2 = this.dce.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dca == aVar.dca) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dbZ++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dcf.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dce.clear();
            if (this.dcf.size() > aqT() && aqP() && com.baidu.adp.lib.util.i.hk()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dcf.size() > 100 && !aqQ() && !aqP()) {
                this.dcf.clear();
            }
        }
    }

    public void aqN() {
        if (this.dcf.size() > 0) {
            this.dci = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dcf) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dbZ);
                builder.process_type = Integer.valueOf(aVar.dca);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqO() {
        String str;
        com.baidu.tbadk.data.f aqR = aqR();
        return (aqR == null || (str = aqR.axs) == null || !str.equals("1")) ? false : true;
    }

    private boolean aqP() {
        String str;
        com.baidu.tbadk.data.f aqR = aqR();
        return aqR == null || (str = aqR.axq.get(aqK())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqQ() {
        String str;
        com.baidu.tbadk.data.f aqR = aqR();
        return aqR == null || (str = aqR.axp.get(aqK())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f aqR() {
        return com.baidu.tbadk.data.f.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aqS() {
        String str;
        com.baidu.tbadk.data.f aqR = aqR();
        if (aqR != null && (str = aqR.axp.get(aqK())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dcb.get(aqK()).longValue() * 1000;
    }

    private int aqT() {
        String str;
        int g;
        com.baidu.tbadk.data.f aqR = aqR();
        return (aqR == null || (str = aqR.axq.get(aqK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dcc.get(aqK()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aqU() {
        String str;
        int g;
        com.baidu.tbadk.data.f aqR = aqR();
        return (aqR == null || (str = aqR.axr.get(aqK())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dcd.get(aqK()).longValue() * 1000 : g * 1000;
    }
}
