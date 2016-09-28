package com.baidu.tieba.frs;

import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class j implements a.InterfaceC0058a {
    final /* synthetic */ FrsActivity bQi;
    final int bQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bQi = frsActivity;
        this.bQj = (int) frsActivity.getResources().getDimension(r.e.ds98);
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void O(int i, int i2) {
        bm bmVar;
        bm bmVar2;
        dj djVar;
        dj djVar2;
        dj djVar3;
        if (af(i2)) {
            djVar = this.bQi.bPB;
            if (djVar != null) {
                djVar2 = this.bQi.bPB;
                djVar2.dq(false);
                djVar3 = this.bQi.bPB;
                djVar3.Zd();
            }
        }
        bmVar = this.bQi.bPi;
        if (bmVar != null) {
            bmVar2 = this.bQi.bPi;
            bmVar2.dN(true);
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        bm bmVar;
        bm bmVar2;
        dj djVar;
        dj djVar2;
        dj djVar3;
        if (af(i2)) {
            djVar = this.bQi.bPB;
            if (djVar != null) {
                djVar2 = this.bQi.bPB;
                djVar2.dq(true);
                if (Math.abs(i2) > this.bQj) {
                    djVar3 = this.bQi.bPB;
                    djVar3.Zc();
                }
            }
        }
        bmVar = this.bQi.bPi;
        if (bmVar != null) {
            bmVar2 = this.bQi.bPi;
            bmVar2.dN(false);
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
