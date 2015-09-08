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
    private AlertDialog WE;
    private final Button ajD;
    private final LinearLayout ajE;
    private final LinearLayout ajF;
    private View.OnClickListener ajH;
    private final LinearLayout ajI;
    private SparseArray<String> ajL;
    private SparseArray<j> ajM;
    private final Context mContext;
    private final SparseArray<f> ajJ = new SparseArray<>(7);
    private boolean ajK = false;
    private com.baidu.tbadk.coreExtra.share.a ajN = new e(this);
    private final List<TextView> ajG = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_dialog_content, (ViewGroup) null);
    private final TextView ajA = (TextView) this.mRootView.findViewById(i.f.share_dialog_title);
    private final View ajB = this.mRootView.findViewById(i.f.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(i.f.line);
    private final Button ajC = (Button) this.mRootView.findViewById(i.f.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ajC.setOnClickListener(this);
        this.ajD = (Button) this.mRootView.findViewById(i.f.btnCopy);
        this.ajD.setOnClickListener(this);
        E(i.h.share_weixin_timeline, i.e.icon_unite_share_friend);
        E(i.h.share_weixin, i.e.icon_unite_share_weixin);
        E(i.h.share_qzone, i.e.icon_unite_share_qqzon);
        E(i.h.share_qweibo, i.e.icon_unite_share_tencent);
        E(i.h.share_sina_weibo, i.e.icon_unite_share_sina);
        E(i.h.share_renren, i.e.icon_unite_share_renren);
        this.ajI = (LinearLayout) this.mRootView.findViewById(i.f.customViewBox);
        this.ajE = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_1);
        this.ajF = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.ajE.setVisibility(8);
            this.ajF.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ajC.setOnClickListener(onClickListener);
        }
    }

    private TextView E(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yT());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.ajG.add(textView);
        return textView;
    }

    public TextView F(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yT());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams yT() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.ajG.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.ajG.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener ajP;

        public a(View.OnClickListener onClickListener) {
            this.ajP = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.ajP != null) {
                this.ajP.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, k.d(this.mContext, i.d.ds100));
        if (z) {
            this.ajD.setVisibility(0);
            int d = k.d(this.mContext, i.d.ds50);
            int d2 = k.d(this.mContext, i.d.ds40);
            layoutParams.setMargins(d2, k.d(this.mContext, i.d.ds20), d2, d);
            this.ajC.setLayoutParams(layoutParams);
            return;
        }
        this.ajD.setVisibility(8);
        int d3 = k.d(this.mContext, i.d.ds50);
        int d4 = k.d(this.mContext, i.d.ds40);
        layoutParams.setMargins(d4, d3, d4, d3);
        this.ajC.setLayoutParams(layoutParams);
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.ajN = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.ajL = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajJ.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajJ.put(i, fVar);
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
            this.ajH = onClickListener;
        }
    }

    public void yU() {
        int size = this.ajG.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView F = F(i.h.share_weixin_timeline, i.e.icon_unite_share_friend);
                F.setVisibility(4);
                this.ajG.add(F);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.ajE.addView(this.ajG.get(i2));
            } else {
                this.ajF.addView(this.ajG.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.iL()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.share_on_no_network);
            return;
        }
        yU();
        this.WE = new AlertDialog.Builder(this.mContext).create();
        this.WE.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.a(this.WE, (Activity) this.mContext);
        }
        Window window = this.WE.getWindow();
        window.setWindowAnimations(i.C0057i.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.ajN);
        window.setContentView(this.mRootView);
        yV();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.WE.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.WE != null) {
            this.ajK = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.WE, (Activity) this.mContext);
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
        if (this.ajJ.size() != 0) {
            if (view.getId() == i.f.btnShareCancel || !this.ajK) {
                this.ajK = true;
                h hVar = new h(this.mContext, this.ajN);
                f dz = dz(1);
                if (id == i.f.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.ajN.yQ();
                } else if (id == i.f.btnCopy) {
                    if (this.ajH != null) {
                        this.ajH.onClick(this.ajD);
                    }
                    if (dz != null && dz.ajQ) {
                        q(8, dz.ajR);
                    }
                }
                if (i == i.e.icon_unite_share_weixin) {
                    c("share_to_weixin", new Object[0]);
                    dA(3);
                    f dz2 = dz(3);
                    if (dz2 != null) {
                        hVar.b(dz2);
                        if (dz2.ajQ) {
                            q(3, dz2.ajR);
                        }
                    }
                } else if (i == i.e.icon_unite_share_friend) {
                    c("share_to_pyq", new Object[0]);
                    dA(2);
                    f dz3 = dz(2);
                    if (dz3 != null) {
                        hVar.c(dz3);
                        if (dz3.ajQ) {
                            q(3, dz3.ajR);
                        }
                    }
                } else if (i == i.e.icon_unite_share_qqzon) {
                    c("share_to_qzone", new Object[0]);
                    dA(4);
                    f dz4 = dz(4);
                    if (dz4 != null) {
                        hVar.d(dz4);
                        if (dz4.ajQ) {
                            q(3, dz4.ajR);
                        }
                    }
                } else if (i == i.e.icon_unite_share_tencent) {
                    c("share_to_qweibo", new Object[0]);
                    dA(5);
                    f dz5 = dz(5);
                    if (dz5 != null) {
                        hVar.e(dz5);
                        if (dz5.ajQ) {
                            q(3, dz5.ajR);
                        }
                    }
                } else if (i == i.e.icon_unite_share_sina) {
                    c("share_to_sweibo", new Object[0]);
                    dA(6);
                    f dz6 = dz(6);
                    if (dz6 != null) {
                        hVar.f(dz6);
                        if (dz6.ajQ) {
                            q(3, dz6.ajR);
                        }
                    }
                } else if (i == i.e.icon_unite_share_renren) {
                    c("share_to_renren", new Object[0]);
                    dA(7);
                    f dz7 = dz(7);
                    if (dz7 != null) {
                        hVar.g(dz7);
                        if (dz7.ajQ) {
                            q(3, dz7.ajR);
                        }
                    }
                }
            }
        }
    }

    private f dz(int i) {
        f fVar = this.ajJ.get(i);
        if (fVar == null) {
            return this.ajJ.get(1);
        }
        return fVar;
    }

    private void dA(int i) {
        if (i <= 7 && i > 0) {
            this.ajK = true;
            if (this.ajM != null) {
                j jVar = this.ajM.get(i);
                if (!StringUtils.isNull(jVar.wF()) && jVar.wG() != null && jVar.wG().size() > 0) {
                    c(jVar.wF(), jVar.wG());
                    return;
                }
            }
            if (this.ajL != null) {
                String str = this.ajL.get(i);
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

    private void yV() {
        int size = this.ajG.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.ajG.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), i.c.cp_cont_f);
        }
        int paddingLeft = this.ajA.getPaddingLeft();
        al.h(this.ajB, i.e.bg_dailog);
        al.h((View) this.ajA, i.e.bg_unite_popup_share_up);
        al.b(this.ajA, i.c.share_to, 1);
        al.h((View) this.ajC, i.e.btn_w_square);
        al.b(this.ajC, i.c.share_to, 3);
        al.h((View) this.ajD, i.e.btn_blue_bg);
        al.b(this.ajD, i.c.cp_cont_g, 3);
        al.h(this.mLine, i.c.cp_bg_line_b);
        this.ajA.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = al.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        al.b(textView, i2, 1);
    }

    public void b(SparseArray<j> sparseArray) {
        this.ajM = sparseArray;
    }
}
