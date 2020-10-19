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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes4.dex */
public class b extends Dialog {
    public final int gWf;
    private a.InterfaceC0650a gWj;
    private final int gWl;
    private final int gWm;
    private final int gWn;
    private final int gWo;
    private boolean gWp;
    private int gWq;
    private int gWr;
    private FrameLayout gWs;
    private NoScrollGridView gWt;
    private com.baidu.tieba.ala.liveroom.master.panel.a gWu;
    private a gWv;

    /* loaded from: classes4.dex */
    public interface a {
        void bZG();

        void bZH();

        void bZI();

        void bZJ();

        void na(boolean z);

        void nb(boolean z);

        void nc(boolean z);

        void nd(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.gWf = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
        this.gWl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
        this.gWm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.gWn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
        this.gWo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
        this.gWr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.gWj = new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0650a
            public void L(int i, boolean z2) {
                if (b.this.gWv != null) {
                    if (i == 1) {
                        b.this.gWv.na(z2);
                    } else if (i == 2) {
                        b.this.gWv.nb(z2);
                    } else if (i == 3) {
                        b.this.gWv.nc(z2);
                    } else if (i == 4) {
                        b.this.gWv.nd(z2);
                    } else if (i == 5) {
                        b.this.gWv.bZG();
                    } else if (i == 6) {
                        b.this.gWv.bZH();
                    } else if (i == 7) {
                        b.this.gWv.bZI();
                    } else if (i == 8) {
                        b.this.gWv.bZJ();
                    }
                }
            }
        };
        this.gWp = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.gWu = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.gWu.a(this.gWj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bZP();
        bZO();
    }

    private void bZO() {
        this.gWs.addView(this.gWt);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.gWq;
        layoutParams.leftMargin = this.gWr;
        layoutParams.rightMargin = this.gWr;
        this.gWs.addView(view, layoutParams);
        setContentView(this.gWs);
    }

    public void a(a aVar) {
        this.gWv = aVar;
    }

    private void createView() {
        this.gWs = new FrameLayout(getContext());
        this.gWt = new NoScrollGridView(getContext());
        this.gWt.setAdapter((ListAdapter) this.gWu);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.gWt.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bZP() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = l.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.gWt.setNumColumns(2);
            this.gWt.setPadding(this.gWl, this.gWn, navigationBarHeight + this.gWm, this.gWn);
            this.gWq = ((this.gWp ? this.gWf : this.gWf * 2) + this.gWn) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.gWp) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.gWt.setNumColumns(4);
            this.gWt.setPadding(this.gWo, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), this.gWo, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void ne(boolean z) {
        this.gWu.a(1, z ? (short) 1 : (short) 2);
    }

    public void N(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gWu.a(2, s);
    }

    public void O(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.gWu.a(3, s);
    }

    public void nf(boolean z) {
        this.gWu.a(4, z ? (short) 1 : (short) 2);
    }

    public void bZQ() {
        this.gWu.notifyDataSetChanged();
    }
}
