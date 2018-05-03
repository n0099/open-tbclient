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
    private BaseActivity bcJ;
    private com.baidu.tieba.f.b byy;
    private BlankView djT;
    private a djV;
    private boolean djW = false;
    private View.OnTouchListener djX;
    private NavigationBar mNavigationBar;
    private static final int djU = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes3.dex */
    public interface a {
        void asW();

        void asX();

        boolean asY();
    }

    public c(BaseActivity baseActivity, View view2, NavigationBar navigationBar) {
        this.bcJ = baseActivity;
        this.byy = new com.baidu.tieba.f.b(this.bcJ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.djX = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                c.this.byy.onTouchEvent(motionEvent);
                return true;
            }
        };
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                c.this.byy.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.byy.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.gamesubpb.c.3
            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void W(int i, int i2) {
                if (c.this.djV != null && c.this.djV.asY() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.djT != null) {
                        c.this.djT.setBackgroundResource(d.C0126d.transparent);
                    }
                    c.this.bcJ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void X(int i, int i2) {
                c.this.asZ();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void Y(int i, int i2) {
            }
        });
    }

    public void asZ() {
        if (this.djW && this.mNavigationBar != null && this.djT != null && this.djT.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcJ.setExcludeHeight(0);
            if (this.djV != null) {
                this.djV.asW();
            }
            this.djT.atg();
        }
    }

    public void ata() {
        ViewGroup viewGroup;
        if (!this.djW && (viewGroup = (ViewGroup) this.bcJ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.djT = new BlankView(this.bcJ.getPageContext().getPageActivity());
            this.djT.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.djT, 0, new LinearLayout.LayoutParams(-1, djU));
            this.djT.setVisibility(0);
            this.djT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bcJ.finish();
                }
            });
            this.djT.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void atc() {
                    if (c.this.djT != null) {
                        c.this.djT.setVisibility(8);
                    }
                    c.this.djW = false;
                    if (c.this.djV != null) {
                        c.this.djV.asX();
                    }
                }
            });
            this.bcJ.setExcludeHeight(djU);
            this.djW = true;
        }
    }

    public void a(a aVar) {
        this.djV = aVar;
    }

    public boolean atb() {
        return this.djW;
    }

    public void kL(int i) {
        if (this.djT != null) {
            ak.i(this.djT, i);
        }
    }
}
