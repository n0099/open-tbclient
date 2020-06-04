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
/* loaded from: classes9.dex */
public class c {
    private BlankView hDu;
    private a hDw;
    private boolean hDx = false;
    private View.OnTouchListener hDy;
    private com.baidu.tieba.f.b hrv;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hDv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bZm();

        void bZn();

        boolean bZo();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hrv = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hDy = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hrv.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hrv.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hrv.a(new a.InterfaceC0607a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void B(int i, int i2) {
                c.this.bZp();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void C(int i, int i2) {
                if (c.this.hDw != null && c.this.hDw.bZo() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hDu != null) {
                        c.this.hDu.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void bK(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void D(int i, int i2) {
            }
        });
    }

    public void bZp() {
        if (this.hDx && this.mNavigationBar != null && this.hDu != null && this.hDu.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hDw != null) {
                this.hDw.bZm();
            }
            this.hDu.bZw();
        }
    }

    public void bZq() {
        ViewGroup viewGroup;
        if (!this.hDx && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hDu = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hDu.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hDu, 0, new LinearLayout.LayoutParams(-1, hDv));
            this.hDu.setVisibility(0);
            this.hDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hDu.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bZs() {
                    if (c.this.hDu != null) {
                        c.this.hDu.setVisibility(8);
                    }
                    c.this.hDx = false;
                    if (c.this.hDw != null) {
                        c.this.hDw.bZn();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hDv);
            this.hDx = true;
        }
    }

    public void a(a aVar) {
        this.hDw = aVar;
    }

    public boolean bZr() {
        return this.hDx;
    }

    public void uL(int i) {
        if (this.hDu != null) {
            am.setBackgroundResource(this.hDu, i);
        }
    }
}
