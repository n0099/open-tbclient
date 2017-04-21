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
    private static final HashMap<String, Long> dcC = new HashMap<>();
    private static final HashMap<String, Integer> dcD = new HashMap<>();
    private static final HashMap<String, Long> dcE = new HashMap<>();
    private static c dcK;
    private List<b> dcF;
    private List<a> dcG;
    private String dcH = null;
    private String dcI = null;
    private long xm = -1;
    private boolean dcJ = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dcL = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dcM = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dcN = new g(this, 202003);
    private final CustomMessageListener dcO = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        dcC.put("2g", 60L);
        dcC.put("3g", 40L);
        dcC.put("4g", 40L);
        dcC.put("wifi", 10L);
        dcD.put("2g", 10);
        dcD.put("3g", 10);
        dcD.put("4g", 10);
        dcD.put("wifi", 10);
        dcE.put("2g", 300L);
        dcE.put("3g", 60L);
        dcE.put("4g", 60L);
        dcE.put("wifi", 5L);
        dcK = null;
    }

    public String asJ() {
        return this.dcI;
    }

    public String asK() {
        return this.dcH;
    }

    public void asL() {
        this.dcH = null;
        this.dcI = null;
    }

    public static synchronized c asM() {
        c cVar;
        synchronized (c.class) {
            if (dcK == null) {
                dcK = new c();
            }
            cVar = dcK;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), ata());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), asY());
    }

    public c() {
        this.dcF = null;
        this.dcG = null;
        asN();
        this.dcG = new ArrayList();
        this.dcF = new ArrayList();
    }

    private void asN() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dcL);
        MessageManager.getInstance().registerListener(this.dcM);
        MessageManager.getInstance().registerListener(this.dcN);
        MessageManager.getInstance().registerListener(this.dcO);
    }

    public void asO() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kI(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (asW() && System.currentTimeMillis() - this.xm > asY()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String asP() {
        return String.valueOf(com.baidu.adp.lib.util.i.hq());
    }

    public String asQ() {
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

    public int asR() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asS() {
        if (!this.dcJ) {
            if (this.dcF != null && this.dcF.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dcF.size()) {
                        break;
                    }
                    b bVar = this.dcF.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dcB = bVar.dcB;
                        aVar.dcA = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dcF.size(); i3++) {
                            b bVar2 = this.dcF.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dcB == aVar.dcB) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dcA++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dcG.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dcF.clear();
            if (this.dcG.size() > asZ() && asV() && com.baidu.adp.lib.util.i.hk()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dcG.size() > 100 && !asW() && !asV()) {
                this.dcG.clear();
            }
        }
    }

    public void asT() {
        if (this.dcG.size() > 0) {
            this.dcJ = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dcG) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dcA);
                builder.process_type = Integer.valueOf(aVar.dcB);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asU() {
        String str;
        com.baidu.tbadk.data.f asX = asX();
        return (asX == null || (str = asX.axJ) == null || !str.equals("1")) ? false : true;
    }

    private boolean asV() {
        String str;
        com.baidu.tbadk.data.f asX = asX();
        return asX == null || (str = asX.axH.get(asQ())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asW() {
        String str;
        com.baidu.tbadk.data.f asX = asX();
        return asX == null || (str = asX.axG.get(asQ())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f asX() {
        return com.baidu.tbadk.data.f.CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long asY() {
        String str;
        com.baidu.tbadk.data.f asX = asX();
        if (asX != null && (str = asX.axG.get(asQ())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dcC.get(asQ()).longValue() * 1000;
    }

    private int asZ() {
        String str;
        int g;
        com.baidu.tbadk.data.f asX = asX();
        return (asX == null || (str = asX.axH.get(asQ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dcD.get(asQ()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ata() {
        String str;
        int g;
        com.baidu.tbadk.data.f asX = asX();
        return (asX == null || (str = asX.axI.get(asQ())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dcE.get(asQ()).longValue() * 1000 : g * 1000;
    }
}
