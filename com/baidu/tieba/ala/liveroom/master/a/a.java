package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes6.dex */
public abstract class a {
    protected com.baidu.tieba.ala.liveroom.data.e dYK;
    protected com.baidu.tieba.ala.liveroom.data.d eja;
    protected AlaMasterLiveRoomOpearator ekk;
    protected b ekl;
    protected int mCurrentState;

    public abstract void aUt();

    public abstract void ab(int i, String str);

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.dYK = eVar;
    }

    public void S(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.ekk = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.ekk != null) {
                    this.ekk.aTn();
                    return;
                }
                return;
            case 3:
                if (this.ekk != null) {
                    this.ekk.aTo();
                    return;
                }
                return;
            case 4:
                if (this.ekk != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.ekk.d(dVar);
                    if (this.ekl != null) {
                        this.ekl.b(dVar);
                    }
                    if (dVar != null && dVar.eeY) {
                        this.dYK.eff.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.ekk != null) {
                    this.ekk.b(obj instanceof g ? (g) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.ekk != null) {
                    this.ekk.aTs();
                    return;
                }
                return;
            case 7:
                if (this.ekk != null) {
                    this.ekk.aTt();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.ekk != null) {
                    this.ekk.d(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.eja = dVar;
        aUt();
    }

    public void c(g gVar) {
        if (this.dYK != null && this.dYK.eff != null) {
            this.dYK.eff.a((short) 5, gVar);
        }
    }

    public void ac(int i, String str) {
        if (this.ekk != null) {
            this.ekk.onError(i, str);
        }
    }

    public void f(short s) {
        if (this.dYK != null && this.dYK.eff != null) {
            this.dYK.eff.a((short) 8, Short.valueOf(s));
        }
    }

    public void aUu() {
        if (this.ekk != null) {
            this.ekk.aTw();
        }
    }

    public void aUv() {
        if (this.ekk != null) {
            this.ekk.aTx();
        }
    }

    public void onPause() {
        if (this.ekk != null) {
            this.ekk.onPause();
        }
    }

    public boolean aUw() {
        if (this.ekk != null) {
            return this.ekk.aTu();
        }
        return false;
    }

    public void aUx() {
        if (this.ekk != null) {
            this.ekk.aTv();
        }
    }

    public boolean aUy() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.ekl = bVar;
    }
}
