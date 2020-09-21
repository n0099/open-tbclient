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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes4.dex */
public class b extends Dialog {
    public final int gHF;
    private a.InterfaceC0632a gHJ;
    private final int gHL;
    private final int gHM;
    private final int gHN;
    private final int gHO;
    private boolean gHP;
    private int gHQ;
    private int gHR;
    private FrameLayout gHS;
    private NoScrollGridView gHT;
    private com.baidu.tieba.ala.liveroom.master.panel.a gHU;
    private a gHV;

    /* loaded from: classes4.dex */
    public interface a {
        void bWl();

        void bWm();

        void bWn();

        void bWo();

        void mA(boolean z);

        void mB(boolean z);

        void my(boolean z);

        void mz(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.gHF = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.gHL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.gHM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.gHN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.gHO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.gHR = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gHJ = new a.InterfaceC0632a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0632a
            public void J(int i, boolean z2) {
                if (b.this.gHV != null) {
                    if (i == 1) {
                        b.this.gHV.my(z2);
                    } else if (i == 2) {
                        b.this.gHV.mz(z2);
                    } else if (i == 3) {
                        b.this.gHV.mA(z2);
                    } else if (i == 4) {
                        b.this.gHV.mB(z2);
                    } else if (i == 5) {
                        b.this.gHV.bWl();
                    } else if (i == 6) {
                        b.this.gHV.bWm();
                    } else if (i == 7) {
                        b.this.gHV.bWn();
                    } else if (i == 8) {
                        b.this.gHV.bWo();
                    }
                }
            }
        };
        this.gHP = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.gHU = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.gHU.a(this.gHJ);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bWu();
        bWt();
    }

    private void bWt() {
        this.gHS.addView(this.gHT);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.gHQ;
        layoutParams.leftMargin = this.gHR;
        layoutParams.rightMargin = this.gHR;
        this.gHS.addView(view, layoutParams);
        setContentView(this.gHS);
    }

    public void a(a aVar) {
        this.gHV = aVar;
    }

    private void createView() {
        this.gHS = new FrameLayout(getContext());
        this.gHT = new NoScrollGridView(getContext());
        this.gHT.setAdapter((ListAdapter) this.gHU);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gHT.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bWu() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gHT.setNumColumns(2);
            this.gHT.setPadding(this.gHL, this.gHN, navigationBarHeight + this.gHM, this.gHN);
            this.gHQ = ((this.gHP ? this.gHF : this.gHF * 2) + this.gHN) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gHP) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gHT.setNumColumns(4);
            this.gHT.setPadding(this.gHO, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.gHO, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void mC(boolean z) {
        this.gHU.a(1, z ? (short) 1 : (short) 2);
    }

    public void N(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gHU.a(2, s);
    }

    public void O(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gHU.a(3, s);
    }

    public void mD(boolean z) {
        this.gHU.a(4, z ? (short) 1 : (short) 2);
    }

    public void bWv() {
        this.gHU.notifyDataSetChanged();
    }
}
