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
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aQd = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aQd.aPF;
        w KF = frsActivity.KF();
        if (KF != null && KF.aas() != null) {
            com.baidu.tieba.tbadkCore.d.amp().D(KF.aas().getName(), false);
            KF.aas().setLike(0);
            this.aQd.fi(0);
            frsActivity2 = this.aQd.aPF;
            frsActivity2.aLW.c(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.aQd.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void h(String str, long j) {
    }
}
