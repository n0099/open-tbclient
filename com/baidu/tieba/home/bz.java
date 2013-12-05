package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bz {

    /* renamed from: a  reason: collision with root package name */
    private int f1487a = -1;

    public void a(int i) {
        this.f1487a = i;
    }

    public int a() {
        return this.f1487a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
