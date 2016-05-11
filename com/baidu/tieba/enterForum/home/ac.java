package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(k kVar, int i, int i2) {
        super(i, i2);
        this.aXF = kVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        String errorString;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            cVar = this.aXF.aXl;
            if (cVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.aXF.aXk.Nn();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.aXF.aJw.getResources().getString(t.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.aXF.aJw.showToast(errorString);
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    cVar3 = this.aXF.aXl;
                    cVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    cVar2 = this.aXF.aXl;
                    cVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
