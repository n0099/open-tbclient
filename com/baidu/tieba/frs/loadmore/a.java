package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.z;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel cdY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.cdY = frsLoadMoreModel;
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
        rVar = this.cdY.cdV;
        if (rVar != null) {
            this.cdY.isLoading = false;
            if (responsedMessage == null) {
                rVar10 = this.cdY.cdV;
                rVar11 = this.cdY.cdV;
                rVar10.iZ(rVar11.getPageContext().getString(w.l.neterror));
            } else if (responsedMessage.getError() == 0) {
                rVar2 = this.cdY.cdV;
                n aau = rVar2.aau();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (aau != null) {
                        aau.a(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    rVar6 = this.cdY.cdV;
                    rVar6.F(loadMoreHttpResponseMessage.getThreadList());
                    this.cdY.a((LoadMoreHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (aau != null) {
                        aau.a(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    rVar3 = this.cdY.cdV;
                    rVar3.F(loadMoreResponseSocketMessage.getThreadList());
                    this.cdY.a((LoadMoreResponseSocketMessage) responsedMessage);
                }
                rVar4 = this.cdY.cdV;
                if (!TextUtils.isEmpty(rVar4.getForumName()) && z.aZK().aZG() != null) {
                    s aZG = z.aZK().aZG();
                    rVar5 = this.cdY.cdV;
                    aZG.g(rVar5.getForumName(), 2, false);
                }
                this.cdY.loadIndex++;
            } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                rVar9 = this.cdY.cdV;
                rVar9.iZ(responsedMessage.getErrorString());
            } else {
                rVar7 = this.cdY.cdV;
                rVar8 = this.cdY.cdV;
                rVar7.iZ(rVar8.getPageContext().getString(w.l.neterror));
            }
        }
    }
}
