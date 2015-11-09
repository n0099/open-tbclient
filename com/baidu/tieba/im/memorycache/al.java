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
    private final /* synthetic */ ImMessageCenterPojo bES;
    private final /* synthetic */ SocketResponsedMessage bEU;
    final /* synthetic */ ak bFb;
    private final /* synthetic */ ChatMessage bFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bFb = akVar;
        this.bES = imMessageCenterPojo;
        this.bFc = chatMessage;
        this.bEU = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Ua().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.Ua().Ub();
                com.baidu.tieba.im.db.i.Uf().a(this.bES, 3);
                if (this.bES.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.Ul().a(this.bFc.getUserId(), this.bFc.getToUserId(), String.valueOf(this.bFc.getRecordId()), String.valueOf(this.bFc.getMsgId()), this.bFc.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.Uk().a(this.bFc.getUserId(), this.bFc.getToUserId(), String.valueOf(this.bFc.getRecordId()), String.valueOf(this.bFc.getMsgId()), this.bFc.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bEU);
            }
        }
        return null;
    }
}
