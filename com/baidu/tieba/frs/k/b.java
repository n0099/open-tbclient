package com.baidu.tieba.frs.k;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cnd;
    private final /* synthetic */ y cne;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, y yVar) {
        this.cnd = aVar;
        this.cne = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.cne.linkUrl;
        String[] strArr = {str};
        bf vP = bf.vP();
        baseActivity = this.cnd.aTb;
        if (!vP.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !bf.vP().dP(str)) {
            baseActivity2 = this.cnd.aTb;
            baseActivity2.showToast(r.j.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new av("c11683").ab("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
