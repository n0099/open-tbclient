package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aOL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aOL = votePhotoGroupView;
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
        i2 = this.aOL.mode;
        if (i2 == 3) {
            if (z) {
                this.aOL.j(i, false);
            }
            i3 = this.aOL.aOI;
            if (i3 != i) {
                bVar3 = this.aOL.aOH;
                if (bVar3 != null) {
                    bVar4 = this.aOL.aOH;
                    aVar2 = this.aOL.aOJ;
                    i4 = this.aOL.aOI;
                    bVar4.a(aVar2, i4, false);
                }
                this.aOL.aOJ = aVar;
                this.aOL.aOI = i;
            }
        }
        bVar = this.aOL.aOH;
        if (bVar != null) {
            bVar2 = this.aOL.aOH;
            bVar2.a(aVar, i, z);
        }
    }
}
