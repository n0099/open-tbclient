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
    private BlankView gDt;
    private a gDv;
    private boolean gDw = false;
    private View.OnTouchListener gDx;
    private com.baidu.tieba.f.b gsB;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gDu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bHZ();

        void bIa();

        boolean bIb();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gsB = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gDx = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gsB.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gsB.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gsB.a(new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void z(int i, int i2) {
                c.this.bIc();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void A(int i, int i2) {
                if (c.this.gDv != null && c.this.gDv.bIb() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gDt != null) {
                        c.this.gDt.setBackgroundResource(R.color.transparent);
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

    public void bIc() {
        if (this.gDw && this.mNavigationBar != null && this.gDt != null && this.gDt.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gDv != null) {
                this.gDv.bHZ();
            }
            this.gDt.bIj();
        }
    }

    public void bId() {
        ViewGroup viewGroup;
        if (!this.gDw && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gDt = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gDt.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gDt, 0, new LinearLayout.LayoutParams(-1, gDu));
            this.gDt.setVisibility(0);
            this.gDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gDt.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bIf() {
                    if (c.this.gDt != null) {
                        c.this.gDt.setVisibility(8);
                    }
                    c.this.gDw = false;
                    if (c.this.gDv != null) {
                        c.this.gDv.bIa();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gDu);
            this.gDw = true;
        }
    }

    public void a(a aVar) {
        this.gDv = aVar;
    }

    public boolean bIe() {
        return this.gDw;
    }

    public void tA(int i) {
        if (this.gDt != null) {
            am.setBackgroundResource(this.gDt, i);
        }
    }
}
