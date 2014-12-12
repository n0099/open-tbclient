package com.baidu.tbadk.coreExtra.share;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.aa;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private View.OnClickListener SA;
    private final LinearLayout SB;
    private SparseArray<String> SF;
    private SparseArray<i> SG;
    private final Button Sw;
    private final LinearLayout Sx;
    private final LinearLayout Sy;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<f> SC = new SparseArray<>(7);
    private boolean SD = false;
    private final int SE = 8;
    private a SH = new e(this);
    private final List<TextView> Sz = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.ek().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_dialog_content, null);
    private final TextView St = (TextView) this.mRootView.findViewById(w.share_dialog_title);
    private final View Su = this.mRootView.findViewById(w.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(w.line);
    private final Button Sv = (Button) this.mRootView.findViewById(w.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.Sv.setOnClickListener(this);
        this.Sw = (Button) this.mRootView.findViewById(w.btnCopy);
        this.Sw.setOnClickListener(this);
        v(z.share_weixin_timeline, v.icon_unite_share_friend);
        v(z.share_weixin, v.icon_unite_share_weixin);
        v(z.share_qzone, v.icon_unite_share_qqzon);
        v(z.share_qweibo, v.icon_unite_share_tencent);
        v(z.share_sina_weibo, v.icon_unite_share_sina);
        v(z.share_renren, v.icon_unite_share_renren);
        this.SB = (LinearLayout) this.mRootView.findViewById(w.customViewBox);
        this.Sx = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_1);
        this.Sy = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.gX().ha()) == null) {
            this.Sx.setVisibility(8);
            this.Sy.setVisibility(8);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.Sv.setOnClickListener(onClickListener);
        }
    }

    private TextView v(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tg());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.Sz.add(textView);
        return textView;
    }

    public TextView w(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tg());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams tg() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.Sz.add(0, textView);
    }

    public void aw(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.d(this.mContext, u.ds100));
        if (z) {
            this.Sw.setVisibility(0);
            int d = l.d(this.mContext, u.ds50);
            int d2 = l.d(this.mContext, u.ds40);
            layoutParams.setMargins(d2, l.d(this.mContext, u.ds20), d2, d);
            this.Sv.setLayoutParams(layoutParams);
            return;
        }
        this.Sw.setVisibility(8);
        int d3 = l.d(this.mContext, u.ds50);
        int d4 = l.d(this.mContext, u.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.Sv.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.SH = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.SF = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.SM = location;
        }
        this.SC.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.SM = location;
        }
        this.SC.put(i, fVar);
    }

    private Location getLocation() {
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        try {
            return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        } catch (Exception e) {
            return null;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.SA = onClickListener;
        }
    }

    public void th() {
        int size = this.Sz.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView w = w(z.share_weixin_timeline, v.icon_unite_share_friend);
                w.setVisibility(4);
                this.Sz.add(w);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.Sx.addView(this.Sz.get(i2));
            } else {
                this.Sy.addView(this.Sz.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.fg()) {
            l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.share_on_no_network);
            return;
        }
        th();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(aa.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.SH);
        window.setContentView(this.mRootView);
        ti();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.SD = false;
            if (this.mContext instanceof Activity) {
                k.b(this.mDialog, (Activity) this.mContext);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int i = -1;
        if (view.getTag() != null) {
            i = ((Integer) view.getTag()).intValue();
        }
        dismiss();
        if (this.SC.size() != 0) {
            if (view.getId() == w.btnShareCancel || !this.SD) {
                this.SD = true;
                g gVar = new g(this.mContext, this.SH);
                if (id == w.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.SH.td();
                } else if (id == w.btnCopy && this.SA != null) {
                    this.SA.onClick(this.Sw);
                }
                if (i == v.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    cS(3);
                    f cR = cR(3);
                    if (cR != null) {
                        gVar.a(cR);
                    }
                } else if (i == v.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    cS(2);
                    f cR2 = cR(2);
                    if (cR2 != null) {
                        gVar.b(cR2);
                    }
                } else if (i == v.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    cS(4);
                    f cR3 = cR(4);
                    if (cR3 != null) {
                        gVar.c(cR3);
                    }
                } else if (i == v.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    cS(5);
                    f cR4 = cR(5);
                    if (cR4 != null) {
                        gVar.d(cR4);
                    }
                } else if (i == v.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    cS(6);
                    f cR5 = cR(6);
                    if (cR5 != null) {
                        gVar.e(cR5);
                    }
                } else if (i == v.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    cS(7);
                    f cR6 = cR(7);
                    if (cR6 != null) {
                        gVar.f(cR6);
                    }
                }
            }
        }
    }

    private f cR(int i) {
        f fVar = this.SC.get(i);
        if (fVar == null) {
            return this.SC.get(1);
        }
        return fVar;
    }

    private void cS(int i) {
        if (i <= 7 && i > 0) {
            this.SD = true;
            if (this.SG != null) {
                i iVar = this.SG.get(i);
                if (!StringUtils.isNull(iVar.rB()) && iVar.rC() != null && iVar.rC().size() > 0) {
                    c(iVar.rB(), iVar.rC());
                    return;
                }
            }
            if (this.SF != null) {
                String str = this.SF.get(i);
                if (!ba.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void ti() {
        int size = this.Sz.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.Sz.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.cp_cont_f);
        }
        int paddingLeft = this.St.getPaddingLeft();
        ax.i(this.Su, v.bg_dailog);
        ax.i((View) this.St, v.bg_unite_popup_share_up);
        ax.b(this.St, t.share_to, 1);
        ax.i((View) this.Sv, v.btn_w_square);
        ax.b(this.Sv, t.share_to, 3);
        ax.i((View) this.Sw, v.btn_blue_bg);
        ax.b(this.Sw, t.cp_cont_g, 3);
        ax.i(this.mLine, t.cp_bg_line_b);
        this.St.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ax.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ax.b(textView, i2, 1);
    }

    public void b(SparseArray<i> sparseArray) {
        this.SG = sparseArray;
    }
}
