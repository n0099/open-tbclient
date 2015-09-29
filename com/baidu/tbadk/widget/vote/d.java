package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aCI = votePhotoGroupView;
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
        i2 = this.aCI.mode;
        if (i2 == 3) {
            if (z) {
                this.aCI.h(i, false);
            }
            i3 = this.aCI.aCF;
            if (i3 != i) {
                bVar3 = this.aCI.aCE;
                if (bVar3 != null) {
                    bVar4 = this.aCI.aCE;
                    aVar2 = this.aCI.aCG;
                    i4 = this.aCI.aCF;
                    bVar4.a(aVar2, i4, false);
                }
                this.aCI.aCG = aVar;
                this.aCI.aCF = i;
            }
        }
        bVar = this.aCI.aCE;
        if (bVar != null) {
            bVar2 = this.aCI.aCE;
            bVar2.a(aVar, i, z);
        }
    }
}
