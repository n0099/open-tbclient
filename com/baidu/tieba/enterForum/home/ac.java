package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.bxV = lVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        EnterForumModel enterForumModel;
        String str;
        LikeModel likeModel4;
        likeModel = this.bxV.Fq;
        if (AntiHelper.sa(likeModel.getErrorCode())) {
            Activity pageActivity = this.bxV.aQU.getPageContext().getPageActivity();
            likeModel4 = this.bxV.Fq;
            AntiHelper.T(pageActivity, likeModel4.getErrorString());
        } else if (obj != null) {
            enterForumModel = this.bxV.bxD;
            str = this.bxV.bxF;
            enterForumModel.dh(!StringUtils.isNull(str));
        } else {
            likeModel2 = this.bxV.Fq;
            if (!StringUtils.isNull(likeModel2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                likeModel3 = this.bxV.Fq;
                com.baidu.adp.lib.util.k.showToast(m9getInst, likeModel3.getErrorString());
            }
        }
    }
}
