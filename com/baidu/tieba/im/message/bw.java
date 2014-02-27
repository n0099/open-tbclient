package com.baidu.tieba.im.message;

import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.im.data.RandChatRoomData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.EnterChatroom.EnterChatroomRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class bw extends da implements com.baidu.tieba.im.coder.f {
    private RandChatRoomData a;

    public bw() {
        super(106101);
    }

    public final RandChatRoomData a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        EnterChatroomRes.EnterChatroomResIdl parseFrom = EnterChatroomRes.EnterChatroomResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
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
}
