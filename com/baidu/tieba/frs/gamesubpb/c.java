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
    private BaseActivity bSC;
    private com.baidu.tieba.e.b coc;
    private com.baidu.tieba.frs.gamesubpb.view.a dPD;
    private a dPF;
    private boolean dPG = false;
    private View.OnTouchListener dPH;
    private NavigationBar mNavigationBar;
    private static final int dPE = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void ayf();

        void ayg();

        boolean ayh();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSC = baseActivity;
        this.coc = new com.baidu.tieba.e.b(this.bSC.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPH = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.coc.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.coc.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.coc.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
                if (c.this.dPF != null && c.this.dPF.ayh() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dPD != null) {
                        c.this.dPD.setBackgroundResource(d.C0141d.transparent);
                    }
                    c.this.bSC.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
                c.this.ayi();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void ayi() {
        if (this.dPG && this.mNavigationBar != null && this.dPD != null && this.dPD.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSC.setExcludeHeight(0);
            if (this.dPF != null) {
                this.dPF.ayf();
            }
            this.dPD.ayp();
        }
    }

    public void ayj() {
        ViewGroup viewGroup;
        if (!this.dPG && (viewGroup = (ViewGroup) this.bSC.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dPD = new com.baidu.tieba.frs.gamesubpb.view.a(this.bSC.getPageContext().getPageActivity());
            this.dPD.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dPD, 0, new LinearLayout.LayoutParams(-1, dPE));
            this.dPD.setVisibility(0);
            this.dPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bSC.finish();
                }
            });
            this.dPD.setScrollCallBack(new a.InterfaceC0158a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.a.InterfaceC0158a
                public void ayl() {
                    if (c.this.dPD != null) {
                        c.this.dPD.setVisibility(8);
                    }
                    c.this.dPG = false;
                    if (c.this.dPF != null) {
                        c.this.dPF.ayg();
                    }
                }
            });
            this.bSC.setExcludeHeight(dPE);
            this.dPG = true;
        }
    }

    public void a(a aVar) {
        this.dPF = aVar;
    }

    public boolean ayk() {
        return this.dPG;
    }

    public void nx(int i) {
        if (this.dPD != null) {
            aj.s(this.dPD, i);
        }
    }
}
