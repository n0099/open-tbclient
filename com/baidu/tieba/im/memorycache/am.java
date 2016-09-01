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
    private final /* synthetic */ ImMessageCenterPojo dhB;
    private final /* synthetic */ SocketResponsedMessage dhD;
    final /* synthetic */ al dhK;
    private final /* synthetic */ ChatMessage dhL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.dhK = alVar;
        this.dhB = imMessageCenterPojo;
        this.dhL = chatMessage;
        this.dhD = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.asj().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.asj().ask();
                com.baidu.tieba.im.db.i.aso().a(this.dhB, 3);
                if (this.dhB.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.asu().a(this.dhL.getUserId(), this.dhL.getToUserId(), String.valueOf(this.dhL.getRecordId()), String.valueOf(this.dhL.getMsgId()), this.dhL.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.ast().a(this.dhL.getUserId(), this.dhL.getToUserId(), String.valueOf(this.dhL.getRecordId()), String.valueOf(this.dhL.getMsgId()), this.dhL.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.dhD);
            }
        }
        return null;
    }
}
