package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ceH;
    private final /* synthetic */ z ceI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, z zVar) {
        this.ceH = aVar;
        this.ceI = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.ceI.linkUrl;
        String[] strArr = {str};
        bb wn = bb.wn();
        baseActivity = this.ceH.bcy;
        if (!wn.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !bb.wn().dL(str)) {
            baseActivity2 = this.ceH.bcy;
            baseActivity2.showToast(w.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new as("c11683").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
