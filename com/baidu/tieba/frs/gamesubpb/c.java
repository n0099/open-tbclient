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
    private BlankView gDh;
    private a gDj;
    private boolean gDk = false;
    private View.OnTouchListener gDl;
    private com.baidu.tieba.f.b gso;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gDi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bHY();

        void bHZ();

        boolean bIa();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gso = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gDl = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gso.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gso.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gso.a(new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void z(int i, int i2) {
                c.this.bIb();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void A(int i, int i2) {
                if (c.this.gDj != null && c.this.gDj.bIa() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gDh != null) {
                        c.this.gDh.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void bA(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void B(int i, int i2) {
            }
        });
    }

    public void bIb() {
        if (this.gDk && this.mNavigationBar != null && this.gDh != null && this.gDh.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gDj != null) {
                this.gDj.bHY();
            }
            this.gDh.bIi();
        }
    }

    public void bIc() {
        ViewGroup viewGroup;
        if (!this.gDk && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gDh = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gDh.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gDh, 0, new LinearLayout.LayoutParams(-1, gDi));
            this.gDh.setVisibility(0);
            this.gDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gDh.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bIe() {
                    if (c.this.gDh != null) {
                        c.this.gDh.setVisibility(8);
                    }
                    c.this.gDk = false;
                    if (c.this.gDj != null) {
                        c.this.gDj.bHZ();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gDi);
            this.gDk = true;
        }
    }

    public void a(a aVar) {
        this.gDj = aVar;
    }

    public boolean bId() {
        return this.gDk;
    }

    public void tA(int i) {
        if (this.gDh != null) {
            am.setBackgroundResource(this.gDh, i);
        }
    }
}
