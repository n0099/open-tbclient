package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegisterStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage)) {
            ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage onlineToDbCustomMessage = (ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage) customMessage;
            try {
                com.baidu.tieba.im.db.g.Ua().Ub();
                if (onlineToDbCustomMessage.needCreateGroupList != null) {
                    com.baidu.tieba.im.db.c.TW().aK(onlineToDbCustomMessage.needCreateGroupList);
                    for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                        com.baidu.tieba.im.db.i.Uf().c(imMessageCenterPojo);
                    }
                }
                if (onlineToDbCustomMessage.systemGroup != null) {
                    com.baidu.tieba.im.db.i.Uf().c(onlineToDbCustomMessage.systemGroup);
                }
                if (onlineToDbCustomMessage.privateChatGroup != null) {
                    com.baidu.tieba.im.db.i.Uf().c(onlineToDbCustomMessage.privateChatGroup);
                }
                if (onlineToDbCustomMessage.officialChatGroup != null) {
                    com.baidu.tieba.im.db.i.Uf().c(onlineToDbCustomMessage.officialChatGroup);
                }
                if (onlineToDbCustomMessage.notifyGroup != null) {
                    com.baidu.tieba.im.db.i.Uf().c(onlineToDbCustomMessage.notifyGroup);
                }
                if (onlineToDbCustomMessage.yyGroupList != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                        if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                            com.baidu.tieba.im.db.i.Uf().c(imMessageCenterPojo2);
                        } else {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.p.St().i(imMessageCenterPojo2.getGid(), com.baidu.tieba.im.util.g.aK(imMessageCenterPojo2.getPulled_msgId()));
                        }
                    }
                }
                if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo3 : onlineToDbCustomMessage.needDeleteGroupList) {
                        if (imMessageCenterPojo3 != null) {
                            com.baidu.tieba.im.db.i.Uf().E(imMessageCenterPojo3.getGid(), imMessageCenterPojo3.getCustomGroupType());
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Ua().endTransaction();
            }
        }
        return null;
    }
}
