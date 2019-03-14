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
    private BaseActivity cNa;
    private com.baidu.tieba.f.b dMr;
    private BlankView fnu;
    private a fnw;
    private boolean fnx = false;
    private View.OnTouchListener fny;
    private NavigationBar mNavigationBar;
    private static final int fnv = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bgB();

        void bgC();

        boolean bgD();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cNa = baseActivity;
        this.dMr = new com.baidu.tieba.f.b(this.cNa.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fny = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dMr.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dMr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dMr.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aR(int i, int i2) {
                if (c.this.fnw != null && c.this.fnw.bgD() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fnu != null) {
                        c.this.fnu.setBackgroundResource(d.C0277d.transparent);
                    }
                    c.this.cNa.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aS(int i, int i2) {
                c.this.bgE();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aT(int i, int i2) {
            }
        });
    }

    public void bgE() {
        if (this.fnx && this.mNavigationBar != null && this.fnu != null && this.fnu.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cNa.setExcludeHeight(0);
            if (this.fnw != null) {
                this.fnw.bgB();
            }
            this.fnu.bgL();
        }
    }

    public void bgF() {
        ViewGroup viewGroup;
        if (!this.fnx && (viewGroup = (ViewGroup) this.cNa.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fnu = new BlankView(this.cNa.getPageContext().getPageActivity());
            this.fnu.setBackgroundResource(d.C0277d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fnu, 0, new LinearLayout.LayoutParams(-1, fnv));
            this.fnu.setVisibility(0);
            this.fnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cNa.finish();
                }
            });
            this.fnu.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bgH() {
                    if (c.this.fnu != null) {
                        c.this.fnu.setVisibility(8);
                    }
                    c.this.fnx = false;
                    if (c.this.fnw != null) {
                        c.this.fnw.bgC();
                    }
                }
            });
            this.cNa.setExcludeHeight(fnv);
            this.fnx = true;
        }
    }

    public void a(a aVar) {
        this.fnw = aVar;
    }

    public boolean bgG() {
        return this.fnx;
    }

    public void qP(int i) {
        if (this.fnu != null) {
            al.k(this.fnu, i);
        }
    }
}
