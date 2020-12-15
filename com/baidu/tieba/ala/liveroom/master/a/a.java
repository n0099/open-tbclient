package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.aq;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int cnU;
    protected com.baidu.tieba.ala.liveroom.data.e hjc;
    protected com.baidu.tieba.ala.liveroom.data.d hwb;
    protected AlaMasterLiveRoomOpearator hxx;
    protected b hxy;

    public abstract void bi(int i, String str);

    public abstract void ciO();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hjc = eVar;
    }

    public void ar(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hxx = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.cnU = s;
        switch (s) {
            case 2:
                if (this.hxx != null) {
                    this.hxx.chv();
                    return;
                }
                return;
            case 3:
                if (this.hxx != null) {
                    this.hxx.chw();
                    return;
                }
                return;
            case 4:
                if (this.hxx != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hxx.d(dVar);
                    if (this.hxy != null) {
                        this.hxy.b(dVar);
                    }
                    if (dVar != null && dVar.hqe) {
                        this.hjc.hqo.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hxx != null) {
                    this.hxx.b(obj instanceof aq ? (aq) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hxx != null) {
                    this.hxx.chE();
                    return;
                }
                return;
            case 7:
                if (this.hxx != null) {
                    this.hxx.chF();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hxx != null) {
                    this.hxx.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hwb = dVar;
        ciO();
    }

    public void c(aq aqVar) {
        if (this.hjc != null && this.hjc.hqo != null) {
            this.hjc.hqo.a((short) 5, aqVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hxx != null) {
            this.hxx.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.hjc != null && this.hjc.hqo != null) {
            this.hjc.hqo.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hxx != null) {
            this.hxx.chI();
        }
    }

    public void markEnterForeground() {
        if (this.hxx != null) {
            this.hxx.chJ();
        }
    }

    public void onPause() {
        if (this.hxx != null) {
            this.hxx.onPause();
        }
    }

    public boolean ciP() {
        if (this.hxx != null) {
            return this.hxx.chG();
        }
        return false;
    }

    public void ciQ() {
        if (this.hxx != null) {
            this.hxx.chH();
        }
    }

    public boolean ciR() {
        return this.cnU == 5;
    }

    public void a(b bVar) {
        this.hxy = bVar;
    }
}
