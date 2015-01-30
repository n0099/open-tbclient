package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fx() {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDW.aCY;
        if (bpVar.FF() != null) {
            bpVar2 = this.aDW.aCY;
            if (bpVar2.FF().getLocationViewVisibility() == 0) {
                this.aDW.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bpVar3 = this.aDW.aCY;
            bpVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fy(String str) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDW.aCY;
        if (bpVar.FF() != null) {
            bpVar2 = this.aDW.aCY;
            if (bpVar2.FF().getLocationViewVisibility() == 0) {
                FrsActivity frsActivity = this.aDW;
                if (StringUtils.isNull(str)) {
                    str = this.aDW.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                frsActivity.showToast(str);
            }
            bpVar3 = this.aDW.aCY;
            bpVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bp bpVar;
        bp bpVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahY())) {
            bpVar = this.aDW.aCY;
            if (bpVar.FF() != null) {
                bpVar2 = this.aDW.aCY;
                bpVar2.FF().B(2, aVar.ahY());
                return;
            }
            return;
        }
        fy(null);
    }
}
