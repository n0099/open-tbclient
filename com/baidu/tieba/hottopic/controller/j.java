package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.hottopic.controller.i;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i bDp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, int i2) {
        super(i, i2);
        this.bDp = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        i.a aVar;
        BaseActivity baseActivity;
        if (responsedMessage != null) {
            if (((responsedMessage instanceof ResponseHttpHotTopicMessage) || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bDp.getUniqueId()) {
                if (responsedMessage.hasError()) {
                    if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                        baseActivity = this.bDp.aXA;
                        baseActivity.showToast(responsedMessage.getErrorString());
                    }
                    aVar = this.bDp.bDo;
                    aVar.a(false, null);
                    return;
                }
                this.bDp.h(responsedMessage);
            }
        }
    }
}
