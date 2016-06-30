package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aGz = votePhotoGroupView;
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
        i2 = this.aGz.mode;
        if (i2 == 3) {
            if (z) {
                this.aGz.i(i, false);
            }
            i3 = this.aGz.aGw;
            if (i3 != i) {
                bVar3 = this.aGz.aGv;
                if (bVar3 != null) {
                    bVar4 = this.aGz.aGv;
                    aVar2 = this.aGz.aGx;
                    i4 = this.aGz.aGw;
                    bVar4.a(aVar2, i4, false);
                }
                this.aGz.aGx = aVar;
                this.aGz.aGw = i;
            }
        }
        bVar = this.aGz.aGv;
        if (bVar != null) {
            bVar2 = this.aGz.aGv;
            bVar2.a(aVar, i, z);
        }
    }
}
