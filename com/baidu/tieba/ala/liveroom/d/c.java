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
    private bo gWU;
    private com.baidu.tieba.ala.player.d gWX;
    private com.baidu.tieba.ala.liveroom.data.a gWe;
    private short gXX = 0;
    private com.baidu.live.liveroom.f.a gXY;
    private com.baidu.live.liveroom.a.c gXZ;
    private boolean gXe;
    private AlaLastLiveroomInfo gaF;
    private String otherParams;

    public void e(short s) {
        if (this.gXY != null && (this.gXY instanceof b)) {
            this.gXY.cj(true);
            this.gXY = null;
        }
        if (this.gXY == null) {
            this.gXY = com.baidu.live.liveroom.f.c.Np().Nq().c(s);
            if (this.gXY != null) {
                this.gXY.setActivity(this.gWe.pageContext.getPageActivity());
                this.gXY.a(this.gXZ);
                this.gXY.b(this.gWe.hgl);
                if (this.gWe.hgl.getParent() != null && (this.gWe.hgl.getParent() instanceof ViewGroup)) {
                    this.gXY.l((ViewGroup) this.gWe.hgl.getParent());
                }
                this.gXY.a(this.gWe.hgj, this.gWe.blY);
                this.gXX = (short) 0;
                this.gWe.hgp = false;
                this.gXY.init();
                return;
            }
            return;
        }
        this.gXY.b(this.gWe.hgl);
        if (this.gWe.hgl.getParent() != null && (this.gWe.hgl.getParent() instanceof ViewGroup)) {
            this.gXY.l((ViewGroup) this.gWe.hgl.getParent());
        }
        this.gXY.a(this.gWe.hgj, this.gWe.blY);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.gXY != null && !(this.gXY instanceof a)) {
                this.gXY.cj(true);
                this.gXY = null;
            }
            if (this.gXY == null) {
                a aVar = new a();
                this.gXX = (short) 0;
                aVar.a(this.gWe);
                aVar.a(this.gXZ);
                aVar.setActivity(this.gWe.pageContext.getPageActivity());
                this.gWe.hgp = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gXY = aVar;
            }
            this.gXY.a(this.gWe.hgj, this.gWe.blY);
        } else if (2 == s) {
            if (this.gXY != null && !(this.gXY instanceof d)) {
                this.gXY.cj(true);
                this.gXY = null;
            }
            if (this.gXY == null) {
                d dVar = new d();
                this.gXX = (short) 0;
                dVar.a(this.gWe);
                dVar.a(this.gXZ);
                dVar.setActivity(this.gWe.pageContext.getPageActivity());
                this.gWe.hgp = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gXY = dVar;
            }
        }
        if (this.gXY instanceof b) {
            b bVar = (b) this.gXY;
            bVar.bXi();
            bVar.mN(this.gXe);
            bVar.a(this.gWU);
            bVar.a(this.gWX);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.q.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bo boVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.gWe == null) {
            this.gWe = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gWe.pageContext = tbPageContext;
        this.gWe.hgl = alaLiveView;
        this.gWe.hgm = alaLoopViewPager;
        this.gWe.blY = fVar;
        this.gWe.hgj = eVar;
        this.gWe.hgk = dVar;
        this.gWe.fromType = str;
        this.gWe.enterTime = j;
        this.gWe.hgn = z;
        this.gWe.hgq = arrayList;
        this.gWe.hgr = false;
        this.gWU = boVar;
    }

    public void mN(boolean z) {
        this.gXe = z;
        if (this.gXY != null && (this.gXY instanceof b)) {
            ((b) this.gXY).mN(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gWX = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gXZ = cVar;
        if (this.gXY != null) {
            this.gXY.a(this.gXZ);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gWe != null) {
            this.gWe.hgj = alaLiveRoomBlurPageLayout;
        }
    }

    public void mR(boolean z) {
        if (this.gXX != 1) {
            if (this.gWe != null) {
                this.gWe.hgp = false;
            }
            try {
                if (this.gXY != null) {
                    if (this.gWe != null) {
                        if (this.gXY instanceof d) {
                            ((d) this.gXY).b(this.gaF);
                        } else if (this.gXY instanceof a) {
                            ((a) this.gXY).b(this.gaF);
                        }
                        this.gXY.l(this.gWe.hgk.Gz());
                    }
                    if ((this.gXY instanceof d) && z) {
                        ((d) this.gXY).mT(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXX = (short) 1;
        }
    }

    public void dI(int i) {
        if (this.gWe != null) {
            this.gWe.hgr = true;
        }
        if (this.gXY != null) {
            this.gXY.dI(i);
        }
    }

    public void bYh() {
        if (this.gWe != null) {
            this.gWe.hgo = true;
        }
    }

    public void a(w wVar) {
        if (this.gXY != null) {
            this.gXY.j(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gXY != null) {
            this.gXY.b(qVar);
        }
    }

    public void mS(boolean z) {
        if (this.gXX != 3) {
            try {
                if (this.gWe != null) {
                    this.gWe.hgp = false;
                }
                if (this.gXY != null) {
                    this.gXY.cl(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXX = (short) 3;
        }
    }

    public void bYi() {
        if (this.gXX != 4) {
            try {
                if (this.gWe != null) {
                    this.gWe.hgp = true;
                    if (this.gXY != null) {
                        this.gXY.m(this.gWe.hgk.Gz());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gWU = null;
            this.gXX = (short) 4;
        }
    }

    public boolean bYj() {
        if (this.gXY == null || !(this.gXY instanceof b)) {
            return false;
        }
        return ((b) this.gXY).bXb();
    }

    public boolean bYk() {
        if (this.gXY != null && (this.gXY instanceof b) && ((b) this.gXY).gXo) {
            return false;
        }
        if (this.gXX != 5) {
            if (this.gWe != null) {
                this.gWe.hgp = false;
            }
            try {
                if (this.gXY != null) {
                    boolean Nn = this.gXY.Nn();
                    if (Nn && (this.gXY instanceof b)) {
                        ((b) this.gXY).gXn = true;
                    }
                    return Nn;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gXX = (short) 5;
        }
        if (this.gXY != null && (this.gXY instanceof b)) {
            ((b) this.gXY).gXn = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gXY != null) {
            this.gXY.cj(false);
        }
    }

    public void enterBackground() {
        if (this.gXY != null) {
            this.gXY.onPause();
        }
    }

    public void enterForeground() {
        if (this.gXY != null) {
            this.gXY.onResume();
        }
    }

    public void bYl() {
        if (this.gXY != null) {
            this.gXY.onStop();
        }
    }

    public void bYm() {
        if (this.gXY != null) {
            this.gXY.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gXY != null) {
            this.gXY.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gXY != null) {
            this.gXY.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gXY != null) {
            this.gXY.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bYd() {
        return this.gWe;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bYn() {
        return this.gXY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gXY != null) {
            return this.gXY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaF = alaLastLiveroomInfo;
    }
}
