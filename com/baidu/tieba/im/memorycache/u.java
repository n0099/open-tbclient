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
    final /* synthetic */ t bEw;
    private final /* synthetic */ ImMessageCenterPojo bEx;
    private final /* synthetic */ ChatMessage bEy;
    private final /* synthetic */ SocketResponsedMessage bEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bEw = tVar;
        this.bEx = imMessageCenterPojo;
        this.bEy = chatMessage;
        this.bEz = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.TF().TG();
            com.baidu.tieba.im.db.i.TK().a(this.bEx, 3);
            com.baidu.tieba.im.db.c.TB().c(this.bEy.getGroupId(), String.valueOf(this.bEy.getRecordId()), String.valueOf(this.bEy.getMsgId()), this.bEy.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.TF().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bEz);
    }
}
