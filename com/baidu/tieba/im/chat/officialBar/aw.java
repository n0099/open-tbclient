package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
public class aw {
    private static volatile aw aSb;
    private boolean isAcceptNotify;

    public static aw Kz() {
        if (aSb == null) {
            synchronized (aw.class) {
                if (aSb == null) {
                    aSb = new aw();
                }
            }
        }
        return aSb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
