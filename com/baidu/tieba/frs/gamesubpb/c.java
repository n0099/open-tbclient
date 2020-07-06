package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.f.b hEm;
    private BlankView hQC;
    private a hQE;
    private boolean hQF = false;
    private View.OnTouchListener hQG;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hQD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void ccB();

        void ccC();

        boolean ccD();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hEm = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hQG = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hEm.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hEm.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hEm.a(new a.InterfaceC0614a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void D(int i, int i2) {
                c.this.ccE();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void E(int i, int i2) {
                if (c.this.hQE != null && c.this.hQE.ccD() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hQC != null) {
                        c.this.hQC.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void bO(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0614a
            public void F(int i, int i2) {
            }
        });
    }

    public void ccE() {
        if (this.hQF && this.mNavigationBar != null && this.hQC != null && this.hQC.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hQE != null) {
                this.hQE.ccB();
            }
            this.hQC.ccK();
        }
    }

    public void ccF() {
        ViewGroup viewGroup;
        if (!this.hQF && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hQC = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hQC.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hQC, 0, new LinearLayout.LayoutParams(-1, hQD));
            this.hQC.setVisibility(0);
            this.hQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hQC.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bit() {
                    if (c.this.hQC != null) {
                        c.this.hQC.setVisibility(8);
                    }
                    c.this.hQF = false;
                    if (c.this.hQE != null) {
                        c.this.hQE.ccC();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hQD);
            this.hQF = true;
        }
    }

    public void a(a aVar) {
        this.hQE = aVar;
    }

    public boolean ccG() {
        return this.hQF;
    }

    public void vq(int i) {
        if (this.hQC != null) {
            an.setBackgroundResource(this.hQC, i);
        }
    }
}
