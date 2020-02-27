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
    private static final int fgh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fgi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fgj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fgk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private a.InterfaceC0463a fge;
    private boolean fgl;
    private int fgm;
    private int fgn;
    private FrameLayout fgo;
    private NoScrollGridView fgp;
    private com.baidu.tieba.ala.liveroom.master.panel.a fgq;
    private a fgr;

    /* loaded from: classes3.dex */
    public interface a {
        void boH();

        void boI();

        void boJ();

        void boK();

        void jD(boolean z);

        void jE(boolean z);

        void jF(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fgn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fge = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0463a
            public void z(int i, boolean z2) {
                if (b.this.fgr != null) {
                    if (i == 1) {
                        b.this.fgr.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fgr.jD(z2);
                    } else if (i == 3) {
                        b.this.fgr.jE(z2);
                    } else if (i == 4) {
                        b.this.fgr.jF(z2);
                    } else if (i == 5) {
                        b.this.fgr.boH();
                    } else if (i == 6) {
                        b.this.fgr.boI();
                    } else if (i == 7) {
                        b.this.fgr.boJ();
                    } else if (i == 8) {
                        b.this.fgr.boK();
                    }
                }
            }
        };
        this.fgl = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fgq = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fgq.a(this.fge);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        boO();
        boN();
    }

    private void boN() {
        this.fgo.addView(this.fgp);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fgm;
        layoutParams.leftMargin = this.fgn;
        layoutParams.rightMargin = this.fgn;
        this.fgo.addView(view, layoutParams);
        setContentView(this.fgo);
    }

    public void a(a aVar) {
        this.fgr = aVar;
    }

    private void createView() {
        this.fgo = new FrameLayout(getContext());
        this.fgp = new NoScrollGridView(getContext());
        this.fgp.setAdapter((ListAdapter) this.fgq);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fgp.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void boO() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fgp.setNumColumns(2);
            this.fgp.setPadding(fgh, fgj, navigationBarHeight + fgi, fgj);
            this.fgm = ((this.fgl ? com.baidu.tieba.ala.liveroom.master.panel.a.fga : com.baidu.tieba.ala.liveroom.master.panel.a.fga * 2) + fgj) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fgl) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fgp.setNumColumns(4);
            this.fgp.setPadding(fgk, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fgk, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jG(boolean z) {
        this.fgq.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgq.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgq.a(3, s);
    }

    public void jH(boolean z) {
        this.fgq.a(4, z ? (short) 1 : (short) 2);
    }

    public void boP() {
        this.fgq.notifyDataSetChanged();
    }
}
