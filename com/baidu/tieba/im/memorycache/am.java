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
    private final /* synthetic */ ImMessageCenterPojo dlp;
    private final /* synthetic */ SocketResponsedMessage dlr;
    final /* synthetic */ al dly;
    private final /* synthetic */ ChatMessage dlz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.dly = alVar;
        this.dlp = imMessageCenterPojo;
        this.dlz = chatMessage;
        this.dlr = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.asd().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.asd().ase();
                com.baidu.tieba.im.db.j.asi().a(this.dlp, 3);
                if (this.dlp.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.m.aso().a(this.dlz.getUserId(), this.dlz.getToUserId(), String.valueOf(this.dlz.getRecordId()), String.valueOf(this.dlz.getMsgId()), this.dlz.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.l.asn().a(this.dlz.getUserId(), this.dlz.getToUserId(), String.valueOf(this.dlz.getRecordId()), String.valueOf(this.dlz.getMsgId()), this.dlz.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.dlr);
            }
        }
        return null;
    }
}
