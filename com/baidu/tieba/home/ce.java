package com.baidu.tieba.home;
/* loaded from: classes.dex */
class ce {

    /* renamed from: a  reason: collision with root package name */
    private int f1447a = -1;

    public void a(int i) {
        this.f1447a = i;
    }

    public int a() {
        return this.f1447a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
