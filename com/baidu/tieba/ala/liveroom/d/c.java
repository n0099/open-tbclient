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
    private AlaLastLiveroomInfo giS;
    private com.baidu.tieba.ala.liveroom.data.a hfF;
    private com.baidu.tieba.ala.player.d hgB;
    private boolean hgJ;
    private bp hgy;
    private short hhD = 0;
    private com.baidu.live.liveroom.f.a hhE;
    private com.baidu.live.liveroom.a.c hhF;
    private String otherParams;

    public void e(short s) {
        if (this.hhE != null && (this.hhE instanceof b)) {
            this.hhE.cx(true);
            this.hhE = null;
        }
        if (this.hhE == null) {
            this.hhE = com.baidu.live.liveroom.f.c.PI().PJ().c(s);
            if (this.hhE != null) {
                this.hhE.setActivity(this.hfF.pageContext.getPageActivity());
                this.hhE.a(this.hhF);
                this.hhE.b(this.hfF.hpU);
                if (this.hfF.hpU.getParent() != null && (this.hfF.hpU.getParent() instanceof ViewGroup)) {
                    this.hhE.l((ViewGroup) this.hfF.hpU.getParent());
                }
                this.hhE.a(this.hfF.hpS, this.hfF.brf);
                this.hhD = (short) 0;
                this.hfF.hpY = false;
                this.hhE.init();
                return;
            }
            return;
        }
        this.hhE.b(this.hfF.hpU);
        if (this.hfF.hpU.getParent() != null && (this.hfF.hpU.getParent() instanceof ViewGroup)) {
            this.hhE.l((ViewGroup) this.hfF.hpU.getParent());
        }
        this.hhE.a(this.hfF.hpS, this.hfF.brf);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.hhE != null && !(this.hhE instanceof a)) {
                this.hhE.cx(true);
                this.hhE = null;
            }
            if (this.hhE == null) {
                a aVar = new a();
                this.hhD = (short) 0;
                aVar.a(this.hfF);
                aVar.a(this.hhF);
                aVar.setActivity(this.hfF.pageContext.getPageActivity());
                this.hfF.hpY = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.hhE = aVar;
            }
            this.hhE.a(this.hfF.hpS, this.hfF.brf);
        } else if (2 == s) {
            if (this.hhE != null && !(this.hhE instanceof d)) {
                this.hhE.cx(true);
                this.hhE = null;
            }
            if (this.hhE == null) {
                d dVar = new d();
                this.hhD = (short) 0;
                dVar.a(this.hfF);
                dVar.a(this.hhF);
                dVar.setActivity(this.hfF.pageContext.getPageActivity());
                this.hfF.hpY = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.hhE = dVar;
            }
        }
        if (this.hhE instanceof b) {
            b bVar = (b) this.hhE;
            bVar.cba();
            bVar.nh(this.hgJ);
            bVar.a(this.hgy);
            bVar.a(this.hgB);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bp bpVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hfF == null) {
            this.hfF = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hfF.pageContext = tbPageContext;
        this.hfF.hpU = alaLiveView;
        this.hfF.hpV = alaLoopViewPager;
        this.hfF.brf = fVar;
        this.hfF.hpS = eVar;
        this.hfF.hpT = dVar;
        this.hfF.fromType = str;
        this.hfF.enterTime = j;
        this.hfF.hpW = z;
        this.hfF.hpZ = arrayList;
        this.hfF.hqa = false;
        this.hgy = bpVar;
    }

    public void nh(boolean z) {
        this.hgJ = z;
        if (this.hhE != null && (this.hhE instanceof b)) {
            ((b) this.hhE).nh(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hgB = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hhF = cVar;
        if (this.hhE != null) {
            this.hhE.a(this.hhF);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hfF != null) {
            this.hfF.hpS = alaLiveRoomBlurPageLayout;
        }
    }

    public void nm(boolean z) {
        if (this.hhD != 1) {
            if (this.hfF != null) {
                this.hfF.hpY = false;
            }
            try {
                if (this.hhE != null) {
                    if (this.hfF != null) {
                        if (this.hhE instanceof d) {
                            ((d) this.hhE).b(this.giS);
                        } else if (this.hhE instanceof a) {
                            ((a) this.hhE).b(this.giS);
                        }
                        this.hhE.l(this.hfF.hpT.Iq());
                    }
                    if ((this.hhE instanceof d) && z) {
                        ((d) this.hhE).no(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhD = (short) 1;
        }
    }

    public void eb(int i) {
        if (this.hfF != null) {
            this.hfF.hqa = true;
        }
        if (this.hhE != null) {
            this.hhE.eb(i);
        }
    }

    public void ccb() {
        if (this.hfF != null) {
            this.hfF.hpX = true;
        }
    }

    public void a(w wVar) {
        if (this.hhE != null) {
            this.hhE.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.hhE != null) {
            this.hhE.b(qVar);
        }
    }

    public void nn(boolean z) {
        if (this.hhD != 3) {
            try {
                if (this.hfF != null) {
                    this.hfF.hpY = false;
                }
                if (this.hhE != null) {
                    this.hhE.cz(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhD = (short) 3;
        }
    }

    public void ccc() {
        if (this.hhD != 4) {
            try {
                if (this.hfF != null) {
                    this.hfF.hpY = true;
                    if (this.hhE != null) {
                        this.hhE.m(this.hfF.hpT.Iq());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hgy = null;
            this.hhD = (short) 4;
        }
    }

    public boolean ccd() {
        if (this.hhE == null || !(this.hhE instanceof b)) {
            return false;
        }
        return ((b) this.hhE).caT();
    }

    public boolean cce() {
        if (this.hhE != null && (this.hhE instanceof b) && ((b) this.hhE).hgT) {
            return false;
        }
        if (this.hhD != 5) {
            if (this.hfF != null) {
                this.hfF.hpY = false;
            }
            try {
                if (this.hhE != null) {
                    boolean PG = this.hhE.PG();
                    if (PG && (this.hhE instanceof b)) {
                        ((b) this.hhE).hgS = true;
                    }
                    return PG;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hhD = (short) 5;
        }
        if (this.hhE != null && (this.hhE instanceof b)) {
            ((b) this.hhE).hgS = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hhE != null) {
            this.hhE.cx(false);
        }
    }

    public void enterBackground() {
        if (this.hhE != null) {
            this.hhE.onPause();
        }
    }

    public void enterForeground() {
        if (this.hhE != null) {
            this.hhE.onResume();
        }
    }

    public void ccf() {
        if (this.hhE != null) {
            this.hhE.onStop();
        }
    }

    public void ccg() {
        if (this.hhE != null) {
            this.hhE.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hhE != null) {
            this.hhE.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hhE != null) {
            this.hhE.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hhE != null) {
            this.hhE.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a cbX() {
        return this.hfF;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cch() {
        return this.hhE;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hhE != null) {
            return this.hhE.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giS = alaLastLiveroomInfo;
    }
}
