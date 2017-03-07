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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String arH = "";
    private AlertDialog aab;
    private final LinearLayout arA;
    private View.OnClickListener arC;
    private SparseArray<String> arF;
    private SparseArray<o> arG;
    private TextView arx;
    private final LinearLayout arz;
    private final Context mContext;
    private final SparseArray<g> arD = new SparseArray<>(8);
    private boolean arE = false;
    private boolean arI = true;
    private com.baidu.tbadk.coreExtra.share.a arJ = new e(this);
    private final List<TextView> arB = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
    private final TextView aru = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
    private final View arv = this.mRootView.findViewById(w.h.share_dialog_content);
    private final View ary = this.mRootView.findViewById(w.h.line);
    private final TextView arw = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.arw.setOnClickListener(this);
        H(w.l.share_weixin, w.g.icon_weixin);
        H(w.l.share_weixin_timeline, w.g.icon_weixin_q);
        H(w.l.share_qzone, w.g.icon_qq_zone);
        H(w.l.share_qq_friends, w.g.icon_qq_share);
        H(w.l.share_sina_weibo, w.g.icon_sina);
        this.arz = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_1);
        this.arA = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.arz.setVisibility(8);
            this.arA.setVisibility(8);
        }
    }

    private void AF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AG());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.arB.add(textView);
        return textView;
    }

    public TextView I(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
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

    public int AH() {
        if (this.arB == null) {
            return 0;
        }
        return this.arB.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.arB.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.arB.size() && i >= 0) {
            this.arB.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener arL;

        public a(View.OnClickListener onClickListener) {
            this.arL = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.arL != null) {
                this.arL.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.arI = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.arJ = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.arF = sparseArray;
    }

    public void a(g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.arD.put(1, gVar);
    }

    public void a(int i, g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.arD.put(i, gVar);
    }

    private Location getLocation() {
        if (ae.ax(this.mContext)) {
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
            this.arC = onClickListener;
        }
    }

    public void AI() {
        if (this.arI) {
            this.arx = H(w.l.share_copy, w.g.icon_copy_link);
        }
        int size = this.arB.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView I = I(w.l.share_weixin_timeline, w.g.icon_weixin_q);
                I.setVisibility(4);
                this.arB.add(I);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.arz.addView(this.arB.get(i2));
            } else {
                this.arA.addView(this.arB.get(i2));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.he()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            AI();
            this.aab = new AlertDialog.Builder(this.mContext).create();
            this.aab.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.aab, (Activity) this.mContext);
            }
            Window window = this.aab.getWindow();
            window.setWindowAnimations(w.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.arJ);
            window.setContentView(this.mRootView);
            AJ();
            AF();
        }
    }

    public void dismiss() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
        if (this.aab != null) {
            this.arE = false;
            if (this.mContext instanceof Activity) {
                j.b(this.aab, (Activity) this.mContext);
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
        if (this.arD.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.arE) {
                this.arE = true;
                i iVar = new i(this.mContext, this.arJ);
                g eb = eb(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.arJ.AC();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ec(3);
                    g eb2 = eb(3);
                    a(eb2, 4);
                    if (eb2 != null) {
                        if (eb2.imageUri != null) {
                            arH = eb2.imageUri.toString();
                        }
                        iVar.c(eb2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ec(2);
                    g eb3 = eb(2);
                    a(eb3, 3);
                    if (eb3 != null) {
                        if (eb3.arN) {
                            eb3.content = "【" + eb3.title + "】 " + eb3.content;
                        }
                        if (eb3.imageUri != null) {
                            arH = eb3.imageUri.toString();
                        }
                        iVar.d(eb3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        h("share_to_qzone", new Object[0]);
                        ec(4);
                        g eb4 = eb(4);
                        a(eb4, 5);
                        if (eb4 != null) {
                            iVar.f(eb4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tA();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ec(5);
                    g eb5 = eb(5);
                    a(eb5, 6);
                    if (eb5 != null) {
                        if (!eb5.arM) {
                            eb5.content = b(eb5);
                        }
                        iVar.g(eb5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ec(6);
                    g eb6 = eb(6);
                    a(eb6, 7);
                    if (eb6 != null) {
                        if (!eb6.arM) {
                            eb6.content = b(eb6);
                        }
                        iVar.h(eb6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ec(7);
                    g eb7 = eb(7);
                    a(eb7, 8);
                    if (eb7 != null) {
                        if (!eb7.arM) {
                            eb7.content = b(eb7);
                        }
                        iVar.i(eb7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        h("share_to_qq_friend", new Object[0]);
                        ec(8);
                        g eb8 = eb(8);
                        a(eb8, 9);
                        if (eb8 != null) {
                            iVar.e(eb8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tA();
                } else if (i == w.g.icon_copy_link) {
                    a(eb, 10);
                    if (this.arC != null) {
                        this.arC.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.as(eb.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(w.l.copy_pb_url_success));
                    }
                    if (eb != null && eb.arM) {
                        j(8, eb.arS);
                    }
                }
            }
        }
    }

    private g eb(int i) {
        g gVar = this.arD.get(i);
        if (gVar == null) {
            return this.arD.get(1);
        }
        return gVar;
    }

    private void ec(int i) {
        if (i <= 8 && i > 0) {
            this.arE = true;
            if (this.arG != null) {
                o oVar = this.arG.get(i);
                if (!StringUtils.isNull(oVar.yf()) && oVar.yg() != null && oVar.yg().size() > 0) {
                    h(oVar.yf(), oVar.yg());
                    return;
                }
            }
            if (this.arF != null) {
                String str = this.arF.get(i);
                if (!au.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void j(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(g gVar, int i) {
        if (gVar != null && gVar.extData != null) {
            if (gVar.arN) {
                TiebaStatic.log(new as("c10125").Z("fid", gVar.extData).s("obj_type", i));
            } else if (gVar.arO) {
                TiebaStatic.log(new as("c10125").Z("tid", gVar.extData).s("obj_type", i));
            } else if (gVar.arP) {
                TiebaStatic.log(new as("c10427").Z("tid", gVar.extData).s("obj_type", i));
            } else if (gVar.arM) {
                j(i, gVar.arS);
            } else if (gVar.arQ) {
                TiebaStatic.log(new as("c10125").s("obj_param1", 7).s("obj_type", i).Z("fid", gVar.extData));
            }
        }
    }

    private void AJ() {
        int size = this.arB.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.arB.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), w.e.cp_cont_j);
        }
        int paddingLeft = this.aru.getPaddingLeft();
        aq.j(this.arv, w.e.common_color_10010);
        aq.j(this.aru, w.g.bg_unite_popup_share_up);
        aq.c(this.aru, w.e.common_color_10039, 1);
        aq.c(this.arw, w.e.cp_cont_f, 1);
        aq.j(this.arw, w.g.dialog_single_button_bg_selector);
        aq.j(this.ary, w.e.cp_bg_line_a);
        this.aru.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = aq.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        aq.c(textView, i2, 1);
    }

    private String b(g gVar) {
        String str = "【" + gVar.title + "】 " + gVar.content;
        gVar.content = str;
        return str;
    }
}
