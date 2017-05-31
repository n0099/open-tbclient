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
    public static String arK = "";
    private AlertDialog ZM;
    private final View arA;
    private final LinearLayout arB;
    private final LinearLayout arC;
    private final List<TextView> arD;
    private View.OnClickListener arE;
    private DialogInterface.OnDismissListener arF;
    private final SparseArray<h> arG;
    private boolean arH;
    private SparseArray<String> arI;
    private SparseArray<o> arJ;
    private boolean arL;
    private boolean arM;
    private com.baidu.tbadk.coreExtra.share.a arN;
    private final TextView arw;
    private final View arx;
    private final TextView ary;
    private TextView arz;
    private final Context mContext;
    private final View mRootView;

    public d(Context context, boolean z) {
        this.arG = new SparseArray<>(8);
        this.arH = false;
        this.arL = true;
        this.arM = false;
        this.arN = new e(this);
        this.mContext = context;
        this.arM = z;
        this.arD = new ArrayList();
        this.mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_dialog_content, (ViewGroup) null);
        this.arw = (TextView) this.mRootView.findViewById(w.h.share_dialog_title);
        this.arx = this.mRootView.findViewById(w.h.share_dialog_content);
        this.arA = this.mRootView.findViewById(w.h.line);
        this.ary = (TextView) this.mRootView.findViewById(w.h.btnShareCancel);
        this.ary.setOnClickListener(this);
        G(w.l.share_weixin, w.g.icon_weixin);
        G(w.l.share_weixin_timeline, w.g.icon_weixin_q);
        G(w.l.share_qzone, w.g.icon_qq_zone);
        G(w.l.share_qq_friends, w.g.icon_qq_share);
        G(w.l.share_sina_weibo, w.g.icon_sina);
        this.arB = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_1);
        this.arC = (LinearLayout) this.mRootView.findViewById(w.h.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.arB.setVisibility(8);
            this.arC.setVisibility(8);
        }
    }

    public d(Context context) {
        this(context, false);
    }

    private void Ai() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView G(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aj());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        if (this.arM) {
            int g = k.g(this.mContext, w.f.ds54);
            textView.setPadding(g, 0, g, 0);
        }
        this.arD.add(textView);
        return textView;
    }

    public TextView H(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(Aj());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams Aj() {
        if (!this.arM) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    public int Ak() {
        if (this.arD == null) {
            return 0;
        }
        return this.arD.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.arD.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.arD.size() && i >= 0) {
            this.arD.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener arP;

        public a(View.OnClickListener onClickListener) {
            this.arP = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.arP != null) {
                this.arP.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.arL = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.arN = aVar;
        }
    }

    public void b(SparseArray<String> sparseArray) {
        this.arI = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arG.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            hVar.location = location;
        }
        this.arG.put(i, hVar);
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
            this.arE = onClickListener;
        }
    }

    public void Al() {
        if (this.arL) {
            this.arz = G(w.l.share_copy, w.g.icon_copy_link);
        }
        int size = this.arD.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView H = H(w.l.share_weixin_timeline, w.g.icon_weixin_q);
                H.setVisibility(4);
                this.arD.add(H);
            }
        }
        if (!this.arM) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.arB.addView(this.arD.get(i2));
                } else {
                    this.arC.addView(this.arD.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 5) {
                this.arB.addView(this.arD.get(i3));
            }
        }
    }

    public void show() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.plugin_share_install_failure);
        } else {
            Al();
            this.ZM = new AlertDialog.Builder(this.mContext).create();
            this.ZM.setCanceledOnTouchOutside(true);
            this.ZM.setOnDismissListener(new g(this));
            if (this.mContext instanceof Activity) {
                j.a(this.ZM, (Activity) this.mContext);
            }
            Window window = this.ZM.getWindow();
            window.setWindowAnimations(w.m.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.arN);
            window.setContentView(this.mRootView);
            Am();
            Ai();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.arF = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.ZM != null) {
            this.arH = false;
            if (this.mContext instanceof Activity) {
                j.b(this.ZM, (Activity) this.mContext);
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
        if (this.arG.size() != 0) {
            if (view.getId() == w.h.btnShareCancel || !this.arH) {
                this.arH = true;
                i iVar = new i(this.mContext, this.arN);
                h ed = ed(1);
                if (id == w.h.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    this.arN.Af();
                }
                if (i == w.g.icon_weixin) {
                    h("share_to_weixin", new Object[0]);
                    ee(3);
                    h ed2 = ed(3);
                    a(ed2, 4);
                    if (ed2 != null) {
                        if (ed2.imageUri != null) {
                            arK = ed2.imageUri.toString();
                        }
                        iVar.c(ed2);
                    }
                } else if (i == w.g.icon_weixin_q) {
                    h("share_to_pyq", new Object[0]);
                    ee(2);
                    h ed3 = ed(2);
                    a(ed3, 3);
                    if (ed3 != null) {
                        if (ed3.arR) {
                            ed3.content = "【" + ed3.title + "】 " + ed3.content;
                        }
                        if (ed3.imageUri != null) {
                            arK = ed3.imageUri.toString();
                        }
                        iVar.d(ed3);
                    }
                } else if (i == w.g.icon_qq_zone) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        ee(4);
                        h ed4 = ed(4);
                        a(ed4, 5);
                        if (ed4 != null) {
                            iVar.f(ed4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tk();
                } else if (i == w.g.icon_qq_weibo) {
                    h("share_to_qweibo", new Object[0]);
                    ee(5);
                    h ed5 = ed(5);
                    a(ed5, 6);
                    if (ed5 != null) {
                        if (!ed5.arQ) {
                            ed5.content = b(ed5);
                        }
                        iVar.g(ed5);
                    }
                } else if (i == w.g.icon_sina) {
                    h("share_to_sweibo", new Object[0]);
                    ee(6);
                    h ed6 = ed(6);
                    a(ed6, 7);
                    if (ed6 != null) {
                        if (!ed6.arQ) {
                            ed6.content = b(ed6);
                        }
                        iVar.h(ed6);
                    }
                } else if (i == w.g.icon_renren) {
                    h("share_to_renren", new Object[0]);
                    ee(7);
                    h ed7 = ed(7);
                    a(ed7, 8);
                    if (ed7 != null) {
                        if (!ed7.arQ) {
                            ed7.content = b(ed7);
                        }
                        iVar.i(ed7);
                    }
                } else if (i == w.g.icon_qq_share) {
                    if (ac.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        ee(8);
                        h ed8 = ed(8);
                        a(ed8, 9);
                        if (ed8 != null) {
                            iVar.e(ed8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(w.l.share_qq_not_install)).tk();
                } else if (i == w.g.icon_copy_link) {
                    a(ed, 10);
                    if (this.arE != null) {
                        this.arE.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.ao(ed.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(w.l.copy_pb_url_success));
                    }
                    if (ed != null && ed.arQ) {
                        k(8, ed.arW);
                    }
                }
            }
        }
    }

    private h ed(int i) {
        h hVar = this.arG.get(i);
        if (hVar == null) {
            return this.arG.get(1);
        }
        return hVar;
    }

    private void ee(int i) {
        if (i <= 8 && i > 0) {
            this.arH = true;
            if (this.arJ != null) {
                o oVar = this.arJ.get(i);
                if (!StringUtils.isNull(oVar.xK()) && oVar.xL() != null && oVar.xL().size() > 0) {
                    h(oVar.xK(), oVar.xL());
                    return;
                }
            }
            if (this.arI != null) {
                String str = this.arI.get(i);
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
            if (hVar.arR) {
                TiebaStatic.log(new as("c10125").Z("fid", hVar.extData).r("obj_type", i));
            } else if (hVar.arS) {
                TiebaStatic.log(new as("c10125").Z("tid", hVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, hVar.arZ).r("obj_param1", hVar.asa));
            } else if (hVar.arT) {
                TiebaStatic.log(new as("c10427").Z("tid", hVar.extData).r("obj_type", i));
            } else if (hVar.arQ) {
                k(i, hVar.arW);
            } else if (hVar.arU) {
                TiebaStatic.log(new as("c10125").r("obj_param1", 7).r("obj_type", i).Z("fid", hVar.extData));
            }
        }
    }

    private void Am() {
        int size = this.arD.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.arD.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), w.e.cp_cont_j);
        }
        int paddingLeft = this.arw.getPaddingLeft();
        aq.j(this.arx, w.e.common_color_10010);
        aq.j(this.arw, w.g.bg_unite_popup_share_up);
        aq.c(this.arw, w.e.common_color_10039, 1);
        aq.c(this.ary, w.e.cp_cont_f, 1);
        aq.j(this.ary, w.g.dialog_single_button_bg_selector);
        aq.j(this.arA, w.e.cp_bg_line_a);
        this.arw.setPadding(paddingLeft, 0, 0, 0);
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
