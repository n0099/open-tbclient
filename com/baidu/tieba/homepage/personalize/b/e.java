package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends ci<com.baidu.tieba.card.data.k> {
    final /* synthetic */ d cJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cJG = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        com.baidu.tieba.card.t tVar;
        tVar = this.cJG.cJE;
        if (tVar.bBs == view) {
            int i = 0;
            String str = "";
            if (kVar != null && kVar.Mv() != null) {
                i = kVar.Mv().rJ().live_type;
                str = kVar.Mv().getTid();
            }
            au auVar = new au("c11824");
            auVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            auVar.r("obj_type", i);
            auVar.Z("tid", str);
            TiebaStatic.log(auVar);
        }
    }
}
