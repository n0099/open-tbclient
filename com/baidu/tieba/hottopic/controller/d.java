package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes21.dex */
public class d {
    private i hXO;
    private boolean jiG = true;
    private int ird = 0;
    private int fSe = 0;
    private boolean irN = false;
    private Runnable jwp = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.hXO.cUu();
        }
    };
    private com.baidu.tieba.f.a iQC = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.hXO = new i(tbPageContext, bdTypeListView);
        this.iQC.a(new a.InterfaceC0689a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void H(int i, int i2) {
                d.this.irN = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void I(int i, int i2) {
                d.this.irN = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void cc(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void J(int i, int i2) {
            }
        });
    }

    public void qM(boolean z) {
        this.jiG = z;
    }

    public void cEF() {
        this.hXO.cEF();
        this.jiG = false;
    }

    public void cHi() {
        if (this.hXO != null && this.jiG) {
            this.hXO.a(this.ird, this.fSe, this.irN, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.ird = i;
        this.fSe = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.iQC != null) {
            this.iQC.onTouchEvent(motionEvent);
        }
    }

    public void qN(boolean z) {
        this.hXO.sw(!z);
        e.mY().removeCallbacks(this.jwp);
        if (z) {
            this.hXO.cUt();
        } else {
            e.mY().postDelayed(this.jwp, 200L);
        }
    }

    public void destroy() {
        if (this.hXO != null) {
            this.hXO.destroy();
        }
    }
}
