package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aOt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aOt = votePhotoGroupView;
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
        i2 = this.aOt.mode;
        if (i2 == 3) {
            if (z) {
                this.aOt.j(i, false);
            }
            i3 = this.aOt.aOq;
            if (i3 != i) {
                bVar3 = this.aOt.aOp;
                if (bVar3 != null) {
                    bVar4 = this.aOt.aOp;
                    aVar2 = this.aOt.aOr;
                    i4 = this.aOt.aOq;
                    bVar4.a(aVar2, i4, false);
                }
                this.aOt.aOr = aVar;
                this.aOt.aOq = i;
            }
        }
        bVar = this.aOt.aOp;
        if (bVar != null) {
            bVar2 = this.aOt.aOp;
            bVar2.a(aVar, i, z);
        }
    }
}
