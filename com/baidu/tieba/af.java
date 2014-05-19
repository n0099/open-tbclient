package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.data.l> {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.a = adVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.data.l> customMessage) {
        UtilHelper.showNotification(TbadkApplication.m252getInst(), customMessage.getData(), 13);
        return null;
    }
}
