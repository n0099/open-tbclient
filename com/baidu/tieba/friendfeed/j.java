package com.baidu.tieba.friendfeed;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.location.i {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EI() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayU.ayz;
        if (yVar.EQ() != null) {
            yVar2 = this.ayU.ayz;
            if (yVar2.EQ().getLocationViewVisibility() == 0) {
                this.ayU.showToast(com.baidu.tieba.y.no_network_guide);
            }
            yVar3 = this.ayU.ayz;
            yVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayU.ayz;
        if (yVar.EQ() != null) {
            yVar2 = this.ayU.ayz;
            if (yVar2.EQ().getLocationViewVisibility() == 0) {
                FriendFeedActivity friendFeedActivity = this.ayU;
                if (StringUtils.isNull(str)) {
                    str = this.ayU.getString(com.baidu.tieba.y.location_fail);
                }
                friendFeedActivity.showToast(str);
            }
            yVar3 = this.ayU.ayz;
            yVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        y yVar;
        y yVar2;
        if (aVar != null && !StringUtils.isNull(aVar.So())) {
            yVar = this.ayU.ayz;
            if (yVar.EQ() != null) {
                yVar2 = this.ayU.ayz;
                yVar2.EQ().j(2, aVar.So());
                return;
            }
            return;
        }
        eY(null);
    }
}
