package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bXa;
    private final /* synthetic */ FrsActivity bXb;
    private final /* synthetic */ AcrossForumViewData bXc;
    private final /* synthetic */ String bXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, FrsActivity frsActivity, AcrossForumViewData acrossForumViewData, String str) {
        this.bXa = qVar;
        this.bXb = frsActivity;
        this.bXc = acrossForumViewData;
        this.bXd = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u.a(this.bXb.getPageContext(), this.bXc, this.bXd);
    }
}
