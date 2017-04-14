package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(l lVar, int i, int i2) {
        super(i, i2);
        this.bEU = lVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        String errorString;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            enterForumModel = this.bEU.bEC;
            if (enterForumModel.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.bEU.bEB.WG();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.bEU.aXt.getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.bEU.aXt.showToast(errorString);
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    enterForumModel3 = this.bEU.bEC;
                    enterForumModel3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    enterForumModel2 = this.bEU.bEC;
                    enterForumModel2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
