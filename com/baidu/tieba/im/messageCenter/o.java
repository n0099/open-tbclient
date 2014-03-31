package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.InvokeUpdateActivityIsOpenConfig;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
/* loaded from: classes.dex */
final class o implements com.baidu.adp.framework.task.a<InvokeUpdateActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<Boolean> a(com.baidu.adp.framework.message.a<InvokeUpdateActivityIsOpenConfig> aVar) {
        if (aVar == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008005, Boolean.valueOf(UpdatesActivity.a));
    }
}
