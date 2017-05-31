package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aPd = votePhotoGroupView;
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
        i2 = this.aPd.mode;
        if (i2 == 3) {
            if (z) {
                this.aPd.j(i, false);
            }
            i3 = this.aPd.aPa;
            if (i3 != i) {
                bVar3 = this.aPd.aOZ;
                if (bVar3 != null) {
                    bVar4 = this.aPd.aOZ;
                    aVar2 = this.aPd.aPb;
                    i4 = this.aPd.aPa;
                    bVar4.a(aVar2, i4, false);
                }
                this.aPd.aPb = aVar;
                this.aPd.aPa = i;
            }
        }
        bVar = this.aPd.aOZ;
        if (bVar != null) {
            bVar2 = this.aPd.aOZ;
            bVar2.a(aVar, i, z);
        }
    }
}
