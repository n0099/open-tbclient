package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.s.e;
import com.baidu.live.s.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a gWx;
    private bo gXn;
    private com.baidu.tieba.ala.player.d gXq;
    private boolean gXx;
    private short gYq = 0;
    private com.baidu.live.liveroom.f.a gYr;
    private com.baidu.live.liveroom.a.c gYs;
    private AlaLastLiveroomInfo gaY;
    private String otherParams;

    public void e(short s) {
        if (this.gYr != null && (this.gYr instanceof b)) {
            this.gYr.ch(true);
            this.gYr = null;
        }
        if (this.gYr == null) {
            this.gYr = com.baidu.live.liveroom.f.c.NY().NZ().c(s);
            if (this.gYr != null) {
                this.gYr.setActivity(this.gWx.pageContext.getPageActivity());
                this.gYr.a(this.gYs);
                this.gYr.b(this.gWx.hgE);
                if (this.gWx.hgE.getParent() != null && (this.gWx.hgE.getParent() instanceof ViewGroup)) {
                    this.gYr.p((ViewGroup) this.gWx.hgE.getParent());
                }
                this.gYr.a(this.gWx.hgC, this.gWx.bnJ);
                this.gYq = (short) 0;
                this.gWx.hgI = false;
                this.gYr.init();
                return;
            }
            return;
        }
        this.gYr.b(this.gWx.hgE);
        if (this.gWx.hgE.getParent() != null && (this.gWx.hgE.getParent() instanceof ViewGroup)) {
            this.gYr.p((ViewGroup) this.gWx.hgE.getParent());
        }
        this.gYr.a(this.gWx.hgC, this.gWx.bnJ);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.gYr != null && !(this.gYr instanceof a)) {
                this.gYr.ch(true);
                this.gYr = null;
            }
            if (this.gYr == null) {
                a aVar = new a();
                this.gYq = (short) 0;
                aVar.a(this.gWx);
                aVar.a(this.gYs);
                aVar.setActivity(this.gWx.pageContext.getPageActivity());
                this.gWx.hgI = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gYr = aVar;
            }
            this.gYr.a(this.gWx.hgC, this.gWx.bnJ);
        } else if (2 == s) {
            if (this.gYr != null && !(this.gYr instanceof d)) {
                this.gYr.ch(true);
                this.gYr = null;
            }
            if (this.gYr == null) {
                d dVar = new d();
                this.gYq = (short) 0;
                dVar.a(this.gWx);
                dVar.a(this.gYs);
                dVar.setActivity(this.gWx.pageContext.getPageActivity());
                this.gWx.hgI = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gYr = dVar;
            }
        }
        if (this.gYr instanceof b) {
            b bVar = (b) this.gYr;
            bVar.bXP();
            bVar.mM(this.gXx);
            bVar.a(this.gXn);
            bVar.a(this.gXq);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.q.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bo boVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.gWx == null) {
            this.gWx = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gWx.pageContext = tbPageContext;
        this.gWx.hgE = alaLiveView;
        this.gWx.hgF = alaLoopViewPager;
        this.gWx.bnJ = fVar;
        this.gWx.hgC = eVar;
        this.gWx.hgD = dVar;
        this.gWx.fromType = str;
        this.gWx.enterTime = j;
        this.gWx.hgG = z;
        this.gWx.hgJ = arrayList;
        this.gWx.hgK = false;
        this.gXn = boVar;
    }

    public void mM(boolean z) {
        this.gXx = z;
        if (this.gYr != null && (this.gYr instanceof b)) {
            ((b) this.gYr).mM(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gXq = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gYs = cVar;
        if (this.gYr != null) {
            this.gYr.a(this.gYs);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gWx != null) {
            this.gWx.hgC = alaLiveRoomBlurPageLayout;
        }
    }

    public void mQ(boolean z) {
        if (this.gYq != 1) {
            if (this.gWx != null) {
                this.gWx.hgI = false;
            }
            try {
                if (this.gYr != null) {
                    if (this.gWx != null) {
                        if (this.gYr instanceof d) {
                            ((d) this.gYr).b(this.gaY);
                        } else if (this.gYr instanceof a) {
                            ((a) this.gYr).b(this.gaY);
                        }
                        this.gYr.l(this.gWx.hgD.Hi());
                    }
                    if ((this.gYr instanceof d) && z) {
                        ((d) this.gYr).mS(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gYq = (short) 1;
        }
    }

    public void dM(int i) {
        if (this.gWx != null) {
            this.gWx.hgK = true;
        }
        if (this.gYr != null) {
            this.gYr.dM(i);
        }
    }

    public void bYO() {
        if (this.gWx != null) {
            this.gWx.hgH = true;
        }
    }

    public void a(w wVar) {
        if (this.gYr != null) {
            this.gYr.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gYr != null) {
            this.gYr.b(qVar);
        }
    }

    public void mR(boolean z) {
        if (this.gYq != 3) {
            try {
                if (this.gWx != null) {
                    this.gWx.hgI = false;
                }
                if (this.gYr != null) {
                    this.gYr.cj(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gYq = (short) 3;
        }
    }

    public void bYP() {
        if (this.gYq != 4) {
            try {
                if (this.gWx != null) {
                    this.gWx.hgI = true;
                    if (this.gYr != null) {
                        this.gYr.m(this.gWx.hgD.Hi());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXn = null;
            this.gYq = (short) 4;
        }
    }

    public boolean bYQ() {
        if (this.gYr == null || !(this.gYr instanceof b)) {
            return false;
        }
        return ((b) this.gYr).bXI();
    }

    public boolean bYR() {
        if (this.gYr != null && (this.gYr instanceof b) && ((b) this.gYr).gXH) {
            return false;
        }
        if (this.gYq != 5) {
            if (this.gWx != null) {
                this.gWx.hgI = false;
            }
            try {
                if (this.gYr != null) {
                    boolean NW = this.gYr.NW();
                    if (NW && (this.gYr instanceof b)) {
                        ((b) this.gYr).gXG = true;
                    }
                    return NW;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gYq = (short) 5;
        }
        if (this.gYr != null && (this.gYr instanceof b)) {
            ((b) this.gYr).gXG = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gYr != null) {
            this.gYr.ch(false);
        }
    }

    public void enterBackground() {
        if (this.gYr != null) {
            this.gYr.onPause();
        }
    }

    public void enterForeground() {
        if (this.gYr != null) {
            this.gYr.onResume();
        }
    }

    public void bYS() {
        if (this.gYr != null) {
            this.gYr.onStop();
        }
    }

    public void bYT() {
        if (this.gYr != null) {
            this.gYr.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gYr != null) {
            this.gYr.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gYr != null) {
            this.gYr.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gYr != null) {
            this.gYr.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bYK() {
        return this.gWx;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bYU() {
        return this.gYr;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gYr != null) {
            return this.gYr.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaY = alaLastLiveroomInfo;
    }
}
