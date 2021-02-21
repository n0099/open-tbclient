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
/* loaded from: classes11.dex */
public class c {
    private AlaLastLiveroomInfo grF;
    private com.baidu.tieba.ala.liveroom.data.a hro;
    private bw hsg;
    private com.baidu.tieba.ala.player.d hsj;
    private boolean hsr;
    private short hto = 0;
    private com.baidu.live.liveroom.f.a htp;
    private com.baidu.live.liveroom.a.c htq;
    private String otherParams;

    public void e(short s) {
        if (this.htp != null && (this.htp instanceof b)) {
            this.htp.cF(true);
            this.htp = null;
        }
        if (this.htp == null) {
            this.htp = com.baidu.live.liveroom.f.c.Na().Nb().c(s);
            if (this.htp != null) {
                this.htp.setActivity(this.hro.pageContext.getPageActivity());
                this.htp.a(this.htq);
                this.htp.b(this.hro.hBI);
                if (this.hro.hBI.getParent() != null && (this.hro.hBI.getParent() instanceof ViewGroup)) {
                    this.htp.o((ViewGroup) this.hro.hBI.getParent());
                }
                this.htp.a(this.hro.hBG, this.hro.brO);
                this.hto = (short) 0;
                this.hro.hBM = false;
                this.htp.init();
                return;
            }
            return;
        }
        this.htp.b(this.hro.hBI);
        if (this.hro.hBI.getParent() != null && (this.hro.hBI.getParent() instanceof ViewGroup)) {
            this.htp.o((ViewGroup) this.hro.hBI.getParent());
        }
        this.htp.a(this.hro.hBG, this.hro.brO);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.htp != null && !(this.htp instanceof a)) {
                this.htp.cF(true);
                this.htp = null;
            }
            if (this.htp == null) {
                a aVar = new a();
                this.hto = (short) 0;
                aVar.a(this.hro);
                aVar.a(this.htq);
                aVar.setActivity(this.hro.pageContext.getPageActivity());
                this.hro.hBM = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.htp = aVar;
            }
            this.htp.a(this.hro.hBG, this.hro.brO);
        } else if (2 == s) {
            if (this.htp != null && !(this.htp instanceof d)) {
                this.htp.cF(true);
                this.htp = null;
            }
            if (this.htp == null) {
                d dVar = new d();
                this.hto = (short) 0;
                dVar.a(this.hro);
                dVar.a(this.htq);
                dVar.setActivity(this.hro.pageContext.getPageActivity());
                this.hro.hBM = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.htp = dVar;
            }
        }
        if (this.htp instanceof b) {
            b bVar = (b) this.htp;
            bVar.caS();
            bVar.nO(this.hsr);
            bVar.a(this.hsg);
            bVar.a(this.hsj);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.n.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hro == null) {
            this.hro = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hro.pageContext = tbPageContext;
        this.hro.hBI = alaLiveView;
        this.hro.hBJ = alaLoopViewPager;
        this.hro.brO = fVar;
        this.hro.hBG = eVar;
        this.hro.hBH = dVar;
        this.hro.fromType = str;
        this.hro.enterTime = j;
        this.hro.hBK = z;
        this.hro.hBN = arrayList;
        this.hro.hBO = false;
        this.hsg = bwVar;
    }

    public void nO(boolean z) {
        this.hsr = z;
        if (this.htp != null && (this.htp instanceof b)) {
            ((b) this.htp).nO(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hsj = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.htq = cVar;
        if (this.htp != null) {
            this.htp.a(this.htq);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hro != null) {
            this.hro.hBG = alaLiveRoomBlurPageLayout;
        }
    }

    public void nT(boolean z) {
        if (this.hto != 1) {
            if (this.hro != null) {
                this.hro.hBM = false;
            }
            try {
                if (this.htp != null) {
                    if (this.hro != null) {
                        if (this.htp instanceof d) {
                            ((d) this.htp).b(this.grF);
                        } else if (this.htp instanceof a) {
                            ((a) this.htp).b(this.grF);
                        }
                        this.htp.m(this.hro.hBH.Fm());
                    }
                    if ((this.htp instanceof d) && z) {
                        ((d) this.htp).nV(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hto = (short) 1;
        }
    }

    public void cv(int i) {
        if (this.hro != null) {
            this.hro.hBO = true;
        }
        if (this.htp != null) {
            this.htp.cv(i);
        }
    }

    public void cbU() {
        if (this.hro != null) {
            this.hro.hBL = true;
        }
    }

    public void a(ab abVar) {
        if (this.htp != null) {
            this.htp.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.htp != null) {
            this.htp.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.hto != 3) {
            try {
                if (this.hro != null) {
                    this.hro.hBM = false;
                }
                if (this.htp != null) {
                    this.htp.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hto = (short) 3;
        }
    }

    public void cbV() {
        if (this.hto != 4) {
            try {
                if (this.hro != null) {
                    this.hro.hBM = true;
                    if (this.htp != null) {
                        this.htp.n(this.hro.hBH.Fm());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hsg = null;
            this.hto = (short) 4;
        }
    }

    public boolean cbW() {
        if (this.htp == null || !(this.htp instanceof b)) {
            return false;
        }
        return ((b) this.htp).caL();
    }

    public boolean cbX() {
        if (this.htp != null && (this.htp instanceof b) && ((b) this.htp).hsB) {
            return false;
        }
        if (this.hto != 5) {
            if (this.hro != null) {
                this.hro.hBM = false;
            }
            try {
                if (this.htp != null) {
                    boolean MY = this.htp.MY();
                    if (MY && (this.htp instanceof b)) {
                        ((b) this.htp).hsA = true;
                    }
                    return MY;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hto = (short) 5;
        }
        if (this.htp != null && (this.htp instanceof b)) {
            ((b) this.htp).hsA = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htp != null) {
            this.htp.cF(false);
        }
    }

    public void enterBackground() {
        if (this.htp != null) {
            this.htp.onPause();
        }
    }

    public void enterForeground() {
        if (this.htp != null) {
            this.htp.onResume();
        }
    }

    public void cbY() {
        if (this.htp != null) {
            this.htp.onStop();
        }
    }

    public void cbZ() {
        if (this.htp != null) {
            this.htp.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htp != null) {
            this.htp.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htp != null) {
            this.htp.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htp != null) {
            this.htp.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a cbP() {
        return this.hro;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cca() {
        return this.htp;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htp != null) {
            return this.htp.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grF = alaLastLiveroomInfo;
    }
}
