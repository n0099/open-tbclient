package com.baidu.tieba.friendfeed;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.location.j {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EH() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayL.ayq;
        if (yVar != null) {
            yVar2 = this.ayL.ayq;
            if (yVar2.EO() != null) {
                yVar3 = this.ayL.ayq;
                yVar3.EO().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.ayL.ayq;
        if (yVar.EO() != null) {
            yVar2 = this.ayL.ayq;
            yVar2.EO().setLocationViewVisibility(0);
            yVar3 = this.ayL.ayq;
            yVar3.EO().j(2, str);
        }
    }
}
