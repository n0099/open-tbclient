package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private int fZA;
    private FrameLayout fZB;
    private NoScrollGridView fZC;
    private com.baidu.tieba.ala.liveroom.master.panel.a fZD;
    private a fZE;
    public final int fZn;
    private a.InterfaceC0566a fZr;
    private final int fZu;
    private final int fZv;
    private final int fZw;
    private final int fZx;
    private boolean fZy;
    private int fZz;

    /* loaded from: classes3.dex */
    public interface a {
        void bEk();

        void bEl();

        void bEm();

        void bEn();

        void lb(boolean z);

        void lc(boolean z);

        void ld(boolean z);

        void le(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fZn = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.fZu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.fZv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.fZw = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.fZx = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.fZA = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fZr = new a.InterfaceC0566a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0566a
            public void F(int i, boolean z2) {
                if (b.this.fZE != null) {
                    if (i == 1) {
                        b.this.fZE.lb(z2);
                    } else if (i == 2) {
                        b.this.fZE.lc(z2);
                    } else if (i == 3) {
                        b.this.fZE.ld(z2);
                    } else if (i == 4) {
                        b.this.fZE.le(z2);
                    } else if (i == 5) {
                        b.this.fZE.bEk();
                    } else if (i == 6) {
                        b.this.fZE.bEl();
                    } else if (i == 7) {
                        b.this.fZE.bEm();
                    } else if (i == 8) {
                        b.this.fZE.bEn();
                    }
                }
            }
        };
        this.fZy = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fZD = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fZD.a(this.fZr);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bEt();
        bEs();
    }

    private void bEs() {
        this.fZB.addView(this.fZC);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fZz;
        layoutParams.leftMargin = this.fZA;
        layoutParams.rightMargin = this.fZA;
        this.fZB.addView(view, layoutParams);
        setContentView(this.fZB);
    }

    public void a(a aVar) {
        this.fZE = aVar;
    }

    private void createView() {
        this.fZB = new FrameLayout(getContext());
        this.fZC = new NoScrollGridView(getContext());
        this.fZC.setAdapter((ListAdapter) this.fZD);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fZC.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bEt() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fZC.setNumColumns(2);
            this.fZC.setPadding(this.fZu, this.fZw, navigationBarHeight + this.fZv, this.fZw);
            this.fZz = ((this.fZy ? this.fZn : this.fZn * 2) + this.fZw) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fZy) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fZC.setNumColumns(4);
            this.fZC.setPadding(this.fZx, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.fZx, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void lf(boolean z) {
        this.fZD.a(1, z ? (short) 1 : (short) 2);
    }

    public void I(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fZD.a(2, s);
    }

    public void J(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fZD.a(3, s);
    }

    public void lg(boolean z) {
        this.fZD.a(4, z ? (short) 1 : (short) 2);
    }

    public void bEu() {
        this.fZD.notifyDataSetChanged();
    }
}
