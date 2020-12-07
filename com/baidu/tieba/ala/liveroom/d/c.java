package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.u.e;
import com.baidu.live.u.f;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    private AlaLastLiveroomInfo giQ;
    private com.baidu.tieba.ala.liveroom.data.a hfD;
    private boolean hgH;
    private bp hgw;
    private com.baidu.tieba.ala.player.d hgz;
    private short hhB = 0;
    private com.baidu.live.liveroom.f.a hhC;
    private com.baidu.live.liveroom.a.c hhD;
    private String otherParams;

    public void e(short s) {
        if (this.hhC != null && (this.hhC instanceof b)) {
            this.hhC.cx(true);
            this.hhC = null;
        }
        if (this.hhC == null) {
            this.hhC = com.baidu.live.liveroom.f.c.PI().PJ().c(s);
            if (this.hhC != null) {
                this.hhC.setActivity(this.hfD.pageContext.getPageActivity());
                this.hhC.a(this.hhD);
                this.hhC.b(this.hfD.hpS);
                if (this.hfD.hpS.getParent() != null && (this.hfD.hpS.getParent() instanceof ViewGroup)) {
                    this.hhC.l((ViewGroup) this.hfD.hpS.getParent());
                }
                this.hhC.a(this.hfD.hpQ, this.hfD.brf);
                this.hhB = (short) 0;
                this.hfD.hpW = false;
                this.hhC.init();
                return;
            }
            return;
        }
        this.hhC.b(this.hfD.hpS);
        if (this.hfD.hpS.getParent() != null && (this.hfD.hpS.getParent() instanceof ViewGroup)) {
            this.hhC.l((ViewGroup) this.hfD.hpS.getParent());
        }
        this.hhC.a(this.hfD.hpQ, this.hfD.brf);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.hhC != null && !(this.hhC instanceof a)) {
                this.hhC.cx(true);
                this.hhC = null;
            }
            if (this.hhC == null) {
                a aVar = new a();
                this.hhB = (short) 0;
                aVar.a(this.hfD);
                aVar.a(this.hhD);
                aVar.setActivity(this.hfD.pageContext.getPageActivity());
                this.hfD.hpW = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.hhC = aVar;
            }
            this.hhC.a(this.hfD.hpQ, this.hfD.brf);
        } else if (2 == s) {
            if (this.hhC != null && !(this.hhC instanceof d)) {
                this.hhC.cx(true);
                this.hhC = null;
            }
            if (this.hhC == null) {
                d dVar = new d();
                this.hhB = (short) 0;
                dVar.a(this.hfD);
                dVar.a(this.hhD);
                dVar.setActivity(this.hfD.pageContext.getPageActivity());
                this.hfD.hpW = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.hhC = dVar;
            }
        }
        if (this.hhC instanceof b) {
            b bVar = (b) this.hhC;
            bVar.caZ();
            bVar.nh(this.hgH);
            bVar.a(this.hgw);
            bVar.a(this.hgz);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bp bpVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hfD == null) {
            this.hfD = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hfD.pageContext = tbPageContext;
        this.hfD.hpS = alaLiveView;
        this.hfD.hpT = alaLoopViewPager;
        this.hfD.brf = fVar;
        this.hfD.hpQ = eVar;
        this.hfD.hpR = dVar;
        this.hfD.fromType = str;
        this.hfD.enterTime = j;
        this.hfD.hpU = z;
        this.hfD.hpX = arrayList;
        this.hfD.hpY = false;
        this.hgw = bpVar;
    }

    public void nh(boolean z) {
        this.hgH = z;
        if (this.hhC != null && (this.hhC instanceof b)) {
            ((b) this.hhC).nh(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hgz = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hhD = cVar;
        if (this.hhC != null) {
            this.hhC.a(this.hhD);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hfD != null) {
            this.hfD.hpQ = alaLiveRoomBlurPageLayout;
        }
    }

    public void nm(boolean z) {
        if (this.hhB != 1) {
            if (this.hfD != null) {
                this.hfD.hpW = false;
            }
            try {
                if (this.hhC != null) {
                    if (this.hfD != null) {
                        if (this.hhC instanceof d) {
                            ((d) this.hhC).b(this.giQ);
                        } else if (this.hhC instanceof a) {
                            ((a) this.hhC).b(this.giQ);
                        }
                        this.hhC.l(this.hfD.hpR.Iq());
                    }
                    if ((this.hhC instanceof d) && z) {
                        ((d) this.hhC).no(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhB = (short) 1;
        }
    }

    public void eb(int i) {
        if (this.hfD != null) {
            this.hfD.hpY = true;
        }
        if (this.hhC != null) {
            this.hhC.eb(i);
        }
    }

    public void cca() {
        if (this.hfD != null) {
            this.hfD.hpV = true;
        }
    }

    public void a(w wVar) {
        if (this.hhC != null) {
            this.hhC.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.hhC != null) {
            this.hhC.b(qVar);
        }
    }

    public void nn(boolean z) {
        if (this.hhB != 3) {
            try {
                if (this.hfD != null) {
                    this.hfD.hpW = false;
                }
                if (this.hhC != null) {
                    this.hhC.cz(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhB = (short) 3;
        }
    }

    public void ccb() {
        if (this.hhB != 4) {
            try {
                if (this.hfD != null) {
                    this.hfD.hpW = true;
                    if (this.hhC != null) {
                        this.hhC.m(this.hfD.hpR.Iq());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hgw = null;
            this.hhB = (short) 4;
        }
    }

    public boolean ccc() {
        if (this.hhC == null || !(this.hhC instanceof b)) {
            return false;
        }
        return ((b) this.hhC).caS();
    }

    public boolean ccd() {
        if (this.hhC != null && (this.hhC instanceof b) && ((b) this.hhC).hgR) {
            return false;
        }
        if (this.hhB != 5) {
            if (this.hfD != null) {
                this.hfD.hpW = false;
            }
            try {
                if (this.hhC != null) {
                    boolean PG = this.hhC.PG();
                    if (PG && (this.hhC instanceof b)) {
                        ((b) this.hhC).hgQ = true;
                    }
                    return PG;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhB = (short) 5;
        }
        if (this.hhC != null && (this.hhC instanceof b)) {
            ((b) this.hhC).hgQ = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hhC != null) {
            this.hhC.cx(false);
        }
    }

    public void enterBackground() {
        if (this.hhC != null) {
            this.hhC.onPause();
        }
    }

    public void enterForeground() {
        if (this.hhC != null) {
            this.hhC.onResume();
        }
    }

    public void cce() {
        if (this.hhC != null) {
            this.hhC.onStop();
        }
    }

    public void ccf() {
        if (this.hhC != null) {
            this.hhC.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hhC != null) {
            this.hhC.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hhC != null) {
            this.hhC.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hhC != null) {
            this.hhC.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a cbW() {
        return this.hfD;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ccg() {
        return this.hhC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hhC != null) {
            return this.hhC.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giQ = alaLastLiveroomInfo;
    }
}
