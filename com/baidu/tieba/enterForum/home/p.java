package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(i iVar, int i, int i2) {
        super(i, i2);
        this.bMN = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        String errorString;
        View view;
        if ((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) {
            enterForumModel = this.bMN.bMC;
            if (enterForumModel.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.bMN.bMB.XQ();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.bMN.aVu.getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.bMN.aVu.showToast(errorString);
                    if (this.bMN.bMB.isEmpty()) {
                        com.baidu.tieba.enterForum.c.c cVar = this.bMN.bMB;
                        view = this.bMN.mRootView;
                        cVar.ac(view);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    enterForumModel3 = this.bMN.bMC;
                    enterForumModel3.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    enterForumModel2 = this.bMN.bMC;
                    enterForumModel2.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
