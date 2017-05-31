package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar) {
        this.bMN = iVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        LikeModel likeModel3;
        EnterForumModel enterForumModel;
        String str;
        LikeModel likeModel4;
        likeModel = this.bMN.bzS;
        if (AntiHelper.sr(likeModel.getErrorCode())) {
            Activity pageActivity = this.bMN.aVu.getPageContext().getPageActivity();
            likeModel4 = this.bMN.bzS;
            AntiHelper.ap(pageActivity, likeModel4.getErrorString());
        } else if (obj != null) {
            enterForumModel = this.bMN.bMC;
            str = this.bMN.bME;
            enterForumModel.dM(!StringUtils.isNull(str));
        } else {
            likeModel2 = this.bMN.bzS;
            if (!StringUtils.isNull(likeModel2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                likeModel3 = this.bMN.bzS;
                com.baidu.adp.lib.util.k.showToast(m9getInst, likeModel3.getErrorString());
            }
        }
    }
}
