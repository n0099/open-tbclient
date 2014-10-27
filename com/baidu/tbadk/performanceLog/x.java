package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class x extends u {
    public void a(p pVar) {
        if (v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "time");
            logItem.n("ishttp", pVar.Zh ? "1" : "0");
            logItem.n("logid", String.valueOf(pVar.YT));
            logItem.n("issuccess", pVar.isSuccess ? "1" : "0");
            logItem.n("nettype", v.uN().getNetType());
            logItem.n("ct", String.valueOf(pVar.YV));
            logItem.n("wt", String.valueOf(pVar.Zc));
            logItem.n("qt", String.valueOf(pVar.YW));
            logItem.n("connt", String.valueOf(pVar.YX));
            logItem.n("rwt", String.valueOf(pVar.YY));
            logItem.n("dect", String.valueOf(pVar.YZ));
            logItem.n("parset", String.valueOf(pVar.Za));
            logItem.n("rendert", String.valueOf(pVar.Zb));
            logItem.n("ss", String.valueOf(pVar.Zf));
            logItem.n("hs", String.valueOf(pVar.Zg));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void b(p pVar) {
        if (v.uN().uO() && pVar.Zc > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "white");
            logItem.n("logid", String.valueOf(pVar.YT));
            logItem.n("ct", String.valueOf(pVar.YV));
            logItem.n("wt", String.valueOf(pVar.Zc));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void c(p pVar) {
        if (v.uN().uO() && pVar.Zd > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "readCache");
            logItem.n("rct", String.valueOf(pVar.Zd));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void d(p pVar) {
        if (v.uN().uO() && pVar.Ze > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "writeCache");
            logItem.n("wct", String.valueOf(pVar.Ze));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void a(o oVar, String str) {
        if (oVar != null && str != null && v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "resource");
            logItem.n("actype", str);
            logItem.n("logid", String.valueOf(oVar.YT));
            logItem.n("issuccess", oVar.isSuccess ? "1" : "0");
            logItem.n("isfs", oVar.YU ? "1" : "0");
            logItem.n("ct", String.valueOf(oVar.tm));
            logItem.n("from", String.valueOf(oVar.tl));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void g(a aVar) {
        if (aVar != null && v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "fluency");
            logItem.n("logid", String.valueOf(aVar.YT));
            logItem.n("fps", String.valueOf(aVar.uw()));
            logItem.n("memp", String.valueOf(aVar.uy()));
            logItem.n("cpu", String.valueOf(aVar.uz()));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }

    public void h(a aVar) {
        if (v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "gc");
            logItem.n("logid", String.valueOf(aVar.YT));
            logItem.n("gc", String.valueOf(aVar.ux()));
            com.baidu.adp.lib.stats.f.er().b(this.Zu, logItem);
        }
    }
}
