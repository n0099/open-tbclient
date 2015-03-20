package com.baidu.tieba.friendFeed;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IQ() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHM.aHt;
        if (yVar.IY() != null) {
            yVar2 = this.aHM.aHt;
            if (yVar2.IY().getLocationViewVisibility() == 0) {
                this.aHM.showToast(com.baidu.tieba.y.no_network_guide);
            }
            yVar3 = this.aHM.aHt;
            yVar3.IY().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fE(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHM.aHt;
        if (yVar.IY() != null) {
            yVar2 = this.aHM.aHt;
            if (yVar2.IY().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.aHM;
                if (StringUtils.isNull(str)) {
                    str = this.aHM.getPageContext().getString(com.baidu.tieba.y.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            yVar3 = this.aHM.aHt;
            yVar3.IY().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        y yVar;
        y yVar2;
        if (aVar != null && !StringUtils.isNull(aVar.amX())) {
            yVar = this.aHM.aHt;
            if (yVar.IY() != null) {
                yVar2 = this.aHM.aHt;
                yVar2.IY().B(2, aVar.amX());
                return;
            }
            return;
        }
        fE(null);
    }
}
