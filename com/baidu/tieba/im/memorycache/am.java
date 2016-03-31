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
    private final /* synthetic */ ImMessageCenterPojo cmK;
    private final /* synthetic */ SocketResponsedMessage cmM;
    final /* synthetic */ al cmT;
    private final /* synthetic */ ChatMessage cmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.cmT = alVar;
        this.cmK = imMessageCenterPojo;
        this.cmU = chatMessage;
        this.cmM = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aet().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.aet().aeu();
                com.baidu.tieba.im.db.i.aey().a(this.cmK, 3);
                if (this.cmK.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.aeE().a(this.cmU.getUserId(), this.cmU.getToUserId(), String.valueOf(this.cmU.getRecordId()), String.valueOf(this.cmU.getMsgId()), this.cmU.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.aeD().a(this.cmU.getUserId(), this.cmU.getToUserId(), String.valueOf(this.cmU.getRecordId()), String.valueOf(this.cmU.getMsgId()), this.cmU.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.cmM);
            }
        }
        return null;
    }
}
