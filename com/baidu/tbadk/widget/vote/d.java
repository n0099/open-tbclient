package com.baidu.tbadk.widget.vote;

import com.baidu.tbadk.widget.vote.e;
/* loaded from: classes.dex */
class d implements e.a {
    final /* synthetic */ VotePhotoGroupView aHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VotePhotoGroupView votePhotoGroupView) {
        this.aHq = votePhotoGroupView;
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
        i2 = this.aHq.mode;
        if (i2 == 3) {
            if (z) {
                this.aHq.j(i, false);
            }
            i3 = this.aHq.aHn;
            if (i3 != i) {
                bVar3 = this.aHq.aHm;
                if (bVar3 != null) {
                    bVar4 = this.aHq.aHm;
                    aVar2 = this.aHq.aHo;
                    i4 = this.aHq.aHn;
                    bVar4.a(aVar2, i4, false);
                }
                this.aHq.aHo = aVar;
                this.aHq.aHn = i;
            }
        }
        bVar = this.aHq.aHm;
        if (bVar != null) {
            bVar2 = this.aHq.aHm;
            bVar2.a(aVar, i, z);
        }
    }
}
