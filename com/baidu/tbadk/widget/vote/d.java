package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aBN = votePhotoGroupView;
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
        i2 = this.aBN.mode;
        if (i2 == 3) {
            if (z) {
                this.aBN.g(i, false);
            }
            i3 = this.aBN.aBK;
            if (i3 != i) {
                bVar3 = this.aBN.aBJ;
                if (bVar3 != null) {
                    bVar4 = this.aBN.aBJ;
                    aVar2 = this.aBN.aBL;
                    i4 = this.aBN.aBK;
                    bVar4.a(aVar2, i4, false);
                }
                this.aBN.aBL = aVar;
                this.aBN.aBK = i;
            }
        }
        bVar = this.aBN.aBJ;
        if (bVar != null) {
            bVar2 = this.aBN.aBJ;
            bVar2.a(aVar, i, z);
        }
    }
}
