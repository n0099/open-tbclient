package com.baidu.tieba.im.c;

import com.baidu.browser.core.util.BdLog;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.z;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.tencent.mm.sdk.conversation.RConversation;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        com.baidu.tieba.im.codec.a.a d;
        int a2;
        ResponsePullMessage responsePullMessage = new ResponsePullMessage();
        responsePullMessage.setGroupMsg(new LinkedList());
        responsePullMessage.setErrorInfo(qVar);
        linkedList.add(responsePullMessage);
        if (cVar != null && !responsePullMessage.hasError() && (d = cVar.d("groupMsg")) != null && d.a() != 0) {
            BdLog.i("----begin messync transformCommand");
            int a3 = d.a();
            for (int i2 = 0; i2 < a3; i2++) {
                GroupMsgData groupMsgData = new GroupMsgData(-100);
                linkedList.add(groupMsgData);
                responsePullMessage.getGroupMsg().add(groupMsgData);
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.a(new LinkedList());
                groupMsgData.setListMessageData(bVar);
                com.baidu.tieba.im.codec.a.c a4 = d.a(i2);
                com.baidu.tieba.im.codec.a.c e = a4.e("groupInfo");
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                groupMsgData.setGroupInfo(groupIdTypeData);
                groupIdTypeData.setGroupId(e.c("groupId"));
                groupIdTypeData.setGroupType(e.b("groupType"));
                com.baidu.tieba.im.codec.a.a d2 = a4.d("msgList");
                if (d2 != null && (a2 = d2.a()) > 0) {
                    BdLog.i("----transform list size:" + a2);
                    for (int i3 = 0; i3 < a2; i3++) {
                        try {
                            com.baidu.tieba.im.codec.a.c a5 = d2.a(i3);
                            ChatMessage chatMessage = new ChatMessage();
                            chatMessage.setMsgId(z.b(a5.c("msgId")));
                            chatMessage.setRecordId(a5.c("recordId"));
                            chatMessage.setGroupId(a5.a("groupId"));
                            chatMessage.setMsgType(a5.b(RConversation.COL_MSGTYPE));
                            BdLog.d("msgType:" + chatMessage.getMsgType());
                            chatMessage.setUserId(a5.c("userId"));
                            chatMessage.setUserInfo(new UserData());
                            com.baidu.tieba.im.codec.a.c e2 = a5.e("userInfo");
                            chatMessage.getUserInfo().setId(e2.a("userId"));
                            chatMessage.getUserInfo().setName(e2.a("userName"));
                            chatMessage.getUserInfo().setPortrait(e2.a("portrait"));
                            chatMessage.getUserInfo().setSex(e2.b("sex"));
                            chatMessage.setContent(a5.a("content"));
                            chatMessage.setTime(a5.b(RMsgInfo.COL_CREATE_TIME));
                            bVar.a().add(chatMessage);
                            com.baidu.tieba.im.d.c.e(chatMessage);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            BdLog.i("----transform error!");
                        }
                    }
                }
            }
            BdLog.i("----end messync transformCommand");
        }
    }
}
