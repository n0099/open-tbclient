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
/* loaded from: classes2.dex */
public class c {
    private BlankView jBe;
    private a jBg;
    private boolean jBh = false;
    private View.OnTouchListener jBi;
    private com.baidu.tieba.f.b jlq;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jBf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void cIq();

        void cIr();

        boolean cIs();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.jlq = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jBi = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jlq.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jlq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.jlq.a(new a.InterfaceC0711a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void G(int i, int i2) {
                c.this.cIt();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void H(int i, int i2) {
                if (c.this.jBg != null && c.this.jBg.cIs() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jBe != null) {
                        c.this.jBe.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void I(int i, int i2) {
            }
        });
    }

    public void cIt() {
        if (this.jBh && this.mNavigationBar != null && this.jBe != null && this.jBe.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jBg != null) {
                this.jBg.cIq();
            }
            this.jBe.cIz();
        }
    }

    public void cIu() {
        ViewGroup viewGroup;
        if (!this.jBh && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jBe = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jBe.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jBe, 0, new LinearLayout.LayoutParams(-1, jBf));
            this.jBe.setVisibility(0);
            this.jBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jBe.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bEO() {
                    if (c.this.jBe != null) {
                        c.this.jBe.setVisibility(8);
                    }
                    c.this.jBh = false;
                    if (c.this.jBg != null) {
                        c.this.jBg.cIr();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jBf);
            this.jBh = true;
        }
    }

    public void a(a aVar) {
        this.jBg = aVar;
    }

    public boolean cIv() {
        return this.jBh;
    }

    public void zO(int i) {
        if (this.jBe != null) {
            ap.setBackgroundResource(this.jBe, i);
        }
    }
}
