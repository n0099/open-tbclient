package com.baidu.tieba.friendfeed;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fx() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBV.aBD;
        if (xVar.FF() != null) {
            xVar2 = this.aBV.aBD;
            if (xVar2.FF().getLocationViewVisibility() == 0) {
                this.aBV.showToast(z.no_network_guide);
            }
            xVar3 = this.aBV.aBD;
            xVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fy(String str) {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBV.aBD;
        if (xVar.FF() != null) {
            xVar2 = this.aBV.aBD;
            if (xVar2.FF().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.aBV;
                if (StringUtils.isNull(str)) {
                    str = this.aBV.getPageContext().getString(z.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            xVar3 = this.aBV.aBD;
            xVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        x xVar;
        x xVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahY())) {
            xVar = this.aBV.aBD;
            if (xVar.FF() != null) {
                xVar2 = this.aBV.aBD;
                xVar2.FF().B(2, aVar.ahY());
                return;
            }
            return;
        }
        fy(null);
    }
}
