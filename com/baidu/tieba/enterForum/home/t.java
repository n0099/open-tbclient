package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ae.b {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.bMN = iVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        EnterForumModel enterForumModel;
        String str;
        enterForumModel = this.bMN.bMC;
        str = this.bMN.bME;
        enterForumModel.dM(!StringUtils.isNull(str));
        TbadkCoreApplication.m9getInst().setLikeBarChanged(false);
    }
}
