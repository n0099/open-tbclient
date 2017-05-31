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
    final /* synthetic */ al ddC;
    private final /* synthetic */ ChatMessage ddD;
    private final /* synthetic */ ImMessageCenterPojo dds;
    private final /* synthetic */ SocketResponsedMessage ddv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.ddC = alVar;
        this.dds = imMessageCenterPojo;
        this.ddD = chatMessage;
        this.ddv = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aos().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aos().aot();
                com.baidu.tieba.im.db.j.aox().a(this.dds, 3);
                if (this.dds.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.m.aoD().a(this.ddD.getUserId(), this.ddD.getToUserId(), String.valueOf(this.ddD.getRecordId()), String.valueOf(this.ddD.getMsgId()), this.ddD.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.l.aoC().a(this.ddD.getUserId(), this.ddD.getToUserId(), String.valueOf(this.ddD.getRecordId()), String.valueOf(this.ddD.getMsgId()), this.ddD.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.ddv);
            }
        }
        return null;
    }
}
