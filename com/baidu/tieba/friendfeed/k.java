package com.baidu.tieba.friendfeed;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.location.j {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EJ() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayU.ayz;
        if (yVar != null) {
            yVar2 = this.ayU.ayz;
            if (yVar2.EQ() != null) {
                yVar3 = this.ayU.ayz;
                yVar3.EQ().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayU.ayz;
        if (yVar.EQ() != null) {
            yVar2 = this.ayU.ayz;
            yVar2.EQ().setLocationViewVisibility(0);
            yVar3 = this.ayU.ayz;
            yVar3.EQ().j(2, str);
        }
    }
}
