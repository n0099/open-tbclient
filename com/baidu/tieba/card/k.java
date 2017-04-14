package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f {
    final /* synthetic */ h brZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.brZ = hVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        LikeModel likeModel4;
        if (obj instanceof com.baidu.tieba.tbadkCore.v) {
            likeModel4 = this.brZ.brQ;
            if (likeModel4.getErrorCode() == 0) {
                return;
            }
        }
        likeModel = this.brZ.brQ;
        if (AntiHelper.rX(likeModel.getErrorCode())) {
            Context context = this.brZ.getContext();
            likeModel3 = this.brZ.brQ;
            AntiHelper.aq(context, likeModel3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.brZ.getTbPageContext();
        likeModel2 = this.brZ.brQ;
        tbPageContext.showToast(likeModel2.getErrorString());
    }
}
