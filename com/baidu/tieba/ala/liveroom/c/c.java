package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.g;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.data.j;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a eNz;
    private short eOW = 0;
    private b eOX;
    private e eOY;
    private j eOk;
    private boolean eOp;
    private String otherParams;

    public void c(short s) {
        if (1 == s) {
            if (this.eOX != null && !(this.eOX instanceof a)) {
                this.eOX.iK(true);
                this.eOX = null;
            }
            if (this.eOX == null) {
                this.eOX = new a();
                this.eOW = (short) 0;
                this.eOX.a(this.eNz);
                this.eOX.a(this.eOY);
                this.eNz.eWw = false;
                this.eOX.setOtherParams(this.otherParams);
                this.eOX.init();
            }
        } else if (2 == s) {
            if (this.eOX != null && !(this.eOX instanceof d)) {
                this.eOX.iK(true);
                this.eOX = null;
            }
            if (this.eOX == null) {
                this.eOX = new d();
                this.eOW = (short) 0;
                this.eOX.a(this.eNz);
                this.eOX.a(this.eOY);
                this.eNz.eWw = false;
                this.eOX.setOtherParams(this.otherParams);
                this.eOX.init();
            }
        }
        this.eOX.bgR();
        this.eOX.iO(this.eOp);
        this.eOX.a(this.eOk);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.o.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, j jVar) {
        if (this.eNz == null) {
            this.eNz = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eNz.pageContext = tbPageContext;
        this.eNz.eWs = alaLiveView;
        this.eNz.eWq = view;
        this.eNz.eWt = viewGroup;
        this.eNz.eWr = cVar;
        this.eNz.fromType = str;
        this.eNz.enterTime = j;
        this.eNz.eWu = z;
        this.eNz.eWx = arrayList;
        this.eNz.eWy = false;
        this.eOk = jVar;
    }

    public void iO(boolean z) {
        this.eOp = z;
        if (this.eOX != null) {
            this.eOX.iO(z);
        }
    }

    public void a(e eVar) {
        this.eOY = eVar;
        if (this.eOX != null) {
            this.eOX.a(this.eOY);
        }
    }

    public void b(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eNz != null) {
            this.eNz.eWt = alaLiveRoomBlurPageLayout;
        }
    }

    public void iS(boolean z) {
        if (this.eOW != 1) {
            if (this.eNz != null) {
                this.eNz.eWw = false;
            }
            if (this.eOX != null) {
                this.eOX.xc();
                if ((this.eOX instanceof d) && z) {
                    ((d) this.eOX).iU(true);
                }
            }
            this.eOW = (short) 1;
        }
    }

    public void bd(int i) {
        this.eNz.eWy = true;
        if (this.eOX != null) {
            this.eOX.bd(i);
        }
    }

    public void bhK() {
        if (this.eNz != null) {
            this.eNz.eWv = true;
        }
    }

    public void a(l lVar) {
        if (this.eOX != null) {
            this.eOX.b(lVar);
        }
    }

    public void d(g gVar) {
        if (this.eOX != null) {
            this.eOX.c(gVar);
        }
    }

    public void iT(boolean z) {
        if (this.eOW != 3) {
            if (this.eNz != null) {
                this.eNz.eWw = false;
            }
            if (this.eOX != null) {
                this.eOX.iJ(z);
            }
            this.eOW = (short) 3;
        }
    }

    public void bhL() {
        if (this.eOW != 4) {
            if (this.eNz != null) {
                this.eNz.eWw = true;
            }
            if (this.eOX != null) {
                this.eOX.bgD();
            }
            this.eOk = null;
            this.eOW = (short) 4;
        }
    }

    public boolean bhM() {
        return this.eOX != null && this.eOX.bgG();
    }

    public boolean bhN() {
        if (this.eOX == null || !this.eOX.eOx) {
            if (this.eOW != 5) {
                if (this.eNz != null) {
                    this.eNz.eWw = false;
                }
                if (this.eOX != null) {
                    boolean bhz = this.eOX.bhz();
                    if (bhz) {
                        this.eOX.eOw = true;
                        return bhz;
                    }
                    return bhz;
                }
                this.eOW = (short) 5;
            }
            if (this.eOX != null) {
                this.eOX.eOw = true;
            }
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.eOX != null) {
            this.eOX.iK(false);
        }
    }

    public void enterBackground() {
        if (this.eOX != null) {
            this.eOX.bhA();
        }
    }

    public void enterForeground() {
        if (this.eOX != null) {
            this.eOX.bhB();
        }
    }

    public void bhO() {
        if (this.eOX != null) {
            this.eOX.bgM();
        }
    }

    public void bhP() {
        if (this.eOX != null) {
            this.eOX.bgN();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eOX != null) {
            this.eOX.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eOX != null) {
            this.eOX.onKeyboardVisibilityChanged(z);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.eOX != null) {
            this.eOX.E(i, i2, i3);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
