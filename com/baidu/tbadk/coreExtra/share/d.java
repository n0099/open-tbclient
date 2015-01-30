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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
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
    private final Button Tc;
    private final LinearLayout Te;
    private final LinearLayout Tf;
    private View.OnClickListener Th;
    private final LinearLayout Ti;
    private SparseArray<String> Tm;
    private SparseArray<i> Tn;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<f> Tj = new SparseArray<>(7);
    private boolean Tk = false;
    private final int Tl = 8;
    private a To = new e(this);
    private final List<TextView> Tg = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_dialog_content, null);
    private final TextView SZ = (TextView) this.mRootView.findViewById(w.share_dialog_title);
    private final View Ta = this.mRootView.findViewById(w.share_dialog_content);
    private final View Td = this.mRootView.findViewById(w.line);
    private final Button Tb = (Button) this.mRootView.findViewById(w.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.Tb.setOnClickListener(this);
        this.Tc = (Button) this.mRootView.findViewById(w.btnCopy);
        this.Tc.setOnClickListener(this);
        v(z.share_weixin_timeline, v.icon_unite_share_friend);
        v(z.share_weixin, v.icon_unite_share_weixin);
        v(z.share_qzone, v.icon_unite_share_qqzon);
        v(z.share_qweibo, v.icon_unite_share_tencent);
        v(z.share_sina_weibo, v.icon_unite_share_sina);
        v(z.share_renren, v.icon_unite_share_renren);
        this.Ti = (LinearLayout) this.mRootView.findViewById(w.customViewBox);
        this.Te = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_1);
        this.Tf = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.gW().gZ()) == null) {
            this.Te.setVisibility(8);
            this.Tf.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.Tb.setOnClickListener(onClickListener);
        }
    }

    private TextView v(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tx());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.Tg.add(textView);
        return textView;
    }

    public TextView w(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tx());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams tx() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.Tg.add(0, textView);
    }

    public void ay(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.d(this.mContext, u.ds100));
        if (z) {
            this.Tc.setVisibility(0);
            int d = l.d(this.mContext, u.ds50);
            int d2 = l.d(this.mContext, u.ds40);
            layoutParams.setMargins(d2, l.d(this.mContext, u.ds20), d2, d);
            this.Tb.setLayoutParams(layoutParams);
            return;
        }
        this.Tc.setVisibility(8);
        int d3 = l.d(this.mContext, u.ds50);
        int d4 = l.d(this.mContext, u.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.Tb.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.To = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.Tm = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.Ts = location;
        }
        this.Tj.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.Ts = location;
        }
        this.Tj.put(i, fVar);
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

    public void d(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.Th = onClickListener;
        }
    }

    public void ty() {
        int size = this.Tg.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView w = w(z.share_weixin_timeline, v.icon_unite_share_friend);
                w.setVisibility(4);
                this.Tg.add(w);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.Te.addView(this.Tg.get(i2));
            } else {
                this.Tf.addView(this.Tg.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.ff()) {
            l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.share_on_no_network);
            return;
        }
        ty();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(aa.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.To);
        window.setContentView(this.mRootView);
        tz();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.Tk = false;
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
        if (this.Tj.size() != 0) {
            if (view.getId() == w.btnShareCancel || !this.Tk) {
                this.Tk = true;
                g gVar = new g(this.mContext, this.To);
                if (id == w.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.To.tu();
                } else if (id == w.btnCopy && this.Th != null) {
                    this.Th.onClick(this.Tc);
                }
                if (i == v.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    cZ(3);
                    f cY = cY(3);
                    if (cY != null) {
                        gVar.a(cY);
                    }
                } else if (i == v.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    cZ(2);
                    f cY2 = cY(2);
                    if (cY2 != null) {
                        gVar.b(cY2);
                    }
                } else if (i == v.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    cZ(4);
                    f cY3 = cY(4);
                    if (cY3 != null) {
                        gVar.c(cY3);
                    }
                } else if (i == v.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    cZ(5);
                    f cY4 = cY(5);
                    if (cY4 != null) {
                        gVar.d(cY4);
                    }
                } else if (i == v.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    cZ(6);
                    f cY5 = cY(6);
                    if (cY5 != null) {
                        gVar.e(cY5);
                    }
                } else if (i == v.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    cZ(7);
                    f cY6 = cY(7);
                    if (cY6 != null) {
                        gVar.f(cY6);
                    }
                }
            }
        }
    }

    private f cY(int i) {
        f fVar = this.Tj.get(i);
        if (fVar == null) {
            return this.Tj.get(1);
        }
        return fVar;
    }

    private void cZ(int i) {
        if (i <= 7 && i > 0) {
            this.Tk = true;
            if (this.Tn != null) {
                i iVar = this.Tn.get(i);
                if (!StringUtils.isNull(iVar.rO()) && iVar.rP() != null && iVar.rP().size() > 0) {
                    c(iVar.rO(), iVar.rP());
                    return;
                }
            }
            if (this.Tm != null) {
                String str = this.Tm.get(i);
                if (!bf.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void tz() {
        int size = this.Tg.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.Tg.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.cp_cont_f);
        }
        int paddingLeft = this.SZ.getPaddingLeft();
        bc.i(this.Ta, v.bg_dailog);
        bc.i((View) this.SZ, v.bg_unite_popup_share_up);
        bc.b(this.SZ, t.share_to, 1);
        bc.i((View) this.Tb, v.btn_w_square);
        bc.b(this.Tb, t.share_to, 3);
        bc.i((View) this.Tc, v.btn_blue_bg);
        bc.b(this.Tc, t.cp_cont_g, 3);
        bc.i(this.Td, t.cp_bg_line_b);
        this.SZ.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = bc.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        bc.b(textView, i2, 1);
    }

    public void b(SparseArray<i> sparseArray) {
        this.Tn = sparseArray;
    }
}
