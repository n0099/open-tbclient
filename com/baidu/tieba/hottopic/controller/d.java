package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes20.dex */
public class d {
    private i hIT;
    private boolean iTI = true;
    private int icc = 0;
    private int fFV = 0;
    private boolean icM = false;
    private Runnable jhq = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.hIT.cQK();
        }
    };
    private com.baidu.tieba.f.a iBM = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.hIT = new i(tbPageContext, bdTypeListView);
        this.iBM.a(new a.InterfaceC0671a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void H(int i, int i2) {
                d.this.icM = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void I(int i, int i2) {
                d.this.icM = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void cc(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void J(int i, int i2) {
            }
        });
    }

    public void qg(boolean z) {
        this.iTI = z;
    }

    public void cAY() {
        this.hIT.cAY();
        this.iTI = false;
    }

    public void cDz() {
        if (this.hIT != null && this.iTI) {
            this.hIT.a(this.icc, this.fFV, this.icM, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.icc = i;
        this.fFV = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.iBM != null) {
            this.iBM.onTouchEvent(motionEvent);
        }
    }

    public void qh(boolean z) {
        this.hIT.rP(!z);
        e.mX().removeCallbacks(this.jhq);
        if (z) {
            this.hIT.cQJ();
        } else {
            e.mX().postDelayed(this.jhq, 200L);
        }
    }

    public void destroy() {
        if (this.hIT != null) {
            this.hIT.destroy();
        }
    }
}
