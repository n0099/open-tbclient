package com.baidu.tieba.ala.liveroom.master.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.view.NoScrollGridView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.master.panel.a;
import com.baidu.tieba.compatible.StatusBarUtil;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private static final int fak = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds12);
    private static final int fal = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
    private static final int fam = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    private static final int fan = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds17);
    private a.InterfaceC0449a fah;
    private boolean fao;
    private int fap;
    private int faq;
    private FrameLayout far;
    private NoScrollGridView fas;
    private com.baidu.tieba.ala.liveroom.master.panel.a fat;
    private a fau;

    /* loaded from: classes2.dex */
    public interface a {
        void blZ();

        void bma();

        void bmb();

        void bmc();

        void jq(boolean z);

        void jr(boolean z);

        void js(boolean z);

        void switchCamera(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.faq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds24);
        this.fah = new a.InterfaceC0449a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0449a
            public void A(int i, boolean z2) {
                if (b.this.fau != null) {
                    if (i == 1) {
                        b.this.fau.switchCamera(z2);
                    } else if (i == 2) {
                        b.this.fau.jq(z2);
                    } else if (i == 3) {
                        b.this.fau.jr(z2);
                    } else if (i == 4) {
                        b.this.fau.js(z2);
                    } else if (i == 5) {
                        b.this.fau.blZ();
                    } else if (i == 6) {
                        b.this.fau.bma();
                    } else if (i == 7) {
                        b.this.fau.bmb();
                    } else if (i == 8) {
                        b.this.fau.bmc();
                    }
                }
            }
        };
        this.fao = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.j.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.j.theme_operation_portrait_dialog);
        }
        this.fat = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.fat.a(this.fah);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        bmg();
        bmf();
    }

    private void bmf() {
        this.far.addView(this.fas);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        layoutParams.topMargin = this.fap;
        layoutParams.leftMargin = this.faq;
        layoutParams.rightMargin = this.faq;
        this.far.addView(view, layoutParams);
        setContentView(this.far);
    }

    public void a(a aVar) {
        this.fau = aVar;
    }

    private void createView() {
        this.far = new FrameLayout(getContext());
        this.fas = new NoScrollGridView(getContext());
        this.fas.setAdapter((ListAdapter) this.fat);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.fas.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_black_alpha85));
        }
    }

    private void bmg() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = k.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.fas.setNumColumns(2);
            this.fas.setPadding(fak, fam, navigationBarHeight + fal, fam);
            this.fap = ((this.fao ? com.baidu.tieba.ala.liveroom.master.panel.a.fad : com.baidu.tieba.ala.liveroom.master.panel.a.fad * 2) + fam) - getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.fao) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.fas.setNumColumns(4);
            this.fas.setPadding(fan, getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32), fan, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void jt(boolean z) {
        this.fat.a(1, z ? (short) 1 : (short) 2);
    }

    public void D(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fat.a(2, s);
    }

    public void E(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.fat.a(3, s);
    }

    public void ju(boolean z) {
        this.fat.a(4, z ? (short) 1 : (short) 2);
    }

    public void bmh() {
        this.fat.notifyDataSetChanged();
    }
}
