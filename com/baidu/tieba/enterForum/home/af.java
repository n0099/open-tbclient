package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements aa.b {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bxV = lVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
        EnterForumModel enterForumModel;
        String str;
        enterForumModel = this.bxV.bxD;
        str = this.bxV.bxF;
        enterForumModel.dh(!StringUtils.isNull(str));
    }
}
