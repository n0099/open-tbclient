package com.baidu.tieba.im.data;

import com.baidu.tbadk.data.UserData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class MembersData implements Serializable {
    private static final long serialVersionUID = -7753167435649497271L;
    private UserData.Permission permission;
    private List<com.baidu.tieba.data.UserData> users;

    public List<com.baidu.tieba.data.UserData> getUsers() {
        return this.users;
    }

    public void setUsers(List<com.baidu.tieba.data.UserData> list) {
        this.users = list;
    }

    public UserData.Permission getPermission() {
        return this.permission;
    }

    public void setPermission(UserData.Permission permission) {
        this.permission = permission;
    }
}
