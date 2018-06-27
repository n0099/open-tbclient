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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.f.b bJn;
    private BaseActivity bmt;
    private boolean dxA = false;
    private View.OnTouchListener dxB;
    private BlankView dxx;
    private a dxz;
    private NavigationBar mNavigationBar;
    private static final int dxy = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void axF();

        void axG();

        boolean axH();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmt = baseActivity;
        this.bJn = new com.baidu.tieba.f.b(this.bmt.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dxB = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bJn.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bJn.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bJn.a(new a.InterfaceC0147a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void W(int i, int i2) {
                if (c.this.dxz != null && c.this.dxz.axH() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dxx != null) {
                        c.this.dxx.setBackgroundResource(d.C0142d.transparent);
                    }
                    c.this.bmt.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void X(int i, int i2) {
                c.this.axI();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void Y(int i, int i2) {
            }
        });
    }

    public void axI() {
        if (this.dxA && this.mNavigationBar != null && this.dxx != null && this.dxx.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmt.setExcludeHeight(0);
            if (this.dxz != null) {
                this.dxz.axF();
            }
            this.dxx.axP();
        }
    }

    public void axJ() {
        ViewGroup viewGroup;
        if (!this.dxA && (viewGroup = (ViewGroup) this.bmt.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dxx = new BlankView(this.bmt.getPageContext().getPageActivity());
            this.dxx.setBackgroundResource(d.C0142d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dxx, 0, new LinearLayout.LayoutParams(-1, dxy));
            this.dxx.setVisibility(0);
            this.dxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bmt.finish();
                }
            });
            this.dxx.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void axL() {
                    if (c.this.dxx != null) {
                        c.this.dxx.setVisibility(8);
                    }
                    c.this.dxA = false;
                    if (c.this.dxz != null) {
                        c.this.dxz.axG();
                    }
                }
            });
            this.bmt.setExcludeHeight(dxy);
            this.dxA = true;
        }
    }

    public void a(a aVar) {
        this.dxz = aVar;
    }

    public boolean axK() {
        return this.dxA;
    }

    public void kW(int i) {
        if (this.dxx != null) {
            am.i(this.dxx, i);
        }
    }
}
