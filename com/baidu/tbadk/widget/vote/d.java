package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aPe = votePhotoGroupView;
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
        i2 = this.aPe.mode;
        if (i2 == 3) {
            if (z) {
                this.aPe.j(i, false);
            }
            i3 = this.aPe.aPb;
            if (i3 != i) {
                bVar3 = this.aPe.aPa;
                if (bVar3 != null) {
                    bVar4 = this.aPe.aPa;
                    aVar2 = this.aPe.aPc;
                    i4 = this.aPe.aPb;
                    bVar4.a(aVar2, i4, false);
                }
                this.aPe.aPc = aVar;
                this.aPe.aPb = i;
            }
        }
        bVar = this.aPe.aPa;
        if (bVar != null) {
            bVar2 = this.aPe.aPa;
            bVar2.a(aVar, i, z);
        }
    }
}
