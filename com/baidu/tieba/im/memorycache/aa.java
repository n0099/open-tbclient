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
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar2;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar3;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar4;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar5;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar6;
        com.baidu.tieba.im.chat.receiveChatMsgHandler.b bVar7;
        if (customResponsedMessage != null && (customResponsedMessage instanceof GroupMsgData)) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (groupMsgData.getGroupInfo() != null) {
                if (groupMsgData.getGroupInfo().getGroupId() == 0) {
                    BdLog.e("groupMsgData.getGroupInfo().getGroupId() == 0");
                }
                String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (!TextUtils.isEmpty(valueOf)) {
                    ImMessageCenterPojo a = c.b().a(valueOf, customType);
                    if (groupMsgData.getCmd() != 2013005) {
                        if (groupMsgData.getCmd() != 2013007) {
                            if (groupMsgData.getCmd() != 2013004) {
                                if (groupMsgData.getCmd() != 2013003) {
                                    if (groupMsgData.getCmd() != 2013001) {
                                        if (groupMsgData.getCmd() != 2013002) {
                                            if (groupMsgData.getCmd() != 2013000) {
                                                if (groupMsgData.getCmd() == 2013006) {
                                                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                                        com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a(groupMsgData, a, new ab(this));
                                                    } else {
                                                        long[] a2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().a(groupMsgData);
                                                        if (a2 != null && a2.length == 2) {
                                                            if (a2[0] <= 0 && a2[1] > 0) {
                                                                if (a2[0] == 12) {
                                                                    c.b().a(8, a2[1], String.valueOf(12));
                                                                } else if (a2[0] == 11) {
                                                                    c.b().a(7, a2[1], String.valueOf(11));
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().b(groupMsgData);
                                                    return;
                                                }
                                                return;
                                            }
                                            bVar = this.a.C;
                                            com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(groupMsgData, a, bVar);
                                            return;
                                        }
                                        bVar2 = this.a.F;
                                        SnapChatMsgHelper.b(groupMsgData, a, bVar2);
                                        return;
                                    }
                                    bVar3 = this.a.H;
                                    com.baidu.tieba.im.chat.receiveChatMsgHandler.l.a(groupMsgData, a, bVar3);
                                    return;
                                }
                                bVar4 = this.a.G;
                                com.baidu.tieba.im.chat.receiveChatMsgHandler.j.a(groupMsgData, a, bVar4);
                                return;
                            }
                            bVar5 = this.a.E;
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.h.a(groupMsgData, a, bVar5);
                            return;
                        }
                        bVar6 = this.a.D;
                        com.baidu.tieba.im.chat.receiveChatMsgHandler.f.a(groupMsgData, a, bVar6);
                        return;
                    }
                    bVar7 = this.a.B;
                    com.baidu.tieba.im.chat.receiveChatMsgHandler.d.a(groupMsgData, a, bVar7);
                }
            }
        }
    }
}
