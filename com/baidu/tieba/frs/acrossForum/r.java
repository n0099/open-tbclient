package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q bXa;
    private final /* synthetic */ FrsActivity bXb;
    private final /* synthetic */ AcrossForumViewData bXc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, FrsActivity frsActivity, AcrossForumViewData acrossForumViewData) {
        this.bXa = qVar;
        this.bXb = frsActivity;
        this.bXc = acrossForumViewData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.acrossForum.a.MS().b(this.bXb.getPageContext(), "frs_recross", this.bXc.forumName);
    }
}
