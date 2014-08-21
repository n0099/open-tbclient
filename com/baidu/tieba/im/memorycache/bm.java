package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
import protobuf.LiveGroupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinLiveGroupMessage) && !socketResponsedMessage.hasError()) {
            LiveGroupInfo liveGroupInfo = ((ResponseJoinLiveGroupMessage) socketResponsedMessage).getLiveGroupInfo();
            String valueOf = String.valueOf(liveGroupInfo.groupId);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(valueOf);
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.b(liveGroupInfo.lastMsgId.longValue()));
            imMessageCenterPojo.setCustomGroupType(9);
            imMessageCenterPojo.setIs_hidden(1);
            c.b().c(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bn(this, valueOf));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
