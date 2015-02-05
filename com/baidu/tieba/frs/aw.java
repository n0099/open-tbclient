package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fr() {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDT.aCV;
        if (bpVar.Fz() != null) {
            bpVar2 = this.aDT.aCV;
            if (bpVar2.Fz().getLocationViewVisibility() == 0) {
                this.aDT.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bpVar3 = this.aDT.aCV;
            bpVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fv(String str) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDT.aCV;
        if (bpVar.Fz() != null) {
            bpVar2 = this.aDT.aCV;
            if (bpVar2.Fz().getLocationViewVisibility() == 0) {
                FrsActivity frsActivity = this.aDT;
                if (StringUtils.isNull(str)) {
                    str = this.aDT.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                frsActivity.showToast(str);
            }
            bpVar3 = this.aDT.aCV;
            bpVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bp bpVar;
        bp bpVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahT())) {
            bpVar = this.aDT.aCV;
            if (bpVar.Fz() != null) {
                bpVar2 = this.aDT.aCV;
                bpVar2.Fz().B(2, aVar.ahT());
                return;
            }
            return;
        }
        fv(null);
    }
}
