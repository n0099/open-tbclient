package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends cd<com.baidu.tieba.card.data.k> {
    final /* synthetic */ d cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cvr = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        com.baidu.tieba.card.p pVar;
        pVar = this.cvr.cvp;
        if (pVar.buN == view) {
            int i = 0;
            String str = "";
            if (kVar != null && kVar.JB() != null) {
                i = kVar.JB().rQ().live_type;
                str = kVar.JB().getTid();
            }
            as asVar = new as("c11824");
            asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            asVar.s("obj_type", i);
            asVar.aa("tid", str);
            TiebaStatic.log(asVar);
        }
    }
}
