package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bkF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsHeaderView frsHeaderView) {
        this.bkF = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bkF.bjW, this.bkF.mContext.getPageActivity());
        this.bkF.baC.aZe = false;
        com.baidu.tbadk.browser.f.a(this.bkF.mContext.getPageActivity(), this.bkF.mContext.getResources().getString(n.i.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
