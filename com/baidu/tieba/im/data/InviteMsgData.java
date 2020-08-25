package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class InviteMsgData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 5185744948511601466L;
    private long fromUid;
    private long groupId;
    private String groupName;
    private long groupOwnerId;
    private String notice;
    private String portrait;
    private String text;
    private String title;
    private long toUid;

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public long getGroupOwnerId() {
        return this.groupOwnerId;
    }

    public void setGroupOwnerId(long j) {
        this.groupOwnerId = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getNotice() {
        return this.notice;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public long getToUid() {
        return this.toUid;
    }

    public void setToUid(long j) {
        this.toUid = j;
    }

    public long getFromUid() {
        return this.fromUid;
    }

    public void setFromUid(long j) {
        this.fromUid = j;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }
}
