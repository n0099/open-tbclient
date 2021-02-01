package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes8.dex */
public class d {
    private i iPi;
    private boolean kfL = true;
    private int jiq = 0;
    private int gyR = 0;
    private boolean jja = false;
    private Runnable ktP = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iPi.dcD();
        }
    };
    private com.baidu.tieba.f.a jKG = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iPi = new i(tbPageContext, bdTypeListView);
        this.jKG.a(new a.InterfaceC0710a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void G(int i, int i2) {
                d.this.jja = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void H(int i, int i2) {
                d.this.jja = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void I(int i, int i2) {
            }
        });
    }

    public void sy(boolean z) {
        this.kfL = z;
    }

    public void cQu() {
        this.iPi.cQu();
        this.kfL = false;
    }

    public void cTa() {
        if (this.iPi != null && this.kfL) {
            this.iPi.a(this.jiq, this.gyR, this.jja, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.jiq = i;
        this.gyR = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jKG != null) {
            this.jKG.onTouchEvent(motionEvent);
        }
    }

    public void sz(boolean z) {
        this.iPi.tN(!z);
        e.mA().removeCallbacks(this.ktP);
        if (z) {
            this.iPi.dcC();
        } else {
            e.mA().postDelayed(this.ktP, 200L);
        }
    }

    public void destroy() {
        if (this.iPi != null) {
            this.iPi.destroy();
        }
    }
}
