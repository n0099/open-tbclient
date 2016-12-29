package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bSo;
    private final /* synthetic */ x bSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, x xVar) {
        this.bSo = aVar;
        this.bSp = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.bSp.linkUrl;
        String[] strArr = {str};
        bc vz = bc.vz();
        baseActivity = this.bSo.aSs;
        if (!vz.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !bc.vz().dN(str)) {
            baseActivity2 = this.bSo.aSs;
            baseActivity2.showToast(r.j.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new at("c11683").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
