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
    public final int gEi;
    private a.InterfaceC0635a gEm;
    private final int gEo;
    private final int gEp;
    private final int gEq;
    private final int gEr;
    private boolean gEs;
    private int gEt;
    private int gEu;
    private FrameLayout gEv;
    private NoScrollGridView gEw;
    private com.baidu.tieba.ala.liveroom.master.panel.a gEx;
    private a gEy;

    /* loaded from: classes7.dex */
    public interface a {
        void bUB();

        void bUC();

        void bUD();

        void bUE();

        void mu(boolean z);

        void mv(boolean z);

        void mw(boolean z);

        void mx(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.gEi = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.gEo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.gEp = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.gEq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.gEr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.gEu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gEm = new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0635a
            public void J(int i, boolean z2) {
                if (b.this.gEy != null) {
                    if (i == 1) {
                        b.this.gEy.mu(z2);
                    } else if (i == 2) {
                        b.this.gEy.mv(z2);
                    } else if (i == 3) {
                        b.this.gEy.mw(z2);
                    } else if (i == 4) {
                        b.this.gEy.mx(z2);
                    } else if (i == 5) {
                        b.this.gEy.bUB();
                    } else if (i == 6) {
                        b.this.gEy.bUC();
                    } else if (i == 7) {
                        b.this.gEy.bUD();
                    } else if (i == 8) {
                        b.this.gEy.bUE();
                    }
                }
            }
        };
        this.gEs = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.gEx = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.gEx.a(this.gEm);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bUK();
        bUJ();
    }

    private void bUJ() {
        this.gEv.addView(this.gEw);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.gEt;
        layoutParams.leftMargin = this.gEu;
        layoutParams.rightMargin = this.gEu;
        this.gEv.addView(view, layoutParams);
        setContentView(this.gEv);
    }

    public void a(a aVar) {
        this.gEy = aVar;
    }

    private void createView() {
        this.gEv = new FrameLayout(getContext());
        this.gEw = new NoScrollGridView(getContext());
        this.gEw.setAdapter((ListAdapter) this.gEx);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gEw.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bUK() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gEw.setNumColumns(2);
            this.gEw.setPadding(this.gEo, this.gEq, navigationBarHeight + this.gEp, this.gEq);
            this.gEt = ((this.gEs ? this.gEi : this.gEi * 2) + this.gEq) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gEs) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gEw.setNumColumns(4);
            this.gEw.setPadding(this.gEr, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.gEr, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void my(boolean z) {
        this.gEx.a(1, z ? (short) 1 : (short) 2);
    }

    public void N(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gEx.a(2, s);
    }

    public void O(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gEx.a(3, s);
    }

    public void mz(boolean z) {
        this.gEx.a(4, z ? (short) 1 : (short) 2);
    }

    public void bUL() {
        this.gEx.notifyDataSetChanged();
    }
}
