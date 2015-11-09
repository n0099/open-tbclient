package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f aVa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.aUS = frsActivity;
        this.aVa = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ay(this.aVa.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aUS.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
