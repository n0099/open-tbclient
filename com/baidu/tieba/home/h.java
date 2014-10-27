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
    final /* synthetic */ f aMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aMo = fVar;
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
        baseFragmentActivity = this.aMo.axV;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            rVar9 = this.aMo.aMd;
            rVar9.IS();
        }
        rVar = this.aMo.aMd;
        rVar.d(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + qVar.avc);
        rVar2 = this.aMo.aMd;
        rVar2.IN();
        if (qVar.avc) {
            if (qVar.type == 1) {
                this.aMo.aMi = true;
                new com.baidu.tieba.data.o();
                com.baidu.tieba.data.o oVar = qVar.boy;
                rVar7 = this.aMo.aMd;
                rVar7.b(oVar);
                rVar8 = this.aMo.aMd;
                rVar8.notifyDataSetChanged();
            } else if (qVar.type == 0) {
                z = this.aMo.aMi;
                if (!z) {
                    new com.baidu.tieba.data.o();
                    com.baidu.tieba.data.o oVar2 = qVar.boy;
                    nVar5 = this.aMo.aMf;
                    nVar5.c(oVar2);
                    rVar5 = this.aMo.aMd;
                    rVar5.b(oVar2);
                    rVar6 = this.aMo.aMd;
                    rVar6.notifyDataSetChanged();
                }
            }
        } else if (qVar.box != null && !qVar.box.equals("")) {
            baseFragmentActivity2 = this.aMo.axV;
            baseFragmentActivity2.showToast(qVar.box);
        }
        if (qVar.type == 1 && aj.wk().wi()) {
            isShow = this.aMo.isShow();
            if (isShow) {
                rVar4 = this.aMo.aMd;
                rVar4.IR();
                aj.wk().aN(false);
            }
        }
        if (qVar.type == 1) {
            j = this.aMo.aAK;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aMo.aAK;
                nVar = this.aMo.aMf;
                long Fc = nVar.Fc();
                j3 = this.aMo.aAK;
                long j4 = Fc - j3;
                nVar2 = this.aMo.aMf;
                long Fa = nVar2.Fa();
                nVar3 = this.aMo.aMf;
                long Fb = nVar3.Fb();
                nVar4 = this.aMo.aMf;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Fa, Fb, currentTimeMillis - nVar4.EZ());
                this.aMo.aAK = -1L;
            }
        }
        com.baidu.tieba.data.o oVar3 = qVar.boy;
        if (oVar3.yM() == 1) {
            if (!oVar3.yT()) {
                baseFragmentActivity4 = this.aMo.axV;
                String.format(baseFragmentActivity4.getString(y.signallforum_warning), Integer.valueOf(oVar3.yN()));
            }
        } else {
            oVar3.yO();
        }
        if (qVar.type == 1) {
            String loadString = TbadkSettings.getInst().loadString("hao123_guide_show", "");
            baseFragmentActivity3 = this.aMo.axV;
            String currentVerson = UtilHelper.getCurrentVerson(baseFragmentActivity3);
            if (!TextUtils.isEmpty(currentVerson) && !currentVerson.equals(loadString) && TbadkApplication.m251getInst().isHao123HelperShouldOpen() && !TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                rVar3 = this.aMo.aMd;
                rVar3.Jc();
                TbadkSettings.getInst().saveString("hao123_guide_show", currentVerson);
            }
        }
    }
}
