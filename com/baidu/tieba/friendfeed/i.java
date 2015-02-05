package com.baidu.tieba.friendfeed;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fr() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBS.aBA;
        if (xVar.Fz() != null) {
            xVar2 = this.aBS.aBA;
            if (xVar2.Fz().getLocationViewVisibility() == 0) {
                this.aBS.showToast(z.no_network_guide);
            }
            xVar3 = this.aBS.aBA;
            xVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fv(String str) {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBS.aBA;
        if (xVar.Fz() != null) {
            xVar2 = this.aBS.aBA;
            if (xVar2.Fz().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.aBS;
                if (StringUtils.isNull(str)) {
                    str = this.aBS.getPageContext().getString(z.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            xVar3 = this.aBS.aBA;
            xVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        x xVar;
        x xVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahT())) {
            xVar = this.aBS.aBA;
            if (xVar.Fz() != null) {
                xVar2 = this.aBS.aBA;
                xVar2.Fz().B(2, aVar.ahT());
                return;
            }
            return;
        }
        fv(null);
    }
}
