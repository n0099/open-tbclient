package com.baidu.tieba.friendfeed;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.location.i {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EG() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayL.ayq;
        if (yVar.EO() != null) {
            yVar2 = this.ayL.ayq;
            if (yVar2.EO().getLocationViewVisibility() == 0) {
                this.ayL.showToast(com.baidu.tieba.y.no_network_guide);
            }
            yVar3 = this.ayL.ayq;
            yVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayL.ayq;
        if (yVar.EO() != null) {
            yVar2 = this.ayL.ayq;
            if (yVar2.EO().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.ayL;
                if (StringUtils.isNull(str)) {
                    str = this.ayL.getString(com.baidu.tieba.y.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            yVar3 = this.ayL.ayq;
            yVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        y yVar;
        y yVar2;
        if (aVar != null && !StringUtils.isNull(aVar.Sl())) {
            yVar = this.ayL.ayq;
            if (yVar.EO() != null) {
                yVar2 = this.ayL.ayq;
                yVar2.EO().j(2, aVar.Sl());
                return;
            }
            return;
        }
        eY(null);
    }
}
