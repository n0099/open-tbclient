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
    public final int hIG;
    private a.InterfaceC0669a hIK;
    private final int hIM;
    private final int hIN;
    private final int hIO;
    private final int hIP;
    private boolean hIQ;
    private int hIR;
    private int hIS;
    private FrameLayout hIT;
    private NoScrollGridView hIU;
    private com.baidu.tieba.ala.liveroom.master.panel.a hIV;
    private a hIW;

    /* loaded from: classes11.dex */
    public interface a {
        void cip();

        void ciq();

        void cir();

        void cis();

        void oB(boolean z);

        void oC(boolean z);

        void oD(boolean z);

        void oE(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hIG = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hIM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hIN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hIO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hIP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hIS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hIK = new a.InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0669a
            public void L(int i, boolean z2) {
                if (b.this.hIW != null) {
                    if (i == 1) {
                        b.this.hIW.oB(z2);
                    } else if (i == 2) {
                        b.this.hIW.oC(z2);
                    } else if (i == 3) {
                        b.this.hIW.oD(z2);
                    } else if (i == 4) {
                        b.this.hIW.oE(z2);
                    } else if (i == 5) {
                        b.this.hIW.cip();
                    } else if (i == 6) {
                        b.this.hIW.ciq();
                    } else if (i == 7) {
                        b.this.hIW.cir();
                    } else if (i == 8) {
                        b.this.hIW.cis();
                    }
                }
            }
        };
        this.hIQ = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hIV = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hIV.a(this.hIK);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        ciA();
        ciz();
    }

    private void ciz() {
        this.hIT.addView(this.hIU);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hIR;
        layoutParams.leftMargin = this.hIS;
        layoutParams.rightMargin = this.hIS;
        this.hIT.addView(view, layoutParams);
        setContentView(this.hIT);
    }

    public void a(a aVar) {
        this.hIW = aVar;
    }

    private void createView() {
        this.hIT = new FrameLayout(getContext());
        this.hIU = new NoScrollGridView(getContext());
        this.hIU.setAdapter((ListAdapter) this.hIV);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hIU.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void ciA() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = m.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hIU.setNumColumns(2);
            this.hIU.setPadding(this.hIM, this.hIO, navigationBarHeight + this.hIN, this.hIO);
            this.hIR = ((this.hIQ ? this.hIG : this.hIG * 2) + this.hIO) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hIQ) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hIU.setNumColumns(4);
            this.hIU.setPadding(this.hIP, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hIP, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setIsBackCamera(boolean z) {
        this.hIV.a(1, z ? (short) 1 : (short) 2);
    }

    public void S(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hIV.a(2, s);
    }

    public void T(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hIV.a(3, s);
    }

    public void oF(boolean z) {
        this.hIV.a(4, z ? (short) 1 : (short) 2);
    }

    public void ciB() {
        this.hIV.notifyDataSetChanged();
    }
}
