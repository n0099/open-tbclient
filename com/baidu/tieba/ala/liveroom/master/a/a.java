package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f fNw;
    protected com.baidu.tieba.ala.liveroom.data.e fYi;
    protected AlaMasterLiveRoomOpearator fZJ;
    protected b fZK;
    protected int mCurrentState;

    public abstract void aQ(int i, String str);

    public abstract void bEx();

    public a(f fVar) {
        this.fNw = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fZJ = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fZJ != null) {
                    this.fZJ.bDj();
                    return;
                }
                return;
            case 3:
                if (this.fZJ != null) {
                    this.fZJ.bDk();
                    return;
                }
                return;
            case 4:
                if (this.fZJ != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fZJ.d(eVar);
                    if (this.fZK != null) {
                        this.fZK.b(eVar);
                    }
                    if (eVar != null && eVar.fTG) {
                        this.fNw.fTO.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fZJ != null) {
                    this.fZJ.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fZJ != null) {
                    this.fZJ.bDp();
                    return;
                }
                return;
            case 7:
                if (this.fZJ != null) {
                    this.fZJ.bDq();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fZJ != null) {
                    this.fZJ.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fYi = eVar;
        bEx();
    }

    public void c(h hVar) {
        if (this.fNw != null && this.fNw.fTO != null) {
            this.fNw.fTO.a((short) 5, hVar);
        }
    }

    public void aR(int i, String str) {
        if (this.fZJ != null) {
            this.fZJ.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.fNw != null && this.fNw.fTO != null) {
            this.fNw.fTO.a((short) 8, Short.valueOf(s));
        }
    }

    public void bEy() {
        if (this.fZJ != null) {
            this.fZJ.bDt();
        }
    }

    public void bEz() {
        if (this.fZJ != null) {
            this.fZJ.bDu();
        }
    }

    public void onPause() {
        if (this.fZJ != null) {
            this.fZJ.onPause();
        }
    }

    public boolean bEA() {
        if (this.fZJ != null) {
            return this.fZJ.bDr();
        }
        return false;
    }

    public void bEB() {
        if (this.fZJ != null) {
            this.fZJ.bDs();
        }
    }

    public boolean bEC() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fZK = bVar;
    }
}
