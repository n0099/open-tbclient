package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.ag;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes7.dex */
public abstract class a {
    protected int bMf;
    protected com.baidu.tieba.ala.liveroom.data.e gDf;
    protected AlaMasterLiveRoomOpearator gED;
    protected b gEE;
    protected f gqf;

    public abstract void aT(int i, String str);

    public abstract void bUO();

    public a(f fVar) {
        this.gqf = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.gED = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.bMf = s;
        switch (s) {
            case 2:
                if (this.gED != null) {
                    this.gED.bTC();
                    return;
                }
                return;
            case 3:
                if (this.gED != null) {
                    this.gED.bTD();
                    return;
                }
                return;
            case 4:
                if (this.gED != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.gED.d(eVar);
                    if (this.gEE != null) {
                        this.gEE.b(eVar);
                    }
                    if (eVar != null && eVar.gxC) {
                        this.gqf.gxL.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.gED != null) {
                    this.gED.b(obj instanceof ag ? (ag) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.gED != null) {
                    this.gED.bTI();
                    return;
                }
                return;
            case 7:
                if (this.gED != null) {
                    this.gED.bTJ();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.gED != null) {
                    this.gED.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gDf = eVar;
        bUO();
    }

    public void c(ag agVar) {
        if (this.gqf != null && this.gqf.gxL != null) {
            this.gqf.gxL.a((short) 5, agVar);
        }
    }

    public void aU(int i, String str) {
        if (this.gED != null) {
            this.gED.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.gqf != null && this.gqf.gxL != null) {
            this.gqf.gxL.a((short) 8, Short.valueOf(s));
        }
    }

    public void bUP() {
        if (this.gED != null) {
            this.gED.bTM();
        }
    }

    public void bUQ() {
        if (this.gED != null) {
            this.gED.bTN();
        }
    }

    public void onPause() {
        if (this.gED != null) {
            this.gED.onPause();
        }
    }

    public boolean bUR() {
        if (this.gED != null) {
            return this.gED.bTK();
        }
        return false;
    }

    public void bUS() {
        if (this.gED != null) {
            this.gED.bTL();
        }
    }

    public boolean bUT() {
        return this.bMf == 5;
    }

    public void a(b bVar) {
        this.gEE = bVar;
    }
}
