package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.o.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a eRQ;
    private aq eSA;
    private boolean eSF;
    private short eTm = 0;
    private com.baidu.live.liveroom.f.a eTn;
    private com.baidu.live.liveroom.a.b eTo;
    private String otherParams;

    public void d(short s) {
        if (this.eTn != null && (this.eTn instanceof b)) {
            this.eTn.be(true);
            this.eTn = null;
        }
        if (this.eTn == null) {
            this.eTn = com.baidu.live.liveroom.f.c.yK().yL().b(s);
            if (this.eTn != null) {
                this.eTn.setActivity(this.eRQ.pageContext.getPageActivity());
                this.eTn.a(this.eTo);
                this.eTn.b(this.eRQ.faw);
                if (this.eRQ.faw.getParent() != null && (this.eRQ.faw.getParent() instanceof ViewGroup)) {
                    this.eTn.g((ViewGroup) this.eRQ.faw.getParent());
                }
                this.eTn.a(this.eRQ.fau, this.eRQ.awj);
                this.eTm = (short) 0;
                this.eRQ.faz = false;
                this.eTn.init();
                return;
            }
            return;
        }
        this.eTn.b(this.eRQ.faw);
        if (this.eRQ.faw.getParent() != null && (this.eRQ.faw.getParent() instanceof ViewGroup)) {
            this.eTn.g((ViewGroup) this.eRQ.faw.getParent());
        }
        this.eTn.a(this.eRQ.fau, this.eRQ.awj);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.eTn != null && !(this.eTn instanceof a)) {
                this.eTn.be(true);
                this.eTn = null;
            }
            if (this.eTn == null) {
                a aVar = new a();
                this.eTm = (short) 0;
                aVar.a(this.eRQ);
                aVar.a(this.eTo);
                aVar.setActivity(this.eRQ.pageContext.getPageActivity());
                this.eRQ.faz = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.eTn = aVar;
            }
            this.eTn.a(this.eRQ.fau, this.eRQ.awj);
        } else if (2 == s) {
            if (this.eTn != null && !(this.eTn instanceof d)) {
                this.eTn.be(true);
                this.eTn = null;
            }
            if (this.eTn == null) {
                d dVar = new d();
                this.eTm = (short) 0;
                dVar.a(this.eRQ);
                dVar.a(this.eTo);
                dVar.setActivity(this.eRQ.pageContext.getPageActivity());
                this.eRQ.faz = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.eTn = dVar;
            }
        }
        if (this.eTn instanceof b) {
            b bVar = (b) this.eTn;
            bVar.biZ();
            bVar.iU(this.eSF);
            bVar.a(this.eSA);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, e eVar, com.baidu.live.o.d dVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, aq aqVar) {
        if (this.eRQ == null) {
            this.eRQ = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eRQ.pageContext = tbPageContext;
        this.eRQ.faw = alaLiveView;
        this.eRQ.awj = eVar;
        this.eRQ.fau = dVar;
        this.eRQ.fav = cVar;
        this.eRQ.fromType = str;
        this.eRQ.enterTime = j;
        this.eRQ.fax = z;
        this.eRQ.faA = arrayList;
        this.eRQ.faB = false;
        this.eSA = aqVar;
    }

    public void iU(boolean z) {
        this.eSF = z;
        if (this.eTn != null && (this.eTn instanceof b)) {
            ((b) this.eTn).iU(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.eTo = bVar;
        if (this.eTn != null) {
            this.eTn.a(this.eTo);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eRQ != null) {
            this.eRQ.fau = alaLiveRoomBlurPageLayout;
        }
    }

    public void iY(boolean z) {
        if (this.eTm != 1) {
            if (this.eRQ != null) {
                this.eRQ.faz = false;
            }
            try {
                if (this.eTn != null) {
                    if (this.eRQ != null) {
                        this.eTn.k(this.eRQ.fav.yO());
                    }
                    if ((this.eTn instanceof d) && z) {
                        ((d) this.eTn).ja(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTm = (short) 1;
        }
    }

    public void bk(int i) {
        this.eRQ.faB = true;
        if (this.eTn != null) {
            this.eTn.bk(i);
        }
    }

    public void bjM() {
        if (this.eRQ != null) {
            this.eRQ.fay = true;
        }
    }

    public void a(m mVar) {
        if (this.eTn != null) {
            this.eTn.i(mVar);
        }
    }

    public void d(h hVar) {
        if (this.eTn != null) {
            this.eTn.b(hVar);
        }
    }

    public void iZ(boolean z) {
        if (this.eTm != 3) {
            try {
                if (this.eRQ != null) {
                    this.eRQ.faz = false;
                }
                if (this.eTn != null) {
                    this.eTn.bf(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTm = (short) 3;
        }
    }

    public void bjN() {
        if (this.eTm != 4) {
            try {
                if (this.eRQ != null) {
                    this.eRQ.faz = true;
                    if (this.eTn != null) {
                        this.eTn.l(this.eRQ.fav.yO());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSA = null;
            this.eTm = (short) 4;
        }
    }

    public boolean bjO() {
        if (this.eTn == null || !(this.eTn instanceof b)) {
            return false;
        }
        return ((b) this.eTn).biR();
    }

    public boolean bjP() {
        if (this.eTn != null && (this.eTn instanceof b) && ((b) this.eTn).eSO) {
            return false;
        }
        if (this.eTm != 5) {
            if (this.eRQ != null) {
                this.eRQ.faz = false;
            }
            try {
                if (this.eTn != null) {
                    boolean yJ = this.eTn.yJ();
                    if (yJ && (this.eTn instanceof b)) {
                        ((b) this.eTn).eSN = true;
                    }
                    return yJ;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTm = (short) 5;
        }
        if (this.eTn != null && (this.eTn instanceof b)) {
            ((b) this.eTn).eSN = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.eTn != null) {
            this.eTn.be(false);
        }
    }

    public void enterBackground() {
        if (this.eTn != null) {
            this.eTn.onPause();
        }
    }

    public void enterForeground() {
        if (this.eTn != null) {
            this.eTn.onResume();
        }
    }

    public void bjQ() {
        if (this.eTn != null) {
            this.eTn.onStop();
        }
    }

    public void bjR() {
        if (this.eTn != null) {
            this.eTn.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eTn != null) {
            this.eTn.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eTn != null) {
            this.eTn.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.eTn != null) {
            this.eTn.j(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bjJ() {
        return this.eRQ;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bjS() {
        return this.eTn;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eTn != null) {
            return this.eTn.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
