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
    private static final HashMap<String, Long> dai = new HashMap<>();
    private static final HashMap<String, Integer> daj = new HashMap<>();
    private static final HashMap<String, Long> dak = new HashMap<>();
    private static c daq;
    private List<b> dal;
    private List<a> dam;
    private String dan = null;
    private String dao = null;
    private long xj = -1;
    private boolean dap = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dar = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e das = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dau = new g(this, 202003);
    private final CustomMessageListener dav = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        dai.put("2g", 60L);
        dai.put("3g", 40L);
        dai.put("4g", 40L);
        dai.put("wifi", 10L);
        daj.put("2g", 10);
        daj.put("3g", 10);
        daj.put("4g", 10);
        daj.put("wifi", 10);
        dak.put("2g", 300L);
        dak.put("3g", 60L);
        dak.put("4g", 60L);
        dak.put("wifi", 5L);
        daq = null;
    }

    public String arI() {
        return this.dao;
    }

    public String arJ() {
        return this.dan;
    }

    public void arK() {
        this.dan = null;
        this.dao = null;
    }

    public static synchronized c arL() {
        c cVar;
        synchronized (c.class) {
            if (daq == null) {
                daq = new c();
            }
            cVar = daq;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), arZ());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), arX());
    }

    public c() {
        this.dal = null;
        this.dam = null;
        arM();
        this.dam = new ArrayList();
        this.dal = new ArrayList();
    }

    private void arM() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dar);
        MessageManager.getInstance().registerListener(this.das);
        MessageManager.getInstance().registerListener(this.dau);
        MessageManager.getInstance().registerListener(this.dav);
    }

    public void arN() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kH(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (arV() && System.currentTimeMillis() - this.xj > arX()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String arO() {
        return String.valueOf(com.baidu.adp.lib.util.i.hp());
    }

    public String arP() {
        switch (com.baidu.adp.lib.util.i.hp()) {
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

    public int arQ() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arR() {
        if (!this.dap) {
            if (this.dal != null && this.dal.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dal.size()) {
                        break;
                    }
                    b bVar = this.dal.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dah = bVar.dah;
                        aVar.dag = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dal.size(); i3++) {
                            b bVar2 = this.dal.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dah == aVar.dah) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dag++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dam.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dal.clear();
            if (this.dam.size() > arY() && arU() && com.baidu.adp.lib.util.i.hj()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dam.size() > 100 && !arV() && !arU()) {
                this.dam.clear();
            }
        }
    }

    public void arS() {
        if (this.dam.size() > 0) {
            this.dap = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dam) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dag);
                builder.process_type = Integer.valueOf(aVar.dah);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arT() {
        String str;
        com.baidu.tbadk.data.f arW = arW();
        return (arW == null || (str = arW.axH) == null || !str.equals("1")) ? false : true;
    }

    private boolean arU() {
        String str;
        com.baidu.tbadk.data.f arW = arW();
        return arW == null || (str = arW.axF.get(arP())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arV() {
        String str;
        com.baidu.tbadk.data.f arW = arW();
        return arW == null || (str = arW.axE.get(arP())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f arW() {
        return com.baidu.tbadk.data.f.CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long arX() {
        String str;
        com.baidu.tbadk.data.f arW = arW();
        if (arW != null && (str = arW.axE.get(arP())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dai.get(arP()).longValue() * 1000;
    }

    private int arY() {
        String str;
        int g;
        com.baidu.tbadk.data.f arW = arW();
        return (arW == null || (str = arW.axF.get(arP())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? daj.get(arP()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long arZ() {
        String str;
        int g;
        com.baidu.tbadk.data.f arW = arW();
        return (arW == null || (str = arW.axG.get(arP())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dak.get(arP()).longValue() * 1000 : g * 1000;
    }
}
