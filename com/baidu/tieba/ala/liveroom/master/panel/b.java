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
    public final int hxa;
    private a.InterfaceC0693a hxe;
    private final int hxg;
    private final int hxh;
    private final int hxi;
    private final int hxj;
    private boolean hxk;
    private int hxl;
    private int hxm;
    private FrameLayout hxn;
    private NoScrollGridView hxo;
    private com.baidu.tieba.ala.liveroom.master.panel.a hxp;
    private a hxq;

    /* loaded from: classes4.dex */
    public interface a {
        void ciA();

        void ciB();

        void ciC();

        void ciz();

        void nV(boolean z);

        void nW(boolean z);

        void nX(boolean z);

        void nY(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hxa = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hxg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hxh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hxi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hxj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hxm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hxe = new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0693a
            public void L(int i, boolean z2) {
                if (b.this.hxq != null) {
                    if (i == 1) {
                        b.this.hxq.nV(z2);
                    } else if (i == 2) {
                        b.this.hxq.nW(z2);
                    } else if (i == 3) {
                        b.this.hxq.nX(z2);
                    } else if (i == 4) {
                        b.this.hxq.nY(z2);
                    } else if (i == 5) {
                        b.this.hxq.ciz();
                    } else if (i == 6) {
                        b.this.hxq.ciA();
                    } else if (i == 7) {
                        b.this.hxq.ciB();
                    } else if (i == 8) {
                        b.this.hxq.ciC();
                    }
                }
            }
        };
        this.hxk = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hxp = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hxp.a(this.hxe);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ciJ();
        ciI();
    }

    private void ciI() {
        this.hxn.addView(this.hxo);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hxl;
        layoutParams.leftMargin = this.hxm;
        layoutParams.rightMargin = this.hxm;
        this.hxn.addView(view, layoutParams);
        setContentView(this.hxn);
    }

    public void a(a aVar) {
        this.hxq = aVar;
    }

    private void createView() {
        this.hxn = new FrameLayout(getContext());
        this.hxo = new NoScrollGridView(getContext());
        this.hxo.setAdapter((ListAdapter) this.hxp);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hxo.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ciJ() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hxo.setNumColumns(2);
            this.hxo.setPadding(this.hxg, this.hxi, navigationBarHeight + this.hxh, this.hxi);
            this.hxl = ((this.hxk ? this.hxa : this.hxa * 2) + this.hxi) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hxk) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hxo.setNumColumns(4);
            this.hxo.setPadding(this.hxj, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hxj, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void nZ(boolean z) {
        this.hxp.a(1, z ? (short) 1 : (short) 2);
    }

    public void Q(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hxp.a(2, s);
    }

    public void R(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hxp.a(3, s);
    }

    public void oa(boolean z) {
        this.hxp.a(4, z ? (short) 1 : (short) 2);
    }

    public void ciK() {
        this.hxp.notifyDataSetChanged();
    }
}
