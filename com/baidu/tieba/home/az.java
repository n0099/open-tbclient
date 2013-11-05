package com.baidu.tieba.home;
/* loaded from: classes.dex */
class az {

    /* renamed from: a  reason: collision with root package name */
    private int f1350a = -1;

    public void a(int i) {
        this.f1350a = i;
    }

    public int a() {
        return this.f1350a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
