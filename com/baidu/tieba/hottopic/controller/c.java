package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.hottopic.controller.b;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.bGF = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        b.a aVar;
        BaseActivity baseActivity;
        if (responsedMessage != null) {
            if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bGF.getUniqueId()) {
                if (responsedMessage.hasError()) {
                    if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                        baseActivity = this.bGF.bbA;
                        baseActivity.showToast(responsedMessage.getErrorString());
                    }
                    aVar = this.bGF.bGD;
                    aVar.a(false, null);
                    return;
                }
                this.bGF.h(responsedMessage);
            }
        }
    }
}
