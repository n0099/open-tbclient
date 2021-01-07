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
/* loaded from: classes11.dex */
public class c {
    private AlaLastLiveroomInfo gtp;
    private com.baidu.tieba.ala.liveroom.data.a hru;
    private br hso;
    private com.baidu.tieba.ala.player.d hsr;
    private boolean hsz;
    private short htw = 0;
    private com.baidu.live.liveroom.f.a htx;
    private com.baidu.live.liveroom.a.c hty;
    private String otherParams;

    public void e(short s) {
        if (this.htx != null && (this.htx instanceof b)) {
            this.htx.cA(true);
            this.htx = null;
        }
        if (this.htx == null) {
            this.htx = com.baidu.live.liveroom.f.c.Px().Py().c(s);
            if (this.htx != null) {
                this.htx.setActivity(this.hru.pageContext.getPageActivity());
                this.htx.a(this.hty);
                this.htx.b(this.hru.hBQ);
                if (this.hru.hBQ.getParent() != null && (this.hru.hBQ.getParent() instanceof ViewGroup)) {
                    this.htx.o((ViewGroup) this.hru.hBQ.getParent());
                }
                this.htx.a(this.hru.hBO, this.hru.bsZ);
                this.htw = (short) 0;
                this.hru.hBU = false;
                this.htx.init();
                return;
            }
            return;
        }
        this.htx.b(this.hru.hBQ);
        if (this.hru.hBQ.getParent() != null && (this.hru.hBQ.getParent() instanceof ViewGroup)) {
            this.htx.o((ViewGroup) this.hru.hBQ.getParent());
        }
        this.htx.a(this.hru.hBO, this.hru.bsZ);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.htx != null && !(this.htx instanceof a)) {
                this.htx.cA(true);
                this.htx = null;
            }
            if (this.htx == null) {
                a aVar = new a();
                this.htw = (short) 0;
                aVar.a(this.hru);
                aVar.a(this.hty);
                aVar.setActivity(this.hru.pageContext.getPageActivity());
                this.hru.hBU = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.htx = aVar;
            }
            this.htx.a(this.hru.hBO, this.hru.bsZ);
        } else if (2 == s) {
            if (this.htx != null && !(this.htx instanceof d)) {
                this.htx.cA(true);
                this.htx = null;
            }
            if (this.htx == null) {
                d dVar = new d();
                this.htw = (short) 0;
                dVar.a(this.hru);
                dVar.a(this.hty);
                dVar.setActivity(this.hru.pageContext.getPageActivity());
                this.hru.hBU = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.htx = dVar;
            }
        }
        if (this.htx instanceof b) {
            b bVar = (b) this.htx;
            bVar.cdH();
            bVar.nH(this.hsz);
            bVar.a(this.hso);
            bVar.a(this.hsr);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, br brVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hru == null) {
            this.hru = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hru.pageContext = tbPageContext;
        this.hru.hBQ = alaLiveView;
        this.hru.hBR = alaLoopViewPager;
        this.hru.bsZ = fVar;
        this.hru.hBO = eVar;
        this.hru.hBP = dVar;
        this.hru.fromType = str;
        this.hru.enterTime = j;
        this.hru.hBS = z;
        this.hru.hBV = arrayList;
        this.hru.hBW = false;
        this.hso = brVar;
    }

    public void nH(boolean z) {
        this.hsz = z;
        if (this.htx != null && (this.htx instanceof b)) {
            ((b) this.htx).nH(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hsr = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.hty = cVar;
        if (this.htx != null) {
            this.htx.a(this.hty);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hru != null) {
            this.hru.hBO = alaLiveRoomBlurPageLayout;
        }
    }

    public void nM(boolean z) {
        if (this.htw != 1) {
            if (this.hru != null) {
                this.hru.hBU = false;
            }
            try {
                if (this.htx != null) {
                    if (this.hru != null) {
                        if (this.htx instanceof d) {
                            ((d) this.htx).b(this.gtp);
                        } else if (this.htx instanceof a) {
                            ((a) this.htx).b(this.gtp);
                        }
                        this.htx.m(this.hru.hBP.HR());
                    }
                    if ((this.htx instanceof d) && z) {
                        ((d) this.htx).nO(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htw = (short) 1;
        }
    }

    public void dY(int i) {
        if (this.hru != null) {
            this.hru.hBW = true;
        }
        if (this.htx != null) {
            this.htx.dY(i);
        }
    }

    public void ceL() {
        if (this.hru != null) {
            this.hru.hBT = true;
        }
    }

    public void a(x xVar) {
        if (this.htx != null) {
            this.htx.k(xVar);
        }
    }

    public void c(r rVar) {
        if (this.htx != null) {
            this.htx.b(rVar);
        }
    }

    public void nN(boolean z) {
        if (this.htw != 3) {
            try {
                if (this.hru != null) {
                    this.hru.hBU = false;
                }
                if (this.htx != null) {
                    this.htx.cC(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htw = (short) 3;
        }
    }

    public void ceM() {
        if (this.htw != 4) {
            try {
                if (this.hru != null) {
                    this.hru.hBU = true;
                    if (this.htx != null) {
                        this.htx.n(this.hru.hBP.HR());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hso = null;
            this.htw = (short) 4;
        }
    }

    public boolean ceN() {
        if (this.htx == null || !(this.htx instanceof b)) {
            return false;
        }
        return ((b) this.htx).cdA();
    }

    public boolean ceO() {
        if (this.htx != null && (this.htx instanceof b) && ((b) this.htx).hsJ) {
            return false;
        }
        if (this.htw != 5) {
            if (this.hru != null) {
                this.hru.hBU = false;
            }
            try {
                if (this.htx != null) {
                    boolean Pv = this.htx.Pv();
                    if (Pv && (this.htx instanceof b)) {
                        ((b) this.htx).hsI = true;
                    }
                    return Pv;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htw = (short) 5;
        }
        if (this.htx != null && (this.htx instanceof b)) {
            ((b) this.htx).hsI = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htx != null) {
            this.htx.cA(false);
        }
    }

    public void enterBackground() {
        if (this.htx != null) {
            this.htx.onPause();
        }
    }

    public void enterForeground() {
        if (this.htx != null) {
            this.htx.onResume();
        }
    }

    public void ceP() {
        if (this.htx != null) {
            this.htx.onStop();
        }
    }

    public void ceQ() {
        if (this.htx != null) {
            this.htx.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htx != null) {
            this.htx.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htx != null) {
            this.htx.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htx != null) {
            this.htx.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a ceG() {
        return this.hru;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ceR() {
        return this.htx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htx != null) {
            return this.htx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gtp = alaLastLiveroomInfo;
    }
}
