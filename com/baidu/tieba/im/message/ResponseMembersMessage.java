package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryGroupUserList.QueryGroupUserListResIdl;
import protobuf.TshowInfo;
import protobuf.UserInfo;
import protobuf.UserPermission;
/* loaded from: classes.dex */
public class ResponseMembersMessage extends SocketResponsedMessage {
    private MembersData membersData;

    public ResponseMembersMessage() {
        super(MessageTypes.CMD_REQUEST_MEMBERS_BY_ID);
    }

    public MembersData getMembersData() {
        return this.membersData;
    }

    public void setMembersData(MembersData membersData) {
        this.membersData = membersData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupUserListResIdl queryGroupUserListResIdl = (QueryGroupUserListResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupUserListResIdl.class);
        setError(queryGroupUserListResIdl.error.errorno.intValue());
        setErrorString(queryGroupUserListResIdl.error.usermsg);
        if (getError() == 0) {
            setMembersData(new MembersData());
            getMembersData().setUsers(new ArrayList());
            if (queryGroupUserListResIdl.data.userList != null) {
                for (UserInfo userInfo : queryGroupUserListResIdl.data.userList) {
                    UserData userData = new UserData();
                    userData.setInTime(userInfo.inTime.intValue());
                    userData.setLastReplyTime(userInfo.lastReplyTime.intValue());
                    userData.setLat(String.valueOf(userInfo.lat));
                    userData.setLng(String.valueOf(userInfo.lng));
                    userData.setLoginTime(userInfo.loginTime.intValue());
                    userData.setPortrait(userInfo.portrait);
                    userData.setPosition(userInfo.position);
                    userData.setSex(userInfo.sex.intValue());
                    userData.setUserIdLong(userInfo.userId.intValue());
                    userData.setUserName(userInfo.userName);
                    List<TshowInfo> list = userInfo.tshowIcon;
                    if (list != null) {
                        LinkedList<IconData> linkedList = new LinkedList<>();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            TshowInfo tshowInfo = list.get(i2);
                            linkedList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                        }
                        userData.setTShowInfo(linkedList);
                    }
                    UserPermission userPermission = userInfo.permission;
                    UserData.Permission permission = new UserData.Permission();
                    permission.setIsGroupManager(userPermission.isGroupManager.intValue());
                    permission.setIsGroupOwner(userPermission.isGroupOwner.intValue());
                    userData.setPermission(permission);
                    getMembersData().getUsers().add(userData);
                }
            }
            UserPermission userPermission2 = queryGroupUserListResIdl.data.permission;
            UserData.Permission permission2 = new UserData.Permission();
            permission2.setIsGroupManager(userPermission2.isGroupManager.intValue());
            permission2.setIsGroupOwner(userPermission2.isGroupOwner.intValue());
            getMembersData().setPermission(permission2);
        }
    }
}
