package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel bZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.bZh = frsLoadMoreModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        this.bZh.isLoading = false;
        if (responsedMessage == null) {
            frsActivity7 = this.bZh.bOq;
            frsActivity8 = this.bZh.bOq;
            frsActivity7.iF(frsActivity8.getPageContext().getString(w.l.neterror));
        } else if (responsedMessage.getError() == 0) {
            frsActivity = this.bZh.bOq;
            n YV = frsActivity.YV();
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                if (YV != null) {
                    YV.a(loadMoreHttpResponseMessage.getBannerListData());
                }
                frsActivity3 = this.bZh.bOq;
                frsActivity3.E(loadMoreHttpResponseMessage.getThreadList());
                this.bZh.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                if (YV != null) {
                    YV.a(loadMoreResponseSocketMessage.getBannerListData());
                }
                frsActivity2 = this.bZh.bOq;
                frsActivity2.E(loadMoreResponseSocketMessage.getThreadList());
                this.bZh.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bZh.loadIndex++;
        } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
            frsActivity6 = this.bZh.bOq;
            frsActivity6.iF(responsedMessage.getErrorString());
        } else {
            frsActivity4 = this.bZh.bOq;
            frsActivity5 = this.bZh.bOq;
            frsActivity4.iF(frsActivity5.getPageContext().getString(w.l.neterror));
        }
    }
}
