package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected com.baidu.tieba.ala.liveroom.data.e fJU;
    protected AlaMasterLiveRoomOpearator fLv;
    protected b fLw;
    protected f fze;
    protected int mCurrentState;

    public abstract void aL(int i, String str);

    public abstract void byu();

    public a(f fVar) {
        this.fze = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fLv = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fLv != null) {
                    this.fLv.bxg();
                    return;
                }
                return;
            case 3:
                if (this.fLv != null) {
                    this.fLv.bxh();
                    return;
                }
                return;
            case 4:
                if (this.fLv != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fLv.d(eVar);
                    if (this.fLw != null) {
                        this.fLw.b(eVar);
                    }
                    if (eVar != null && eVar.fFw) {
                        this.fze.fFE.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fLv != null) {
                    this.fLv.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fLv != null) {
                    this.fLv.bxm();
                    return;
                }
                return;
            case 7:
                if (this.fLv != null) {
                    this.fLv.bxn();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fLv != null) {
                    this.fLv.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fJU = eVar;
        byu();
    }

    public void c(h hVar) {
        if (this.fze != null && this.fze.fFE != null) {
            this.fze.fFE.a((short) 5, hVar);
        }
    }

    public void aM(int i, String str) {
        if (this.fLv != null) {
            this.fLv.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.fze != null && this.fze.fFE != null) {
            this.fze.fFE.a((short) 8, Short.valueOf(s));
        }
    }

    public void byv() {
        if (this.fLv != null) {
            this.fLv.bxq();
        }
    }

    public void byw() {
        if (this.fLv != null) {
            this.fLv.bxr();
        }
    }

    public void onPause() {
        if (this.fLv != null) {
            this.fLv.onPause();
        }
    }

    public boolean byx() {
        if (this.fLv != null) {
            return this.fLv.bxo();
        }
        return false;
    }

    public void byy() {
        if (this.fLv != null) {
            this.fLv.bxp();
        }
    }

    public boolean byz() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fLw = bVar;
    }
}
