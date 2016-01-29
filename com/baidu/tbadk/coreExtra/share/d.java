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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String amA = "";
    private AlertDialog Yd;
    private TextView amp;
    private final LinearLayout amr;
    private final LinearLayout ams;
    private View.OnClickListener amu;
    private final LinearLayout amv;
    private SparseArray<String> amy;
    private SparseArray<l> amz;
    private final Context mContext;
    private final SparseArray<f> amw = new SparseArray<>(7);
    private boolean amx = false;
    private com.baidu.tbadk.coreExtra.share.a amB = new e(this);
    private final List<TextView> amt = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_dialog_content, (ViewGroup) null);
    private final TextView amm = (TextView) this.mRootView.findViewById(t.g.share_dialog_title);
    private final View amn = this.mRootView.findViewById(t.g.share_dialog_content);
    private final View amq = this.mRootView.findViewById(t.g.line);
    private final TextView amo = (TextView) this.mRootView.findViewById(t.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amo.setOnClickListener(this);
        B(t.j.share_weixin_timeline, t.f.icon_weixin_q);
        B(t.j.share_weixin, t.f.icon_weixin);
        B(t.j.share_qzone, t.f.icon_qq_zone);
        B(t.j.share_sina_weibo, t.f.icon_sina);
        B(t.j.share_qweibo, t.f.icon_qq_weibo);
        this.amp = B(t.j.share_copy, t.f.icon_copy_link);
        this.amv = (LinearLayout) this.mRootView.findViewById(t.g.customViewBox);
        this.amr = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_1);
        this.ams = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amr.setVisibility(8);
            this.ams.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.amo.setOnClickListener(onClickListener);
        }
    }

    private TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AF());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.amt.add(textView);
        return textView;
    }

    public TextView C(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AF());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams AF() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.amt.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.amt.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener amD;

        public a(View.OnClickListener onClickListener) {
            this.amD = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.amD != null) {
                this.amD.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.amp.setVisibility(0);
        } else {
            this.amp.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.amB = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.amy = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amw.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amw.put(i, fVar);
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
            this.amu = onClickListener;
        }
    }

    public void AG() {
        int size = this.amt.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView C = C(t.j.share_weixin_timeline, t.f.icon_weixin_q);
                C.setVisibility(4);
                this.amt.add(C);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.amr.addView(this.amt.get(i2));
            } else {
                this.ams.addView(this.amt.get(i2));
            }
        }
    }

    public void show() {
        if (!i.iZ()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.plugin_share_install_failure);
        } else {
            AG();
            this.Yd = new AlertDialog.Builder(this.mContext).create();
            this.Yd.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Yd, (Activity) this.mContext);
            }
            Window window = this.Yd.getWindow();
            window.setWindowAnimations(t.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.amB);
            window.setContentView(this.mRootView);
            AH();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Yd.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Yd != null) {
            this.amx = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Yd, (Activity) this.mContext);
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
        if (this.amw.size() != 0) {
            if (view.getId() == t.g.btnShareCancel || !this.amx) {
                this.amx = true;
                h hVar = new h(this.mContext, this.amB);
                f ee = ee(1);
                if (id == t.g.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    this.amB.AC();
                }
                if (i == t.f.icon_weixin) {
                    f("share_to_weixin", new Object[0]);
                    ef(3);
                    f ee2 = ee(3);
                    a(ee2, 4);
                    if (ee2 != null) {
                        if (ee2.imageUri != null) {
                            amA = ee2.imageUri.toString();
                        }
                        hVar.c(ee2);
                        if (ee2.amE) {
                            r(3, ee2.amI);
                        }
                    }
                } else if (i == t.f.icon_weixin_q) {
                    f("share_to_pyq", new Object[0]);
                    ef(2);
                    f ee3 = ee(2);
                    a(ee3, 3);
                    if (ee3 != null) {
                        if (ee3.amF) {
                            ee3.content = "【" + ee3.title + "】 " + ee3.content;
                        }
                        if (ee3.imageUri != null) {
                            amA = ee3.imageUri.toString();
                        }
                        hVar.d(ee3);
                        if (ee3.amE) {
                            r(3, ee3.amI);
                        }
                    }
                } else if (i == t.f.icon_qq_zone) {
                    if (ag.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        f("share_to_qzone", new Object[0]);
                        ef(4);
                        f ee4 = ee(4);
                        a(ee4, 5);
                        if (ee4 != null) {
                            hVar.e(ee4);
                            if (ee4.amE) {
                                r(3, ee4.amI);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(t.j.share_qq_not_install)).us();
                } else if (i == t.f.icon_qq_weibo) {
                    f("share_to_qweibo", new Object[0]);
                    ef(5);
                    f ee5 = ee(5);
                    a(ee5, 6);
                    if (ee5 != null) {
                        if (ee5.amE) {
                            r(3, ee5.amI);
                        } else {
                            ee5.content = b(ee5);
                        }
                        hVar.f(ee5);
                    }
                } else if (i == t.f.icon_sina) {
                    f("share_to_sweibo", new Object[0]);
                    ef(6);
                    f ee6 = ee(6);
                    a(ee6, 7);
                    if (ee6 != null) {
                        if (ee6.amE) {
                            r(3, ee6.amI);
                        } else {
                            ee6.content = b(ee6);
                        }
                        hVar.g(ee6);
                    }
                } else if (i == t.f.icon_renren) {
                    f("share_to_renren", new Object[0]);
                    ef(7);
                    f ee7 = ee(7);
                    a(ee7, 8);
                    if (ee7 != null) {
                        if (ee7.amE) {
                            r(3, ee7.amI);
                        } else {
                            ee7.content = b(ee7);
                        }
                        hVar.h(ee7);
                    }
                } else if (i == t.f.icon_copy_link) {
                    if (this.amu != null) {
                        this.amu.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aB(ee.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(t.j.copy_pb_url_success));
                    }
                    if (ee != null && ee.amE) {
                        r(8, ee.amI);
                    }
                }
            }
        }
    }

    private f ee(int i) {
        f fVar = this.amw.get(i);
        if (fVar == null) {
            return this.amw.get(1);
        }
        return fVar;
    }

    private void ef(int i) {
        if (i <= 7 && i > 0) {
            this.amx = true;
            if (this.amz != null) {
                l lVar = this.amz.get(i);
                if (!StringUtils.isNull(lVar.yi()) && lVar.yj() != null && lVar.yj().size() > 0) {
                    f(lVar.yi(), lVar.yj());
                    return;
                }
            }
            if (this.amy != null) {
                String str = this.amy.get(i);
                if (!aw.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void r(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.amF) {
                TiebaStatic.log(new au("c10125").aa(ImageViewerConfig.FORUM_ID, fVar.extData).r("obj_type", i));
            } else if (fVar.amG) {
                TiebaStatic.log(new au("c10125").aa("tid", fVar.extData).r("obj_type", i));
            } else if (fVar.amH) {
                TiebaStatic.log(new au("c10427").aa("tid", fVar.extData).r("obj_type", i));
            }
        }
    }

    private void AH() {
        int size = this.amt.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.amt.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.d.cp_cont_f);
        }
        int paddingLeft = this.amm.getPaddingLeft();
        ar.k(this.amn, t.d.share_dialog_bg);
        ar.k(this.amm, t.f.bg_unite_popup_share_up);
        ar.b(this.amm, t.d.share_to, 1);
        ar.b(this.amo, t.d.cp_link_tip_a, 1);
        ar.k(this.amq, t.d.cp_bg_line_a);
        this.amm.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ar.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ar.b(textView, i2, 1);
    }

    public void b(SparseArray<l> sparseArray) {
        this.amz = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
