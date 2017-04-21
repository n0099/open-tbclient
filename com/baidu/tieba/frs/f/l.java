package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aIi;
    private final /* synthetic */ String ccv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, TbPageContext tbPageContext) {
        this.ccv = str;
        this.aIi = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ao(this.ccv);
        com.baidu.adp.lib.util.k.showToast(this.aIi.getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
