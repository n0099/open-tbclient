package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.data.l> {
    final /* synthetic */ aj aee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(aj ajVar) {
        this.aee = ajVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.data.l> customMessage) {
        UtilHelper.showYYNotification(TbadkApplication.m251getInst(), customMessage.getData(), 13);
        return null;
    }
}
