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
public class u implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ t bAC;
    private final /* synthetic */ ImMessageCenterPojo bAD;
    private final /* synthetic */ ChatMessage bAE;
    private final /* synthetic */ SocketResponsedMessage bAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bAC = tVar;
        this.bAD = imMessageCenterPojo;
        this.bAE = chatMessage;
        this.bAF = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.SZ().Ta();
            com.baidu.tieba.im.db.i.Te().a(this.bAD, 3);
            com.baidu.tieba.im.db.c.SV().c(this.bAE.getGroupId(), String.valueOf(this.bAE.getRecordId()), String.valueOf(this.bAE.getMsgId()), this.bAE.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.SZ().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bAF);
    }
}
