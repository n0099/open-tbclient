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
    private com.baidu.tieba.f.b iMk;
    private BlankView iZe;
    private a iZg;
    private boolean iZh = false;
    private View.OnTouchListener iZi;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int iZf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes22.dex */
    public interface a {
        void cCX();

        void cCY();

        boolean cCZ();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.iMk = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.iZi = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iMk.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iMk.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.iMk.a(new a.InterfaceC0719a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void H(int i, int i2) {
                c.this.cDa();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void I(int i, int i2) {
                if (c.this.iZg != null && c.this.iZg.cCZ() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.iZe != null) {
                        c.this.iZe.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0719a
            public void J(int i, int i2) {
            }
        });
    }

    public void cDa() {
        if (this.iZh && this.mNavigationBar != null && this.iZe != null && this.iZe.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iZg != null) {
                this.iZg.cCX();
            }
            this.iZe.cDg();
        }
    }

    public void cDb() {
        ViewGroup viewGroup;
        if (!this.iZh && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iZe = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iZe.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iZe, 0, new LinearLayout.LayoutParams(-1, iZf));
            this.iZe.setVisibility(0);
            this.iZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.iZe.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bCY() {
                    if (c.this.iZe != null) {
                        c.this.iZe.setVisibility(8);
                    }
                    c.this.iZh = false;
                    if (c.this.iZg != null) {
                        c.this.iZg.cCY();
                    }
                }
            });
            this.mActivity.setExcludeHeight(iZf);
            this.iZh = true;
        }
    }

    public void a(a aVar) {
        this.iZg = aVar;
    }

    public boolean cDc() {
        return this.iZh;
    }

    public void zM(int i) {
        if (this.iZe != null) {
            ap.setBackgroundResource(this.iZe, i);
        }
    }
}
