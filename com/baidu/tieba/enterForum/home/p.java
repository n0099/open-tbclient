package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(d dVar, int i, int i2) {
        super(i, i2);
        this.aMe = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        String errorString;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            cVar = this.aMe.aLO;
            if (cVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.aMe.aLN.Jg();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.aMe.aEO.getResources().getString(i.h.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.aMe.showToast(errorString);
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    cVar3 = this.aMe.aLO;
                    cVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    cVar2 = this.aMe.aLO;
                    cVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
