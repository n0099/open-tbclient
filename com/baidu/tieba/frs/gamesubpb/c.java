package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.gamesubpb.view.a;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bSO;
    private com.baidu.tieba.e.b coo;
    private com.baidu.tieba.frs.gamesubpb.view.a dPP;
    private a dPR;
    private boolean dPS = false;
    private View.OnTouchListener dPT;
    private NavigationBar mNavigationBar;
    private static final int dPQ = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void ayg();

        void ayh();

        boolean ayi();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSO = baseActivity;
        this.coo = new com.baidu.tieba.e.b(this.bSO.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPT = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.coo.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.coo.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.coo.a(new a.InterfaceC0142a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aY(int i, int i2) {
                if (c.this.dPR != null && c.this.dPR.ayi() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dPP != null) {
                        c.this.dPP.setBackgroundResource(d.C0140d.transparent);
                    }
                    c.this.bSO.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aZ(int i, int i2) {
                c.this.ayj();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void ba(int i, int i2) {
            }
        });
    }

    public void ayj() {
        if (this.dPS && this.mNavigationBar != null && this.dPP != null && this.dPP.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSO.setExcludeHeight(0);
            if (this.dPR != null) {
                this.dPR.ayg();
            }
            this.dPP.ayq();
        }
    }

    public void ayk() {
        ViewGroup viewGroup;
        if (!this.dPS && (viewGroup = (ViewGroup) this.bSO.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dPP = new com.baidu.tieba.frs.gamesubpb.view.a(this.bSO.getPageContext().getPageActivity());
            this.dPP.setBackgroundResource(d.C0140d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dPP, 0, new LinearLayout.LayoutParams(-1, dPQ));
            this.dPP.setVisibility(0);
            this.dPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bSO.finish();
                }
            });
            this.dPP.setScrollCallBack(new a.InterfaceC0157a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.a.InterfaceC0157a
                public void aym() {
                    if (c.this.dPP != null) {
                        c.this.dPP.setVisibility(8);
                    }
                    c.this.dPS = false;
                    if (c.this.dPR != null) {
                        c.this.dPR.ayh();
                    }
                }
            });
            this.bSO.setExcludeHeight(dPQ);
            this.dPS = true;
        }
    }

    public void a(a aVar) {
        this.dPR = aVar;
    }

    public boolean ayl() {
        return this.dPS;
    }

    public void nx(int i) {
        if (this.dPP != null) {
            aj.s(this.dPP, i);
        }
    }
}
