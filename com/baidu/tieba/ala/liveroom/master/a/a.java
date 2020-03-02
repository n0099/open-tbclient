package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f eUa;
    protected com.baidu.tieba.ala.liveroom.data.e ffa;
    protected AlaMasterLiveRoomOpearator fgx;
    protected b fgy;
    protected int mCurrentState;

    public abstract void aw(int i, String str);

    public abstract void boU();

    public a(f fVar) {
        this.eUa = fVar;
    }

    public void ac(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fgx = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fgx != null) {
                    this.fgx.bnI();
                    return;
                }
                return;
            case 3:
                if (this.fgx != null) {
                    this.fgx.bnJ();
                    return;
                }
                return;
            case 4:
                if (this.fgx != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fgx.d(eVar);
                    if (this.fgy != null) {
                        this.fgy.b(eVar);
                    }
                    if (eVar != null && eVar.faC) {
                        this.eUa.faK.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fgx != null) {
                    this.fgx.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fgx != null) {
                    this.fgx.bnO();
                    return;
                }
                return;
            case 7:
                if (this.fgx != null) {
                    this.fgx.bnP();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fgx != null) {
                    this.fgx.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffa = eVar;
        boU();
    }

    public void c(h hVar) {
        if (this.eUa != null && this.eUa.faK != null) {
            this.eUa.faK.a((short) 5, hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgx != null) {
            this.fgx.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.eUa != null && this.eUa.faK != null) {
            this.eUa.faK.a((short) 8, Short.valueOf(s));
        }
    }

    public void boV() {
        if (this.fgx != null) {
            this.fgx.bnS();
        }
    }

    public void boW() {
        if (this.fgx != null) {
            this.fgx.bnT();
        }
    }

    public void onPause() {
        if (this.fgx != null) {
            this.fgx.onPause();
        }
    }

    public boolean boX() {
        if (this.fgx != null) {
            return this.fgx.bnQ();
        }
        return false;
    }

    public void boY() {
        if (this.fgx != null) {
            this.fgx.bnR();
        }
    }

    public boolean boZ() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fgy = bVar;
    }
}
