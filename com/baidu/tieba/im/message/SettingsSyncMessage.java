package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class SettingsSyncMessage extends Message {
    private String portrait;

    public SettingsSyncMessage() {
        setCmd(-10);
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }
}
