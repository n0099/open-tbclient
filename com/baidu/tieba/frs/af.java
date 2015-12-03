package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bag = frsActivity;
        this.bam = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aC(this.bam.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.bag.getPageContext().getPageActivity(), view.getResources().getString(n.i.copy_pb_url_success));
    }
}
