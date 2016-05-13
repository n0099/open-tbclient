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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ah;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String aiE = "";
    private AlertDialog RH;
    private SparseArray<String> aiC;
    private SparseArray<l> aiD;
    private TextView ait;
    private final LinearLayout aiv;
    private final LinearLayout aiw;
    private View.OnClickListener aiy;
    private final LinearLayout aiz;
    private final Context mContext;
    private final SparseArray<f> aiA = new SparseArray<>(7);
    private boolean aiB = false;
    private com.baidu.tbadk.coreExtra.share.a aiF = new e(this);
    private final List<TextView> aix = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m11getInst().getContext()).inflate(t.h.share_dialog_content, (ViewGroup) null);
    private final TextView aiq = (TextView) this.mRootView.findViewById(t.g.share_dialog_title);
    private final View air = this.mRootView.findViewById(t.g.share_dialog_content);
    private final View aiu = this.mRootView.findViewById(t.g.line);
    private final TextView ais = (TextView) this.mRootView.findViewById(t.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ais.setOnClickListener(this);
        y(t.j.share_weixin_timeline, t.f.icon_weixin_q);
        y(t.j.share_weixin, t.f.icon_weixin);
        y(t.j.share_qzone, t.f.icon_qq_zone);
        y(t.j.share_sina_weibo, t.f.icon_sina);
        y(t.j.share_qweibo, t.f.icon_qq_weibo);
        this.ait = y(t.j.share_copy, t.f.icon_copy_link);
        this.aiz = (LinearLayout) this.mRootView.findViewById(t.g.customViewBox);
        this.aiv = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_1);
        this.aiw = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.aiv.setVisibility(8);
            this.aiw.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ais.setOnClickListener(onClickListener);
        }
    }

    private TextView y(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m11getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m11getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zc());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.aix.add(textView);
        return textView;
    }

    public TextView z(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m11getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m11getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zc());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams zc() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.aix.add(0, textView);
    }

    public int zd() {
        if (this.aix == null) {
            return 0;
        }
        return this.aix.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.aix.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.aix.size() && i >= 0) {
            this.aix.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener aiH;

        public a(View.OnClickListener onClickListener) {
            this.aiH = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.aiH != null) {
                this.aiH.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.ait.setVisibility(0);
        } else {
            this.ait.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.aiF = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.aiC = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aiA.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aiA.put(i, fVar);
    }

    private Location getLocation() {
        if (ag.Q(this.mContext)) {
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
            this.aiy = onClickListener;
        }
    }

    public void ze() {
        int size = this.aix.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView z = z(t.j.share_weixin_timeline, t.f.icon_weixin_q);
                z.setVisibility(4);
                this.aix.add(z);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.aiv.addView(this.aix.get(i2));
            } else {
                this.aiw.addView(this.aix.get(i2));
            }
        }
    }

    public void show() {
        if (!i.fq()) {
            k.showToast(TbadkCoreApplication.m11getInst().getContext(), t.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m11getInst().getContext(), t.j.plugin_share_install_failure);
        } else {
            ze();
            this.RH = new AlertDialog.Builder(this.mContext).create();
            this.RH.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.RH, (Activity) this.mContext);
            }
            Window window = this.RH.getWindow();
            window.setWindowAnimations(t.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.aiF);
            window.setContentView(this.mRootView);
            zf();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.RH.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.RH != null) {
            this.aiB = false;
            if (this.mContext instanceof Activity) {
                j.b(this.RH, (Activity) this.mContext);
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
        if (this.aiA.size() != 0) {
            if (view.getId() == t.g.btnShareCancel || !this.aiB) {
                this.aiB = true;
                h hVar = new h(this.mContext, this.aiF);
                f dM = dM(1);
                if (id == t.g.btnShareCancel) {
                    g("share_cancel", new Object[0]);
                    this.aiF.yZ();
                }
                if (i == t.f.icon_weixin) {
                    g("share_to_weixin", new Object[0]);
                    dN(3);
                    f dM2 = dM(3);
                    a(dM2, 4);
                    if (dM2 != null) {
                        if (dM2.imageUri != null) {
                            aiE = dM2.imageUri.toString();
                        }
                        hVar.c(dM2);
                    }
                } else if (i == t.f.icon_weixin_q) {
                    g("share_to_pyq", new Object[0]);
                    dN(2);
                    f dM3 = dM(2);
                    a(dM3, 3);
                    if (dM3 != null) {
                        if (dM3.aiJ) {
                            dM3.content = "【" + dM3.title + "】 " + dM3.content;
                        }
                        if (dM3.aiM) {
                            dM3.content = "【" + dM3.title + "】 " + dM3.content;
                        }
                        if (dM3.imageUri != null) {
                            aiE = dM3.imageUri.toString();
                        }
                        hVar.d(dM3);
                    }
                } else if (i == t.f.icon_qq_zone) {
                    if (ah.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        g("share_to_qzone", new Object[0]);
                        dN(4);
                        f dM4 = dM(4);
                        a(dM4, 5);
                        if (dM4 != null) {
                            hVar.e(dM4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(t.j.share_qq_not_install)).sd();
                } else if (i == t.f.icon_qq_weibo) {
                    g("share_to_qweibo", new Object[0]);
                    dN(5);
                    f dM5 = dM(5);
                    a(dM5, 6);
                    if (dM5 != null) {
                        if (!dM5.aiI) {
                            dM5.content = b(dM5);
                        }
                        hVar.f(dM5);
                    }
                } else if (i == t.f.icon_sina) {
                    g("share_to_sweibo", new Object[0]);
                    dN(6);
                    f dM6 = dM(6);
                    a(dM6, 7);
                    if (dM6 != null) {
                        if (!dM6.aiI) {
                            dM6.content = b(dM6);
                        }
                        hVar.g(dM6);
                    }
                } else if (i == t.f.icon_renren) {
                    g("share_to_renren", new Object[0]);
                    dN(7);
                    f dM7 = dM(7);
                    a(dM7, 8);
                    if (dM7 != null) {
                        if (!dM7.aiI) {
                            dM7.content = b(dM7);
                        }
                        hVar.h(dM7);
                    }
                } else if (i == t.f.icon_copy_link) {
                    a(dM, 10);
                    if (this.aiy != null) {
                        this.aiy.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aw(dM.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(t.j.copy_pb_url_success));
                    }
                    if (dM != null && dM.aiI) {
                        j(8, dM.aiN);
                    }
                }
            }
        }
    }

    private f dM(int i) {
        f fVar = this.aiA.get(i);
        if (fVar == null) {
            return this.aiA.get(1);
        }
        return fVar;
    }

    private void dN(int i) {
        if (i <= 7 && i > 0) {
            this.aiB = true;
            if (this.aiD != null) {
                l lVar = this.aiD.get(i);
                if (!StringUtils.isNull(lVar.wD()) && lVar.wE() != null && lVar.wE().size() > 0) {
                    g(lVar.wD(), lVar.wE());
                    return;
                }
            }
            if (this.aiC != null) {
                String str = this.aiC.get(i);
                if (!ay.isEmpty(str)) {
                    g(str, new Object[0]);
                }
            }
        }
    }

    private void g(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void j(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.aiJ) {
                TiebaStatic.log(new aw("c10125").ac("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.aiK) {
                TiebaStatic.log(new aw("c10125").ac("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.aiL) {
                TiebaStatic.log(new aw("c10427").ac("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.aiI) {
                j(i, fVar.aiN);
            }
        }
    }

    private void zf() {
        int size = this.aix.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.aix.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.d.cp_cont_f);
        }
        int paddingLeft = this.aiq.getPaddingLeft();
        at.k(this.air, t.d.share_dialog_bg);
        at.k(this.aiq, t.f.bg_unite_popup_share_up);
        at.c(this.aiq, t.d.share_to, 1);
        at.c(this.ais, t.d.cp_link_tip_a, 1);
        at.k(this.aiu, t.d.cp_bg_line_a);
        this.aiq.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = at.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        at.c(textView, i2, 1);
    }

    public void b(SparseArray<l> sparseArray) {
        this.aiD = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
