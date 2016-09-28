package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aKf = votePhotoGroupView;
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
        i2 = this.aKf.mode;
        if (i2 == 3) {
            if (z) {
                this.aKf.j(i, false);
            }
            i3 = this.aKf.aKc;
            if (i3 != i) {
                bVar3 = this.aKf.aKb;
                if (bVar3 != null) {
                    bVar4 = this.aKf.aKb;
                    aVar2 = this.aKf.aKd;
                    i4 = this.aKf.aKc;
                    bVar4.a(aVar2, i4, false);
                }
                this.aKf.aKd = aVar;
                this.aKf.aKc = i;
            }
        }
        bVar = this.aKf.aKb;
        if (bVar != null) {
            bVar2 = this.aKf.aKb;
            bVar2.a(aVar, i, z);
        }
    }
}
