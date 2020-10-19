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
/* loaded from: classes22.dex */
public class c {
    private BlankView iGL;
    private a iGN;
    private boolean iGO = false;
    private View.OnTouchListener iGP;
    private com.baidu.tieba.f.b itR;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int iGM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes22.dex */
    public interface a {
        void cxp();

        void cxq();

        boolean cxr();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.itR = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.iGP = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.itR.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.itR.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.itR.a(new a.InterfaceC0689a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void H(int i, int i2) {
                c.this.cxs();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void I(int i, int i2) {
                if (c.this.iGN != null && c.this.iGN.cxr() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.iGL != null) {
                        c.this.iGL.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void cc(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0689a
            public void J(int i, int i2) {
            }
        });
    }

    public void cxs() {
        if (this.iGO && this.mNavigationBar != null && this.iGL != null && this.iGL.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iGN != null) {
                this.iGN.cxp();
            }
            this.iGL.cxy();
        }
    }

    public void cxt() {
        ViewGroup viewGroup;
        if (!this.iGO && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iGL = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iGL.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iGL, 0, new LinearLayout.LayoutParams(-1, iGM));
            this.iGL.setVisibility(0);
            this.iGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.iGL.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void byG() {
                    if (c.this.iGL != null) {
                        c.this.iGL.setVisibility(8);
                    }
                    c.this.iGO = false;
                    if (c.this.iGN != null) {
                        c.this.iGN.cxq();
                    }
                }
            });
            this.mActivity.setExcludeHeight(iGM);
            this.iGO = true;
        }
    }

    public void a(a aVar) {
        this.iGN = aVar;
    }

    public boolean cxu() {
        return this.iGO;
    }

    public void zg(int i) {
        if (this.iGL != null) {
            ap.setBackgroundResource(this.iGL, i);
        }
    }
}
