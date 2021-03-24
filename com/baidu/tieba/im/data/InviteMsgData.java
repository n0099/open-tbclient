package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class InviteMsgData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 5185744948511601466L;
    public long fromUid;
    public long groupId;
    public String groupName;
    public long groupOwnerId;
    public String notice;
    public String portrait;
    public String text;
    public String title;
    public long toUid;

    public long getFromUid() {
        return this.fromUid;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getGroupOwnerId() {
        return this.groupOwnerId;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public long getToUid() {
        return this.toUid;
    }

    public void setFromUid(long j) {
        this.fromUid = j;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupOwnerId(long j) {
        this.groupOwnerId = j;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setToUid(long j) {
        this.toUid = j;
    }
}
