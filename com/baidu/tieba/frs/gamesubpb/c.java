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
    private com.baidu.tieba.f.b bKb;
    private BaseActivity bmZ;
    private BlankView dAj;
    private a dAl;
    private boolean dAm = false;
    private View.OnTouchListener dAn;
    private NavigationBar mNavigationBar;
    private static final int dAk = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void ayk();

        void ayl();

        boolean aym();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmZ = baseActivity;
        this.bKb = new com.baidu.tieba.f.b(this.bmZ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dAn = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bKb.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bKb.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bKb.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Y(int i, int i2) {
                if (c.this.dAl != null && c.this.dAl.aym() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dAj != null) {
                        c.this.dAj.setBackgroundResource(d.C0140d.transparent);
                    }
                    c.this.bmZ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Z(int i, int i2) {
                c.this.ayn();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void aa(int i, int i2) {
            }
        });
    }

    public void ayn() {
        if (this.dAm && this.mNavigationBar != null && this.dAj != null && this.dAj.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmZ.setExcludeHeight(0);
            if (this.dAl != null) {
                this.dAl.ayk();
            }
            this.dAj.ayu();
        }
    }

    public void ayo() {
        ViewGroup viewGroup;
        if (!this.dAm && (viewGroup = (ViewGroup) this.bmZ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dAj = new BlankView(this.bmZ.getPageContext().getPageActivity());
            this.dAj.setBackgroundResource(d.C0140d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dAj, 0, new LinearLayout.LayoutParams(-1, dAk));
            this.dAj.setVisibility(0);
            this.dAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bmZ.finish();
                }
            });
            this.dAj.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void ayq() {
                    if (c.this.dAj != null) {
                        c.this.dAj.setVisibility(8);
                    }
                    c.this.dAm = false;
                    if (c.this.dAl != null) {
                        c.this.dAl.ayl();
                    }
                }
            });
            this.bmZ.setExcludeHeight(dAk);
            this.dAm = true;
        }
    }

    public void a(a aVar) {
        this.dAl = aVar;
    }

    public boolean ayp() {
        return this.dAm;
    }

    public void lh(int i) {
        if (this.dAj != null) {
            am.i(this.dAj, i);
        }
    }
}
