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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes11.dex */
public class b extends Dialog {
    public final int hIU;
    private a.InterfaceC0670a hIY;
    private final int hJa;
    private final int hJb;
    private final int hJc;
    private final int hJd;
    private boolean hJe;
    private int hJf;
    private int hJg;
    private FrameLayout hJh;
    private NoScrollGridView hJi;
    private com.baidu.tieba.ala.liveroom.master.panel.a hJj;
    private a hJk;

    /* loaded from: classes11.dex */
    public interface a {
        void ciw();

        void cix();

        void ciy();

        void ciz();

        void oB(boolean z);

        void oC(boolean z);

        void oD(boolean z);

        void oE(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hIU = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hJa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hJb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hJc = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hJd = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hIY = new a.InterfaceC0670a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0670a
            public void L(int i, boolean z2) {
                if (b.this.hJk != null) {
                    if (i == 1) {
                        b.this.hJk.oB(z2);
                    } else if (i == 2) {
                        b.this.hJk.oC(z2);
                    } else if (i == 3) {
                        b.this.hJk.oD(z2);
                    } else if (i == 4) {
                        b.this.hJk.oE(z2);
                    } else if (i == 5) {
                        b.this.hJk.ciw();
                    } else if (i == 6) {
                        b.this.hJk.cix();
                    } else if (i == 7) {
                        b.this.hJk.ciy();
                    } else if (i == 8) {
                        b.this.hJk.ciz();
                    }
                }
            }
        };
        this.hJe = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hJj = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hJj.a(this.hIY);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ciH();
        ciG();
    }

    private void ciG() {
        this.hJh.addView(this.hJi);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hJf;
        layoutParams.leftMargin = this.hJg;
        layoutParams.rightMargin = this.hJg;
        this.hJh.addView(view, layoutParams);
        setContentView(this.hJh);
    }

    public void a(a aVar) {
        this.hJk = aVar;
    }

    private void createView() {
        this.hJh = new FrameLayout(getContext());
        this.hJi = new NoScrollGridView(getContext());
        this.hJi.setAdapter((ListAdapter) this.hJj);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hJi.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ciH() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = m.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hJi.setNumColumns(2);
            this.hJi.setPadding(this.hJa, this.hJc, navigationBarHeight + this.hJb, this.hJc);
            this.hJf = ((this.hJe ? this.hIU : this.hIU * 2) + this.hJc) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hJe) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hJi.setNumColumns(4);
            this.hJi.setPadding(this.hJd, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hJd, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setIsBackCamera(boolean z) {
        this.hJj.a(1, z ? (short) 1 : (short) 2);
    }

    public void S(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hJj.a(2, s);
    }

    public void T(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hJj.a(3, s);
    }

    public void oF(boolean z) {
        this.hJj.a(4, z ? (short) 1 : (short) 2);
    }

    public void ciI() {
        this.hJj.notifyDataSetChanged();
    }
}
