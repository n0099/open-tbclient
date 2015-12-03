package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aEz = votePhotoGroupView;
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
        i2 = this.aEz.mode;
        if (i2 == 3) {
            if (z) {
                this.aEz.g(i, false);
            }
            i3 = this.aEz.aEw;
            if (i3 != i) {
                bVar3 = this.aEz.aEv;
                if (bVar3 != null) {
                    bVar4 = this.aEz.aEv;
                    aVar2 = this.aEz.aEx;
                    i4 = this.aEz.aEw;
                    bVar4.a(aVar2, i4, false);
                }
                this.aEz.aEx = aVar;
                this.aEz.aEw = i;
            }
        }
        bVar = this.aEz.aEv;
        if (bVar != null) {
            bVar2 = this.aEz.aEv;
            bVar2.a(aVar, i, z);
        }
    }
}
