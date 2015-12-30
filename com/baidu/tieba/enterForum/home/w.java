package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(i iVar, int i, int i2) {
        super(i, i2);
        this.aUE = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        String errorString;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            cVar = this.aUE.aUm;
            if (cVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.aUE.aUl.KK();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.aUE.aJl.getResources().getString(n.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.aUE.aJl.showToast(errorString);
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    cVar3 = this.aUE.aUm;
                    cVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    cVar2 = this.aUE.aUm;
                    cVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
