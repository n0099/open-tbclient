package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes6.dex */
public class c {
    private com.baidu.tieba.f.b gnc;
    private BlankView gxV;
    private a gxX;
    private boolean gxY = false;
    private View.OnTouchListener gxZ;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gxW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes6.dex */
    public interface a {
        void bFs();

        void bFt();

        boolean bFu();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gnc = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gxZ = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gnc.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gnc.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gnc.a(new a.InterfaceC0488a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0488a
            public void u(int i, int i2) {
                c.this.bFv();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0488a
            public void v(int i, int i2) {
                if (c.this.gxX != null && c.this.gxX.bFu() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gxV != null) {
                        c.this.gxV.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0488a
            public void bA(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0488a
            public void w(int i, int i2) {
            }
        });
    }

    public void bFv() {
        if (this.gxY && this.mNavigationBar != null && this.gxV != null && this.gxV.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gxX != null) {
                this.gxX.bFs();
            }
            this.gxV.bFC();
        }
    }

    public void bFw() {
        ViewGroup viewGroup;
        if (!this.gxY && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gxV = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gxV.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gxV, 0, new LinearLayout.LayoutParams(-1, gxW));
            this.gxV.setVisibility(0);
            this.gxV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gxV.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bFy() {
                    if (c.this.gxV != null) {
                        c.this.gxV.setVisibility(8);
                    }
                    c.this.gxY = false;
                    if (c.this.gxX != null) {
                        c.this.gxX.bFt();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gxW);
            this.gxY = true;
        }
    }

    public void a(a aVar) {
        this.gxX = aVar;
    }

    public boolean bFx() {
        return this.gxY;
    }

    public void tp(int i) {
        if (this.gxV != null) {
            am.setBackgroundResource(this.gxV, i);
        }
    }
}
