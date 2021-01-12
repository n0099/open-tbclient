package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.v.e;
import com.baidu.live.v.f;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class c {
    private AlaLastLiveroomInfo goI;
    private com.baidu.tieba.ala.liveroom.data.a hmN;
    private br hnH;
    private com.baidu.tieba.ala.player.d hnK;
    private boolean hnS;
    private short hoQ = 0;
    private com.baidu.live.liveroom.f.a hoR;
    private com.baidu.live.liveroom.a.c hoS;
    private String otherParams;

    public void e(short s) {
        if (this.hoR != null && (this.hoR instanceof b)) {
            this.hoR.cw(true);
            this.hoR = null;
        }
        if (this.hoR == null) {
            this.hoR = com.baidu.live.liveroom.f.c.LC().LD().c(s);
            if (this.hoR != null) {
                this.hoR.setActivity(this.hmN.pageContext.getPageActivity());
                this.hoR.a(this.hoS);
                this.hoR.b(this.hmN.hxk);
                if (this.hmN.hxk.getParent() != null && (this.hmN.hxk.getParent() instanceof ViewGroup)) {
                    this.hoR.o((ViewGroup) this.hmN.hxk.getParent());
                }
                this.hoR.a(this.hmN.hxi, this.hmN.bon);
                this.hoQ = (short) 0;
                this.hmN.hxo = false;
                this.hoR.init();
                return;
            }
            return;
        }
        this.hoR.b(this.hmN.hxk);
        if (this.hmN.hxk.getParent() != null && (this.hmN.hxk.getParent() instanceof ViewGroup)) {
            this.hoR.o((ViewGroup) this.hmN.hxk.getParent());
        }
        this.hoR.a(this.hmN.hxi, this.hmN.bon);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.hoR != null && !(this.hoR instanceof a)) {
                this.hoR.cw(true);
                this.hoR = null;
            }
            if (this.hoR == null) {
                a aVar = new a();
                this.hoQ = (short) 0;
                aVar.a(this.hmN);
                aVar.a(this.hoS);
                aVar.setActivity(this.hmN.pageContext.getPageActivity());
                this.hmN.hxo = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.hoR = aVar;
            }
            this.hoR.a(this.hmN.hxi, this.hmN.bon);
        } else if (2 == s) {
            if (this.hoR != null && !(this.hoR instanceof d)) {
                this.hoR.cw(true);
                this.hoR = null;
            }
            if (this.hoR == null) {
                d dVar = new d();
                this.hoQ = (short) 0;
                dVar.a(this.hmN);
                dVar.a(this.hoS);
                dVar.setActivity(this.hmN.pageContext.getPageActivity());
                this.hmN.hxo = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.hoR = dVar;
            }
        }
        if (this.hoR instanceof b) {
            b bVar = (b) this.hoR;
            bVar.bZP();
            bVar.nD(this.hnS);
            bVar.a(this.hnH);
            bVar.a(this.hnK);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, br brVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hmN == null) {
            this.hmN = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hmN.pageContext = tbPageContext;
        this.hmN.hxk = alaLiveView;
        this.hmN.hxl = alaLoopViewPager;
        this.hmN.bon = fVar;
        this.hmN.hxi = eVar;
        this.hmN.hxj = dVar;
        this.hmN.fromType = str;
        this.hmN.enterTime = j;
        this.hmN.hxm = z;
        this.hmN.hxp = arrayList;
        this.hmN.hxq = false;
        this.hnH = brVar;
    }

    public void nD(boolean z) {
        this.hnS = z;
        if (this.hoR != null && (this.hoR instanceof b)) {
            ((b) this.hoR).nD(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hnK = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hoS = cVar;
        if (this.hoR != null) {
            this.hoR.a(this.hoS);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hmN != null) {
            this.hmN.hxi = alaLiveRoomBlurPageLayout;
        }
    }

    public void nI(boolean z) {
        if (this.hoQ != 1) {
            if (this.hmN != null) {
                this.hmN.hxo = false;
            }
            try {
                if (this.hoR != null) {
                    if (this.hmN != null) {
                        if (this.hoR instanceof d) {
                            ((d) this.hoR).b(this.goI);
                        } else if (this.hoR instanceof a) {
                            ((a) this.hoR).b(this.goI);
                        }
                        this.hoR.m(this.hmN.hxj.DW());
                    }
                    if ((this.hoR instanceof d) && z) {
                        ((d) this.hoR).nK(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoQ = (short) 1;
        }
    }

    public void cs(int i) {
        if (this.hmN != null) {
            this.hmN.hxq = true;
        }
        if (this.hoR != null) {
            this.hoR.cs(i);
        }
    }

    public void caT() {
        if (this.hmN != null) {
            this.hmN.hxn = true;
        }
    }

    public void a(x xVar) {
        if (this.hoR != null) {
            this.hoR.k(xVar);
        }
    }

    public void c(r rVar) {
        if (this.hoR != null) {
            this.hoR.b(rVar);
        }
    }

    public void nJ(boolean z) {
        if (this.hoQ != 3) {
            try {
                if (this.hmN != null) {
                    this.hmN.hxo = false;
                }
                if (this.hoR != null) {
                    this.hoR.cy(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoQ = (short) 3;
        }
    }

    public void caU() {
        if (this.hoQ != 4) {
            try {
                if (this.hmN != null) {
                    this.hmN.hxo = true;
                    if (this.hoR != null) {
                        this.hoR.n(this.hmN.hxj.DW());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hnH = null;
            this.hoQ = (short) 4;
        }
    }

    public boolean caV() {
        if (this.hoR == null || !(this.hoR instanceof b)) {
            return false;
        }
        return ((b) this.hoR).bZI();
    }

    public boolean caW() {
        if (this.hoR != null && (this.hoR instanceof b) && ((b) this.hoR).hoc) {
            return false;
        }
        if (this.hoQ != 5) {
            if (this.hmN != null) {
                this.hmN.hxo = false;
            }
            try {
                if (this.hoR != null) {
                    boolean LA = this.hoR.LA();
                    if (LA && (this.hoR instanceof b)) {
                        ((b) this.hoR).hob = true;
                    }
                    return LA;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hoQ = (short) 5;
        }
        if (this.hoR != null && (this.hoR instanceof b)) {
            ((b) this.hoR).hob = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.hoR != null) {
            this.hoR.cw(false);
        }
    }

    public void enterBackground() {
        if (this.hoR != null) {
            this.hoR.onPause();
        }
    }

    public void enterForeground() {
        if (this.hoR != null) {
            this.hoR.onResume();
        }
    }

    public void caX() {
        if (this.hoR != null) {
            this.hoR.onStop();
        }
    }

    public void caY() {
        if (this.hoR != null) {
            this.hoR.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hoR != null) {
            this.hoR.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hoR != null) {
            this.hoR.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hoR != null) {
            this.hoR.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a caO() {
        return this.hmN;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a caZ() {
        return this.hoR;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hoR != null) {
            return this.hoR.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.goI = alaLastLiveroomInfo;
    }
}
