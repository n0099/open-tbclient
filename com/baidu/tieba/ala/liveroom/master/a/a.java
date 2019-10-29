package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes6.dex */
public abstract class a {
    protected com.baidu.tieba.ala.liveroom.data.e dZB;
    protected com.baidu.tieba.ala.liveroom.data.d ejR;
    protected AlaMasterLiveRoomOpearator elb;
    protected b elc;
    protected int mCurrentState;

    public abstract void aUv();

    public abstract void ac(int i, String str);

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.dZB = eVar;
    }

    public void S(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.elb = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.elb != null) {
                    this.elb.aTp();
                    return;
                }
                return;
            case 3:
                if (this.elb != null) {
                    this.elb.aTq();
                    return;
                }
                return;
            case 4:
                if (this.elb != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.elb.d(dVar);
                    if (this.elc != null) {
                        this.elc.b(dVar);
                    }
                    if (dVar != null && dVar.efP) {
                        this.dZB.efW.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.elb != null) {
                    this.elb.b(obj instanceof g ? (g) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.elb != null) {
                    this.elb.aTu();
                    return;
                }
                return;
            case 7:
                if (this.elb != null) {
                    this.elb.aTv();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.elb != null) {
                    this.elb.e(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.ejR = dVar;
        aUv();
    }

    public void c(g gVar) {
        if (this.dZB != null && this.dZB.efW != null) {
            this.dZB.efW.a((short) 5, gVar);
        }
    }

    public void ad(int i, String str) {
        if (this.elb != null) {
            this.elb.onError(i, str);
        }
    }

    public void g(short s) {
        if (this.dZB != null && this.dZB.efW != null) {
            this.dZB.efW.a((short) 8, Short.valueOf(s));
        }
    }

    public void aUw() {
        if (this.elb != null) {
            this.elb.aTy();
        }
    }

    public void aUx() {
        if (this.elb != null) {
            this.elb.aTz();
        }
    }

    public void onPause() {
        if (this.elb != null) {
            this.elb.onPause();
        }
    }

    public boolean aUy() {
        if (this.elb != null) {
            return this.elb.aTw();
        }
        return false;
    }

    public void aUz() {
        if (this.elb != null) {
            this.elb.aTx();
        }
    }

    public boolean aUA() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.elc = bVar;
    }
}
