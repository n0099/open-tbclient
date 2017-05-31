package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ae.a {
    final /* synthetic */ ag cif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.cif = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.a
    public void b(View view, boolean z) {
        com.baidu.tieba.frs.smartsort.c cVar;
        au auVar;
        cb cbVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.smartsort.c cVar3;
        cVar = this.cif.bUp;
        if (cVar != null) {
            cVar3 = this.cif.bUp;
            cVar3.adq();
        }
        auVar = this.cif.bUa;
        if (auVar != null) {
            cbVar = this.cif.ceP;
            if (cbVar != null) {
                uVar = this.cif.bUk;
                if (uVar != null) {
                    cVar2 = this.cif.bUp;
                    if (cVar2 != null) {
                        rVar = this.cif.bTw;
                        rVar.eb(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
