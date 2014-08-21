package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
public class ay {
    private static volatile ay a;
    private boolean b;

    public static ay a() {
        if (a == null) {
            synchronized (ay.class) {
                if (a == null) {
                    a = new ay();
                }
            }
        }
        return a;
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
