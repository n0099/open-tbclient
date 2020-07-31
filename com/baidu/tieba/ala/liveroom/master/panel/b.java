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
/* loaded from: classes4.dex */
public class b extends Dialog {
    private a grA;
    public final int grk;
    private a.InterfaceC0585a gro;
    private final int grq;
    private final int grr;
    private final int grs;
    private final int grt;
    private boolean gru;
    private int grv;
    private int grw;
    private FrameLayout grx;
    private NoScrollGridView gry;
    private com.baidu.tieba.ala.liveroom.master.panel.a grz;

    /* loaded from: classes4.dex */
    public interface a {
        void bKA();

        void bKx();

        void bKy();

        void bKz();

        void lO(boolean z);

        void lP(boolean z);

        void lQ(boolean z);

        void lR(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.grk = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.grq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.grr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.grs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.grt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.grw = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gro = new a.InterfaceC0585a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0585a
            public void H(int i, boolean z2) {
                if (b.this.grA != null) {
                    if (i == 1) {
                        b.this.grA.lO(z2);
                    } else if (i == 2) {
                        b.this.grA.lP(z2);
                    } else if (i == 3) {
                        b.this.grA.lQ(z2);
                    } else if (i == 4) {
                        b.this.grA.lR(z2);
                    } else if (i == 5) {
                        b.this.grA.bKx();
                    } else if (i == 6) {
                        b.this.grA.bKy();
                    } else if (i == 7) {
                        b.this.grA.bKz();
                    } else if (i == 8) {
                        b.this.grA.bKA();
                    }
                }
            }
        };
        this.gru = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.grz = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.grz.a(this.gro);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bKG();
        bKF();
    }

    private void bKF() {
        this.grx.addView(this.gry);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.grv;
        layoutParams.leftMargin = this.grw;
        layoutParams.rightMargin = this.grw;
        this.grx.addView(view, layoutParams);
        setContentView(this.grx);
    }

    public void a(a aVar) {
        this.grA = aVar;
    }

    private void createView() {
        this.grx = new FrameLayout(getContext());
        this.gry = new NoScrollGridView(getContext());
        this.gry.setAdapter((ListAdapter) this.grz);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gry.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bKG() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gry.setNumColumns(2);
            this.gry.setPadding(this.grq, this.grs, navigationBarHeight + this.grr, this.grs);
            this.grv = ((this.gru ? this.grk : this.grk * 2) + this.grs) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gru) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gry.setNumColumns(4);
            this.gry.setPadding(this.grt, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.grt, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void lS(boolean z) {
        this.grz.a(1, z ? (short) 1 : (short) 2);
    }

    public void K(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.grz.a(2, s);
    }

    public void L(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.grz.a(3, s);
    }

    public void lT(boolean z) {
        this.grz.a(4, z ? (short) 1 : (short) 2);
    }

    public void bKH() {
        this.grz.notifyDataSetChanged();
    }
}
