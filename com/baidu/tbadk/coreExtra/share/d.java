package com.baidu.tbadk.coreExtra.share;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.af;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String amn = "";
    private AlertDialog UQ;
    private TextView amd;
    private final LinearLayout amf;
    private final LinearLayout amg;
    private View.OnClickListener ami;
    private SparseArray<String> aml;
    private SparseArray<o> amm;
    private final Context mContext;
    private final SparseArray<f> amj = new SparseArray<>(8);
    private boolean amk = false;
    private boolean amo = true;
    private com.baidu.tbadk.coreExtra.share.a amp = new e(this);
    private final List<TextView> amh = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.j.share_dialog_content, (ViewGroup) null);
    private final TextView ama = (TextView) this.mRootView.findViewById(r.h.share_dialog_title);
    private final View amb = this.mRootView.findViewById(r.h.share_dialog_content);
    private final View ame = this.mRootView.findViewById(r.h.line);
    private final TextView amc = (TextView) this.mRootView.findViewById(r.h.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amc.setOnClickListener(this);
        B(r.l.share_weixin, r.g.icon_weixin);
        B(r.l.share_weixin_timeline, r.g.icon_weixin_q);
        B(r.l.share_qzone, r.g.icon_qq_zone);
        B(r.l.share_qq_friends, r.g.icon_qq_share);
        B(r.l.share_sina_weibo, r.g.icon_sina);
        this.amf = (LinearLayout) this.mRootView.findViewById(r.h.share_dialog_line_1);
        this.amg = (LinearLayout) this.mRootView.findViewById(r.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amf.setVisibility(8);
            this.amg.setVisibility(8);
        }
    }

    private TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Ao());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.amh.add(textView);
        return textView;
    }

    public TextView C(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Ao());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Ao() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public int Ap() {
        if (this.amh == null) {
            return 0;
        }
        return this.amh.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.amh.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.amh.size() && i >= 0) {
            this.amh.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener amr;

        public a(View.OnClickListener onClickListener) {
            this.amr = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.amr != null) {
                this.amr.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.amo = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.amp = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.aml = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amj.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amj.put(i, fVar);
    }

    private Location getLocation() {
        if (ad.Z(this.mContext)) {
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
        return null;
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ami = onClickListener;
        }
    }

    public void Aq() {
        if (this.amo) {
            this.amd = B(r.l.share_copy, r.g.icon_copy_link);
        }
        int size = this.amh.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView C = C(r.l.share_weixin_timeline, r.g.icon_weixin_q);
                C.setVisibility(4);
                this.amh.add(C);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.amf.addView(this.amh.get(i2));
            } else {
                this.amg.addView(this.amh.get(i2));
            }
        }
    }

    public void show() {
        if (!i.gk()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.l.plugin_share_install_failure);
        } else {
            Aq();
            this.UQ = new AlertDialog.Builder(this.mContext).create();
            this.UQ.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.UQ, (Activity) this.mContext);
            }
            Window window = this.UQ.getWindow();
            window.setWindowAnimations(r.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.amp);
            window.setContentView(this.mRootView);
            Ar();
        }
    }

    public void dismiss() {
        if (this.UQ != null) {
            this.amk = false;
            if (this.mContext instanceof Activity) {
                j.b(this.UQ, (Activity) this.mContext);
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
        if (this.amj.size() != 0) {
            if (view.getId() == r.h.btnShareCancel || !this.amk) {
                this.amk = true;
                h hVar = new h(this.mContext, this.amp);
                f eg = eg(1);
                if (id == r.h.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    this.amp.Al();
                }
                if (i == r.g.icon_weixin) {
                    k("share_to_weixin", new Object[0]);
                    eh(3);
                    f eg2 = eg(3);
                    a(eg2, 4);
                    if (eg2 != null) {
                        if (eg2.imageUri != null) {
                            amn = eg2.imageUri.toString();
                        }
                        hVar.c(eg2);
                    }
                } else if (i == r.g.icon_weixin_q) {
                    k("share_to_pyq", new Object[0]);
                    eh(2);
                    f eg3 = eg(2);
                    a(eg3, 3);
                    if (eg3 != null) {
                        if (eg3.amt) {
                            eg3.content = "【" + eg3.title + "】 " + eg3.content;
                        }
                        if (eg3.imageUri != null) {
                            amn = eg3.imageUri.toString();
                        }
                        hVar.d(eg3);
                    }
                } else if (i == r.g.icon_qq_zone) {
                    if (af.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qzone", new Object[0]);
                        eh(4);
                        f eg4 = eg(4);
                        a(eg4, 5);
                        if (eg4 != null) {
                            hVar.f(eg4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.l.share_qq_not_install)).td();
                } else if (i == r.g.icon_qq_weibo) {
                    k("share_to_qweibo", new Object[0]);
                    eh(5);
                    f eg5 = eg(5);
                    a(eg5, 6);
                    if (eg5 != null) {
                        if (!eg5.ams) {
                            eg5.content = b(eg5);
                        }
                        hVar.g(eg5);
                    }
                } else if (i == r.g.icon_sina) {
                    k("share_to_sweibo", new Object[0]);
                    eh(6);
                    f eg6 = eg(6);
                    a(eg6, 7);
                    if (eg6 != null) {
                        if (!eg6.ams) {
                            eg6.content = b(eg6);
                        }
                        hVar.h(eg6);
                    }
                } else if (i == r.g.icon_renren) {
                    k("share_to_renren", new Object[0]);
                    eh(7);
                    f eg7 = eg(7);
                    a(eg7, 8);
                    if (eg7 != null) {
                        if (!eg7.ams) {
                            eg7.content = b(eg7);
                        }
                        hVar.i(eg7);
                    }
                } else if (i == r.g.icon_qq_share) {
                    if (af.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qq_friend", new Object[0]);
                        eh(8);
                        f eg8 = eg(8);
                        a(eg8, 9);
                        if (eg8 != null) {
                            hVar.e(eg8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.l.share_qq_not_install)).td();
                } else if (i == r.g.icon_copy_link) {
                    a(eg, 10);
                    if (this.ami != null) {
                        this.ami.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.ay(eg.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(r.l.copy_pb_url_success));
                    }
                    if (eg != null && eg.ams) {
                        i(8, eg.amx);
                    }
                }
            }
        }
    }

    private f eg(int i) {
        f fVar = this.amj.get(i);
        if (fVar == null) {
            return this.amj.get(1);
        }
        return fVar;
    }

    private void eh(int i) {
        if (i <= 8 && i > 0) {
            this.amk = true;
            if (this.amm != null) {
                o oVar = this.amm.get(i);
                if (!StringUtils.isNull(oVar.xJ()) && oVar.xK() != null && oVar.xK().size() > 0) {
                    k(oVar.xJ(), oVar.xK());
                    return;
                }
            }
            if (this.aml != null) {
                String str = this.aml.get(i);
                if (!at.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void i(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.amt) {
                TiebaStatic.log(new ar("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.amu) {
                TiebaStatic.log(new ar("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.amv) {
                TiebaStatic.log(new ar("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.ams) {
                i(i, fVar.amx);
            } else if (fVar.amw) {
                TiebaStatic.log(new ar("c10125").s("obj_param1", 7).s("obj_type", i).ab("fid", fVar.extData));
            }
        }
    }

    private void Ar() {
        int size = this.amh.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.amh.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), r.e.cp_cont_j);
        }
        int paddingLeft = this.ama.getPaddingLeft();
        ap.j(this.amb, r.e.common_color_10010);
        ap.j((View) this.ama, r.g.bg_unite_popup_share_up);
        ap.c(this.ama, r.e.common_color_10039, 1);
        ap.c(this.amc, r.e.cp_cont_f, 1);
        ap.j((View) this.amc, r.g.dialog_single_button_bg_selector);
        ap.j(this.ame, r.e.cp_bg_line_a);
        this.ama.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ap.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ap.c(textView, i2, 1);
    }

    public void b(SparseArray<o> sparseArray) {
        this.amm = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
