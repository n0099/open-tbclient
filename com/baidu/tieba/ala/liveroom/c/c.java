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
    private i dXX;
    private com.baidu.tieba.ala.liveroom.data.a dXt;
    private e dYA;
    private short dYy = 0;
    private b dYz;
    private String otherParams;

    public void c(short s) {
        if (1 == s) {
            if (this.dYz != null && !(this.dYz instanceof a)) {
                this.dYz.onDestory();
                this.dYz = null;
            }
            if (this.dYz == null) {
                this.dYz = new a();
                this.dYy = (short) 0;
                this.dYz.a(this.dXt);
                this.dYz.a(this.dYA);
                this.dXt.efH = false;
                this.dYz.setOtherParams(this.otherParams);
                this.dYz.init();
            }
        } else if (2 == s) {
            if (this.dYz != null && !(this.dYz instanceof d)) {
                this.dYz.onDestory();
                this.dYz = null;
            }
            if (this.dYz == null) {
                this.dYz = new d();
                this.dYy = (short) 0;
                this.dYz.a(this.dXt);
                this.dYz.a(this.dYA);
                this.dXt.efH = false;
                this.dYz.setOtherParams(this.otherParams);
                this.dYz.init();
            }
        }
        this.dYz.aOR();
        this.dYz.a(this.dXX);
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, i iVar) {
        if (this.dXt == null) {
            this.dXt = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.dXt.pageContext = tbPageContext;
        this.dXt.efD = alaLiveView;
        this.dXt.efB = view;
        this.dXt.efE = viewGroup;
        this.dXt.efC = cVar;
        this.dXt.fromType = str;
        this.dXt.enterTime = j;
        this.dXt.efF = z;
        this.dXt.efI = arrayList;
        this.dXt.efJ = false;
        this.dXX = iVar;
    }

    public void a(e eVar) {
        this.dYA = eVar;
        if (this.dYz != null) {
            this.dYz.a(this.dYA);
        }
    }

    public void b(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.dXt != null) {
            this.dXt.efE = alaLiveRoomBlurPageLayout;
        }
    }

    public void hx(boolean z) {
        if (this.dYy != 1) {
            if (this.dXt != null) {
                this.dXt.efH = false;
            }
            if (this.dYz != null) {
                this.dYz.uM();
                if ((this.dYz instanceof d) && z) {
                    ((d) this.dYz).hz(true);
                }
            }
            this.dYy = (short) 1;
        }
    }

    public void aS(int i) {
        this.dXt.efJ = true;
        if (this.dYz != null) {
            this.dYz.aS(i);
        }
    }

    public void aPD() {
        if (this.dXt != null) {
            this.dXt.efG = true;
        }
    }

    public void b(com.baidu.live.data.i iVar) {
        if (this.dYz != null) {
            this.dYz.a(iVar);
        }
    }

    public void c(com.baidu.live.data.e eVar) {
        if (this.dYz != null) {
            this.dYz.b(eVar);
        }
    }

    public void hy(boolean z) {
        if (this.dYy != 3) {
            if (this.dXt != null) {
                this.dXt.efH = false;
            }
            if (this.dYz != null) {
                this.dYz.hp(z);
            }
            this.dYy = (short) 3;
        }
    }

    public void aPE() {
        if (this.dYy != 4) {
            if (this.dXt != null) {
                this.dXt.efH = true;
            }
            if (this.dYz != null) {
                this.dYz.aOH();
            }
            this.dXX = null;
            this.dYy = (short) 4;
        }
    }

    public boolean aPF() {
        return this.dYz != null && this.dYz.aOK();
    }

    public boolean aPG() {
        if (this.dYz == null || !this.dYz.dYi) {
            if (this.dYy != 5) {
                if (this.dXt != null) {
                    this.dXt.efH = false;
                }
                if (this.dYz != null) {
                    boolean aPr = this.dYz.aPr();
                    if (aPr) {
                        this.dYz.dYh = true;
                        return aPr;
                    }
                    return aPr;
                }
                this.dYy = (short) 5;
            }
            if (this.dYz != null) {
                this.dYz.dYh = true;
            }
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.dYz != null) {
            this.dYz.onDestory();
        }
    }

    public void enterBackground() {
        if (this.dYz != null) {
            this.dYz.aPs();
        }
    }

    public void enterForeground() {
        if (this.dYz != null) {
            this.dYz.aPt();
        }
    }

    public void aPH() {
        if (this.dYz != null) {
            this.dYz.aOO();
        }
    }

    public void aPI() {
        if (this.dYz != null) {
            this.dYz.aOP();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.dYz != null) {
            this.dYz.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.dYz != null) {
            this.dYz.onKeyboardVisibilityChanged(z);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.dYz != null) {
            this.dYz.E(i, i2, i3);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
