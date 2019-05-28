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
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes4.dex */
public class c {
    private BaseActivity cVp;
    private com.baidu.tieba.f.b dWj;
    private BlankView fDC;
    private a fDE;
    private boolean fDF = false;
    private View.OnTouchListener fDG;
    private NavigationBar mNavigationBar;
    private static final int fDD = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bnT();

        void bnU();

        boolean bnV();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cVp = baseActivity;
        this.dWj = new com.baidu.tieba.f.b(this.cVp.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fDG = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dWj.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dWj.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dWj.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aT(int i, int i2) {
                if (c.this.fDE != null && c.this.fDE.bnV() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fDC != null) {
                        c.this.fDC.setBackgroundResource(R.color.transparent);
                    }
                    c.this.cVp.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aU(int i, int i2) {
                c.this.bnW();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aV(int i, int i2) {
            }
        });
    }

    public void bnW() {
        if (this.fDF && this.mNavigationBar != null && this.fDC != null && this.fDC.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cVp.setExcludeHeight(0);
            if (this.fDE != null) {
                this.fDE.bnT();
            }
            this.fDC.bod();
        }
    }

    public void bnX() {
        ViewGroup viewGroup;
        if (!this.fDF && (viewGroup = (ViewGroup) this.cVp.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fDC = new BlankView(this.cVp.getPageContext().getPageActivity());
            this.fDC.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fDC, 0, new LinearLayout.LayoutParams(-1, fDD));
            this.fDC.setVisibility(0);
            this.fDC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cVp.finish();
                }
            });
            this.fDC.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bnZ() {
                    if (c.this.fDC != null) {
                        c.this.fDC.setVisibility(8);
                    }
                    c.this.fDF = false;
                    if (c.this.fDE != null) {
                        c.this.fDE.bnU();
                    }
                }
            });
            this.cVp.setExcludeHeight(fDD);
            this.fDF = true;
        }
    }

    public void a(a aVar) {
        this.fDE = aVar;
    }

    public boolean bnY() {
        return this.fDF;
    }

    public void rT(int i) {
        if (this.fDC != null) {
            al.k(this.fDC, i);
        }
    }
}
