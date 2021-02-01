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
    private BlankView jAQ;
    private a jAS;
    private boolean jAT = false;
    private View.OnTouchListener jAU;
    private com.baidu.tieba.f.b jlc;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jAR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void cIj();

        void cIk();

        boolean cIl();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.jlc = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jAU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jlc.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jlc.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.jlc.a(new a.InterfaceC0710a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void G(int i, int i2) {
                c.this.cIm();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void H(int i, int i2) {
                if (c.this.jAS != null && c.this.jAS.cIl() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jAQ != null) {
                        c.this.jAQ.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void I(int i, int i2) {
            }
        });
    }

    public void cIm() {
        if (this.jAT && this.mNavigationBar != null && this.jAQ != null && this.jAQ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jAS != null) {
                this.jAS.cIj();
            }
            this.jAQ.cIs();
        }
    }

    public void cIn() {
        ViewGroup viewGroup;
        if (!this.jAT && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jAQ = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jAQ.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jAQ, 0, new LinearLayout.LayoutParams(-1, jAR));
            this.jAQ.setVisibility(0);
            this.jAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jAQ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bEO() {
                    if (c.this.jAQ != null) {
                        c.this.jAQ.setVisibility(8);
                    }
                    c.this.jAT = false;
                    if (c.this.jAS != null) {
                        c.this.jAS.cIk();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jAR);
            this.jAT = true;
        }
    }

    public void a(a aVar) {
        this.jAS = aVar;
    }

    public boolean cIo() {
        return this.jAT;
    }

    public void zO(int i) {
        if (this.jAQ != null) {
            ap.setBackgroundResource(this.jAQ, i);
        }
    }
}
