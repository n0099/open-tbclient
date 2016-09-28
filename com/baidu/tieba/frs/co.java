package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class co implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDv;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bSO = fVar;
        this.aDv = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.az(this.bSO.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aDv.getPageActivity(), view.getResources().getString(r.j.copy_pb_url_success));
    }
}
