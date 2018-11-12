package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bxI;
    private com.baidu.tieba.f.b crR;
    private BlankView dPS;
    private a dPU;
    private boolean dPV = false;
    private View.OnTouchListener dPW;
    private NavigationBar mNavigationBar;
    private static final int dPT = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aDl();

        void aDm();

        boolean aDn();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bxI = baseActivity;
        this.crR = new com.baidu.tieba.f.b(this.bxI.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPW = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.crR.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.crR.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.crR.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ap(int i, int i2) {
                if (c.this.dPU != null && c.this.dPU.aDn() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dPS != null) {
                        c.this.dPS.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bxI.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void aq(int i, int i2) {
                c.this.aDo();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ar(int i, int i2) {
            }
        });
    }

    public void aDo() {
        if (this.dPV && this.mNavigationBar != null && this.dPS != null && this.dPS.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bxI.setExcludeHeight(0);
            if (this.dPU != null) {
                this.dPU.aDl();
            }
            this.dPS.aDv();
        }
    }

    public void aDp() {
        ViewGroup viewGroup;
        if (!this.dPV && (viewGroup = (ViewGroup) this.bxI.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dPS = new BlankView(this.bxI.getPageContext().getPageActivity());
            this.dPS.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dPS, 0, new LinearLayout.LayoutParams(-1, dPT));
            this.dPS.setVisibility(0);
            this.dPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bxI.finish();
                }
            });
            this.dPS.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aDr() {
                    if (c.this.dPS != null) {
                        c.this.dPS.setVisibility(8);
                    }
                    c.this.dPV = false;
                    if (c.this.dPU != null) {
                        c.this.dPU.aDm();
                    }
                }
            });
            this.bxI.setExcludeHeight(dPT);
            this.dPV = true;
        }
    }

    public void a(a aVar) {
        this.dPU = aVar;
    }

    public boolean aDq() {
        return this.dPV;
    }

    public void my(int i) {
        if (this.dPS != null) {
            al.i(this.dPS, i);
        }
    }
}
