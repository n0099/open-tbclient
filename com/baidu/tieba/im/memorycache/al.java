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
    private final /* synthetic */ ImMessageCenterPojo bAD;
    private final /* synthetic */ SocketResponsedMessage bAF;
    final /* synthetic */ ak bAL;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bAL = akVar;
        this.bAD = imMessageCenterPojo;
        this.val$chatMessage = chatMessage;
        this.bAF = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.SZ().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.SZ().Ta();
                com.baidu.tieba.im.db.i.Te().a(this.bAD, 3);
                if (this.bAD.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.Tk().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.Tj().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bAF);
            }
        }
        return null;
    }
}
