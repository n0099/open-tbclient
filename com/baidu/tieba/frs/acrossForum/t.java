package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bXa;
    private final /* synthetic */ FrsActivity bXb;
    private final /* synthetic */ AcrossForumViewData bXc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, FrsActivity frsActivity, AcrossForumViewData acrossForumViewData) {
        this.bXa = qVar;
        this.bXb = frsActivity;
        this.bXc = acrossForumViewData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf.vP().c(this.bXb.getPageContext(), new String[]{this.bXc.rulesURL});
    }
}
