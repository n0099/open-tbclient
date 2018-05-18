package com.baidu.tieba.frs.gamesubpb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
/* loaded from: classes3.dex */
public class c {
    private BaseActivity bcK;
    private com.baidu.tieba.f.b bzr;
    private BlankView dla;
    private a dlc;
    private boolean dld = false;
    private View.OnTouchListener dle;
    private NavigationBar mNavigationBar;
    private static final int dlb = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void asV();

        void asW();

        boolean asX();
    }

    public c(BaseActivity baseActivity, View view2, NavigationBar navigationBar) {
        this.bcK = baseActivity;
        this.bzr = new com.baidu.tieba.f.b(this.bcK.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dle = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                c.this.bzr.onTouchEvent(motionEvent);
                return true;
            }
        };
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                c.this.bzr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bzr.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void W(int i, int i2) {
                if (c.this.dlc != null && c.this.dlc.asX() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.dla != null) {
                        c.this.dla.setBackgroundResource(d.C0126d.transparent);
                    }
                    c.this.bcK.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void X(int i, int i2) {
                c.this.asY();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void Y(int i, int i2) {
            }
        });
    }

    public void asY() {
        if (this.dld && this.mNavigationBar != null && this.dla != null && this.dla.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcK.setExcludeHeight(0);
            if (this.dlc != null) {
                this.dlc.asV();
            }
            this.dla.atf();
        }
    }

    public void asZ() {
        ViewGroup viewGroup;
        if (!this.dld && (viewGroup = (ViewGroup) this.bcK.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.dla = new BlankView(this.bcK.getPageContext().getPageActivity());
            this.dla.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.dla, 0, new LinearLayout.LayoutParams(-1, dlb));
            this.dla.setVisibility(0);
            this.dla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bcK.finish();
                }
            });
            this.dla.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void atb() {
                    if (c.this.dla != null) {
                        c.this.dla.setVisibility(8);
                    }
                    c.this.dld = false;
                    if (c.this.dlc != null) {
                        c.this.dlc.asW();
                    }
                }
            });
            this.bcK.setExcludeHeight(dlb);
            this.dld = true;
        }
    }

    public void a(a aVar) {
        this.dlc = aVar;
    }

    public boolean ata() {
        return this.dld;
    }

    public void kK(int i) {
        if (this.dla != null) {
            ak.i(this.dla, i);
        }
    }
}
