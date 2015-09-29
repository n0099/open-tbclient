package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.hottopic.controller.a;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bon;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bon = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0056a interfaceC0056a;
        BaseActivity baseActivity;
        if (responsedMessage != null) {
            if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bon.getUniqueId()) {
                if (responsedMessage.hasError()) {
                    if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                        baseActivity = this.bon.aRT;
                        baseActivity.showToast(responsedMessage.getErrorString());
                    }
                    interfaceC0056a = this.bon.bol;
                    interfaceC0056a.a(false, null);
                    return;
                }
                this.bon.h(responsedMessage);
            }
        }
    }
}
