package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.a;
import com.baidu.tbadk.data.IconData;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class OldUserData extends a implements Serializable {
    private static final long serialVersionUID = -4483304441506804594L;
    private long id;
    private long inTime;
    private long lastReplyTime;
    private String lat;
    private String lng;
    private long loginTime;
    private LinkedList<IconData> mTShowIconInfo;
    private String name;
    private Permission permission;
    private String portrait;
    private String position;
    private int sex;
    private long userId;
    private String userName;

    public void setToUserData(UserData userData) {
        if (userData != null) {
            userData.setUserIdLong(Math.max(this.id, this.userId));
            userData.setUserName((i.c(this.userName) || "null".equalsIgnoreCase(this.userName)) ? this.name : this.userName);
            userData.setPortrait(this.portrait);
            userData.setSex(this.sex);
            userData.setPosition(this.position);
            userData.setLat(this.lat);
            userData.setLng(this.lng);
            userData.setInTime(this.inTime);
            userData.setLoginTime(this.loginTime);
            userData.setLastReplyTime(this.lastReplyTime);
            userData.setTShowInfo(this.mTShowIconInfo);
        }
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public long getInTime() {
        return this.inTime;
    }

    public void setInTime(long j) {
        this.inTime = j;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public long getLastReplyTime() {
        return this.lastReplyTime;
    }

    public void setLastReplyTime(long j) {
        this.lastReplyTime = j;
    }

    @Override // com.baidu.tbadk.core.util.a
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.portrait);
        return linkedList;
    }

    /* loaded from: classes.dex */
    public class Permission implements Serializable {
        private static final long serialVersionUID = -661968182172681650L;
        private int isGroupManager;
        private int isGroupOwner;

        public boolean getIsGroupOwner() {
            return this.isGroupOwner == 1;
        }

        public void setIsGroupOwner(int i) {
            this.isGroupOwner = i;
        }

        public boolean getIsGroupManager() {
            return this.isGroupManager == 1;
        }

        public void setIsGroupManager(int i) {
            this.isGroupManager = i;
        }

        public boolean isController() {
            return getIsGroupManager() || getIsGroupOwner();
        }
    }
}
