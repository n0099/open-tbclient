package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes7.dex */
public class d {
    private i iRf;
    private boolean kib = true;
    private int jkn = 0;
    private int gAO = 0;
    private boolean jkX = false;
    private Runnable kwf = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iRf.dcT();
        }
    };
    private com.baidu.tieba.f.a jMD = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iRf = new i(tbPageContext, bdTypeListView);
        this.jMD.a(new a.InterfaceC0717a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void G(int i, int i2) {
                d.this.jkX = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void H(int i, int i2) {
                d.this.jkX = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void I(int i, int i2) {
            }
        });
    }

    public void sy(boolean z) {
        this.kib = z;
    }

    public void cQI() {
        this.iRf.cQI();
        this.kib = false;
    }

    public void cTo() {
        if (this.iRf != null && this.kib) {
            this.iRf.a(this.jkn, this.gAO, this.jkX, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.jkn = i;
        this.gAO = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jMD != null) {
            this.jMD.onTouchEvent(motionEvent);
        }
    }

    public void sz(boolean z) {
        this.iRf.tN(!z);
        e.mA().removeCallbacks(this.kwf);
        if (z) {
            this.iRf.dcS();
        } else {
            e.mA().postDelayed(this.kwf, 200L);
        }
    }

    public void destroy() {
        if (this.iRf != null) {
            this.iRf.destroy();
        }
    }
}
