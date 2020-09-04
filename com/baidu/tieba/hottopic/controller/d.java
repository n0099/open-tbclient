package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes15.dex */
public class d {
    private i hBR;
    private boolean iLc = true;
    private int hVc = 0;
    private int fCJ = 0;
    private boolean hVM = false;
    private Runnable iYL = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.hBR.cNf();
        }
    };
    private com.baidu.tieba.f.a iuq = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.hBR = new i(tbPageContext, bdTypeListView);
        this.iuq.a(new a.InterfaceC0674a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void H(int i, int i2) {
                d.this.hVM = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void I(int i, int i2) {
                d.this.hVM = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void bZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void J(int i, int i2) {
            }
        });
    }

    public void pY(boolean z) {
        this.iLc = z;
    }

    public void cxq() {
        this.hBR.cxq();
        this.iLc = false;
    }

    public void czS() {
        if (this.hBR != null && this.iLc) {
            this.hBR.a(this.hVc, this.fCJ, this.hVM, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.hVc = i;
        this.fCJ = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.iuq != null) {
            this.iuq.onTouchEvent(motionEvent);
        }
    }

    public void pZ(boolean z) {
        this.hBR.rH(!z);
        e.mS().removeCallbacks(this.iYL);
        if (z) {
            this.hBR.cNe();
        } else {
            e.mS().postDelayed(this.iYL, 200L);
        }
    }

    public void destroy() {
        if (this.hBR != null) {
            this.hBR.destroy();
        }
    }
}
