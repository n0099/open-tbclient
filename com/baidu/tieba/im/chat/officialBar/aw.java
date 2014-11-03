package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
public class aw {
    private static volatile aw aSp;
    private boolean isAcceptNotify;

    public static aw KD() {
        if (aSp == null) {
            synchronized (aw.class) {
                if (aSp == null) {
                    aSp = new aw();
                }
            }
        }
        return aSp;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
