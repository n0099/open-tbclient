package com.baidu.tieba.im;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f1637a;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        f1637a = new l();
    }

    public static l b() {
        return f1637a;
    }

    public boolean c() {
        boolean a2 = com.baidu.tieba.sharedPref.b.a().a("bar_group_first", true);
        if (a2) {
            com.baidu.tieba.sharedPref.b.a().b("bar_group_first", false);
        }
        return a2;
    }

    public boolean d() {
        return com.baidu.tieba.sharedPref.b.a().a("is_hidden_entergroup_guide", false);
    }

    public void a(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("is_hidden_entergroup_guide", z);
    }

    public boolean e() {
        return com.baidu.tieba.sharedPref.b.a().a("is_hidden_frs_im_grouplist_guide", false);
    }

    public void b(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("is_hidden_frs_im_grouplist_guide", z);
    }
}
