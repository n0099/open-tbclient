package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class cs implements View.OnClickListener {
    private final /* synthetic */ TbPageContext azW;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bGt = fVar;
        this.azW = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.aw(this.bGt.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.azW.getPageActivity(), view.getResources().getString(u.j.copy_pb_url_success));
    }
}
