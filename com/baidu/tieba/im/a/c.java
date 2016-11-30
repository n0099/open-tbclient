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
    private static final HashMap<String, Long> dnq = new HashMap<>();
    private static final HashMap<String, Integer> dnr = new HashMap<>();
    private static final HashMap<String, Long> dns = new HashMap<>();
    private static c dny;
    private List<b> dnt;
    private List<a> dnu;
    private String dnv = null;
    private String dnw = null;
    private long qt = -1;
    private boolean dnx = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e dnz = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e dnA = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e dnB = new g(this, 202003);
    private final CustomMessageListener dnC = new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private CustomMessageListener qR = new i(this, 2000994);

    static {
        dnq.put("2g", 60L);
        dnq.put("3g", 40L);
        dnq.put("4g", 40L);
        dnq.put("wifi", 10L);
        dnr.put("2g", 10);
        dnr.put("3g", 10);
        dnr.put("4g", 10);
        dnr.put("wifi", 10);
        dns.put("2g", 300L);
        dns.put("3g", 60L);
        dns.put("4g", 60L);
        dns.put("wifi", 5L);
        dny = null;
    }

    public String awP() {
        return this.dnw;
    }

    public String awQ() {
        return this.dnv;
    }

    public void awR() {
        this.dnv = null;
        this.dnw = null;
    }

    public static synchronized c awS() {
        c cVar;
        synchronized (c.class) {
            if (dny == null) {
                dny = new c();
            }
            cVar = dny;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), axg());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), axe());
    }

    public c() {
        this.dnt = null;
        this.dnu = null;
        awT();
        this.dnu = new ArrayList();
        this.dnt = new ArrayList();
    }

    private void awT() {
        MessageManager.getInstance().registerListener(this.qR);
        MessageManager.getInstance().registerListener(this.dnz);
        MessageManager.getInstance().registerListener(this.dnA);
        MessageManager.getInstance().registerListener(this.dnB);
        MessageManager.getInstance().registerListener(this.dnC);
    }

    public void awU() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mk(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (axc() && System.currentTimeMillis() - this.qt > axe()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String awV() {
        return String.valueOf(com.baidu.adp.lib.util.i.gs());
    }

    public String awW() {
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

    public int awX() {
        return TbadkCoreApplication.m9getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awY() {
        if (!this.dnx) {
            if (this.dnt != null && this.dnt.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dnt.size()) {
                        break;
                    }
                    b bVar = this.dnt.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.dno = bVar.dno;
                        aVar.dnp = bVar.dnp;
                        aVar.dnn = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dnt.size(); i3++) {
                            b bVar2 = this.dnt.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.dno != null && aVar.dno != null && bVar2.dno.equals(aVar.dno) && bVar2.dnp == aVar.dnp) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.h.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.h.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dnn++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dnu.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dnt.clear();
            if (this.dnu.size() > axf() && axb() && com.baidu.adp.lib.util.i.gm()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dnu.size() > 100 && !axc() && !axb()) {
                this.dnu.clear();
            }
        }
    }

    public void awZ() {
        if (this.dnu.size() > 0) {
            this.dnx = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dnu) {
                builder.et = aVar.emitTime;
                builder.net = aVar.dno;
                builder.pushcnt = Integer.valueOf(aVar.dnn);
                builder.process_type = Integer.valueOf(aVar.dnp);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axa() {
        String str;
        com.baidu.tbadk.data.f axd = axd();
        return (axd == null || (str = axd.ato) == null || !str.equals("1")) ? false : true;
    }

    private boolean axb() {
        String str;
        com.baidu.tbadk.data.f axd = axd();
        return axd == null || (str = axd.atm.get(awW())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axc() {
        String str;
        com.baidu.tbadk.data.f axd = axd();
        return axd == null || (str = axd.atl.get(awW())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.f axd() {
        return com.baidu.tbadk.data.f.Cg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axe() {
        String str;
        com.baidu.tbadk.data.f axd = axd();
        if (axd != null && (str = axd.atl.get(awW())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.h.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dnq.get(awW()).longValue() * 1000;
    }

    private int axf() {
        String str;
        int g;
        com.baidu.tbadk.data.f axd = axd();
        return (axd == null || (str = axd.atm.get(awW())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dnr.get(awW()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axg() {
        String str;
        int g;
        com.baidu.tbadk.data.f axd = axd();
        return (axd == null || (str = axd.atn.get(awW())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.h.b.g(str, 0)) < 2) ? dns.get(awW()).longValue() * 1000 : g * 1000;
    }
}
