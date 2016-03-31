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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String amR = "";
    private AlertDialog Wx;
    private TextView amG;
    private final LinearLayout amI;
    private final LinearLayout amJ;
    private View.OnClickListener amL;
    private final LinearLayout amM;
    private SparseArray<String> amP;
    private SparseArray<l> amQ;
    private final Context mContext;
    private final SparseArray<f> amN = new SparseArray<>(7);
    private boolean amO = false;
    private com.baidu.tbadk.coreExtra.share.a amS = new e(this);
    private final List<TextView> amK = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_dialog_content, (ViewGroup) null);
    private final TextView amD = (TextView) this.mRootView.findViewById(t.g.share_dialog_title);
    private final View amE = this.mRootView.findViewById(t.g.share_dialog_content);
    private final View amH = this.mRootView.findViewById(t.g.line);
    private final TextView amF = (TextView) this.mRootView.findViewById(t.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amF.setOnClickListener(this);
        y(t.j.share_weixin_timeline, t.f.icon_weixin_q);
        y(t.j.share_weixin, t.f.icon_weixin);
        y(t.j.share_qzone, t.f.icon_qq_zone);
        y(t.j.share_sina_weibo, t.f.icon_sina);
        y(t.j.share_qweibo, t.f.icon_qq_weibo);
        this.amG = y(t.j.share_copy, t.f.icon_copy_link);
        this.amM = (LinearLayout) this.mRootView.findViewById(t.g.customViewBox);
        this.amI = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_1);
        this.amJ = (LinearLayout) this.mRootView.findViewById(t.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amI.setVisibility(8);
            this.amJ.setVisibility(8);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.amF.setOnClickListener(onClickListener);
        }
    }

    private TextView y(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Bi());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.amK.add(textView);
        return textView;
    }

    public TextView z(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Bi());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Bi() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.amK.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.amK.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener amU;

        public a(View.OnClickListener onClickListener) {
            this.amU = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.amU != null) {
                this.amU.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.amG.setVisibility(0);
        } else {
            this.amG.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.amS = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.amP = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amN.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.amN.put(i, fVar);
    }

    private Location getLocation() {
        if (ag.R(this.mContext)) {
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
            this.amL = onClickListener;
        }
    }

    public void Bj() {
        int size = this.amK.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView z = z(t.j.share_weixin_timeline, t.f.icon_weixin_q);
                z.setVisibility(4);
                this.amK.add(z);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.amI.addView(this.amK.get(i2));
            } else {
                this.amJ.addView(this.amK.get(i2));
            }
        }
    }

    public void show() {
        if (!i.jf()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.plugin_share_install_failure);
        } else {
            Bj();
            this.Wx = new AlertDialog.Builder(this.mContext).create();
            this.Wx.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.Wx, (Activity) this.mContext);
            }
            Window window = this.Wx.getWindow();
            window.setWindowAnimations(t.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.amS);
            window.setContentView(this.mRootView);
            Bk();
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Wx.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Wx != null) {
            this.amO = false;
            if (this.mContext instanceof Activity) {
                j.b(this.Wx, (Activity) this.mContext);
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
        if (this.amN.size() != 0) {
            if (view.getId() == t.g.btnShareCancel || !this.amO) {
                this.amO = true;
                h hVar = new h(this.mContext, this.amS);
                f eh = eh(1);
                if (id == t.g.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    this.amS.Bf();
                }
                if (i == t.f.icon_weixin) {
                    f("share_to_weixin", new Object[0]);
                    ei(3);
                    f eh2 = eh(3);
                    a(eh2, 4);
                    if (eh2 != null) {
                        if (eh2.imageUri != null) {
                            amR = eh2.imageUri.toString();
                        }
                        hVar.c(eh2);
                    }
                } else if (i == t.f.icon_weixin_q) {
                    f("share_to_pyq", new Object[0]);
                    ei(2);
                    f eh3 = eh(2);
                    a(eh3, 3);
                    if (eh3 != null) {
                        if (eh3.amW) {
                            eh3.content = "【" + eh3.title + "】 " + eh3.content;
                        }
                        if (eh3.imageUri != null) {
                            amR = eh3.imageUri.toString();
                        }
                        hVar.d(eh3);
                    }
                } else if (i == t.f.icon_qq_zone) {
                    if (com.baidu.tieba.tbadkCore.ag.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        f("share_to_qzone", new Object[0]);
                        ei(4);
                        f eh4 = eh(4);
                        a(eh4, 5);
                        if (eh4 != null) {
                            hVar.e(eh4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(t.j.share_qq_not_install)).ux();
                } else if (i == t.f.icon_qq_weibo) {
                    f("share_to_qweibo", new Object[0]);
                    ei(5);
                    f eh5 = eh(5);
                    a(eh5, 6);
                    if (eh5 != null) {
                        if (!eh5.amV) {
                            eh5.content = b(eh5);
                        }
                        hVar.f(eh5);
                    }
                } else if (i == t.f.icon_sina) {
                    f("share_to_sweibo", new Object[0]);
                    ei(6);
                    f eh6 = eh(6);
                    a(eh6, 7);
                    if (eh6 != null) {
                        if (!eh6.amV) {
                            eh6.content = b(eh6);
                        }
                        hVar.g(eh6);
                    }
                } else if (i == t.f.icon_renren) {
                    f("share_to_renren", new Object[0]);
                    ei(7);
                    f eh7 = eh(7);
                    a(eh7, 8);
                    if (eh7 != null) {
                        if (!eh7.amV) {
                            eh7.content = b(eh7);
                        }
                        hVar.h(eh7);
                    }
                } else if (i == t.f.icon_copy_link) {
                    a(eh, 10);
                    if (this.amL != null) {
                        this.amL.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aD(eh.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(t.j.copy_pb_url_success));
                    }
                    if (eh != null && eh.amV) {
                        j(8, eh.amZ);
                    }
                }
            }
        }
    }

    private f eh(int i) {
        f fVar = this.amN.get(i);
        if (fVar == null) {
            return this.amN.get(1);
        }
        return fVar;
    }

    private void ei(int i) {
        if (i <= 7 && i > 0) {
            this.amO = true;
            if (this.amQ != null) {
                l lVar = this.amQ.get(i);
                if (!StringUtils.isNull(lVar.yJ()) && lVar.yK() != null && lVar.yK().size() > 0) {
                    f(lVar.yJ(), lVar.yK());
                    return;
                }
            }
            if (this.amP != null) {
                String str = this.amP.get(i);
                if (!ay.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void j(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.amW) {
                TiebaStatic.log(new aw("c10125").ac("fid", fVar.extData).r("obj_type", i));
            } else if (fVar.amX) {
                TiebaStatic.log(new aw("c10125").ac("tid", fVar.extData).r("obj_type", i));
            } else if (fVar.amY) {
                TiebaStatic.log(new aw("c10427").ac("tid", fVar.extData).r("obj_type", i));
            } else if (fVar.amV) {
                j(i, fVar.amZ);
            }
        }
    }

    private void Bk() {
        int size = this.amK.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.amK.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), t.d.cp_cont_f);
        }
        int paddingLeft = this.amD.getPaddingLeft();
        at.k(this.amE, t.d.share_dialog_bg);
        at.k(this.amD, t.f.bg_unite_popup_share_up);
        at.b(this.amD, t.d.share_to, 1);
        at.b(this.amF, t.d.cp_link_tip_a, 1);
        at.k(this.amH, t.d.cp_bg_line_a);
        this.amD.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = at.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        at.b(textView, i2, 1);
    }

    public void b(SparseArray<l> sparseArray) {
        this.amQ = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
