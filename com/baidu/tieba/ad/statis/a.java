package com.baidu.tieba.ad.statis;

import com.baidu.live.tbadk.pay.PayHelper;
/* loaded from: classes20.dex */
public class a implements com.baidu.tieba.r.a {
    private a() {
    }

    /* renamed from: com.baidu.tieba.ad.statis.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static class C0565a {
        private static a fsz = new a();
    }

    public static a bCE() {
        return C0565a.fsz;
    }

    @Override // com.baidu.tieba.r.a
    public void d(long j, String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "pageshow");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dQ(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dR(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardclick");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dS(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "fullvideoshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void b(long j, String str, String str2, long j2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "pagetime");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.addParam("f5", j2);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void af(String str, String str2, String str3) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "alert_click");
        init.addParam("f2", str);
        init.addParam("f5", str2);
        init.addParam("extf", str3);
        init.send();
    }
}
