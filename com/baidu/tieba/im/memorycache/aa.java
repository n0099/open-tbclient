package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.SnapChatMsgHelper;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar2;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar3;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar4;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar5;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar6;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.c cVar7;
        if (customResponsedMessage != null && (customResponsedMessage instanceof GroupMsgData)) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (groupMsgData.getGroupInfo() != null) {
                if (groupMsgData.getGroupInfo().getGroupId() == 0) {
                    BdLog.e("groupMsgData.getGroupInfo().getGroupId() == 0");
                }
                String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (!TextUtils.isEmpty(valueOf)) {
                    ImMessageCenterPojo H = c.QO().H(valueOf, customType);
                    if (groupMsgData.getCmd() != 2013005) {
                        if (groupMsgData.getCmd() != 2013007) {
                            if (groupMsgData.getCmd() != 2013004) {
                                if (groupMsgData.getCmd() != 2013003) {
                                    if (groupMsgData.getCmd() != 2013001) {
                                        if (groupMsgData.getCmd() != 2013002) {
                                            if (groupMsgData.getCmd() != 2013000) {
                                                if (groupMsgData.getCmd() == 2013008) {
                                                    if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                                        c.QO().a(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.c.a.boy));
                                                        return;
                                                    }
                                                    return;
                                                } else if (groupMsgData.getCmd() == 2013006) {
                                                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                                        com.baidu.tieba.im.chat.receiveChatMsgHandler.s.a(groupMsgData, H, new ab(this));
                                                    } else {
                                                        long[] b = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Ln().b(groupMsgData);
                                                        if (b != null && b.length == 2) {
                                                            if (b[0] <= 0 && b[1] > 0) {
                                                                if (b[0] == 12) {
                                                                    c.QO().a(8, b[1], String.valueOf(12));
                                                                } else if (b[0] == 11) {
                                                                    c.QO().a(7, b[1], String.valueOf(11));
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Ln().c(groupMsgData);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            cVar = this.this$0.biE;
                                            com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a(groupMsgData, H, cVar);
                                            return;
                                        }
                                        cVar2 = this.this$0.biH;
                                        SnapChatMsgHelper.a(groupMsgData, H, cVar2);
                                        return;
                                    }
                                    cVar3 = this.this$0.biJ;
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.m.b(groupMsgData, H, cVar3);
                                    return;
                                }
                                cVar4 = this.this$0.biI;
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.k.b(groupMsgData, H, cVar4);
                                return;
                            }
                            cVar5 = this.this$0.biG;
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.i.a(groupMsgData, H, cVar5);
                            return;
                        }
                        cVar6 = this.this$0.biF;
                        com.baidu.tieba.im.chat.receiveChatMsgHandler.g.a(groupMsgData, H, cVar6);
                        return;
                    }
                    cVar7 = this.this$0.biD;
                    com.baidu.tieba.im.chat.receiveChatMsgHandler.e.a(groupMsgData, H, cVar7);
                }
            }
        }
    }
}
