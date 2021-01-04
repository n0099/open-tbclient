package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes2.dex */
public class c {
    private com.baidu.tieba.f.b jkd;
    private BlankView jzQ;
    private a jzS;
    private boolean jzT = false;
    private View.OnTouchListener jzU;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jzR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void cKN();

        void cKO();

        boolean cKP();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.jkd = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jzU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jkd.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jkd.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.jkd.a(new a.InterfaceC0727a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void G(int i, int i2) {
                c.this.cKQ();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void H(int i, int i2) {
                if (c.this.jzS != null && c.this.jzS.cKP() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jzQ != null) {
                        c.this.jzQ.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void cj(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void I(int i, int i2) {
            }
        });
    }

    public void cKQ() {
        if (this.jzT && this.mNavigationBar != null && this.jzQ != null && this.jzQ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jzS != null) {
                this.jzS.cKN();
            }
            this.jzQ.cKW();
        }
    }

    public void cKR() {
        ViewGroup viewGroup;
        if (!this.jzT && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jzQ = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jzQ.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jzQ, 0, new LinearLayout.LayoutParams(-1, jzR));
            this.jzQ.setVisibility(0);
            this.jzQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jzQ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bIn() {
                    if (c.this.jzQ != null) {
                        c.this.jzQ.setVisibility(8);
                    }
                    c.this.jzT = false;
                    if (c.this.jzS != null) {
                        c.this.jzS.cKO();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jzR);
            this.jzT = true;
        }
    }

    public void a(a aVar) {
        this.jzS = aVar;
    }

    public boolean cKS() {
        return this.jzT;
    }

    public void Bk(int i) {
        if (this.jzQ != null) {
            ao.setBackgroundResource(this.jzQ, i);
        }
    }
}
