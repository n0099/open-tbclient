package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aGS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aGS = votePhotoGroupView;
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
        i2 = this.aGS.mode;
        if (i2 == 3) {
            if (z) {
                this.aGS.g(i, false);
            }
            i3 = this.aGS.aGP;
            if (i3 != i) {
                bVar3 = this.aGS.aGO;
                if (bVar3 != null) {
                    bVar4 = this.aGS.aGO;
                    aVar2 = this.aGS.aGQ;
                    i4 = this.aGS.aGP;
                    bVar4.a(aVar2, i4, false);
                }
                this.aGS.aGQ = aVar;
                this.aGS.aGP = i;
            }
        }
        bVar = this.aGS.aGO;
        if (bVar != null) {
            bVar2 = this.aGS.aGO;
            bVar2.a(aVar, i, z);
        }
    }
}
