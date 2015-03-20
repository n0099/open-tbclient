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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final Button acW;
    private final LinearLayout acY;
    private final LinearLayout acZ;
    private View.OnClickListener adb;
    private final LinearLayout adc;
    private SparseArray<String> adh;
    private SparseArray<com.baidu.tbadk.coreExtra.data.i> adi;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<f> ade = new SparseArray<>(7);
    private boolean adf = false;
    private final int adg = 8;
    private a adj = new e(this);
    private final List<TextView> ada = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_dialog_content, null);
    private final TextView acT = (TextView) this.mRootView.findViewById(v.share_dialog_title);
    private final View acU = this.mRootView.findViewById(v.share_dialog_content);
    private final View acX = this.mRootView.findViewById(v.line);
    private final Button acV = (Button) this.mRootView.findViewById(v.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.acV.setOnClickListener(this);
        this.acW = (Button) this.mRootView.findViewById(v.btnCopy);
        this.acW.setOnClickListener(this);
        t(y.share_weixin_timeline, u.icon_unite_share_friend);
        t(y.share_weixin, u.icon_unite_share_weixin);
        t(y.share_qzone, u.icon_unite_share_qqzon);
        t(y.share_qweibo, u.icon_unite_share_tencent);
        t(y.share_sina_weibo, u.icon_unite_share_sina);
        t(y.share_renren, u.icon_unite_share_renren);
        this.adc = (LinearLayout) this.mRootView.findViewById(v.customViewBox);
        this.acY = (LinearLayout) this.mRootView.findViewById(v.share_dialog_line_1);
        this.acZ = (LinearLayout) this.mRootView.findViewById(v.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.acY.setVisibility(8);
            this.acZ.setVisibility(8);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.acV.setOnClickListener(onClickListener);
        }
    }

    private TextView t(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(wJ());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.ada.add(textView);
        return textView;
    }

    public TextView u(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(wJ());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams wJ() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.ada.add(0, textView);
    }

    public void setIsCopyLink(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n.d(this.mContext, t.ds100));
        if (z) {
            this.acW.setVisibility(0);
            int d = n.d(this.mContext, t.ds50);
            int d2 = n.d(this.mContext, t.ds40);
            layoutParams.setMargins(d2, n.d(this.mContext, t.ds20), d2, d);
            this.acV.setLayoutParams(layoutParams);
            return;
        }
        this.acW.setVisibility(8);
        int d3 = n.d(this.mContext, t.ds50);
        int d4 = n.d(this.mContext, t.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.acV.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.adj = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.adh = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.ado = location;
        }
        this.ade.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.ado = location;
        }
        this.ade.put(i, fVar);
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

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.adb = onClickListener;
        }
    }

    public void wK() {
        int size = this.ada.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView u = u(y.share_weixin_timeline, u.icon_unite_share_friend);
                u.setVisibility(4);
                this.ada.add(u);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.acY.addView(this.ada.get(i2));
            } else {
                this.acZ.addView(this.ada.get(i2));
            }
        }
    }

    public void show() {
        if (!k.iH()) {
            n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.share_on_no_network);
            return;
        }
        wK();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(z.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.adj);
        window.setContentView(this.mRootView);
        wL();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.adf = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.k.b(this.mDialog, (Activity) this.mContext);
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
        if (this.ade.size() != 0) {
            if (view.getId() == v.btnShareCancel || !this.adf) {
                this.adf = true;
                i iVar = new i(this.mContext, this.adj);
                f cZ = cZ(1);
                if (id == v.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.adj.wG();
                } else if (id == v.btnCopy) {
                    if (this.adb != null) {
                        this.adb.onClick(this.acW);
                    }
                    if (cZ != null && cZ.adl) {
                        db(8);
                    }
                }
                if (i == u.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    da(3);
                    f cZ2 = cZ(3);
                    if (cZ2 != null) {
                        iVar.b(cZ2);
                        if (cZ2.adl) {
                            db(3);
                        }
                    }
                } else if (i == u.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    da(2);
                    f cZ3 = cZ(2);
                    if (cZ3 != null) {
                        iVar.c(cZ3);
                        if (cZ3.adl) {
                            db(2);
                        }
                    }
                } else if (i == u.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    da(4);
                    f cZ4 = cZ(4);
                    if (cZ4 != null) {
                        iVar.d(cZ4);
                        if (cZ4.adl) {
                            db(4);
                        }
                    }
                } else if (i == u.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    da(5);
                    f cZ5 = cZ(5);
                    if (cZ5 != null) {
                        iVar.e(cZ5);
                        if (cZ5.adl) {
                            db(5);
                        }
                    }
                } else if (i == u.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    da(6);
                    f cZ6 = cZ(6);
                    if (cZ6 != null) {
                        iVar.f(cZ6);
                        if (cZ6.adl) {
                            db(6);
                        }
                    }
                } else if (i == u.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    da(7);
                    f cZ7 = cZ(7);
                    if (cZ7 != null) {
                        iVar.g(cZ7);
                        if (cZ7.adl) {
                            db(7);
                        }
                    }
                }
            }
        }
    }

    private f cZ(int i) {
        f fVar = this.ade.get(i);
        if (fVar == null) {
            return this.ade.get(1);
        }
        return fVar;
    }

    private void da(int i) {
        if (i <= 7 && i > 0) {
            this.adf = true;
            if (this.adi != null) {
                com.baidu.tbadk.coreExtra.data.i iVar = this.adi.get(i);
                if (!StringUtils.isNull(iVar.uF()) && iVar.uG() != null && iVar.uG().size() > 0) {
                    c(iVar.uF(), iVar.uG());
                    return;
                }
            }
            if (this.adh != null) {
                String str = this.adh.get(i);
                if (!bd.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void db(int i) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", "loc", i, new Object[0]);
    }

    private void wL() {
        int size = this.ada.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.ada.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), s.cp_cont_f);
        }
        int paddingLeft = this.acT.getPaddingLeft();
        ba.i(this.acU, u.bg_dailog);
        ba.i((View) this.acT, u.bg_unite_popup_share_up);
        ba.b(this.acT, s.share_to, 1);
        ba.i((View) this.acV, u.btn_w_square);
        ba.b(this.acV, s.share_to, 3);
        ba.i((View) this.acW, u.btn_blue_bg);
        ba.b(this.acW, s.cp_cont_g, 3);
        ba.i(this.acX, s.cp_bg_line_b);
        this.acT.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ba.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ba.b(textView, i2, 1);
    }

    public void b(SparseArray<com.baidu.tbadk.coreExtra.data.i> sparseArray) {
        this.adi = sparseArray;
    }
}
