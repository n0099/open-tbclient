package com.baidu.tieba.im.messageCenter;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.y;
/* loaded from: classes.dex */
class o implements CustomMessageTask.CustomRunnable<y> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Fragment> run(CustomMessage<y> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            Fragment a = customMessage.getData().a();
            if (a instanceof com.baidu.tieba.im.chat.notify.b) {
                ((com.baidu.tieba.im.chat.notify.b) a).a();
            }
        }
        return null;
    }
}
