package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bn implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            String data = customMessage.getData();
            if (!TextUtils.isEmpty(data)) {
                bi.a(data, (com.baidu.tieba.im.a<Void>) null);
            }
        }
        return null;
    }
}
