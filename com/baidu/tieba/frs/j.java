package com.baidu.tieba.frs;

import com.baidu.tieba.e.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class j implements a.InterfaceC0055a {
    final /* synthetic */ FrsActivity bQp;
    final int bQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bQp = frsActivity;
        this.bQq = (int) frsActivity.getResources().getDimension(t.e.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void N(int i, int i2) {
        bm bmVar;
        bm bmVar2;
        dj djVar;
        dj djVar2;
        dj djVar3;
        if (af(i2)) {
            djVar = this.bQp.bPJ;
            if (djVar != null) {
                djVar2 = this.bQp.bPJ;
                djVar2.dp(false);
                djVar3 = this.bQp.bPJ;
                djVar3.YO();
            }
        }
        bmVar = this.bQp.bPo;
        if (bmVar != null) {
            bmVar2 = this.bQp.bPo;
            bmVar2.dM(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void O(int i, int i2) {
        bm bmVar;
        bm bmVar2;
        dj djVar;
        dj djVar2;
        dj djVar3;
        if (af(i2)) {
            djVar = this.bQp.bPJ;
            if (djVar != null) {
                djVar2 = this.bQp.bPJ;
                djVar2.dp(true);
                if (Math.abs(i2) > this.bQq) {
                    djVar3 = this.bQp.bPJ;
                    djVar3.YN();
                }
            }
        }
        bmVar = this.bQp.bPo;
        if (bmVar != null) {
            bmVar2 = this.bQp.bPo;
            bmVar2.dM(false);
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
