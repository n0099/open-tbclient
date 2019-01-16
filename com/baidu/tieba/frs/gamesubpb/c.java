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
    private BaseActivity bBV;
    private com.baidu.tieba.f.b cxA;
    private BlankView dZR;
    private a dZT;
    private boolean dZU = false;
    private View.OnTouchListener dZV;
    private NavigationBar mNavigationBar;
    private static final int dZS = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aGj();

        void aGk();

        boolean aGl();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBV = baseActivity;
        this.cxA = new com.baidu.tieba.f.b(this.bBV.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZV = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cxA.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cxA.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cxA.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (c.this.dZT != null && c.this.dZT.aGl() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dZR != null) {
                        c.this.dZR.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bBV.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
                c.this.aGm();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void aGm() {
        if (this.dZU && this.mNavigationBar != null && this.dZR != null && this.dZR.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBV.setExcludeHeight(0);
            if (this.dZT != null) {
                this.dZT.aGj();
            }
            this.dZR.aGt();
        }
    }

    public void aGn() {
        ViewGroup viewGroup;
        if (!this.dZU && (viewGroup = (ViewGroup) this.bBV.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dZR = new BlankView(this.bBV.getPageContext().getPageActivity());
            this.dZR.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dZR, 0, new LinearLayout.LayoutParams(-1, dZS));
            this.dZR.setVisibility(0);
            this.dZR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bBV.finish();
                }
            });
            this.dZR.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aGp() {
                    if (c.this.dZR != null) {
                        c.this.dZR.setVisibility(8);
                    }
                    c.this.dZU = false;
                    if (c.this.dZT != null) {
                        c.this.dZT.aGk();
                    }
                }
            });
            this.bBV.setExcludeHeight(dZS);
            this.dZU = true;
        }
    }

    public void a(a aVar) {
        this.dZT = aVar;
    }

    public boolean aGo() {
        return this.dZU;
    }

    public void nc(int i) {
        if (this.dZR != null) {
            al.i(this.dZR, i);
        }
    }
}
