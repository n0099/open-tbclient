package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.data.UserData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.EnterChatroom.EnterChatroomRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class bo extends cr implements com.baidu.tieba.im.coder.f {
    private RandChatRoomData a;

    public bo() {
        super(106101);
    }

    public RandChatRoomData a() {
        return this.a;
    }

    public void a(RandChatRoomData randChatRoomData) {
        this.a = randChatRoomData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        EnterChatroomRes.EnterChatroomResIdl parseFrom = EnterChatroomRes.EnterChatroomResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(new RandChatRoomData());
            EnterChatroomRes.DataRes data = parseFrom.getData();
            if (data != null) {
                a().a(data.getGroupId());
                a().c(data.getMaxUserNum());
                a().b(data.getUserNum());
                a().a(data.getDurationTime());
                a().c(data.getAverageWaitTime());
                a().b(data.getSilenceTime());
                a().d(data.getLastMsgId());
                a().b(new ArrayList());
                ChatRoomTopicData chatRoomTopicData = new ChatRoomTopicData();
                chatRoomTopicData.setTitle(data.getTitle());
                chatRoomTopicData.setContent(data.getContent());
                a().a(chatRoomTopicData);
                ArrayList arrayList = new ArrayList();
                for (EnterChatroomRes.ChatroomTopic chatroomTopic : data.getTopicListList()) {
                    ChatRoomTopicData chatRoomTopicData2 = new ChatRoomTopicData();
                    chatRoomTopicData2.setTitle(chatroomTopic.getTitle());
                    chatRoomTopicData2.setContent(chatroomTopic.getContent());
                    arrayList.add(chatRoomTopicData2);
                }
                a().a(arrayList);
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
                        userData.setUserId(userInfo.getUserId());
                        userData.setUserName(userInfo.getUserName());
                        a().j().add(userData);
                    }
                }
            }
        }
    }
}
