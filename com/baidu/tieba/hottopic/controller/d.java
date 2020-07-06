package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.m;
/* loaded from: classes8.dex */
public class d {
    private m hjm;
    private boolean iqB = true;
    private int hBI = 0;
    private int fmb = 0;
    private boolean hCs = false;
    private Runnable iDB = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.hjm.cyo();
        }
    };
    private com.baidu.tieba.f.a iac = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.hjm = new m(tbPageContext, bdTypeListView);
        this.iac.a(new a.InterfaceC0614a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void D(int i, int i2) {
                d.this.hCs = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void E(int i, int i2) {
                d.this.hCs = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void bO(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void F(int i, int i2) {
            }
        });
    }

    public void oL(boolean z) {
        this.iqB = z;
    }

    public void cjf() {
        this.hjm.cjf();
        this.iqB = false;
    }

    public void cly() {
        if (this.hjm != null && this.iqB) {
            this.hjm.a(this.hBI, this.fmb, this.hCs, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.hBI = i;
        this.fmb = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.iac != null) {
            this.iac.onTouchEvent(motionEvent);
        }
    }

    public void oM(boolean z) {
        this.hjm.qs(!z);
        e.lt().removeCallbacks(this.iDB);
        if (z) {
            this.hjm.cyn();
        } else {
            e.lt().postDelayed(this.iDB, 200L);
        }
    }

    public void destroy() {
        if (this.hjm != null) {
            this.hjm.destroy();
        }
    }
}
