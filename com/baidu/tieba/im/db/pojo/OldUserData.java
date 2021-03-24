package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.data.IconData;
import d.b.b.e.p.k;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OldUserData extends AbstractImageProvider implements Serializable {
    public static final long serialVersionUID = -4483304441506804594L;
    public long id;
    public long inTime;
    public long lastReplyTime;
    public String lat;
    public String lng;
    public long loginTime;
    public ArrayList<IconData> mTShowIconInfo;
    public String name;
    public Permission permission;
    public String portrait;
    public String position;
    public int sex;
    public long userId;
    public String userName;

    /* loaded from: classes4.dex */
    public static class Permission extends OrmObject implements Serializable {
        public static final int TRUE = 1;
        public static final long serialVersionUID = -661968182172681650L;
        public int isGroupManager;
        public int isGroupOwner;

        public boolean getIsGroupManager() {
            return this.isGroupManager == 1;
        }

        public boolean getIsGroupOwner() {
            return this.isGroupOwner == 1;
        }

        public boolean isController() {
            return getIsGroupManager() || getIsGroupOwner();
        }

        public void setIsGroupManager(int i) {
            this.isGroupManager = i;
        }

        public void setIsGroupOwner(int i) {
            this.isGroupOwner = i;
        }
    }

    public long getId() {
        return this.id;
    }

    public long getInTime() {
        return this.inTime;
    }

    public long getLastReplyTime() {
        return this.lastReplyTime;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public String getName() {
        return this.name;
    }

    public Permission getPermission() {
        return this.permission;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.portrait);
        return arrayList;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPosition() {
        return this.position;
    }

    public int getSex() {
        return this.sex;
    }

    public ArrayList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setInTime(long j) {
        this.inTime = j;
    }

    public void setLastReplyTime(long j) {
        this.lastReplyTime = j;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        this.mTShowIconInfo = arrayList;
    }

    public void setToUserData(UserData userData) {
        if (userData == null) {
            return;
        }
        userData.setUserIdLong(Math.max(this.id, this.userId));
        userData.setUserName((k.isEmpty(this.userName) || StringUtil.NULL_STRING.equalsIgnoreCase(this.userName)) ? this.name : this.userName);
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

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
