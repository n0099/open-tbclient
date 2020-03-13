package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private static final int fgv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fgw = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fgx = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fgy = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private int fgA;
    private int fgB;
    private FrameLayout fgC;
    private NoScrollGridView fgD;
    private com.baidu.tieba.ala.liveroom.master.panel.a fgE;
    private a fgF;
    private a.InterfaceC0463a fgs;
    private boolean fgz;

    /* loaded from: classes3.dex */
    public interface a {
        void boK();

        void boL();

        void boM();

        void boN();

        void jD(boolean z);

        void jE(boolean z);

        void jF(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fgB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fgs = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0463a
            public void z(int i, boolean z2) {
                if (b.this.fgF != null) {
                    if (i == 1) {
                        b.this.fgF.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fgF.jD(z2);
                    } else if (i == 3) {
                        b.this.fgF.jE(z2);
                    } else if (i == 4) {
                        b.this.fgF.jF(z2);
                    } else if (i == 5) {
                        b.this.fgF.boK();
                    } else if (i == 6) {
                        b.this.fgF.boL();
                    } else if (i == 7) {
                        b.this.fgF.boM();
                    } else if (i == 8) {
                        b.this.fgF.boN();
                    }
                }
            }
        };
        this.fgz = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fgE = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fgE.a(this.fgs);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        boR();
        boQ();
    }

    private void boQ() {
        this.fgC.addView(this.fgD);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fgA;
        layoutParams.leftMargin = this.fgB;
        layoutParams.rightMargin = this.fgB;
        this.fgC.addView(view, layoutParams);
        setContentView(this.fgC);
    }

    public void a(a aVar) {
        this.fgF = aVar;
    }

    private void createView() {
        this.fgC = new FrameLayout(getContext());
        this.fgD = new NoScrollGridView(getContext());
        this.fgD.setAdapter((ListAdapter) this.fgE);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fgD.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void boR() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fgD.setNumColumns(2);
            this.fgD.setPadding(fgv, fgx, navigationBarHeight + fgw, fgx);
            this.fgA = ((this.fgz ? com.baidu.tieba.ala.liveroom.master.panel.a.fgo : com.baidu.tieba.ala.liveroom.master.panel.a.fgo * 2) + fgx) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fgz) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fgD.setNumColumns(4);
            this.fgD.setPadding(fgy, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fgy, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jG(boolean z) {
        this.fgE.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgE.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgE.a(3, s);
    }

    public void jH(boolean z) {
        this.fgE.a(4, z ? (short) 1 : (short) 2);
    }

    public void boS() {
        this.fgE.notifyDataSetChanged();
    }
}
