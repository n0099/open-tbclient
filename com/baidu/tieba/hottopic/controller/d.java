package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes21.dex */
public class d {
    private i iko;
    private boolean jvd = true;
    private int iDz = 0;
    private int gch = 0;
    private boolean iEj = false;
    private Runnable jIO = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iko.cXB();
        }
    };
    private com.baidu.tieba.f.a jcY = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iko = new i(tbPageContext, bdTypeListView);
        this.jcY.a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void H(int i, int i2) {
                d.this.iEj = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void I(int i, int i2) {
                d.this.iEj = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void ce(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void J(int i, int i2) {
            }
        });
    }

    public void re(boolean z) {
        this.jvd = z;
    }

    public void cHM() {
        this.iko.cHM();
        this.jvd = false;
    }

    public void cKp() {
        if (this.iko != null && this.jvd) {
            this.iko.a(this.iDz, this.gch, this.iEj, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.iDz = i;
        this.gch = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jcY != null) {
            this.jcY.onTouchEvent(motionEvent);
        }
    }

    public void rf(boolean z) {
        this.iko.sO(!z);
        e.mY().removeCallbacks(this.jIO);
        if (z) {
            this.iko.cXA();
        } else {
            e.mY().postDelayed(this.jIO, 200L);
        }
    }

    public void destroy() {
        if (this.iko != null) {
            this.iko.destroy();
        }
    }
}
