package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bk;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.q.e;
import com.baidu.live.q.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    private AlaLastLiveroomInfo fMS;
    private com.baidu.tieba.ala.liveroom.data.a gEE;
    private boolean gFC;
    private bk gFt;
    private com.baidu.tieba.ala.player.d gFx;
    private short gGw = 0;
    private com.baidu.live.liveroom.f.a gGx;
    private com.baidu.live.liveroom.a.c gGy;
    private String otherParams;

    public void d(short s) {
        if (this.gGx != null && (this.gGx instanceof b)) {
            this.gGx.ce(true);
            this.gGx = null;
        }
        if (this.gGx == null) {
            this.gGx = com.baidu.live.liveroom.f.c.Ne().Nf().b(s);
            if (this.gGx != null) {
                this.gGx.setActivity(this.gEE.pageContext.getPageActivity());
                this.gGx.a(this.gGy);
                this.gGx.b(this.gEE.gOO);
                if (this.gEE.gOO.getParent() != null && (this.gEE.gOO.getParent() instanceof ViewGroup)) {
                    this.gGx.p((ViewGroup) this.gEE.gOO.getParent());
                }
                this.gGx.a(this.gEE.gOM, this.gEE.bkU);
                this.gGw = (short) 0;
                this.gEE.gOR = false;
                this.gGx.init();
                return;
            }
            return;
        }
        this.gGx.b(this.gEE.gOO);
        if (this.gEE.gOO.getParent() != null && (this.gEE.gOO.getParent() instanceof ViewGroup)) {
            this.gGx.p((ViewGroup) this.gEE.gOO.getParent());
        }
        this.gGx.a(this.gEE.gOM, this.gEE.bkU);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.gGx != null && !(this.gGx instanceof a)) {
                this.gGx.ce(true);
                this.gGx = null;
            }
            if (this.gGx == null) {
                a aVar = new a();
                this.gGw = (short) 0;
                aVar.a(this.gEE);
                aVar.a(this.gGy);
                aVar.setActivity(this.gEE.pageContext.getPageActivity());
                this.gEE.gOR = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gGx = aVar;
            }
            this.gGx.a(this.gEE.gOM, this.gEE.bkU);
        } else if (2 == s) {
            if (this.gGx != null && !(this.gGx instanceof d)) {
                this.gGx.ce(true);
                this.gGx = null;
            }
            if (this.gGx == null) {
                d dVar = new d();
                this.gGw = (short) 0;
                dVar.a(this.gEE);
                dVar.a(this.gGy);
                dVar.setActivity(this.gEE.pageContext.getPageActivity());
                this.gEE.gOR = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gGx = dVar;
            }
        }
        if (this.gGx instanceof b) {
            b bVar = (b) this.gGx;
            bVar.bSt();
            bVar.mn(this.gFC);
            bVar.a(this.gFt);
            bVar.a(this.gFx);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.q.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bk bkVar) {
        if (this.gEE == null) {
            this.gEE = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gEE.pageContext = tbPageContext;
        this.gEE.gOO = alaLiveView;
        this.gEE.bkU = fVar;
        this.gEE.gOM = eVar;
        this.gEE.gON = dVar;
        this.gEE.fromType = str;
        this.gEE.enterTime = j;
        this.gEE.gOP = z;
        this.gEE.gOS = arrayList;
        this.gEE.gOT = false;
        this.gFt = bkVar;
    }

    public void mn(boolean z) {
        this.gFC = z;
        if (this.gGx != null && (this.gGx instanceof b)) {
            ((b) this.gGx).mn(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gFx = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gGy = cVar;
        if (this.gGx != null) {
            this.gGx.a(this.gGy);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gEE != null) {
            this.gEE.gOM = alaLiveRoomBlurPageLayout;
        }
    }

    public void mr(boolean z) {
        if (this.gGw != 1) {
            if (this.gEE != null) {
                this.gEE.gOR = false;
            }
            try {
                if (this.gGx != null) {
                    if (this.gEE != null) {
                        if (this.gGx instanceof d) {
                            ((d) this.gGx).b(this.fMS);
                        } else if (this.gGx instanceof a) {
                            ((a) this.gGx).b(this.fMS);
                        }
                        this.gGx.n(this.gEE.gON.Gm());
                    }
                    if ((this.gGx instanceof d) && z) {
                        ((d) this.gGx).mt(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gGw = (short) 1;
        }
    }

    public void dM(int i) {
        if (this.gEE != null) {
            this.gEE.gOT = true;
        }
        if (this.gGx != null) {
            this.gGx.dM(i);
        }
    }

    public void bTp() {
        if (this.gEE != null) {
            this.gEE.gOQ = true;
        }
    }

    public void a(u uVar) {
        if (this.gGx != null) {
            this.gGx.l(uVar);
        }
    }

    public void c(n nVar) {
        if (this.gGx != null) {
            this.gGx.b(nVar);
        }
    }

    public void ms(boolean z) {
        if (this.gGw != 3) {
            try {
                if (this.gEE != null) {
                    this.gEE.gOR = false;
                }
                if (this.gGx != null) {
                    this.gGx.cg(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gGw = (short) 3;
        }
    }

    public void bTq() {
        if (this.gGw != 4) {
            try {
                if (this.gEE != null) {
                    this.gEE.gOR = true;
                    if (this.gGx != null) {
                        this.gGx.o(this.gEE.gON.Gm());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gFt = null;
            this.gGw = (short) 4;
        }
    }

    public boolean bTr() {
        if (this.gGx == null || !(this.gGx instanceof b)) {
            return false;
        }
        return ((b) this.gGx).bSl();
    }

    public boolean bTs() {
        if (this.gGx != null && (this.gGx instanceof b) && ((b) this.gGx).gFL) {
            return false;
        }
        if (this.gGw != 5) {
            if (this.gEE != null) {
                this.gEE.gOR = false;
            }
            try {
                if (this.gGx != null) {
                    boolean Nc = this.gGx.Nc();
                    if (Nc && (this.gGx instanceof b)) {
                        ((b) this.gGx).gFK = true;
                    }
                    return Nc;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gGw = (short) 5;
        }
        if (this.gGx != null && (this.gGx instanceof b)) {
            ((b) this.gGx).gFK = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gGx != null) {
            this.gGx.ce(false);
        }
    }

    public void enterBackground() {
        if (this.gGx != null) {
            this.gGx.onPause();
        }
    }

    public void enterForeground() {
        if (this.gGx != null) {
            this.gGx.onResume();
        }
    }

    public void bTt() {
        if (this.gGx != null) {
            this.gGx.onStop();
        }
    }

    public void bTu() {
        if (this.gGx != null) {
            this.gGx.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gGx != null) {
            this.gGx.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gGx != null) {
            this.gGx.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gGx != null) {
            this.gGx.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bTl() {
        return this.gEE;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bTv() {
        return this.gGx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gGx != null) {
            return this.gGx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fMS = alaLastLiveroomInfo;
    }
}
