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
    public final int hxc;
    private a.InterfaceC0693a hxg;
    private final int hxi;
    private final int hxj;
    private final int hxk;
    private final int hxl;
    private boolean hxm;
    private int hxn;
    private int hxo;
    private FrameLayout hxp;
    private NoScrollGridView hxq;
    private com.baidu.tieba.ala.liveroom.master.panel.a hxr;
    private a hxs;

    /* loaded from: classes4.dex */
    public interface a {
        void ciA();

        void ciB();

        void ciC();

        void ciD();

        void nV(boolean z);

        void nW(boolean z);

        void nX(boolean z);

        void nY(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hxc = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hxi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hxj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hxk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hxl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hxo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hxg = new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0693a
            public void L(int i, boolean z2) {
                if (b.this.hxs != null) {
                    if (i == 1) {
                        b.this.hxs.nV(z2);
                    } else if (i == 2) {
                        b.this.hxs.nW(z2);
                    } else if (i == 3) {
                        b.this.hxs.nX(z2);
                    } else if (i == 4) {
                        b.this.hxs.nY(z2);
                    } else if (i == 5) {
                        b.this.hxs.ciA();
                    } else if (i == 6) {
                        b.this.hxs.ciB();
                    } else if (i == 7) {
                        b.this.hxs.ciC();
                    } else if (i == 8) {
                        b.this.hxs.ciD();
                    }
                }
            }
        };
        this.hxm = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hxr = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hxr.a(this.hxg);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ciK();
        ciJ();
    }

    private void ciJ() {
        this.hxp.addView(this.hxq);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hxn;
        layoutParams.leftMargin = this.hxo;
        layoutParams.rightMargin = this.hxo;
        this.hxp.addView(view, layoutParams);
        setContentView(this.hxp);
    }

    public void a(a aVar) {
        this.hxs = aVar;
    }

    private void createView() {
        this.hxp = new FrameLayout(getContext());
        this.hxq = new NoScrollGridView(getContext());
        this.hxq.setAdapter((ListAdapter) this.hxr);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hxq.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ciK() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hxq.setNumColumns(2);
            this.hxq.setPadding(this.hxi, this.hxk, navigationBarHeight + this.hxj, this.hxk);
            this.hxn = ((this.hxm ? this.hxc : this.hxc * 2) + this.hxk) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hxm) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hxq.setNumColumns(4);
            this.hxq.setPadding(this.hxl, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hxl, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void nZ(boolean z) {
        this.hxr.a(1, z ? (short) 1 : (short) 2);
    }

    public void Q(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hxr.a(2, s);
    }

    public void R(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hxr.a(3, s);
    }

    public void oa(boolean z) {
        this.hxr.a(4, z ? (short) 1 : (short) 2);
    }

    public void ciL() {
        this.hxr.notifyDataSetChanged();
    }
}
