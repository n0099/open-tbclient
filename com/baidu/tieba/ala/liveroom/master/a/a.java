package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected f eUL;
    protected com.baidu.tieba.ala.liveroom.data.e ffM;
    protected AlaMasterLiveRoomOpearator fhj;
    protected b fhk;
    protected int mCurrentState;

    public abstract void aw(int i, String str);

    public abstract void bpa();

    public a(f fVar) {
        this.eUL = fVar;
    }

    public void ac(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fhj = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fhj != null) {
                    this.fhj.bnO();
                    return;
                }
                return;
            case 3:
                if (this.fhj != null) {
                    this.fhj.bnP();
                    return;
                }
                return;
            case 4:
                if (this.fhj != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fhj.d(eVar);
                    if (this.fhk != null) {
                        this.fhk.b(eVar);
                    }
                    if (eVar != null && eVar.fbn) {
                        this.eUL.fbv.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fhj != null) {
                    this.fhj.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fhj != null) {
                    this.fhj.bnU();
                    return;
                }
                return;
            case 7:
                if (this.fhj != null) {
                    this.fhj.bnV();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fhj != null) {
                    this.fhj.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffM = eVar;
        bpa();
    }

    public void c(h hVar) {
        if (this.eUL != null && this.eUL.fbv != null) {
            this.eUL.fbv.a((short) 5, hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fhj != null) {
            this.fhj.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.eUL != null && this.eUL.fbv != null) {
            this.eUL.fbv.a((short) 8, Short.valueOf(s));
        }
    }

    public void bpb() {
        if (this.fhj != null) {
            this.fhj.bnY();
        }
    }

    public void bpc() {
        if (this.fhj != null) {
            this.fhj.bnZ();
        }
    }

    public void onPause() {
        if (this.fhj != null) {
            this.fhj.onPause();
        }
    }

    public boolean bpd() {
        if (this.fhj != null) {
            return this.fhj.bnW();
        }
        return false;
    }

    public void bpe() {
        if (this.fhj != null) {
            this.fhj.bnX();
        }
    }

    public boolean bpf() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fhk = bVar;
    }
}
