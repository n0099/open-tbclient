package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
        com.baidu.tieba.im.message.e data;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.a != null) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.im.message.h hVar : data.a) {
                c.b().a(hVar.a, hVar.b, hVar.c);
            }
            if (memoryClearStrangerItemsMessage.isAllClear()) {
                c.b().b("-1001", -7, false);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new x(this, arrayList, memoryClearStrangerItemsMessage));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
