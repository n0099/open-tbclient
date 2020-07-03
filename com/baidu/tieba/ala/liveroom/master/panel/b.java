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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private NoScrollGridView gmA;
    private com.baidu.tieba.ala.liveroom.master.panel.a gmB;
    private a gmC;
    public final int gmm;
    private a.InterfaceC0575a gmq;
    private final int gms;
    private final int gmt;
    private final int gmu;
    private final int gmv;
    private boolean gmw;
    private int gmx;
    private int gmy;
    private FrameLayout gmz;

    /* loaded from: classes3.dex */
    public interface a {
        void bHq();

        void bHr();

        void bHs();

        void bHt();

        void ll(boolean z);

        void lm(boolean z);

        void ln(boolean z);

        void lo(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.gmm = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.gms = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.gmt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.gmu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.gmv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.gmy = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gmq = new a.InterfaceC0575a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0575a
            public void H(int i, boolean z2) {
                if (b.this.gmC != null) {
                    if (i == 1) {
                        b.this.gmC.ll(z2);
                    } else if (i == 2) {
                        b.this.gmC.lm(z2);
                    } else if (i == 3) {
                        b.this.gmC.ln(z2);
                    } else if (i == 4) {
                        b.this.gmC.lo(z2);
                    } else if (i == 5) {
                        b.this.gmC.bHq();
                    } else if (i == 6) {
                        b.this.gmC.bHr();
                    } else if (i == 7) {
                        b.this.gmC.bHs();
                    } else if (i == 8) {
                        b.this.gmC.bHt();
                    }
                }
            }
        };
        this.gmw = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.gmB = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.gmB.a(this.gmq);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bHz();
        bHy();
    }

    private void bHy() {
        this.gmz.addView(this.gmA);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.gmx;
        layoutParams.leftMargin = this.gmy;
        layoutParams.rightMargin = this.gmy;
        this.gmz.addView(view, layoutParams);
        setContentView(this.gmz);
    }

    public void a(a aVar) {
        this.gmC = aVar;
    }

    private void createView() {
        this.gmz = new FrameLayout(getContext());
        this.gmA = new NoScrollGridView(getContext());
        this.gmA.setAdapter((ListAdapter) this.gmB);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gmA.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bHz() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gmA.setNumColumns(2);
            this.gmA.setPadding(this.gms, this.gmu, navigationBarHeight + this.gmt, this.gmu);
            this.gmx = ((this.gmw ? this.gmm : this.gmm * 2) + this.gmu) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gmw) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gmA.setNumColumns(4);
            this.gmA.setPadding(this.gmv, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.gmv, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void lp(boolean z) {
        this.gmB.a(1, z ? (short) 1 : (short) 2);
    }

    public void J(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gmB.a(2, s);
    }

    public void K(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gmB.a(3, s);
    }

    public void lq(boolean z) {
        this.gmB.a(4, z ? (short) 1 : (short) 2);
    }

    public void bHA() {
        this.gmB.notifyDataSetChanged();
    }
}
