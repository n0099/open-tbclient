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
/* loaded from: classes7.dex */
public class c {
    private BlankView gBf;
    private a gBh;
    private boolean gBi = false;
    private View.OnTouchListener gBj;
    private com.baidu.tieba.f.b gql;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gBg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes7.dex */
    public interface a {
        void bGu();

        void bGv();

        boolean bGw();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gql = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gBj = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gql.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gql.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gql.a(new a.InterfaceC0492a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0492a
            public void y(int i, int i2) {
                c.this.bGx();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0492a
            public void z(int i, int i2) {
                if (c.this.gBh != null && c.this.gBh.bGw() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gBf != null) {
                        c.this.gBf.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0492a
            public void bz(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0492a
            public void A(int i, int i2) {
            }
        });
    }

    public void bGx() {
        if (this.gBi && this.mNavigationBar != null && this.gBf != null && this.gBf.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gBh != null) {
                this.gBh.bGu();
            }
            this.gBf.bGE();
        }
    }

    public void bGy() {
        ViewGroup viewGroup;
        if (!this.gBi && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gBf = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gBf.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gBf, 0, new LinearLayout.LayoutParams(-1, gBg));
            this.gBf.setVisibility(0);
            this.gBf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gBf.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bGA() {
                    if (c.this.gBf != null) {
                        c.this.gBf.setVisibility(8);
                    }
                    c.this.gBi = false;
                    if (c.this.gBh != null) {
                        c.this.gBh.bGv();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gBg);
            this.gBi = true;
        }
    }

    public void a(a aVar) {
        this.gBh = aVar;
    }

    public boolean bGz() {
        return this.gBi;
    }

    public void tu(int i) {
        if (this.gBf != null) {
            am.setBackgroundResource(this.gBf, i);
        }
    }
}
