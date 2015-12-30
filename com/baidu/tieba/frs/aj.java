package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bed = frsActivity;
        this.bel = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aC(this.bel.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.bed.getPageContext().getPageActivity(), view.getResources().getString(n.j.copy_pb_url_success));
    }
}
