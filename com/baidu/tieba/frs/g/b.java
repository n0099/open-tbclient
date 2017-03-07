package com.baidu.tieba.frs.g;

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
    final /* synthetic */ a cgh;
    private final /* synthetic */ z cgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, z zVar) {
        this.cgh = aVar;
        this.cgi = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str = this.cgi.linkUrl;
        String[] strArr = {str};
        bb vQ = bb.vQ();
        baseActivity = this.cgh.bcF;
        if (!vQ.a(baseActivity.getPageContext(), "", strArr, false, null, true) && !bb.vQ().dF(str)) {
            baseActivity2 = this.cgh.bcF;
            baseActivity2.showToast(w.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new as("c11683").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
