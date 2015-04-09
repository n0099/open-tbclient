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
import com.baidu.tbadk.coreExtra.data.j;
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
    private final Button adf;
    private final LinearLayout adh;
    private final LinearLayout adi;
    private View.OnClickListener adk;
    private final LinearLayout adl;
    private SparseArray<String> adp;
    private SparseArray<j> adq;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<f> adm = new SparseArray<>(7);
    private boolean adn = false;
    private final int ado = 8;
    private a adr = new e(this);
    private final List<TextView> adj = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_dialog_content, null);
    private final TextView adb = (TextView) this.mRootView.findViewById(v.share_dialog_title);
    private final View adc = this.mRootView.findViewById(v.share_dialog_content);
    private final View adg = this.mRootView.findViewById(v.line);
    private final Button ade = (Button) this.mRootView.findViewById(v.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ade.setOnClickListener(this);
        this.adf = (Button) this.mRootView.findViewById(v.btnCopy);
        this.adf.setOnClickListener(this);
        t(y.share_weixin_timeline, u.icon_unite_share_friend);
        t(y.share_weixin, u.icon_unite_share_weixin);
        t(y.share_qzone, u.icon_unite_share_qqzon);
        t(y.share_qweibo, u.icon_unite_share_tencent);
        t(y.share_sina_weibo, u.icon_unite_share_sina);
        t(y.share_renren, u.icon_unite_share_renren);
        this.adl = (LinearLayout) this.mRootView.findViewById(v.customViewBox);
        this.adh = (LinearLayout) this.mRootView.findViewById(v.share_dialog_line_1);
        this.adi = (LinearLayout) this.mRootView.findViewById(v.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.adh.setVisibility(8);
            this.adi.setVisibility(8);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ade.setOnClickListener(onClickListener);
        }
    }

    private TextView t(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(wP());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.adj.add(textView);
        return textView;
    }

    public TextView u(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst().getContext(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(wP());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams wP() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.adj.add(0, textView);
    }

    public void setIsCopyLink(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n.d(this.mContext, t.ds100));
        if (z) {
            this.adf.setVisibility(0);
            int d = n.d(this.mContext, t.ds50);
            int d2 = n.d(this.mContext, t.ds40);
            layoutParams.setMargins(d2, n.d(this.mContext, t.ds20), d2, d);
            this.ade.setLayoutParams(layoutParams);
            return;
        }
        this.adf.setVisibility(8);
        int d3 = n.d(this.mContext, t.ds50);
        int d4 = n.d(this.mContext, t.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.ade.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.adr = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.adp = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.adw = location;
        }
        this.adm.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.adw = location;
        }
        this.adm.put(i, fVar);
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
            this.adk = onClickListener;
        }
    }

    public void wQ() {
        int size = this.adj.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView u = u(y.share_weixin_timeline, u.icon_unite_share_friend);
                u.setVisibility(4);
                this.adj.add(u);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.adh.addView(this.adj.get(i2));
            } else {
                this.adi.addView(this.adj.get(i2));
            }
        }
    }

    public void show() {
        if (!k.iH()) {
            n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.share_on_no_network);
            return;
        }
        wQ();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(z.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.adr);
        window.setContentView(this.mRootView);
        wR();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.adn = false;
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
        if (this.adm.size() != 0) {
            if (view.getId() == v.btnShareCancel || !this.adn) {
                this.adn = true;
                i iVar = new i(this.mContext, this.adr);
                f cZ = cZ(1);
                if (id == v.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.adr.wM();
                } else if (id == v.btnCopy) {
                    if (this.adk != null) {
                        this.adk.onClick(this.adf);
                    }
                    if (cZ != null && cZ.adt) {
                        db(8);
                    }
                }
                if (i == u.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    da(3);
                    f cZ2 = cZ(3);
                    if (cZ2 != null) {
                        iVar.b(cZ2);
                        if (cZ2.adt) {
                            db(3);
                        }
                    }
                } else if (i == u.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    da(2);
                    f cZ3 = cZ(2);
                    if (cZ3 != null) {
                        iVar.c(cZ3);
                        if (cZ3.adt) {
                            db(2);
                        }
                    }
                } else if (i == u.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    da(4);
                    f cZ4 = cZ(4);
                    if (cZ4 != null) {
                        iVar.d(cZ4);
                        if (cZ4.adt) {
                            db(4);
                        }
                    }
                } else if (i == u.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    da(5);
                    f cZ5 = cZ(5);
                    if (cZ5 != null) {
                        iVar.e(cZ5);
                        if (cZ5.adt) {
                            db(5);
                        }
                    }
                } else if (i == u.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    da(6);
                    f cZ6 = cZ(6);
                    if (cZ6 != null) {
                        iVar.f(cZ6);
                        if (cZ6.adt) {
                            db(6);
                        }
                    }
                } else if (i == u.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    da(7);
                    f cZ7 = cZ(7);
                    if (cZ7 != null) {
                        iVar.g(cZ7);
                        if (cZ7.adt) {
                            db(7);
                        }
                    }
                }
            }
        }
    }

    private f cZ(int i) {
        f fVar = this.adm.get(i);
        if (fVar == null) {
            return this.adm.get(1);
        }
        return fVar;
    }

    private void da(int i) {
        if (i <= 7 && i > 0) {
            this.adn = true;
            if (this.adq != null) {
                j jVar = this.adq.get(i);
                if (!StringUtils.isNull(jVar.uI()) && jVar.uJ() != null && jVar.uJ().size() > 0) {
                    c(jVar.uI(), jVar.uJ());
                    return;
                }
            }
            if (this.adp != null) {
                String str = this.adp.get(i);
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

    private void wR() {
        int size = this.adj.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.adj.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), s.cp_cont_f);
        }
        int paddingLeft = this.adb.getPaddingLeft();
        ba.i(this.adc, u.bg_dailog);
        ba.i((View) this.adb, u.bg_unite_popup_share_up);
        ba.b(this.adb, s.share_to, 1);
        ba.i((View) this.ade, u.btn_w_square);
        ba.b(this.ade, s.share_to, 3);
        ba.i((View) this.adf, u.btn_blue_bg);
        ba.b(this.adf, s.cp_cont_g, 3);
        ba.i(this.adg, s.cp_bg_line_b);
        this.adb.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ba.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ba.b(textView, i2, 1);
    }

    public void b(SparseArray<j> sparseArray) {
        this.adq = sparseArray;
    }
}
