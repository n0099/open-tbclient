package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes21.dex */
public class d {
    private i iqn;
    private boolean jBa = true;
    private int iJw = 0;
    private int ghW = 0;
    private boolean iKg = false;
    private Runnable jOM = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iqn.dac();
        }
    };
    private com.baidu.tieba.f.a jiW = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iqn = new i(tbPageContext, bdTypeListView);
        this.jiW.a(new a.InterfaceC0719a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void H(int i, int i2) {
                d.this.iKg = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void I(int i, int i2) {
                d.this.iKg = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void J(int i, int i2) {
            }
        });
    }

    public void rn(boolean z) {
        this.jBa = z;
    }

    public void cKn() {
        this.iqn.cKn();
        this.jBa = false;
    }

    public void cMQ() {
        if (this.iqn != null && this.jBa) {
            this.iqn.a(this.iJw, this.ghW, this.iKg, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.iJw = i;
        this.ghW = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jiW != null) {
            this.jiW.onTouchEvent(motionEvent);
        }
    }

    public void ro(boolean z) {
        this.iqn.sX(!z);
        e.mY().removeCallbacks(this.jOM);
        if (z) {
            this.iqn.dab();
        } else {
            e.mY().postDelayed(this.jOM, 200L);
        }
    }

    public void destroy() {
        if (this.iqn != null) {
            this.iqn.destroy();
        }
    }
}
