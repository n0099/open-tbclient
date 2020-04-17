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
    public final int fKZ;
    private a.InterfaceC0498a fLd;
    private final int fLg;
    private final int fLh;
    private final int fLi;
    private final int fLj;
    private boolean fLk;
    private int fLl;
    private int fLm;
    private FrameLayout fLn;
    private NoScrollGridView fLo;
    private com.baidu.tieba.ala.liveroom.master.panel.a fLp;
    private a fLq;

    /* loaded from: classes3.dex */
    public interface a {
        void byh();

        void byi();

        void byj();

        void byk();

        void kG(boolean z);

        void kH(boolean z);

        void kI(boolean z);

        void kJ(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fKZ = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.fLg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.fLh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.fLi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.fLj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.fLm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fLd = new a.InterfaceC0498a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0498a
            public void C(int i, boolean z2) {
                if (b.this.fLq != null) {
                    if (i == 1) {
                        b.this.fLq.kG(z2);
                    } else if (i == 2) {
                        b.this.fLq.kH(z2);
                    } else if (i == 3) {
                        b.this.fLq.kI(z2);
                    } else if (i == 4) {
                        b.this.fLq.kJ(z2);
                    } else if (i == 5) {
                        b.this.fLq.byh();
                    } else if (i == 6) {
                        b.this.fLq.byi();
                    } else if (i == 7) {
                        b.this.fLq.byj();
                    } else if (i == 8) {
                        b.this.fLq.byk();
                    }
                }
            }
        };
        this.fLk = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fLp = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fLp.a(this.fLd);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        byq();
        byp();
    }

    private void byp() {
        this.fLn.addView(this.fLo);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fLl;
        layoutParams.leftMargin = this.fLm;
        layoutParams.rightMargin = this.fLm;
        this.fLn.addView(view, layoutParams);
        setContentView(this.fLn);
    }

    public void a(a aVar) {
        this.fLq = aVar;
    }

    private void createView() {
        this.fLn = new FrameLayout(getContext());
        this.fLo = new NoScrollGridView(getContext());
        this.fLo.setAdapter((ListAdapter) this.fLp);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fLo.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void byq() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fLo.setNumColumns(2);
            this.fLo.setPadding(this.fLg, this.fLi, navigationBarHeight + this.fLh, this.fLi);
            this.fLl = ((this.fLk ? this.fKZ : this.fKZ * 2) + this.fLi) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fLk) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fLo.setNumColumns(4);
            this.fLo.setPadding(this.fLj, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.fLj, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void kK(boolean z) {
        this.fLp.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fLp.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fLp.a(3, s);
    }

    public void kL(boolean z) {
        this.fLp.a(4, z ? (short) 1 : (short) 2);
    }

    public void byr() {
        this.fLp.notifyDataSetChanged();
    }
}
