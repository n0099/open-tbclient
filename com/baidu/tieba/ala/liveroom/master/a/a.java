package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f fNl;
    protected com.baidu.tieba.ala.liveroom.data.e fXX;
    protected AlaMasterLiveRoomOpearator fZy;
    protected b fZz;
    protected int mCurrentState;

    public abstract void aQ(int i, String str);

    public abstract void bEv();

    public a(f fVar) {
        this.fNl = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fZy = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fZy != null) {
                    this.fZy.bDh();
                    return;
                }
                return;
            case 3:
                if (this.fZy != null) {
                    this.fZy.bDi();
                    return;
                }
                return;
            case 4:
                if (this.fZy != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fZy.d(eVar);
                    if (this.fZz != null) {
                        this.fZz.b(eVar);
                    }
                    if (eVar != null && eVar.fTv) {
                        this.fNl.fTD.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fZy != null) {
                    this.fZy.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fZy != null) {
                    this.fZy.bDn();
                    return;
                }
                return;
            case 7:
                if (this.fZy != null) {
                    this.fZy.bDo();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fZy != null) {
                    this.fZy.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fXX = eVar;
        bEv();
    }

    public void c(h hVar) {
        if (this.fNl != null && this.fNl.fTD != null) {
            this.fNl.fTD.a((short) 5, hVar);
        }
    }

    public void aR(int i, String str) {
        if (this.fZy != null) {
            this.fZy.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.fNl != null && this.fNl.fTD != null) {
            this.fNl.fTD.a((short) 8, Short.valueOf(s));
        }
    }

    public void bEw() {
        if (this.fZy != null) {
            this.fZy.bDr();
        }
    }

    public void bEx() {
        if (this.fZy != null) {
            this.fZy.bDs();
        }
    }

    public void onPause() {
        if (this.fZy != null) {
            this.fZy.onPause();
        }
    }

    public boolean bEy() {
        if (this.fZy != null) {
            return this.fZy.bDp();
        }
        return false;
    }

    public void bEz() {
        if (this.fZy != null) {
            this.fZy.bDq();
        }
    }

    public boolean bEA() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fZz = bVar;
    }
}
