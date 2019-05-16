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
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes4.dex */
public class c {
    private BaseActivity cVo;
    private com.baidu.tieba.f.b dWi;
    private BlankView fDB;
    private a fDD;
    private boolean fDE = false;
    private View.OnTouchListener fDF;
    private NavigationBar mNavigationBar;
    private static final int fDC = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bnQ();

        void bnR();

        boolean bnS();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cVo = baseActivity;
        this.dWi = new com.baidu.tieba.f.b(this.cVo.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fDF = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dWi.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.dWi.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dWi.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aT(int i, int i2) {
                if (c.this.fDD != null && c.this.fDD.bnS() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fDB != null) {
                        c.this.fDB.setBackgroundResource(R.color.transparent);
                    }
                    c.this.cVo.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aU(int i, int i2) {
                c.this.bnT();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aV(int i, int i2) {
            }
        });
    }

    public void bnT() {
        if (this.fDE && this.mNavigationBar != null && this.fDB != null && this.fDB.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cVo.setExcludeHeight(0);
            if (this.fDD != null) {
                this.fDD.bnQ();
            }
            this.fDB.boa();
        }
    }

    public void bnU() {
        ViewGroup viewGroup;
        if (!this.fDE && (viewGroup = (ViewGroup) this.cVo.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fDB = new BlankView(this.cVo.getPageContext().getPageActivity());
            this.fDB.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fDB, 0, new LinearLayout.LayoutParams(-1, fDC));
            this.fDB.setVisibility(0);
            this.fDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cVo.finish();
                }
            });
            this.fDB.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bnW() {
                    if (c.this.fDB != null) {
                        c.this.fDB.setVisibility(8);
                    }
                    c.this.fDE = false;
                    if (c.this.fDD != null) {
                        c.this.fDD.bnR();
                    }
                }
            });
            this.cVo.setExcludeHeight(fDC);
            this.fDE = true;
        }
    }

    public void a(a aVar) {
        this.fDD = aVar;
    }

    public boolean bnV() {
        return this.fDE;
    }

    public void rT(int i) {
        if (this.fDB != null) {
            al.k(this.fDB, i);
        }
    }
}
