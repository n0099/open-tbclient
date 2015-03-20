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
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aNz = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void d(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aNz.aNb;
        w Ju = frsActivity.Ju();
        if (Ju != null && Ju.YO() != null) {
            com.baidu.tieba.tbadkCore.d.ako().D(Ju.YO().getName(), false);
            Ju.YO().setLike(0);
            this.aNz.eT(0);
            frsActivity2 = this.aNz.aNb;
            frsActivity2.aJE.c(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.aNz.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void e(String str, long j) {
    }
}
