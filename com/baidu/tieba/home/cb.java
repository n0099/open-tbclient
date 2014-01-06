package com.baidu.tieba.home;
/* loaded from: classes.dex */
class cb {
    private int a = -1;

    public void a(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public boolean b(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }
}
