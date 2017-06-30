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
    private static final HashMap<String, Long> djZ = new HashMap<>();
    private static final HashMap<String, Integer> dka = new HashMap<>();
    private static final HashMap<String, Long> dkb = new HashMap<>();
    private static c dkh;
    private List<b> dkc;
    private List<a> dkd;
    private String dke = null;
    private String dkf = null;
    private long xn = -1;
    private boolean dkg = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dki = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dkj = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dkk = new g(this, 202003);
    private final CustomMessageListener dkl = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener mNetworkChangedListener = new i(this, 2000994);

    static {
        djZ.put("2g", 60L);
        djZ.put("3g", 40L);
        djZ.put("4g", 40L);
        djZ.put("wifi", 10L);
        dka.put("2g", 10);
        dka.put("3g", 10);
        dka.put("4g", 10);
        dka.put("wifi", 10);
        dkb.put("2g", 300L);
        dkb.put("3g", 60L);
        dkb.put("4g", 60L);
        dkb.put("wifi", 5L);
        dkh = null;
    }

    public String auo() {
        return this.dkf;
    }

    public String aup() {
        return this.dke;
    }

    public void auq() {
        this.dke = null;
        this.dkf = null;
    }

    public static synchronized c aur() {
        c cVar;
        synchronized (c.class) {
            if (dkh == null) {
                dkh = new c();
            }
            cVar = dkh;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), auF());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), auD());
    }

    public c() {
        this.dkc = null;
        this.dkd = null;
        aus();
        this.dkd = new ArrayList();
        this.dkc = new ArrayList();
    }

    private void aus() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dki);
        MessageManager.getInstance().registerListener(this.dkj);
        MessageManager.getInstance().registerListener(this.dkk);
        MessageManager.getInstance().registerListener(this.dkl);
    }

    public void aut() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void lV(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (auB() && System.currentTimeMillis() - this.xn > auD()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String auu() {
        return String.valueOf(com.baidu.adp.lib.util.i.hp());
    }

    public String auv() {
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

    public int auw() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aux() {
        if (!this.dkg) {
            if (this.dkc != null && this.dkc.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dkc.size()) {
                        break;
                    }
                    b bVar = this.dkc.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.djY = bVar.djY;
                        aVar.djX = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dkc.size(); i3++) {
                            b bVar2 = this.dkc.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.djY == aVar.djY) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.djX++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dkd.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dkc.clear();
            if (this.dkd.size() > auE() && auA() && com.baidu.adp.lib.util.i.hj()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dkd.size() > 100 && !auB() && !auA()) {
                this.dkd.clear();
            }
        }
    }

    public void auy() {
        if (this.dkd.size() > 0) {
            this.dkg = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dkd) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.djX);
                builder.process_type = Integer.valueOf(aVar.djY);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auz() {
        String str;
        com.baidu.tbadk.data.f auC = auC();
        return (auC == null || (str = auC.ayu) == null || !str.equals("1")) ? false : true;
    }

    private boolean auA() {
        String str;
        com.baidu.tbadk.data.f auC = auC();
        return auC == null || (str = auC.ays.get(auv())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auB() {
        String str;
        com.baidu.tbadk.data.f auC = auC();
        return auC == null || (str = auC.ayr.get(auv())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f auC() {
        return com.baidu.tbadk.data.f.Ca();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long auD() {
        String str;
        com.baidu.tbadk.data.f auC = auC();
        if (auC != null && (str = auC.ayr.get(auv())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return djZ.get(auv()).longValue() * 1000;
    }

    private int auE() {
        String str;
        int g;
        com.baidu.tbadk.data.f auC = auC();
        return (auC == null || (str = auC.ays.get(auv())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dka.get(auv()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long auF() {
        String str;
        int g;
        com.baidu.tbadk.data.f auC = auC();
        return (auC == null || (str = auC.ayt.get(auv())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dkb.get(auv()).longValue() * 1000 : g * 1000;
    }
}
