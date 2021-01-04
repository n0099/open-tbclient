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
    public final int hJa;
    private a.InterfaceC0685a hJe;
    private final int hJg;
    private final int hJh;
    private final int hJi;
    private final int hJj;
    private boolean hJk;
    private int hJl;
    private int hJm;
    private FrameLayout hJn;
    private NoScrollGridView hJo;
    private com.baidu.tieba.ala.liveroom.master.panel.a hJp;
    private a hJq;

    /* loaded from: classes11.dex */
    public interface a {
        void cln();

        void clo();

        void clp();

        void clq();

        void ov(boolean z);

        void ow(boolean z);

        void ox(boolean z);

        void oy(boolean z);
    }

    public b(Context context, boolean z) {
        super(context);
        this.hJa = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
        this.hJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        this.hJh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.hJi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
        this.hJj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds17);
        this.hJm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds24);
        this.hJe = new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.liveroom.master.panel.b.1
            @Override // com.baidu.tieba.ala.liveroom.master.panel.a.InterfaceC0685a
            public void L(int i, boolean z2) {
                if (b.this.hJq != null) {
                    if (i == 1) {
                        b.this.hJq.ov(z2);
                    } else if (i == 2) {
                        b.this.hJq.ow(z2);
                    } else if (i == 3) {
                        b.this.hJq.ox(z2);
                    } else if (i == 4) {
                        b.this.hJq.oy(z2);
                    } else if (i == 5) {
                        b.this.hJq.cln();
                    } else if (i == 6) {
                        b.this.hJq.clo();
                    } else if (i == 7) {
                        b.this.hJq.clp();
                    } else if (i == 8) {
                        b.this.hJq.clq();
                    }
                }
            }
        };
        this.hJk = z;
        if (UtilHelper.getRealScreenOrientation(context) == 2) {
            getContext().setTheme(a.i.theme_operation_landscape_dialog);
        } else {
            getContext().setTheme(a.i.theme_operation_portrait_dialog);
        }
        this.hJp = new com.baidu.tieba.ala.liveroom.master.panel.a(getContext(), z);
        this.hJp.a(this.hJe);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtil.from(this).setTransparentStatusbar(true).process();
        createView();
        cly();
        clx();
    }

    private void clx() {
        this.hJn.addView(this.hJo);
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_white_alpha10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        layoutParams.topMargin = this.hJl;
        layoutParams.leftMargin = this.hJm;
        layoutParams.rightMargin = this.hJm;
        this.hJn.addView(view, layoutParams);
        setContentView(this.hJn);
    }

    public void a(a aVar) {
        this.hJq = aVar;
    }

    private void createView() {
        this.hJn = new FrameLayout(getContext());
        this.hJo = new NoScrollGridView(getContext());
        this.hJo.setAdapter((ListAdapter) this.hJp);
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            this.hJo.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        } else {
            findViewById.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha85));
        }
    }

    private void cly() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int navigationBarHeight = m.getNavigationBarHeight(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            attributes.width = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds370) + navigationBarHeight;
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setGravity(5);
            this.hJo.setNumColumns(2);
            this.hJo.setPadding(this.hJg, this.hJi, navigationBarHeight + this.hJh, this.hJi);
            this.hJl = ((this.hJk ? this.hJa : this.hJa * 2) + this.hJi) - getContext().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        } else {
            attributes.width = defaultDisplay.getWidth();
            if (this.hJk) {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds184) + navigationBarHeight;
            } else {
                attributes.height = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds334) + navigationBarHeight;
            }
            getWindow().setAttributes(attributes);
            getWindow().setGravity(80);
            this.hJo.setNumColumns(4);
            this.hJo.setPadding(this.hJj, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32), this.hJj, 0);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setIsBackCamera(boolean z) {
        this.hJp.a(1, z ? (short) 1 : (short) 2);
    }

    public void S(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hJp.a(2, s);
    }

    public void T(boolean z, boolean z2) {
        short s = 1;
        if (!z2) {
            s = 3;
        } else if (!z) {
            s = 2;
        }
        this.hJp.a(3, s);
    }

    public void oz(boolean z) {
        this.hJp.a(4, z ? (short) 1 : (short) 2);
    }

    public void clz() {
        this.hJp.notifyDataSetChanged();
    }
}
