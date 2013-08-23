package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bg {

    /* renamed from: a  reason: collision with root package name */
    private int f1179a = -1;

    public void a(int i) {
        this.f1179a = i;
    }

    public int a() {
        return this.f1179a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
