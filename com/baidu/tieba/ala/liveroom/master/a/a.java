package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.aw;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes10.dex */
public abstract class a {
    protected int eBs;
    protected com.baidu.tieba.ala.liveroom.data.d hJD;
    protected AlaMasterLiveRoomOpearator hKY;
    protected b hKZ;
    protected com.baidu.tieba.ala.liveroom.data.e hwy;

    public abstract void bq(int i, String str);

    public abstract void ciP();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hwy = eVar;
    }

    public void ao(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hKY = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.eBs = s;
        switch (s) {
            case 2:
                if (this.hKY != null) {
                    this.hKY.chz();
                    return;
                }
                return;
            case 3:
                if (this.hKY != null) {
                    this.hKY.chA();
                    return;
                }
                return;
            case 4:
                if (this.hKY != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hKY.d(dVar);
                    if (this.hKZ != null) {
                        this.hKZ.b(dVar);
                    }
                    if (dVar != null && dVar.hDB) {
                        this.hwy.hDL.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hKY != null) {
                    this.hKY.b(obj instanceof aw ? (aw) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hKY != null) {
                    this.hKY.chH();
                    return;
                }
                return;
            case 7:
                if (this.hKY != null) {
                    this.hKY.chI();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hKY != null) {
                    this.hKY.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hJD = dVar;
        ciP();
    }

    public void c(aw awVar) {
        if (this.hwy != null && this.hwy.hDL != null) {
            this.hwy.hDL.a((short) 5, awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hKY != null) {
            this.hKY.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.hwy != null && this.hwy.hDL != null) {
            this.hwy.hDL.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hKY != null) {
            this.hKY.chL();
        }
    }

    public void markEnterForeground() {
        if (this.hKY != null) {
            this.hKY.chM();
        }
    }

    public void onPause() {
        if (this.hKY != null) {
            this.hKY.onPause();
        }
    }

    public boolean ciQ() {
        if (this.hKY != null) {
            return this.hKY.chJ();
        }
        return false;
    }

    public void ciR() {
        if (this.hKY != null) {
            this.hKY.chK();
        }
    }

    public boolean ciS() {
        return this.eBs == 5;
    }

    public void a(b bVar) {
        this.hKZ = bVar;
    }
}
