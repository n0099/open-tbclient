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
    final /* synthetic */ u doG;
    private final /* synthetic */ ImMessageCenterPojo doH;
    private final /* synthetic */ ChatMessage doI;
    private final /* synthetic */ SocketResponsedMessage doJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.doG = uVar;
        this.doH = imMessageCenterPojo;
        this.doI = chatMessage;
        this.doJ = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.auF().auG();
            com.baidu.tieba.im.db.i.auK().a(this.doH, 3);
            com.baidu.tieba.im.db.c.auB().c(this.doI.getGroupId(), String.valueOf(this.doI.getRecordId()), String.valueOf(this.doI.getMsgId()), this.doI.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.auF().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.doJ);
    }
}
