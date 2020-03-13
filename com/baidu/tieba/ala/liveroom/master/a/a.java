package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f eUn;
    protected com.baidu.tieba.ala.liveroom.data.e ffn;
    protected AlaMasterLiveRoomOpearator fgK;
    protected b fgL;
    protected int mCurrentState;

    public abstract void aw(int i, String str);

    public abstract void boV();

    public a(f fVar) {
        this.eUn = fVar;
    }

    public void ac(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fgK = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fgK != null) {
                    this.fgK.bnJ();
                    return;
                }
                return;
            case 3:
                if (this.fgK != null) {
                    this.fgK.bnK();
                    return;
                }
                return;
            case 4:
                if (this.fgK != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fgK.d(eVar);
                    if (this.fgL != null) {
                        this.fgL.b(eVar);
                    }
                    if (eVar != null && eVar.faP) {
                        this.eUn.faX.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fgK != null) {
                    this.fgK.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fgK != null) {
                    this.fgK.bnP();
                    return;
                }
                return;
            case 7:
                if (this.fgK != null) {
                    this.fgK.bnQ();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fgK != null) {
                    this.fgK.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffn = eVar;
        boV();
    }

    public void c(h hVar) {
        if (this.eUn != null && this.eUn.faX != null) {
            this.eUn.faX.a((short) 5, hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgK != null) {
            this.fgK.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.eUn != null && this.eUn.faX != null) {
            this.eUn.faX.a((short) 8, Short.valueOf(s));
        }
    }

    public void boW() {
        if (this.fgK != null) {
            this.fgK.bnT();
        }
    }

    public void boX() {
        if (this.fgK != null) {
            this.fgK.bnU();
        }
    }

    public void onPause() {
        if (this.fgK != null) {
            this.fgK.onPause();
        }
    }

    public boolean boY() {
        if (this.fgK != null) {
            return this.fgK.bnR();
        }
        return false;
    }

    public void boZ() {
        if (this.fgK != null) {
            this.fgK.bnS();
        }
    }

    public boolean bpa() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fgL = bVar;
    }
}
