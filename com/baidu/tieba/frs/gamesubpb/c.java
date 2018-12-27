package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bBi;
    private com.baidu.tieba.f.b cwP;
    private BlankView dZl;
    private a dZn;
    private boolean dZo = false;
    private View.OnTouchListener dZp;
    private NavigationBar mNavigationBar;
    private static final int dZm = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aFM();

        void aFN();

        boolean aFO();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBi = baseActivity;
        this.cwP = new com.baidu.tieba.f.b(this.bBi.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZp = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cwP.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cwP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cwP.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (c.this.dZn != null && c.this.dZn.aFO() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dZl != null) {
                        c.this.dZl.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bBi.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
                c.this.aFP();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void aFP() {
        if (this.dZo && this.mNavigationBar != null && this.dZl != null && this.dZl.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBi.setExcludeHeight(0);
            if (this.dZn != null) {
                this.dZn.aFM();
            }
            this.dZl.aFW();
        }
    }

    public void aFQ() {
        ViewGroup viewGroup;
        if (!this.dZo && (viewGroup = (ViewGroup) this.bBi.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dZl = new BlankView(this.bBi.getPageContext().getPageActivity());
            this.dZl.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dZl, 0, new LinearLayout.LayoutParams(-1, dZm));
            this.dZl.setVisibility(0);
            this.dZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bBi.finish();
                }
            });
            this.dZl.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aFS() {
                    if (c.this.dZl != null) {
                        c.this.dZl.setVisibility(8);
                    }
                    c.this.dZo = false;
                    if (c.this.dZn != null) {
                        c.this.dZn.aFN();
                    }
                }
            });
            this.bBi.setExcludeHeight(dZm);
            this.dZo = true;
        }
    }

    public void a(a aVar) {
        this.dZn = aVar;
    }

    public boolean aFR() {
        return this.dZo;
    }

    public void nb(int i) {
        if (this.dZl != null) {
            al.i(this.dZl, i);
        }
    }
}
