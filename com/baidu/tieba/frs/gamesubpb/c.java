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
    private com.baidu.tieba.f.b hXQ;
    private BlankView ikQ;
    private a ikS;
    private boolean ikT = false;
    private View.OnTouchListener ikU;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int ikR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes16.dex */
    public interface a {
        void cqF();

        void cqG();

        boolean cqH();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hXQ = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.ikU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hXQ.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hXQ.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hXQ.a(new a.InterfaceC0674a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void H(int i, int i2) {
                c.this.cqI();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0674a
            public void I(int i, int i2) {
                if (c.this.ikS != null && c.this.ikS.cqH() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.ikQ != null) {
                        c.this.ikQ.setBackgroundResource(R.color.transparent);
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

    public void cqI() {
        if (this.ikT && this.mNavigationBar != null && this.ikQ != null && this.ikQ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.ikS != null) {
                this.ikS.cqF();
            }
            this.ikQ.cqO();
        }
    }

    public void cqJ() {
        ViewGroup viewGroup;
        if (!this.ikT && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.ikQ = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.ikQ.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.ikQ, 0, new LinearLayout.LayoutParams(-1, ikR));
            this.ikQ.setVisibility(0);
            this.ikQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.ikQ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void buS() {
                    if (c.this.ikQ != null) {
                        c.this.ikQ.setVisibility(8);
                    }
                    c.this.ikT = false;
                    if (c.this.ikS != null) {
                        c.this.ikS.cqG();
                    }
                }
            });
            this.mActivity.setExcludeHeight(ikR);
            this.ikT = true;
        }
    }

    public void a(a aVar) {
        this.ikS = aVar;
    }

    public boolean cqK() {
        return this.ikT;
    }

    public void yb(int i) {
        if (this.ikQ != null) {
            ap.setBackgroundResource(this.ikQ, i);
        }
    }
}
