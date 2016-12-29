package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aKp = votePhotoGroupView;
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
        i2 = this.aKp.mode;
        if (i2 == 3) {
            if (z) {
                this.aKp.j(i, false);
            }
            i3 = this.aKp.aKm;
            if (i3 != i) {
                bVar3 = this.aKp.aKl;
                if (bVar3 != null) {
                    bVar4 = this.aKp.aKl;
                    aVar2 = this.aKp.aKn;
                    i4 = this.aKp.aKm;
                    bVar4.a(aVar2, i4, false);
                }
                this.aKp.aKn = aVar;
                this.aKp.aKm = i;
            }
        }
        bVar = this.aKp.aKl;
        if (bVar != null) {
            bVar2 = this.aKp.aKl;
            bVar2.a(aVar, i, z);
        }
    }
}
