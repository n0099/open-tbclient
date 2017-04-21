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
    private final /* synthetic */ ImMessageCenterPojo ddT;
    private final /* synthetic */ SocketResponsedMessage ddV;
    final /* synthetic */ al dec;
    private final /* synthetic */ ChatMessage ded;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.dec = alVar;
        this.ddT = imMessageCenterPojo;
        this.ded = chatMessage;
        this.ddV = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aqz().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aqz().aqA();
                com.baidu.tieba.im.db.j.aqE().a(this.ddT, 3);
                if (this.ddT.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.m.aqK().a(this.ded.getUserId(), this.ded.getToUserId(), String.valueOf(this.ded.getRecordId()), String.valueOf(this.ded.getMsgId()), this.ded.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.l.aqJ().a(this.ded.getUserId(), this.ded.getToUserId(), String.valueOf(this.ded.getRecordId()), String.valueOf(this.ded.getMsgId()), this.ded.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.ddV);
            }
        }
        return null;
    }
}
