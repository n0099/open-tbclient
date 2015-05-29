package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements CustomMessageTask.CustomRunnable<Integer> {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        List<ImMessageCenterPojo> TM;
        if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
            return null;
        }
        int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
        if (intValue == 3) {
            TM = c.TD().TL();
        } else if (intValue == 2) {
            TM = c.TD().TK();
        } else if (intValue == 1) {
            TM = c.TD().TI();
        } else {
            TM = intValue == 4 ? c.TD().TM() : null;
        }
        return new ResponsedMemoryListMessage(TM, intValue);
    }
}
