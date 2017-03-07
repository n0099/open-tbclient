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
    private final /* synthetic */ ImMessageCenterPojo dde;
    private final /* synthetic */ SocketResponsedMessage ddg;
    final /* synthetic */ al ddn;
    private final /* synthetic */ ChatMessage ddo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.ddn = alVar;
        this.dde = imMessageCenterPojo;
        this.ddo = chatMessage;
        this.ddg = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.apF().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.apF().apG();
                com.baidu.tieba.im.db.i.apK().a(this.dde, 3);
                if (this.dde.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.l.apQ().a(this.ddo.getUserId(), this.ddo.getToUserId(), String.valueOf(this.ddo.getRecordId()), String.valueOf(this.ddo.getMsgId()), this.ddo.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.k.apP().a(this.ddo.getUserId(), this.ddo.getToUserId(), String.valueOf(this.ddo.getRecordId()), String.valueOf(this.ddo.getMsgId()), this.ddo.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.ddg);
            }
        }
        return null;
    }
}
