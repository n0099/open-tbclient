package com.baidu.tbadk.coreExtra.view;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<q> run(CustomMessage<Activity> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Activity)) {
            return null;
        }
        return new CustomResponsedMessage<>(2001269, new LivePlayingImageView(customMessage.getData()));
    }
}
