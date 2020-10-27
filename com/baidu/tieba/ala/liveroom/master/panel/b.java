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
    public final int hhU;
    private a.InterfaceC0666a hhY;
    private final int hia;
    private final int hib;
    private final int hic;
    private final int hie;
    private boolean hif;
    private int hig;
    private int hih;
    private FrameLayout hii;
    private NoScrollGridView hij;
    private com.baidu.tieba.ala.liveroom.master.panel.a hik;
    private a hil;

    /* loaded from: classes4.dex */
    public interface a {
        void ccK();

        void ccL();

        void ccM();

        void ccN();

        void nq(boolean z);

        void nr(boolean z);

        void ns(boolean z);

        void nt(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hhU = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.hia = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.hib = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.hic = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.hie = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.hih = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.hhY = new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0666a
            public void L(int i, boolean z2) {
                if (b.this.hil != null) {
                    if (i == 1) {
                        b.this.hil.nq(z2);
                    } else if (i == 2) {
                        b.this.hil.nr(z2);
                    } else if (i == 3) {
                        b.this.hil.ns(z2);
                    } else if (i == 4) {
                        b.this.hil.nt(z2);
                    } else if (i == 5) {
                        b.this.hil.ccK();
                    } else if (i == 6) {
                        b.this.hil.ccL();
                    } else if (i == 7) {
                        b.this.hil.ccM();
                    } else if (i == 8) {
                        b.this.hil.ccN();
                    }
                }
            }
        };
        this.hif = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.hik = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hik.a(this.hhY);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ccT();
        ccS();
    }

    private void ccS() {
        this.hii.addView(this.hij);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.hig;
        layoutParams.leftMargin = this.hih;
        layoutParams.rightMargin = this.hih;
        this.hii.addView(view, layoutParams);
        setContentView(this.hii);
    }

    public void a(a aVar) {
        this.hil = aVar;
    }

    private void createView() {
        this.hii = new FrameLayout(getContext());
        this.hij = new NoScrollGridView(getContext());
        this.hij.setAdapter((ListAdapter) this.hik);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hij.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void ccT() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hij.setNumColumns(2);
            this.hij.setPadding(this.hia, this.hic, navigationBarHeight + this.hib, this.hic);
            this.hig = ((this.hif ? this.hhU : this.hhU * 2) + this.hic) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hif) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hij.setNumColumns(4);
            this.hij.setPadding(this.hie, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.hie, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void nu(boolean z) {
        this.hik.a(1, z ? (short) 1 : (short) 2);
    }

    public void Q(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hik.a(2, s);
    }

    public void R(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hik.a(3, s);
    }

    public void nv(boolean z) {
        this.hik.a(4, z ? (short) 1 : (short) 2);
    }

    public void ccU() {
        this.hik.notifyDataSetChanged();
    }
}
