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
    private BaseActivity bBf;
    private com.baidu.tieba.f.b cvK;
    private BlankView dWu;
    private a dWw;
    private boolean dWx = false;
    private View.OnTouchListener dWy;
    private NavigationBar mNavigationBar;
    private static final int dWv = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aEX();

        void aEY();

        boolean aEZ();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBf = baseActivity;
        this.cvK = new com.baidu.tieba.f.b(this.bBf.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dWy = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cvK.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.cvK.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cvK.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void aq(int i, int i2) {
                if (c.this.dWw != null && c.this.dWw.aEZ() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dWu != null) {
                        c.this.dWu.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bBf.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                c.this.aFa();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
            }
        });
    }

    public void aFa() {
        if (this.dWx && this.mNavigationBar != null && this.dWu != null && this.dWu.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBf.setExcludeHeight(0);
            if (this.dWw != null) {
                this.dWw.aEX();
            }
            this.dWu.aFh();
        }
    }

    public void aFb() {
        ViewGroup viewGroup;
        if (!this.dWx && (viewGroup = (ViewGroup) this.bBf.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dWu = new BlankView(this.bBf.getPageContext().getPageActivity());
            this.dWu.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dWu, 0, new LinearLayout.LayoutParams(-1, dWv));
            this.dWu.setVisibility(0);
            this.dWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bBf.finish();
                }
            });
            this.dWu.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aFd() {
                    if (c.this.dWu != null) {
                        c.this.dWu.setVisibility(8);
                    }
                    c.this.dWx = false;
                    if (c.this.dWw != null) {
                        c.this.dWw.aEY();
                    }
                }
            });
            this.bBf.setExcludeHeight(dWv);
            this.dWx = true;
        }
    }

    public void a(a aVar) {
        this.dWw = aVar;
    }

    public boolean aFc() {
        return this.dWx;
    }

    public void mO(int i) {
        if (this.dWu != null) {
            al.i(this.dWu, i);
        }
    }
}
