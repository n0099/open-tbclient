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
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.f.b hcw;
    private BlankView hnT;
    private a hnV;
    private boolean hnW = false;
    private View.OnTouchListener hnX;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hnU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bSI();

        void bSJ();

        boolean bSK();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hcw = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hnX = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hcw.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hcw.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hcw.a(new a.InterfaceC0557a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0557a
            public void y(int i, int i2) {
                c.this.bSL();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0557a
            public void z(int i, int i2) {
                if (c.this.hnV != null && c.this.hnV.bSK() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hnT != null) {
                        c.this.hnT.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0557a
            public void bG(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0557a
            public void A(int i, int i2) {
            }
        });
    }

    public void bSL() {
        if (this.hnW && this.mNavigationBar != null && this.hnT != null && this.hnT.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hnV != null) {
                this.hnV.bSI();
            }
            this.hnT.bSS();
        }
    }

    public void bSM() {
        ViewGroup viewGroup;
        if (!this.hnW && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hnT = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hnT.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hnT, 0, new LinearLayout.LayoutParams(-1, hnU));
            this.hnT.setVisibility(0);
            this.hnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hnT.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bSO() {
                    if (c.this.hnT != null) {
                        c.this.hnT.setVisibility(8);
                    }
                    c.this.hnW = false;
                    if (c.this.hnV != null) {
                        c.this.hnV.bSJ();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hnU);
            this.hnW = true;
        }
    }

    public void a(a aVar) {
        this.hnV = aVar;
    }

    public boolean bSN() {
        return this.hnW;
    }

    public void ue(int i) {
        if (this.hnT != null) {
            am.setBackgroundResource(this.hnT, i);
        }
    }
}
