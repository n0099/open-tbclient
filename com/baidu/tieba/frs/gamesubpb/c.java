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
    private BlankView fJG;
    private a fJI;
    private boolean fJJ = false;
    private View.OnTouchListener fJK;
    private com.baidu.tieba.f.b fyF;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int fJH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bnV();

        void bnW();

        boolean bnX();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.fyF = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fJK = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fyF.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fyF.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fyF.a(new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void t(int i, int i2) {
                if (c.this.fJI != null && c.this.fJI.bnX() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fJG != null) {
                        c.this.fJG.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void u(int i, int i2) {
                c.this.bnY();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void v(int i, int i2) {
            }
        });
    }

    public void bnY() {
        if (this.fJJ && this.mNavigationBar != null && this.fJG != null && this.fJG.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.fJI != null) {
                this.fJI.bnV();
            }
            this.fJG.bof();
        }
    }

    public void bnZ() {
        ViewGroup viewGroup;
        if (!this.fJJ && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fJG = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.fJG.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fJG, 0, new LinearLayout.LayoutParams(-1, fJH));
            this.fJG.setVisibility(0);
            this.fJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.fJG.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bob() {
                    if (c.this.fJG != null) {
                        c.this.fJG.setVisibility(8);
                    }
                    c.this.fJJ = false;
                    if (c.this.fJI != null) {
                        c.this.fJI.bnW();
                    }
                }
            });
            this.mActivity.setExcludeHeight(fJH);
            this.fJJ = true;
        }
    }

    public void a(a aVar) {
        this.fJI = aVar;
    }

    public boolean boa() {
        return this.fJJ;
    }

    public void rj(int i) {
        if (this.fJG != null) {
            am.setBackgroundResource(this.fJG, i);
        }
    }
}
