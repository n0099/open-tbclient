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
    private final /* synthetic */ ImMessageCenterPojo ccf;
    private final /* synthetic */ SocketResponsedMessage cch;
    final /* synthetic */ al cco;
    private final /* synthetic */ ChatMessage ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cco = alVar;
        this.ccf = imMessageCenterPojo;
        this.ccp = chatMessage;
        this.cch = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aaX().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aaX().aaY();
                com.baidu.tieba.im.db.i.abc().a(this.ccf, 3);
                if (this.ccf.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.abi().a(this.ccp.getUserId(), this.ccp.getToUserId(), String.valueOf(this.ccp.getRecordId()), String.valueOf(this.ccp.getMsgId()), this.ccp.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.abh().a(this.ccp.getUserId(), this.ccp.getToUserId(), String.valueOf(this.ccp.getRecordId()), String.valueOf(this.ccp.getMsgId()), this.ccp.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cch);
            }
        }
        return null;
    }
}
