package com.baidu.tieba.discover;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<BaseFragment> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, new b());
    }
}
