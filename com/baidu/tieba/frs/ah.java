package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.aUK = frsActivity;
        this.aUS = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aA(this.aUS.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aUK.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
