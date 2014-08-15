package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CustomMessageTask.CustomRunnable<Intent> {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
        UtilHelper.commenDealIntent(TbadkApplication.m252getInst().getApp(), customMessage.getData());
        return null;
    }
}
