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
    private static final HashMap<String, Long> bSN = new HashMap<>();
    private static final HashMap<String, Integer> bSO = new HashMap<>();
    private static final HashMap<String, Long> bSP = new HashMap<>();
    private static c bSV;
    private List<b> bSQ;
    private List<a> bSR;
    private String bSS = null;
    private String bST = null;
    private long wT = -1;
    private boolean bSU = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bSW = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bSX = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bSY = new g(this, 202003);
    private final CustomMessageListener bSZ = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener xr = new i(this, 2000994);

    static {
        bSN.put("2g", 60L);
        bSN.put("3g", 40L);
        bSN.put("4g", 40L);
        bSN.put("wifi", 10L);
        bSO.put("2g", 10);
        bSO.put("3g", 10);
        bSO.put("4g", 10);
        bSO.put("wifi", 10);
        bSP.put("2g", 300L);
        bSP.put("3g", 60L);
        bSP.put("4g", 60L);
        bSP.put("wifi", 5L);
        bSV = null;
    }

    public String Za() {
        return this.bST;
    }

    public String Zb() {
        return this.bSS;
    }

    public void Zc() {
        this.bSS = null;
        this.bST = null;
    }

    public static synchronized c Zd() {
        c cVar;
        synchronized (c.class) {
            if (bSV == null) {
                bSV = new c();
            }
            cVar = bSV;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Zr());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Zp());
    }

    public c() {
        this.bSQ = null;
        this.bSR = null;
        Ze();
        this.bSR = new ArrayList();
        this.bSQ = new ArrayList();
    }

    private void Ze() {
        MessageManager.getInstance().registerListener(this.xr);
        MessageManager.getInstance().registerListener(this.bSW);
        MessageManager.getInstance().registerListener(this.bSX);
        MessageManager.getInstance().registerListener(this.bSY);
        MessageManager.getInstance().registerListener(this.bSZ);
    }

    public void Zf() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void iA(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Zn() && System.currentTimeMillis() - this.wT > Zp()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Zg() {
        return String.valueOf(com.baidu.adp.lib.util.i.iV());
    }

    public String Zh() {
        switch (com.baidu.adp.lib.util.i.iV()) {
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

    public int Zi() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        if (!this.bSU) {
            if (this.bSQ != null && this.bSQ.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bSQ.size()) {
                        break;
                    }
                    b bVar = this.bSQ.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bSL = bVar.bSL;
                        aVar.bSM = bVar.bSM;
                        aVar.bSK = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bSQ.size(); i3++) {
                            b bVar2 = this.bSQ.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bSL != null && aVar.bSL != null && bVar2.bSL.equals(aVar.bSL) && bVar2.bSM == aVar.bSM) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bSK++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bSR.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bSQ.clear();
            if (this.bSR.size() > Zq() && Zm() && com.baidu.adp.lib.util.i.iP()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bSR.size() > 100 && !Zn() && !Zm()) {
                this.bSR.clear();
            }
        }
    }

    public void Zk() {
        if (this.bSR.size() > 0) {
            this.bSU = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bSR) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bSL;
                builder.pushcnt = Integer.valueOf(aVar.bSK);
                builder.process_type = Integer.valueOf(aVar.bSM);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zl() {
        String str;
        com.baidu.tbadk.data.c Zo = Zo();
        return (Zo == null || (str = Zo.apt) == null || !str.equals("1")) ? false : true;
    }

    private boolean Zm() {
        String str;
        com.baidu.tbadk.data.c Zo = Zo();
        return Zo == null || (str = Zo.apr.get(Zh())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zn() {
        String str;
        com.baidu.tbadk.data.c Zo = Zo();
        return Zo == null || (str = Zo.apq.get(Zh())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Zo() {
        return com.baidu.tbadk.data.c.AT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Zp() {
        String str;
        com.baidu.tbadk.data.c Zo = Zo();
        if (Zo != null && (str = Zo.apq.get(Zh())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return bSN.get(Zh()).longValue() * 1000;
    }

    private int Zq() {
        String str;
        int g;
        com.baidu.tbadk.data.c Zo = Zo();
        return (Zo == null || (str = Zo.apr.get(Zh())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? bSO.get(Zh()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Zr() {
        String str;
        int g;
        com.baidu.tbadk.data.c Zo = Zo();
        return (Zo == null || (str = Zo.aps.get(Zh())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? bSP.get(Zh()).longValue() * 1000 : g * 1000;
    }
}
