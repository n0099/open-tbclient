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
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tieba.g.b iXQ;
    private BlankView jns;
    private a jnu;
    private boolean jnv = false;
    private View.OnTouchListener jnw;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jnt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes22.dex */
    public interface a {
        void cHN();

        void cHO();

        boolean cHP();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.iXQ = new com.baidu.tieba.g.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jnw = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iXQ.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iXQ.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.iXQ.a(new a.InterfaceC0756a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void G(int i, int i2) {
                c.this.cHQ();
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void H(int i, int i2) {
                if (c.this.jnu != null && c.this.jnu.cHP() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jns != null) {
                        c.this.jns.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void ck(int i, int i2) {
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void I(int i, int i2) {
            }
        });
    }

    public void cHQ() {
        if (this.jnv && this.mNavigationBar != null && this.jns != null && this.jns.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jnu != null) {
                this.jnu.cHN();
            }
            this.jns.cHW();
        }
    }

    public void cHR() {
        ViewGroup viewGroup;
        if (!this.jnv && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jns = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jns.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jns, 0, new LinearLayout.LayoutParams(-1, jnt));
            this.jns.setVisibility(0);
            this.jns.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jns.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bFS() {
                    if (c.this.jns != null) {
                        c.this.jns.setVisibility(8);
                    }
                    c.this.jnv = false;
                    if (c.this.jnu != null) {
                        c.this.jnu.cHO();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jnt);
            this.jnv = true;
        }
    }

    public void a(a aVar) {
        this.jnu = aVar;
    }

    public boolean cHS() {
        return this.jnv;
    }

    public void AY(int i) {
        if (this.jns != null) {
            ap.setBackgroundResource(this.jns, i);
        }
    }
}
