package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i iVar, int i, int i2) {
        super(i, i2);
        this.bTq = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        String errorString;
        View view;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            enterForumModel = this.bTq.bTd;
            if (enterForumModel.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.bTq.bTc.abq();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.bTq.aWN.getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.bTq.aWN.showToast(errorString);
                    if (this.bTq.bTc.isEmpty()) {
                        com.baidu.tieba.enterForum.c.c cVar = this.bTq.bTc;
                        view = this.bTq.mRootView;
                        cVar.ad(view);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    enterForumModel3 = this.bTq.bTd;
                    enterForumModel3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    enterForumModel2 = this.bTq.bTd;
                    enterForumModel2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
