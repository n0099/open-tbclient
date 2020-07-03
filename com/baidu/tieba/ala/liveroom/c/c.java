package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ar;
import com.baidu.live.data.bc;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.p.e;
import com.baidu.live.p.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a fVT;
    private bc fWG;
    private boolean fWM;
    private short fXw = 0;
    private com.baidu.live.liveroom.f.a fXx;
    private com.baidu.live.liveroom.a.c fXy;
    private AlaLastLiveroomInfo fgP;
    private String otherParams;

    public void d(short s) {
        if (this.fXx != null && (this.fXx instanceof b)) {
            this.fXx.bT(true);
            this.fXx = null;
        }
        if (this.fXx == null) {
            this.fXx = com.baidu.live.liveroom.f.c.FP().FQ().b(s);
            if (this.fXx != null) {
                this.fXx.setActivity(this.fVT.pageContext.getPageActivity());
                this.fXx.a(this.fXy);
                this.fXx.b(this.fVT.gfT);
                if (this.fVT.gfT.getParent() != null && (this.fVT.gfT.getParent() instanceof ViewGroup)) {
                    this.fXx.m((ViewGroup) this.fVT.gfT.getParent());
                }
                this.fXx.a(this.fVT.gfR, this.fVT.aYU);
                this.fXw = (short) 0;
                this.fVT.gfW = false;
                this.fXx.init();
                return;
            }
            return;
        }
        this.fXx.b(this.fVT.gfT);
        if (this.fVT.gfT.getParent() != null && (this.fVT.gfT.getParent() instanceof ViewGroup)) {
            this.fXx.m((ViewGroup) this.fVT.gfT.getParent());
        }
        this.fXx.a(this.fVT.gfR, this.fVT.aYU);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.fXx != null && !(this.fXx instanceof a)) {
                this.fXx.bT(true);
                this.fXx = null;
            }
            if (this.fXx == null) {
                a aVar = new a();
                this.fXw = (short) 0;
                aVar.a(this.fVT);
                aVar.a(this.fXy);
                aVar.setActivity(this.fVT.pageContext.getPageActivity());
                this.fVT.gfW = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.fXx = aVar;
            }
            this.fXx.a(this.fVT.gfR, this.fVT.aYU);
        } else if (2 == s) {
            if (this.fXx != null && !(this.fXx instanceof d)) {
                this.fXx.bT(true);
                this.fXx = null;
            }
            if (this.fXx == null) {
                d dVar = new d();
                this.fXw = (short) 0;
                dVar.a(this.fVT);
                dVar.a(this.fXy);
                dVar.setActivity(this.fVT.pageContext.getPageActivity());
                this.fVT.gfW = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.fXx = dVar;
            }
        }
        if (this.fXx instanceof b) {
            b bVar = (b) this.fXx;
            bVar.bBe();
            bVar.kE(this.fWM);
            bVar.a(this.fWG);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.n.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bc bcVar) {
        if (this.fVT == null) {
            this.fVT = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.fVT.pageContext = tbPageContext;
        this.fVT.gfT = alaLiveView;
        this.fVT.aYU = fVar;
        this.fVT.gfR = eVar;
        this.fVT.gfS = cVar;
        this.fVT.fromType = str;
        this.fVT.enterTime = j;
        this.fVT.gfU = z;
        this.fVT.gfX = arrayList;
        this.fVT.gfY = false;
        this.fWG = bcVar;
    }

    public void kE(boolean z) {
        this.fWM = z;
        if (this.fXx != null && (this.fXx instanceof b)) {
            ((b) this.fXx).kE(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.fXy = cVar;
        if (this.fXx != null) {
            this.fXx.a(this.fXy);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.fVT != null) {
            this.fVT.gfR = alaLiveRoomBlurPageLayout;
        }
    }

    public void kH(boolean z) {
        if (this.fXw != 1) {
            if (this.fVT != null) {
                this.fVT.gfW = false;
            }
            try {
                if (this.fXx != null) {
                    if (this.fVT != null) {
                        if (this.fXx instanceof d) {
                            ((d) this.fXx).b(this.fgP);
                        } else if (this.fXx instanceof a) {
                            ((a) this.fXx).b(this.fgP);
                        }
                        this.fXx.m(this.fVT.gfS.FU());
                    }
                    if ((this.fXx instanceof d) && z) {
                        ((d) this.fXx).kJ(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fXw = (short) 1;
        }
    }

    public void bL(int i) {
        if (this.fVT != null) {
            this.fVT.gfY = true;
        }
        if (this.fXx != null) {
            this.fXx.bL(i);
        }
    }

    public void bBV() {
        if (this.fVT != null) {
            this.fVT.gfV = true;
        }
    }

    public void a(q qVar) {
        if (this.fXx != null) {
            this.fXx.k(qVar);
        }
    }

    public void c(k kVar) {
        if (this.fXx != null) {
            this.fXx.b(kVar);
        }
    }

    public void kI(boolean z) {
        if (this.fXw != 3) {
            try {
                if (this.fVT != null) {
                    this.fVT.gfW = false;
                }
                if (this.fXx != null) {
                    this.fXx.bU(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fXw = (short) 3;
        }
    }

    public void bBW() {
        if (this.fXw != 4) {
            try {
                if (this.fVT != null) {
                    this.fVT.gfW = true;
                    if (this.fXx != null) {
                        this.fXx.n(this.fVT.gfS.FU());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fWG = null;
            this.fXw = (short) 4;
        }
    }

    public boolean bBX() {
        if (this.fXx == null || !(this.fXx instanceof b)) {
            return false;
        }
        return ((b) this.fXx).bAW();
    }

    public boolean bBY() {
        if (this.fXx != null && (this.fXx instanceof b) && ((b) this.fXx).fWV) {
            return false;
        }
        if (this.fXw != 5) {
            if (this.fVT != null) {
                this.fVT.gfW = false;
            }
            try {
                if (this.fXx != null) {
                    boolean FO = this.fXx.FO();
                    if (FO && (this.fXx instanceof b)) {
                        ((b) this.fXx).fWU = true;
                    }
                    return FO;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fXw = (short) 5;
        }
        if (this.fXx != null && (this.fXx instanceof b)) {
            ((b) this.fXx).fWU = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.fXx != null) {
            this.fXx.bT(false);
        }
    }

    public void enterBackground() {
        if (this.fXx != null) {
            this.fXx.onPause();
        }
    }

    public void enterForeground() {
        if (this.fXx != null) {
            this.fXx.onResume();
        }
    }

    public void bBZ() {
        if (this.fXx != null) {
            this.fXx.onStop();
        }
    }

    public void bCa() {
        if (this.fXx != null) {
            this.fXx.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fXx != null) {
            this.fXx.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fXx != null) {
            this.fXx.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fXx != null) {
            this.fXx.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bBS() {
        return this.fVT;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bCb() {
        return this.fXx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fXx != null) {
            return this.fXx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fgP = alaLastLiveroomInfo;
    }

    public void a(ar arVar, AlaLiveInfoData alaLiveInfoData) {
        if (this.fXx instanceof b) {
            ((b) this.fXx).a(arVar, alaLiveInfoData);
        }
    }
}
