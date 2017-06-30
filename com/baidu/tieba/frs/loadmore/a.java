package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.recapp.aa;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel cml;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.cml = frsLoadMoreModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        r rVar9;
        r rVar10;
        r rVar11;
        rVar = this.cml.cmi;
        if (rVar != null) {
            this.cml.isLoading = false;
            if (responsedMessage == null) {
                rVar10 = this.cml.cmi;
                rVar11 = this.cml.cmi;
                rVar10.jW(rVar11.getPageContext().getString(w.l.neterror));
            } else if (responsedMessage.getError() == 0) {
                rVar2 = this.cml.cmi;
                n aek = rVar2.aek();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (aek != null) {
                        aek.a(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    rVar6 = this.cml.cmi;
                    rVar6.G(loadMoreHttpResponseMessage.getThreadList());
                    this.cml.a((LoadMoreHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (aek != null) {
                        aek.a(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    rVar3 = this.cml.cmi;
                    rVar3.G(loadMoreResponseSocketMessage.getThreadList());
                    this.cml.a((LoadMoreResponseSocketMessage) responsedMessage);
                }
                rVar4 = this.cml.cmi;
                if (!TextUtils.isEmpty(rVar4.getForumName()) && aa.bdU().bdQ() != null) {
                    t bdQ = aa.bdU().bdQ();
                    rVar5 = this.cml.cmi;
                    bdQ.g(rVar5.getForumName(), 2, false);
                }
                this.cml.loadIndex++;
            } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                rVar9 = this.cml.cmi;
                rVar9.jW(responsedMessage.getErrorString());
            } else {
                rVar7 = this.cml.cmi;
                rVar8 = this.cml.cmi;
                rVar7.jW(rVar8.getPageContext().getString(w.l.neterror));
            }
        }
    }
}
