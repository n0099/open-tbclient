package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aFZ = votePhotoGroupView;
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
        i2 = this.aFZ.mode;
        if (i2 == 3) {
            if (z) {
                this.aFZ.g(i, false);
            }
            i3 = this.aFZ.aFW;
            if (i3 != i) {
                bVar3 = this.aFZ.aFV;
                if (bVar3 != null) {
                    bVar4 = this.aFZ.aFV;
                    aVar2 = this.aFZ.aFX;
                    i4 = this.aFZ.aFW;
                    bVar4.a(aVar2, i4, false);
                }
                this.aFZ.aFX = aVar;
                this.aFZ.aFW = i;
            }
        }
        bVar = this.aFZ.aFV;
        if (bVar != null) {
            bVar2 = this.aFZ.aFV;
            bVar2.a(aVar, i, z);
        }
    }
}
