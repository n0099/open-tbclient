package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class x extends u {
    public void a(p pVar) {
        if (v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "time");
            logItem.n("ishttp", pVar.Zl ? "1" : "0");
            logItem.n("logid", String.valueOf(pVar.YX));
            logItem.n("issuccess", pVar.isSuccess ? "1" : "0");
            logItem.n("nettype", v.uP().getNetType());
            logItem.n("ct", String.valueOf(pVar.YZ));
            logItem.n("wt", String.valueOf(pVar.Zg));
            logItem.n("qt", String.valueOf(pVar.Za));
            logItem.n("connt", String.valueOf(pVar.Zb));
            logItem.n("rwt", String.valueOf(pVar.Zc));
            logItem.n("dect", String.valueOf(pVar.Zd));
            logItem.n("parset", String.valueOf(pVar.Ze));
            logItem.n("rendert", String.valueOf(pVar.Zf));
            logItem.n("ss", String.valueOf(pVar.Zj));
            logItem.n("hs", String.valueOf(pVar.Zk));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void b(p pVar) {
        if (v.uP().uQ() && pVar.Zg > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "white");
            logItem.n("logid", String.valueOf(pVar.YX));
            logItem.n("ct", String.valueOf(pVar.YZ));
            logItem.n("wt", String.valueOf(pVar.Zg));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void c(p pVar) {
        if (v.uP().uQ() && pVar.Zh > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "readCache");
            logItem.n("rct", String.valueOf(pVar.Zh));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void d(p pVar) {
        if (v.uP().uQ() && pVar.Zi > 0) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "writeCache");
            logItem.n("wct", String.valueOf(pVar.Zi));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void a(o oVar, String str) {
        if (oVar != null && str != null && v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "resource");
            logItem.n("actype", str);
            logItem.n("logid", String.valueOf(oVar.YX));
            logItem.n("issuccess", oVar.isSuccess ? "1" : "0");
            logItem.n("isfs", oVar.YY ? "1" : "0");
            logItem.n("ct", String.valueOf(oVar.tm));
            logItem.n("from", String.valueOf(oVar.tl));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void g(a aVar) {
        if (aVar != null && v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "fluency");
            logItem.n("logid", String.valueOf(aVar.YX));
            logItem.n("fps", String.valueOf(aVar.uy()));
            logItem.n("memp", String.valueOf(aVar.uA()));
            logItem.n("cpu", String.valueOf(aVar.uB()));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }

    public void h(a aVar) {
        if (v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "gc");
            logItem.n("logid", String.valueOf(aVar.YX));
            logItem.n("gc", String.valueOf(aVar.uz()));
            com.baidu.adp.lib.stats.f.er().b(this.Zy, logItem);
        }
    }
}
