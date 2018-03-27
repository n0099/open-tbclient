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
    private BaseActivity bSF;
    private com.baidu.tieba.e.b cof;
    private com.baidu.tieba.frs.gamesubpb.view.a dPI;
    private a dPK;
    private boolean dPL = false;
    private View.OnTouchListener dPM;
    private NavigationBar mNavigationBar;
    private static final int dPJ = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void ayh();

        void ayi();

        boolean ayj();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSF = baseActivity;
        this.cof = new com.baidu.tieba.e.b(this.bSF.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPM = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cof.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cof.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cof.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
                if (c.this.dPK != null && c.this.dPK.ayj() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dPI != null) {
                        c.this.dPI.setBackgroundResource(d.C0141d.transparent);
                    }
                    c.this.bSF.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
                c.this.ayk();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void ayk() {
        if (this.dPL && this.mNavigationBar != null && this.dPI != null && this.dPI.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSF.setExcludeHeight(0);
            if (this.dPK != null) {
                this.dPK.ayh();
            }
            this.dPI.ayr();
        }
    }

    public void ayl() {
        ViewGroup viewGroup;
        if (!this.dPL && (viewGroup = (ViewGroup) this.bSF.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dPI = new com.baidu.tieba.frs.gamesubpb.view.a(this.bSF.getPageContext().getPageActivity());
            this.dPI.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dPI, 0, new LinearLayout.LayoutParams(-1, dPJ));
            this.dPI.setVisibility(0);
            this.dPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bSF.finish();
                }
            });
            this.dPI.setScrollCallBack(new a.InterfaceC0158a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.a.InterfaceC0158a
                public void ayn() {
                    if (c.this.dPI != null) {
                        c.this.dPI.setVisibility(8);
                    }
                    c.this.dPL = false;
                    if (c.this.dPK != null) {
                        c.this.dPK.ayi();
                    }
                }
            });
            this.bSF.setExcludeHeight(dPJ);
            this.dPL = true;
        }
    }

    public void a(a aVar) {
        this.dPK = aVar;
    }

    public boolean aym() {
        return this.dPL;
    }

    public void nx(int i) {
        if (this.dPI != null) {
            aj.s(this.dPI, i);
        }
    }
}
