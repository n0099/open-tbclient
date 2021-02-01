package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.aw;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes11.dex */
public abstract class a {
    protected int ezR;
    protected com.baidu.tieba.ala.liveroom.data.d hHG;
    protected AlaMasterLiveRoomOpearator hJb;
    protected b hJc;
    protected com.baidu.tieba.ala.liveroom.data.e huB;

    public abstract void bq(int i, String str);

    public abstract void ciC();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huB = eVar;
    }

    public void ao(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hJb = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.ezR = s;
        switch (s) {
            case 2:
                if (this.hJb != null) {
                    this.hJb.chm();
                    return;
                }
                return;
            case 3:
                if (this.hJb != null) {
                    this.hJb.chn();
                    return;
                }
                return;
            case 4:
                if (this.hJb != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hJb.d(dVar);
                    if (this.hJc != null) {
                        this.hJc.b(dVar);
                    }
                    if (dVar != null && dVar.hBE) {
                        this.huB.hBO.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hJb != null) {
                    this.hJb.b(obj instanceof aw ? (aw) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hJb != null) {
                    this.hJb.chu();
                    return;
                }
                return;
            case 7:
                if (this.hJb != null) {
                    this.hJb.chv();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hJb != null) {
                    this.hJb.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHG = dVar;
        ciC();
    }

    public void c(aw awVar) {
        if (this.huB != null && this.huB.hBO != null) {
            this.huB.hBO.a((short) 5, awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hJb != null) {
            this.hJb.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.huB != null && this.huB.hBO != null) {
            this.huB.hBO.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hJb != null) {
            this.hJb.chy();
        }
    }

    public void markEnterForeground() {
        if (this.hJb != null) {
            this.hJb.chz();
        }
    }

    public void onPause() {
        if (this.hJb != null) {
            this.hJb.onPause();
        }
    }

    public boolean ciD() {
        if (this.hJb != null) {
            return this.hJb.chw();
        }
        return false;
    }

    public void ciE() {
        if (this.hJb != null) {
            this.hJb.chx();
        }
    }

    public boolean ciF() {
        return this.ezR == 5;
    }

    public void a(b bVar) {
        this.hJc = bVar;
    }
}
