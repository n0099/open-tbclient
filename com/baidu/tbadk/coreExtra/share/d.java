package com.baidu.tbadk.coreExtra.share;

import android.annotation.SuppressLint;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String auW = "";
    private AlertDialog abL;
    private final TextView auJ;
    private final View auK;
    private final TextView auL;
    private TextView auM;
    private final View auN;
    private final LinearLayout auO;
    private final LinearLayout auP;
    private final List<View> auQ;
    private View.OnClickListener auR;
    private final SparseArray<e> auS;
    private boolean auT;
    private SparseArray<String> auU;
    private SparseArray<o> auV;
    private boolean auX;
    private com.baidu.tbadk.coreExtra.share.a auY;
    private boolean isSupportNightMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private final View mLine2;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.auS = new SparseArray<>(8);
        this.auT = false;
        this.auX = true;
        this.mIsLandscape = false;
        this.isSupportNightMode = true;
        this.auY = new com.baidu.tbadk.coreExtra.share.a() { // from class: com.baidu.tbadk.coreExtra.share.d.2
            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AS() {
                k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.auth_account_success);
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AT() {
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AU() {
                k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.share_success);
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AV() {
            }
        };
        this.mContext = context;
        this.mIsLandscape = z;
        this.auQ = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_dialog_content, (ViewGroup) null);
        this.auJ = (TextView) this.mRootView.findViewById(d.h.share_dialog_title);
        this.auK = this.mRootView.findViewById(d.h.share_dialog_content);
        this.auN = this.mRootView.findViewById(d.h.line);
        this.mLine2 = this.mRootView.findViewById(d.h.line_2);
        this.auL = (TextView) this.mRootView.findViewById(d.h.btnShareCancel);
        this.auL.setOnClickListener(this);
        H(d.l.share_weixin, d.g.icon_weixin);
        H(d.l.share_weixin_timeline, d.g.icon_weixin_q);
        H(d.l.share_qzone, d.g.icon_qq_zone);
        H(d.l.share_qq_friends, d.g.icon_qq_share);
        H(d.l.share_sina_weibo, d.g.icon_sina);
        this.auO = (LinearLayout) this.mRootView.findViewById(d.h.share_dialog_line_1);
        this.auP = (LinearLayout) this.mRootView.findViewById(d.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.auO.setVisibility(8);
            this.auP.setVisibility(8);
        }
    }

    public d(Context context) {
        this(context, false);
    }

    private void AW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tbadk.coreExtra.share.d.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.abL != null && d.this.abL.isShowing()) {
                    d.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void setIsSupportNightMode(boolean z) {
        this.isSupportNightMode = z;
    }

    private TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AX());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.auQ.add(textView);
        return textView;
    }

    public TextView I(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AX());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams AX() {
        if (!this.mIsLandscape) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    public int AY() {
        if (this.auQ == null) {
            return 0;
        }
        return this.auQ.size();
    }

    public void a(View view, View.OnClickListener onClickListener) {
        this.auQ.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.auQ.size() && i >= 0) {
            this.auQ.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener ava;

        public a(View.OnClickListener onClickListener) {
            this.ava = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.ava != null) {
                this.ava.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.auX = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.auY = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.auU = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            eVar.location = location;
        }
        this.auS.put(1, eVar);
        this.auJ.setVisibility(eVar.avg ? 0 : 8);
        if (!StringUtils.isNull(eVar.avh)) {
            this.auJ.setText(eVar.avh);
        }
    }

    public void a(int i, e eVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            eVar.location = location;
        }
        this.auS.put(i, eVar);
    }

    private Location getLocation() {
        if (aa.aD(this.mContext)) {
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
            this.auR = onClickListener;
        }
    }

    public void AZ() {
        if (this.auX) {
            this.auM = H(d.l.share_copy, d.g.icon_copy_link);
        }
        int size = this.auQ.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView I = I(d.l.share_weixin_timeline, d.g.icon_weixin_q);
                I.setVisibility(4);
                this.auQ.add(I);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.auO.addView(this.auQ.get(i2));
                } else {
                    this.auP.addView(this.auQ.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.auO.addView(this.auQ.get(i3));
            }
        }
    }

    public void show() {
        if (!i.hr()) {
            k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.plugin_share_install_failure);
        } else {
            AZ();
            this.abL = new AlertDialog.Builder(this.mContext).create();
            this.abL.setCanceledOnTouchOutside(true);
            this.abL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.coreExtra.share.d.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (d.this.mOnDismissListener != null) {
                        d.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.abL, (Activity) this.mContext);
            }
            Window window = this.abL.getWindow();
            window.setWindowAnimations(d.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.auY);
            window.setContentView(this.mRootView);
            Ba();
            AW();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.abL != null) {
            this.auT = false;
            if (this.mContext instanceof Activity) {
                g.b(this.abL, (Activity) this.mContext);
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
        if (this.auS.size() != 0) {
            if (view.getId() == d.h.btnShareCancel || !this.auT) {
                this.auT = true;
                f fVar = new f(this.mContext, this.auY);
                e ej = ej(1);
                if (id == d.h.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    this.auY.AT();
                }
                if (i == d.g.icon_weixin) {
                    l("share_to_weixin", new Object[0]);
                    ek(3);
                    e ej2 = ej(3);
                    a(ej2, 4);
                    if (ej2 != null) {
                        if (ej2.imageUri != null) {
                            auW = ej2.imageUri.toString();
                        }
                        fVar.c(ej2);
                    }
                } else if (i == d.g.icon_weixin_q) {
                    l("share_to_pyq", new Object[0]);
                    ek(2);
                    e ej3 = ej(2);
                    a(ej3, 3);
                    if (ej3 != null) {
                        if (ej3.avc) {
                            ej3.content = "【" + ej3.title + "】 " + ej3.content;
                        }
                        if (ej3.imageUri != null) {
                            auW = ej3.imageUri.toString();
                        }
                        fVar.d(ej3);
                    }
                } else if (i == d.g.icon_qq_zone) {
                    if (s.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        ek(4);
                        e ej4 = ej(4);
                        a(ej4, 5);
                        if (ej4 != null) {
                            fVar.f(ej4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(d.l.share_qq_not_install)).tz();
                } else if (i == d.g.icon_qq_weibo) {
                    l("share_to_qweibo", new Object[0]);
                    ek(5);
                    e ej5 = ej(5);
                    a(ej5, 6);
                    if (ej5 != null) {
                        if (!ej5.avb) {
                            ej5.content = b(ej5);
                        }
                        fVar.g(ej5);
                    }
                } else if (i == d.g.icon_sina) {
                    l("share_to_sweibo", new Object[0]);
                    ek(6);
                    e ej6 = ej(6);
                    a(ej6, 7);
                    if (ej6 != null) {
                        if (!ej6.avb) {
                            ej6.content = b(ej6);
                        }
                        fVar.h(ej6);
                    }
                } else if (i == d.g.icon_renren) {
                    l("share_to_renren", new Object[0]);
                    ek(7);
                    e ej7 = ej(7);
                    a(ej7, 8);
                    if (ej7 != null) {
                        if (!ej7.avb) {
                            ej7.content = b(ej7);
                        }
                        fVar.i(ej7);
                    }
                } else if (i == d.g.icon_qq_share) {
                    if (s.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        ek(8);
                        e ej8 = ej(8);
                        a(ej8, 9);
                        if (ej8 != null) {
                            fVar.e(ej8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(d.l.share_qq_not_install)).tz();
                } else if (i == d.g.icon_copy_link) {
                    a(ej, 10);
                    if (this.auR != null) {
                        this.auR.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aB(ej.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.l.copy_pb_url_success));
                    }
                    if (ej != null && ej.avb) {
                        k(8, ej.avj);
                    }
                }
            }
        }
    }

    private e ej(int i) {
        e eVar = this.auS.get(i);
        if (eVar == null) {
            return this.auS.get(1);
        }
        return eVar;
    }

    private void ek(int i) {
        if (i <= 8 && i > 0) {
            this.auT = true;
            if (this.auV != null) {
                o oVar = this.auV.get(i);
                if (!StringUtils.isNull(oVar.yu()) && oVar.yv() != null && oVar.yv().size() > 0) {
                    l(oVar.yu(), oVar.yv());
                    return;
                }
            }
            if (this.auU != null) {
                String str = this.auU.get(i);
                if (!al.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void k(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.avc) {
                TiebaStatic.log(new aj("c10125").aa("fid", eVar.extData).r("obj_type", i));
            } else if (eVar.avd) {
                TiebaStatic.log(new aj("c10125").aa("tid", eVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.avm).r("obj_param1", eVar.avn).aa("fid", eVar.fid));
            } else if (eVar.ave) {
                TiebaStatic.log(new aj("c10427").aa("tid", eVar.extData).r("obj_type", i));
            } else if (eVar.avb) {
                k(i, eVar.avj);
            } else if (eVar.avf) {
                TiebaStatic.log(new aj("c10125").r("obj_param1", 7).r("obj_type", i).aa("fid", eVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void Ba() {
        int skinType = !this.isSupportNightMode ? 0 : TbadkCoreApplication.getInst().getSkinType();
        int size = this.auQ.size();
        for (int i = 0; i < size; i++) {
            View view = this.auQ.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.e.cp_cont_j, skinType);
            }
        }
        ai.d(this.mRootView, d.e.common_color_10010, skinType);
        ai.b(this.auJ, d.e.cp_cont_d, 1, skinType);
        ai.b(this.auL, d.e.cp_cont_f, 1, skinType);
        ai.d(this.auL, d.g.dialog_single_button_bg_selector, skinType);
        ai.d(this.auN, d.e.cp_bg_line_a, skinType);
        ai.d(this.mLine2, d.e.cp_bg_line_a, skinType);
    }

    private void a(TextView textView, int i, int i2, int i3) {
        Drawable v = ai.v(i3, i);
        v.setBounds(0, 0, v.getIntrinsicWidth(), v.getIntrinsicHeight());
        textView.setCompoundDrawables(null, v, null, null);
        ai.b(textView, i2, 1, i3);
    }

    private String b(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }
}
