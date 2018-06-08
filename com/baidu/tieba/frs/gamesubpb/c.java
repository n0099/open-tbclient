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
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.f.b bHu;
    private BaseActivity bkU;
    private BlankView duo;
    private a duq;
    private boolean dur = false;
    private View.OnTouchListener dus;
    private NavigationBar mNavigationBar;
    private static final int dup = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void axb();

        void axc();

        boolean axd();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bkU = baseActivity;
        this.bHu = new com.baidu.tieba.f.b(this.bkU.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dus = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bHu.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bHu.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bHu.a(new a.InterfaceC0146a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void X(int i, int i2) {
                if (c.this.duq != null && c.this.duq.axd() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.duo != null) {
                        c.this.duo.setBackgroundResource(d.C0141d.transparent);
                    }
                    c.this.bkU.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Y(int i, int i2) {
                c.this.axe();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Z(int i, int i2) {
            }
        });
    }

    public void axe() {
        if (this.dur && this.mNavigationBar != null && this.duo != null && this.duo.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bkU.setExcludeHeight(0);
            if (this.duq != null) {
                this.duq.axb();
            }
            this.duo.axl();
        }
    }

    public void axf() {
        ViewGroup viewGroup;
        if (!this.dur && (viewGroup = (ViewGroup) this.bkU.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.duo = new BlankView(this.bkU.getPageContext().getPageActivity());
            this.duo.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.duo, 0, new LinearLayout.LayoutParams(-1, dup));
            this.duo.setVisibility(0);
            this.duo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bkU.finish();
                }
            });
            this.duo.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void axh() {
                    if (c.this.duo != null) {
                        c.this.duo.setVisibility(8);
                    }
                    c.this.dur = false;
                    if (c.this.duq != null) {
                        c.this.duq.axc();
                    }
                }
            });
            this.bkU.setExcludeHeight(dup);
            this.dur = true;
        }
    }

    public void a(a aVar) {
        this.duq = aVar;
    }

    public boolean axg() {
        return this.dur;
    }

    public void kP(int i) {
        if (this.duo != null) {
            al.i(this.duo, i);
        }
    }
}
