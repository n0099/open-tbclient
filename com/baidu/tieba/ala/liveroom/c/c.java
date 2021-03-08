package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.bw;
import com.baidu.live.data.v;
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
/* loaded from: classes10.dex */
public class c {
    private AlaLastLiveroomInfo gto;
    private com.baidu.tieba.ala.liveroom.data.a hsX;
    private bw htP;
    private com.baidu.tieba.ala.player.d htS;
    private short huX = 0;
    private com.baidu.live.liveroom.f.a huY;
    private com.baidu.live.liveroom.a.c huZ;
    private boolean hua;
    private String otherParams;

    public void e(short s) {
        if (this.huY != null && (this.huY instanceof b)) {
            this.huY.cF(true);
            this.huY = null;
        }
        if (this.huY == null) {
            this.huY = com.baidu.live.liveroom.f.c.Nd().Ne().c(s);
            if (this.huY != null) {
                this.huY.setActivity(this.hsX.pageContext.getPageActivity());
                this.huY.a(this.huZ);
                this.huY.b(this.hsX.hDr);
                if (this.hsX.hDr.getParent() != null && (this.hsX.hDr.getParent() instanceof ViewGroup)) {
                    this.huY.o((ViewGroup) this.hsX.hDr.getParent());
                }
                this.huY.a(this.hsX.hDp, this.hsX.btp);
                this.huX = (short) 0;
                this.hsX.hDv = false;
                this.huY.init();
                return;
            }
            return;
        }
        this.huY.b(this.hsX.hDr);
        if (this.hsX.hDr.getParent() != null && (this.hsX.hDr.getParent() instanceof ViewGroup)) {
            this.huY.o((ViewGroup) this.hsX.hDr.getParent());
        }
        this.huY.a(this.hsX.hDp, this.hsX.btp);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.huY != null && !(this.huY instanceof a)) {
                this.huY.cF(true);
                this.huY = null;
            }
            if (this.huY == null) {
                a aVar = new a();
                this.huX = (short) 0;
                aVar.a(this.hsX);
                aVar.a(this.huZ);
                aVar.setActivity(this.hsX.pageContext.getPageActivity());
                this.hsX.hDv = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.huY = aVar;
            }
            this.huY.a(this.hsX.hDp, this.hsX.btp);
        } else if (2 == s) {
            if (this.huY != null && !(this.huY instanceof d)) {
                this.huY.cF(true);
                this.huY = null;
            }
            if (this.huY == null) {
                d dVar = new d();
                this.huX = (short) 0;
                dVar.a(this.hsX);
                dVar.a(this.huZ);
                dVar.setActivity(this.hsX.pageContext.getPageActivity());
                this.hsX.hDv = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.huY = dVar;
            }
        }
        if (this.huY instanceof b) {
            b bVar = (b) this.huY;
            bVar.caY();
            bVar.nO(this.hua);
            bVar.a(this.htP);
            bVar.a(this.htS);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.n.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hsX == null) {
            this.hsX = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hsX.pageContext = tbPageContext;
        this.hsX.hDr = alaLiveView;
        this.hsX.hDs = alaLoopViewPager;
        this.hsX.btp = fVar;
        this.hsX.hDp = eVar;
        this.hsX.hDq = dVar;
        this.hsX.fromType = str;
        this.hsX.enterTime = j;
        this.hsX.hDt = z;
        this.hsX.hDw = arrayList;
        this.hsX.hDx = false;
        this.htP = bwVar;
    }

    public void nO(boolean z) {
        this.hua = z;
        if (this.huY != null && (this.huY instanceof b)) {
            ((b) this.huY).nO(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.htS = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.huZ = cVar;
        if (this.huY != null) {
            this.huY.a(this.huZ);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hsX != null) {
            this.hsX.hDp = alaLiveRoomBlurPageLayout;
        }
    }

    public void nT(boolean z) {
        if (this.huX != 1) {
            if (this.hsX != null) {
                this.hsX.hDv = false;
            }
            try {
                if (this.huY != null) {
                    if (this.hsX != null) {
                        if (this.huY instanceof d) {
                            ((d) this.huY).b(this.gto);
                        } else if (this.huY instanceof a) {
                            ((a) this.huY).b(this.gto);
                        }
                        this.huY.m(this.hsX.hDq.Fp());
                    }
                    if ((this.huY instanceof d) && z) {
                        ((d) this.huY).nV(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.huX = (short) 1;
        }
    }

    public void cw(int i) {
        if (this.hsX != null) {
            this.hsX.hDx = true;
        }
        if (this.huY != null) {
            this.huY.cw(i);
        }
    }

    public void cca() {
        if (this.hsX != null) {
            this.hsX.hDu = true;
        }
    }

    public void a(ab abVar) {
        if (this.huY != null) {
            this.huY.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.huY != null) {
            this.huY.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.huX != 3) {
            try {
                if (this.hsX != null) {
                    this.hsX.hDv = false;
                }
                if (this.huY != null) {
                    this.huY.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.huX = (short) 3;
        }
    }

    public void ccb() {
        if (this.huX != 4) {
            try {
                if (this.hsX != null) {
                    this.hsX.hDv = true;
                    if (this.huY != null) {
                        this.huY.n(this.hsX.hDq.Fp());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.htP = null;
            this.huX = (short) 4;
        }
    }

    public boolean ccc() {
        if (this.huY == null || !(this.huY instanceof b)) {
            return false;
        }
        return ((b) this.huY).caR();
    }

    public boolean ccd() {
        if (this.huY != null && (this.huY instanceof b) && ((b) this.huY).huk) {
            return false;
        }
        if (this.huX != 5) {
            if (this.hsX != null) {
                this.hsX.hDv = false;
            }
            try {
                if (this.huY != null) {
                    boolean Nb = this.huY.Nb();
                    if (Nb && (this.huY instanceof b)) {
                        ((b) this.huY).huj = true;
                    }
                    return Nb;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.huX = (short) 5;
        }
        if (this.huY != null && (this.huY instanceof b)) {
            ((b) this.huY).huj = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.huY != null) {
            this.huY.cF(false);
        }
    }

    public void enterBackground() {
        if (this.huY != null) {
            this.huY.onPause();
        }
    }

    public void enterForeground() {
        if (this.huY != null) {
            this.huY.onResume();
        }
    }

    public void cce() {
        if (this.huY != null) {
            this.huY.onStop();
        }
    }

    public void ccf() {
        if (this.huY != null) {
            this.huY.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.huY != null) {
            this.huY.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.huY != null) {
            this.huY.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.huY != null) {
            this.huY.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a cbV() {
        return this.hsX;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a ccg() {
        return this.huY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.huY != null) {
            return this.huY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gto = alaLastLiveroomInfo;
    }
}
