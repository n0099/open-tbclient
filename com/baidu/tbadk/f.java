package com.baidu.tbadk;
/* loaded from: classes.dex */
public abstract class f {
    private static f a = new g();

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public static f a() {
        return a;
    }

    public void a(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, str2);
    }

    public String b(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, str2);
    }

    public boolean a(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, z);
    }

    public void b(String str, boolean z) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, z);
    }

    public int a(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, i);
    }

    public void b(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, i);
    }

    public long a(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, j);
    }

    public void b(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, j);
    }
}
