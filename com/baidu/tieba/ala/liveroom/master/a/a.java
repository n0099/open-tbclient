package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.data.as;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes10.dex */
public abstract class a {
    protected int cqj;
    protected com.baidu.tieba.ala.liveroom.data.d hDt;
    protected AlaMasterLiveRoomOpearator hEP;
    protected b hEQ;
    protected com.baidu.tieba.ala.liveroom.data.e hqr;

    public abstract void bl(int i, String str);

    public abstract void chJ();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hqr = eVar;
    }

    public void aq(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hEP = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.cqj = s;
        switch (s) {
            case 2:
                if (this.hEP != null) {
                    this.hEP.cgs();
                    return;
                }
                return;
            case 3:
                if (this.hEP != null) {
                    this.hEP.cgt();
                    return;
                }
                return;
            case 4:
                if (this.hEP != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hEP.d(dVar);
                    if (this.hEQ != null) {
                        this.hEQ.b(dVar);
                    }
                    if (dVar != null && dVar.hxu) {
                        this.hqr.hxE.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hEP != null) {
                    this.hEP.b(obj instanceof as ? (as) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hEP != null) {
                    this.hEP.cgA();
                    return;
                }
                return;
            case 7:
                if (this.hEP != null) {
                    this.hEP.cgB();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hEP != null) {
                    this.hEP.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hDt = dVar;
        chJ();
    }

    public void c(as asVar) {
        if (this.hqr != null && this.hqr.hxE != null) {
            this.hqr.hxE.a((short) 5, asVar);
        }
    }

    public void bm(int i, String str) {
        if (this.hEP != null) {
            this.hEP.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.hqr != null && this.hqr.hxE != null) {
            this.hqr.hxE.a((short) 8, Short.valueOf(s));
        }
    }

    public void markEnterBackground() {
        if (this.hEP != null) {
            this.hEP.cgE();
        }
    }

    public void markEnterForeground() {
        if (this.hEP != null) {
            this.hEP.cgF();
        }
    }

    public void onPause() {
        if (this.hEP != null) {
            this.hEP.onPause();
        }
    }

    public boolean chK() {
        if (this.hEP != null) {
            return this.hEP.cgC();
        }
        return false;
    }

    public void chL() {
        if (this.hEP != null) {
            this.hEP.cgD();
        }
    }

    public boolean chM() {
        return this.cqj == 5;
    }

    public void a(b bVar) {
        this.hEQ = bVar;
    }
}
