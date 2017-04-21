package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements ab.b {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bHl = lVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        EnterForumModel enterForumModel;
        String str;
        enterForumModel = this.bHl.bGT;
        str = this.bHl.bGV;
        enterForumModel.dt(!StringUtils.isNull(str));
    }
}
