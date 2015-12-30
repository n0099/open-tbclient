package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsHeaderView frsHeaderView) {
        this.bow = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bow.bnN, this.bow.mContext.getPageActivity());
        this.bow.beB.bda = false;
        com.baidu.tbadk.browser.f.a(this.bow.mContext.getPageActivity(), this.bow.mContext.getResources().getString(n.j.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
