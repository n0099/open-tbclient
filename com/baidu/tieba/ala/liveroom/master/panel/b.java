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
/* loaded from: classes7.dex */
public class b extends Dialog {
    public final int gEe;
    private a.InterfaceC0635a gEi;
    private final int gEk;
    private final int gEl;
    private final int gEm;
    private final int gEn;
    private boolean gEo;
    private int gEp;
    private int gEq;
    private FrameLayout gEr;
    private NoScrollGridView gEs;
    private com.baidu.tieba.ala.liveroom.master.panel.a gEt;
    private a gEu;

    /* loaded from: classes7.dex */
    public interface a {
        void bUA();

        void bUB();

        void bUC();

        void bUD();

        void ms(boolean z);

        void mt(boolean z);

        void mu(boolean z);

        void mv(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.gEe = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.gEk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.gEl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.gEm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.gEn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.gEq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gEi = new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0635a
            public void J(int i, boolean z2) {
                if (b.this.gEu != null) {
                    if (i == 1) {
                        b.this.gEu.ms(z2);
                    } else if (i == 2) {
                        b.this.gEu.mt(z2);
                    } else if (i == 3) {
                        b.this.gEu.mu(z2);
                    } else if (i == 4) {
                        b.this.gEu.mv(z2);
                    } else if (i == 5) {
                        b.this.gEu.bUA();
                    } else if (i == 6) {
                        b.this.gEu.bUB();
                    } else if (i == 7) {
                        b.this.gEu.bUC();
                    } else if (i == 8) {
                        b.this.gEu.bUD();
                    }
                }
            }
        };
        this.gEo = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.gEt = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.gEt.a(this.gEi);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bUJ();
        bUI();
    }

    private void bUI() {
        this.gEr.addView(this.gEs);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.gEp;
        layoutParams.leftMargin = this.gEq;
        layoutParams.rightMargin = this.gEq;
        this.gEr.addView(view, layoutParams);
        setContentView(this.gEr);
    }

    public void a(a aVar) {
        this.gEu = aVar;
    }

    private void createView() {
        this.gEr = new FrameLayout(getContext());
        this.gEs = new NoScrollGridView(getContext());
        this.gEs.setAdapter((ListAdapter) this.gEt);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gEs.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bUJ() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gEs.setNumColumns(2);
            this.gEs.setPadding(this.gEk, this.gEm, navigationBarHeight + this.gEl, this.gEm);
            this.gEp = ((this.gEo ? this.gEe : this.gEe * 2) + this.gEm) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gEo) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gEs.setNumColumns(4);
            this.gEs.setPadding(this.gEn, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.gEn, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void mw(boolean z) {
        this.gEt.a(1, z ? (short) 1 : (short) 2);
    }

    public void N(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gEt.a(2, s);
    }

    public void O(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gEt.a(3, s);
    }

    public void mx(boolean z) {
        this.gEt.a(4, z ? (short) 1 : (short) 2);
    }

    public void bUK() {
        this.gEt.notifyDataSetChanged();
    }
}
