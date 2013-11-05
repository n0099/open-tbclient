package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseGroupInfoMessage extends ResponsedMessage {
    private static final long serialVersionUID = -1087140172527614629L;
    private int canJoinGroupNum;
    private GroupData group;
    private boolean hideRecommendGroup;
    private boolean isGroupManager;
    private boolean isJoin;
    private int joinGroupNum;
    private List<MemberData> members;
    private List<PhotoUrlData> photos;

    public ResponseGroupInfoMessage() {
    }

    public ResponseGroupInfoMessage(int i) {
        super(i);
    }

    public GroupData getGroup() {
        return this.group;
    }

    public void setGroup(GroupData groupData) {
        this.group = groupData;
    }

    public List<MemberData> getMembers() {
        return this.members;
    }

    public void setMembers(List<MemberData> list) {
        this.members = list;
    }

    public List<PhotoUrlData> getPhotos() {
        return this.photos;
    }

    public void setPhotos(List<PhotoUrlData> list) {
        this.photos = list;
    }

    public int getJoinGroupNum() {
        return this.joinGroupNum;
    }

    public void setJoinGroupNum(int i) {
        this.joinGroupNum = i;
    }

    public int getCanJoinGroupNum() {
        return this.canJoinGroupNum;
    }

    public void setCanJoinGroupNum(int i) {
        this.canJoinGroupNum = i;
    }

    public boolean isJoin() {
        return this.isJoin;
    }

    public void setJoin(boolean z) {
        this.isJoin = z;
    }

    public boolean isGroupManager() {
        return this.isGroupManager;
    }

    public void setGroupManager(boolean z) {
        this.isGroupManager = z;
    }

    public boolean isHideRecommendGroup() {
        return this.hideRecommendGroup;
    }

    public void setHideRecommendGroup(boolean z) {
        this.hideRecommendGroup = z;
    }
}
