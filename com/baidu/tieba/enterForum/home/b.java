package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aFd = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        String errorString;
        BaseFragmentActivity baseFragmentActivity;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            cVar = this.aFd.aEM;
            if (cVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                eVar = this.aFd.aEL;
                eVar.Ix();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        baseFragmentActivity = this.aFd.azk;
                        errorString = baseFragmentActivity.getResources().getString(t.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.aFd.showToast(errorString);
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    cVar3 = this.aFd.aEM;
                    cVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    cVar2 = this.aFd.aEM;
                    cVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
