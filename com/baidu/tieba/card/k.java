package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f {
    final /* synthetic */ h bAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bAU = hVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        LikeModel likeModel4;
        if (obj instanceof com.baidu.tieba.tbadkCore.t) {
            likeModel4 = this.bAU.bAL;
            if (likeModel4.getErrorCode() == 0) {
                return;
            }
        }
        likeModel = this.bAU.bAL;
        if (AntiHelper.sK(likeModel.getErrorCode())) {
            Context context = this.bAU.getContext();
            likeModel3 = this.bAU.bAL;
            AntiHelper.ar(context, likeModel3.getErrorString());
            return;
        }
        TbPageContext<?> Vr = this.bAU.Vr();
        likeModel2 = this.bAU.bAL;
        Vr.showToast(likeModel2.getErrorString());
    }
}
