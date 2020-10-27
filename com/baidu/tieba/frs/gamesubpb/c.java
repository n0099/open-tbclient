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
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tieba.f.b iGn;
    private BlankView iTh;
    private a iTj;
    private boolean iTk = false;
    private View.OnTouchListener iTl;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int iTi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes22.dex */
    public interface a {
        void cAw();

        void cAx();

        boolean cAy();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.iGn = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.iTl = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iGn.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iGn.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.iGn.a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void H(int i, int i2) {
                c.this.cAz();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void I(int i, int i2) {
                if (c.this.iTj != null && c.this.iTj.cAy() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.iTh != null) {
                        c.this.iTh.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void ce(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0705a
            public void J(int i, int i2) {
            }
        });
    }

    public void cAz() {
        if (this.iTk && this.mNavigationBar != null && this.iTh != null && this.iTh.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iTj != null) {
                this.iTj.cAw();
            }
            this.iTh.cAF();
        }
    }

    public void cAA() {
        ViewGroup viewGroup;
        if (!this.iTk && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iTh = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iTh.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iTh, 0, new LinearLayout.LayoutParams(-1, iTi));
            this.iTh.setVisibility(0);
            this.iTh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.iTh.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bAz() {
                    if (c.this.iTh != null) {
                        c.this.iTh.setVisibility(8);
                    }
                    c.this.iTk = false;
                    if (c.this.iTj != null) {
                        c.this.iTj.cAx();
                    }
                }
            });
            this.mActivity.setExcludeHeight(iTi);
            this.iTk = true;
        }
    }

    public void a(a aVar) {
        this.iTj = aVar;
    }

    public boolean cAB() {
        return this.iTk;
    }

    public void zz(int i) {
        if (this.iTh != null) {
            ap.setBackgroundResource(this.iTh, i);
        }
    }
}
