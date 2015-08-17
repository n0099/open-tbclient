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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private AlertDialog Ww;
    private SparseArray<String> ajC;
    private SparseArray<j> ajD;
    private final Button aju;
    private final LinearLayout ajv;
    private final LinearLayout ajw;
    private View.OnClickListener ajy;
    private final LinearLayout ajz;
    private final Context mContext;
    private final SparseArray<f> ajA = new SparseArray<>(7);
    private boolean ajB = false;
    private com.baidu.tbadk.coreExtra.share.a ajE = new e(this);
    private final List<TextView> ajx = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_dialog_content, (ViewGroup) null);
    private final TextView ajr = (TextView) this.mRootView.findViewById(i.f.share_dialog_title);
    private final View ajs = this.mRootView.findViewById(i.f.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(i.f.line);
    private final Button ajt = (Button) this.mRootView.findViewById(i.f.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ajt.setOnClickListener(this);
        this.aju = (Button) this.mRootView.findViewById(i.f.btnCopy);
        this.aju.setOnClickListener(this);
        E(i.C0057i.share_weixin_timeline, i.e.icon_unite_share_friend);
        E(i.C0057i.share_weixin, i.e.icon_unite_share_weixin);
        E(i.C0057i.share_qzone, i.e.icon_unite_share_qqzon);
        E(i.C0057i.share_qweibo, i.e.icon_unite_share_tencent);
        E(i.C0057i.share_sina_weibo, i.e.icon_unite_share_sina);
        E(i.C0057i.share_renren, i.e.icon_unite_share_renren);
        this.ajz = (LinearLayout) this.mRootView.findViewById(i.f.customViewBox);
        this.ajv = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_1);
        this.ajw = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.ajv.setVisibility(8);
            this.ajw.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ajt.setOnClickListener(onClickListener);
        }
    }

    private TextView E(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yM());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.ajx.add(textView);
        return textView;
    }

    public TextView F(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yM());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams yM() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.ajx.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.ajx.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener ajG;

        public a(View.OnClickListener onClickListener) {
            this.ajG = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.ajG != null) {
                this.ajG.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, k.d(this.mContext, i.d.ds100));
        if (z) {
            this.aju.setVisibility(0);
            int d = k.d(this.mContext, i.d.ds50);
            int d2 = k.d(this.mContext, i.d.ds40);
            layoutParams.setMargins(d2, k.d(this.mContext, i.d.ds20), d2, d);
            this.ajt.setLayoutParams(layoutParams);
            return;
        }
        this.aju.setVisibility(8);
        int d3 = k.d(this.mContext, i.d.ds50);
        int d4 = k.d(this.mContext, i.d.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.ajt.setLayoutParams(layoutParams);
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.ajE = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.ajC = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajA.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajA.put(i, fVar);
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
            this.ajy = onClickListener;
        }
    }

    public void yN() {
        int size = this.ajx.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView F = F(i.C0057i.share_weixin_timeline, i.e.icon_unite_share_friend);
                F.setVisibility(4);
                this.ajx.add(F);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.ajv.addView(this.ajx.get(i2));
            } else {
                this.ajw.addView(this.ajx.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.iO()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.C0057i.share_on_no_network);
            return;
        }
        yN();
        this.Ww = new AlertDialog.Builder(this.mContext).create();
        this.Ww.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.a(this.Ww, (Activity) this.mContext);
        }
        Window window = this.Ww.getWindow();
        window.setWindowAnimations(i.j.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.ajE);
        window.setContentView(this.mRootView);
        yO();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Ww.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Ww != null) {
            this.ajB = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.Ww, (Activity) this.mContext);
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
        if (this.ajA.size() != 0) {
            if (view.getId() == i.f.btnShareCancel || !this.ajB) {
                this.ajB = true;
                h hVar = new h(this.mContext, this.ajE);
                f dt = dt(1);
                if (id == i.f.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.ajE.yJ();
                } else if (id == i.f.btnCopy) {
                    if (this.ajy != null) {
                        this.ajy.onClick(this.aju);
                    }
                    if (dt != null && dt.ajH) {
                        q(8, dt.ajI);
                    }
                }
                if (i == i.e.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    du(3);
                    f dt2 = dt(3);
                    if (dt2 != null) {
                        hVar.b(dt2);
                        if (dt2.ajH) {
                            q(3, dt2.ajI);
                        }
                    }
                } else if (i == i.e.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    du(2);
                    f dt3 = dt(2);
                    if (dt3 != null) {
                        hVar.c(dt3);
                        if (dt3.ajH) {
                            q(3, dt3.ajI);
                        }
                    }
                } else if (i == i.e.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    du(4);
                    f dt4 = dt(4);
                    if (dt4 != null) {
                        hVar.d(dt4);
                        if (dt4.ajH) {
                            q(3, dt4.ajI);
                        }
                    }
                } else if (i == i.e.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    du(5);
                    f dt5 = dt(5);
                    if (dt5 != null) {
                        hVar.e(dt5);
                        if (dt5.ajH) {
                            q(3, dt5.ajI);
                        }
                    }
                } else if (i == i.e.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    du(6);
                    f dt6 = dt(6);
                    if (dt6 != null) {
                        hVar.f(dt6);
                        if (dt6.ajH) {
                            q(3, dt6.ajI);
                        }
                    }
                } else if (i == i.e.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    du(7);
                    f dt7 = dt(7);
                    if (dt7 != null) {
                        hVar.g(dt7);
                        if (dt7.ajH) {
                            q(3, dt7.ajI);
                        }
                    }
                }
            }
        }
    }

    private f dt(int i) {
        f fVar = this.ajA.get(i);
        if (fVar == null) {
            return this.ajA.get(1);
        }
        return fVar;
    }

    private void du(int i) {
        if (i <= 7 && i > 0) {
            this.ajB = true;
            if (this.ajD != null) {
                j jVar = this.ajD.get(i);
                if (!StringUtils.isNull(jVar.wz()) && jVar.wA() != null && jVar.wA().size() > 0) {
                    c(jVar.wz(), jVar.wA());
                    return;
                }
            }
            if (this.ajC != null) {
                String str = this.ajC.get(i);
                if (!aq.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void q(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void yO() {
        int size = this.ajx.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.ajx.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), i.c.cp_cont_f);
        }
        int paddingLeft = this.ajr.getPaddingLeft();
        al.i(this.ajs, i.e.bg_dailog);
        al.i((View) this.ajr, i.e.bg_unite_popup_share_up);
        al.b(this.ajr, i.c.share_to, 1);
        al.i((View) this.ajt, i.e.btn_w_square);
        al.b(this.ajt, i.c.share_to, 3);
        al.i((View) this.aju, i.e.btn_blue_bg);
        al.b(this.aju, i.c.cp_cont_g, 3);
        al.i(this.mLine, i.c.cp_bg_line_b);
        this.ajr.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = al.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        al.b(textView, i2, 1);
    }

    public void b(SparseArray<j> sparseArray) {
        this.ajD = sparseArray;
    }
}
