package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.ag;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes7.dex */
public abstract class a {
    protected int bMb;
    protected com.baidu.tieba.ala.liveroom.data.e gDb;
    protected b gEA;
    protected AlaMasterLiveRoomOpearator gEz;
    protected f gqb;

    public abstract void aU(int i, String str);

    public abstract void bUN();

    public a(f fVar) {
        this.gqb = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.gEz = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.bMb = s;
        switch (s) {
            case 2:
                if (this.gEz != null) {
                    this.gEz.bTB();
                    return;
                }
                return;
            case 3:
                if (this.gEz != null) {
                    this.gEz.bTC();
                    return;
                }
                return;
            case 4:
                if (this.gEz != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.gEz.d(eVar);
                    if (this.gEA != null) {
                        this.gEA.b(eVar);
                    }
                    if (eVar != null && eVar.gxy) {
                        this.gqb.gxH.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.gEz != null) {
                    this.gEz.b(obj instanceof ag ? (ag) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.gEz != null) {
                    this.gEz.bTH();
                    return;
                }
                return;
            case 7:
                if (this.gEz != null) {
                    this.gEz.bTI();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.gEz != null) {
                    this.gEz.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gDb = eVar;
        bUN();
    }

    public void c(ag agVar) {
        if (this.gqb != null && this.gqb.gxH != null) {
            this.gqb.gxH.a((short) 5, agVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gEz != null) {
            this.gEz.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.gqb != null && this.gqb.gxH != null) {
            this.gqb.gxH.a((short) 8, Short.valueOf(s));
        }
    }

    public void bUO() {
        if (this.gEz != null) {
            this.gEz.bTL();
        }
    }

    public void bUP() {
        if (this.gEz != null) {
            this.gEz.bTM();
        }
    }

    public void onPause() {
        if (this.gEz != null) {
            this.gEz.onPause();
        }
    }

    public boolean bUQ() {
        if (this.gEz != null) {
            return this.gEz.bTJ();
        }
        return false;
    }

    public void bUR() {
        if (this.gEz != null) {
            this.gEz.bTK();
        }
    }

    public boolean bUS() {
        return this.bMb == 5;
    }

    public void a(b bVar) {
        this.gEA = bVar;
    }
}
