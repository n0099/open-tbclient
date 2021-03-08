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
    private BlankView jCN;
    private a jCP;
    private boolean jCQ = false;
    private View.OnTouchListener jCR;
    private com.baidu.tieba.f.b jna;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jCO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void cIw();

        void cIx();

        boolean cIy();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.jna = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jCR = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jna.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.jna.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.jna.a(new a.InterfaceC0717a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void G(int i, int i2) {
                c.this.cIz();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void H(int i, int i2) {
                if (c.this.jCP != null && c.this.jCP.cIy() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jCN != null) {
                        c.this.jCN.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void I(int i, int i2) {
            }
        });
    }

    public void cIz() {
        if (this.jCQ && this.mNavigationBar != null && this.jCN != null && this.jCN.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jCP != null) {
                this.jCP.cIw();
            }
            this.jCN.cIF();
        }
    }

    public void cIA() {
        ViewGroup viewGroup;
        if (!this.jCQ && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jCN = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jCN.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jCN, 0, new LinearLayout.LayoutParams(-1, jCO));
            this.jCN.setVisibility(0);
            this.jCN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jCN.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bES() {
                    if (c.this.jCN != null) {
                        c.this.jCN.setVisibility(8);
                    }
                    c.this.jCQ = false;
                    if (c.this.jCP != null) {
                        c.this.jCP.cIx();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jCO);
            this.jCQ = true;
        }
    }

    public void a(a aVar) {
        this.jCP = aVar;
    }

    public boolean cIB() {
        return this.jCQ;
    }

    public void zP(int i) {
        if (this.jCN != null) {
            ap.setBackgroundResource(this.jCN, i);
        }
    }
}
