package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.as;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes11.dex */
public abstract class a {
    protected int cvb;
    protected com.baidu.tieba.ala.liveroom.data.d hHZ;
    protected AlaMasterLiveRoomOpearator hJv;
    protected b hJw;
    protected com.baidu.tieba.ala.liveroom.data.e huX;

    public abstract void bk(int i, String str);

    public abstract void clB();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huX = eVar;
    }

    public void aq(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hJv = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.cvb = s;
        switch (s) {
            case 2:
                if (this.hJv != null) {
                    this.hJv.ckk();
                    return;
                }
                return;
            case 3:
                if (this.hJv != null) {
                    this.hJv.ckl();
                    return;
                }
                return;
            case 4:
                if (this.hJv != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hJv.d(dVar);
                    if (this.hJw != null) {
                        this.hJw.b(dVar);
                    }
                    if (dVar != null && dVar.hCa) {
                        this.huX.hCk.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hJv != null) {
                    this.hJv.b(obj instanceof as ? (as) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hJv != null) {
                    this.hJv.cks();
                    return;
                }
                return;
            case 7:
                if (this.hJv != null) {
                    this.hJv.ckt();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hJv != null) {
                    this.hJv.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHZ = dVar;
        clB();
    }

    public void c(as asVar) {
        if (this.huX != null && this.huX.hCk != null) {
            this.huX.hCk.a((short) 5, asVar);
        }
    }

    public void bl(int i, String str) {
        if (this.hJv != null) {
            this.hJv.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.huX != null && this.huX.hCk != null) {
            this.huX.hCk.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hJv != null) {
            this.hJv.ckw();
        }
    }

    public void markEnterForeground() {
        if (this.hJv != null) {
            this.hJv.ckx();
        }
    }

    public void onPause() {
        if (this.hJv != null) {
            this.hJv.onPause();
        }
    }

    public boolean clC() {
        if (this.hJv != null) {
            return this.hJv.cku();
        }
        return false;
    }

    public void clD() {
        if (this.hJv != null) {
            this.hJv.ckv();
        }
    }

    public boolean clE() {
        return this.cvb == 5;
    }

    public void a(b bVar) {
        this.hJw = bVar;
    }
}
