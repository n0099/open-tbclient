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
    private BlankView gDf;
    private a gDh;
    private boolean gDi = false;
    private View.OnTouchListener gDj;
    private com.baidu.tieba.f.b gsm;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gDg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bHW();

        void bHX();

        boolean bHY();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gsm = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gDj = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gsm.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gsm.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gsm.a(new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void z(int i, int i2) {
                c.this.bHZ();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void A(int i, int i2) {
                if (c.this.gDh != null && c.this.gDh.bHY() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gDf != null) {
                        c.this.gDf.setBackgroundResource(R.color.transparent);
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

    public void bHZ() {
        if (this.gDi && this.mNavigationBar != null && this.gDf != null && this.gDf.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gDh != null) {
                this.gDh.bHW();
            }
            this.gDf.bIg();
        }
    }

    public void bIa() {
        ViewGroup viewGroup;
        if (!this.gDi && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gDf = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gDf.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gDf, 0, new LinearLayout.LayoutParams(-1, gDg));
            this.gDf.setVisibility(0);
            this.gDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gDf.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bIc() {
                    if (c.this.gDf != null) {
                        c.this.gDf.setVisibility(8);
                    }
                    c.this.gDi = false;
                    if (c.this.gDh != null) {
                        c.this.gDh.bHX();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gDg);
            this.gDi = true;
        }
    }

    public void a(a aVar) {
        this.gDh = aVar;
    }

    public boolean bIb() {
        return this.gDi;
    }

    public void tA(int i) {
        if (this.gDf != null) {
            am.setBackgroundResource(this.gDf, i);
        }
    }
}
