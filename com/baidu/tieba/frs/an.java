package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bhv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bhl = frsActivity;
        this.bhv = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.aw(this.bhv.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.bhl.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
