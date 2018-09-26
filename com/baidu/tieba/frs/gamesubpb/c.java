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
    private com.baidu.tieba.f.b bPP;
    private BaseActivity bsQ;
    private BlankView dGQ;
    private a dGS;
    private boolean dGT = false;
    private View.OnTouchListener dGU;
    private NavigationBar mNavigationBar;
    private static final int dGR = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aAx();

        void aAy();

        boolean aAz();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bsQ = baseActivity;
        this.bPP = new com.baidu.tieba.f.b(this.bsQ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dGU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bPP.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bPP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bPP.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ac(int i, int i2) {
                if (c.this.dGS != null && c.this.dGS.aAz() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dGQ != null) {
                        c.this.dGQ.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bsQ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ad(int i, int i2) {
                c.this.aAA();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ae(int i, int i2) {
            }
        });
    }

    public void aAA() {
        if (this.dGT && this.mNavigationBar != null && this.dGQ != null && this.dGQ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bsQ.setExcludeHeight(0);
            if (this.dGS != null) {
                this.dGS.aAx();
            }
            this.dGQ.aAH();
        }
    }

    public void aAB() {
        ViewGroup viewGroup;
        if (!this.dGT && (viewGroup = (ViewGroup) this.bsQ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dGQ = new BlankView(this.bsQ.getPageContext().getPageActivity());
            this.dGQ.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dGQ, 0, new LinearLayout.LayoutParams(-1, dGR));
            this.dGQ.setVisibility(0);
            this.dGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bsQ.finish();
                }
            });
            this.dGQ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aAD() {
                    if (c.this.dGQ != null) {
                        c.this.dGQ.setVisibility(8);
                    }
                    c.this.dGT = false;
                    if (c.this.dGS != null) {
                        c.this.dGS.aAy();
                    }
                }
            });
            this.bsQ.setExcludeHeight(dGR);
            this.dGT = true;
        }
    }

    public void a(a aVar) {
        this.dGS = aVar;
    }

    public boolean aAC() {
        return this.dGT;
    }

    public void lJ(int i) {
        if (this.dGQ != null) {
            al.i(this.dGQ, i);
        }
    }
}
