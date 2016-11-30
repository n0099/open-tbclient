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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String anF = "";
    private AlertDialog Wg;
    private final LinearLayout anA;
    private SparseArray<String> anD;
    private SparseArray<p> anE;
    private TextView anu;
    private final LinearLayout anw;
    private final LinearLayout anx;
    private View.OnClickListener anz;
    private final Context mContext;
    private final SparseArray<f> anB = new SparseArray<>(8);
    private boolean anC = false;
    private com.baidu.tbadk.coreExtra.share.a anG = new e(this);
    private final List<TextView> any = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_dialog_content, (ViewGroup) null);
    private final TextView anr = (TextView) this.mRootView.findViewById(r.g.share_dialog_title);
    private final View ans = this.mRootView.findViewById(r.g.share_dialog_content);
    private final View anv = this.mRootView.findViewById(r.g.line);
    private final TextView ant = (TextView) this.mRootView.findViewById(r.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.ant.setOnClickListener(this);
        A(r.j.share_weixin, r.f.icon_weixin);
        A(r.j.share_weixin_timeline, r.f.icon_weixin_q);
        A(r.j.share_qzone, r.f.icon_qq_zone);
        A(r.j.share_qq_friends, r.f.icon_qq_share);
        A(r.j.share_sina_weibo, r.f.icon_sina);
        this.anu = A(r.j.share_copy, r.f.icon_copy_link);
        this.anA = (LinearLayout) this.mRootView.findViewById(r.g.customViewBox);
        this.anw = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_1);
        this.anx = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.anw.setVisibility(8);
            this.anx.setVisibility(8);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ant.setOnClickListener(onClickListener);
        }
    }

    private TextView A(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AG());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.any.add(textView);
        return textView;
    }

    public TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AG());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams AG() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.any.add(0, textView);
    }

    public int AH() {
        if (this.any == null) {
            return 0;
        }
        return this.any.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.any.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.any.size() && i >= 0) {
            this.any.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener anI;

        public a(View.OnClickListener onClickListener) {
            this.anI = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.anI != null) {
                this.anI.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.anu.setVisibility(0);
        } else {
            this.anu.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.anG = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.anD = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.anB.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.anB.put(i, fVar);
    }

    private Location getLocation() {
        if (ae.Z(this.mContext)) {
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
            this.anz = onClickListener;
        }
    }

    public void AI() {
        int size = this.any.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView B = B(r.j.share_weixin_timeline, r.f.icon_weixin_q);
                B.setVisibility(4);
                this.any.add(B);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.anw.addView(this.any.get(i2));
            } else {
                this.anx.addView(this.any.get(i2));
            }
        }
    }

    public void show() {
        if (!i.gm()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.plugin_share_install_failure);
        } else {
            AI();
            this.Wg = new AlertDialog.Builder(this.mContext).create();
            this.Wg.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Wg, (Activity) this.mContext);
            }
            Window window = this.Wg.getWindow();
            window.setWindowAnimations(r.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.anG);
            window.setContentView(this.mRootView);
            AJ();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Wg.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Wg != null) {
            this.anC = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Wg, (Activity) this.mContext);
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
        if (this.anB.size() != 0) {
            if (view.getId() == r.g.btnShareCancel || !this.anC) {
                this.anC = true;
                h hVar = new h(this.mContext, this.anG);
                f ee = ee(1);
                if (id == r.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    this.anG.AD();
                }
                if (i == r.f.icon_weixin) {
                    k("share_to_weixin", new Object[0]);
                    ef(3);
                    f ee2 = ee(3);
                    a(ee2, 4);
                    if (ee2 != null) {
                        if (ee2.imageUri != null) {
                            anF = ee2.imageUri.toString();
                        }
                        hVar.c(ee2);
                    }
                } else if (i == r.f.icon_weixin_q) {
                    k("share_to_pyq", new Object[0]);
                    ef(2);
                    f ee3 = ee(2);
                    a(ee3, 3);
                    if (ee3 != null) {
                        if (ee3.anK) {
                            ee3.content = "【" + ee3.title + "】 " + ee3.content;
                        }
                        if (ee3.anN) {
                            ee3.content = "【" + ee3.title + "】 " + ee3.content;
                        }
                        if (ee3.imageUri != null) {
                            anF = ee3.imageUri.toString();
                        }
                        hVar.d(ee3);
                    }
                } else if (i == r.f.icon_qq_zone) {
                    if (aj.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qzone", new Object[0]);
                        ef(4);
                        f ee4 = ee(4);
                        a(ee4, 5);
                        if (ee4 != null) {
                            hVar.f(ee4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.j.share_qq_not_install)).ty();
                } else if (i == r.f.icon_qq_weibo) {
                    k("share_to_qweibo", new Object[0]);
                    ef(5);
                    f ee5 = ee(5);
                    a(ee5, 6);
                    if (ee5 != null) {
                        if (!ee5.anJ) {
                            ee5.content = b(ee5);
                        }
                        hVar.g(ee5);
                    }
                } else if (i == r.f.icon_sina) {
                    k("share_to_sweibo", new Object[0]);
                    ef(6);
                    f ee6 = ee(6);
                    a(ee6, 7);
                    if (ee6 != null) {
                        if (!ee6.anJ) {
                            ee6.content = b(ee6);
                        }
                        hVar.h(ee6);
                    }
                } else if (i == r.f.icon_renren) {
                    k("share_to_renren", new Object[0]);
                    ef(7);
                    f ee7 = ee(7);
                    a(ee7, 8);
                    if (ee7 != null) {
                        if (!ee7.anJ) {
                            ee7.content = b(ee7);
                        }
                        hVar.i(ee7);
                    }
                } else if (i == r.f.icon_qq_share) {
                    if (aj.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qq_friend", new Object[0]);
                        ef(8);
                        f ee8 = ee(8);
                        a(ee8, 9);
                        if (ee8 != null) {
                            hVar.e(ee8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.j.share_qq_not_install)).ty();
                } else if (i == r.f.icon_copy_link) {
                    a(ee, 10);
                    if (this.anz != null) {
                        this.anz.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.az(ee.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(r.j.copy_pb_url_success));
                    }
                    if (ee != null && ee.anJ) {
                        i(8, ee.anP);
                    }
                }
            }
        }
    }

    private f ee(int i) {
        f fVar = this.anB.get(i);
        if (fVar == null) {
            return this.anB.get(1);
        }
        return fVar;
    }

    private void ef(int i) {
        if (i <= 8 && i > 0) {
            this.anC = true;
            if (this.anE != null) {
                p pVar = this.anE.get(i);
                if (!StringUtils.isNull(pVar.xZ()) && pVar.ya() != null && pVar.ya().size() > 0) {
                    k(pVar.xZ(), pVar.ya());
                    return;
                }
            }
            if (this.anD != null) {
                String str = this.anD.get(i);
                if (!ax.isEmpty(str)) {
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
            if (fVar.anK) {
                TiebaStatic.log(new av("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.anL) {
                TiebaStatic.log(new av("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.anM) {
                TiebaStatic.log(new av("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.anJ) {
                i(i, fVar.anP);
            } else if (fVar.anO) {
                TiebaStatic.log(new av("c10125").s("obj_param1", 7).s("obj_type", i).ab("fid", fVar.extData));
            }
        }
    }

    private void AJ() {
        int size = this.any.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.any.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), r.d.cp_cont_j);
        }
        int paddingLeft = this.anr.getPaddingLeft();
        at.k(this.ans, r.d.common_color_10010);
        at.k(this.anr, r.f.bg_unite_popup_share_up);
        at.c(this.anr, r.d.common_color_10039, 1);
        at.c(this.ant, r.d.cp_cont_f, 1);
        at.k(this.ant, r.f.dialog_single_button_bg_selector);
        at.k(this.anv, r.d.cp_bg_line_a);
        this.anr.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = at.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        at.c(textView, i2, 1);
    }

    public void b(SparseArray<p> sparseArray) {
        this.anE = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
