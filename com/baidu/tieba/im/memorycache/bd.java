package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseGroupInfoMessage responseGroupInfoMessage;
        String valueOf;
        ImMessageCenterPojo B;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103004 && (responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage) != null && responseGroupInfoMessage.getData() != null) {
            com.baidu.tieba.im.message.i data = responseGroupInfoMessage.getData();
            if (data.getGroup() != null && (B = c.PN().B((valueOf = String.valueOf(data.getGroup().getGroupId())), 1)) != null) {
                if (TextUtils.isEmpty(B.getGroup_head()) || TextUtils.isEmpty(B.getGroup_name())) {
                    String name = data.getGroup().getName();
                    c.PN().as(valueOf, data.getGroup().getPortrait());
                    c.PN().at(valueOf, name);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new be(this, B));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        }
    }
}
