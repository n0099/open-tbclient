package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
/* loaded from: classes.dex */
class ao implements CustomMessageTask.CustomRunnable<OfficialBarTipActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialBarTipActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), OfficialBarTipActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
