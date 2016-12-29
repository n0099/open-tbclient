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
    private static final HashMap<String, Long> cSm = new HashMap<>();
    private static final HashMap<String, Integer> cSn = new HashMap<>();
    private static final HashMap<String, Long> cSo = new HashMap<>();
    private static c cSu;
    private List<b> cSp;
    private List<a> cSq;
    private String cSr = null;
    private String cSs = null;
    private long qt = -1;
    private boolean cSt = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e cSv = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e cSw = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e cSx = new g(this, 202003);
    private final CustomMessageListener cSy = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener qR = new i(this, 2000994);

    static {
        cSm.put("2g", 60L);
        cSm.put("3g", 40L);
        cSm.put("4g", 40L);
        cSm.put("wifi", 10L);
        cSn.put("2g", 10);
        cSn.put("3g", 10);
        cSn.put("4g", 10);
        cSn.put("wifi", 10);
        cSo.put("2g", 300L);
        cSo.put("3g", 60L);
        cSo.put("4g", 60L);
        cSo.put("wifi", 5L);
        cSu = null;
    }

    public String aro() {
        return this.cSs;
    }

    public String arp() {
        return this.cSr;
    }

    public void arq() {
        this.cSr = null;
        this.cSs = null;
    }

    public static synchronized c arr() {
        c cVar;
        synchronized (c.class) {
            if (cSu == null) {
                cSu = new c();
            }
            cVar = cSu;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), arF());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), arD());
    }

    public c() {
        this.cSp = null;
        this.cSq = null;
        ars();
        this.cSq = new ArrayList();
        this.cSp = new ArrayList();
    }

    private void ars() {
        MessageManager.getInstance().registerListener(this.qR);
        MessageManager.getInstance().registerListener(this.cSv);
        MessageManager.getInstance().registerListener(this.cSw);
        MessageManager.getInstance().registerListener(this.cSx);
        MessageManager.getInstance().registerListener(this.cSy);
    }

    public void art() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void kN(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (arB() && System.currentTimeMillis() - this.qt > arD()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String aru() {
        return String.valueOf(com.baidu.adp.lib.util.i.gs());
    }

    public String arv() {
        switch (com.baidu.adp.lib.util.i.gs()) {
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

    public int arw() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arx() {
        if (!this.cSt) {
            if (this.cSp != null && this.cSp.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.cSp.size()) {
                        break;
                    }
                    b bVar = this.cSp.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.cSk = bVar.cSk;
                        aVar.cSl = bVar.cSl;
                        aVar.cSj = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.cSp.size(); i3++) {
                            b bVar2 = this.cSp.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.cSk != null && aVar.cSk != null && bVar2.cSk.equals(aVar.cSk) && bVar2.cSl == aVar.cSl) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.cSj++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.cSq.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.cSp.clear();
            if (this.cSq.size() > arE() && arA() && com.baidu.adp.lib.util.i.gm()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.cSq.size() > 100 && !arB() && !arA()) {
                this.cSq.clear();
            }
        }
    }

    public void ary() {
        if (this.cSq.size() > 0) {
            this.cSt = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.cSq) {
                builder.et = aVar.emitTime;
                builder.net = aVar.cSk;
                builder.pushcnt = Integer.valueOf(aVar.cSj);
                builder.process_type = Integer.valueOf(aVar.cSl);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arz() {
        String str;
        com.baidu.tbadk.data.f arC = arC();
        return (arC == null || (str = arC.asR) == null || !str.equals("1")) ? false : true;
    }

    private boolean arA() {
        String str;
        com.baidu.tbadk.data.f arC = arC();
        return arC == null || (str = arC.asP.get(arv())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arB() {
        String str;
        com.baidu.tbadk.data.f arC = arC();
        return arC == null || (str = arC.asO.get(arv())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f arC() {
        return com.baidu.tbadk.data.f.BT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long arD() {
        String str;
        com.baidu.tbadk.data.f arC = arC();
        if (arC != null && (str = arC.asO.get(arv())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return cSm.get(arv()).longValue() * 1000;
    }

    private int arE() {
        String str;
        int g;
        com.baidu.tbadk.data.f arC = arC();
        return (arC == null || (str = arC.asP.get(arv())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cSn.get(arv()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long arF() {
        String str;
        int g;
        com.baidu.tbadk.data.f arC = arC();
        return (arC == null || (str = arC.asQ.get(arv())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? cSo.get(arv()).longValue() * 1000 : g * 1000;
    }
}
