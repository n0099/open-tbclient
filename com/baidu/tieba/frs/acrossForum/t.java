package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bDk;
    private final /* synthetic */ FrsActivity bDl;
    private final /* synthetic */ AcrossForumViewData bDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, FrsActivity frsActivity, AcrossForumViewData acrossForumViewData) {
        this.bDk = qVar;
        this.bDl = frsActivity;
        this.bDm = acrossForumViewData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bc.vz().c(this.bDl.getPageContext(), new String[]{this.bDm.rulesURL});
    }
}
