package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes16.dex */
public class c {
    private com.baidu.tieba.f.b hXK;
    private BlankView ikK;
    private a ikM;
    private boolean ikN = false;
    private View.OnTouchListener ikO;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int ikL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes16.dex */
    public interface a {
        void cqE();

        void cqF();

        boolean cqG();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hXK = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.ikO = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hXK.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hXK.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hXK.a(new a.InterfaceC0674a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void H(int i, int i2) {
                c.this.cqH();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void I(int i, int i2) {
                if (c.this.ikM != null && c.this.ikM.cqG() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.ikK != null) {
                        c.this.ikK.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void bZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void J(int i, int i2) {
            }
        });
    }

    public void cqH() {
        if (this.ikN && this.mNavigationBar != null && this.ikK != null && this.ikK.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.ikM != null) {
                this.ikM.cqE();
            }
            this.ikK.cqN();
        }
    }

    public void cqI() {
        ViewGroup viewGroup;
        if (!this.ikN && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.ikK = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.ikK.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.ikK, 0, new LinearLayout.LayoutParams(-1, ikL));
            this.ikK.setVisibility(0);
            this.ikK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.ikK.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void buR() {
                    if (c.this.ikK != null) {
                        c.this.ikK.setVisibility(8);
                    }
                    c.this.ikN = false;
                    if (c.this.ikM != null) {
                        c.this.ikM.cqF();
                    }
                }
            });
            this.mActivity.setExcludeHeight(ikL);
            this.ikN = true;
        }
    }

    public void a(a aVar) {
        this.ikM = aVar;
    }

    public boolean cqJ() {
        return this.ikN;
    }

    public void yb(int i) {
        if (this.ikK != null) {
            ap.setBackgroundResource(this.ikK, i);
        }
    }
}
