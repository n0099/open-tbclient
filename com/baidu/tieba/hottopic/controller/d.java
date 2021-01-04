package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes8.dex */
public class d {
    private i iOh;
    private boolean kcO = true;
    private int jhq = 0;
    private int gAO = 0;
    private boolean jia = false;
    private Runnable kqn = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iOh.dew();
        }
    };
    private com.baidu.tieba.f.a jJI = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iOh = new i(tbPageContext, bdTypeListView);
        this.jJI.a(new a.InterfaceC0727a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void G(int i, int i2) {
                d.this.jia = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void H(int i, int i2) {
                d.this.jia = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void cj(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void I(int i, int i2) {
            }
        });
    }

    public void sp(boolean z) {
        this.kcO = z;
    }

    public void cSo() {
        this.iOh.cSo();
        this.kcO = false;
    }

    public void cUS() {
        if (this.iOh != null && this.kcO) {
            this.iOh.a(this.jhq, this.gAO, this.jia, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.jhq = i;
        this.gAO = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jJI != null) {
            this.jJI.onTouchEvent(motionEvent);
        }
    }

    public void sq(boolean z) {
        this.iOh.tE(!z);
        e.mB().removeCallbacks(this.kqn);
        if (z) {
            this.iOh.dev();
        } else {
            e.mB().postDelayed(this.kqn, 200L);
        }
    }

    public void destroy() {
        if (this.iOh != null) {
            this.iOh.destroy();
        }
    }
}
