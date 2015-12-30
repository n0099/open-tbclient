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
public class am implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bXL;
    private final /* synthetic */ SocketResponsedMessage bXN;
    final /* synthetic */ al bXU;
    private final /* synthetic */ ChatMessage bXV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bXU = alVar;
        this.bXL = imMessageCenterPojo;
        this.bXV = chatMessage;
        this.bXN = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Ym().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.Ym().Yn();
                com.baidu.tieba.im.db.i.Yr().a(this.bXL, 3);
                if (this.bXL.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.Yx().a(this.bXV.getUserId(), this.bXV.getToUserId(), String.valueOf(this.bXV.getRecordId()), String.valueOf(this.bXV.getMsgId()), this.bXV.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.Yw().a(this.bXV.getUserId(), this.bXV.getToUserId(), String.valueOf(this.bXV.getRecordId()), String.valueOf(this.bXV.getMsgId()), this.bXV.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bXN);
            }
        }
        return null;
    }
}
