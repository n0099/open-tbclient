package com.baidu.tbadk.coreExtra.view;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<j> run(CustomMessage<Activity> customMessage) {
        if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Activity)) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_PLAY_IMAGE, new LivePlayingImageView(customMessage.getData()));
    }
}
