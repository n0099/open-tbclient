package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements ab.b {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bEU = lVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        EnterForumModel enterForumModel;
        String str;
        enterForumModel = this.bEU.bEC;
        str = this.bEU.bEE;
        enterForumModel.dj(!StringUtils.isNull(str));
    }
}
