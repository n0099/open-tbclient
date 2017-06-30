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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String asN = "";
    private AlertDialog ZN;
    private final View asA;
    private final TextView asB;
    private TextView asC;
    private final View asD;
    private final LinearLayout asE;
    private final LinearLayout asF;
    private final List<TextView> asG;
    private View.OnClickListener asH;
    private DialogInterface.OnDismissListener asI;
    private final SparseArray<h> asJ;
    private boolean asK;
    private SparseArray<String> asL;
    private SparseArray<o> asM;
    private boolean asO;
    private com.baidu.tbadk.coreExtra.share.a asP;
    private final TextView asz;
    private final Context mContext;
    private boolean mIsLandscape;
    private final View mLine2;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.asJ = new SparseArray<>(8);
        this.asK = false;
        this.asO = true;
        this.mIsLandscape = false;
        this.asP = new e(this);
        this.mContext = context;
        this.mIsLandscape = z;
        this.asG = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
        this.asz = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
        this.asA = this.mRootView.findViewById(w.h.share_dialog_content);
        this.asD = this.mRootView.findViewById(w.h.line);
        this.mLine2 = this.mRootView.findViewById(w.h.line_2);
        this.asB = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);
        this.asB.setOnClickListener(this);
        G(w.l.share_weixin, w.g.icon_weixin);
        G(w.l.share_weixin_timeline, w.g.icon_weixin_q);
        G(w.l.share_qzone, w.g.icon_qq_zone);
        G(w.l.share_qq_friends, w.g.icon_qq_share);
        G(w.l.share_sina_weibo, w.g.icon_sina);
        this.asE = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_1);
        this.asF = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.asE.setVisibility(8);
            this.asF.setVisibility(8);
        }
    }

    public d(Context context) {
        this(context, false);
    }

    private void AD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView G(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AE());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        if (this.mIsLandscape) {
            int g = k.g(this.mContext, w.f.ds54);
            textView.setPadding(g, 0, g, 0);
        }
        this.asG.add(textView);
        return textView;
    }

    public TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AE());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams AE() {
        if (!this.mIsLandscape) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    public int AF() {
        if (this.asG == null) {
            return 0;
        }
        return this.asG.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.asG.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.asG.size() && i >= 0) {
            this.asG.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener asR;

        public a(View.OnClickListener onClickListener) {
            this.asR = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.asR != null) {
                this.asR.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.asO = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.asP = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.asL = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.asJ.put(1, hVar);
        this.asz.setVisibility(hVar.asX ? 0 : 8);
    }

    public void a(int i, h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.asJ.put(i, hVar);
    }

    private Location getLocation() {
        if (ag.aC(this.mContext)) {
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
            this.asH = onClickListener;
        }
    }

    public void AG() {
        if (this.asO) {
            this.asC = G(w.l.share_copy, w.g.icon_copy_link);
        }
        int size = this.asG.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView H = H(w.l.share_weixin_timeline, w.g.icon_weixin_q);
                H.setVisibility(4);
                this.asG.add(H);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.asE.addView(this.asG.get(i2));
                } else {
                    this.asF.addView(this.asG.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 5) {
                this.asE.addView(this.asG.get(i3));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            AG();
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
            a(this.asP);
            window.setContentView(this.mRootView);
            AH();
            AD();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.asI = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.ZN != null) {
            this.asK = false;
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
        if (this.asJ.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.asK) {
                this.asK = true;
                i iVar = new i(this.mContext, this.asP);
                h ef = ef(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.asP.AA();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    eg(3);
                    h ef2 = ef(3);
                    a(ef2, 4);
                    if (ef2 != null) {
                        if (ef2.imageUri != null) {
                            asN = ef2.imageUri.toString();
                        }
                        iVar.c(ef2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    eg(2);
                    h ef3 = ef(2);
                    a(ef3, 3);
                    if (ef3 != null) {
                        if (ef3.asT) {
                            ef3.content = "【" + ef3.title + "】 " + ef3.content;
                        }
                        if (ef3.imageUri != null) {
                            asN = ef3.imageUri.toString();
                        }
                        iVar.d(ef3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        eg(4);
                        h ef4 = ef(4);
                        a(ef4, 5);
                        if (ef4 != null) {
                            iVar.f(ef4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).ti();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    eg(5);
                    h ef5 = ef(5);
                    a(ef5, 6);
                    if (ef5 != null) {
                        if (!ef5.asS) {
                            ef5.content = b(ef5);
                        }
                        iVar.g(ef5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    eg(6);
                    h ef6 = ef(6);
                    a(ef6, 7);
                    if (ef6 != null) {
                        if (!ef6.asS) {
                            ef6.content = b(ef6);
                        }
                        iVar.h(ef6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    eg(7);
                    h ef7 = ef(7);
                    a(ef7, 8);
                    if (ef7 != null) {
                        if (!ef7.asS) {
                            ef7.content = b(ef7);
                        }
                        iVar.i(ef7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        eg(8);
                        h ef8 = ef(8);
                        a(ef8, 9);
                        if (ef8 != null) {
                            iVar.e(ef8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).ti();
                } else if (i == w.g.icon_copy_link) {
                    a(ef, 10);
                    if (this.asH != null) {
                        this.asH.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.at(ef.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(w.l.copy_pb_url_success));
                    }
                    if (ef != null && ef.asS) {
                        k(8, ef.asZ);
                    }
                }
            }
        }
    }

    private h ef(int i) {
        h hVar = this.asJ.get(i);
        if (hVar == null) {
            return this.asJ.get(1);
        }
        return hVar;
    }

    private void eg(int i) {
        if (i <= 8 && i > 0) {
            this.asK = true;
            if (this.asM != null) {
                o oVar = this.asM.get(i);
                if (!StringUtils.isNull(oVar.yb()) && oVar.yc() != null && oVar.yc().size() > 0) {
                    h(oVar.yb(), oVar.yc());
                    return;
                }
            }
            if (this.asL != null) {
                String str = this.asL.get(i);
                if (!aw.isEmpty(str)) {
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
            if (hVar.asT) {
                TiebaStatic.log(new au("c10125").Z("fid", hVar.extData).r("obj_type", i));
            } else if (hVar.asU) {
                TiebaStatic.log(new au("c10125").Z("tid", hVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, hVar.atc).r("obj_param1", hVar.atd).Z("fid", hVar.fid));
            } else if (hVar.asV) {
                TiebaStatic.log(new au("c10427").Z("tid", hVar.extData).r("obj_type", i));
            } else if (hVar.asS) {
                k(i, hVar.asZ);
            } else if (hVar.asW) {
                TiebaStatic.log(new au("c10125").r("obj_param1", 7).r("obj_type", i).Z("fid", hVar.extData));
            }
        }
    }

    private void AH() {
        int size = this.asG.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.asG.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), w.e.cp_cont_j);
        }
        as.j(this.mRootView, w.e.common_color_10010);
        as.c(this.asz, w.e.cp_cont_d, 1);
        as.c(this.asB, w.e.cp_cont_f, 1);
        as.j(this.asB, w.g.dialog_single_button_bg_selector);
        as.j(this.asD, w.e.cp_bg_line_a);
        as.j(this.mLine2, w.e.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = as.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        as.c(textView, i2, 1);
    }

    private String b(h hVar) {
        String str = "【" + hVar.title + "】 " + hVar.content;
        hVar.content = str;
        return str;
    }
}
