package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.g> {
    private com.baidu.tieba.im.pushNotify.o a;
    private int b;

    public b(com.baidu.tieba.im.pushNotify.o oVar, int i) {
        this.a = oVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.g> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.b);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        com.baidu.tieba.im.message.g data = customMessage.getData();
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.pushNotify.n b = this.a.b(str, data.b);
        if (b == null) {
            return null;
        }
        b.setDraft(data.a);
        this.a.a(b);
        return customResponsedMessage;
    }
}
