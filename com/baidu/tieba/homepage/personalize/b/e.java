package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends ci<com.baidu.tieba.card.data.k> {
    final /* synthetic */ d cBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cBJ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        com.baidu.tieba.card.t tVar;
        tVar = this.cBJ.cBH;
        if (tVar.bAz == view) {
            int i = 0;
            String str = "";
            if (kVar != null && kVar.LH() != null) {
                i = kVar.LH().rM().live_type;
                str = kVar.LH().getTid();
            }
            as asVar = new as("c11824");
            asVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            asVar.r("obj_type", i);
            asVar.Z("tid", str);
            TiebaStatic.log(asVar);
        }
    }
}
