package com.baidu.tieba.im.a;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> bgf = new HashMap<>();
    private static final HashMap<String, Integer> bgg = new HashMap<>();
    private static final HashMap<String, Long> bgh = new HashMap<>();
    private static c bgn;
    private List<b> bgi;
    private List<a> bgj;
    private String bgk = null;
    private String bgl = null;
    private long mLastUploadTime = -1;
    private boolean bgm = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bgo = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bgp = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bgq = new g(this, 202003);
    private final CustomMessageListener bgr = new h(this, 2001011);

    static {
        bgf.put("2g", 60L);
        bgf.put("3g", 40L);
        bgf.put("4g", 40L);
        bgf.put("wifi", 10L);
        bgg.put("2g", 10);
        bgg.put("3g", 10);
        bgg.put("4g", 10);
        bgg.put("wifi", 10);
        bgh.put("2g", 300L);
        bgh.put("3g", 60L);
        bgh.put("4g", 60L);
        bgh.put("wifi", 5L);
        bgn = null;
    }

    public String PZ() {
        return this.bgl;
    }

    public String Qa() {
        return this.bgk;
    }

    public void Qb() {
        this.bgk = null;
        this.bgl = null;
    }

    public static synchronized c Qc() {
        c cVar;
        synchronized (c.class) {
            if (bgn == null) {
                bgn = new c();
            }
            cVar = bgn;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), Qq());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Qo());
    }

    public c() {
        this.bgi = null;
        this.bgj = null;
        Qd();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.bgj = new ArrayList();
        this.bgi = new ArrayList();
    }

    private void Qd() {
        MessageManager.getInstance().registerListener(this.bgo);
        MessageManager.getInstance().registerListener(this.bgp);
        MessageManager.getInstance().registerListener(this.bgq);
        MessageManager.getInstance().registerListener(this.bgr);
    }

    public void Qe() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void gQ(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Qm() && System.currentTimeMillis() - this.mLastUploadTime > Qo()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Qf() {
        return String.valueOf(com.baidu.adp.lib.util.i.fl());
    }

    public String Qg() {
        switch (com.baidu.adp.lib.util.i.fl()) {
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

    public int Qh() {
        return TbadkCoreApplication.m255getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
        if (!this.bgm) {
            if (this.bgi != null && this.bgi.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bgi.size()) {
                        break;
                    }
                    b bVar = this.bgi.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bgd = bVar.bgd;
                        aVar.bge = bVar.bge;
                        aVar.bgc = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bgi.size(); i3++) {
                            b bVar2 = this.bgi.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bgd != null && aVar.bgd != null && bVar2.bgd.equals(aVar.bgd) && bVar2.bge == aVar.bge) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bgc++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bgj.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bgi.clear();
            if (this.bgj.size() > Qp() && Ql() && com.baidu.adp.lib.util.i.fg()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bgj.size() > 100 && !Qm() && !Ql()) {
                this.bgj.clear();
            }
        }
    }

    public void Qj() {
        if (this.bgj.size() > 0) {
            this.bgm = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bgj) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bgd;
                builder.pushcnt = Integer.valueOf(aVar.bgc);
                builder.process_type = Integer.valueOf(aVar.bge);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qk() {
        String str;
        com.baidu.tbadk.data.c Qn = Qn();
        return (Qn == null || (str = Qn.Wn) == null || !str.equals("1")) ? false : true;
    }

    private boolean Ql() {
        String str;
        com.baidu.tbadk.data.c Qn = Qn();
        return Qn == null || (str = Qn.Wl.get(Qg())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qm() {
        String str;
        com.baidu.tbadk.data.c Qn = Qn();
        return Qn == null || (str = Qn.Wk.get(Qg())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Qn() {
        return com.baidu.tbadk.data.c.uo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Qo() {
        String str;
        com.baidu.tbadk.data.c Qn = Qn();
        if (Qn != null && (str = Qn.Wk.get(Qg())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return bgf.get(Qg()).longValue() * 1000;
    }

    private int Qp() {
        String str;
        int i;
        com.baidu.tbadk.data.c Qn = Qn();
        return (Qn == null || (str = Qn.Wl.get(Qg())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bgg.get(Qg()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Qq() {
        String str;
        int i;
        com.baidu.tbadk.data.c Qn = Qn();
        return (Qn == null || (str = Qn.Wm.get(Qg())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bgh.get(Qg()).longValue() * 1000 : i * 1000;
    }
}
