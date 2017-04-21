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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
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
    public static String arY = "";
    private AlertDialog aas;
    private final TextView arK;
    private final View arL;
    private final TextView arM;
    private TextView arN;
    private final View arO;
    private final LinearLayout arP;
    private final LinearLayout arQ;
    private final List<TextView> arR;
    private View.OnClickListener arS;
    private DialogInterface.OnDismissListener arT;
    private final SparseArray<h> arU;
    private boolean arV;
    private SparseArray<String> arW;
    private SparseArray<o> arX;
    private boolean arZ;
    private boolean asa;
    private com.baidu.tbadk.coreExtra.share.a asb;
    private final Context mContext;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.arU = new SparseArray<>(8);
        this.arV = false;
        this.arZ = true;
        this.asa = false;
        this.asb = new e(this);
        this.mContext = context;
        this.asa = z;
        this.arR = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
        this.arK = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
        this.arL = this.mRootView.findViewById(w.h.share_dialog_content);
        this.arO = this.mRootView.findViewById(w.h.line);
        this.arM = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);
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

    public d(Context context) {
        this(context, false);
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
        if (this.asa) {
            int g = k.g(this.mContext, w.f.ds54);
            textView.setPadding(g, 0, g, 0);
        }
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
        if (!this.asa) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        return layoutParams2;
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
        private View.OnClickListener asd;

        public a(View.OnClickListener onClickListener) {
            this.asd = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.asd != null) {
                this.asd.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.arZ = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.asb = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.arW = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arU.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arU.put(i, hVar);
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
        if (this.arZ) {
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
        if (!this.asa) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.arP.addView(this.arR.get(i2));
                } else {
                    this.arQ.addView(this.arR.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 5) {
                this.arP.addView(this.arR.get(i3));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            Bh();
            this.aas = new AlertDialog.Builder(this.mContext).create();
            this.aas.setCanceledOnTouchOutside(true);
            this.aas.setOnDismissListener(new g(this));
            if (this.mContext instanceof Activity) {
                j.a(this.aas, (Activity) this.mContext);
            }
            Window window = this.aas.getWindow();
            window.setWindowAnimations(w.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.asb);
            window.setContentView(this.mRootView);
            Bi();
            Be();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.arT = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.aas != null) {
            this.arV = false;
            if (this.mContext instanceof Activity) {
                j.b(this.aas, (Activity) this.mContext);
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
        if (this.arU.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.arV) {
                this.arV = true;
                i iVar = new i(this.mContext, this.asb);
                h ee = ee(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.asb.Bb();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ef(3);
                    h ee2 = ee(3);
                    a(ee2, 4);
                    if (ee2 != null) {
                        if (ee2.imageUri != null) {
                            arY = ee2.imageUri.toString();
                        }
                        iVar.c(ee2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ef(2);
                    h ee3 = ee(2);
                    a(ee3, 3);
                    if (ee3 != null) {
                        if (ee3.asf) {
                            ee3.content = "【" + ee3.title + "】 " + ee3.content;
                        }
                        if (ee3.imageUri != null) {
                            arY = ee3.imageUri.toString();
                        }
                        iVar.d(ee3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        ef(4);
                        h ee4 = ee(4);
                        a(ee4, 5);
                        if (ee4 != null) {
                            iVar.f(ee4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tY();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ef(5);
                    h ee5 = ee(5);
                    a(ee5, 6);
                    if (ee5 != null) {
                        if (!ee5.ase) {
                            ee5.content = b(ee5);
                        }
                        iVar.g(ee5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ef(6);
                    h ee6 = ee(6);
                    a(ee6, 7);
                    if (ee6 != null) {
                        if (!ee6.ase) {
                            ee6.content = b(ee6);
                        }
                        iVar.h(ee6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ef(7);
                    h ee7 = ee(7);
                    a(ee7, 8);
                    if (ee7 != null) {
                        if (!ee7.ase) {
                            ee7.content = b(ee7);
                        }
                        iVar.i(ee7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (com.baidu.tieba.tbadkCore.ae.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        ef(8);
                        h ee8 = ee(8);
                        a(ee8, 9);
                        if (ee8 != null) {
                            iVar.e(ee8);
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
                    if (ee != null && ee.ase) {
                        j(8, ee.ask);
                    }
                }
            }
        }
    }

    private h ee(int i) {
        h hVar = this.arU.get(i);
        if (hVar == null) {
            return this.arU.get(1);
        }
        return hVar;
    }

    private void ef(int i) {
        if (i <= 8 && i > 0) {
            this.arV = true;
            if (this.arX != null) {
                o oVar = this.arX.get(i);
                if (!StringUtils.isNull(oVar.yD()) && oVar.yE() != null && oVar.yE().size() > 0) {
                    h(oVar.yD(), oVar.yE());
                    return;
                }
            }
            if (this.arW != null) {
                String str = this.arW.get(i);
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

    private void a(h hVar, int i) {
        if (hVar != null && hVar.extData != null) {
            if (hVar.asf) {
                TiebaStatic.log(new as("c10125").aa("fid", hVar.extData).s("obj_type", i));
            } else if (hVar.asg) {
                TiebaStatic.log(new as("c10125").aa("tid", hVar.extData).s("obj_type", i));
            } else if (hVar.ash) {
                TiebaStatic.log(new as("c10427").aa("tid", hVar.extData).s("obj_type", i));
            } else if (hVar.ase) {
                j(i, hVar.ask);
            } else if (hVar.asi) {
                TiebaStatic.log(new as("c10125").s("obj_param1", 7).s("obj_type", i).aa("fid", hVar.extData));
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

    private String b(h hVar) {
        String str = "【" + hVar.title + "】 " + hVar.content;
        hVar.content = str;
        return str;
    }
}
