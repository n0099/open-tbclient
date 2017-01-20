package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bYL;
    private final /* synthetic */ y bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, y yVar) {
        this.bYL = aVar;
        this.bYM = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.bYM.linkUrl;
        String[] strArr = {str};
        ba vt = ba.vt();
        baseActivity = this.bYL.aWr;
        if (!vt.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !ba.vt().dL(str)) {
            baseActivity2 = this.bYL.aWr;
            baseActivity2.showToast(r.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new ar("c11683").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
