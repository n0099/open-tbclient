package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f fYL;
    protected com.baidu.tieba.ala.liveroom.data.e glk;
    protected AlaMasterLiveRoomOpearator gmH;
    protected b gmI;
    protected int mCurrentState;

    public abstract void aU(int i, String str);

    public abstract void bHE();

    public a(f fVar) {
        this.fYL = fVar;
    }

    public void aj(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.gmH = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.gmH != null) {
                    this.gmH.bGs();
                    return;
                }
                return;
            case 3:
                if (this.gmH != null) {
                    this.gmH.bGt();
                    return;
                }
                return;
            case 4:
                if (this.gmH != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.gmH.d(eVar);
                    if (this.gmI != null) {
                        this.gmI.b(eVar);
                    }
                    if (eVar != null && eVar.ggm) {
                        this.fYL.ggv.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.gmH != null) {
                    this.gmH.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.gmH != null) {
                    this.gmH.bGy();
                    return;
                }
                return;
            case 7:
                if (this.gmH != null) {
                    this.gmH.bGz();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.gmH != null) {
                    this.gmH.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.glk = eVar;
        bHE();
    }

    public void c(h hVar) {
        if (this.fYL != null && this.fYL.ggv != null) {
            this.fYL.ggv.a((short) 5, hVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gmH != null) {
            this.gmH.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.fYL != null && this.fYL.ggv != null) {
            this.fYL.ggv.a((short) 8, Short.valueOf(s));
        }
    }

    public void bHF() {
        if (this.gmH != null) {
            this.gmH.bGC();
        }
    }

    public void bHG() {
        if (this.gmH != null) {
            this.gmH.bGD();
        }
    }

    public void onPause() {
        if (this.gmH != null) {
            this.gmH.onPause();
        }
    }

    public boolean bHH() {
        if (this.gmH != null) {
            return this.gmH.bGA();
        }
        return false;
    }

    public void bHI() {
        if (this.gmH != null) {
            this.gmH.bGB();
        }
    }

    public boolean bHJ() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.gmI = bVar;
    }
}
