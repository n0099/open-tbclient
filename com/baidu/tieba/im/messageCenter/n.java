package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.InvokeValidateActivityIsOpenConfig;
import com.baidu.tieba.im.validate.ValidateActivity;
/* loaded from: classes.dex */
final class n implements com.baidu.adp.framework.task.a<InvokeValidateActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<Boolean> a(com.baidu.adp.framework.message.a<InvokeValidateActivityIsOpenConfig> aVar) {
        if (aVar == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008004, Boolean.valueOf(ValidateActivity.a));
    }
}
