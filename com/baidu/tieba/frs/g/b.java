package com.baidu.tieba.frs.g;

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
    final /* synthetic */ a cki;
    private final /* synthetic */ z ckj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, z zVar) {
        this.cki = aVar;
        this.ckj = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        String str = this.ckj.linkUrl;
        String[] strArr = {str};
        bb vy = bb.vy();
        tbPageContext = this.cki.ajh;
        if (!vy.a(tbPageContext, "", strArr, false, null, true) && !bb.vy().dG(str)) {
            tbPageContext2 = this.cki.ajh;
            tbPageContext2.showToast(w.l.pluginstatus_tip_unknown);
        }
        TiebaStatic.log(new as("c11683").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }
}
