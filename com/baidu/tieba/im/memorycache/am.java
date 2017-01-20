package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo daM;
    private final /* synthetic */ SocketResponsedMessage daO;
    final /* synthetic */ al daV;
    private final /* synthetic */ ChatMessage daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.daV = alVar;
        this.daM = imMessageCenterPojo;
        this.daW = chatMessage;
        this.daO = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aql().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aql().aqm();
                com.baidu.tieba.im.db.i.aqq().a(this.daM, 3);
                if (this.daM.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.aqw().a(this.daW.getUserId(), this.daW.getToUserId(), String.valueOf(this.daW.getRecordId()), String.valueOf(this.daW.getMsgId()), this.daW.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.aqv().a(this.daW.getUserId(), this.daW.getToUserId(), String.valueOf(this.daW.getRecordId()), String.valueOf(this.daW.getMsgId()), this.daW.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.daO);
            }
        }
        return null;
    }
}
