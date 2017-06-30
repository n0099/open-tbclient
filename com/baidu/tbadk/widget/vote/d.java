package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aQv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aQv = votePhotoGroupView;
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
        i2 = this.aQv.mode;
        if (i2 == 3) {
            if (z) {
                this.aQv.j(i, false);
            }
            i3 = this.aQv.aQs;
            if (i3 != i) {
                bVar3 = this.aQv.aQr;
                if (bVar3 != null) {
                    bVar4 = this.aQv.aQr;
                    aVar2 = this.aQv.aQt;
                    i4 = this.aQv.aQs;
                    bVar4.a(aVar2, i4, false);
                }
                this.aQv.aQt = aVar;
                this.aQv.aQs = i;
            }
        }
        bVar = this.aQv.aQr;
        if (bVar != null) {
            bVar2 = this.aQv.aQr;
            bVar2.a(aVar, i, z);
        }
    }
}
