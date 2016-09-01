package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class co implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aDS;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(com.baidu.tbadk.coreExtra.share.f fVar, TbPageContext tbPageContext) {
        this.bSV = fVar;
        this.aDS = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.az(this.bSV.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.aDS.getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
