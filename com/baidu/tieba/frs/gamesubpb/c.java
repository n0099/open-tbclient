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
    private com.baidu.tieba.f.b bYq;
    private BaseActivity bwX;
    private BlankView dOP;
    private a dOR;
    private boolean dOS = false;
    private View.OnTouchListener dOT;
    private NavigationBar mNavigationBar;
    private static final int dOQ = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void aDQ();

        void aDR();

        boolean aDS();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bwX = baseActivity;
        this.bYq = new com.baidu.tieba.f.b(this.bwX.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dOT = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bYq.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.bYq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bYq.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void af(int i, int i2) {
                if (c.this.dOR != null && c.this.dOR.aDS() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dOP != null) {
                        c.this.dOP.setBackgroundResource(e.d.transparent);
                    }
                    c.this.bwX.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ag(int i, int i2) {
                c.this.aDT();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ah(int i, int i2) {
            }
        });
    }

    public void aDT() {
        if (this.dOS && this.mNavigationBar != null && this.dOP != null && this.dOP.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bwX.setExcludeHeight(0);
            if (this.dOR != null) {
                this.dOR.aDQ();
            }
            this.dOP.aEa();
        }
    }

    public void aDU() {
        ViewGroup viewGroup;
        if (!this.dOS && (viewGroup = (ViewGroup) this.bwX.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dOP = new BlankView(this.bwX.getPageContext().getPageActivity());
            this.dOP.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dOP, 0, new LinearLayout.LayoutParams(-1, dOQ));
            this.dOP.setVisibility(0);
            this.dOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.bwX.finish();
                }
            });
            this.dOP.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void aDW() {
                    if (c.this.dOP != null) {
                        c.this.dOP.setVisibility(8);
                    }
                    c.this.dOS = false;
                    if (c.this.dOR != null) {
                        c.this.dOR.aDR();
                    }
                }
            });
            this.bwX.setExcludeHeight(dOQ);
            this.dOS = true;
        }
    }

    public void a(a aVar) {
        this.dOR = aVar;
    }

    public boolean aDV() {
        return this.dOS;
    }

    public void mh(int i) {
        if (this.dOP != null) {
            al.i(this.dOP, i);
        }
    }
}
