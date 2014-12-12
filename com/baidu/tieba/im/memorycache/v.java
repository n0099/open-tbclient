package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class v implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ u bhp;
    private final /* synthetic */ ImMessageCenterPojo bhq;
    private final /* synthetic */ ChatMessage bhr;
    private final /* synthetic */ SocketResponsedMessage bhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bhp = uVar;
        this.bhq = imMessageCenterPojo;
        this.bhr = chatMessage;
        this.bhs = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.My().Mz();
            com.baidu.tieba.im.db.k.MD().a(this.bhq, 3);
            com.baidu.tieba.im.db.c.Mu().b(this.bhr.getGroupId(), String.valueOf(this.bhr.getRecordId()), String.valueOf(this.bhr.getMsgId()), this.bhr.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.My().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bhs);
    }
}
