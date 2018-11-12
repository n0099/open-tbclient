package com.baidu.tieba.ad.statis;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.p.a {
    private a() {
    }

    /* renamed from: com.baidu.tieba.ad.statis.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0176a {
        private static a byF = new a();
    }

    public static a Vh() {
        return C0176a.byF;
    }

    @Override // com.baidu.tieba.p.a
    public void b(long j, String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "pageshow");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.send();
    }

    @Override // com.baidu.tieba.p.a
    public void aR(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "cardshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.p.a
    public void aS(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "cardclick");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.p.a
    public void aT(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "fullvideoshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // com.baidu.tieba.p.a
    public void a(long j, String str, String str2, long j2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "pagetime");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.addParam("f5", j2);
        init.send();
    }

    @Override // com.baidu.tieba.p.a
    public void s(String str, String str2, String str3) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "alert_click");
        init.addParam("f2", str);
        init.addParam("f5", str2);
        init.addParam("extf", str3);
        init.send();
    }
}
