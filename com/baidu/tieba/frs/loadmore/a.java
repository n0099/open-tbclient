package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel bXG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.bXG = frsLoadMoreModel;
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
        this.bXG.isLoading = false;
        if (responsedMessage == null) {
            frsActivity7 = this.bXG.bOf;
            frsActivity8 = this.bXG.bOf;
            frsActivity7.iJ(frsActivity8.getPageContext().getString(w.l.neterror));
        } else if (responsedMessage.getError() == 0) {
            frsActivity = this.bXG.bOf;
            n Zr = frsActivity.Zr();
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                if (Zr != null) {
                    Zr.a(loadMoreHttpResponseMessage.getBannerListData());
                }
                frsActivity3 = this.bXG.bOf;
                frsActivity3.E(loadMoreHttpResponseMessage.getThreadList());
                this.bXG.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                if (Zr != null) {
                    Zr.a(loadMoreResponseSocketMessage.getBannerListData());
                }
                frsActivity2 = this.bXG.bOf;
                frsActivity2.E(loadMoreResponseSocketMessage.getThreadList());
                this.bXG.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bXG.loadIndex++;
        } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
            frsActivity6 = this.bXG.bOf;
            frsActivity6.iJ(responsedMessage.getErrorString());
        } else {
            frsActivity4 = this.bXG.bOf;
            frsActivity5 = this.bXG.bOf;
            frsActivity4.iJ(frsActivity5.getPageContext().getString(w.l.neterror));
        }
    }
}
