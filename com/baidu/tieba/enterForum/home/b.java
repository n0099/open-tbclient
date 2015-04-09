package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a aDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aDb = aVar;
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
            cVar = this.aDb.aCK;
            if (cVar.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                eVar = this.aDb.aCJ;
                eVar.Hx();
                if (responsedMessage.getError() == 1) {
                    ReloginManager.rw().e(null);
                } else if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        baseFragmentActivity = this.aDb.aCN;
                        errorString = baseFragmentActivity.getResources().getString(y.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.aDb.showToast(errorString);
                } else {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        cVar3 = this.aDb.aCK;
                        cVar3.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        cVar2 = this.aDb.aCK;
                        cVar2.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
