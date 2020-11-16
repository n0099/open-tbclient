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
    private final int hnA;
    private final int hnB;
    private final int hnC;
    private boolean hnD;
    private int hnE;
    private int hnF;
    private FrameLayout hnG;
    private NoScrollGridView hnH;
    private com.baidu.tieba.ala.liveroom.master.panel.a hnI;
    private a hnJ;
    public final int hnt;
    private a.InterfaceC0680a hnx;
    private final int hnz;

    /* loaded from: classes4.dex */
    public interface a {
        void ceE();

        void ceF();

        void ceG();

        void ceH();

        void nA(boolean z);

        void nB(boolean z);

        void nC(boolean z);

        void nD(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hnt = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hnz = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hnA = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hnB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hnC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hnF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hnx = new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0680a
            public void L(int i, boolean z2) {
                if (b.this.hnJ != null) {
                    if (i == 1) {
                        b.this.hnJ.nA(z2);
                    } else if (i == 2) {
                        b.this.hnJ.nB(z2);
                    } else if (i == 3) {
                        b.this.hnJ.nC(z2);
                    } else if (i == 4) {
                        b.this.hnJ.nD(z2);
                    } else if (i == 5) {
                        b.this.hnJ.ceE();
                    } else if (i == 6) {
                        b.this.hnJ.ceF();
                    } else if (i == 7) {
                        b.this.hnJ.ceG();
                    } else if (i == 8) {
                        b.this.hnJ.ceH();
                    }
                }
            }
        };
        this.hnD = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hnI = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hnI.a(this.hnx);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ceN();
        ceM();
    }

    private void ceM() {
        this.hnG.addView(this.hnH);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hnE;
        layoutParams.leftMargin = this.hnF;
        layoutParams.rightMargin = this.hnF;
        this.hnG.addView(view, layoutParams);
        setContentView(this.hnG);
    }

    public void a(a aVar) {
        this.hnJ = aVar;
    }

    private void createView() {
        this.hnG = new FrameLayout(getContext());
        this.hnH = new NoScrollGridView(getContext());
        this.hnH.setAdapter((ListAdapter) this.hnI);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hnH.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ceN() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hnH.setNumColumns(2);
            this.hnH.setPadding(this.hnz, this.hnB, navigationBarHeight + this.hnA, this.hnB);
            this.hnE = ((this.hnD ? this.hnt : this.hnt * 2) + this.hnB) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hnD) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hnH.setNumColumns(4);
            this.hnH.setPadding(this.hnC, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hnC, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void nE(boolean z) {
        this.hnI.a(1, z ? (short) 1 : (short) 2);
    }

    public void Q(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hnI.a(2, s);
    }

    public void R(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hnI.a(3, s);
    }

    public void nF(boolean z) {
        this.hnI.a(4, z ? (short) 1 : (short) 2);
    }

    public void ceO() {
        this.hnI.notifyDataSetChanged();
    }
}
