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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String akC = "";
    private AlertDialog Xo;
    private SparseArray<String> akA;
    private SparseArray<l> akB;
    private TextView aks;
    private final LinearLayout akt;
    private final LinearLayout aku;
    private View.OnClickListener akw;
    private final LinearLayout akx;
    private final Context mContext;
    private final SparseArray<f> aky = new SparseArray<>(7);
    private boolean akz = false;
    private com.baidu.tbadk.coreExtra.share.a akD = new e(this);
    private final List<TextView> akv = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.g.share_dialog_content, (ViewGroup) null);
    private final TextView akp = (TextView) this.mRootView.findViewById(n.f.share_dialog_title);
    private final View akq = this.mRootView.findViewById(n.f.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(n.f.line);
    private final TextView akr = (TextView) this.mRootView.findViewById(n.f.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.akr.setOnClickListener(this);
        F(n.i.share_weixin_timeline, n.e.icon_weixin_q);
        F(n.i.share_weixin, n.e.icon_weixin);
        F(n.i.share_qzone, n.e.icon_qq_zone);
        F(n.i.share_sina_weibo, n.e.icon_sina);
        F(n.i.share_qweibo, n.e.icon_qq_weibo);
        this.aks = F(n.i.share_copy, n.e.icon_copy_link);
        this.akx = (LinearLayout) this.mRootView.findViewById(n.f.customViewBox);
        this.akt = (LinearLayout) this.mRootView.findViewById(n.f.share_dialog_line_1);
        this.aku = (LinearLayout) this.mRootView.findViewById(n.f.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.akt.setVisibility(8);
            this.aku.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.akr.setOnClickListener(onClickListener);
        }
    }

    private TextView F(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zB());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.akv.add(textView);
        return textView;
    }

    public TextView G(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zB());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams zB() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.akv.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.akv.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener akF;

        public a(View.OnClickListener onClickListener) {
            this.akF = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.akF != null) {
                this.akF.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.aks.setVisibility(0);
        } else {
            this.aks.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.akD = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.akA = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aky.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aky.put(i, fVar);
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
            this.akw = onClickListener;
        }
    }

    public void zC() {
        int size = this.akv.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView G = G(n.i.share_weixin_timeline, n.e.icon_weixin_q);
                G.setVisibility(4);
                this.akv.add(G);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.akt.addView(this.akv.get(i2));
            } else {
                this.aku.addView(this.akv.get(i2));
            }
        }
    }

    public void show() {
        if (!i.iP()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.i.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.i.plugin_share_install_failure);
        } else {
            zC();
            this.Xo = new AlertDialog.Builder(this.mContext).create();
            this.Xo.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Xo, (Activity) this.mContext);
            }
            Window window = this.Xo.getWindow();
            window.setWindowAnimations(n.j.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.akD);
            window.setContentView(this.mRootView);
            zD();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Xo.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Xo != null) {
            this.akz = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Xo, (Activity) this.mContext);
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
        if (this.aky.size() != 0) {
            if (view.getId() == n.f.btnShareCancel || !this.akz) {
                this.akz = true;
                h hVar = new h(this.mContext, this.akD);
                f dP = dP(1);
                if (id == n.f.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.akD.zy();
                }
                if (i == n.e.icon_weixin) {
                    c("share_to_weixin", new Object[0]);
                    dQ(3);
                    f dP2 = dP(3);
                    a(dP2, 4);
                    if (dP2 != null) {
                        if (dP2.imageUri != null) {
                            akC = dP2.imageUri.toString();
                        }
                        hVar.c(dP2);
                        if (dP2.akG) {
                            r(3, dP2.akJ);
                        }
                    }
                } else if (i == n.e.icon_weixin_q) {
                    c("share_to_pyq", new Object[0]);
                    dQ(2);
                    f dP3 = dP(2);
                    a(dP3, 3);
                    if (dP3 != null) {
                        if (dP3.akH) {
                            dP3.content = "【" + dP3.title + "】 " + dP3.content;
                        }
                        if (dP3.imageUri != null) {
                            akC = dP3.imageUri.toString();
                        }
                        hVar.d(dP3);
                        if (dP3.akG) {
                            r(3, dP3.akJ);
                        }
                    }
                } else if (i == n.e.icon_qq_zone) {
                    c("share_to_qzone", new Object[0]);
                    dQ(4);
                    f dP4 = dP(4);
                    a(dP4, 5);
                    if (dP4 != null) {
                        hVar.e(dP4);
                        if (dP4.akG) {
                            r(3, dP4.akJ);
                        }
                    }
                } else if (i == n.e.icon_qq_weibo) {
                    c("share_to_qweibo", new Object[0]);
                    dQ(5);
                    f dP5 = dP(5);
                    a(dP5, 6);
                    if (dP5 != null) {
                        if (dP5.akG) {
                            r(3, dP5.akJ);
                        } else {
                            dP5.content = b(dP5);
                        }
                        hVar.f(dP5);
                    }
                } else if (i == n.e.icon_sina) {
                    c("share_to_sweibo", new Object[0]);
                    dQ(6);
                    f dP6 = dP(6);
                    a(dP6, 7);
                    if (dP6 != null) {
                        if (dP6.akG) {
                            r(3, dP6.akJ);
                        } else {
                            dP6.content = b(dP6);
                        }
                        hVar.g(dP6);
                    }
                } else if (i == n.e.icon_renren) {
                    c("share_to_renren", new Object[0]);
                    dQ(7);
                    f dP7 = dP(7);
                    a(dP7, 8);
                    if (dP7 != null) {
                        if (dP7.akG) {
                            r(3, dP7.akJ);
                        } else {
                            dP7.content = b(dP7);
                        }
                        hVar.h(dP7);
                    }
                } else if (i == n.e.icon_copy_link) {
                    if (this.akw != null) {
                        this.akw.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aC(dP.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(n.i.copy_pb_url_success));
                    }
                    if (dP != null && dP.akG) {
                        r(8, dP.akJ);
                    }
                }
            }
        }
    }

    private f dP(int i) {
        f fVar = this.aky.get(i);
        if (fVar == null) {
            return this.aky.get(1);
        }
        return fVar;
    }

    private void dQ(int i) {
        if (i <= 7 && i > 0) {
            this.akz = true;
            if (this.akB != null) {
                l lVar = this.akB.get(i);
                if (!StringUtils.isNull(lVar.xm()) && lVar.xn() != null && lVar.xn().size() > 0) {
                    c(lVar.xm(), lVar.xn());
                    return;
                }
            }
            if (this.akA != null) {
                String str = this.akA.get(i);
                if (!ax.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void r(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.akH) {
                TiebaStatic.log(new av("c10125").ab(ImageViewerConfig.FORUM_ID, fVar.extData).r("obj_type", i));
            } else if (fVar.akI) {
                TiebaStatic.log(new av("c10125").ab("tid", fVar.extData).r("obj_type", i));
            } else if (fVar.isFromPhotoLive) {
                TiebaStatic.log(new av("c10427").ab("tid", fVar.extData).r("obj_type", i));
            }
        }
    }

    private void zD() {
        int size = this.akv.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.akv.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), n.c.cp_cont_f);
        }
        int paddingLeft = this.akp.getPaddingLeft();
        as.i(this.akq, n.c.share_dialog_bg);
        as.i((View) this.akp, n.e.bg_unite_popup_share_up);
        as.b(this.akp, n.c.share_to, 1);
        as.b(this.akr, n.c.cp_link_tip_a, 1);
        as.i(this.mLine, n.c.cp_bg_line_a);
        this.akp.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = as.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        as.b(textView, i2, 1);
    }

    public void b(SparseArray<l> sparseArray) {
        this.akB = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
