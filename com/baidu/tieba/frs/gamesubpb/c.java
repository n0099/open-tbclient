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
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
import com.baidu.tieba.g.a;
/* loaded from: classes21.dex */
public class c {
    private com.baidu.tieba.g.b iMX;
    private BlankView iZQ;
    private a iZS;
    private boolean iZT = false;
    private View.OnTouchListener iZU;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int iZR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes21.dex */
    public interface a {
        void cCB();

        void cCC();

        boolean cCD();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.iMX = new com.baidu.tieba.g.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.iZU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iMX.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iMX.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.iMX.a(new a.InterfaceC0740a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void H(int i, int i2) {
                c.this.cCE();
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void I(int i, int i2) {
                if (c.this.iZS != null && c.this.iZS.cCD() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.iZQ != null) {
                        c.this.iZQ.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0740a
            public void J(int i, int i2) {
            }
        });
    }

    public void cCE() {
        if (this.iZT && this.mNavigationBar != null && this.iZQ != null && this.iZQ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iZS != null) {
                this.iZS.cCB();
            }
            this.iZQ.cCK();
        }
    }

    public void cCF() {
        ViewGroup viewGroup;
        if (!this.iZT && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iZQ = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iZQ.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iZQ, 0, new LinearLayout.LayoutParams(-1, iZR));
            this.iZQ.setVisibility(0);
            this.iZQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.iZQ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bCr() {
                    if (c.this.iZQ != null) {
                        c.this.iZQ.setVisibility(8);
                    }
                    c.this.iZT = false;
                    if (c.this.iZS != null) {
                        c.this.iZS.cCC();
                    }
                }
            });
            this.mActivity.setExcludeHeight(iZR);
            this.iZT = true;
        }
    }

    public void a(a aVar) {
        this.iZS = aVar;
    }

    public boolean cCG() {
        return this.iZT;
    }

    public void Ak(int i) {
        if (this.iZQ != null) {
            ap.setBackgroundResource(this.iZQ, i);
        }
    }
}
