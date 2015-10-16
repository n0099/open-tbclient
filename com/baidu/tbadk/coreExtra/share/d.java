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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private AlertDialog Wy;
    private TextView aiA;
    private final LinearLayout aiB;
    private final LinearLayout aiC;
    private View.OnClickListener aiE;
    private final LinearLayout aiF;
    private SparseArray<String> aiI;
    private SparseArray<j> aiJ;
    private final Context mContext;
    private final SparseArray<f> aiG = new SparseArray<>(7);
    private boolean aiH = false;
    private com.baidu.tbadk.coreExtra.share.a aiK = new e(this);
    private final List<TextView> aiD = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_dialog_content, (ViewGroup) null);
    private final TextView aix = (TextView) this.mRootView.findViewById(i.f.share_dialog_title);
    private final View aiy = this.mRootView.findViewById(i.f.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(i.f.line);
    private final TextView aiz = (TextView) this.mRootView.findViewById(i.f.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.aiz.setOnClickListener(this);
        E(i.h.share_weixin_timeline, i.e.icon_weixin_q);
        E(i.h.share_weixin, i.e.icon_weixin);
        E(i.h.share_qzone, i.e.icon_qq_zone);
        E(i.h.share_sina_weibo, i.e.icon_sina);
        E(i.h.share_qweibo, i.e.icon_qq_weibo);
        this.aiA = E(i.h.share_copy, i.e.icon_copy_link);
        this.aiF = (LinearLayout) this.mRootView.findViewById(i.f.customViewBox);
        this.aiB = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_1);
        this.aiC = (LinearLayout) this.mRootView.findViewById(i.f.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.aiB.setVisibility(8);
            this.aiC.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.aiz.setOnClickListener(onClickListener);
        }
    }

    private TextView E(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yD());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.aiD.add(textView);
        return textView;
    }

    public TextView F(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m411getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(yD());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams yD() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void b(TextView textView) {
        this.aiD.add(0, textView);
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.aiD.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener aiM;

        public a(View.OnClickListener onClickListener) {
            this.aiM = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.aiM != null) {
                this.aiM.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        if (z) {
            this.aiA.setVisibility(0);
        } else {
            this.aiA.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.aiK = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.aiI = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aiG.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.aiG.put(i, fVar);
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
            this.aiE = onClickListener;
        }
    }

    public void yE() {
        int size = this.aiD.size();
        if (size < 10) {
            for (int i = 0; i < 10 - size; i++) {
                TextView F = F(i.h.share_weixin_timeline, i.e.icon_weixin_q);
                F.setVisibility(4);
                this.aiD.add(F);
            }
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 < 5) {
                this.aiB.addView(this.aiD.get(i2));
            } else {
                this.aiC.addView(this.aiD.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.share_on_no_network);
            return;
        }
        yE();
        this.Wy = new AlertDialog.Builder(this.mContext).create();
        this.Wy.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.a(this.Wy, (Activity) this.mContext);
        }
        Window window = this.Wy.getWindow();
        window.setWindowAnimations(i.C0057i.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.aiK);
        window.setContentView(this.mRootView);
        yF();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Wy.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Wy != null) {
            this.aiH = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.Wy, (Activity) this.mContext);
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
        if (this.aiG.size() != 0) {
            if (view.getId() == i.f.btnShareCancel || !this.aiH) {
                this.aiH = true;
                h hVar = new h(this.mContext, this.aiK);
                f dA = dA(1);
                if (id == i.f.btnShareCancel) {
                    c("share_cancel", new Object[0]);
                    this.aiK.yA();
                }
                if (i == i.e.icon_weixin) {
                    c("share_to_weixin", new Object[0]);
                    dB(3);
                    f dA2 = dA(3);
                    a(dA2, 4);
                    if (dA2 != null) {
                        hVar.c(dA2);
                        if (dA2.aiN) {
                            q(3, dA2.aiQ);
                        }
                    }
                } else if (i == i.e.icon_weixin_q) {
                    c("share_to_pyq", new Object[0]);
                    dB(2);
                    f dA3 = dA(2);
                    a(dA3, 3);
                    if (dA3 != null) {
                        if (dA3.aiO) {
                            dA3.content = "【" + dA3.title + "】 " + dA3.content;
                        }
                        hVar.d(dA3);
                        if (dA3.aiN) {
                            q(3, dA3.aiQ);
                        }
                    }
                } else if (i == i.e.icon_qq_zone) {
                    c("share_to_qzone", new Object[0]);
                    dB(4);
                    f dA4 = dA(4);
                    a(dA4, 5);
                    if (dA4 != null) {
                        hVar.e(dA4);
                        if (dA4.aiN) {
                            q(3, dA4.aiQ);
                        }
                    }
                } else if (i == i.e.icon_qq_weibo) {
                    c("share_to_qweibo", new Object[0]);
                    dB(5);
                    f dA5 = dA(5);
                    a(dA5, 6);
                    if (dA5 != null) {
                        if (dA5.aiN) {
                            q(3, dA5.aiQ);
                        } else {
                            dA5.content = b(dA5);
                        }
                        hVar.f(dA5);
                    }
                } else if (i == i.e.icon_sina) {
                    c("share_to_sweibo", new Object[0]);
                    dB(6);
                    f dA6 = dA(6);
                    a(dA6, 7);
                    if (dA6 != null) {
                        if (dA6.aiN) {
                            q(3, dA6.aiQ);
                        } else {
                            dA6.content = b(dA6);
                        }
                        hVar.g(dA6);
                    }
                } else if (i == i.e.icon_renren) {
                    c("share_to_renren", new Object[0]);
                    dB(7);
                    f dA7 = dA(7);
                    a(dA7, 8);
                    if (dA7 != null) {
                        if (dA7.aiN) {
                            q(3, dA7.aiQ);
                        } else {
                            dA7.content = b(dA7);
                        }
                        hVar.h(dA7);
                    }
                } else if (i == i.e.icon_copy_link) {
                    if (this.aiE != null) {
                        this.aiE.onClick(view);
                    }
                    if (dA != null && dA.aiN) {
                        q(8, dA.aiQ);
                    }
                }
            }
        }
    }

    private f dA(int i) {
        f fVar = this.aiG.get(i);
        if (fVar == null) {
            return this.aiG.get(1);
        }
        return fVar;
    }

    private void dB(int i) {
        if (i <= 7 && i > 0) {
            this.aiH = true;
            if (this.aiJ != null) {
                j jVar = this.aiJ.get(i);
                if (!StringUtils.isNull(jVar.wp()) && jVar.wq() != null && jVar.wq().size() > 0) {
                    c(jVar.wp(), jVar.wq());
                    return;
                }
            }
            if (this.aiI != null) {
                String str = this.aiI.get(i);
                if (!as.isEmpty(str)) {
                    c(str, new Object[0]);
                }
            }
        }
    }

    private void c(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void q(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.aiO) {
                TiebaStatic.log(new aq("c10125").ae(ImageViewerConfig.FORUM_ID, fVar.extData).r("obj_type", i));
            } else if (fVar.aiP) {
                TiebaStatic.log(new aq("c10125").ae("tid", fVar.extData).r("obj_type", i));
            }
        }
    }

    private void yF() {
        int size = this.aiD.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.aiD.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), i.c.cp_cont_f);
        }
        int paddingLeft = this.aix.getPaddingLeft();
        an.i(this.aiy, i.c.share_dialog_bg);
        an.i((View) this.aix, i.e.bg_unite_popup_share_up);
        an.b(this.aix, i.c.share_to, 1);
        an.b(this.aiz, i.c.cp_link_tip_a, 1);
        an.i(this.mLine, i.c.cp_bg_line_a);
        this.aix.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = an.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        an.b(textView, i2, 1);
    }

    public void b(SparseArray<j> sparseArray) {
        this.aiJ = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
