package com.baidu.tieba.friendfeed;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fy() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBV.aBD;
        if (xVar != null) {
            xVar2 = this.aBV.aBD;
            if (xVar2.FF() != null) {
                xVar3 = this.aBV.aBD;
                xVar3.FF().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fz(String str) {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBV.aBD;
        if (xVar.FF() != null) {
            xVar2 = this.aBV.aBD;
            xVar2.FF().setLocationViewVisibility(0);
            xVar3 = this.aBV.aBD;
            xVar3.FF().B(2, str);
        }
    }
}
