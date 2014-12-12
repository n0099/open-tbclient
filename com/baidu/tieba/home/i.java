package com.baidu.tieba.home;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.model.h {
    final /* synthetic */ f aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aOG = fVar;
    }

    @Override // com.baidu.tieba.model.h
    public void a(com.baidu.tieba.model.g gVar) {
        BaseFragmentActivity baseFragmentActivity;
        s sVar;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        long j;
        long j2;
        com.baidu.tieba.model.d dVar;
        long j3;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        com.baidu.tieba.model.d dVar4;
        boolean isShow;
        s sVar2;
        boolean z;
        com.baidu.tieba.model.d dVar5;
        s sVar3;
        s sVar4;
        s sVar5;
        s sVar6;
        s sVar7;
        s sVar8;
        baseFragmentActivity = this.aOG.aOz;
        if (UtilHelper.getNetStatusInfo(baseFragmentActivity.getPageContext().getPageActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            sVar8 = this.aOG.aOs;
            sVar8.Jr();
        }
        sVar = this.aOG.aOs;
        sVar.h(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + gVar.ayu);
        if (gVar.type == 1) {
            sVar7 = this.aOG.aOs;
            sVar7.Jm();
        }
        if (gVar.ayu) {
            if (gVar.type == 1) {
                this.aOG.aOx = true;
                new com.baidu.tieba.data.e();
                com.baidu.tieba.data.e eVar = gVar.bsW;
                sVar5 = this.aOG.aOs;
                sVar5.b(eVar);
                sVar6 = this.aOG.aOs;
                sVar6.notifyDataSetChanged();
            } else if (gVar.type == 0) {
                z = this.aOG.aOx;
                if (!z) {
                    new com.baidu.tieba.data.e();
                    com.baidu.tieba.data.e eVar2 = gVar.bsW;
                    dVar5 = this.aOG.aOu;
                    dVar5.c(eVar2);
                    sVar3 = this.aOG.aOs;
                    sVar3.b(eVar2);
                    sVar4 = this.aOG.aOs;
                    sVar4.notifyDataSetChanged();
                }
            }
        } else if (gVar.bsV != null && !gVar.bsV.equals("")) {
            baseFragmentActivity2 = this.aOG.aOz;
            baseFragmentActivity2.showToast(gVar.bsV);
        }
        if (gVar.type == 1 && TbadkCoreApplication.m255getInst().getIsNewRegUser()) {
            isShow = this.aOG.isShow();
            if (isShow) {
                sVar2 = this.aOG.aOs;
                sVar2.Jq();
                TbadkCoreApplication.m255getInst().setIsNewRegUser(false);
            }
        }
        if (gVar.type == 1) {
            j = this.aOG.aCo;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.aOG.aCo;
                dVar = this.aOG.aOu;
                long Uc = dVar.Uc();
                j3 = this.aOG.aCo;
                long j4 = Uc - j3;
                dVar2 = this.aOG.aOu;
                long Ua = dVar2.Ua();
                dVar3 = this.aOG.aOu;
                long Ub = dVar3.Ub();
                dVar4 = this.aOG.aOu;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Ua, Ub, currentTimeMillis - dVar4.TZ());
                this.aOG.aCo = -1L;
            }
        }
        com.baidu.tieba.data.e eVar3 = gVar.bsW;
        if (eVar3.BZ() == 1) {
            if (!eVar3.Ch()) {
                baseFragmentActivity3 = this.aOG.aOz;
                String.format(baseFragmentActivity3.getPageContext().getPageActivity().getString(z.signallforum_warning), Integer.valueOf(eVar3.Ca()));
                return;
            }
            return;
        }
        eVar3.Cb();
    }
}
