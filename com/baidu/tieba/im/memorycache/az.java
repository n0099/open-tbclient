package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo D;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.im.message.i)) {
            com.baidu.tieba.im.message.i iVar = (com.baidu.tieba.im.message.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.id)) {
                if ((!TextUtils.isEmpty(iVar.head) || !TextUtils.isEmpty(iVar.name)) && (D = c.TE().D(iVar.id, iVar.customGroupType)) != null) {
                    String str = iVar.name;
                    String str2 = iVar.head;
                    if (!TextUtils.isEmpty(str)) {
                        c.TE().aH(iVar.id, str);
                    }
                    if (!TextUtils.isEmpty(iVar.head)) {
                        c.TE().aG(iVar.id, str2);
                    }
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new ba(this, D));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        }
    }
}
