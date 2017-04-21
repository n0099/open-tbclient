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
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ImMemoryCacheRegister imMemoryCacheRegister) {
        this.this$0 = imMemoryCacheRegister;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        List<ImMessageCenterPojo> atm;
        if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
            return null;
        }
        int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
        if (intValue == 3) {
            atm = b.atd().atl();
        } else if (intValue == 2) {
            atm = b.atd().atk();
        } else if (intValue == 1) {
            atm = b.atd().ati();
        } else {
            atm = intValue == 4 ? b.atd().atm() : null;
        }
        return new ResponsedMemoryListMessage(atm, intValue);
    }
}
