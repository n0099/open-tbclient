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
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final Button aem;
    private final LinearLayout aen;
    private final LinearLayout aeo;
    private View.OnClickListener aeq;
    private final LinearLayout aer;
    private SparseArray<String> aev;
    private SparseArray<j> aew;
    private final Context mContext;
    private AlertDialog mDialog;
    private final SparseArray<g> aes = new SparseArray<>(7);
    private boolean aet = false;
    private final int aeu = 8;
    private a aex = new e(this);
    private final List<TextView> aep = new ArrayList();
    private final View mRootView = com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst().getContext(), r.share_dialog_content, null);
    private final TextView aej = (TextView) this.mRootView.findViewById(q.share_dialog_title);
    private final View aek = this.mRootView.findViewById(q.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(q.line);
    private final Button ael = (Button) this.mRootView.findViewById(q.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ael.setOnClickListener(this);
        this.aem = (Button) this.mRootView.findViewById(q.btnCopy);
        this.aem.setOnClickListener(this);
        u(t.share_weixin_timeline, p.icon_unite_share_friend);
        u(t.share_weixin, p.icon_unite_share_weixin);
        u(t.share_qzone, p.icon_unite_share_qqzon);
        u(t.share_qweibo, p.icon_unite_share_tencent);
        u(t.share_sina_weibo, p.icon_unite_share_sina);
        u(t.share_renren, p.icon_unite_share_renren);
        this.aer = (LinearLayout) this.mRootView.findViewById(q.customViewBox);
        this.aen = (LinearLayout) this.mRootView.findViewById(q.share_dialog_line_1);
        this.aeo = (LinearLayout) this.mRootView.findViewById(q.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.aen.setVisibility(8);
            this.aeo.setVisibility(8);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ael.setOnClickListener(onClickListener);
        }
    }

    private TextView u(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst().getContext(), r.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(xD());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.aep.add(textView);
        return textView;
    }

    public TextView v(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst().getContext(), r.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(xD());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams xD() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.aep.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.aep.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new f(this, onClickListener));
        }
    }

    public void setIsCopyLink(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n.d(this.mContext, o.ds100));
        if (z) {
            this.aem.setVisibility(0);
            int d = n.d(this.mContext, o.ds50);
            int d2 = n.d(this.mContext, o.ds40);
            layoutParams.setMargins(d2, n.d(this.mContext, o.ds20), d2, d);
            this.ael.setLayoutParams(layoutParams);
            return;
        }
        this.aem.setVisibility(8);
        int d3 = n.d(this.mContext, o.ds50);
        int d4 = n.d(this.mContext, o.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.ael.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.aex = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.aev = sparseArray;
    }

    public void a(g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.aes.put(1, gVar);
    }

    public void a(int i, g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.aes.put(i, gVar);
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
            this.aeq = onClickListener;
        }
    }

    public void xE() {
        int size = this.aep.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView v = v(t.share_weixin_timeline, p.icon_unite_share_friend);
                v.setVisibility(4);
                this.aep.add(v);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.aen.addView(this.aep.get(i2));
            } else {
                this.aeo.addView(this.aep.get(i2));
            }
        }
    }

    public void show() {
        if (!k.iX()) {
            n.showToast(TbadkCoreApplication.m411getInst().getContext(), t.share_on_no_network);
            return;
        }
        xE();
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.k.a(this.mDialog, (Activity) this.mContext);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(u.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.aex);
        window.setContentView(this.mRootView);
        xF();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.aet = false;
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
        if (this.aes.size() != 0) {
            if (view.getId() == q.btnShareCancel || !this.aet) {
                this.aet = true;
                i iVar = new i(this.mContext, this.aex);
                g di = di(1);
                if (id == q.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.aex.xA();
                } else if (id == q.btnCopy) {
                    if (this.aeq != null) {
                        this.aeq.onClick(this.aem);
                    }
                    if (di != null && di.aeA) {
                        o(8, di.aeB);
                    }
                }
                if (i == p.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    dj(3);
                    g di2 = di(3);
                    if (di2 != null) {
                        iVar.b(di2);
                        if (di2.aeA) {
                            o(3, di2.aeB);
                        }
                    }
                } else if (i == p.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    dj(2);
                    g di3 = di(2);
                    if (di3 != null) {
                        iVar.c(di3);
                        if (di3.aeA) {
                            o(3, di3.aeB);
                        }
                    }
                } else if (i == p.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    dj(4);
                    g di4 = di(4);
                    if (di4 != null) {
                        iVar.d(di4);
                        if (di4.aeA) {
                            o(3, di4.aeB);
                        }
                    }
                } else if (i == p.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    dj(5);
                    g di5 = di(5);
                    if (di5 != null) {
                        iVar.e(di5);
                        if (di5.aeA) {
                            o(3, di5.aeB);
                        }
                    }
                } else if (i == p.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    dj(6);
                    g di6 = di(6);
                    if (di6 != null) {
                        iVar.f(di6);
                        if (di6.aeA) {
                            o(3, di6.aeB);
                        }
                    }
                } else if (i == p.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    dj(7);
                    g di7 = di(7);
                    if (di7 != null) {
                        iVar.g(di7);
                        if (di7.aeA) {
                            o(3, di7.aeB);
                        }
                    }
                }
            }
        }
    }

    private g di(int i) {
        g gVar = this.aes.get(i);
        if (gVar == null) {
            return this.aes.get(1);
        }
        return gVar;
    }

    private void dj(int i) {
        if (i <= 7 && i > 0) {
            this.aet = true;
            if (this.aew != null) {
                j jVar = this.aew.get(i);
                if (!StringUtils.isNull(jVar.vs()) && jVar.vt() != null && jVar.vt().size() > 0) {
                    c(jVar.vs(), jVar.vt());
                    return;
                }
            }
            if (this.aev != null) {
                String str = this.aev.get(i);
                if (!bb.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void o(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void xF() {
        int size = this.aep.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.aep.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), com.baidu.tieba.n.cp_cont_f);
        }
        int paddingLeft = this.aej.getPaddingLeft();
        ay.i(this.aek, p.bg_dailog);
        ay.i((View) this.aej, p.bg_unite_popup_share_up);
        ay.b(this.aej, com.baidu.tieba.n.share_to, 1);
        ay.i((View) this.ael, p.btn_w_square);
        ay.b(this.ael, com.baidu.tieba.n.share_to, 3);
        ay.i((View) this.aem, p.btn_blue_bg);
        ay.b(this.aem, com.baidu.tieba.n.cp_cont_g, 3);
        ay.i(this.mLine, com.baidu.tieba.n.cp_bg_line_b);
        this.aej.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ay.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ay.b(textView, i2, 1);
    }

    public void b(SparseArray<j> sparseArray) {
        this.aew = sparseArray;
    }
}
