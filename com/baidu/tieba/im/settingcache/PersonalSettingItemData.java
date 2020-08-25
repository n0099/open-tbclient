package com.baidu.tieba.im.settingcache;

import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PersonalSettingItemData extends ChatSetting implements Serializable {
    private static final long serialVersionUID = 6507309561121772239L;
    private boolean isHide;
    private String myUid;
    private String toName;
    private String toPortrait;
    private String toUid;

    public String getMyUid() {
        return this.myUid;
    }

    public void setMyUid(String str) {
        this.myUid = str;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public String getToName() {
        return this.toName;
    }

    public void setToName(String str) {
        this.toName = str;
    }

    public String getToPortrait() {
        return this.toPortrait;
    }

    public void setToPortrait(String str) {
        this.toPortrait = str;
    }
}
