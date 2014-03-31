package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
public class ResponseMembersMessage extends SocketResponsedMessage {
    private MembersData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupUserListRes.QueryGroupUserListResIdl parseFrom = QueryGroupUserListRes.QueryGroupUserListResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
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
                    LinkedList<IconData> linkedList = new LinkedList<>();
                    for (int i3 = 0; i3 < tshowIconList.size(); i3++) {
                        Im.TshowInfo tshowInfo = tshowIconList.get(i3);
                        linkedList.add(new IconData(tshowInfo.getIcon(), tshowInfo.getName(), tshowInfo.getUrl()));
                    }
                    userData.setTShowInfo(linkedList);
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

    public ResponseMembersMessage() {
        super(103005);
    }

    public final MembersData d() {
        return this.a;
    }
}
