package com.baidu.tieba.ad.statis;

import com.baidu.live.tbadk.pay.PayHelper;
/* loaded from: classes8.dex */
public class a implements com.baidu.tieba.r.a {
    private a() {
    }

    /* renamed from: com.baidu.tieba.ad.statis.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0505a {
        private static a ePj = new a();
    }

    public static a bmR() {
        return C0505a.ePj;
    }

    @Override // com.baidu.tieba.r.a
    public void c(long j, String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "pageshow");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dt(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void du(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardclick");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dv(String str, String str2) {
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
    public void ad(String str, String str2, String str3) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "alert_click");
        init.addParam("f2", str);
        init.addParam("f5", str2);
        init.addParam("extf", str3);
        init.send();
    }
}
