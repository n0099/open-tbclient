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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes4.dex */
public class c {
    private BaseActivity cNc;
    private com.baidu.tieba.f.b dLI;
    private BlankView fng;
    private a fni;
    private boolean fnj = false;
    private View.OnTouchListener fnk;
    private NavigationBar mNavigationBar;
    private static final int fnh = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bgA();

        boolean bgB();

        void bgz();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cNc = baseActivity;
        this.dLI = new com.baidu.tieba.f.b(this.cNc.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fnk = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dLI.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dLI.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dLI.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aR(int i, int i2) {
                if (c.this.fni != null && c.this.fni.bgB() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fng != null) {
                        c.this.fng.setBackgroundResource(d.C0277d.transparent);
                    }
                    c.this.cNc.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aS(int i, int i2) {
                c.this.bgC();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aT(int i, int i2) {
            }
        });
    }

    public void bgC() {
        if (this.fnj && this.mNavigationBar != null && this.fng != null && this.fng.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cNc.setExcludeHeight(0);
            if (this.fni != null) {
                this.fni.bgz();
            }
            this.fng.bgJ();
        }
    }

    public void bgD() {
        ViewGroup viewGroup;
        if (!this.fnj && (viewGroup = (ViewGroup) this.cNc.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fng = new BlankView(this.cNc.getPageContext().getPageActivity());
            this.fng.setBackgroundResource(d.C0277d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fng, 0, new LinearLayout.LayoutParams(-1, fnh));
            this.fng.setVisibility(0);
            this.fng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cNc.finish();
                }
            });
            this.fng.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bgF() {
                    if (c.this.fng != null) {
                        c.this.fng.setVisibility(8);
                    }
                    c.this.fnj = false;
                    if (c.this.fni != null) {
                        c.this.fni.bgA();
                    }
                }
            });
            this.cNc.setExcludeHeight(fnh);
            this.fnj = true;
        }
    }

    public void a(a aVar) {
        this.fni = aVar;
    }

    public boolean bgE() {
        return this.fnj;
    }

    public void qL(int i) {
        if (this.fng != null) {
            al.k(this.fng, i);
        }
    }
}
