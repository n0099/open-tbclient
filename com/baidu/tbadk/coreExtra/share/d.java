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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String ajk = "";
    private AlertDialog Sa;
    private TextView aiZ;
    private final LinearLayout ajb;
    private final LinearLayout ajc;
    private View.OnClickListener aje;
    private final LinearLayout ajf;
    private SparseArray<String> aji;
    private SparseArray<m> ajj;
    private final Context mContext;
    private final SparseArray<f> ajg = new SparseArray<>(7);
    private boolean ajh = false;
    private com.baidu.tbadk.coreExtra.share.a ajl = new e(this);
    private final List<TextView> ajd = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(u.h.share_dialog_content, (ViewGroup) null);
    private final TextView aiW = (TextView) this.mRootView.findViewById(u.g.share_dialog_title);
    private final View aiX = this.mRootView.findViewById(u.g.share_dialog_content);
    private final View aja = this.mRootView.findViewById(u.g.line);
    private final TextView aiY = (TextView) this.mRootView.findViewById(u.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.aiY.setOnClickListener(this);
        y(u.j.share_weixin_timeline, u.f.icon_weixin_q);
        y(u.j.share_weixin, u.f.icon_weixin);
        y(u.j.share_qzone, u.f.icon_qq_zone);
        y(u.j.share_sina_weibo, u.f.icon_sina);
        this.aiZ = y(u.j.share_copy, u.f.icon_copy_link);
        this.ajf = (LinearLayout) this.mRootView.findViewById(u.g.customViewBox);
        this.ajb = (LinearLayout) this.mRootView.findViewById(u.g.share_dialog_line_1);
        this.ajc = (LinearLayout) this.mRootView.findViewById(u.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.ajb.setVisibility(8);
            this.ajc.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.aiY.setOnClickListener(onClickListener);
        }
    }

    private TextView y(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(u.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zh());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.ajd.add(textView);
        return textView;
    }

    public TextView z(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(u.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zh());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams zh() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.ajd.add(0, textView);
    }

    public int zi() {
        if (this.ajd == null) {
            return 0;
        }
        return this.ajd.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.ajd.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.ajd.size() && i >= 0) {
            this.ajd.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener ajn;

        public a(View.OnClickListener onClickListener) {
            this.ajn = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.ajn != null) {
                this.ajn.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.aiZ.setVisibility(0);
        } else {
            this.aiZ.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.ajl = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.aji = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajg.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ajg.put(i, fVar);
    }

    private Location getLocation() {
        if (ag.P(this.mContext)) {
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
            this.aje = onClickListener;
        }
    }

    public void zj() {
        int size = this.ajd.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView z = z(u.j.share_weixin_timeline, u.f.icon_weixin_q);
                z.setVisibility(4);
                this.ajd.add(z);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.ajb.addView(this.ajd.get(i2));
            } else {
                this.ajc.addView(this.ajd.get(i2));
            }
        }
    }

    public void show() {
        if (!i.fr()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), u.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), u.j.plugin_share_install_failure);
        } else {
            zj();
            this.Sa = new AlertDialog.Builder(this.mContext).create();
            this.Sa.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Sa, (Activity) this.mContext);
            }
            Window window = this.Sa.getWindow();
            window.setWindowAnimations(u.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.ajl);
            window.setContentView(this.mRootView);
            zk();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Sa.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Sa != null) {
            this.ajh = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Sa, (Activity) this.mContext);
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
        if (this.ajg.size() != 0) {
            if (view.getId() == u.g.btnShareCancel || !this.ajh) {
                this.ajh = true;
                h hVar = new h(this.mContext, this.ajl);
                f dO = dO(1);
                if (id == u.g.btnShareCancel) {
                    g("share_cancel", new Object[0]);
                    this.ajl.ze();
                }
                if (i == u.f.icon_weixin) {
                    g("share_to_weixin", new Object[0]);
                    dP(3);
                    f dO2 = dO(3);
                    a(dO2, 4);
                    if (dO2 != null) {
                        if (dO2.imageUri != null) {
                            ajk = dO2.imageUri.toString();
                        }
                        hVar.c(dO2);
                    }
                } else if (i == u.f.icon_weixin_q) {
                    g("share_to_pyq", new Object[0]);
                    dP(2);
                    f dO3 = dO(2);
                    a(dO3, 3);
                    if (dO3 != null) {
                        if (dO3.ajp) {
                            dO3.content = "【" + dO3.title + "】 " + dO3.content;
                        }
                        if (dO3.ajs) {
                            dO3.content = "【" + dO3.title + "】 " + dO3.content;
                        }
                        if (dO3.imageUri != null) {
                            ajk = dO3.imageUri.toString();
                        }
                        hVar.d(dO3);
                    }
                } else if (i == u.f.icon_qq_zone) {
                    if (al.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        g("share_to_qzone", new Object[0]);
                        dP(4);
                        f dO4 = dO(4);
                        a(dO4, 5);
                        if (dO4 != null) {
                            hVar.e(dO4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(u.j.share_qq_not_install)).sb();
                } else if (i == u.f.icon_qq_weibo) {
                    g("share_to_qweibo", new Object[0]);
                    dP(5);
                    f dO5 = dO(5);
                    a(dO5, 6);
                    if (dO5 != null) {
                        if (!dO5.ajo) {
                            dO5.content = b(dO5);
                        }
                        hVar.f(dO5);
                    }
                } else if (i == u.f.icon_sina) {
                    g("share_to_sweibo", new Object[0]);
                    dP(6);
                    f dO6 = dO(6);
                    a(dO6, 7);
                    if (dO6 != null) {
                        if (!dO6.ajo) {
                            dO6.content = b(dO6);
                        }
                        hVar.g(dO6);
                    }
                } else if (i == u.f.icon_renren) {
                    g("share_to_renren", new Object[0]);
                    dP(7);
                    f dO7 = dO(7);
                    a(dO7, 8);
                    if (dO7 != null) {
                        if (!dO7.ajo) {
                            dO7.content = b(dO7);
                        }
                        hVar.h(dO7);
                    }
                } else if (i == u.f.icon_copy_link) {
                    a(dO, 10);
                    if (this.aje != null) {
                        this.aje.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aw(dO.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(u.j.copy_pb_url_success));
                    }
                    if (dO != null && dO.ajo) {
                        j(8, dO.ajt);
                    }
                }
            }
        }
    }

    private f dO(int i) {
        f fVar = this.ajg.get(i);
        if (fVar == null) {
            return this.ajg.get(1);
        }
        return fVar;
    }

    private void dP(int i) {
        if (i <= 7 && i > 0) {
            this.ajh = true;
            if (this.ajj != null) {
                m mVar = this.ajj.get(i);
                if (!StringUtils.isNull(mVar.wG()) && mVar.wH() != null && mVar.wH().size() > 0) {
                    g(mVar.wG(), mVar.wH());
                    return;
                }
            }
            if (this.aji != null) {
                String str = this.aji.get(i);
                if (!ba.isEmpty(str)) {
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
            if (fVar.ajp) {
                TiebaStatic.log(new ay("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.ajq) {
                TiebaStatic.log(new ay("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.ajr) {
                TiebaStatic.log(new ay("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.ajo) {
                j(i, fVar.ajt);
            }
        }
    }

    private void zk() {
        int size = this.ajd.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.ajd.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), u.d.cp_cont_f);
        }
        int paddingLeft = this.aiW.getPaddingLeft();
        av.k(this.aiX, u.d.common_color_10010);
        av.k(this.aiW, u.f.bg_unite_popup_share_up);
        av.c(this.aiW, u.d.common_color_10039, 1);
        av.c(this.aiY, u.d.cp_link_tip_a, 1);
        av.k(this.aja, u.d.cp_bg_line_a);
        this.aiW.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = av.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        av.c(textView, i2, 1);
    }

    public void b(SparseArray<m> sparseArray) {
        this.ajj = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
