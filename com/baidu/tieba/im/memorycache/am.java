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
    private final /* synthetic */ ImMessageCenterPojo cVR;
    private final /* synthetic */ SocketResponsedMessage cVT;
    final /* synthetic */ al cWa;
    private final /* synthetic */ ChatMessage cWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cWa = alVar;
        this.cVR = imMessageCenterPojo;
        this.cWb = chatMessage;
        this.cVT = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.anu().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.anu().anv();
                com.baidu.tieba.im.db.i.anz().a(this.cVR, 3);
                if (this.cVR.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.anF().a(this.cWb.getUserId(), this.cWb.getToUserId(), String.valueOf(this.cWb.getRecordId()), String.valueOf(this.cWb.getMsgId()), this.cWb.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.anE().a(this.cWb.getUserId(), this.cWb.getToUserId(), String.valueOf(this.cWb.getRecordId()), String.valueOf(this.cWb.getMsgId()), this.cWb.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cVT);
            }
        }
        return null;
    }
}
