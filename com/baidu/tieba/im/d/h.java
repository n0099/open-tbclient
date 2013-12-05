package com.baidu.tieba.im.d;

import com.baidu.browser.core.util.BdLog;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.b.n;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.chat.ac;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.tencent.mm.sdk.conversation.RConversation;
import com.tencent.mm.sdk.message.RMsgInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        com.baidu.tieba.im.b.a.a e;
        int a2;
        ResponsePullMessage responsePullMessage = new ResponsePullMessage();
        responsePullMessage.setGroupMsg(new LinkedList());
        responsePullMessage.setErrorInfo(qVar);
        linkedList.add(responsePullMessage);
        if (dVar != null && !responsePullMessage.hasError() && (e = dVar.e("groupMsg")) != null && e.a() != 0) {
            BdLog.i("----begin messync transformCommand");
            int a3 = e.a();
            for (int i2 = 0; i2 < a3; i2++) {
                GroupMsgData groupMsgData = new GroupMsgData(-100);
                linkedList.add(groupMsgData);
                responsePullMessage.getGroupMsg().add(groupMsgData);
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.a(new LinkedList());
                groupMsgData.setListMessageData(bVar);
                com.baidu.tieba.im.b.a.d a4 = e.a(i2);
                com.baidu.tieba.im.b.a.d f = a4.f("groupInfo");
                GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
                groupMsgData.setGroupInfo(groupIdTypeData);
                groupIdTypeData.setGroupId(f.c("groupId"));
                groupIdTypeData.setGroupType(f.b("groupType"));
                com.baidu.tieba.im.b.a.a e2 = a4.e("msgList");
                if (e2 != null && (a2 = e2.a()) > 0) {
                    BdLog.i("----transform list size:" + a2);
                    for (int i3 = 0; i3 < a2; i3++) {
                        try {
                            com.baidu.tieba.im.b.a.d a5 = e2.a(i3);
                            ChatMessage chatMessage = new ChatMessage();
                            long b = ac.b(a5.c("msgId"));
                            chatMessage.setMsgId(b);
                            chatMessage.setGroupId(a5.a("groupId"));
                            chatMessage.setMsgType(a5.b(RConversation.COL_MSGTYPE));
                            BdLog.d("msgType:" + chatMessage.getMsgType());
                            long c = a5.c("userId");
                            chatMessage.setUserId(c);
                            if (TiebaApplication.C() && String.valueOf(c).equals(TiebaApplication.B())) {
                                chatMessage.setRecordId(a5.c("recordId"));
                            } else {
                                chatMessage.setRecordId(b);
                            }
                            chatMessage.setUserInfo(new UserData());
                            com.baidu.tieba.im.b.a.d f2 = a5.f("userInfo");
                            chatMessage.getUserInfo().setId(f2.a("userId"));
                            chatMessage.getUserInfo().setName(f2.a("userName"));
                            chatMessage.getUserInfo().setPortrait(f2.a("portrait"));
                            chatMessage.getUserInfo().setSex(f2.b("sex"));
                            chatMessage.setContent(a5.a("content"));
                            chatMessage.setTime(a5.b(RMsgInfo.COL_CREATE_TIME));
                            bVar.a().add(chatMessage);
                            com.baidu.tieba.im.e.d.e(chatMessage);
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
