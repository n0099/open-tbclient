package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes7.dex */
public class d {
    private i iJA;
    private boolean jYj = true;
    private int jcJ = 0;
    private int gwh = 0;
    private boolean jdt = false;
    private Runnable klI = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iJA.daF();
        }
    };
    private com.baidu.tieba.f.a jFc = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iJA = new i(tbPageContext, bdTypeListView);
        this.jFc.a(new a.InterfaceC0710a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void G(int i, int i2) {
                d.this.jdt = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void H(int i, int i2) {
                d.this.jdt = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void cj(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void I(int i, int i2) {
            }
        });
    }

    public void sl(boolean z) {
        this.jYj = z;
    }

    public void cOx() {
        this.iJA.cOx();
        this.jYj = false;
    }

    public void cRb() {
        if (this.iJA != null && this.jYj) {
            this.iJA.a(this.jcJ, this.gwh, this.jdt, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.jcJ = i;
        this.gwh = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jFc != null) {
            this.jFc.onTouchEvent(motionEvent);
        }
    }

    public void sm(boolean z) {
        this.iJA.tA(!z);
        e.mB().removeCallbacks(this.klI);
        if (z) {
            this.iJA.daE();
        } else {
            e.mB().postDelayed(this.klI, 200L);
        }
    }

    public void destroy() {
        if (this.iJA != null) {
            this.iJA.destroy();
        }
    }
}
