package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aIW = votePhotoGroupView;
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
        i2 = this.aIW.mode;
        if (i2 == 3) {
            if (z) {
                this.aIW.j(i, false);
            }
            i3 = this.aIW.aIT;
            if (i3 != i) {
                bVar3 = this.aIW.aIS;
                if (bVar3 != null) {
                    bVar4 = this.aIW.aIS;
                    aVar2 = this.aIW.aIU;
                    i4 = this.aIW.aIT;
                    bVar4.a(aVar2, i4, false);
                }
                this.aIW.aIU = aVar;
                this.aIW.aIT = i;
            }
        }
        bVar = this.aIW.aIS;
        if (bVar != null) {
            bVar2 = this.aIW.aIS;
            bVar2.a(aVar, i, z);
        }
    }
}
