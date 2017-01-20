package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aCz;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bUr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bUr = fVar;
        this.aCz = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ay(this.bUr.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aCz.getPageActivity(), view.getResources().getString(r.l.copy_pb_url_success));
    }
}
