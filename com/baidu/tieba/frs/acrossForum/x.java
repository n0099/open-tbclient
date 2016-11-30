package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aEn;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bXf = fVar;
        this.aEn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.az(this.bXf.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aEn.getPageActivity(), view.getResources().getString(r.j.copy_pb_url_success));
    }
}
