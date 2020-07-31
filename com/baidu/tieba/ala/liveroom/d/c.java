package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.as;
import com.baidu.live.data.bd;
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
/* loaded from: classes4.dex */
public class c {
    private AlaLastLiveroomInfo flX;
    private com.baidu.tieba.ala.liveroom.data.a gaY;
    private bd gbL;
    private boolean gbR;
    private short gcB = 0;
    private com.baidu.live.liveroom.f.a gcC;
    private com.baidu.live.liveroom.a.c gcD;
    private String otherParams;

    public void d(short s) {
        if (this.gcC != null && (this.gcC instanceof b)) {
            this.gcC.bU(true);
            this.gcC = null;
        }
        if (this.gcC == null) {
            this.gcC = com.baidu.live.liveroom.f.c.FJ().FK().b(s);
            if (this.gcC != null) {
                this.gcC.setActivity(this.gaY.pageContext.getPageActivity());
                this.gcC.a(this.gcD);
                this.gcC.b(this.gaY.glb);
                if (this.gaY.glb.getParent() != null && (this.gaY.glb.getParent() instanceof ViewGroup)) {
                    this.gcC.n((ViewGroup) this.gaY.glb.getParent());
                }
                this.gcC.a(this.gaY.gkZ, this.gaY.aYS);
                this.gcB = (short) 0;
                this.gaY.gle = false;
                this.gcC.init();
                return;
            }
            return;
        }
        this.gcC.b(this.gaY.glb);
        if (this.gaY.glb.getParent() != null && (this.gaY.glb.getParent() instanceof ViewGroup)) {
            this.gcC.n((ViewGroup) this.gaY.glb.getParent());
        }
        this.gcC.a(this.gaY.gkZ, this.gaY.aYS);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.gcC != null && !(this.gcC instanceof a)) {
                this.gcC.bU(true);
                this.gcC = null;
            }
            if (this.gcC == null) {
                a aVar = new a();
                this.gcB = (short) 0;
                aVar.a(this.gaY);
                aVar.a(this.gcD);
                aVar.setActivity(this.gaY.pageContext.getPageActivity());
                this.gaY.gle = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gcC = aVar;
            }
            this.gcC.a(this.gaY.gkZ, this.gaY.aYS);
        } else if (2 == s) {
            if (this.gcC != null && !(this.gcC instanceof d)) {
                this.gcC.bU(true);
                this.gcC = null;
            }
            if (this.gcC == null) {
                d dVar = new d();
                this.gcB = (short) 0;
                dVar.a(this.gaY);
                dVar.a(this.gcD);
                dVar.setActivity(this.gaY.pageContext.getPageActivity());
                this.gaY.gle = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gcC = dVar;
            }
        }
        if (this.gcC instanceof b) {
            b bVar = (b) this.gcC;
            bVar.bEq();
            bVar.lh(this.gbR);
            bVar.a(this.gbL);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.o.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bd bdVar) {
        if (this.gaY == null) {
            this.gaY = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gaY.pageContext = tbPageContext;
        this.gaY.glb = alaLiveView;
        this.gaY.aYS = fVar;
        this.gaY.gkZ = eVar;
        this.gaY.gla = cVar;
        this.gaY.fromType = str;
        this.gaY.enterTime = j;
        this.gaY.glc = z;
        this.gaY.glf = arrayList;
        this.gaY.glg = false;
        this.gbL = bdVar;
    }

    public void lh(boolean z) {
        this.gbR = z;
        if (this.gcC != null && (this.gcC instanceof b)) {
            ((b) this.gcC).lh(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gcD = cVar;
        if (this.gcC != null) {
            this.gcC.a(this.gcD);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gaY != null) {
            this.gaY.gkZ = alaLiveRoomBlurPageLayout;
        }
    }

    public void lk(boolean z) {
        if (this.gcB != 1) {
            if (this.gaY != null) {
                this.gaY.gle = false;
            }
            try {
                if (this.gcC != null) {
                    if (this.gaY != null) {
                        if (this.gcC instanceof d) {
                            ((d) this.gcC).b(this.flX);
                        } else if (this.gcC instanceof a) {
                            ((a) this.gcC).b(this.flX);
                        }
                        this.gcC.m(this.gaY.gla.FO());
                    }
                    if ((this.gcC instanceof d) && z) {
                        ((d) this.gcC).lm(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gcB = (short) 1;
        }
    }

    public void bR(int i) {
        if (this.gaY != null) {
            this.gaY.glg = true;
        }
        if (this.gcC != null) {
            this.gcC.bR(i);
        }
    }

    public void bFh() {
        if (this.gaY != null) {
            this.gaY.gld = true;
        }
    }

    public void a(q qVar) {
        if (this.gcC != null) {
            this.gcC.k(qVar);
        }
    }

    public void c(k kVar) {
        if (this.gcC != null) {
            this.gcC.b(kVar);
        }
    }

    public void ll(boolean z) {
        if (this.gcB != 3) {
            try {
                if (this.gaY != null) {
                    this.gaY.gle = false;
                }
                if (this.gcC != null) {
                    this.gcC.bV(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gcB = (short) 3;
        }
    }

    public void bFi() {
        if (this.gcB != 4) {
            try {
                if (this.gaY != null) {
                    this.gaY.gle = true;
                    if (this.gcC != null) {
                        this.gcC.n(this.gaY.gla.FO());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gbL = null;
            this.gcB = (short) 4;
        }
    }

    public boolean bFj() {
        if (this.gcC == null || !(this.gcC instanceof b)) {
            return false;
        }
        return ((b) this.gcC).bEi();
    }

    public boolean bFk() {
        if (this.gcC != null && (this.gcC instanceof b) && ((b) this.gcC).gca) {
            return false;
        }
        if (this.gcB != 5) {
            if (this.gaY != null) {
                this.gaY.gle = false;
            }
            try {
                if (this.gcC != null) {
                    boolean FI = this.gcC.FI();
                    if (FI && (this.gcC instanceof b)) {
                        ((b) this.gcC).gbZ = true;
                    }
                    return FI;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gcB = (short) 5;
        }
        if (this.gcC != null && (this.gcC instanceof b)) {
            ((b) this.gcC).gbZ = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gcC != null) {
            this.gcC.bU(false);
        }
    }

    public void enterBackground() {
        if (this.gcC != null) {
            this.gcC.onPause();
        }
    }

    public void enterForeground() {
        if (this.gcC != null) {
            this.gcC.onResume();
        }
    }

    public void bFl() {
        if (this.gcC != null) {
            this.gcC.onStop();
        }
    }

    public void bFm() {
        if (this.gcC != null) {
            this.gcC.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gcC != null) {
            this.gcC.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gcC != null) {
            this.gcC.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gcC != null) {
            this.gcC.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bFe() {
        return this.gaY;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bFn() {
        return this.gcC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gcC != null) {
            return this.gcC.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.flX = alaLastLiveroomInfo;
    }

    public void a(as asVar, AlaLiveInfoData alaLiveInfoData) {
        if (this.gcC instanceof b) {
            ((b) this.gcC).a(asVar, alaLiveInfoData);
        }
    }
}
