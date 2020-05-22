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
    private BlankView hCH;
    private a hCJ;
    private boolean hCK = false;
    private View.OnTouchListener hCL;
    private com.baidu.tieba.f.b hrk;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int hCI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bZe();

        void bZf();

        boolean bZg();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.hrk = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.hCL = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hrk.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.hrk.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.hrk.a(new a.InterfaceC0607a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void B(int i, int i2) {
                c.this.bZh();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0607a
            public void C(int i, int i2) {
                if (c.this.hCJ != null && c.this.hCJ.bZg() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.hCH != null) {
                        c.this.hCH.setBackgroundResource(R.color.transparent);
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

    public void bZh() {
        if (this.hCK && this.mNavigationBar != null && this.hCH != null && this.hCH.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.hCJ != null) {
                this.hCJ.bZe();
            }
            this.hCH.bZo();
        }
    }

    public void bZi() {
        ViewGroup viewGroup;
        if (!this.hCK && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hCH = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.hCH.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hCH, 0, new LinearLayout.LayoutParams(-1, hCI));
            this.hCH.setVisibility(0);
            this.hCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.hCH.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bZk() {
                    if (c.this.hCH != null) {
                        c.this.hCH.setVisibility(8);
                    }
                    c.this.hCK = false;
                    if (c.this.hCJ != null) {
                        c.this.hCJ.bZf();
                    }
                }
            });
            this.mActivity.setExcludeHeight(hCI);
            this.hCK = true;
        }
    }

    public void a(a aVar) {
        this.hCJ = aVar;
    }

    public boolean bZj() {
        return this.hCK;
    }

    public void uJ(int i) {
        if (this.hCH != null) {
            am.setBackgroundResource(this.hCH, i);
        }
    }
}
