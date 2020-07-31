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
/* loaded from: classes16.dex */
public class c {
    private com.baidu.tieba.f.b hKk;
    private BlankView hWB;
    private a hWD;
    private boolean hWE = false;
    private View.OnTouchListener hWF;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hWC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes16.dex */
    public interface a {
        void cfZ();

        void cga();

        boolean cgb();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hKk = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hWF = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hKk.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hKk.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hKk.a(new a.InterfaceC0623a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void D(int i, int i2) {
                c.this.cgc();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void E(int i, int i2) {
                if (c.this.hWD != null && c.this.hWD.cgb() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hWB != null) {
                        c.this.hWB.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void bR(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0623a
            public void F(int i, int i2) {
            }
        });
    }

    public void cgc() {
        if (this.hWE && this.mNavigationBar != null && this.hWB != null && this.hWB.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hWD != null) {
                this.hWD.cfZ();
            }
            this.hWB.cgi();
        }
    }

    public void cgd() {
        ViewGroup viewGroup;
        if (!this.hWE && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hWB = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hWB.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hWB, 0, new LinearLayout.LayoutParams(-1, hWC));
            this.hWB.setVisibility(0);
            this.hWB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hWB.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bme() {
                    if (c.this.hWB != null) {
                        c.this.hWB.setVisibility(8);
                    }
                    c.this.hWE = false;
                    if (c.this.hWD != null) {
                        c.this.hWD.cga();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hWC);
            this.hWE = true;
        }
    }

    public void a(a aVar) {
        this.hWD = aVar;
    }

    public boolean cge() {
        return this.hWE;
    }

    public void vI(int i) {
        if (this.hWB != null) {
            ao.setBackgroundResource(this.hWB, i);
        }
    }
}
