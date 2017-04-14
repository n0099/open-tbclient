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
    private final /* synthetic */ ImMessageCenterPojo dbA;
    private final /* synthetic */ SocketResponsedMessage dbC;
    final /* synthetic */ al dbJ;
    private final /* synthetic */ ChatMessage dbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.dbJ = alVar;
        this.dbA = imMessageCenterPojo;
        this.dbK = chatMessage;
        this.dbC = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.apy().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.apy().apz();
                com.baidu.tieba.im.db.j.apD().a(this.dbA, 3);
                if (this.dbA.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.m.apJ().a(this.dbK.getUserId(), this.dbK.getToUserId(), String.valueOf(this.dbK.getRecordId()), String.valueOf(this.dbK.getMsgId()), this.dbK.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.l.apI().a(this.dbK.getUserId(), this.dbK.getToUserId(), String.valueOf(this.dbK.getRecordId()), String.valueOf(this.dbK.getMsgId()), this.dbK.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.dbC);
            }
        }
        return null;
    }
}
