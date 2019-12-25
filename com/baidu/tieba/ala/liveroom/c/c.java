package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.g;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.data.i;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private i eMR;
    private boolean eMW;
    private com.baidu.tieba.ala.liveroom.data.a eMj;
    private short eNC = 0;
    private b eND;
    private e eNE;
    private String otherParams;

    public void c(short s) {
        if (1 == s) {
            if (this.eND != null && !(this.eND instanceof a)) {
                this.eND.onDestory();
                this.eND = null;
            }
            if (this.eND == null) {
                this.eND = new a();
                this.eNC = (short) 0;
                this.eND.a(this.eMj);
                this.eND.a(this.eNE);
                this.eMj.eUK = false;
                this.eND.setOtherParams(this.otherParams);
                this.eND.init();
            }
        } else if (2 == s) {
            if (this.eND != null && !(this.eND instanceof d)) {
                this.eND.onDestory();
                this.eND = null;
            }
            if (this.eND == null) {
                this.eND = new d();
                this.eNC = (short) 0;
                this.eND.a(this.eMj);
                this.eND.a(this.eNE);
                this.eMj.eUK = false;
                this.eND.setOtherParams(this.otherParams);
                this.eND.init();
            }
        }
        this.eND.bgn();
        this.eND.iE(this.eMW);
        this.eND.a(this.eMR);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, i iVar) {
        if (this.eMj == null) {
            this.eMj = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eMj.pageContext = tbPageContext;
        this.eMj.eUG = alaLiveView;
        this.eMj.eUE = view;
        this.eMj.eUH = viewGroup;
        this.eMj.eUF = cVar;
        this.eMj.fromType = str;
        this.eMj.enterTime = j;
        this.eMj.eUI = z;
        this.eMj.eUL = arrayList;
        this.eMj.eUM = false;
        this.eMR = iVar;
    }

    public void iE(boolean z) {
        this.eMW = z;
        if (this.eND != null) {
            this.eND.iE(z);
        }
    }

    public void a(e eVar) {
        this.eNE = eVar;
        if (this.eND != null) {
            this.eND.a(this.eNE);
        }
    }

    public void b(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eMj != null) {
            this.eMj.eUH = alaLiveRoomBlurPageLayout;
        }
    }

    public void iL(boolean z) {
        if (this.eNC != 1) {
            if (this.eMj != null) {
                this.eMj.eUK = false;
            }
            if (this.eND != null) {
                this.eND.wL();
                if ((this.eND instanceof d) && z) {
                    ((d) this.eND).iN(true);
                }
            }
            this.eNC = (short) 1;
        }
    }

    public void bd(int i) {
        this.eMj.eUM = true;
        if (this.eND != null) {
            this.eND.bd(i);
        }
    }

    public void bhd() {
        if (this.eMj != null) {
            this.eMj.eUJ = true;
        }
    }

    public void a(k kVar) {
        if (this.eND != null) {
            this.eND.b(kVar);
        }
    }

    public void d(g gVar) {
        if (this.eND != null) {
            this.eND.c(gVar);
        }
    }

    public void iM(boolean z) {
        if (this.eNC != 3) {
            if (this.eMj != null) {
                this.eMj.eUK = false;
            }
            if (this.eND != null) {
                this.eND.iz(z);
            }
            this.eNC = (short) 3;
        }
    }

    public void bhe() {
        if (this.eNC != 4) {
            if (this.eMj != null) {
                this.eMj.eUK = true;
            }
            if (this.eND != null) {
                this.eND.bgb();
            }
            this.eMR = null;
            this.eNC = (short) 4;
        }
    }

    public boolean bhf() {
        return this.eND != null && this.eND.bge();
    }

    public boolean bhg() {
        if (this.eND == null || !this.eND.eNe) {
            if (this.eNC != 5) {
                if (this.eMj != null) {
                    this.eMj.eUK = false;
                }
                if (this.eND != null) {
                    boolean bgS = this.eND.bgS();
                    if (bgS) {
                        this.eND.eNd = true;
                        return bgS;
                    }
                    return bgS;
                }
                this.eNC = (short) 5;
            }
            if (this.eND != null) {
                this.eND.eNd = true;
            }
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.eND != null) {
            this.eND.onDestory();
        }
    }

    public void enterBackground() {
        if (this.eND != null) {
            this.eND.bgT();
        }
    }

    public void enterForeground() {
        if (this.eND != null) {
            this.eND.bgU();
        }
    }

    public void bhh() {
        if (this.eND != null) {
            this.eND.bgk();
        }
    }

    public void bhi() {
        if (this.eND != null) {
            this.eND.bgl();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eND != null) {
            this.eND.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eND != null) {
            this.eND.onKeyboardVisibilityChanged(z);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.eND != null) {
            this.eND.E(i, i2, i3);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
