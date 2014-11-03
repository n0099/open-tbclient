package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.location.i {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EI() {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBu.aAF;
        if (buVar.EQ() != null) {
            buVar2 = this.aBu.aAF;
            if (buVar2.EQ().getLocationViewVisibility() == 0) {
                this.aBu.showToast(com.baidu.tieba.y.no_network_guide);
            }
            buVar3 = this.aBu.aAF;
            buVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBu.aAF;
        if (buVar.EQ() != null) {
            buVar2 = this.aBu.aAF;
            if (buVar2.EQ().getLocationViewVisibility() == 0) {
                FrsActivity frsActivity = this.aBu;
                if (StringUtils.isNull(str)) {
                    str = this.aBu.getString(com.baidu.tieba.y.location_fail);
                }
                frsActivity.showToast(str);
            }
            buVar3 = this.aBu.aAF;
            buVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        bu buVar;
        bu buVar2;
        if (aVar != null && !StringUtils.isNull(aVar.So())) {
            buVar = this.aBu.aAF;
            if (buVar.EQ() != null) {
                buVar2 = this.aBu.aAF;
                buVar2.EQ().j(2, aVar.So());
                return;
            }
            return;
        }
        eY(null);
    }
}
