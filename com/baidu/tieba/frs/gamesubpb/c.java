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
/* loaded from: classes4.dex */
public class c {
    private boolean fKA = false;
    private View.OnTouchListener fKB;
    private BlankView fKx;
    private a fKz;
    private com.baidu.tieba.f.b fzw;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int fKy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bnX();

        void bnY();

        boolean bnZ();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.fzw = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fKB = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fzw.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fzw.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fzw.a(new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void v(int i, int i2) {
                if (c.this.fKz != null && c.this.fKz.bnZ() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fKx != null) {
                        c.this.fKx.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void w(int i, int i2) {
                c.this.boa();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void x(int i, int i2) {
            }
        });
    }

    public void boa() {
        if (this.fKA && this.mNavigationBar != null && this.fKx != null && this.fKx.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.fKz != null) {
                this.fKz.bnX();
            }
            this.fKx.boh();
        }
    }

    public void bob() {
        ViewGroup viewGroup;
        if (!this.fKA && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fKx = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.fKx.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fKx, 0, new LinearLayout.LayoutParams(-1, fKy));
            this.fKx.setVisibility(0);
            this.fKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.fKx.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bod() {
                    if (c.this.fKx != null) {
                        c.this.fKx.setVisibility(8);
                    }
                    c.this.fKA = false;
                    if (c.this.fKz != null) {
                        c.this.fKz.bnY();
                    }
                }
            });
            this.mActivity.setExcludeHeight(fKy);
            this.fKA = true;
        }
    }

    public void a(a aVar) {
        this.fKz = aVar;
    }

    public boolean boc() {
        return this.fKA;
    }

    public void rk(int i) {
        if (this.fKx != null) {
            am.setBackgroundResource(this.fKx, i);
        }
    }
}
