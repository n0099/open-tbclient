package com.baidu.tieba.friendfeed;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fs() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBS.aBA;
        if (xVar != null) {
            xVar2 = this.aBS.aBA;
            if (xVar2.Fz() != null) {
                xVar3 = this.aBS.aBA;
                xVar3.Fz().setLocationViewVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fw(String str) {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aBS.aBA;
        if (xVar.Fz() != null) {
            xVar2 = this.aBS.aBA;
            xVar2.Fz().setLocationViewVisibility(0);
            xVar3 = this.aBS.aBA;
            xVar3.Fz().B(2, str);
        }
    }
}
