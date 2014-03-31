package com.baidu.tieba.im.messageCenter;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.InvokeNewImMessageCenterFragmentConfig;
/* loaded from: classes.dex */
final class l implements com.baidu.adp.framework.task.a<InvokeNewImMessageCenterFragmentConfig> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<Fragment> a(com.baidu.adp.framework.message.a<InvokeNewImMessageCenterFragmentConfig> aVar) {
        if (aVar == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008002, new com.baidu.tieba.im.chat.notify.b());
    }
}
