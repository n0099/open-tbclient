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
    private com.baidu.tieba.f.b hcq;
    private BlankView hnN;
    private a hnP;
    private boolean hnQ = false;
    private View.OnTouchListener hnR;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hnO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bSK();

        void bSL();

        boolean bSM();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hcq = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hnR = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hcq.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hcq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hcq.a(new a.InterfaceC0536a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0536a
            public void y(int i, int i2) {
                c.this.bSN();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0536a
            public void z(int i, int i2) {
                if (c.this.hnP != null && c.this.hnP.bSM() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hnN != null) {
                        c.this.hnN.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0536a
            public void bG(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0536a
            public void A(int i, int i2) {
            }
        });
    }

    public void bSN() {
        if (this.hnQ && this.mNavigationBar != null && this.hnN != null && this.hnN.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hnP != null) {
                this.hnP.bSK();
            }
            this.hnN.bSU();
        }
    }

    public void bSO() {
        ViewGroup viewGroup;
        if (!this.hnQ && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hnN = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hnN.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hnN, 0, new LinearLayout.LayoutParams(-1, hnO));
            this.hnN.setVisibility(0);
            this.hnN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hnN.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bSQ() {
                    if (c.this.hnN != null) {
                        c.this.hnN.setVisibility(8);
                    }
                    c.this.hnQ = false;
                    if (c.this.hnP != null) {
                        c.this.hnP.bSL();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hnO);
            this.hnQ = true;
        }
    }

    public void a(a aVar) {
        this.hnP = aVar;
    }

    public boolean bSP() {
        return this.hnQ;
    }

    public void ue(int i) {
        if (this.hnN != null) {
            am.setBackgroundResource(this.hnN, i);
        }
    }
}
