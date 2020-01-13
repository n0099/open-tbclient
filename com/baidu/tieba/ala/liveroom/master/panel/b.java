package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private static final int fcY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fcZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fda = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fdb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private a.InterfaceC0453a fcV;
    private boolean fdc;
    private int fdd;
    private int fde;
    private FrameLayout fdf;
    private NoScrollGridView fdg;
    private com.baidu.tieba.ala.liveroom.master.panel.a fdh;
    private a fdi;

    /* loaded from: classes2.dex */
    public interface a {
        void bmX();

        void bmY();

        void bmZ();

        void bna();

        void jB(boolean z);

        void jC(boolean z);

        void jD(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fde = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fcV = new a.InterfaceC0453a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0453a
            public void A(int i, boolean z2) {
                if (b.this.fdi != null) {
                    if (i == 1) {
                        b.this.fdi.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fdi.jB(z2);
                    } else if (i == 3) {
                        b.this.fdi.jC(z2);
                    } else if (i == 4) {
                        b.this.fdi.jD(z2);
                    } else if (i == 5) {
                        b.this.fdi.bmX();
                    } else if (i == 6) {
                        b.this.fdi.bmY();
                    } else if (i == 7) {
                        b.this.fdi.bmZ();
                    } else if (i == 8) {
                        b.this.fdi.bna();
                    }
                }
            }
        };
        this.fdc = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fdh = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fdh.a(this.fcV);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bne();
        bnd();
    }

    private void bnd() {
        this.fdf.addView(this.fdg);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fdd;
        layoutParams.leftMargin = this.fde;
        layoutParams.rightMargin = this.fde;
        this.fdf.addView(view, layoutParams);
        setContentView(this.fdf);
    }

    public void a(a aVar) {
        this.fdi = aVar;
    }

    private void createView() {
        this.fdf = new FrameLayout(getContext());
        this.fdg = new NoScrollGridView(getContext());
        this.fdg.setAdapter((ListAdapter) this.fdh);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fdg.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bne() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fdg.setNumColumns(2);
            this.fdg.setPadding(fcY, fda, navigationBarHeight + fcZ, fda);
            this.fdd = ((this.fdc ? com.baidu.tieba.ala.liveroom.master.panel.a.fcR : com.baidu.tieba.ala.liveroom.master.panel.a.fcR * 2) + fda) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fdc) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fdg.setNumColumns(4);
            this.fdg.setPadding(fdb, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fdb, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jE(boolean z) {
        this.fdh.a(1, z ? (short) 1 : (short) 2);
    }

    public void D(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fdh.a(2, s);
    }

    public void E(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fdh.a(3, s);
    }

    public void jF(boolean z) {
        this.fdh.a(4, z ? (short) 1 : (short) 2);
    }

    public void bnf() {
        this.fdh.notifyDataSetChanged();
    }
}
