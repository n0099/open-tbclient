package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aHR;
    private final /* synthetic */ String cbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, TbPageContext tbPageContext) {
        this.cbD = str;
        this.aHR = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.as(this.cbD);
        com.baidu.adp.lib.util.k.showToast(this.aHR.getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
