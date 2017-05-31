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
public class v implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ u ddr;
    private final /* synthetic */ ImMessageCenterPojo dds;
    private final /* synthetic */ ChatMessage ddt;
    private final /* synthetic */ SocketResponsedMessage ddv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.ddr = uVar;
        this.dds = imMessageCenterPojo;
        this.ddt = chatMessage;
        this.ddv = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.aos().aot();
            com.baidu.tieba.im.db.j.aox().a(this.dds, 3);
            com.baidu.tieba.im.db.c.aoo().b(this.ddt.getGroupId(), String.valueOf(this.ddt.getRecordId()), String.valueOf(this.ddt.getMsgId()), this.ddt.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.aos().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.ddv);
    }
}
