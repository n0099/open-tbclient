package com.baidu.tieba.im.a;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> biM = new HashMap<>();
    private static final HashMap<String, Integer> biN = new HashMap<>();
    private static final HashMap<String, Long> biO = new HashMap<>();
    private static c biU;
    private List<b> biP;
    private List<a> biQ;
    private String biR = null;
    private String biS = null;
    private long mLastUploadTime = -1;
    private boolean biT = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e biV = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e biW = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e biX = new g(this, 202003);
    private final CustomMessageListener biY = new h(this, 2001011);

    static {
        biM.put("2g", 60L);
        biM.put("3g", 40L);
        biM.put("4g", 40L);
        biM.put("wifi", 10L);
        biN.put("2g", 10);
        biN.put("3g", 10);
        biN.put("4g", 10);
        biN.put("wifi", 10);
        biO.put("2g", 300L);
        biO.put("3g", 60L);
        biO.put("4g", 60L);
        biO.put("wifi", 5L);
        biU = null;
    }

    public String RK() {
        return this.biS;
    }

    public String RL() {
        return this.biR;
    }

    public void RM() {
        this.biR = null;
        this.biS = null;
    }

    public static synchronized c RN() {
        c cVar;
        synchronized (c.class) {
            if (biU == null) {
                biU = new c();
            }
            cVar = biU;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Sb());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), RZ());
    }

    public c() {
        this.biP = null;
        this.biQ = null;
        RO();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.biQ = new ArrayList();
        this.biP = new ArrayList();
    }

    private void RO() {
        MessageManager.getInstance().registerListener(this.biV);
        MessageManager.getInstance().registerListener(this.biW);
        MessageManager.getInstance().registerListener(this.biX);
        MessageManager.getInstance().registerListener(this.biY);
    }

    public void RP() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void gI(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (RX() && System.currentTimeMillis() - this.mLastUploadTime > RZ()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String RQ() {
        return String.valueOf(k.iM());
    }

    public String RR() {
        switch (k.iM()) {
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

    public int RS() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RT() {
        if (!this.biT) {
            if (this.biP != null && this.biP.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.biP.size()) {
                        break;
                    }
                    b bVar = this.biP.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.biK = bVar.biK;
                        aVar.biL = bVar.biL;
                        aVar.biJ = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.biP.size(); i3++) {
                            b bVar2 = this.biP.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.biK != null && aVar.biK != null && bVar2.biK.equals(aVar.biK) && bVar2.biL == aVar.biL) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.biJ++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.biQ.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.biP.clear();
            if (this.biQ.size() > Sa() && RW() && k.iH()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.biQ.size() > 100 && !RX() && !RW()) {
                this.biQ.clear();
            }
        }
    }

    public void RU() {
        if (this.biQ.size() > 0) {
            this.biT = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.biQ) {
                builder.et = aVar.emitTime;
                builder.net = aVar.biK;
                builder.pushcnt = Integer.valueOf(aVar.biJ);
                builder.process_type = Integer.valueOf(aVar.biL);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RV() {
        String str;
        com.baidu.tbadk.data.c RY = RY();
        return (RY == null || (str = RY.agV) == null || !str.equals("1")) ? false : true;
    }

    private boolean RW() {
        String str;
        com.baidu.tbadk.data.c RY = RY();
        return RY == null || (str = RY.agT.get(RR())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RX() {
        String str;
        com.baidu.tbadk.data.c RY = RY();
        return RY == null || (str = RY.agS.get(RR())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c RY() {
        return com.baidu.tbadk.data.c.xP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long RZ() {
        String str;
        com.baidu.tbadk.data.c RY = RY();
        if (RY != null && (str = RY.agS.get(RR())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return biM.get(RR()).longValue() * 1000;
    }

    private int Sa() {
        String str;
        int i;
        com.baidu.tbadk.data.c RY = RY();
        return (RY == null || (str = RY.agT.get(RR())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? biN.get(RR()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Sb() {
        String str;
        int i;
        com.baidu.tbadk.data.c RY = RY();
        return (RY == null || (str = RY.agU.get(RR())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? biO.get(RR()).longValue() * 1000 : i * 1000;
    }
}
