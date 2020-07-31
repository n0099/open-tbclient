package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes15.dex */
public class d {
    private i hoU;
    private boolean iwF = true;
    private int hHG = 0;
    private int frk = 0;
    private boolean hIq = false;
    private Runnable iJF = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.hoU.cCm();
        }
    };
    private com.baidu.tieba.f.a ige = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.hoU = new i(tbPageContext, bdTypeListView);
        this.ige.a(new a.InterfaceC0623a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void D(int i, int i2) {
                d.this.hIq = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void E(int i, int i2) {
                d.this.hIq = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void bR(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void F(int i, int i2) {
            }
        });
    }

    public void pq(boolean z) {
        this.iwF = z;
    }

    public void cmG() {
        this.hoU.cmG();
        this.iwF = false;
    }

    public void coY() {
        if (this.hoU != null && this.iwF) {
            this.hoU.a(this.hHG, this.frk, this.hIq, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.hHG = i;
        this.frk = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.ige != null) {
            this.ige.onTouchEvent(motionEvent);
        }
    }

    public void pr(boolean z) {
        this.hoU.qZ(!z);
        e.lt().removeCallbacks(this.iJF);
        if (z) {
            this.hoU.cCl();
        } else {
            e.lt().postDelayed(this.iJF, 200L);
        }
    }

    public void destroy() {
        if (this.hoU != null) {
            this.hoU.destroy();
        }
    }
}
