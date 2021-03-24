package com.baidu.tieba.im.settingcache;

import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class PersonalSettingItemData extends ChatSetting implements Serializable {
    public static final long serialVersionUID = 6507309561121772239L;
    public boolean isHide;
    public String myUid;
    public String toName;
    public String toPortrait;
    public String toUid;

    public String getMyUid() {
        return this.myUid;
    }

    public String getToName() {
        return this.toName;
    }

    public String getToPortrait() {
        return this.toPortrait;
    }

    public String getToUid() {
        return this.toUid;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void setMyUid(String str) {
        this.myUid = str;
    }

    public void setToName(String str) {
        this.toName = str;
    }

    public void setToPortrait(String str) {
        this.toPortrait = str;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }
}
