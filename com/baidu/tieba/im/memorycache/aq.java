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
public class aq implements CustomMessageTask.CustomRunnable<Integer> {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.a = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        List<ImMessageCenterPojo> j;
        if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
            return null;
        }
        int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
        if (intValue == 3) {
            j = c.b().i();
        } else if (intValue == 2) {
            j = c.b().h();
        } else if (intValue == 1) {
            j = c.b().f();
        } else {
            j = intValue == 4 ? c.b().j() : null;
        }
        return new ResponsedMemoryListMessage(j, intValue);
    }
}
