package com.baidu.tieba.d;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class p extends Thread {
    private int a;
    private String b;
    private Hashtable c;

    public p(Hashtable hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public p(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList y;
        super.run();
        try {
            if (this.a == 3) {
                if (this.c != null && (y = k.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put((String) y.get(i), 1);
                    }
                }
            } else if (this.a == 2) {
                k.q(this.b);
            } else if (this.a == 1) {
                k.p(this.b);
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
