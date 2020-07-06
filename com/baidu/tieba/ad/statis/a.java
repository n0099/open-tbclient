package com.baidu.tieba.ad.statis;

import com.baidu.live.tbadk.pay.PayHelper;
/* loaded from: classes8.dex */
public class a implements com.baidu.tieba.r.a {
    private a() {
    }

    /* renamed from: com.baidu.tieba.ad.statis.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0513a {
        private static a eZu = new a();
    }

    public static a bps() {
        return C0513a.eZu;
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
    public void dx(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dy(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "cardclick");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.r.a
    public void dz(String str, String str2) {
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
    public void ae(String str, String str2, String str3) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init(PayHelper.STATUS_SUCC, "every_log");
        init.addParam("f1", "alert_click");
        init.addParam("f2", str);
        init.addParam("f5", str2);
        init.addParam("extf", str3);
        init.send();
    }
}
