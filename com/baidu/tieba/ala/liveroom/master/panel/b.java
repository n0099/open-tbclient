package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes6.dex */
public class b extends Dialog {
    private static final int ekN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int ekO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int ekP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int ekQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private FrameLayout aeZ;
    private a.InterfaceC0365a ekK;
    private boolean ekR;
    private int ekS;
    private int ekT;
    private NoScrollGridView ekU;
    private com.baidu.tieba.ala.liveroom.master.panel.a ekV;
    private a ekW;

    /* loaded from: classes6.dex */
    public interface a {
        void aUk();

        void aUl();

        void hZ(boolean z);

        void ia(boolean z);

        void ib(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.ekT = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.ekK = new a.InterfaceC0365a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0365a
            public void y(int i, boolean z2) {
                if (b.this.ekW != null) {
                    if (i == 1) {
                        b.this.ekW.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.ekW.hZ(z2);
                    } else if (i == 3) {
                        b.this.ekW.ia(z2);
                    } else if (i == 4) {
                        b.this.ekW.ib(z2);
                    } else if (i == 5) {
                        b.this.ekW.aUk();
                    } else if (i == 6) {
                        b.this.ekW.aUl();
                    }
                }
            }
        };
        this.ekR = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.ekV = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.ekV.a(this.ekK);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        nw();
        aUr();
        aUq();
    }

    private void aUq() {
        this.aeZ.addView(this.ekU);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.ekS;
        layoutParams.leftMargin = this.ekT;
        layoutParams.rightMargin = this.ekT;
        this.aeZ.addView(view, layoutParams);
        setContentView(this.aeZ);
    }

    public void a(a aVar) {
        this.ekW = aVar;
    }

    private void nw() {
        this.aeZ = new FrameLayout(getContext());
        this.ekU = new NoScrollGridView(getContext());
        this.ekU.setAdapter((ListAdapter) this.ekV);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.ekU.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void aUr() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = j.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.ekU.setNumColumns(2);
            this.ekU.setPadding(ekN, ekP, navigationBarHeight + ekO, ekP);
            this.ekS = ((this.ekR ? com.baidu.tieba.ala.liveroom.master.panel.a.ekG : com.baidu.tieba.ala.liveroom.master.panel.a.ekG * 2) + ekP) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.ekR) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.ekU.setNumColumns(4);
            this.ekU.setPadding(ekQ, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), ekQ, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void ic(boolean z) {
        this.ekV.a(1, z ? (short) 1 : (short) 2);
    }

    public void D(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.ekV.a(2, s);
    }

    public void E(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.ekV.a(3, s);
    }

    public void id(boolean z) {
        this.ekV.a(4, z ? (short) 1 : (short) 2);
    }

    public void aUs() {
        this.ekV.notifyDataSetChanged();
    }
}
