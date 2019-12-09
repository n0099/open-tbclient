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
    private static final int ejW = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int ejX = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int ejY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int ejZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private FrameLayout aeH;
    private a.InterfaceC0360a ejT;
    private boolean eka;
    private int ekb;
    private int ekc;
    private NoScrollGridView ekd;
    private com.baidu.tieba.ala.liveroom.master.panel.a eke;
    private a ekf;

    /* loaded from: classes6.dex */
    public interface a {
        void aUi();

        void aUj();

        void hZ(boolean z);

        void ia(boolean z);

        void ib(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.ekc = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.ejT = new a.InterfaceC0360a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0360a
            public void y(int i, boolean z2) {
                if (b.this.ekf != null) {
                    if (i == 1) {
                        b.this.ekf.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.ekf.hZ(z2);
                    } else if (i == 3) {
                        b.this.ekf.ia(z2);
                    } else if (i == 4) {
                        b.this.ekf.ib(z2);
                    } else if (i == 5) {
                        b.this.ekf.aUi();
                    } else if (i == 6) {
                        b.this.ekf.aUj();
                    }
                }
            }
        };
        this.eka = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.eke = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.eke.a(this.ejT);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        nw();
        aUp();
        aUo();
    }

    private void aUo() {
        this.aeH.addView(this.ekd);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.ekb;
        layoutParams.leftMargin = this.ekc;
        layoutParams.rightMargin = this.ekc;
        this.aeH.addView(view, layoutParams);
        setContentView(this.aeH);
    }

    public void a(a aVar) {
        this.ekf = aVar;
    }

    private void nw() {
        this.aeH = new FrameLayout(getContext());
        this.ekd = new NoScrollGridView(getContext());
        this.ekd.setAdapter((ListAdapter) this.eke);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.ekd.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void aUp() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = j.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.ekd.setNumColumns(2);
            this.ekd.setPadding(ejW, ejY, navigationBarHeight + ejX, ejY);
            this.ekb = ((this.eka ? com.baidu.tieba.ala.liveroom.master.panel.a.ejP : com.baidu.tieba.ala.liveroom.master.panel.a.ejP * 2) + ejY) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.eka) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.ekd.setNumColumns(4);
            this.ekd.setPadding(ejZ, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), ejZ, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void ic(boolean z) {
        this.eke.a(1, z ? (short) 1 : (short) 2);
    }

    public void D(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.eke.a(2, s);
    }

    public void E(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.eke.a(3, s);
    }

    public void id(boolean z) {
        this.eke.a(4, z ? (short) 1 : (short) 2);
    }

    public void aUq() {
        this.eke.notifyDataSetChanged();
    }
}
