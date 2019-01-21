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
    private BaseActivity bBW;
    private com.baidu.tieba.f.b cxB;
    private BlankView dZS;
    private a dZU;
    private boolean dZV = false;
    private View.OnTouchListener dZW;
    private NavigationBar mNavigationBar;
    private static final int dZT = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aGj();

        void aGk();

        boolean aGl();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBW = baseActivity;
        this.cxB = new com.baidu.tieba.f.b(this.bBW.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZW = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cxB.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cxB.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cxB.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (c.this.dZU != null && c.this.dZU.aGl() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dZS != null) {
                        c.this.dZS.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bBW.finish();
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
        if (this.dZV && this.mNavigationBar != null && this.dZS != null && this.dZS.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBW.setExcludeHeight(0);
            if (this.dZU != null) {
                this.dZU.aGj();
            }
            this.dZS.aGt();
        }
    }

    public void aGn() {
        ViewGroup viewGroup;
        if (!this.dZV && (viewGroup = (ViewGroup) this.bBW.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dZS = new BlankView(this.bBW.getPageContext().getPageActivity());
            this.dZS.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dZS, 0, new LinearLayout.LayoutParams(-1, dZT));
            this.dZS.setVisibility(0);
            this.dZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bBW.finish();
                }
            });
            this.dZS.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aGp() {
                    if (c.this.dZS != null) {
                        c.this.dZS.setVisibility(8);
                    }
                    c.this.dZV = false;
                    if (c.this.dZU != null) {
                        c.this.dZU.aGk();
                    }
                }
            });
            this.bBW.setExcludeHeight(dZT);
            this.dZV = true;
        }
    }

    public void a(a aVar) {
        this.dZU = aVar;
    }

    public boolean aGo() {
        return this.dZV;
    }

    public void nc(int i) {
        if (this.dZS != null) {
            al.i(this.dZS, i);
        }
    }
}
