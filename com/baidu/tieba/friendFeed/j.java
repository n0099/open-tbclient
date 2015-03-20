package com.baidu.tieba.friendFeed;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void IR() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHM.aHt;
        if (yVar != null) {
            yVar2 = this.aHM.aHt;
            if (yVar2.IY() != null) {
                yVar3 = this.aHM.aHt;
                yVar3.IY().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void fF(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aHM.aHt;
        if (yVar.IY() != null) {
            yVar2 = this.aHM.aHt;
            yVar2.IY().setLocationViewVisibility(0);
            yVar3 = this.aHM.aHt;
            yVar3.IY().B(2, str);
        }
    }
}
