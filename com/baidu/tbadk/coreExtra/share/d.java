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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String asa = "";
    private AlertDialog ZN;
    private final TextView arM;
    private final View arN;
    private final TextView arO;
    private TextView arP;
    private final View arQ;
    private final LinearLayout arR;
    private final LinearLayout arS;
    private final List<TextView> arT;
    private View.OnClickListener arU;
    private DialogInterface.OnDismissListener arV;
    private final SparseArray<h> arW;
    private boolean arX;
    private SparseArray<String> arY;
    private SparseArray<o> arZ;
    private boolean asb;
    private boolean asc;
    private com.baidu.tbadk.coreExtra.share.a asd;
    private final Context mContext;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.arW = new SparseArray<>(8);
        this.arX = false;
        this.asb = true;
        this.asc = false;
        this.asd = new e(this);
        this.mContext = context;
        this.asc = z;
        this.arT = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
        this.arM = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
        this.arN = this.mRootView.findViewById(w.h.share_dialog_content);
        this.arQ = this.mRootView.findViewById(w.h.line);
        this.arO = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);
        this.arO.setOnClickListener(this);
        H(w.l.share_weixin, w.g.icon_weixin);
        H(w.l.share_weixin_timeline, w.g.icon_weixin_q);
        H(w.l.share_qzone, w.g.icon_qq_zone);
        H(w.l.share_qq_friends, w.g.icon_qq_share);
        H(w.l.share_sina_weibo, w.g.icon_sina);
        this.arR = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_1);
        this.arS = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.arR.setVisibility(8);
            this.arS.setVisibility(8);
        }
    }

    public d(Context context) {
        this(context, false);
    }

    private void Ap() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aq());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        if (this.asc) {
            int g = k.g(this.mContext, w.f.ds54);
            textView.setPadding(g, 0, g, 0);
        }
        this.arT.add(textView);
        return textView;
    }

    public TextView I(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aq());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Aq() {
        if (!this.asc) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    public int Ar() {
        if (this.arT == null) {
            return 0;
        }
        return this.arT.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.arT.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.arT.size() && i >= 0) {
            this.arT.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener asf;

        public a(View.OnClickListener onClickListener) {
            this.asf = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.asf != null) {
                this.asf.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.asb = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.asd = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.arY = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arW.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arW.put(i, hVar);
    }

    private Location getLocation() {
        if (ae.aC(this.mContext)) {
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
            this.arU = onClickListener;
        }
    }

    public void As() {
        if (this.asb) {
            this.arP = H(w.l.share_copy, w.g.icon_copy_link);
        }
        int size = this.arT.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView I = I(w.l.share_weixin_timeline, w.g.icon_weixin_q);
                I.setVisibility(4);
                this.arT.add(I);
            }
        }
        if (!this.asc) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.arR.addView(this.arT.get(i2));
                } else {
                    this.arS.addView(this.arT.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 5) {
                this.arR.addView(this.arT.get(i3));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            As();
            this.ZN = new AlertDialog.Builder(this.mContext).create();
            this.ZN.setCanceledOnTouchOutside(true);
            this.ZN.setOnDismissListener(new g(this));
            if (this.mContext instanceof Activity) {
                j.a(this.ZN, (Activity) this.mContext);
            }
            Window window = this.ZN.getWindow();
            window.setWindowAnimations(w.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.asd);
            window.setContentView(this.mRootView);
            At();
            Ap();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.arV = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.ZN != null) {
            this.arX = false;
            if (this.mContext instanceof Activity) {
                j.b(this.ZN, (Activity) this.mContext);
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
        if (this.arW.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.arX) {
                this.arX = true;
                i iVar = new i(this.mContext, this.asd);
                h ec = ec(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.asd.Am();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ed(3);
                    h ec2 = ec(3);
                    a(ec2, 4);
                    if (ec2 != null) {
                        if (ec2.imageUri != null) {
                            asa = ec2.imageUri.toString();
                        }
                        iVar.c(ec2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ed(2);
                    h ec3 = ec(2);
                    a(ec3, 3);
                    if (ec3 != null) {
                        if (ec3.ash) {
                            ec3.content = "【" + ec3.title + "】 " + ec3.content;
                        }
                        if (ec3.imageUri != null) {
                            asa = ec3.imageUri.toString();
                        }
                        iVar.d(ec3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        ed(4);
                        h ec4 = ec(4);
                        a(ec4, 5);
                        if (ec4 != null) {
                            iVar.f(ec4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tl();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ed(5);
                    h ec5 = ec(5);
                    a(ec5, 6);
                    if (ec5 != null) {
                        if (!ec5.asg) {
                            ec5.content = b(ec5);
                        }
                        iVar.g(ec5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ed(6);
                    h ec6 = ec(6);
                    a(ec6, 7);
                    if (ec6 != null) {
                        if (!ec6.asg) {
                            ec6.content = b(ec6);
                        }
                        iVar.h(ec6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ed(7);
                    h ec7 = ec(7);
                    a(ec7, 8);
                    if (ec7 != null) {
                        if (!ec7.asg) {
                            ec7.content = b(ec7);
                        }
                        iVar.i(ec7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        ed(8);
                        h ec8 = ec(8);
                        a(ec8, 9);
                        if (ec8 != null) {
                            iVar.e(ec8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tl();
                } else if (i == w.g.icon_copy_link) {
                    a(ec, 10);
                    if (this.arU != null) {
                        this.arU.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.ao(ec.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(w.l.copy_pb_url_success));
                    }
                    if (ec != null && ec.asg) {
                        k(8, ec.asm);
                    }
                }
            }
        }
    }

    private h ec(int i) {
        h hVar = this.arW.get(i);
        if (hVar == null) {
            return this.arW.get(1);
        }
        return hVar;
    }

    private void ed(int i) {
        if (i <= 8 && i > 0) {
            this.arX = true;
            if (this.arZ != null) {
                o oVar = this.arZ.get(i);
                if (!StringUtils.isNull(oVar.xR()) && oVar.xS() != null && oVar.xS().size() > 0) {
                    h(oVar.xR(), oVar.xS());
                    return;
                }
            }
            if (this.arY != null) {
                String str = this.arY.get(i);
                if (!au.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void k(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(h hVar, int i) {
        if (hVar != null && hVar.extData != null) {
            if (hVar.ash) {
                TiebaStatic.log(new as("c10125").aa("fid", hVar.extData).s("obj_type", i));
            } else if (hVar.asi) {
                TiebaStatic.log(new as("c10125").aa("tid", hVar.extData).s("obj_type", i).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, hVar.asp).s("obj_param1", hVar.asq));
            } else if (hVar.asj) {
                TiebaStatic.log(new as("c10427").aa("tid", hVar.extData).s("obj_type", i));
            } else if (hVar.asg) {
                k(i, hVar.asm);
            } else if (hVar.ask) {
                TiebaStatic.log(new as("c10125").s("obj_param1", 7).s("obj_type", i).aa("fid", hVar.extData));
            }
        }
    }

    private void At() {
        int size = this.arT.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.arT.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), w.e.cp_cont_j);
        }
        int paddingLeft = this.arM.getPaddingLeft();
        aq.j(this.arN, w.e.common_color_10010);
        aq.j(this.arM, w.g.bg_unite_popup_share_up);
        aq.c(this.arM, w.e.common_color_10039, 1);
        aq.c(this.arO, w.e.cp_cont_f, 1);
        aq.j(this.arO, w.g.dialog_single_button_bg_selector);
        aq.j(this.arQ, w.e.cp_bg_line_a);
        this.arM.setPadding(paddingLeft, 0, 0, 0);
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
