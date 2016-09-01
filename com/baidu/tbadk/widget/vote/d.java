package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aKG = votePhotoGroupView;
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
        i2 = this.aKG.mode;
        if (i2 == 3) {
            if (z) {
                this.aKG.j(i, false);
            }
            i3 = this.aKG.aKD;
            if (i3 != i) {
                bVar3 = this.aKG.aKC;
                if (bVar3 != null) {
                    bVar4 = this.aKG.aKC;
                    aVar2 = this.aKG.aKE;
                    i4 = this.aKG.aKD;
                    bVar4.a(aVar2, i4, false);
                }
                this.aKG.aKE = aVar;
                this.aKG.aKD = i;
            }
        }
        bVar = this.aKG.aKC;
        if (bVar != null) {
            bVar2 = this.aKG.aKC;
            bVar2.a(aVar, i, z);
        }
    }
}
