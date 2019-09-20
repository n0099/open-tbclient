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
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes4.dex */
public class c {
    private BaseActivity cXM;
    private com.baidu.tieba.f.b ebS;
    private BlankView fLd;
    private a fLf;
    private boolean fLg = false;
    private View.OnTouchListener fLh;
    private NavigationBar mNavigationBar;
    private static final int fLe = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bqT();

        void bqU();

        boolean bqV();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cXM = baseActivity;
        this.ebS = new com.baidu.tieba.f.b(this.cXM.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fLh = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.ebS.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.ebS.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ebS.a(new a.InterfaceC0316a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aY(int i, int i2) {
                if (c.this.fLf != null && c.this.fLf.bqV() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fLd != null) {
                        c.this.fLd.setBackgroundResource(R.color.transparent);
                    }
                    c.this.cXM.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aZ(int i, int i2) {
                c.this.bqW();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void ba(int i, int i2) {
            }
        });
    }

    public void bqW() {
        if (this.fLg && this.mNavigationBar != null && this.fLd != null && this.fLd.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cXM.setExcludeHeight(0);
            if (this.fLf != null) {
                this.fLf.bqT();
            }
            this.fLd.brd();
        }
    }

    public void bqX() {
        ViewGroup viewGroup;
        if (!this.fLg && (viewGroup = (ViewGroup) this.cXM.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fLd = new BlankView(this.cXM.getPageContext().getPageActivity());
            this.fLd.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fLd, 0, new LinearLayout.LayoutParams(-1, fLe));
            this.fLd.setVisibility(0);
            this.fLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cXM.finish();
                }
            });
            this.fLd.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bqZ() {
                    if (c.this.fLd != null) {
                        c.this.fLd.setVisibility(8);
                    }
                    c.this.fLg = false;
                    if (c.this.fLf != null) {
                        c.this.fLf.bqU();
                    }
                }
            });
            this.cXM.setExcludeHeight(fLe);
            this.fLg = true;
        }
    }

    public void a(a aVar) {
        this.fLf = aVar;
    }

    public boolean bqY() {
        return this.fLg;
    }

    public void sr(int i) {
        if (this.fLd != null) {
            am.k(this.fLd, i);
        }
    }
}
