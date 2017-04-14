package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.SnapChatMsgHelper;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegister;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a.b bVar;
        a.b bVar2;
        a.b bVar3;
        a.b bVar4;
        a.b bVar5;
        a.b bVar6;
        a.b bVar7;
        if (customResponsedMessage != null && (customResponsedMessage instanceof GroupMsgData)) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (groupMsgData.getGroupInfo() != null) {
                if (groupMsgData.getGroupInfo().getGroupId() == 0) {
                    BdLog.e("groupMsgData.getGroupInfo().getGroupId() == 0");
                }
                String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (!TextUtils.isEmpty(valueOf)) {
                    ImMessageCenterPojo Y = b.asc().Y(valueOf, customType);
                    if (groupMsgData.getCmd() != 2012125) {
                        if (groupMsgData.getCmd() != 2012127) {
                            if (groupMsgData.getCmd() != 2012124) {
                                if (groupMsgData.getCmd() != 2012123) {
                                    if (groupMsgData.getCmd() != 2012121) {
                                        if (groupMsgData.getCmd() != 2012122) {
                                            if (groupMsgData.getCmd() != 2012120) {
                                                if (groupMsgData.getCmd() == 2012128) {
                                                    if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                                        b.asc().a(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.deu));
                                                        return;
                                                    }
                                                    return;
                                                } else if (groupMsgData.getCmd() == 2012129) {
                                                    if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                                        ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                                                        if (!chatMessage.isPushForOperateAccount()) {
                                                            b.asc().a(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (groupMsgData.getCmd() == 2012126) {
                                                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                                        com.baidu.tieba.im.chat.receiveChatMsgHandler.p.a(groupMsgData, Y, new y(this));
                                                    } else {
                                                        long[] b = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anT().b(groupMsgData);
                                                        if (b != null && b.length == 2) {
                                                            if (b[0] <= 0 && b[1] > 0) {
                                                                if (b[0] == 12) {
                                                                    b.asc().a(8, b[1], String.valueOf(12));
                                                                } else if (b[0] == 11) {
                                                                    b.asc().a(7, b[1], String.valueOf(11));
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anT().c(groupMsgData);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            bVar = this.this$0.dbt;
                                            com.baidu.tieba.im.chat.receiveChatMsgHandler.n.a(groupMsgData, Y, bVar);
                                            return;
                                        }
                                        bVar2 = this.this$0.dbw;
                                        SnapChatMsgHelper.a(groupMsgData, Y, bVar2);
                                        return;
                                    }
                                    bVar3 = this.this$0.dby;
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.j.b(groupMsgData, Y, bVar3);
                                    return;
                                }
                                bVar4 = this.this$0.dbx;
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.h.b(groupMsgData, Y, bVar4);
                                return;
                            }
                            bVar5 = this.this$0.dbv;
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.f.a(groupMsgData, Y, bVar5);
                            return;
                        }
                        bVar6 = this.this$0.dbu;
                        com.baidu.tieba.im.chat.receiveChatMsgHandler.d.a(groupMsgData, Y, bVar6);
                        return;
                    }
                    bVar7 = this.this$0.dbs;
                    com.baidu.tieba.im.chat.receiveChatMsgHandler.b.a(groupMsgData, Y, bVar7);
                }
            }
        }
    }
}
