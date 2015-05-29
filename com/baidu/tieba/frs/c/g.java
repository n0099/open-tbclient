package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ay;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ay {
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aQc = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aQc.aPE;
        w KE = frsActivity.KE();
        if (KE != null && KE.aar() != null) {
            com.baidu.tieba.tbadkCore.d.amo().D(KE.aar().getName(), false);
            KE.aar().setLike(0);
            this.aQc.fi(0);
            frsActivity2 = this.aQc.aPE;
            frsActivity2.aLV.c(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.aQc.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void h(String str, long j) {
    }
}
