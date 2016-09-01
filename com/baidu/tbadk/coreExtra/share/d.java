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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String ane = "";
    private AlertDialog Vy;
    private TextView amT;
    private final LinearLayout amV;
    private final LinearLayout amW;
    private View.OnClickListener amY;
    private final LinearLayout amZ;
    private SparseArray<String> anc;
    private SparseArray<p> and;
    private final Context mContext;
    private final SparseArray<f> ana = new SparseArray<>(7);
    private boolean anb = false;
    private com.baidu.tbadk.coreExtra.share.a anf = new e(this);
    private final List<TextView> amX = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(t.h.share_dialog_content, (ViewGroup) null);
    private final TextView amQ = (TextView) this.mRootView.findViewById(t.g.share_dialog_title);
    private final View amR = this.mRootView.findViewById(t.g.share_dialog_content);
    private final View amU = this.mRootView.findViewById(t.g.line);
    private final TextView amS = (TextView) this.mRootView.findViewById(t.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amS.setOnClickListener(this);
        A(t.j.share_weixin_timeline, t.f.icon_weixin_q);
        A(t.j.share_weixin, t.f.icon_weixin);
        A(t.j.share_qzone, t.f.icon_qq_zone);
        A(t.j.share_sina_weibo, t.f.icon_sina);
        this.amT = A(t.j.share_copy, t.f.icon_copy_link);
        this.amZ = (LinearLayout) this.mRootView.findViewById(t.g.customViewBox);
        this.amV = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_1);
        this.amW = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amV.setVisibility(8);
            this.amW.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.amS.setOnClickListener(onClickListener);
        }
    }

    private TextView A(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aw());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.amX.add(textView);
        return textView;
    }

    public TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aw());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Aw() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.amX.add(0, textView);
    }

    public int Ax() {
        if (this.amX == null) {
            return 0;
        }
        return this.amX.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.amX.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.amX.size() && i >= 0) {
            this.amX.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener anh;

        public a(View.OnClickListener onClickListener) {
            this.anh = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.anh != null) {
                this.anh.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.amT.setVisibility(0);
        } else {
            this.amT.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.anf = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.anc = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ana.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.ana.put(i, fVar);
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
            this.amY = onClickListener;
        }
    }

    public void Ay() {
        int size = this.amX.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView B = B(t.j.share_weixin_timeline, t.f.icon_weixin_q);
                B.setVisibility(4);
                this.amX.add(B);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.amV.addView(this.amX.get(i2));
            } else {
                this.amW.addView(this.amX.get(i2));
            }
        }
    }

    public void show() {
        if (!i.gm()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), t.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), t.j.plugin_share_install_failure);
        } else {
            Ay();
            this.Vy = new AlertDialog.Builder(this.mContext).create();
            this.Vy.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Vy, (Activity) this.mContext);
            }
            Window window = this.Vy.getWindow();
            window.setWindowAnimations(t.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.anf);
            window.setContentView(this.mRootView);
            Az();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Vy.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Vy != null) {
            this.anb = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Vy, (Activity) this.mContext);
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
        if (this.ana.size() != 0) {
            if (view.getId() == t.g.btnShareCancel || !this.anb) {
                this.anb = true;
                h hVar = new h(this.mContext, this.anf);
                f ec = ec(1);
                if (id == t.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    this.anf.At();
                }
                if (i == t.f.icon_weixin) {
                    k("share_to_weixin", new Object[0]);
                    ed(3);
                    f ec2 = ec(3);
                    a(ec2, 4);
                    if (ec2 != null) {
                        if (ec2.imageUri != null) {
                            ane = ec2.imageUri.toString();
                        }
                        hVar.c(ec2);
                    }
                } else if (i == t.f.icon_weixin_q) {
                    k("share_to_pyq", new Object[0]);
                    ed(2);
                    f ec3 = ec(2);
                    a(ec3, 3);
                    if (ec3 != null) {
                        if (ec3.anj) {
                            ec3.content = "【" + ec3.title + "】 " + ec3.content;
                        }
                        if (ec3.anm) {
                            ec3.content = "【" + ec3.title + "】 " + ec3.content;
                        }
                        if (ec3.imageUri != null) {
                            ane = ec3.imageUri.toString();
                        }
                        hVar.d(ec3);
                    }
                } else if (i == t.f.icon_qq_zone) {
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
                    BdToast.a(this.mContext, this.mContext.getText(t.j.share_qq_not_install)).tf();
                } else if (i == t.f.icon_qq_weibo) {
                    k("share_to_qweibo", new Object[0]);
                    ed(5);
                    f ec5 = ec(5);
                    a(ec5, 6);
                    if (ec5 != null) {
                        if (!ec5.ani) {
                            ec5.content = b(ec5);
                        }
                        hVar.f(ec5);
                    }
                } else if (i == t.f.icon_sina) {
                    k("share_to_sweibo", new Object[0]);
                    ed(6);
                    f ec6 = ec(6);
                    a(ec6, 7);
                    if (ec6 != null) {
                        if (!ec6.ani) {
                            ec6.content = b(ec6);
                        }
                        hVar.g(ec6);
                    }
                } else if (i == t.f.icon_renren) {
                    k("share_to_renren", new Object[0]);
                    ed(7);
                    f ec7 = ec(7);
                    a(ec7, 8);
                    if (ec7 != null) {
                        if (!ec7.ani) {
                            ec7.content = b(ec7);
                        }
                        hVar.h(ec7);
                    }
                } else if (i == t.f.icon_copy_link) {
                    a(ec, 10);
                    if (this.amY != null) {
                        this.amY.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.az(ec.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(t.j.copy_pb_url_success));
                    }
                    if (ec != null && ec.ani) {
                        j(8, ec.ann);
                    }
                }
            }
        }
    }

    private f ec(int i) {
        f fVar = this.ana.get(i);
        if (fVar == null) {
            return this.ana.get(1);
        }
        return fVar;
    }

    private void ed(int i) {
        if (i <= 7 && i > 0) {
            this.anb = true;
            if (this.and != null) {
                p pVar = this.and.get(i);
                if (!StringUtils.isNull(pVar.xQ()) && pVar.xR() != null && pVar.xR().size() > 0) {
                    k(pVar.xQ(), pVar.xR());
                    return;
                }
            }
            if (this.anc != null) {
                String str = this.anc.get(i);
                if (!ba.isEmpty(str)) {
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
            if (fVar.anj) {
                TiebaStatic.log(new ay("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.ank) {
                TiebaStatic.log(new ay("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.anl) {
                TiebaStatic.log(new ay("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.ani) {
                j(i, fVar.ann);
            }
        }
    }

    private void Az() {
        int size = this.amX.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.amX.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.d.cp_cont_f);
        }
        int paddingLeft = this.amQ.getPaddingLeft();
        av.k(this.amR, t.d.common_color_10010);
        av.k(this.amQ, t.f.bg_unite_popup_share_up);
        av.c(this.amQ, t.d.common_color_10039, 1);
        av.c(this.amS, t.d.cp_link_tip_a, 1);
        av.k(this.amS, t.f.dialog_single_button_bg_selector);
        av.k(this.amU, t.d.cp_bg_line_a);
        this.amQ.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = av.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        av.c(textView, i2, 1);
    }

    public void b(SparseArray<p> sparseArray) {
        this.and = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
