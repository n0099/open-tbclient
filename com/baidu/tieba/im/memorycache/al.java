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
    private final /* synthetic */ ImMessageCenterPojo bTZ;
    private final /* synthetic */ SocketResponsedMessage bUb;
    final /* synthetic */ ak bUi;
    private final /* synthetic */ ChatMessage bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bUi = akVar;
        this.bTZ = imMessageCenterPojo;
        this.bUj = chatMessage;
        this.bUb = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Xg().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.Xg().Xh();
                com.baidu.tieba.im.db.i.Xl().a(this.bTZ, 3);
                if (this.bTZ.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.Xr().a(this.bUj.getUserId(), this.bUj.getToUserId(), String.valueOf(this.bUj.getRecordId()), String.valueOf(this.bUj.getMsgId()), this.bUj.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.Xq().a(this.bUj.getUserId(), this.bUj.getToUserId(), String.valueOf(this.bUj.getRecordId()), String.valueOf(this.bUj.getMsgId()), this.bUj.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bUb);
            }
        }
        return null;
    }
}
