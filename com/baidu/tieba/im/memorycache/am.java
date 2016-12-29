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
    private final /* synthetic */ ImMessageCenterPojo cTC;
    private final /* synthetic */ SocketResponsedMessage cTE;
    final /* synthetic */ al cTL;
    private final /* synthetic */ ChatMessage cTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cTL = alVar;
        this.cTC = imMessageCenterPojo;
        this.cTM = chatMessage;
        this.cTE = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.ape().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.ape().apf();
                com.baidu.tieba.im.db.i.apj().a(this.cTC, 3);
                if (this.cTC.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.app().a(this.cTM.getUserId(), this.cTM.getToUserId(), String.valueOf(this.cTM.getRecordId()), String.valueOf(this.cTM.getMsgId()), this.cTM.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.apo().a(this.cTM.getUserId(), this.cTM.getToUserId(), String.valueOf(this.cTM.getRecordId()), String.valueOf(this.cTM.getMsgId()), this.cTM.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cTE);
            }
        }
        return null;
    }
}
