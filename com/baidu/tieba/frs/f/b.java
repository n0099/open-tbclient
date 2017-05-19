package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cdU;
    private final /* synthetic */ z cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, z zVar) {
        this.cdU = aVar;
        this.cdV = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        String str = this.cdV.linkUrl;
        String[] strArr = {str};
        bb vB = bb.vB();
        tbPageContext = this.cdU.ajr;
        if (!vB.a(tbPageContext, "", strArr, false, null, true) && !bb.vB().dJ(str)) {
            tbPageContext2 = this.cdU.ajr;
            tbPageContext2.showToast(w.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new as("c11683").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
