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
    private BlankView gEr;
    private a gEt;
    private boolean gEu = false;
    private View.OnTouchListener gEv;
    private com.baidu.tieba.f.b gtf;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int gEs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes9.dex */
    public interface a {
        void bIl();

        void bIm();

        boolean bIn();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.gtf = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.gEv = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gtf.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.gtf.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.gtf.a(new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void z(int i, int i2) {
                c.this.bIo();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void A(int i, int i2) {
                if (c.this.gEt != null && c.this.gEt.bIn() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.gEr != null) {
                        c.this.gEr.setBackgroundResource(R.color.transparent);
                    }
                    c.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void bB(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0499a
            public void B(int i, int i2) {
            }
        });
    }

    public void bIo() {
        if (this.gEu && this.mNavigationBar != null && this.gEr != null && this.gEr.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.gEt != null) {
                this.gEt.bIl();
            }
            this.gEr.bIv();
        }
    }

    public void bIp() {
        ViewGroup viewGroup;
        if (!this.gEu && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gEr = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.gEr.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gEr, 0, new LinearLayout.LayoutParams(-1, gEs));
            this.gEr.setVisibility(0);
            this.gEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mActivity.finish();
                }
            });
            this.gEr.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bIr() {
                    if (c.this.gEr != null) {
                        c.this.gEr.setVisibility(8);
                    }
                    c.this.gEu = false;
                    if (c.this.gEt != null) {
                        c.this.gEt.bIm();
                    }
                }
            });
            this.mActivity.setExcludeHeight(gEs);
            this.gEu = true;
        }
    }

    public void a(a aVar) {
        this.gEt = aVar;
    }

    public boolean bIq() {
        return this.gEu;
    }

    public void tG(int i) {
        if (this.gEr != null) {
            am.setBackgroundResource(this.gEr, i);
        }
    }
}
