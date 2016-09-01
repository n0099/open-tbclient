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
public class v implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ u dhA;
    private final /* synthetic */ ImMessageCenterPojo dhB;
    private final /* synthetic */ ChatMessage dhC;
    private final /* synthetic */ SocketResponsedMessage dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.dhA = uVar;
        this.dhB = imMessageCenterPojo;
        this.dhC = chatMessage;
        this.dhD = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.asj().ask();
            com.baidu.tieba.im.db.i.aso().a(this.dhB, 3);
            com.baidu.tieba.im.db.c.asf().c(this.dhC.getGroupId(), String.valueOf(this.dhC.getRecordId()), String.valueOf(this.dhC.getMsgId()), this.dhC.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.asj().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.dhD);
    }
}
