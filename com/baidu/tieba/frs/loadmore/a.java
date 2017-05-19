package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel bXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.bXN = frsLoadMoreModel;
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
        rVar = this.bXN.bXK;
        if (rVar != null) {
            this.bXN.isLoading = false;
            if (responsedMessage == null) {
                rVar8 = this.bXN.bXK;
                rVar9 = this.bXN.bXK;
                rVar8.iR(rVar9.getPageContext().getString(w.l.neterror));
            } else if (responsedMessage.getError() == 0) {
                rVar2 = this.bXN.bXK;
                n Zq = rVar2.Zq();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (Zq != null) {
                        Zq.a(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    rVar4 = this.bXN.bXK;
                    rVar4.E(loadMoreHttpResponseMessage.getThreadList());
                    this.bXN.a((LoadMoreHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (Zq != null) {
                        Zq.a(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    rVar3 = this.bXN.bXK;
                    rVar3.E(loadMoreResponseSocketMessage.getThreadList());
                    this.bXN.a((LoadMoreResponseSocketMessage) responsedMessage);
                }
                this.bXN.loadIndex++;
            } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                rVar7 = this.bXN.bXK;
                rVar7.iR(responsedMessage.getErrorString());
            } else {
                rVar5 = this.bXN.bXK;
                rVar6 = this.bXN.bXK;
                rVar5.iR(rVar6.getPageContext().getString(w.l.neterror));
            }
        }
    }
}
