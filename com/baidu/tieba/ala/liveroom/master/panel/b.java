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
    private static final int fgi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fgj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fgk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fgl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private a.InterfaceC0463a fgf;
    private boolean fgm;
    private int fgn;
    private int fgo;
    private FrameLayout fgp;
    private NoScrollGridView fgq;
    private com.baidu.tieba.ala.liveroom.master.panel.a fgr;
    private a fgs;

    /* loaded from: classes3.dex */
    public interface a {
        void boJ();

        void boK();

        void boL();

        void boM();

        void jD(boolean z);

        void jE(boolean z);

        void jF(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.fgo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fgf = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0463a
            public void z(int i, boolean z2) {
                if (b.this.fgs != null) {
                    if (i == 1) {
                        b.this.fgs.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fgs.jD(z2);
                    } else if (i == 3) {
                        b.this.fgs.jE(z2);
                    } else if (i == 4) {
                        b.this.fgs.jF(z2);
                    } else if (i == 5) {
                        b.this.fgs.boJ();
                    } else if (i == 6) {
                        b.this.fgs.boK();
                    } else if (i == 7) {
                        b.this.fgs.boL();
                    } else if (i == 8) {
                        b.this.fgs.boM();
                    }
                }
            }
        };
        this.fgm = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fgr = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fgr.a(this.fgf);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        boQ();
        boP();
    }

    private void boP() {
        this.fgp.addView(this.fgq);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fgn;
        layoutParams.leftMargin = this.fgo;
        layoutParams.rightMargin = this.fgo;
        this.fgp.addView(view, layoutParams);
        setContentView(this.fgp);
    }

    public void a(a aVar) {
        this.fgs = aVar;
    }

    private void createView() {
        this.fgp = new FrameLayout(getContext());
        this.fgq = new NoScrollGridView(getContext());
        this.fgq.setAdapter((ListAdapter) this.fgr);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fgq.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void boQ() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fgq.setNumColumns(2);
            this.fgq.setPadding(fgi, fgk, navigationBarHeight + fgj, fgk);
            this.fgn = ((this.fgm ? com.baidu.tieba.ala.liveroom.master.panel.a.fgb : com.baidu.tieba.ala.liveroom.master.panel.a.fgb * 2) + fgk) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fgm) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fgq.setNumColumns(4);
            this.fgq.setPadding(fgl, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fgl, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jG(boolean z) {
        this.fgr.a(1, z ? (short) 1 : (short) 2);
    }

    public void F(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgr.a(2, s);
    }

    public void G(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fgr.a(3, s);
    }

    public void jH(boolean z) {
        this.fgr.a(4, z ? (short) 1 : (short) 2);
    }

    public void boR() {
        this.fgr.notifyDataSetChanged();
    }
}
