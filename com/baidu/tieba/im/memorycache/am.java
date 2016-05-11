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
    private final /* synthetic */ ImMessageCenterPojo cnH;
    private final /* synthetic */ SocketResponsedMessage cnJ;
    final /* synthetic */ al cnQ;
    private final /* synthetic */ ChatMessage cnR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cnQ = alVar;
        this.cnH = imMessageCenterPojo;
        this.cnR = chatMessage;
        this.cnJ = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aet().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aet().aeu();
                com.baidu.tieba.im.db.i.aex().a(this.cnH, 3);
                if (this.cnH.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.aeD().a(this.cnR.getUserId(), this.cnR.getToUserId(), String.valueOf(this.cnR.getRecordId()), String.valueOf(this.cnR.getMsgId()), this.cnR.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.aeC().a(this.cnR.getUserId(), this.cnR.getToUserId(), String.valueOf(this.cnR.getRecordId()), String.valueOf(this.cnR.getMsgId()), this.cnR.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cnJ);
            }
        }
        return null;
    }
}
