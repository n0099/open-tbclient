package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.o.e;
import com.baidu.live.o.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private aq eSY;
    private com.baidu.tieba.ala.liveroom.data.a eSo;
    private short eTK = 0;
    private com.baidu.live.liveroom.f.a eTL;
    private com.baidu.live.liveroom.a.b eTM;
    private boolean eTd;
    private String otherParams;

    public void d(short s) {
        if (this.eTL != null && (this.eTL instanceof b)) {
            this.eTL.be(true);
            this.eTL = null;
        }
        if (this.eTL == null) {
            this.eTL = com.baidu.live.liveroom.f.c.yP().yQ().b(s);
            if (this.eTL != null) {
                this.eTL.setActivity(this.eSo.pageContext.getPageActivity());
                this.eTL.a(this.eTM);
                this.eTL.b(this.eSo.faU);
                if (this.eSo.faU.getParent() != null && (this.eSo.faU.getParent() instanceof ViewGroup)) {
                    this.eTL.g((ViewGroup) this.eSo.faU.getParent());
                }
                this.eTL.a(this.eSo.faS, this.eSo.awt);
                this.eTK = (short) 0;
                this.eSo.faX = false;
                this.eTL.init();
                return;
            }
            return;
        }
        this.eTL.b(this.eSo.faU);
        if (this.eSo.faU.getParent() != null && (this.eSo.faU.getParent() instanceof ViewGroup)) {
            this.eTL.g((ViewGroup) this.eSo.faU.getParent());
        }
        this.eTL.a(this.eSo.faS, this.eSo.awt);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.eTL != null && !(this.eTL instanceof a)) {
                this.eTL.be(true);
                this.eTL = null;
            }
            if (this.eTL == null) {
                a aVar = new a();
                this.eTK = (short) 0;
                aVar.a(this.eSo);
                aVar.a(this.eTM);
                aVar.setActivity(this.eSo.pageContext.getPageActivity());
                this.eSo.faX = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.eTL = aVar;
            }
            this.eTL.a(this.eSo.faS, this.eSo.awt);
        } else if (2 == s) {
            if (this.eTL != null && !(this.eTL instanceof d)) {
                this.eTL.be(true);
                this.eTL = null;
            }
            if (this.eTL == null) {
                d dVar = new d();
                this.eTK = (short) 0;
                dVar.a(this.eSo);
                dVar.a(this.eTM);
                dVar.setActivity(this.eSo.pageContext.getPageActivity());
                this.eSo.faX = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.eTL = dVar;
            }
        }
        if (this.eTL instanceof b) {
            b bVar = (b) this.eTL;
            bVar.bje();
            bVar.iW(this.eTd);
            bVar.a(this.eSY);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, aq aqVar) {
        if (this.eSo == null) {
            this.eSo = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eSo.pageContext = tbPageContext;
        this.eSo.faU = alaLiveView;
        this.eSo.awt = fVar;
        this.eSo.faS = eVar;
        this.eSo.faT = cVar;
        this.eSo.fromType = str;
        this.eSo.enterTime = j;
        this.eSo.faV = z;
        this.eSo.faY = arrayList;
        this.eSo.faZ = false;
        this.eSY = aqVar;
    }

    public void iW(boolean z) {
        this.eTd = z;
        if (this.eTL != null && (this.eTL instanceof b)) {
            ((b) this.eTL).iW(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.eTM = bVar;
        if (this.eTL != null) {
            this.eTL.a(this.eTM);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eSo != null) {
            this.eSo.faS = alaLiveRoomBlurPageLayout;
        }
    }

    public void ja(boolean z) {
        if (this.eTK != 1) {
            if (this.eSo != null) {
                this.eSo.faX = false;
            }
            try {
                if (this.eTL != null) {
                    if (this.eSo != null) {
                        this.eTL.k(this.eSo.faT.yT());
                    }
                    if ((this.eTL instanceof d) && z) {
                        ((d) this.eTL).jc(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTK = (short) 1;
        }
    }

    public void bk(int i) {
        this.eSo.faZ = true;
        if (this.eTL != null) {
            this.eTL.bk(i);
        }
    }

    public void bjR() {
        if (this.eSo != null) {
            this.eSo.faW = true;
        }
    }

    public void a(m mVar) {
        if (this.eTL != null) {
            this.eTL.i(mVar);
        }
    }

    public void d(h hVar) {
        if (this.eTL != null) {
            this.eTL.b(hVar);
        }
    }

    public void jb(boolean z) {
        if (this.eTK != 3) {
            try {
                if (this.eSo != null) {
                    this.eSo.faX = false;
                }
                if (this.eTL != null) {
                    this.eTL.bf(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTK = (short) 3;
        }
    }

    public void bjS() {
        if (this.eTK != 4) {
            try {
                if (this.eSo != null) {
                    this.eSo.faX = true;
                    if (this.eTL != null) {
                        this.eTL.l(this.eSo.faT.yT());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSY = null;
            this.eTK = (short) 4;
        }
    }

    public boolean bjT() {
        if (this.eTL == null || !(this.eTL instanceof b)) {
            return false;
        }
        return ((b) this.eTL).biW();
    }

    public boolean bjU() {
        if (this.eTL != null && (this.eTL instanceof b) && ((b) this.eTL).eTm) {
            return false;
        }
        if (this.eTK != 5) {
            if (this.eSo != null) {
                this.eSo.faX = false;
            }
            try {
                if (this.eTL != null) {
                    boolean yO = this.eTL.yO();
                    if (yO && (this.eTL instanceof b)) {
                        ((b) this.eTL).eTl = true;
                    }
                    return yO;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eTK = (short) 5;
        }
        if (this.eTL != null && (this.eTL instanceof b)) {
            ((b) this.eTL).eTl = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.eTL != null) {
            this.eTL.be(false);
        }
    }

    public void enterBackground() {
        if (this.eTL != null) {
            this.eTL.onPause();
        }
    }

    public void enterForeground() {
        if (this.eTL != null) {
            this.eTL.onResume();
        }
    }

    public void bjV() {
        if (this.eTL != null) {
            this.eTL.onStop();
        }
    }

    public void bjW() {
        if (this.eTL != null) {
            this.eTL.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eTL != null) {
            this.eTL.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eTL != null) {
            this.eTL.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.eTL != null) {
            this.eTL.j(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bjO() {
        return this.eSo;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bjX() {
        return this.eTL;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eTL != null) {
            return this.eTL.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
