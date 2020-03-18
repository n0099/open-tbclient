package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private static final int fgU = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fgV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fgW = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fgX = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private a.InterfaceC0463a fgR;
    private boolean fgY;
    private int fgZ;
    private int fha;
    private FrameLayout fhb;
    private NoScrollGridView fhc;
    private com.baidu.tieba.ala.liveroom.master.panel.a fhd;
    private a fhe;

    /* loaded from: classes3.dex */
    public interface a {
        void boP();

        void boQ();

        void boR();

        void boS();

        void jF(boolean z);

        void jG(boolean z);

        void jH(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fha = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fgR = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0463a
            public void z(int i, boolean z2) {
                if (b.this.fhe != null) {
                    if (i == 1) {
                        b.this.fhe.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fhe.jF(z2);
                    } else if (i == 3) {
                        b.this.fhe.jG(z2);
                    } else if (i == 4) {
                        b.this.fhe.jH(z2);
                    } else if (i == 5) {
                        b.this.fhe.boP();
                    } else if (i == 6) {
                        b.this.fhe.boQ();
                    } else if (i == 7) {
                        b.this.fhe.boR();
                    } else if (i == 8) {
                        b.this.fhe.boS();
                    }
                }
            }
        };
        this.fgY = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fhd = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fhd.a(this.fgR);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        boW();
        boV();
    }

    private void boV() {
        this.fhb.addView(this.fhc);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fgZ;
        layoutParams.leftMargin = this.fha;
        layoutParams.rightMargin = this.fha;
        this.fhb.addView(view, layoutParams);
        setContentView(this.fhb);
    }

    public void a(a aVar) {
        this.fhe = aVar;
    }

    private void createView() {
        this.fhb = new FrameLayout(getContext());
        this.fhc = new NoScrollGridView(getContext());
        this.fhc.setAdapter((ListAdapter) this.fhd);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fhc.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void boW() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fhc.setNumColumns(2);
            this.fhc.setPadding(fgU, fgW, navigationBarHeight + fgV, fgW);
            this.fgZ = ((this.fgY ? com.baidu.tieba.ala.liveroom.master.panel.a.fgN : com.baidu.tieba.ala.liveroom.master.panel.a.fgN * 2) + fgW) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fgY) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fhc.setNumColumns(4);
            this.fhc.setPadding(fgX, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fgX, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jI(boolean z) {
        this.fhd.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fhd.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fhd.a(3, s);
    }

    public void jJ(boolean z) {
        this.fhd.a(4, z ? (short) 1 : (short) 2);
    }

    public void boX() {
        this.fhd.notifyDataSetChanged();
    }
}
