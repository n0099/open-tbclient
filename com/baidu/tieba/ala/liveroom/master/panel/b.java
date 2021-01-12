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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes10.dex */
public class b extends Dialog {
    private final int hEA;
    private final int hEB;
    private final int hEC;
    private final int hED;
    private boolean hEE;
    private int hEF;
    private int hEG;
    private FrameLayout hEH;
    private NoScrollGridView hEI;
    private com.baidu.tieba.ala.liveroom.master.panel.a hEJ;
    private a hEK;
    public final int hEu;
    private a.InterfaceC0668a hEy;

    /* loaded from: classes10.dex */
    public interface a {
        void chw();

        void chx();

        void chy();

        void chz();

        void or(boolean z);

        void os(boolean z);

        void ot(boolean z);

        void ou(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hEu = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hEA = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hEB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hEC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hED = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hEG = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hEy = new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0668a
            public void L(int i, boolean z2) {
                if (b.this.hEK != null) {
                    if (i == 1) {
                        b.this.hEK.or(z2);
                    } else if (i == 2) {
                        b.this.hEK.os(z2);
                    } else if (i == 3) {
                        b.this.hEK.ot(z2);
                    } else if (i == 4) {
                        b.this.hEK.ou(z2);
                    } else if (i == 5) {
                        b.this.hEK.chw();
                    } else if (i == 6) {
                        b.this.hEK.chx();
                    } else if (i == 7) {
                        b.this.hEK.chy();
                    } else if (i == 8) {
                        b.this.hEK.chz();
                    }
                }
            }
        };
        this.hEE = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hEJ = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hEJ.a(this.hEy);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        chH();
        chG();
    }

    private void chG() {
        this.hEH.addView(this.hEI);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hEF;
        layoutParams.leftMargin = this.hEG;
        layoutParams.rightMargin = this.hEG;
        this.hEH.addView(view, layoutParams);
        setContentView(this.hEH);
    }

    public void a(a aVar) {
        this.hEK = aVar;
    }

    private void createView() {
        this.hEH = new FrameLayout(getContext());
        this.hEI = new NoScrollGridView(getContext());
        this.hEI.setAdapter((ListAdapter) this.hEJ);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hEI.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void chH() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = m.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hEI.setNumColumns(2);
            this.hEI.setPadding(this.hEA, this.hEC, navigationBarHeight + this.hEB, this.hEC);
            this.hEF = ((this.hEE ? this.hEu : this.hEu * 2) + this.hEC) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hEE) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hEI.setNumColumns(4);
            this.hEI.setPadding(this.hED, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hED, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setIsBackCamera(boolean z) {
        this.hEJ.a(1, z ? (short) 1 : (short) 2);
    }

    public void S(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hEJ.a(2, s);
    }

    public void T(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hEJ.a(3, s);
    }

    public void ov(boolean z) {
        this.hEJ.a(4, z ? (short) 1 : (short) 2);
    }

    public void chI() {
        this.hEJ.notifyDataSetChanged();
    }
}
