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
    private BlankView djW;
    private a djY;
    private boolean djZ = false;
    private View.OnTouchListener dka;
    private NavigationBar mNavigationBar;
    private static final int djX = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
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
        this.dka = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.1
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
                if (c.this.djY != null && c.this.djY.asY() && Math.abs(i2) > c.TOUCH_SLOP) {
                    if (c.this.djW != null) {
                        c.this.djW.setBackgroundResource(d.C0126d.transparent);
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
        if (this.djZ && this.mNavigationBar != null && this.djW != null && this.djW.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcJ.setExcludeHeight(0);
            if (this.djY != null) {
                this.djY.asW();
            }
            this.djW.atg();
        }
    }

    public void ata() {
        ViewGroup viewGroup;
        if (!this.djZ && (viewGroup = (ViewGroup) this.bcJ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.djW = new BlankView(this.bcJ.getPageContext().getPageActivity());
            this.djW.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.djW, 0, new LinearLayout.LayoutParams(-1, djX));
            this.djW.setVisibility(0);
            this.djW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.bcJ.finish();
                }
            });
            this.djW.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.frs.gamesubpb.c.5
                @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
                public void atc() {
                    if (c.this.djW != null) {
                        c.this.djW.setVisibility(8);
                    }
                    c.this.djZ = false;
                    if (c.this.djY != null) {
                        c.this.djY.asX();
                    }
                }
            });
            this.bcJ.setExcludeHeight(djX);
            this.djZ = true;
        }
    }

    public void a(a aVar) {
        this.djY = aVar;
    }

    public boolean atb() {
        return this.djZ;
    }

    public void kL(int i) {
        if (this.djW != null) {
            ak.i(this.djW, i);
        }
    }
}
