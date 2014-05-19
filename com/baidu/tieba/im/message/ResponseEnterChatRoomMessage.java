package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.EnterChatroom.ChatroomTopic;
import protobuf.EnterChatroom.DataRes;
import protobuf.EnterChatroom.EnterChatroomResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseEnterChatRoomMessage extends SocketResponsedMessage {
    private RandChatRoomData randChatRoomData;

    public ResponseEnterChatRoomMessage() {
        super(MessageTypes.CMD_REQUEST_ENTER_CHAT_ROOM);
    }

    public RandChatRoomData getRandChatRoomData() {
        return this.randChatRoomData;
    }

    public void setRandChatRoomData(RandChatRoomData randChatRoomData) {
        this.randChatRoomData = randChatRoomData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        EnterChatroomResIdl enterChatroomResIdl = (EnterChatroomResIdl) new Wire(new Class[0]).parseFrom(bArr, EnterChatroomResIdl.class);
        setError(enterChatroomResIdl.error.errorno.intValue());
        setErrorString(enterChatroomResIdl.error.usermsg);
        if (getError() == 0) {
            setRandChatRoomData(new RandChatRoomData());
            DataRes dataRes = enterChatroomResIdl.data;
            if (dataRes != null) {
                getRandChatRoomData().a(dataRes.groupId.intValue());
                getRandChatRoomData().c(dataRes.maxUserNum.intValue());
                getRandChatRoomData().b(dataRes.userNum.intValue());
                getRandChatRoomData().a(dataRes.durationTime.intValue());
                getRandChatRoomData().c(dataRes.averageWaitTime.intValue());
                getRandChatRoomData().b(dataRes.silenceTime.intValue());
                getRandChatRoomData().d(dataRes.lastMsgId.longValue());
                getRandChatRoomData().b(new ArrayList());
                ChatRoomTopicData chatRoomTopicData = new ChatRoomTopicData();
                chatRoomTopicData.setTitle(dataRes.title);
                chatRoomTopicData.setContent(dataRes.content);
                getRandChatRoomData().a(chatRoomTopicData);
                ArrayList arrayList = new ArrayList();
                List<ChatroomTopic> list = dataRes.topicList;
                if (list != null) {
                    for (ChatroomTopic chatroomTopic : list) {
                        ChatRoomTopicData chatRoomTopicData2 = new ChatRoomTopicData();
                        chatRoomTopicData2.setTitle(chatroomTopic.title);
                        chatRoomTopicData2.setContent(chatroomTopic.content);
                        arrayList.add(chatRoomTopicData2);
                    }
                }
                getRandChatRoomData().a(arrayList);
                List<UserInfo> list2 = dataRes.userList;
                if (list2 != null) {
                    for (UserInfo userInfo : list2) {
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
                        getRandChatRoomData().j().add(userData);
                    }
                }
            }
        }
    }
}
