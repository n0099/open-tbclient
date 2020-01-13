package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes2.dex */
public abstract class a {
    protected f eQi;
    protected com.baidu.tieba.ala.liveroom.data.e fbR;
    protected AlaMasterLiveRoomOpearator fdn;
    protected b fdo;
    protected int mCurrentState;

    public abstract void av(int i, String str);

    public abstract void bni();

    public a(f fVar) {
        this.eQi = fVar;
    }

    public void ae(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fdn = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fdn != null) {
                    this.fdn.blX();
                    return;
                }
                return;
            case 3:
                if (this.fdn != null) {
                    this.fdn.blY();
                    return;
                }
                return;
            case 4:
                if (this.fdn != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fdn.d(eVar);
                    if (this.fdo != null) {
                        this.fdo.b(eVar);
                    }
                    if (eVar != null && eVar.eWM) {
                        this.eQi.eWT.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fdn != null) {
                    this.fdn.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fdn != null) {
                    this.fdn.bmd();
                    return;
                }
                return;
            case 7:
                if (this.fdn != null) {
                    this.fdn.bme();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fdn != null) {
                    this.fdn.e(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fbR = eVar;
        bni();
    }

    public void c(h hVar) {
        if (this.eQi != null && this.eQi.eWT != null) {
            this.eQi.eWT.a((short) 5, hVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fdn != null) {
            this.fdn.onError(i, str);
        }
    }

    public void g(short s) {
        if (this.eQi != null && this.eQi.eWT != null) {
            this.eQi.eWT.a((short) 8, Short.valueOf(s));
        }
    }

    public void bnj() {
        if (this.fdn != null) {
            this.fdn.bmh();
        }
    }

    public void bnk() {
        if (this.fdn != null) {
            this.fdn.bmi();
        }
    }

    public void onPause() {
        if (this.fdn != null) {
            this.fdn.onPause();
        }
    }

    public boolean bnl() {
        if (this.fdn != null) {
            return this.fdn.bmf();
        }
        return false;
    }

    public void bnm() {
        if (this.fdn != null) {
            this.fdn.bmg();
        }
    }

    public boolean bnn() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fdo = bVar;
    }
}
