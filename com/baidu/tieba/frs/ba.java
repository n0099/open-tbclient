package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.location.i {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EG() {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBk.aAv;
        if (buVar.EO() != null) {
            buVar2 = this.aBk.aAv;
            if (buVar2.EO().getLocationViewVisibility() == 0) {
                this.aBk.showToast(com.baidu.tieba.y.no_network_guide);
            }
            buVar3 = this.aBk.aAv;
            buVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBk.aAv;
        if (buVar.EO() != null) {
            buVar2 = this.aBk.aAv;
            if (buVar2.EO().getLocationViewVisibility() == 0) {
                FrsActivity frsActivity = this.aBk;
                if (StringUtils.isNull(str)) {
                    str = this.aBk.getString(com.baidu.tieba.y.location_fail);
                }
                frsActivity.showToast(str);
            }
            buVar3 = this.aBk.aAv;
            buVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        bu buVar;
        bu buVar2;
        if (aVar != null && !StringUtils.isNull(aVar.Sl())) {
            buVar = this.aBk.aAv;
            if (buVar.EO() != null) {
                buVar2 = this.aBk.aAv;
                buVar2.EO().j(2, aVar.Sl());
                return;
            }
            return;
        }
        eY(null);
    }
}
