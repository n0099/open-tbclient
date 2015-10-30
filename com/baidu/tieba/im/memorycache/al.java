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
    final /* synthetic */ ak bEG;
    private final /* synthetic */ ChatMessage bEH;
    private final /* synthetic */ ImMessageCenterPojo bEx;
    private final /* synthetic */ SocketResponsedMessage bEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bEG = akVar;
        this.bEx = imMessageCenterPojo;
        this.bEH = chatMessage;
        this.bEz = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.TF().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.TF().TG();
                com.baidu.tieba.im.db.i.TK().a(this.bEx, 3);
                if (this.bEx.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.TQ().a(this.bEH.getUserId(), this.bEH.getToUserId(), String.valueOf(this.bEH.getRecordId()), String.valueOf(this.bEH.getMsgId()), this.bEH.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.TP().a(this.bEH.getUserId(), this.bEH.getToUserId(), String.valueOf(this.bEH.getRecordId()), String.valueOf(this.bEH.getMsgId()), this.bEH.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bEz);
            }
        }
        return null;
    }
}
