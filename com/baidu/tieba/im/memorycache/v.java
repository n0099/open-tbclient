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
    final /* synthetic */ u bkl;
    private final /* synthetic */ ImMessageCenterPojo bkm;
    private final /* synthetic */ ChatMessage bkn;
    private final /* synthetic */ SocketResponsedMessage bko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bkl = uVar;
        this.bkm = imMessageCenterPojo;
        this.bkn = chatMessage;
        this.bko = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.Qb().Qc();
            com.baidu.tieba.im.db.k.Qg().a(this.bkm, 3);
            com.baidu.tieba.im.db.c.PX().b(this.bkn.getGroupId(), String.valueOf(this.bkn.getRecordId()), String.valueOf(this.bkn.getMsgId()), this.bkn.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Qb().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bko);
    }
}
