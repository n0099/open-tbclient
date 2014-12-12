package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.aZh = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        if (responsedMessage == null) {
            jVar5 = this.aZh.aZg;
            if (jVar5 != null) {
                jVar6 = this.aZh.aZg;
                jVar6.gF(null);
            }
        } else if (responsedMessage.hasError()) {
            jVar3 = this.aZh.aZg;
            if (jVar3 != null) {
                jVar4 = this.aZh.aZg;
                jVar4.gF(responsedMessage.getErrorString());
            }
        } else {
            if (responsedMessage instanceof ForumDetailHttpResponse) {
                jVar2 = this.aZh.aZg;
                jVar2.a((ForumDetailHttpResponse) responsedMessage);
            }
            if (responsedMessage instanceof ForumDetailSocketResponse) {
                jVar = this.aZh.aZg;
                jVar.a((ForumDetailSocketResponse) responsedMessage);
            }
        }
    }
}
