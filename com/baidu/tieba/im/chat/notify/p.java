package com.baidu.tieba.im.chat.notify;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeNewImMessageCenterFragmentConfig;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<InvokeNewImMessageCenterFragmentConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Fragment> run(CustomMessage<InvokeNewImMessageCenterFragmentConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008002, new g());
    }
}
