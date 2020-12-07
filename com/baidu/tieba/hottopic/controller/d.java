package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.g.a;
import com.baidu.tieba.play.i;
/* loaded from: classes21.dex */
public class d {
    private i iBT;
    private boolean jPy = true;
    private int iVc = 0;
    private int gpN = 0;
    private boolean iVM = false;
    private Runnable kcZ = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iBT.deK();
        }
    };
    private com.baidu.tieba.g.a jxj = new com.baidu.tieba.g.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iBT = new i(tbPageContext, bdTypeListView);
        this.jxj.a(new a.InterfaceC0756a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void G(int i, int i2) {
                d.this.iVM = false;
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void H(int i, int i2) {
                d.this.iVM = true;
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void ck(int i, int i2) {
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void I(int i, int i2) {
            }
        });
    }

    public void rS(boolean z) {
        this.jPy = z;
    }

    public void cPh() {
        this.iBT.cPh();
        this.jPy = false;
    }

    public void cRL() {
        if (this.iBT != null && this.jPy) {
            this.iBT.a(this.iVc, this.gpN, this.iVM, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.iVc = i;
        this.gpN = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jxj != null) {
            this.jxj.onTouchEvent(motionEvent);
        }
    }

    public void rT(boolean z) {
        this.iBT.tC(!z);
        e.mY().removeCallbacks(this.kcZ);
        if (z) {
            this.iBT.deJ();
        } else {
            e.mY().postDelayed(this.kcZ, 200L);
        }
    }

    public void destroy() {
        if (this.iBT != null) {
            this.iBT.destroy();
        }
    }
}
