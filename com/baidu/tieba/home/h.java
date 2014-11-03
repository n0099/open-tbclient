package com.baidu.tieba.home;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.aj;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.model.r {
    final /* synthetic */ f aMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aMC = fVar;
    }

    @Override // com.baidu.tieba.model.r
    public void a(com.baidu.tieba.model.q qVar) {
        BaseFragmentActivity baseFragmentActivity;
        r rVar;
        r rVar2;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        r rVar3;
        BaseFragmentActivity baseFragmentActivity4;
        long j;
        long j2;
        com.baidu.tieba.model.n nVar;
        long j3;
        com.baidu.tieba.model.n nVar2;
        com.baidu.tieba.model.n nVar3;
        com.baidu.tieba.model.n nVar4;
        boolean isShow;
        r rVar4;
        boolean z;
        com.baidu.tieba.model.n nVar5;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        r rVar9;
        baseFragmentActivity = this.aMC.aye;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            rVar9 = this.aMC.aMr;
            rVar9.IW();
        }
        rVar = this.aMC.aMr;
        rVar.d(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + qVar.avl);
        rVar2 = this.aMC.aMr;
        rVar2.IR();
        if (qVar.avl) {
            if (qVar.type == 1) {
                this.aMC.aMw = true;
                new com.baidu.tieba.data.o();
                com.baidu.tieba.data.o oVar = qVar.boM;
                rVar7 = this.aMC.aMr;
                rVar7.b(oVar);
                rVar8 = this.aMC.aMr;
                rVar8.notifyDataSetChanged();
            } else if (qVar.type == 0) {
                z = this.aMC.aMw;
                if (!z) {
                    new com.baidu.tieba.data.o();
                    com.baidu.tieba.data.o oVar2 = qVar.boM;
                    nVar5 = this.aMC.aMt;
                    nVar5.c(oVar2);
                    rVar5 = this.aMC.aMr;
                    rVar5.b(oVar2);
                    rVar6 = this.aMC.aMr;
                    rVar6.notifyDataSetChanged();
                }
            }
        } else if (qVar.boL != null && !qVar.boL.equals("")) {
            baseFragmentActivity2 = this.aMC.aye;
            baseFragmentActivity2.showToast(qVar.boL);
        }
        if (qVar.type == 1 && aj.wm().wk()) {
            isShow = this.aMC.isShow();
            if (isShow) {
                rVar4 = this.aMC.aMr;
                rVar4.IV();
                aj.wm().aN(false);
            }
        }
        if (qVar.type == 1) {
            j = this.aMC.aAU;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aMC.aAU;
                nVar = this.aMC.aMt;
                long Fe = nVar.Fe();
                j3 = this.aMC.aAU;
                long j4 = Fe - j3;
                nVar2 = this.aMC.aMt;
                long Fc = nVar2.Fc();
                nVar3 = this.aMC.aMt;
                long Fd = nVar3.Fd();
                nVar4 = this.aMC.aMt;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Fc, Fd, currentTimeMillis - nVar4.Fb());
                this.aMC.aAU = -1L;
            }
        }
        com.baidu.tieba.data.o oVar3 = qVar.boM;
        if (oVar3.yO() == 1) {
            if (!oVar3.yV()) {
                baseFragmentActivity4 = this.aMC.aye;
                String.format(baseFragmentActivity4.getString(y.signallforum_warning), Integer.valueOf(oVar3.yP()));
            }
        } else {
            oVar3.yQ();
        }
        if (qVar.type == 1) {
            String loadString = TbadkSettings.getInst().loadString("hao123_guide_show", "");
            baseFragmentActivity3 = this.aMC.aye;
            String currentVerson = UtilHelper.getCurrentVerson(baseFragmentActivity3);
            if (!TextUtils.isEmpty(currentVerson) && !currentVerson.equals(loadString) && TbadkApplication.m251getInst().isHao123HelperShouldOpen() && !TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                rVar3 = this.aMC.aMr;
                rVar3.Jg();
                TbadkSettings.getInst().saveString("hao123_guide_show", currentVerson);
            }
        }
    }
}
