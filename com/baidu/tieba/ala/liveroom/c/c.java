package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.data.i;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a dWC;
    private short dXH = 0;
    private b dXI;
    private e dXJ;
    private i dXg;
    private String otherParams;

    public void b(short s) {
        if (1 == s) {
            if (this.dXI != null && !(this.dXI instanceof a)) {
                this.dXI.onDestory();
                this.dXI = null;
            }
            if (this.dXI == null) {
                this.dXI = new a();
                this.dXH = (short) 0;
                this.dXI.a(this.dWC);
                this.dXI.a(this.dXJ);
                this.dWC.eeQ = false;
                this.dXI.setOtherParams(this.otherParams);
                this.dXI.init();
            }
        } else if (2 == s) {
            if (this.dXI != null && !(this.dXI instanceof d)) {
                this.dXI.onDestory();
                this.dXI = null;
            }
            if (this.dXI == null) {
                this.dXI = new d();
                this.dXH = (short) 0;
                this.dXI.a(this.dWC);
                this.dXI.a(this.dXJ);
                this.dWC.eeQ = false;
                this.dXI.setOtherParams(this.otherParams);
                this.dXI.init();
            }
        }
        this.dXI.aOP();
        this.dXI.a(this.dXg);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, i iVar) {
        if (this.dWC == null) {
            this.dWC = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.dWC.pageContext = tbPageContext;
        this.dWC.eeM = alaLiveView;
        this.dWC.eeK = view;
        this.dWC.eeN = viewGroup;
        this.dWC.eeL = cVar;
        this.dWC.fromType = str;
        this.dWC.enterTime = j;
        this.dWC.eeO = z;
        this.dWC.eeR = arrayList;
        this.dWC.eeS = false;
        this.dXg = iVar;
    }

    public void a(e eVar) {
        this.dXJ = eVar;
        if (this.dXI != null) {
            this.dXI.a(this.dXJ);
        }
    }

    public void b(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.dWC != null) {
            this.dWC.eeN = alaLiveRoomBlurPageLayout;
        }
    }

    public void hx(boolean z) {
        if (this.dXH != 1) {
            if (this.dWC != null) {
                this.dWC.eeQ = false;
            }
            if (this.dXI != null) {
                this.dXI.uN();
                if ((this.dXI instanceof d) && z) {
                    ((d) this.dXI).hz(true);
                }
            }
            this.dXH = (short) 1;
        }
    }

    public void aS(int i) {
        this.dWC.eeS = true;
        if (this.dXI != null) {
            this.dXI.aS(i);
        }
    }

    public void aPB() {
        if (this.dWC != null) {
            this.dWC.eeP = true;
        }
    }

    public void b(com.baidu.live.data.i iVar) {
        if (this.dXI != null) {
            this.dXI.a(iVar);
        }
    }

    public void c(com.baidu.live.data.e eVar) {
        if (this.dXI != null) {
            this.dXI.b(eVar);
        }
    }

    public void hy(boolean z) {
        if (this.dXH != 3) {
            if (this.dWC != null) {
                this.dWC.eeQ = false;
            }
            if (this.dXI != null) {
                this.dXI.hp(z);
            }
            this.dXH = (short) 3;
        }
    }

    public void aPC() {
        if (this.dXH != 4) {
            if (this.dWC != null) {
                this.dWC.eeQ = true;
            }
            if (this.dXI != null) {
                this.dXI.aOF();
            }
            this.dXg = null;
            this.dXH = (short) 4;
        }
    }

    public boolean aPD() {
        return this.dXI != null && this.dXI.aOI();
    }

    public boolean aPE() {
        if (this.dXI == null || !this.dXI.dXr) {
            if (this.dXH != 5) {
                if (this.dWC != null) {
                    this.dWC.eeQ = false;
                }
                if (this.dXI != null) {
                    boolean aPp = this.dXI.aPp();
                    if (aPp) {
                        this.dXI.dXq = true;
                        return aPp;
                    }
                    return aPp;
                }
                this.dXH = (short) 5;
            }
            if (this.dXI != null) {
                this.dXI.dXq = true;
            }
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.dXI != null) {
            this.dXI.onDestory();
        }
    }

    public void enterBackground() {
        if (this.dXI != null) {
            this.dXI.aPq();
        }
    }

    public void enterForeground() {
        if (this.dXI != null) {
            this.dXI.aPr();
        }
    }

    public void aPF() {
        if (this.dXI != null) {
            this.dXI.aOM();
        }
    }

    public void aPG() {
        if (this.dXI != null) {
            this.dXI.aON();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.dXI != null) {
            this.dXI.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.dXI != null) {
            this.dXI.onKeyboardVisibilityChanged(z);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.dXI != null) {
            this.dXI.E(i, i2, i3);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
