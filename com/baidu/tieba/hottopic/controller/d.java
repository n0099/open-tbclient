package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.g.a;
import com.baidu.tieba.play.i;
/* loaded from: classes21.dex */
public class d {
    private i iBV;
    private boolean jPA = true;
    private int iVe = 0;
    private int gpP = 0;
    private boolean iVO = false;
    private Runnable kdb = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iBV.deL();
        }
    };
    private com.baidu.tieba.g.a jxl = new com.baidu.tieba.g.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iBV = new i(tbPageContext, bdTypeListView);
        this.jxl.a(new a.InterfaceC0756a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void G(int i, int i2) {
                d.this.iVO = false;
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void H(int i, int i2) {
                d.this.iVO = true;
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
        this.jPA = z;
    }

    public void cPi() {
        this.iBV.cPi();
        this.jPA = false;
    }

    public void cRM() {
        if (this.iBV != null && this.jPA) {
            this.iBV.a(this.iVe, this.gpP, this.iVO, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.iVe = i;
        this.gpP = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jxl != null) {
            this.jxl.onTouchEvent(motionEvent);
        }
    }

    public void rT(boolean z) {
        this.iBV.tC(!z);
        e.mY().removeCallbacks(this.kdb);
        if (z) {
            this.iBV.deK();
        } else {
            e.mY().postDelayed(this.kdb, 200L);
        }
    }

    public void destroy() {
        if (this.iBV != null) {
            this.iBV.destroy();
        }
    }
}
