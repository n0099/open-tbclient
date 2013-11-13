package com.baidu.tieba.im;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f1724a;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        f1724a = new l();
    }

    public static l b() {
        return f1724a;
    }

    public boolean c() {
        return com.baidu.tieba.sharedPref.b.a().a("is_hidden_entergroup_guide", false);
    }

    public void a(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("is_hidden_entergroup_guide", z);
    }
}
