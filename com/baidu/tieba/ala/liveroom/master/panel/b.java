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
    public final int fZc;
    private a.InterfaceC0566a fZg;
    private final int fZj;
    private final int fZk;
    private final int fZl;
    private final int fZm;
    private boolean fZn;
    private int fZo;
    private int fZp;
    private FrameLayout fZq;
    private NoScrollGridView fZr;
    private com.baidu.tieba.ala.liveroom.master.panel.a fZs;
    private a fZt;

    /* loaded from: classes3.dex */
    public interface a {
        void bEi();

        void bEj();

        void bEk();

        void bEl();

        void lb(boolean z);

        void lc(boolean z);

        void ld(boolean z);

        void le(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fZc = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.fZj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.fZk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.fZl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.fZm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.fZp = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fZg = new a.InterfaceC0566a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0566a
            public void F(int i, boolean z2) {
                if (b.this.fZt != null) {
                    if (i == 1) {
                        b.this.fZt.lb(z2);
                    } else if (i == 2) {
                        b.this.fZt.lc(z2);
                    } else if (i == 3) {
                        b.this.fZt.ld(z2);
                    } else if (i == 4) {
                        b.this.fZt.le(z2);
                    } else if (i == 5) {
                        b.this.fZt.bEi();
                    } else if (i == 6) {
                        b.this.fZt.bEj();
                    } else if (i == 7) {
                        b.this.fZt.bEk();
                    } else if (i == 8) {
                        b.this.fZt.bEl();
                    }
                }
            }
        };
        this.fZn = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fZs = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fZs.a(this.fZg);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bEr();
        bEq();
    }

    private void bEq() {
        this.fZq.addView(this.fZr);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fZo;
        layoutParams.leftMargin = this.fZp;
        layoutParams.rightMargin = this.fZp;
        this.fZq.addView(view, layoutParams);
        setContentView(this.fZq);
    }

    public void a(a aVar) {
        this.fZt = aVar;
    }

    private void createView() {
        this.fZq = new FrameLayout(getContext());
        this.fZr = new NoScrollGridView(getContext());
        this.fZr.setAdapter((ListAdapter) this.fZs);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fZr.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bEr() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fZr.setNumColumns(2);
            this.fZr.setPadding(this.fZj, this.fZl, navigationBarHeight + this.fZk, this.fZl);
            this.fZo = ((this.fZn ? this.fZc : this.fZc * 2) + this.fZl) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fZn) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fZr.setNumColumns(4);
            this.fZr.setPadding(this.fZm, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.fZm, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void lf(boolean z) {
        this.fZs.a(1, z ? (short) 1 : (short) 2);
    }

    public void I(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fZs.a(2, s);
    }

    public void J(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fZs.a(3, s);
    }

    public void lg(boolean z) {
        this.fZs.a(4, z ? (short) 1 : (short) 2);
    }

    public void bEs() {
        this.fZs.notifyDataSetChanged();
    }
}
