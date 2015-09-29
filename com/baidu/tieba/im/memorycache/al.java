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
public class al implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bEm;
    private final /* synthetic */ SocketResponsedMessage bEo;
    final /* synthetic */ ak bEv;
    private final /* synthetic */ ChatMessage bEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bEv = akVar;
        this.bEm = imMessageCenterPojo;
        this.bEw = chatMessage;
        this.bEo = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.TJ().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.TJ().TK();
                com.baidu.tieba.im.db.i.TO().a(this.bEm, 3);
                if (this.bEm.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.TU().a(this.bEw.getUserId(), this.bEw.getToUserId(), String.valueOf(this.bEw.getRecordId()), String.valueOf(this.bEw.getMsgId()), this.bEw.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.TT().a(this.bEw.getUserId(), this.bEw.getToUserId(), String.valueOf(this.bEw.getRecordId()), String.valueOf(this.bEw.getMsgId()), this.bEw.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bEo);
            }
        }
        return null;
    }
}
