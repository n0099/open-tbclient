package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f blr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.blk = frsActivity;
        this.blr = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aD(this.blr.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.blk.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
