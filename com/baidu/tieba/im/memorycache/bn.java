package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegisterStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage)) {
            ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage onlineToDbCustomMessage = (ImMemoryCacheRegisterStatic.OnlineToDbCustomMessage) customMessage;
            try {
                com.baidu.tieba.im.db.g.My().Mz();
                if (onlineToDbCustomMessage.needCreateGroupList != null) {
                    com.baidu.tieba.im.db.c.Mu().an(onlineToDbCustomMessage.needCreateGroupList);
                    for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                        com.baidu.tieba.im.db.k.MD().a(imMessageCenterPojo);
                    }
                }
                if (onlineToDbCustomMessage.systemGroup != null) {
                    com.baidu.tieba.im.db.k.MD().a(onlineToDbCustomMessage.systemGroup);
                }
                if (onlineToDbCustomMessage.privateChatGroup != null) {
                    com.baidu.tieba.im.db.k.MD().a(onlineToDbCustomMessage.privateChatGroup);
                }
                if (onlineToDbCustomMessage.notifyGroup != null) {
                    com.baidu.tieba.im.db.k.MD().a(onlineToDbCustomMessage.notifyGroup);
                }
                if (onlineToDbCustomMessage.yyGroupList != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                        if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                            com.baidu.tieba.im.db.k.MD().a(imMessageCenterPojo2);
                        } else {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.s.KS().h(imMessageCenterPojo2.getGid(), com.baidu.tieba.im.util.h.ag(imMessageCenterPojo2.getPulled_msgId()));
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.My().endTransaction();
            }
        }
        return null;
    }
}
