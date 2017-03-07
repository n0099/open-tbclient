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
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.bFb = lVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        EnterForumModel enterForumModel;
        String str;
        LikeModel likeModel4;
        likeModel = this.bFb.brY;
        if (AntiHelper.rZ(likeModel.getErrorCode())) {
            Activity pageActivity = this.bFb.aXf.getPageContext().getPageActivity();
            likeModel4 = this.bFb.brY;
            AntiHelper.an(pageActivity, likeModel4.getErrorString());
        } else if (obj != null) {
            enterForumModel = this.bFb.bEJ;
            str = this.bFb.bEL;
            enterForumModel.dh(!StringUtils.isNull(str));
        } else {
            likeModel2 = this.bFb.brY;
            if (!StringUtils.isNull(likeModel2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                likeModel3 = this.bFb.brY;
                com.baidu.adp.lib.util.k.showToast(m9getInst, likeModel3.getErrorString());
            }
        }
    }
}
