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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
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
    public static String arX = "";
    private AlertDialog aar;
    private TextView arN;
    private final LinearLayout arP;
    private final LinearLayout arQ;
    private View.OnClickListener arS;
    private SparseArray<String> arV;
    private SparseArray<o> arW;
    private final Context mContext;
    private final SparseArray<g> arT = new SparseArray<>(8);
    private boolean arU = false;
    private boolean arY = true;
    private com.baidu.tbadk.coreExtra.share.a arZ = new e(this);
    private final List<TextView> arR = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
    private final TextView arK = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
    private final View arL = this.mRootView.findViewById(w.h.share_dialog_content);
    private final View arO = this.mRootView.findViewById(w.h.line);
    private final TextView arM = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.arM.setOnClickListener(this);
        H(w.l.share_weixin, w.g.icon_weixin);
        H(w.l.share_weixin_timeline, w.g.icon_weixin_q);
        H(w.l.share_qzone, w.g.icon_qq_zone);
        H(w.l.share_qq_friends, w.g.icon_qq_share);
        H(w.l.share_sina_weibo, w.g.icon_sina);
        this.arP = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_1);
        this.arQ = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.arP.setVisibility(8);
            this.arQ.setVisibility(8);
        }
    }

    private void Be() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Bf());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.arR.add(textView);
        return textView;
    }

    public TextView I(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Bf());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Bf() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public int Bg() {
        if (this.arR == null) {
            return 0;
        }
        return this.arR.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.arR.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.arR.size() && i >= 0) {
            this.arR.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener asb;

        public a(View.OnClickListener onClickListener) {
            this.asb = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.asb != null) {
                this.asb.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.arY = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.arZ = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.arV = sparseArray;
    }

    public void a(g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.arT.put(1, gVar);
    }

    public void a(int i, g gVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            gVar.location = location;
        }
        this.arT.put(i, gVar);
    }

    private Location getLocation() {
        if (ae.az(this.mContext)) {
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
            this.arS = onClickListener;
        }
    }

    public void Bh() {
        if (this.arY) {
            this.arN = H(w.l.share_copy, w.g.icon_copy_link);
        }
        int size = this.arR.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView I = I(w.l.share_weixin_timeline, w.g.icon_weixin_q);
                I.setVisibility(4);
                this.arR.add(I);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.arP.addView(this.arR.get(i2));
            } else {
                this.arQ.addView(this.arR.get(i2));
            }
        }
    }

    public void show() {
        if (!i.hj()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            Bh();
            this.aar = new AlertDialog.Builder(this.mContext).create();
            this.aar.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.aar, (Activity) this.mContext);
            }
            Window window = this.aar.getWindow();
            window.setWindowAnimations(w.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.arZ);
            window.setContentView(this.mRootView);
            Bi();
            Be();
        }
    }

    public void dismiss() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
        if (this.aar != null) {
            this.arU = false;
            if (this.mContext instanceof Activity) {
                j.b(this.aar, (Activity) this.mContext);
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
        if (this.arT.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.arU) {
                this.arU = true;
                h hVar = new h(this.mContext, this.arZ);
                g ee = ee(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.arZ.Bb();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ef(3);
                    g ee2 = ee(3);
                    a(ee2, 4);
                    if (ee2 != null) {
                        if (ee2.imageUri != null) {
                            arX = ee2.imageUri.toString();
                        }
                        hVar.c(ee2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ef(2);
                    g ee3 = ee(2);
                    a(ee3, 3);
                    if (ee3 != null) {
                        if (ee3.asd) {
                            ee3.content = "【" + ee3.title + "】 " + ee3.content;
                        }
                        if (ee3.imageUri != null) {
                            arX = ee3.imageUri.toString();
                        }
                        hVar.d(ee3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        ef(4);
                        g ee4 = ee(4);
                        a(ee4, 5);
                        if (ee4 != null) {
                            hVar.f(ee4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tY();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ef(5);
                    g ee5 = ee(5);
                    a(ee5, 6);
                    if (ee5 != null) {
                        if (!ee5.asc) {
                            ee5.content = b(ee5);
                        }
                        hVar.g(ee5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ef(6);
                    g ee6 = ee(6);
                    a(ee6, 7);
                    if (ee6 != null) {
                        if (!ee6.asc) {
                            ee6.content = b(ee6);
                        }
                        hVar.h(ee6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ef(7);
                    g ee7 = ee(7);
                    a(ee7, 8);
                    if (ee7 != null) {
                        if (!ee7.asc) {
                            ee7.content = b(ee7);
                        }
                        hVar.i(ee7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        ef(8);
                        g ee8 = ee(8);
                        a(ee8, 9);
                        if (ee8 != null) {
                            hVar.e(ee8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tY();
                } else if (i == w.g.icon_copy_link) {
                    a(ee, 10);
                    if (this.arS != null) {
                        this.arS.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.ao(ee.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(w.l.copy_pb_url_success));
                    }
                    if (ee != null && ee.asc) {
                        j(8, ee.asi);
                    }
                }
            }
        }
    }

    private g ee(int i) {
        g gVar = this.arT.get(i);
        if (gVar == null) {
            return this.arT.get(1);
        }
        return gVar;
    }

    private void ef(int i) {
        if (i <= 8 && i > 0) {
            this.arU = true;
            if (this.arW != null) {
                o oVar = this.arW.get(i);
                if (!StringUtils.isNull(oVar.yD()) && oVar.yE() != null && oVar.yE().size() > 0) {
                    h(oVar.yD(), oVar.yE());
                    return;
                }
            }
            if (this.arV != null) {
                String str = this.arV.get(i);
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
            if (gVar.asd) {
                TiebaStatic.log(new as("c10125").aa("fid", gVar.extData).s("obj_type", i));
            } else if (gVar.ase) {
                TiebaStatic.log(new as("c10125").aa("tid", gVar.extData).s("obj_type", i));
            } else if (gVar.asf) {
                TiebaStatic.log(new as("c10427").aa("tid", gVar.extData).s("obj_type", i));
            } else if (gVar.asc) {
                j(i, gVar.asi);
            } else if (gVar.asg) {
                TiebaStatic.log(new as("c10125").s("obj_param1", 7).s("obj_type", i).aa("fid", gVar.extData));
            }
        }
    }

    private void Bi() {
        int size = this.arR.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.arR.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), w.e.cp_cont_j);
        }
        int paddingLeft = this.arK.getPaddingLeft();
        aq.j(this.arL, w.e.common_color_10010);
        aq.j(this.arK, w.g.bg_unite_popup_share_up);
        aq.c(this.arK, w.e.common_color_10039, 1);
        aq.c(this.arM, w.e.cp_cont_f, 1);
        aq.j(this.arM, w.g.dialog_single_button_bg_selector);
        aq.j(this.arO, w.e.cp_bg_line_a);
        this.arK.setPadding(paddingLeft, 0, 0, 0);
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
