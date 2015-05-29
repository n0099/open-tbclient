package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
        com.baidu.tieba.im.message.e data;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.datas != null) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.im.message.h hVar : data.datas) {
                c.TD().d(hVar.id, hVar.customGroupType, hVar.ajd);
            }
            if (memoryClearStrangerItemsMessage.isAllClear()) {
                c.TD().e("-1001", -7, false);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bw(this, arrayList, memoryClearStrangerItemsMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
