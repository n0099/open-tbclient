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
    private final Button SZ;
    private final LinearLayout Tb;
    private final LinearLayout Tc;
    private View.OnClickListener Te;
    private final LinearLayout Tf;
    private SparseArray<String> Tj;
    private SparseArray<i> Tk;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<f> Tg = new SparseArray<>(7);
    private boolean Th = false;
    private final int Ti = 8;
    private a Tl = new e(this);
    private final List<TextView> Td = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_dialog_content, null);
    private final TextView SW = (TextView) this.mRootView.findViewById(w.share_dialog_title);
    private final View SX = this.mRootView.findViewById(w.share_dialog_content);
    private final View Ta = this.mRootView.findViewById(w.line);
    private final Button SY = (Button) this.mRootView.findViewById(w.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.SY.setOnClickListener(this);
        this.SZ = (Button) this.mRootView.findViewById(w.btnCopy);
        this.SZ.setOnClickListener(this);
        v(z.share_weixin_timeline, v.icon_unite_share_friend);
        v(z.share_weixin, v.icon_unite_share_weixin);
        v(z.share_qzone, v.icon_unite_share_qqzon);
        v(z.share_qweibo, v.icon_unite_share_tencent);
        v(z.share_sina_weibo, v.icon_unite_share_sina);
        v(z.share_renren, v.icon_unite_share_renren);
        this.Tf = (LinearLayout) this.mRootView.findViewById(w.customViewBox);
        this.Tb = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_1);
        this.Tc = (LinearLayout) this.mRootView.findViewById(w.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.Tb.setVisibility(8);
            this.Tc.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.SY.setOnClickListener(onClickListener);
        }
    }

    private TextView v(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tr());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.Td.add(textView);
        return textView;
    }

    public TextView w(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), x.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m255getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(tr());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams tr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.Td.add(0, textView);
    }

    public void ay(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.d(this.mContext, u.ds100));
        if (z) {
            this.SZ.setVisibility(0);
            int d = l.d(this.mContext, u.ds50);
            int d2 = l.d(this.mContext, u.ds40);
            layoutParams.setMargins(d2, l.d(this.mContext, u.ds20), d2, d);
            this.SY.setLayoutParams(layoutParams);
            return;
        }
        this.SZ.setVisibility(8);
        int d3 = l.d(this.mContext, u.ds50);
        int d4 = l.d(this.mContext, u.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.SY.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.Tl = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.Tj = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.Tp = location;
        }
        this.Tg.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.Tp = location;
        }
        this.Tg.put(i, fVar);
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
            this.Te = onClickListener;
        }
    }

    public void ts() {
        int size = this.Td.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView w = w(z.share_weixin_timeline, v.icon_unite_share_friend);
                w.setVisibility(4);
                this.Td.add(w);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.Tb.addView(this.Td.get(i2));
            } else {
                this.Tc.addView(this.Td.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.ff()) {
            l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.share_on_no_network);
            return;
        }
        ts();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(aa.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.Tl);
        window.setContentView(this.mRootView);
        tt();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.Th = false;
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
        if (this.Tg.size() != 0) {
            if (view.getId() == w.btnShareCancel || !this.Th) {
                this.Th = true;
                g gVar = new g(this.mContext, this.Tl);
                if (id == w.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.Tl.to();
                } else if (id == w.btnCopy && this.Te != null) {
                    this.Te.onClick(this.SZ);
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
        f fVar = this.Tg.get(i);
        if (fVar == null) {
            return this.Tg.get(1);
        }
        return fVar;
    }

    private void cZ(int i) {
        if (i <= 7 && i > 0) {
            this.Th = true;
            if (this.Tk != null) {
                i iVar = this.Tk.get(i);
                if (!StringUtils.isNull(iVar.rI()) && iVar.rJ() != null && iVar.rJ().size() > 0) {
                    c(iVar.rI(), iVar.rJ());
                    return;
                }
            }
            if (this.Tj != null) {
                String str = this.Tj.get(i);
                if (!bf.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void tt() {
        int size = this.Td.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.Td.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.cp_cont_f);
        }
        int paddingLeft = this.SW.getPaddingLeft();
        bc.i(this.SX, v.bg_dailog);
        bc.i((View) this.SW, v.bg_unite_popup_share_up);
        bc.b(this.SW, t.share_to, 1);
        bc.i((View) this.SY, v.btn_w_square);
        bc.b(this.SY, t.share_to, 3);
        bc.i((View) this.SZ, v.btn_blue_bg);
        bc.b(this.SZ, t.cp_cont_g, 3);
        bc.i(this.Ta, t.cp_bg_line_b);
        this.SW.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = bc.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        bc.b(textView, i2, 1);
    }

    public void b(SparseArray<i> sparseArray) {
        this.Tk = sparseArray;
    }
}
