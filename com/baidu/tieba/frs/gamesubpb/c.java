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
    private BlankView hWD;
    private a hWF;
    private boolean hWG = false;
    private View.OnTouchListener hWH;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hWE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
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
        this.hWH = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
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
                if (c.this.hWF != null && c.this.hWF.cgb() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hWD != null) {
                        c.this.hWD.setBackgroundResource(R.color.transparent);
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
        if (this.hWG && this.mNavigationBar != null && this.hWD != null && this.hWD.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hWF != null) {
                this.hWF.cfZ();
            }
            this.hWD.cgi();
        }
    }

    public void cgd() {
        ViewGroup viewGroup;
        if (!this.hWG && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hWD = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hWD.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hWD, 0, new LinearLayout.LayoutParams(-1, hWE));
            this.hWD.setVisibility(0);
            this.hWD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hWD.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bme() {
                    if (c.this.hWD != null) {
                        c.this.hWD.setVisibility(8);
                    }
                    c.this.hWG = false;
                    if (c.this.hWF != null) {
                        c.this.hWF.cga();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hWE);
            this.hWG = true;
        }
    }

    public void a(a aVar) {
        this.hWF = aVar;
    }

    public boolean cge() {
        return this.hWG;
    }

    public void vI(int i) {
        if (this.hWD != null) {
            ao.setBackgroundResource(this.hWD, i);
        }
    }
}
