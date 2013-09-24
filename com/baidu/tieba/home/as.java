package com.baidu.tieba.home;
/* loaded from: classes.dex */
class as {

    /* renamed from: a  reason: collision with root package name */
    private int f1210a = -1;

    public void a(int i) {
        this.f1210a = i;
    }

    public int a() {
        return this.f1210a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
