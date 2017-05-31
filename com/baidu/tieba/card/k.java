package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f {
    final /* synthetic */ h bAb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bAb = hVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        LikeModel likeModel4;
        if (obj instanceof com.baidu.tieba.tbadkCore.t) {
            likeModel4 = this.bAb.bzS;
            if (likeModel4.getErrorCode() == 0) {
                return;
            }
        }
        likeModel = this.bAb.bzS;
        if (AntiHelper.sr(likeModel.getErrorCode())) {
            Context context = this.bAb.getContext();
            likeModel3 = this.bAb.bzS;
            AntiHelper.ap(context, likeModel3.getErrorString());
            return;
        }
        TbPageContext<?> Uc = this.bAb.Uc();
        likeModel2 = this.bAb.bzS;
        Uc.showToast(likeModel2.getErrorString());
    }
}
