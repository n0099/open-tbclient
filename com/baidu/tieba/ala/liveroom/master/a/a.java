package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.aq;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int cnU;
    protected com.baidu.tieba.ala.liveroom.data.e hja;
    protected com.baidu.tieba.ala.liveroom.data.d hvZ;
    protected AlaMasterLiveRoomOpearator hxv;
    protected b hxw;

    public abstract void bi(int i, String str);

    public abstract void ciN();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hja = eVar;
    }

    public void ar(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hxv = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.cnU = s;
        switch (s) {
            case 2:
                if (this.hxv != null) {
                    this.hxv.chu();
                    return;
                }
                return;
            case 3:
                if (this.hxv != null) {
                    this.hxv.chv();
                    return;
                }
                return;
            case 4:
                if (this.hxv != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hxv.d(dVar);
                    if (this.hxw != null) {
                        this.hxw.b(dVar);
                    }
                    if (dVar != null && dVar.hqc) {
                        this.hja.hqm.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hxv != null) {
                    this.hxv.b(obj instanceof aq ? (aq) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hxv != null) {
                    this.hxv.chD();
                    return;
                }
                return;
            case 7:
                if (this.hxv != null) {
                    this.hxv.chE();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hxv != null) {
                    this.hxv.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hvZ = dVar;
        ciN();
    }

    public void c(aq aqVar) {
        if (this.hja != null && this.hja.hqm != null) {
            this.hja.hqm.a((short) 5, aqVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hxv != null) {
            this.hxv.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.hja != null && this.hja.hqm != null) {
            this.hja.hqm.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hxv != null) {
            this.hxv.chH();
        }
    }

    public void markEnterForeground() {
        if (this.hxv != null) {
            this.hxv.chI();
        }
    }

    public void onPause() {
        if (this.hxv != null) {
            this.hxv.onPause();
        }
    }

    public boolean ciO() {
        if (this.hxv != null) {
            return this.hxv.chF();
        }
        return false;
    }

    public void ciP() {
        if (this.hxv != null) {
            this.hxv.chG();
        }
    }

    public boolean ciQ() {
        return this.cnU == 5;
    }

    public void a(b bVar) {
        this.hxw = bVar;
    }
}
