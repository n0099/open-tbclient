package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aKY = votePhotoGroupView;
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
        i2 = this.aKY.mode;
        if (i2 == 3) {
            if (z) {
                this.aKY.j(i, false);
            }
            i3 = this.aKY.aKV;
            if (i3 != i) {
                bVar3 = this.aKY.aKU;
                if (bVar3 != null) {
                    bVar4 = this.aKY.aKU;
                    aVar2 = this.aKY.aKW;
                    i4 = this.aKY.aKV;
                    bVar4.a(aVar2, i4, false);
                }
                this.aKY.aKW = aVar;
                this.aKY.aKV = i;
            }
        }
        bVar = this.aKY.aKU;
        if (bVar != null) {
            bVar2 = this.aKY.aKU;
            bVar2.a(aVar, i, z);
        }
    }
}
