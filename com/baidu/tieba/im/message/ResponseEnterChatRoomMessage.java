package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.im.data.RandChatRoomData;
import java.util.ArrayList;
import java.util.List;
import protobuf.EnterChatroom.EnterChatroomRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class ResponseEnterChatRoomMessage extends SocketResponsedMessage {
    private RandChatRoomData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        EnterChatroomRes.EnterChatroomResIdl parseFrom = EnterChatroomRes.EnterChatroomResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new RandChatRoomData();
            EnterChatroomRes.DataRes data = parseFrom.getData();
            if (data != null) {
                this.a.a(data.getGroupId());
                this.a.c(data.getMaxUserNum());
                this.a.b(data.getUserNum());
                this.a.a(data.getDurationTime());
                this.a.c(data.getAverageWaitTime());
                this.a.b(data.getSilenceTime());
                this.a.d(data.getLastMsgId());
                this.a.b(new ArrayList());
                ChatRoomTopicData chatRoomTopicData = new ChatRoomTopicData();
                chatRoomTopicData.setTitle(data.getTitle());
                chatRoomTopicData.setContent(data.getContent());
                this.a.a(chatRoomTopicData);
                ArrayList arrayList = new ArrayList();
                for (EnterChatroomRes.ChatroomTopic chatroomTopic : data.getTopicListList()) {
                    ChatRoomTopicData chatRoomTopicData2 = new ChatRoomTopicData();
                    chatRoomTopicData2.setTitle(chatroomTopic.getTitle());
                    chatRoomTopicData2.setContent(chatroomTopic.getContent());
                    arrayList.add(chatRoomTopicData2);
                }
                this.a.a(arrayList);
                List<Im.UserInfo> userListList = data.getUserListList();
                if (userListList != null) {
                    for (Im.UserInfo userInfo : userListList) {
                        UserData userData = new UserData();
                        userData.setInTime(userInfo.getInTime());
                        userData.setLastReplyTime(userInfo.getLastReplyTime());
                        userData.setLat(String.valueOf(userInfo.getLat()));
                        userData.setLng(String.valueOf(userInfo.getLng()));
                        userData.setLoginTime(userInfo.getLoginTime());
                        userData.setPortrait(userInfo.getPortrait());
                        userData.setPosition(userInfo.getPosition());
                        userData.setSex(userInfo.getSex());
                        userData.setUserIdLong(userInfo.getUserId());
                        userData.setUserName(userInfo.getUserName());
                        this.a.j().add(userData);
                    }
                }
            }
        }
    }

    public ResponseEnterChatRoomMessage() {
        super(106101);
    }

    public final RandChatRoomData d() {
        return this.a;
    }
}
