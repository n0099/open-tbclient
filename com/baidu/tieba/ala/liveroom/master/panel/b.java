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
    public final int hKD;
    private a.InterfaceC0676a hKH;
    private final int hKJ;
    private final int hKK;
    private final int hKL;
    private final int hKM;
    private boolean hKN;
    private int hKO;
    private int hKP;
    private FrameLayout hKQ;
    private NoScrollGridView hKR;
    private com.baidu.tieba.ala.liveroom.master.panel.a hKS;
    private a hKT;

    /* loaded from: classes10.dex */
    public interface a {
        void ciC();

        void ciD();

        void ciE();

        void ciF();

        void oB(boolean z);

        void oC(boolean z);

        void oD(boolean z);

        void oE(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hKD = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hKJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hKK = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hKL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hKM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hKP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hKH = new a.InterfaceC0676a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0676a
            public void L(int i, boolean z2) {
                if (b.this.hKT != null) {
                    if (i == 1) {
                        b.this.hKT.oB(z2);
                    } else if (i == 2) {
                        b.this.hKT.oC(z2);
                    } else if (i == 3) {
                        b.this.hKT.oD(z2);
                    } else if (i == 4) {
                        b.this.hKT.oE(z2);
                    } else if (i == 5) {
                        b.this.hKT.ciC();
                    } else if (i == 6) {
                        b.this.hKT.ciD();
                    } else if (i == 7) {
                        b.this.hKT.ciE();
                    } else if (i == 8) {
                        b.this.hKT.ciF();
                    }
                }
            }
        };
        this.hKN = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hKS = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hKS.a(this.hKH);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ciN();
        ciM();
    }

    private void ciM() {
        this.hKQ.addView(this.hKR);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hKO;
        layoutParams.leftMargin = this.hKP;
        layoutParams.rightMargin = this.hKP;
        this.hKQ.addView(view, layoutParams);
        setContentView(this.hKQ);
    }

    public void a(a aVar) {
        this.hKT = aVar;
    }

    private void createView() {
        this.hKQ = new FrameLayout(getContext());
        this.hKR = new NoScrollGridView(getContext());
        this.hKR.setAdapter((ListAdapter) this.hKS);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hKR.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ciN() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = m.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hKR.setNumColumns(2);
            this.hKR.setPadding(this.hKJ, this.hKL, navigationBarHeight + this.hKK, this.hKL);
            this.hKO = ((this.hKN ? this.hKD : this.hKD * 2) + this.hKL) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hKN) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hKR.setNumColumns(4);
            this.hKR.setPadding(this.hKM, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hKM, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setIsBackCamera(boolean z) {
        this.hKS.a(1, z ? (short) 1 : (short) 2);
    }

    public void S(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hKS.a(2, s);
    }

    public void T(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hKS.a(3, s);
    }

    public void oF(boolean z) {
        this.hKS.a(4, z ? (short) 1 : (short) 2);
    }

    public void ciO() {
        this.hKS.notifyDataSetChanged();
    }
}
