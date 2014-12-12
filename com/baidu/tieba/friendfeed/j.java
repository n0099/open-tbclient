package com.baidu.tieba.friendfeed;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void EZ() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aAU.aAB;
        if (yVar.Fh() != null) {
            yVar2 = this.aAU.aAB;
            if (yVar2.Fh().getLocationViewVisibility() == 0) {
                this.aAU.showToast(com.baidu.tieba.z.no_network_guide);
            }
            yVar3 = this.aAU.aAB;
            yVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void ft(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aAU.aAB;
        if (yVar.Fh() != null) {
            yVar2 = this.aAU.aAB;
            if (yVar2.Fh().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.aAU;
                if (StringUtils.isNull(str)) {
                    str = this.aAU.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            yVar3 = this.aAU.aAB;
            yVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        y yVar;
        y yVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahu())) {
            yVar = this.aAU.aAB;
            if (yVar.Fh() != null) {
                yVar2 = this.aAU.aAB;
                yVar2.Fh().B(2, aVar.ahu());
                return;
            }
            return;
        }
        ft(null);
    }
}
