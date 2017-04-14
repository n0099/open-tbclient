package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aOJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aOJ = votePhotoGroupView;
    }

    @Override // com.baidu.tbadk.widget.vote.e.a
    public void b(a aVar, int i, boolean z) {
        int i2;
        b bVar;
        b bVar2;
        int i3;
        b bVar3;
        b bVar4;
        a aVar2;
        int i4;
        i2 = this.aOJ.mode;
        if (i2 == 3) {
            if (z) {
                this.aOJ.j(i, false);
            }
            i3 = this.aOJ.aOG;
            if (i3 != i) {
                bVar3 = this.aOJ.aOF;
                if (bVar3 != null) {
                    bVar4 = this.aOJ.aOF;
                    aVar2 = this.aOJ.aOH;
                    i4 = this.aOJ.aOG;
                    bVar4.a(aVar2, i4, false);
                }
                this.aOJ.aOH = aVar;
                this.aOJ.aOG = i;
            }
        }
        bVar = this.aOJ.aOF;
        if (bVar != null) {
            bVar2 = this.aOJ.aOF;
            bVar2.a(aVar, i, z);
        }
    }
}
