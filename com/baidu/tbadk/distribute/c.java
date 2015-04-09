package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a ahM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i, int i2) {
        super(i, i2);
        this.ahM = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && responsedMessage.hasError()) {
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (!(extra instanceof DistributeRequest)) {
                return;
            }
            this.ahM.l(((DistributeRequest) extra).getAdReqList());
        }
    }
}
