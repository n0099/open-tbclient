package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.aw;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes11.dex */
public abstract class a {
    protected int ezR;
    protected com.baidu.tieba.ala.liveroom.data.d hHU;
    protected AlaMasterLiveRoomOpearator hJp;
    protected b hJq;
    protected com.baidu.tieba.ala.liveroom.data.e huP;

    public abstract void bq(int i, String str);

    public abstract void ciJ();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huP = eVar;
    }

    public void ao(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hJp = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.ezR = s;
        switch (s) {
            case 2:
                if (this.hJp != null) {
                    this.hJp.cht();
                    return;
                }
                return;
            case 3:
                if (this.hJp != null) {
                    this.hJp.chu();
                    return;
                }
                return;
            case 4:
                if (this.hJp != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hJp.d(dVar);
                    if (this.hJq != null) {
                        this.hJq.b(dVar);
                    }
                    if (dVar != null && dVar.hBS) {
                        this.huP.hCc.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hJp != null) {
                    this.hJp.b(obj instanceof aw ? (aw) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hJp != null) {
                    this.hJp.chB();
                    return;
                }
                return;
            case 7:
                if (this.hJp != null) {
                    this.hJp.chC();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hJp != null) {
                    this.hJp.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHU = dVar;
        ciJ();
    }

    public void c(aw awVar) {
        if (this.huP != null && this.huP.hCc != null) {
            this.huP.hCc.a((short) 5, awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hJp != null) {
            this.hJp.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.huP != null && this.huP.hCc != null) {
            this.huP.hCc.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hJp != null) {
            this.hJp.chF();
        }
    }

    public void markEnterForeground() {
        if (this.hJp != null) {
            this.hJp.chG();
        }
    }

    public void onPause() {
        if (this.hJp != null) {
            this.hJp.onPause();
        }
    }

    public boolean ciK() {
        if (this.hJp != null) {
            return this.hJp.chD();
        }
        return false;
    }

    public void ciL() {
        if (this.hJp != null) {
            this.hJp.chE();
        }
    }

    public boolean ciM() {
        return this.ezR == 5;
    }

    public void a(b bVar) {
        this.hJq = bVar;
    }
}
