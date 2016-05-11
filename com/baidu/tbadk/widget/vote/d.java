package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aFX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aFX = votePhotoGroupView;
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
        i2 = this.aFX.mode;
        if (i2 == 3) {
            if (z) {
                this.aFX.i(i, false);
            }
            i3 = this.aFX.aFU;
            if (i3 != i) {
                bVar3 = this.aFX.aFT;
                if (bVar3 != null) {
                    bVar4 = this.aFX.aFT;
                    aVar2 = this.aFX.aFV;
                    i4 = this.aFX.aFU;
                    bVar4.a(aVar2, i4, false);
                }
                this.aFX.aFV = aVar;
                this.aFX.aFU = i;
            }
        }
        bVar = this.aFX.aFT;
        if (bVar != null) {
            bVar2 = this.aFX.aFT;
            bVar2.a(aVar, i, z);
        }
    }
}
