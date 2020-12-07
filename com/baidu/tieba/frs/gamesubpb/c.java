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
    private com.baidu.tieba.g.b iXO;
    private BlankView jnq;
    private a jns;
    private boolean jnt = false;
    private View.OnTouchListener jnu;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int jnr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes22.dex */
    public interface a {
        void cHM();

        void cHN();

        boolean cHO();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.iXO = new com.baidu.tieba.g.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.jnu = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iXO.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.iXO.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.iXO.a(new a.InterfaceC0756a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void G(int i, int i2) {
                c.this.cHP();
            }

            @Override // com.baidu.tieba.g.a.InterfaceC0756a
            public void H(int i, int i2) {
                if (c.this.jns != null && c.this.jns.cHO() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.jnq != null) {
                        c.this.jnq.setBackgroundResource(R.color.transparent);
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

    public void cHP() {
        if (this.jnt && this.mNavigationBar != null && this.jnq != null && this.jnq.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.jns != null) {
                this.jns.cHM();
            }
            this.jnq.cHV();
        }
    }

    public void cHQ() {
        ViewGroup viewGroup;
        if (!this.jnt && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.jnq = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.jnq.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.jnq, 0, new LinearLayout.LayoutParams(-1, jnr));
            this.jnq.setVisibility(0);
            this.jnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.jnq.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bFS() {
                    if (c.this.jnq != null) {
                        c.this.jnq.setVisibility(8);
                    }
                    c.this.jnt = false;
                    if (c.this.jns != null) {
                        c.this.jns.cHN();
                    }
                }
            });
            this.mActivity.setExcludeHeight(jnr);
            this.jnt = true;
        }
    }

    public void a(a aVar) {
        this.jns = aVar;
    }

    public boolean cHR() {
        return this.jnt;
    }

    public void AY(int i) {
        if (this.jnq != null) {
            ap.setBackgroundResource(this.jnq, i);
        }
    }
}
