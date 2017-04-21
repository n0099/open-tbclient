package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.bZX = frsLoadMoreModel;
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
        this.bZX.isLoading = false;
        if (responsedMessage == null) {
            frsActivity7 = this.bZX.bQw;
            frsActivity8 = this.bZX.bQw;
            frsActivity7.iK(frsActivity8.getPageContext().getString(w.l.neterror));
        } else if (responsedMessage.getError() == 0) {
            frsActivity = this.bZX.bQw;
            n aas = frsActivity.aas();
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                if (aas != null) {
                    aas.a(loadMoreHttpResponseMessage.getBannerListData());
                }
                frsActivity3 = this.bZX.bQw;
                frsActivity3.E(loadMoreHttpResponseMessage.getThreadList());
                this.bZX.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                if (aas != null) {
                    aas.a(loadMoreResponseSocketMessage.getBannerListData());
                }
                frsActivity2 = this.bZX.bQw;
                frsActivity2.E(loadMoreResponseSocketMessage.getThreadList());
                this.bZX.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bZX.loadIndex++;
        } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
            frsActivity6 = this.bZX.bQw;
            frsActivity6.iK(responsedMessage.getErrorString());
        } else {
            frsActivity4 = this.bZX.bQw;
            frsActivity5 = this.bZX.bQw;
            frsActivity4.iK(frsActivity5.getPageContext().getString(w.l.neterror));
        }
    }
}
