package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ax implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void EZ() {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bqVar = this.aCV.aBX;
        if (bqVar.Fh() != null) {
            bqVar2 = this.aCV.aBX;
            if (bqVar2.Fh().getLocationViewVisibility() == 0) {
                this.aCV.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bqVar3 = this.aCV.aBX;
            bqVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void ft(String str) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bqVar = this.aCV.aBX;
        if (bqVar.Fh() != null) {
            bqVar2 = this.aCV.aBX;
            if (bqVar2.Fh().getLocationViewVisibility() == 0) {
                FrsActivity frsActivity = this.aCV;
                if (StringUtils.isNull(str)) {
                    str = this.aCV.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                frsActivity.showToast(str);
            }
            bqVar3 = this.aCV.aBX;
            bqVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bq bqVar;
        bq bqVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahu())) {
            bqVar = this.aCV.aBX;
            if (bqVar.Fh() != null) {
                bqVar2 = this.aCV.aBX;
                bqVar2.Fh().B(2, aVar.ahu());
                return;
            }
            return;
        }
        ft(null);
    }
}
