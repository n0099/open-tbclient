package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDH;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bDp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bDp = fVar;
        this.aDH = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.az(this.bDp.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aDH.getPageActivity(), view.getResources().getString(r.j.copy_pb_url_success));
    }
}
