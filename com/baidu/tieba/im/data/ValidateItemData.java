package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ValidateItemData extends AbstractImageProvider implements Serializable {
    public static final long serialVersionUID = 3854743775726463617L;
    public String UserId;
    public String applyReason;
    public long applyTime;
    public String ext;
    public String groupId;
    public String groupName;
    public long inviterUserId;
    public boolean isPass;
    public boolean isShown;
    public int joinType;
    public String notice_id;
    public String portrait;
    public String userName;

    public String getApplyReason() {
        return this.applyReason;
    }

    public long getApplyTime() {
        return this.applyTime;
    }

    public String getExt() {
        return this.ext;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getPortrait());
        return arrayList;
    }

    public long getInviterUserId() {
        return this.inviterUserId;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getPortrait());
        return arrayList;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getUserId() {
        return this.UserId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isPass() {
        return this.isPass;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setApplyReason(String str) {
        this.applyReason = str;
    }

    public void setApplyTime(long j) {
        this.applyTime = j;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setInviterUserId(long j) {
        this.inviterUserId = j;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public void setPass(boolean z) {
        this.isPass = z;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setUserId(String str) {
        this.UserId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public GroupNewsPojo toGroupNewsPojo() {
        return new GroupNewsPojo(this);
    }

    public String toJsonString() {
        return OrmObject.jsonStrWithObject(this);
    }
}
