package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aJO = votePhotoGroupView;
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
        i2 = this.aJO.mode;
        if (i2 == 3) {
            if (z) {
                this.aJO.g(i, false);
            }
            i3 = this.aJO.aJL;
            if (i3 != i) {
                bVar3 = this.aJO.aJK;
                if (bVar3 != null) {
                    bVar4 = this.aJO.aJK;
                    aVar2 = this.aJO.aJM;
                    i4 = this.aJO.aJL;
                    bVar4.a(aVar2, i4, false);
                }
                this.aJO.aJM = aVar;
                this.aJO.aJL = i;
            }
        }
        bVar = this.aJO.aJK;
        if (bVar != null) {
            bVar2 = this.aJO.aJK;
            bVar2.a(aVar, i, z);
        }
    }
}
