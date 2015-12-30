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
    public static String alI = "";
    private AlertDialog XR;
    private final LinearLayout alA;
    private View.OnClickListener alC;
    private final LinearLayout alD;
    private SparseArray<String> alG;
    private SparseArray<l> alH;
    private TextView aly;
    private final LinearLayout alz;
    private final Context mContext;
    private final SparseArray<f> alE = new SparseArray<>(7);
    private boolean alF = false;
    private com.baidu.tbadk.coreExtra.share.a alJ = new e(this);
    private final List<TextView> alB = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.h.share_dialog_content, (ViewGroup) null);
    private final TextView alv = (TextView) this.mRootView.findViewById(n.g.share_dialog_title);
    private final View alw = this.mRootView.findViewById(n.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(n.g.line);
    private final TextView alx = (TextView) this.mRootView.findViewById(n.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.alx.setOnClickListener(this);
        F(n.j.share_weixin_timeline, n.f.icon_weixin_q);
        F(n.j.share_weixin, n.f.icon_weixin);
        F(n.j.share_qzone, n.f.icon_qq_zone);
        F(n.j.share_sina_weibo, n.f.icon_sina);
        F(n.j.share_qweibo, n.f.icon_qq_weibo);
        this.aly = F(n.j.share_copy, n.f.icon_copy_link);
        this.alD = (LinearLayout) this.mRootView.findViewById(n.g.customViewBox);
        this.alz = (LinearLayout) this.mRootView.findViewById(n.g.share_dialog_line_1);
        this.alA = (LinearLayout) this.mRootView.findViewById(n.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.alz.setVisibility(8);
            this.alA.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.alx.setOnClickListener(onClickListener);
        }
    }

    private TextView F(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zn());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.alB.add(textView);
        return textView;
    }

    public TextView G(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(zn());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams zn() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.alB.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.alB.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener alL;

        public a(View.OnClickListener onClickListener) {
            this.alL = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.alL != null) {
                this.alL.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.aly.setVisibility(0);
        } else {
            this.aly.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.alJ = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.alG = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.alE.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.alE.put(i, fVar);
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
            this.alC = onClickListener;
        }
    }

    public void zo() {
        int size = this.alB.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView G = G(n.j.share_weixin_timeline, n.f.icon_weixin_q);
                G.setVisibility(4);
                this.alB.add(G);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.alz.addView(this.alB.get(i2));
            } else {
                this.alA.addView(this.alB.get(i2));
            }
        }
    }

    public void show() {
        if (!i.iQ()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.j.plugin_share_install_failure);
        } else {
            zo();
            this.XR = new AlertDialog.Builder(this.mContext).create();
            this.XR.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.XR, (Activity) this.mContext);
            }
            Window window = this.XR.getWindow();
            window.setWindowAnimations(n.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.alJ);
            window.setContentView(this.mRootView);
            zp();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.XR.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.XR != null) {
            this.alF = false;
            if (this.mContext instanceof Activity) {
                j.b(this.XR, (Activity) this.mContext);
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
        if (this.alE.size() != 0) {
            if (view.getId() == n.g.btnShareCancel || !this.alF) {
                this.alF = true;
                h hVar = new h(this.mContext, this.alJ);
                f dJ = dJ(1);
                if (id == n.g.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.alJ.zk();
                }
                if (i == n.f.icon_weixin) {
                    c("share_to_weixin", new Object[0]);
                    dK(3);
                    f dJ2 = dJ(3);
                    a(dJ2, 4);
                    if (dJ2 != null) {
                        if (dJ2.imageUri != null) {
                            alI = dJ2.imageUri.toString();
                        }
                        hVar.c(dJ2);
                        if (dJ2.alM) {
                            r(3, dJ2.alP);
                        }
                    }
                } else if (i == n.f.icon_weixin_q) {
                    c("share_to_pyq", new Object[0]);
                    dK(2);
                    f dJ3 = dJ(2);
                    a(dJ3, 3);
                    if (dJ3 != null) {
                        if (dJ3.alN) {
                            dJ3.content = "【" + dJ3.title + "】 " + dJ3.content;
                        }
                        if (dJ3.imageUri != null) {
                            alI = dJ3.imageUri.toString();
                        }
                        hVar.d(dJ3);
                        if (dJ3.alM) {
                            r(3, dJ3.alP);
                        }
                    }
                } else if (i == n.f.icon_qq_zone) {
                    c("share_to_qzone", new Object[0]);
                    dK(4);
                    f dJ4 = dJ(4);
                    a(dJ4, 5);
                    if (dJ4 != null) {
                        hVar.e(dJ4);
                        if (dJ4.alM) {
                            r(3, dJ4.alP);
                        }
                    }
                } else if (i == n.f.icon_qq_weibo) {
                    c("share_to_qweibo", new Object[0]);
                    dK(5);
                    f dJ5 = dJ(5);
                    a(dJ5, 6);
                    if (dJ5 != null) {
                        if (dJ5.alM) {
                            r(3, dJ5.alP);
                        } else {
                            dJ5.content = b(dJ5);
                        }
                        hVar.f(dJ5);
                    }
                } else if (i == n.f.icon_sina) {
                    c("share_to_sweibo", new Object[0]);
                    dK(6);
                    f dJ6 = dJ(6);
                    a(dJ6, 7);
                    if (dJ6 != null) {
                        if (dJ6.alM) {
                            r(3, dJ6.alP);
                        } else {
                            dJ6.content = b(dJ6);
                        }
                        hVar.g(dJ6);
                    }
                } else if (i == n.f.icon_renren) {
                    c("share_to_renren", new Object[0]);
                    dK(7);
                    f dJ7 = dJ(7);
                    a(dJ7, 8);
                    if (dJ7 != null) {
                        if (dJ7.alM) {
                            r(3, dJ7.alP);
                        } else {
                            dJ7.content = b(dJ7);
                        }
                        hVar.h(dJ7);
                    }
                } else if (i == n.f.icon_copy_link) {
                    if (this.alC != null) {
                        this.alC.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aC(dJ.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(n.j.copy_pb_url_success));
                    }
                    if (dJ != null && dJ.alM) {
                        r(8, dJ.alP);
                    }
                }
            }
        }
    }

    private f dJ(int i) {
        f fVar = this.alE.get(i);
        if (fVar == null) {
            return this.alE.get(1);
        }
        return fVar;
    }

    private void dK(int i) {
        if (i <= 7 && i > 0) {
            this.alF = true;
            if (this.alH != null) {
                l lVar = this.alH.get(i);
                if (!StringUtils.isNull(lVar.wV()) && lVar.wW() != null && lVar.wW().size() > 0) {
                    c(lVar.wV(), lVar.wW());
                    return;
                }
            }
            if (this.alG != null) {
                String str = this.alG.get(i);
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
            if (fVar.alN) {
                TiebaStatic.log(new av("c10125").aa(ImageViewerConfig.FORUM_ID, fVar.extData).r("obj_type", i));
            } else if (fVar.alO) {
                TiebaStatic.log(new av("c10125").aa("tid", fVar.extData).r("obj_type", i));
            } else if (fVar.isFromPhotoLive) {
                TiebaStatic.log(new av("c10427").aa("tid", fVar.extData).r("obj_type", i));
            }
        }
    }

    private void zp() {
        int size = this.alB.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.alB.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), n.d.cp_cont_f);
        }
        int paddingLeft = this.alv.getPaddingLeft();
        as.i(this.alw, n.d.share_dialog_bg);
        as.i((View) this.alv, n.f.bg_unite_popup_share_up);
        as.b(this.alv, n.d.share_to, 1);
        as.b(this.alx, n.d.cp_link_tip_a, 1);
        as.i(this.mLine, n.d.cp_bg_line_a);
        this.alv.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = as.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        as.b(textView, i2, 1);
    }

    public void b(SparseArray<l> sparseArray) {
        this.alH = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
