package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class BackgroundSwitchMessage extends Message {
    private boolean isBackground;

    public BackgroundSwitchMessage(boolean z) {
        setCmd(-11);
        this.isBackground = z;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public void setBackground(boolean z) {
        this.isBackground = z;
    }
}
