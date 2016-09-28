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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String amM = "";
    private AlertDialog VI;
    private TextView amB;
    private final LinearLayout amD;
    private final LinearLayout amE;
    private View.OnClickListener amG;
    private final LinearLayout amH;
    private SparseArray<String> amK;
    private SparseArray<p> amL;
    private final Context mContext;
    private final SparseArray<f> amI = new SparseArray<>(7);
    private boolean amJ = false;
    private com.baidu.tbadk.coreExtra.share.a amN = new e(this);
    private final List<TextView> amF = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_dialog_content, (ViewGroup) null);
    private final TextView amy = (TextView) this.mRootView.findViewById(r.g.share_dialog_title);
    private final View amz = this.mRootView.findViewById(r.g.share_dialog_content);
    private final View amC = this.mRootView.findViewById(r.g.line);
    private final TextView amA = (TextView) this.mRootView.findViewById(r.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amA.setOnClickListener(this);
        A(r.j.share_weixin_timeline, r.f.icon_weixin_q);
        A(r.j.share_weixin, r.f.icon_weixin);
        A(r.j.share_qzone, r.f.icon_qq_zone);
        A(r.j.share_sina_weibo, r.f.icon_sina);
        this.amB = A(r.j.share_copy, r.f.icon_copy_link);
        this.amH = (LinearLayout) this.mRootView.findViewById(r.g.customViewBox);
        this.amD = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_1);
        this.amE = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amD.setVisibility(8);
            this.amE.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.amA.setOnClickListener(onClickListener);
        }
    }

    private TextView A(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Az());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.amF.add(textView);
        return textView;
    }

    public TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Az());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Az() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.amF.add(0, textView);
    }

    public int AA() {
        if (this.amF == null) {
            return 0;
        }
        return this.amF.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.amF.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.amF.size() && i >= 0) {
            this.amF.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener amP;

        public a(View.OnClickListener onClickListener) {
            this.amP = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.amP != null) {
                this.amP.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.amB.setVisibility(0);
        } else {
            this.amB.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.amN = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.amK = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amI.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amI.put(i, fVar);
    }

    private Location getLocation() {
        if (ag.Z(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(ThActivityDetailActivityConfig.LOCATION);
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
        return null;
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.amG = onClickListener;
        }
    }

    public void AB() {
        int size = this.amF.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView B = B(r.j.share_weixin_timeline, r.f.icon_weixin_q);
                B.setVisibility(4);
                this.amF.add(B);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.amD.addView(this.amF.get(i2));
            } else {
                this.amE.addView(this.amF.get(i2));
            }
        }
    }

    public void show() {
        if (!i.gm()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.plugin_share_install_failure);
        } else {
            AB();
            this.VI = new AlertDialog.Builder(this.mContext).create();
            this.VI.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.VI, (Activity) this.mContext);
            }
            Window window = this.VI.getWindow();
            window.setWindowAnimations(r.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.amN);
            window.setContentView(this.mRootView);
            AC();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.VI.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.VI != null) {
            this.amJ = false;
            if (this.mContext instanceof Activity) {
                j.b(this.VI, (Activity) this.mContext);
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
        if (this.amI.size() != 0) {
            if (view.getId() == r.g.btnShareCancel || !this.amJ) {
                this.amJ = true;
                h hVar = new h(this.mContext, this.amN);
                f ec = ec(1);
                if (id == r.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    this.amN.Aw();
                }
                if (i == r.f.icon_weixin) {
                    k("share_to_weixin", new Object[0]);
                    ed(3);
                    f ec2 = ec(3);
                    a(ec2, 4);
                    if (ec2 != null) {
                        if (ec2.imageUri != null) {
                            amM = ec2.imageUri.toString();
                        }
                        hVar.c(ec2);
                    }
                } else if (i == r.f.icon_weixin_q) {
                    k("share_to_pyq", new Object[0]);
                    ed(2);
                    f ec3 = ec(2);
                    a(ec3, 3);
                    if (ec3 != null) {
                        if (ec3.amR) {
                            ec3.content = "【" + ec3.title + "】 " + ec3.content;
                        }
                        if (ec3.amU) {
                            ec3.content = "【" + ec3.title + "】 " + ec3.content;
                        }
                        if (ec3.imageUri != null) {
                            amM = ec3.imageUri.toString();
                        }
                        hVar.d(ec3);
                    }
                } else if (i == r.f.icon_qq_zone) {
                    if (ak.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qzone", new Object[0]);
                        ed(4);
                        f ec4 = ec(4);
                        a(ec4, 5);
                        if (ec4 != null) {
                            hVar.e(ec4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.j.share_qq_not_install)).tu();
                } else if (i == r.f.icon_qq_weibo) {
                    k("share_to_qweibo", new Object[0]);
                    ed(5);
                    f ec5 = ec(5);
                    a(ec5, 6);
                    if (ec5 != null) {
                        if (!ec5.amQ) {
                            ec5.content = b(ec5);
                        }
                        hVar.f(ec5);
                    }
                } else if (i == r.f.icon_sina) {
                    k("share_to_sweibo", new Object[0]);
                    ed(6);
                    f ec6 = ec(6);
                    a(ec6, 7);
                    if (ec6 != null) {
                        if (!ec6.amQ) {
                            ec6.content = b(ec6);
                        }
                        hVar.g(ec6);
                    }
                } else if (i == r.f.icon_renren) {
                    k("share_to_renren", new Object[0]);
                    ed(7);
                    f ec7 = ec(7);
                    a(ec7, 8);
                    if (ec7 != null) {
                        if (!ec7.amQ) {
                            ec7.content = b(ec7);
                        }
                        hVar.h(ec7);
                    }
                } else if (i == r.f.icon_copy_link) {
                    a(ec, 10);
                    if (this.amG != null) {
                        this.amG.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.az(ec.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(r.j.copy_pb_url_success));
                    }
                    if (ec != null && ec.amQ) {
                        j(8, ec.amV);
                    }
                }
            }
        }
    }

    private f ec(int i) {
        f fVar = this.amI.get(i);
        if (fVar == null) {
            return this.amI.get(1);
        }
        return fVar;
    }

    private void ed(int i) {
        if (i <= 7 && i > 0) {
            this.amJ = true;
            if (this.amL != null) {
                p pVar = this.amL.get(i);
                if (!StringUtils.isNull(pVar.xT()) && pVar.xU() != null && pVar.xU().size() > 0) {
                    k(pVar.xT(), pVar.xU());
                    return;
                }
            }
            if (this.amK != null) {
                String str = this.amK.get(i);
                if (!az.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void j(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.amR) {
                TiebaStatic.log(new ax("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.amS) {
                TiebaStatic.log(new ax("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.amT) {
                TiebaStatic.log(new ax("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.amQ) {
                j(i, fVar.amV);
            }
        }
    }

    private void AC() {
        int size = this.amF.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.amF.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), r.d.cp_cont_f);
        }
        int paddingLeft = this.amy.getPaddingLeft();
        av.k(this.amz, r.d.common_color_10010);
        av.k(this.amy, r.f.bg_unite_popup_share_up);
        av.c(this.amy, r.d.common_color_10039, 1);
        av.c(this.amA, r.d.cp_link_tip_a, 1);
        av.k(this.amA, r.f.dialog_single_button_bg_selector);
        av.k(this.amC, r.d.cp_bg_line_a);
        this.amy.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = av.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        av.c(textView, i2, 1);
    }

    public void b(SparseArray<p> sparseArray) {
        this.amL = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
