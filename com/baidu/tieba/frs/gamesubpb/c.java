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
    private BaseActivity cWM;
    private com.baidu.tieba.f.b eab;
    private BlankView fIA;
    private a fIC;
    private boolean fID = false;
    private View.OnTouchListener fIE;
    private NavigationBar mNavigationBar;
    private static final int fIB = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bpU();

        void bpV();

        boolean bpW();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cWM = baseActivity;
        this.eab = new com.baidu.tieba.f.b(this.cWM.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fIE = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.eab.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.eab.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eab.a(new a.InterfaceC0299a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void aY(int i, int i2) {
                if (c.this.fIC != null && c.this.fIC.bpW() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fIA != null) {
                        c.this.fIA.setBackgroundResource(R.color.transparent);
                    }
                    c.this.cWM.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void aZ(int i, int i2) {
                c.this.bpX();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void ba(int i, int i2) {
            }
        });
    }

    public void bpX() {
        if (this.fID && this.mNavigationBar != null && this.fIA != null && this.fIA.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cWM.setExcludeHeight(0);
            if (this.fIC != null) {
                this.fIC.bpU();
            }
            this.fIA.bqe();
        }
    }

    public void bpY() {
        ViewGroup viewGroup;
        if (!this.fID && (viewGroup = (ViewGroup) this.cWM.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fIA = new BlankView(this.cWM.getPageContext().getPageActivity());
            this.fIA.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fIA, 0, new LinearLayout.LayoutParams(-1, fIB));
            this.fIA.setVisibility(0);
            this.fIA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cWM.finish();
                }
            });
            this.fIA.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bqa() {
                    if (c.this.fIA != null) {
                        c.this.fIA.setVisibility(8);
                    }
                    c.this.fID = false;
                    if (c.this.fIC != null) {
                        c.this.fIC.bpV();
                    }
                }
            });
            this.cWM.setExcludeHeight(fIB);
            this.fID = true;
        }
    }

    public void a(a aVar) {
        this.fIC = aVar;
    }

    public boolean bpZ() {
        return this.fID;
    }

    public void sl(int i) {
        if (this.fIA != null) {
            am.k(this.fIA, i);
        }
    }
}
