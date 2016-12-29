package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bDk;
    private final /* synthetic */ FrsActivity bDl;
    private final /* synthetic */ AcrossForumViewData bDm;
    private final /* synthetic */ String bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, FrsActivity frsActivity, AcrossForumViewData acrossForumViewData, String str) {
        this.bDk = qVar;
        this.bDl = frsActivity;
        this.bDm = acrossForumViewData;
        this.bDn = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u.a(this.bDl.getPageContext(), this.bDm, this.bDn);
    }
}
