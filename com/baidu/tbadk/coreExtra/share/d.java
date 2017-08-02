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
    public static String atE = "";
    private AlertDialog aam;
    private final SparseArray<e> atA;
    private boolean atB;
    private SparseArray<String> atC;
    private SparseArray<o> atD;
    private boolean atF;
    private com.baidu.tbadk.coreExtra.share.a atG;
    private final TextView atq;
    private final View atr;
    private final TextView ats;
    private TextView att;
    private final View atu;
    private final LinearLayout atv;
    private final LinearLayout atw;
    private final List<View> atx;
    private View.OnClickListener aty;
    private DialogInterface.OnDismissListener atz;
    private final Context mContext;
    private boolean mIsLandscape;
    private final View mLine2;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.atA = new SparseArray<>(8);
        this.atB = false;
        this.atF = true;
        this.mIsLandscape = false;
        this.atG = new com.baidu.tbadk.coreExtra.share.a() { // from class: com.baidu.tbadk.coreExtra.share.d.2
            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AK() {
                k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.auth_account_success);
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AL() {
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AM() {
                k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.share_success);
            }

            @Override // com.baidu.tbadk.coreExtra.share.a
            public void AN() {
            }
        };
        this.mContext = context;
        this.mIsLandscape = z;
        this.atx = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_dialog_content, (ViewGroup) null);
        this.atq = (TextView) this.mRootView.findViewById(d.h.share_dialog_title);
        this.atr = this.mRootView.findViewById(d.h.share_dialog_content);
        this.atu = this.mRootView.findViewById(d.h.line);
        this.mLine2 = this.mRootView.findViewById(d.h.line_2);
        this.ats = (TextView) this.mRootView.findViewById(d.h.btnShareCancel);
        this.ats.setOnClickListener(this);
        G(d.l.share_weixin, d.g.icon_weixin);
        G(d.l.share_weixin_timeline, d.g.icon_weixin_q);
        G(d.l.share_qzone, d.g.icon_qq_zone);
        G(d.l.share_qq_friends, d.g.icon_qq_share);
        G(d.l.share_sina_weibo, d.g.icon_sina);
        this.atv = (LinearLayout) this.mRootView.findViewById(d.h.share_dialog_line_1);
        this.atw = (LinearLayout) this.mRootView.findViewById(d.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.atv.setVisibility(8);
            this.atw.setVisibility(8);
        }
    }

    public d(Context context) {
        this(context, false);
    }

    private void AO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tbadk.coreExtra.share.d.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.aam != null && d.this.aam.isShowing()) {
                    d.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView G(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AP());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.atx.add(textView);
        return textView;
    }

    public TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(AP());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams AP() {
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

    public int AQ() {
        if (this.atx == null) {
            return 0;
        }
        return this.atx.size();
    }

    public void a(View view, View.OnClickListener onClickListener) {
        this.atx.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.atx.size() && i >= 0) {
            this.atx.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener atI;

        public a(View.OnClickListener onClickListener) {
            this.atI = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.atI != null) {
                this.atI.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.atF = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.atG = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.atC = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            eVar.location = location;
        }
        this.atA.put(1, eVar);
        this.atq.setVisibility(eVar.atO ? 0 : 8);
        if (!StringUtils.isNull(eVar.atP)) {
            this.atq.setText(eVar.atP);
        }
    }

    public void a(int i, e eVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            eVar.location = location;
        }
        this.atA.put(i, eVar);
    }

    private Location getLocation() {
        if (aa.aC(this.mContext)) {
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
            this.aty = onClickListener;
        }
    }

    public void AR() {
        if (this.atF) {
            this.att = G(d.l.share_copy, d.g.icon_copy_link);
        }
        int size = this.atx.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView H = H(d.l.share_weixin_timeline, d.g.icon_weixin_q);
                H.setVisibility(4);
                this.atx.add(H);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.atv.addView(this.atx.get(i2));
                } else {
                    this.atw.addView(this.atx.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.atv.addView(this.atx.get(i3));
            }
        }
    }

    public void show() {
        if (!i.hh()) {
            k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.getInst().getContext(), d.l.plugin_share_install_failure);
        } else {
            AR();
            this.aam = new AlertDialog.Builder(this.mContext).create();
            this.aam.setCanceledOnTouchOutside(true);
            this.aam.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.coreExtra.share.d.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (d.this.atz != null) {
                        d.this.atz.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.aam, (Activity) this.mContext);
            }
            Window window = this.aam.getWindow();
            window.setWindowAnimations(d.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.atG);
            window.setContentView(this.mRootView);
            AS();
            AO();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.atz = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.aam != null) {
            this.atB = false;
            if (this.mContext instanceof Activity) {
                g.b(this.aam, (Activity) this.mContext);
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
        if (this.atA.size() != 0) {
            if (view.getId() == d.h.btnShareCancel || !this.atB) {
                this.atB = true;
                f fVar = new f(this.mContext, this.atG);
                e eh = eh(1);
                if (id == d.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.atG.AL();
                }
                if (i == d.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ei(3);
                    e eh2 = eh(3);
                    a(eh2, 4);
                    if (eh2 != null) {
                        if (eh2.imageUri != null) {
                            atE = eh2.imageUri.toString();
                        }
                        fVar.c(eh2);
                    }
                } else if (i == d.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ei(2);
                    e eh3 = eh(2);
                    a(eh3, 3);
                    if (eh3 != null) {
                        if (eh3.atK) {
                            eh3.content = "【" + eh3.title + "】 " + eh3.content;
                        }
                        if (eh3.imageUri != null) {
                            atE = eh3.imageUri.toString();
                        }
                        fVar.d(eh3);
                    }
                } else if (i == d.g.icon_qq_zone) {
                    if (s.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        ei(4);
                        e eh4 = eh(4);
                        a(eh4, 5);
                        if (eh4 != null) {
                            fVar.f(eh4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(d.l.share_qq_not_install)).tp();
                } else if (i == d.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ei(5);
                    e eh5 = eh(5);
                    a(eh5, 6);
                    if (eh5 != null) {
                        if (!eh5.atJ) {
                            eh5.content = b(eh5);
                        }
                        fVar.g(eh5);
                    }
                } else if (i == d.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ei(6);
                    e eh6 = eh(6);
                    a(eh6, 7);
                    if (eh6 != null) {
                        if (!eh6.atJ) {
                            eh6.content = b(eh6);
                        }
                        fVar.h(eh6);
                    }
                } else if (i == d.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ei(7);
                    e eh7 = eh(7);
                    a(eh7, 8);
                    if (eh7 != null) {
                        if (!eh7.atJ) {
                            eh7.content = b(eh7);
                        }
                        fVar.i(eh7);
                    }
                } else if (i == d.g.icon_qq_share) {
                    if (s.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        ei(8);
                        e eh8 = eh(8);
                        a(eh8, 9);
                        if (eh8 != null) {
                            fVar.e(eh8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(d.l.share_qq_not_install)).tp();
                } else if (i == d.g.icon_copy_link) {
                    a(eh, 10);
                    if (this.aty != null) {
                        this.aty.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.av(eh.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.l.copy_pb_url_success));
                    }
                    if (eh != null && eh.atJ) {
                        k(8, eh.atR);
                    }
                }
            }
        }
    }

    private e eh(int i) {
        e eVar = this.atA.get(i);
        if (eVar == null) {
            return this.atA.get(1);
        }
        return eVar;
    }

    private void ei(int i) {
        if (i <= 8 && i > 0) {
            this.atB = true;
            if (this.atD != null) {
                o oVar = this.atD.get(i);
                if (!StringUtils.isNull(oVar.ym()) && oVar.yn() != null && oVar.yn().size() > 0) {
                    h(oVar.ym(), oVar.yn());
                    return;
                }
            }
            if (this.atC != null) {
                String str = this.atC.get(i);
                if (!al.isEmpty(str)) {
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

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.atK) {
                TiebaStatic.log(new aj("c10125").aa("fid", eVar.extData).r("obj_type", i));
            } else if (eVar.atL) {
                TiebaStatic.log(new aj("c10125").aa("tid", eVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.atU).r("obj_param1", eVar.atV).aa("fid", eVar.fid));
            } else if (eVar.atM) {
                TiebaStatic.log(new aj("c10427").aa("tid", eVar.extData).r("obj_type", i));
            } else if (eVar.atJ) {
                k(i, eVar.atR);
            } else if (eVar.atN) {
                TiebaStatic.log(new aj("c10125").r("obj_param1", 7).r("obj_type", i).aa("fid", eVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void AS() {
        int size = this.atx.size();
        for (int i = 0; i < size; i++) {
            View view = this.atx.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.e.cp_cont_j);
            }
        }
        ai.j(this.mRootView, d.e.common_color_10010);
        ai.c(this.atq, d.e.cp_cont_d, 1);
        ai.c(this.ats, d.e.cp_cont_f, 1);
        ai.j(this.ats, d.g.dialog_single_button_bg_selector);
        ai.j(this.atu, d.e.cp_bg_line_a);
        ai.j(this.mLine2, d.e.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ai.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ai.c(textView, i2, 1);
    }

    private String b(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }
}
