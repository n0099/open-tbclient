package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bgG;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bgz = frsActivity;
        this.bgG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aB(this.bgG.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.bgz.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
