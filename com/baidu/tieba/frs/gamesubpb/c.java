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
/* loaded from: classes21.dex */
public class c {
    private com.baidu.tieba.f.b ieU;
    private BlankView irS;
    private a irU;
    private boolean irV = false;
    private View.OnTouchListener irW;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int irT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes21.dex */
    public interface a {
        void ctS();

        void ctT();

        boolean ctU();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.ieU = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.irW = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.ieU.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.ieU.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ieU.a(new a.InterfaceC0671a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void H(int i, int i2) {
                c.this.ctV();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void I(int i, int i2) {
                if (c.this.irU != null && c.this.irU.ctU() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.irS != null) {
                        c.this.irS.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void cc(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0671a
            public void J(int i, int i2) {
            }
        });
    }

    public void ctV() {
        if (this.irV && this.mNavigationBar != null && this.irS != null && this.irS.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.irU != null) {
                this.irU.ctS();
            }
            this.irS.cub();
        }
    }

    public void ctW() {
        ViewGroup viewGroup;
        if (!this.irV && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.irS = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.irS.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.irS, 0, new LinearLayout.LayoutParams(-1, irT));
            this.irS.setVisibility(0);
            this.irS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.irS.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bvW() {
                    if (c.this.irS != null) {
                        c.this.irS.setVisibility(8);
                    }
                    c.this.irV = false;
                    if (c.this.irU != null) {
                        c.this.irU.ctT();
                    }
                }
            });
            this.mActivity.setExcludeHeight(irT);
            this.irV = true;
        }
    }

    public void a(a aVar) {
        this.irU = aVar;
    }

    public boolean ctX() {
        return this.irV;
    }

    public void yA(int i) {
        if (this.irS != null) {
            ap.setBackgroundResource(this.irS, i);
        }
    }
}
