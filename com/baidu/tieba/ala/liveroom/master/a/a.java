package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f eTZ;
    protected com.baidu.tieba.ala.liveroom.data.e feZ;
    protected AlaMasterLiveRoomOpearator fgw;
    protected b fgx;
    protected int mCurrentState;

    public abstract void aw(int i, String str);

    public abstract void boS();

    public a(f fVar) {
        this.eTZ = fVar;
    }

    public void ac(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fgw = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fgw != null) {
                    this.fgw.bnG();
                    return;
                }
                return;
            case 3:
                if (this.fgw != null) {
                    this.fgw.bnH();
                    return;
                }
                return;
            case 4:
                if (this.fgw != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fgw.d(eVar);
                    if (this.fgx != null) {
                        this.fgx.b(eVar);
                    }
                    if (eVar != null && eVar.faB) {
                        this.eTZ.faJ.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fgw != null) {
                    this.fgw.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fgw != null) {
                    this.fgw.bnM();
                    return;
                }
                return;
            case 7:
                if (this.fgw != null) {
                    this.fgw.bnN();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fgw != null) {
                    this.fgw.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.feZ = eVar;
        boS();
    }

    public void c(h hVar) {
        if (this.eTZ != null && this.eTZ.faJ != null) {
            this.eTZ.faJ.a((short) 5, hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgw != null) {
            this.fgw.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.eTZ != null && this.eTZ.faJ != null) {
            this.eTZ.faJ.a((short) 8, Short.valueOf(s));
        }
    }

    public void boT() {
        if (this.fgw != null) {
            this.fgw.bnQ();
        }
    }

    public void boU() {
        if (this.fgw != null) {
            this.fgw.bnR();
        }
    }

    public void onPause() {
        if (this.fgw != null) {
            this.fgw.onPause();
        }
    }

    public boolean boV() {
        if (this.fgw != null) {
            return this.fgw.bnO();
        }
        return false;
    }

    public void boW() {
        if (this.fgw != null) {
            this.fgw.bnP();
        }
    }

    public boolean boX() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fgx = bVar;
    }
}
