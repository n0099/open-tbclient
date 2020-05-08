package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes3.dex */
public abstract class a {
    protected com.baidu.tieba.ala.liveroom.data.e fJZ;
    protected AlaMasterLiveRoomOpearator fLA;
    protected b fLB;
    protected f fzj;
    protected int mCurrentState;

    public abstract void aL(int i, String str);

    public abstract void bys();

    public a(f fVar) {
        this.fzj = fVar;
    }

    public void ai(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.fLA = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.fLA != null) {
                    this.fLA.bxe();
                    return;
                }
                return;
            case 3:
                if (this.fLA != null) {
                    this.fLA.bxf();
                    return;
                }
                return;
            case 4:
                if (this.fLA != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.fLA.d(eVar);
                    if (this.fLB != null) {
                        this.fLB.b(eVar);
                    }
                    if (eVar != null && eVar.fFB) {
                        this.fzj.fFJ.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.fLA != null) {
                    this.fLA.b(obj instanceof h ? (h) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.fLA != null) {
                    this.fLA.bxk();
                    return;
                }
                return;
            case 7:
                if (this.fLA != null) {
                    this.fLA.bxl();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.fLA != null) {
                    this.fLA.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fJZ = eVar;
        bys();
    }

    public void c(h hVar) {
        if (this.fzj != null && this.fzj.fFJ != null) {
            this.fzj.fFJ.a((short) 5, hVar);
        }
    }

    public void aM(int i, String str) {
        if (this.fLA != null) {
            this.fLA.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.fzj != null && this.fzj.fFJ != null) {
            this.fzj.fFJ.a((short) 8, Short.valueOf(s));
        }
    }

    public void byt() {
        if (this.fLA != null) {
            this.fLA.bxo();
        }
    }

    public void byu() {
        if (this.fLA != null) {
            this.fLA.bxp();
        }
    }

    public void onPause() {
        if (this.fLA != null) {
            this.fLA.onPause();
        }
    }

    public boolean byv() {
        if (this.fLA != null) {
            return this.fLA.bxm();
        }
        return false;
    }

    public void byw() {
        if (this.fLA != null) {
            this.fLA.bxn();
        }
    }

    public boolean byx() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.fLB = bVar;
    }
}
