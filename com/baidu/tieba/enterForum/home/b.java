package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            enterForumModel = CoreSearchRequestStatic.bEv;
            if (enterForumModel.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    enterForumModel3 = CoreSearchRequestStatic.bEv;
                    enterForumModel3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    enterForumModel2 = CoreSearchRequestStatic.bEv;
                    enterForumModel2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
