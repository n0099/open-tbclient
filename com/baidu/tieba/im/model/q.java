package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.chat.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1825a;

    private q(MsglistModel msglistModel) {
        this.f1825a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(MsglistModel msglistModel, i iVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.chat.aa
    public void a(Message message) {
        GroupData groupData;
        GroupData groupData2;
        MsgPageData msgPageData;
        int a2;
        MsgPageData msgPageData2;
        MsgPageData msgPageData3;
        MsgPageData msgPageData4;
        MsgPageData msgPageData5;
        com.baidu.adp.a.g gVar;
        MsgPageData msgPageData6;
        com.baidu.adp.a.g gVar2;
        MsgPageData msgPageData7;
        MsgPageData msgPageData8;
        GroupData groupData3;
        GroupData groupData4;
        com.baidu.adp.a.g gVar3;
        ChatResponsedMessage chatResponsedMessage;
        String d;
        String d2;
        MsglistActivity msglistActivity;
        GroupData groupData5;
        com.baidu.tieba.im.data.b listMessage;
        MsgPageData msgPageData9;
        MsgPageData msgPageData10;
        int a3;
        MsgPageData msgPageData11;
        MsgPageData msgPageData12;
        MsgPageData msgPageData13;
        MsgPageData msgPageData14;
        com.baidu.adp.a.g gVar4;
        MsgPageData msgPageData15;
        if (message != null) {
            if (message.getCmd() == -100) {
                GroupMsgData groupMsgData = (GroupMsgData) message;
                if (groupMsgData.getGroupInfo() != null) {
                    long groupId = groupMsgData.getGroupInfo().getGroupId();
                    groupData5 = this.f1825a.e;
                    if (groupId == groupData5.getGroupId() && (listMessage = groupMsgData.getListMessage()) != null) {
                        List<ChatMessage> a4 = listMessage.a();
                        this.f1825a.b(a4);
                        MsglistModel msglistModel = this.f1825a;
                        msgPageData9 = this.f1825a.i;
                        msglistModel.b(msgPageData9.getChatMessages(), a4);
                        Collections.sort(a4, new p(this.f1825a, null));
                        MsglistModel msglistModel2 = this.f1825a;
                        msgPageData10 = this.f1825a.i;
                        a3 = msglistModel2.a(msgPageData10.getChatMessages(), a4);
                        if (a3 > 0) {
                            msgPageData13 = this.f1825a.i;
                            msgPageData13.setIsNewAdd(true);
                            msgPageData14 = this.f1825a.i;
                            msgPageData14.setNewAddNum(a3);
                            this.f1825a.mLoadDataMode = 3;
                            gVar4 = this.f1825a.mLoadDataCallBack;
                            msgPageData15 = this.f1825a.i;
                            gVar4.a(msgPageData15);
                            return;
                        }
                        msgPageData11 = this.f1825a.i;
                        msgPageData11.setIsNewAdd(false);
                        msgPageData12 = this.f1825a.i;
                        msgPageData12.setNewAddNum(0);
                    }
                }
            } else if (message.getCmd() == 202001) {
                if ((message instanceof ChatResponsedMessage) && (chatResponsedMessage = (ChatResponsedMessage) message) != null) {
                    if (chatResponsedMessage.getOrginalMessage() == null || !(chatResponsedMessage.getOrginalMessage() instanceof ChatMessage)) {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(chatResponsedMessage.getCmd(), 0, "chatResMessage.getOrginalMessage()==null", "return", null, 0, null));
                        return;
                    }
                    ChatMessage chatMessage = (ChatMessage) chatResponsedMessage.getOrginalMessage();
                    if (chatResponsedMessage.hasError()) {
                        long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
                        long recordId = chatMessage.getRecordId();
                        d2 = this.f1825a.d(chatMessage);
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(chatResponsedMessage.getCmd(), 0, "", "", d2 + "rid" + recordId, chatResponsedMessage.getErrNo(), chatResponsedMessage.getErrMsg(), currentTimeMillis));
                        this.f1825a.c(chatMessage);
                        if (chatResponsedMessage.getErrNo() > 0) {
                            msglistActivity = this.f1825a.o;
                            msglistActivity.showToast(chatResponsedMessage.getErrMsg());
                            if (chatMessage.getRecordId() != chatResponsedMessage.getRecordId()) {
                                chatResponsedMessage.setRecordId(chatMessage.getRecordId());
                                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(chatResponsedMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", null, chatResponsedMessage.getErrNo(), chatResponsedMessage.getErrMsg()));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - chatMessage.getLogTime();
                    long recordId2 = chatResponsedMessage.getRecordId();
                    long msgId = chatResponsedMessage.getMsgId();
                    d = this.f1825a.d(chatMessage);
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(chatResponsedMessage.getCmd(), 0, "", "", "rid = " + recordId2 + "msgId = " + msgId + d, chatResponsedMessage.getErrNo(), chatResponsedMessage.getErrMsg(), currentTimeMillis2));
                    if (chatMessage.getRecordId() != chatResponsedMessage.getRecordId()) {
                        chatResponsedMessage.setRecordId(chatMessage.getRecordId());
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(chatResponsedMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", null, chatResponsedMessage.getErrNo(), chatResponsedMessage.getErrMsg()));
                    }
                    this.f1825a.a(chatResponsedMessage);
                }
            } else if (message.getCmd() == -103) {
                if (!(message instanceof LoadDraftResponsedMessage)) {
                    com.baidu.adp.lib.h.e.a("transform to LoadDraftResponsedMessage error");
                    return;
                }
                LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) message;
                groupData3 = this.f1825a.e;
                if (groupData3 == null || loadDraftResponsedMessage == null) {
                    com.baidu.adp.lib.h.e.a("group ==null or LoadDraftResponsedMessage == null");
                } else if (loadDraftResponsedMessage.hasError()) {
                    com.baidu.adp.lib.h.e.a("LoadDraftResponedMessage hasError");
                } else {
                    String groupId2 = loadDraftResponsedMessage.getGroupId();
                    groupData4 = this.f1825a.e;
                    if (groupId2.equals(String.valueOf(groupData4.getGroupId()))) {
                        this.f1825a.mLoadDataMode = 8;
                        gVar3 = this.f1825a.mLoadDataCallBack;
                        gVar3.a(loadDraftResponsedMessage.getDraft());
                    }
                }
            } else if (message.getCmd() == -105) {
                if (!(message instanceof LoadHistoryResponsedMessage)) {
                    com.baidu.adp.lib.h.e.a("transform to LoadHistoryResponsedMessage error");
                    return;
                }
                LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) message;
                groupData = this.f1825a.e;
                if (groupData == null || loadHistoryResponsedMessage == null) {
                    com.baidu.adp.lib.h.e.a("group ==null or LoadHistoryResponsedMessage == null");
                } else if (loadHistoryResponsedMessage.hasError()) {
                    com.baidu.adp.lib.h.e.a("LoadHistoryResponsedMessage hasError");
                } else {
                    String groupId3 = loadHistoryResponsedMessage.getGroupId();
                    groupData2 = this.f1825a.e;
                    if (groupId3.equals(String.valueOf(groupData2.getGroupId()))) {
                        msgPageData = this.f1825a.i;
                        a2 = this.f1825a.a(msgPageData.getChatMessages(), (LinkedList) loadHistoryResponsedMessage.getMsgList());
                        if (a2 > 0) {
                            msgPageData7 = this.f1825a.i;
                            msgPageData7.setIsNewAdd(true);
                            msgPageData8 = this.f1825a.i;
                            msgPageData8.setNewAddNum(a2);
                        } else {
                            msgPageData2 = this.f1825a.i;
                            msgPageData2.setIsNewAdd(false);
                            msgPageData3 = this.f1825a.i;
                            msgPageData3.setNewAddNum(0);
                        }
                        MsglistModel msglistModel3 = this.f1825a;
                        msgPageData4 = this.f1825a.i;
                        msglistModel3.a(msgPageData4.getChatMessages());
                        if (loadHistoryResponsedMessage.getIsFirst()) {
                            msgPageData6 = this.f1825a.i;
                            if (msgPageData6.getIsNewAdd()) {
                                this.f1825a.mLoadDataMode = 1;
                                gVar2 = this.f1825a.mLoadDataCallBack;
                                gVar2.a(null);
                                return;
                            }
                            return;
                        }
                        msgPageData5 = this.f1825a.i;
                        if (msgPageData5.getIsNewAdd()) {
                            this.f1825a.mLoadDataMode = 2;
                            gVar = this.f1825a.mLoadDataCallBack;
                            gVar.a(null);
                        }
                    }
                }
            }
        }
    }
}
