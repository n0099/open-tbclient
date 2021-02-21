package com.baidu.tieba.hottopic.controller;

import android.view.MotionEvent;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f.a;
import com.baidu.tieba.play.i;
/* loaded from: classes8.dex */
public class d {
    private i iPw;
    private boolean kfZ = true;
    private int jiE = 0;
    private int gzf = 0;
    private boolean jjo = false;
    private Runnable kud = new Runnable() { // from class: com.baidu.tieba.hottopic.controller.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.iPw.dcK();
        }
    };
    private com.baidu.tieba.f.a jKU = new com.baidu.tieba.f.a();

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.iPw = new i(tbPageContext, bdTypeListView);
        this.jKU.a(new a.InterfaceC0711a() { // from class: com.baidu.tieba.hottopic.controller.d.2
            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void G(int i, int i2) {
                d.this.jjo = false;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void H(int i, int i2) {
                d.this.jjo = true;
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void I(int i, int i2) {
            }
        });
    }

    public void sy(boolean z) {
        this.kfZ = z;
    }

    public void cQB() {
        this.iPw.cQB();
        this.kfZ = false;
    }

    public void cTh() {
        if (this.iPw != null && this.kfZ) {
            this.iPw.a(this.jiE, this.gzf, this.jjo, 1);
        }
    }

    public void onScroll(int i, int i2) {
        this.jiE = i;
        this.gzf = (i + i2) - 1;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.jKU != null) {
            this.jKU.onTouchEvent(motionEvent);
        }
    }

    public void sz(boolean z) {
        this.iPw.tN(!z);
        e.mA().removeCallbacks(this.kud);
        if (z) {
            this.iPw.dcJ();
        } else {
            e.mA().postDelayed(this.kud, 200L);
        }
    }

    public void destroy() {
        if (this.iPw != null) {
            this.iPw.destroy();
        }
    }
}
