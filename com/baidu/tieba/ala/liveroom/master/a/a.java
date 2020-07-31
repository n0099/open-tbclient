package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.ae;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int bGB;
    protected f gdS;
    protected com.baidu.tieba.ala.liveroom.data.e gqi;
    protected AlaMasterLiveRoomOpearator grF;
    protected b grG;

    public abstract void aW(int i, String str);

    public abstract void bKK();

    public a(f fVar) {
        this.gdS = fVar;
    }

    public void ag(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.grF = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.bGB = s;
        switch (s) {
            case 2:
                if (this.grF != null) {
                    this.grF.bJA();
                    return;
                }
                return;
            case 3:
                if (this.grF != null) {
                    this.grF.bJB();
                    return;
                }
                return;
            case 4:
                if (this.grF != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.grF.d(eVar);
                    if (this.grG != null) {
                        this.grG.b(eVar);
                    }
                    if (eVar != null && eVar.glu) {
                        this.gdS.glD.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.grF != null) {
                    this.grF.b(obj instanceof ae ? (ae) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.grF != null) {
                    this.grF.bJG();
                    return;
                }
                return;
            case 7:
                if (this.grF != null) {
                    this.grF.bJH();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.grF != null) {
                    this.grF.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gqi = eVar;
        bKK();
    }

    public void c(ae aeVar) {
        if (this.gdS != null && this.gdS.glD != null) {
            this.gdS.glD.a((short) 5, aeVar);
        }
    }

    public void aX(int i, String str) {
        if (this.grF != null) {
            this.grF.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.gdS != null && this.gdS.glD != null) {
            this.gdS.glD.a((short) 8, Short.valueOf(s));
        }
    }

    public void bKL() {
        if (this.grF != null) {
            this.grF.bJK();
        }
    }

    public void bKM() {
        if (this.grF != null) {
            this.grF.bJL();
        }
    }

    public void onPause() {
        if (this.grF != null) {
            this.grF.onPause();
        }
    }

    public boolean bKN() {
        if (this.grF != null) {
            return this.grF.bJI();
        }
        return false;
    }

    public void bKO() {
        if (this.grF != null) {
            this.grF.bJJ();
        }
    }

    public boolean bKP() {
        return this.bGB == 5;
    }

    public void a(b bVar) {
        this.grG = bVar;
    }
}
