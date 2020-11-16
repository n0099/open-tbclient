package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.g.a;
import com.baidu.tieba.play.i;
/* loaded from: classes20.dex */
public class d {
    private i irb;
    private boolean jBW = true;
    private int iKj = 0;
    private int ghD = 0;
    private boolean iKT = false;
    private Runnable jPw = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.irb.cZz();
        }
    };
    private com.baidu.tieba.g.a jjH = new com.baidu.tieba.g.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.irb = new i(tbPageContext, bdTypeListView);
        this.jjH.a(new a.InterfaceC0740a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void H(int i, int i2) {
                d.this.iKT = false;
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void I(int i, int i2) {
                d.this.iKT = true;
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void J(int i, int i2) {
            }
        });
    }

    public void rq(boolean z) {
        this.jBW = z;
    }

    public void cJS() {
        this.irb.cJS();
        this.jBW = false;
    }

    public void cMx() {
        if (this.irb != null && this.jBW) {
            this.irb.a(this.iKj, this.ghD, this.iKT, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.iKj = i;
        this.ghD = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jjH != null) {
            this.jjH.onTouchEvent(motionEvent);
        }
    }

    public void rr(boolean z) {
        this.irb.ta(!z);
        e.mY().removeCallbacks(this.jPw);
        if (z) {
            this.irb.cZy();
        } else {
            e.mY().postDelayed(this.jPw, 200L);
        }
    }

    public void destroy() {
        if (this.irb != null) {
            this.irb.destroy();
        }
    }
}
