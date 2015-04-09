package com.baidu.tieba.friendFeed;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void IX() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHU.aHB;
        if (yVar != null) {
            yVar2 = this.aHU.aHB;
            if (yVar2.Je() != null) {
                yVar3 = this.aHU.aHB;
                yVar3.Je().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void fI(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHU.aHB;
        if (yVar.Je() != null) {
            yVar2 = this.aHU.aHB;
            yVar2.Je().setLocationViewVisibility(0);
            yVar3 = this.aHU.aHB;
            yVar3.Je().B(2, str);
        }
    }
}
