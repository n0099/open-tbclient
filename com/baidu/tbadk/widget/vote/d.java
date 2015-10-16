package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aCT = votePhotoGroupView;
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
        i2 = this.aCT.mode;
        if (i2 == 3) {
            if (z) {
                this.aCT.h(i, false);
            }
            i3 = this.aCT.aCQ;
            if (i3 != i) {
                bVar3 = this.aCT.aCP;
                if (bVar3 != null) {
                    bVar4 = this.aCT.aCP;
                    aVar2 = this.aCT.aCR;
                    i4 = this.aCT.aCQ;
                    bVar4.a(aVar2, i4, false);
                }
                this.aCT.aCR = aVar;
                this.aCT.aCQ = i;
            }
        }
        bVar = this.aCT.aCP;
        if (bVar != null) {
            bVar2 = this.aCT.aCP;
            bVar2.a(aVar, i, z);
        }
    }
}
