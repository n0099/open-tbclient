package com.baidu.tieba.friendFeed;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IW() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHU.aHB;
        if (yVar.Je() != null) {
            yVar2 = this.aHU.aHB;
            if (yVar2.Je().getLocationViewVisibility() == 0) {
                this.aHU.showToast(com.baidu.tieba.y.no_network_guide);
            }
            yVar3 = this.aHU.aHB;
            yVar3.Je().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fH(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHU.aHB;
        if (yVar.Je() != null) {
            yVar2 = this.aHU.aHB;
            if (yVar2.Je().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.aHU;
                if (StringUtils.isNull(str)) {
                    str = this.aHU.getPageContext().getString(com.baidu.tieba.y.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            yVar3 = this.aHU.aHB;
            yVar3.Je().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        y yVar;
        y yVar2;
        if (aVar != null && !StringUtils.isNull(aVar.anm())) {
            yVar = this.aHU.aHB;
            if (yVar.Je() != null) {
                yVar2 = this.aHU.aHB;
                yVar2.Je().B(2, aVar.anm());
                return;
            }
            return;
        }
        fH(null);
    }
}
