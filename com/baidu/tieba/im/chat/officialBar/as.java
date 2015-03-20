package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        return new CustomResponsedMessage<>(2001296, Integer.valueOf(com.baidu.tieba.u.icon_im_subscribe));
    }
}
