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
    public final int hnM;
    private a.InterfaceC0680a hnQ;
    private final int hnS;
    private final int hnT;
    private final int hnU;
    private final int hnV;
    private boolean hnW;
    private int hnX;
    private int hnY;
    private FrameLayout hnZ;
    private NoScrollGridView hoa;
    private com.baidu.tieba.ala.liveroom.master.panel.a hob;
    private a hoc;

    /* loaded from: classes4.dex */
    public interface a {
        void cfl();

        void cfm();

        void cfn();

        void cfo();

        void nA(boolean z);

        void nB(boolean z);

        void nC(boolean z);

        void nz(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hnM = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hnS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hnT = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hnU = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hnV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hnY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hnQ = new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0680a
            public void L(int i, boolean z2) {
                if (b.this.hoc != null) {
                    if (i == 1) {
                        b.this.hoc.nz(z2);
                    } else if (i == 2) {
                        b.this.hoc.nA(z2);
                    } else if (i == 3) {
                        b.this.hoc.nB(z2);
                    } else if (i == 4) {
                        b.this.hoc.nC(z2);
                    } else if (i == 5) {
                        b.this.hoc.cfl();
                    } else if (i == 6) {
                        b.this.hoc.cfm();
                    } else if (i == 7) {
                        b.this.hoc.cfn();
                    } else if (i == 8) {
                        b.this.hoc.cfo();
                    }
                }
            }
        };
        this.hnW = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hob = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hob.a(this.hnQ);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        cfu();
        cft();
    }

    private void cft() {
        this.hnZ.addView(this.hoa);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hnX;
        layoutParams.leftMargin = this.hnY;
        layoutParams.rightMargin = this.hnY;
        this.hnZ.addView(view, layoutParams);
        setContentView(this.hnZ);
    }

    public void a(a aVar) {
        this.hoc = aVar;
    }

    private void createView() {
        this.hnZ = new FrameLayout(getContext());
        this.hoa = new NoScrollGridView(getContext());
        this.hoa.setAdapter((ListAdapter) this.hob);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hoa.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void cfu() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hoa.setNumColumns(2);
            this.hoa.setPadding(this.hnS, this.hnU, navigationBarHeight + this.hnT, this.hnU);
            this.hnX = ((this.hnW ? this.hnM : this.hnM * 2) + this.hnU) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hnW) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hoa.setNumColumns(4);
            this.hoa.setPadding(this.hnV, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hnV, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void nD(boolean z) {
        this.hob.a(1, z ? (short) 1 : (short) 2);
    }

    public void Q(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hob.a(2, s);
    }

    public void R(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hob.a(3, s);
    }

    public void nE(boolean z) {
        this.hob.a(4, z ? (short) 1 : (short) 2);
    }

    public void cfv() {
        this.hob.notifyDataSetChanged();
    }
}
