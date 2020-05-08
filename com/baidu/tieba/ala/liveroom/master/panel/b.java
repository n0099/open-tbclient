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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes3.dex */
public class b extends Dialog {
    public final int fLe;
    private a.InterfaceC0519a fLi;
    private final int fLl;
    private final int fLm;
    private final int fLn;
    private final int fLo;
    private boolean fLp;
    private int fLq;
    private int fLr;
    private FrameLayout fLs;
    private NoScrollGridView fLt;
    private com.baidu.tieba.ala.liveroom.master.panel.a fLu;
    private a fLv;

    /* loaded from: classes3.dex */
    public interface a {
        void byf();

        void byg();

        void byh();

        void byi();

        void kG(boolean z);

        void kH(boolean z);

        void kI(boolean z);

        void kJ(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fLe = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.fLl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.fLm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.fLn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.fLo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.fLr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fLi = new a.InterfaceC0519a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0519a
            public void C(int i, boolean z2) {
                if (b.this.fLv != null) {
                    if (i == 1) {
                        b.this.fLv.kG(z2);
                    } else if (i == 2) {
                        b.this.fLv.kH(z2);
                    } else if (i == 3) {
                        b.this.fLv.kI(z2);
                    } else if (i == 4) {
                        b.this.fLv.kJ(z2);
                    } else if (i == 5) {
                        b.this.fLv.byf();
                    } else if (i == 6) {
                        b.this.fLv.byg();
                    } else if (i == 7) {
                        b.this.fLv.byh();
                    } else if (i == 8) {
                        b.this.fLv.byi();
                    }
                }
            }
        };
        this.fLp = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fLu = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fLu.a(this.fLi);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        byo();
        byn();
    }

    private void byn() {
        this.fLs.addView(this.fLt);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fLq;
        layoutParams.leftMargin = this.fLr;
        layoutParams.rightMargin = this.fLr;
        this.fLs.addView(view, layoutParams);
        setContentView(this.fLs);
    }

    public void a(a aVar) {
        this.fLv = aVar;
    }

    private void createView() {
        this.fLs = new FrameLayout(getContext());
        this.fLt = new NoScrollGridView(getContext());
        this.fLt.setAdapter((ListAdapter) this.fLu);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fLt.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void byo() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fLt.setNumColumns(2);
            this.fLt.setPadding(this.fLl, this.fLn, navigationBarHeight + this.fLm, this.fLn);
            this.fLq = ((this.fLp ? this.fLe : this.fLe * 2) + this.fLn) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fLp) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fLt.setNumColumns(4);
            this.fLt.setPadding(this.fLo, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.fLo, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void kK(boolean z) {
        this.fLu.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fLu.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fLu.a(3, s);
    }

    public void kL(boolean z) {
        this.fLu.a(4, z ? (short) 1 : (short) 2);
    }

    public void byp() {
        this.fLu.notifyDataSetChanged();
    }
}
