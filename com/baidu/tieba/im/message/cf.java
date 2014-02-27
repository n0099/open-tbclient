package com.baidu.tieba.im.message;

import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
public class cf extends da implements com.baidu.tieba.im.coder.f {
    private MembersData a;

    public final MembersData a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupUserListRes.QueryGroupUserListResIdl parseFrom = QueryGroupUserListRes.QueryGroupUserListResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = new MembersData();
            this.a.setUsers(new ArrayList());
            int userListCount = parseFrom.getData().getUserListCount();
            for (int i2 = 0; i2 < userListCount; i2++) {
                Im.UserInfo userList = parseFrom.getData().getUserList(i2);
                UserData userData = new UserData();
                userData.setInTime(userList.getInTime());
                userData.setLastReplyTime(userList.getLastReplyTime());
                userData.setLat(String.valueOf(userList.getLat()));
                userData.setLng(String.valueOf(userList.getLng()));
                userData.setLoginTime(userList.getLoginTime());
                userData.setPortrait(userList.getPortrait());
                userData.setPosition(userList.getPosition());
                userData.setSex(userList.getSex());
                userData.setUserIdLong(userList.getUserId());
                userData.setUserName(userList.getUserName());
                List<Im.TshowInfo> tshowIconList = userList.getTshowIconList();
                if (tshowIconList != null) {
                    LinkedList<IconData> linkedList2 = new LinkedList<>();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= tshowIconList.size()) {
                            break;
                        }
                        Im.TshowInfo tshowInfo = tshowIconList.get(i4);
                        linkedList2.add(new IconData(tshowInfo.getIcon(), tshowInfo.getName(), tshowInfo.getUrl()));
                        i3 = i4 + 1;
                    }
                    userData.setTShowInfo(linkedList2);
                }
                Im.UserPermission permission = userList.getPermission();
                UserData.Permission permission2 = new UserData.Permission();
                permission2.setIsGroupManager(permission.getIsGroupManager());
                permission2.setIsGroupOwner(permission.getIsGroupOwner());
                userData.setPermission(permission2);
                this.a.getUsers().add(userData);
            }
            Im.UserPermission permission3 = parseFrom.getData().getPermission();
            UserData.Permission permission4 = new UserData.Permission();
            permission4.setIsGroupManager(permission3.getIsGroupManager());
            permission4.setIsGroupOwner(permission3.getIsGroupOwner());
            this.a.setPermission(permission4);
        }
    }
}
