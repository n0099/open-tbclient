package com.baidu.tieba.im.message;

import com.baidu.tieba.data.IconData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
public class bw extends cr implements com.baidu.tieba.im.coder.f {
    private MembersData a;

    public MembersData a() {
        return this.a;
    }

    public void a(MembersData membersData) {
        this.a = membersData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        QueryGroupUserListRes.QueryGroupUserListResIdl parseFrom = QueryGroupUserListRes.QueryGroupUserListResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(new MembersData());
            a().setUsers(new ArrayList());
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
                userData.setUserId(userList.getUserId());
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
                a().getUsers().add(userData);
            }
            Im.UserPermission permission3 = parseFrom.getData().getPermission();
            UserData.Permission permission4 = new UserData.Permission();
            permission4.setIsGroupManager(permission3.getIsGroupManager());
            permission4.setIsGroupOwner(permission3.getIsGroupOwner());
            a().setPermission(permission4);
        }
    }
}
