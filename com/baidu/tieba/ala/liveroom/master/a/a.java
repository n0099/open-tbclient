package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes2.dex */
public abstract class a {
    protected com.baidu.tieba.ala.liveroom.data.e eOH;
    protected com.baidu.tieba.ala.liveroom.data.d eZl;
    protected b faA;
    protected AlaMasterLiveRoomOpearator faz;
    protected int mCurrentState;

    public abstract void aq(int i, String str);

    public abstract void bmk();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.eOH = eVar;
    }

    public void U(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.faz = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.mCurrentState = s;
        switch (s) {
            case 2:
                if (this.faz != null) {
                    this.faz.bla();
                    return;
                }
                return;
            case 3:
                if (this.faz != null) {
                    this.faz.blb();
                    return;
                }
                return;
            case 4:
                if (this.faz != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.faz.d(dVar);
                    if (this.faA != null) {
                        this.faA.b(dVar);
                    }
                    if (dVar != null && dVar.eUS) {
                        this.eOH.eUZ.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.faz != null) {
                    this.faz.b(obj instanceof g ? (g) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.faz != null) {
                    this.faz.blf();
                    return;
                }
                return;
            case 7:
                if (this.faz != null) {
                    this.faz.blg();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.faz != null) {
                    this.faz.e(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.eZl = dVar;
        bmk();
    }

    public void c(g gVar) {
        if (this.eOH != null && this.eOH.eUZ != null) {
            this.eOH.eUZ.a((short) 5, gVar);
        }
    }

    public void ar(int i, String str) {
        if (this.faz != null) {
            this.faz.onError(i, str);
        }
    }

    public void g(short s) {
        if (this.eOH != null && this.eOH.eUZ != null) {
            this.eOH.eUZ.a((short) 8, Short.valueOf(s));
        }
    }

    public void bml() {
        if (this.faz != null) {
            this.faz.blj();
        }
    }

    public void bmm() {
        if (this.faz != null) {
            this.faz.blk();
        }
    }

    public void onPause() {
        if (this.faz != null) {
            this.faz.onPause();
        }
    }

    public boolean bmn() {
        if (this.faz != null) {
            return this.faz.blh();
        }
        return false;
    }

    public void bmo() {
        if (this.faz != null) {
            this.faz.bli();
        }
    }

    public boolean bmp() {
        return this.mCurrentState == 5;
    }

    public void a(b bVar) {
        this.faA = bVar;
    }
}
