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
import com.baidu.tieba.f;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.f.b bKa;
    private BaseActivity bnc;
    private BlankView dAg;
    private a dAi;
    private boolean dAj = false;
    private View.OnTouchListener dAk;
    private NavigationBar mNavigationBar;
    private static final int dAh = l.f(TbadkCoreApplication.getInst(), f.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), f.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void ayi();

        void ayj();

        boolean ayk();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bnc = baseActivity;
        this.bKa = new com.baidu.tieba.f.b(this.bnc.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dAk = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bKa.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bKa.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bKa.a(new a.InterfaceC0144a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Y(int i, int i2) {
                if (c.this.dAi != null && c.this.dAi.ayk() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dAg != null) {
                        c.this.dAg.setBackgroundResource(f.d.transparent);
                    }
                    c.this.bnc.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Z(int i, int i2) {
                c.this.ayl();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void aa(int i, int i2) {
            }
        });
    }

    public void ayl() {
        if (this.dAj && this.mNavigationBar != null && this.dAg != null && this.dAg.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bnc.setExcludeHeight(0);
            if (this.dAi != null) {
                this.dAi.ayi();
            }
            this.dAg.ays();
        }
    }

    public void aym() {
        ViewGroup viewGroup;
        if (!this.dAj && (viewGroup = (ViewGroup) this.bnc.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dAg = new BlankView(this.bnc.getPageContext().getPageActivity());
            this.dAg.setBackgroundResource(f.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dAg, 0, new LinearLayout.LayoutParams(-1, dAh));
            this.dAg.setVisibility(0);
            this.dAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bnc.finish();
                }
            });
            this.dAg.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void ayo() {
                    if (c.this.dAg != null) {
                        c.this.dAg.setVisibility(8);
                    }
                    c.this.dAj = false;
                    if (c.this.dAi != null) {
                        c.this.dAi.ayj();
                    }
                }
            });
            this.bnc.setExcludeHeight(dAh);
            this.dAj = true;
        }
    }

    public void a(a aVar) {
        this.dAi = aVar;
    }

    public boolean ayn() {
        return this.dAj;
    }

    public void lg(int i) {
        if (this.dAg != null) {
            am.i(this.dAg, i);
        }
    }
}
