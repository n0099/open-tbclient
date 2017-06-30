package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a crZ;
    private final /* synthetic */ aa csa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, aa aaVar) {
        this.crZ = aVar;
        this.csa = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        String str = this.csa.linkUrl;
        String[] strArr = {str};
        be vP = be.vP();
        tbPageContext = this.crZ.ajP;
        if (!vP.a(tbPageContext, "", strArr, false, null, true) && !be.vP().ea(str)) {
            tbPageContext2 = this.crZ.ajP;
            tbPageContext2.showToast(w.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new au("c11683").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
