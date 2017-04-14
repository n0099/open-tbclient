package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends cf<com.baidu.tieba.card.data.m> {
    final /* synthetic */ d cxQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cxQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.card.t tVar;
        tVar = this.cxQ.cxO;
        if (tVar.bsx == view) {
            as asVar = new as("c11824");
            asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(asVar);
        }
    }
}
