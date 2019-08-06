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
    private BaseActivity cWT;
    private com.baidu.tieba.f.b eai;
    private BlankView fJo;
    private a fJq;
    private boolean fJr = false;
    private View.OnTouchListener fJs;
    private NavigationBar mNavigationBar;
    private static final int fJp = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* loaded from: classes4.dex */
    public interface a {
        void bqh();

        void bqi();

        boolean bqj();
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cWT = baseActivity;
        this.eai = new com.baidu.tieba.f.b(this.cWT.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fJs = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.eai.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.eai.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eai.a(new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i, int i2) {
                if (c.this.fJq != null && c.this.fJq.bqj() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.fJo != null) {
                        c.this.fJo.setBackgroundResource(R.color.transparent);
                    }
                    c.this.cWT.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i, int i2) {
                c.this.bqk();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i, int i2) {
            }
        });
    }

    public void bqk() {
        if (this.fJr && this.mNavigationBar != null && this.fJo != null && this.fJo.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cWT.setExcludeHeight(0);
            if (this.fJq != null) {
                this.fJq.bqh();
            }
            this.fJo.bqr();
        }
    }

    public void bql() {
        ViewGroup viewGroup;
        if (!this.fJr && (viewGroup = (ViewGroup) this.cWT.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fJo = new BlankView(this.cWT.getPageContext().getPageActivity());
            this.fJo.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fJo, 0, new LinearLayout.LayoutParams(-1, fJp));
            this.fJo.setVisibility(0);
            this.fJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.cWT.finish();
                }
            });
            this.fJo.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void bqn() {
                    if (c.this.fJo != null) {
                        c.this.fJo.setVisibility(8);
                    }
                    c.this.fJr = false;
                    if (c.this.fJq != null) {
                        c.this.fJq.bqi();
                    }
                }
            });
            this.cWT.setExcludeHeight(fJp);
            this.fJr = true;
        }
    }

    public void a(a aVar) {
        this.fJq = aVar;
    }

    public boolean bqm() {
        return this.fJr;
    }

    public void sn(int i) {
        if (this.fJo != null) {
            am.k(this.fJo, i);
        }
    }
}
