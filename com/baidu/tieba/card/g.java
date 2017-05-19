package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    final /* synthetic */ d bun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bun = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        LikeModel likeModel4;
        if (obj instanceof com.baidu.tieba.tbadkCore.t) {
            likeModel4 = this.bun.bue;
            if (likeModel4.getErrorCode() == 0) {
                return;
            }
        }
        likeModel = this.bun.bue;
        if (AntiHelper.rV(likeModel.getErrorCode())) {
            Context context = this.bun.getContext();
            likeModel3 = this.bun.bue;
            AntiHelper.aq(context, likeModel3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.bun.getTbPageContext();
        likeModel2 = this.bun.bue;
        tbPageContext.showToast(likeModel2.getErrorString());
    }
}
