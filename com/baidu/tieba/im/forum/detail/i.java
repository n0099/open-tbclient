package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h baD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i, int i2) {
        super(i, i2);
        this.baD = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        if (responsedMessage == null) {
            lVar5 = this.baD.baC;
            if (lVar5 != null) {
                lVar6 = this.baD.baC;
                lVar6.gH(null);
            }
        } else if (responsedMessage.hasError()) {
            lVar3 = this.baD.baC;
            if (lVar3 != null) {
                lVar4 = this.baD.baC;
                lVar4.gH(responsedMessage.getErrorString());
            }
        } else {
            if (responsedMessage instanceof ForumDetailHttpResponse) {
                lVar2 = this.baD.baC;
                lVar2.a((ForumDetailHttpResponse) responsedMessage);
            }
            if (responsedMessage instanceof ForumDetailSocketResponse) {
                lVar = this.baD.baC;
                lVar.a((ForumDetailSocketResponse) responsedMessage);
            }
        }
    }
}
