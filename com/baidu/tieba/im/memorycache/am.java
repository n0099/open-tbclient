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
    private final /* synthetic */ ImMessageCenterPojo doH;
    private final /* synthetic */ SocketResponsedMessage doJ;
    final /* synthetic */ al doQ;
    private final /* synthetic */ ChatMessage doR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.doQ = alVar;
        this.doH = imMessageCenterPojo;
        this.doR = chatMessage;
        this.doJ = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.auF().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.auF().auG();
                com.baidu.tieba.im.db.i.auK().a(this.doH, 3);
                if (this.doH.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.auQ().a(this.doR.getUserId(), this.doR.getToUserId(), String.valueOf(this.doR.getRecordId()), String.valueOf(this.doR.getMsgId()), this.doR.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.auP().a(this.doR.getUserId(), this.doR.getToUserId(), String.valueOf(this.doR.getRecordId()), String.valueOf(this.doR.getMsgId()), this.doR.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.doJ);
            }
        }
        return null;
    }
}
