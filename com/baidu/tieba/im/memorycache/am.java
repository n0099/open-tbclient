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
    private final /* synthetic */ ImMessageCenterPojo cXT;
    private final /* synthetic */ SocketResponsedMessage cXV;
    final /* synthetic */ al cYc;
    private final /* synthetic */ ChatMessage cYd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cYc = alVar;
        this.cXT = imMessageCenterPojo;
        this.cYd = chatMessage;
        this.cXV = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.ans().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.ans().ant();
                com.baidu.tieba.im.db.j.anx().a(this.cXT, 3);
                if (this.cXT.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.m.anD().a(this.cYd.getUserId(), this.cYd.getToUserId(), String.valueOf(this.cYd.getRecordId()), String.valueOf(this.cYd.getMsgId()), this.cYd.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.l.anC().a(this.cYd.getUserId(), this.cYd.getToUserId(), String.valueOf(this.cYd.getRecordId()), String.valueOf(this.cYd.getMsgId()), this.cYd.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cXV);
            }
        }
        return null;
    }
}
