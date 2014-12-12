package com.baidu.tieba.friendfeed;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fa() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aAU.aAB;
        if (yVar != null) {
            yVar2 = this.aAU.aAB;
            if (yVar2.Fh() != null) {
                yVar3 = this.aAU.aAB;
                yVar3.Fh().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fu(String str) {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.aAU.aAB;
        if (yVar.Fh() != null) {
            yVar2 = this.aAU.aAB;
            yVar2.Fh().setLocationViewVisibility(0);
            yVar3 = this.aAU.aAB;
            yVar3.Fh().B(2, str);
        }
    }
}
