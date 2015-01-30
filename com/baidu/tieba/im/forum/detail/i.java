package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h baE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i, int i2) {
        super(i, i2);
        this.baE = hVar;
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
            lVar5 = this.baE.baD;
            if (lVar5 != null) {
                lVar6 = this.baE.baD;
                lVar6.gK(null);
            }
        } else if (responsedMessage.hasError()) {
            lVar3 = this.baE.baD;
            if (lVar3 != null) {
                lVar4 = this.baE.baD;
                lVar4.gK(responsedMessage.getErrorString());
            }
        } else {
            if (responsedMessage instanceof ForumDetailHttpResponse) {
                lVar2 = this.baE.baD;
                lVar2.a((ForumDetailHttpResponse) responsedMessage);
            }
            if (responsedMessage instanceof ForumDetailSocketResponse) {
                lVar = this.baE.baD;
                lVar.a((ForumDetailSocketResponse) responsedMessage);
            }
        }
    }
}
