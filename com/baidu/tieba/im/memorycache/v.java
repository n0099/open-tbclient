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
    final /* synthetic */ u cnG;
    private final /* synthetic */ ImMessageCenterPojo cnH;
    private final /* synthetic */ ChatMessage cnI;
    private final /* synthetic */ SocketResponsedMessage cnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cnG = uVar;
        this.cnH = imMessageCenterPojo;
        this.cnI = chatMessage;
        this.cnJ = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.aet().aeu();
            com.baidu.tieba.im.db.i.aex().a(this.cnH, 3);
            com.baidu.tieba.im.db.c.aep().b(this.cnI.getGroupId(), String.valueOf(this.cnI.getRecordId()), String.valueOf(this.cnI.getMsgId()), this.cnI.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.aet().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cnJ);
    }
}
