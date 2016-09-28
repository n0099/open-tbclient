package com.baidu.tieba.frs.j;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a chW;
    private final /* synthetic */ w chX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, w wVar) {
        this.chW = aVar;
        this.chX = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.chX.linkUrl;
        String[] strArr = {str};
        bh vL = bh.vL();
        baseActivity = this.chW.aRd;
        if (!vL.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !bh.vL().dN(str)) {
            baseActivity2 = this.chW.aRd;
            baseActivity2.showToast(r.j.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new ax("c11683").ab("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
