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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private AlertDialog Bf;
    private final Button MH;
    private final LinearLayout MJ;
    private final LinearLayout MK;
    private View.OnClickListener MN;
    private final LinearLayout MO;
    private boolean MR;
    private SparseArray<String> MT;
    private final Context mContext;
    private final SparseArray<h> MP = new SparseArray<>(7);
    private boolean MQ = false;
    private final int MS = 8;
    private a MU = new e(this);
    private final List<TextView> ML = new ArrayList();
    private final View HS = com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_dialog_content, null);
    private final TextView ME = (TextView) this.HS.findViewById(v.share_dialog_title);
    private final View MF = this.HS.findViewById(v.share_dialog_content);
    private final View MI = this.HS.findViewById(v.line);
    private final Button MG = (Button) this.HS.findViewById(v.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.MG.setOnClickListener(this);
        this.MH = (Button) this.HS.findViewById(v.btnCopy);
        this.MH.setOnClickListener(this);
        s(y.share_weixin_timeline, u.icon_unite_share_friend);
        s(y.share_weixin, u.icon_unite_share_weixin);
        s(y.share_qzone, u.icon_unite_share_qqzon);
        s(y.share_qweibo, u.icon_unite_share_tencent);
        s(y.share_sina_weibo, u.icon_unite_share_sina);
        s(y.share_renren, u.icon_unite_share_renren);
        this.MO = (LinearLayout) this.HS.findViewById(v.customViewBox);
        this.MJ = (LinearLayout) this.HS.findViewById(v.share_dialog_line_1);
        this.MK = (LinearLayout) this.HS.findViewById(v.share_dialog_line_2);
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_SOCIAL_SHARE);
        if ((pluginByName != null ? (BdSocialShareSdkDelegate) pluginByName.getClassInstance(BdSocialShareSdkDelegate.class) : null) == null) {
            this.MJ.setVisibility(8);
            this.MK.setVisibility(8);
        } else if (pluginByName != null && !pluginByName.checkEnable()) {
            this.MR = true;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.MG.setOnClickListener(onClickListener);
        }
    }

    private TextView s(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkApplication.m251getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(pK());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.ML.add(textView);
        return textView;
    }

    public TextView t(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkApplication.m251getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(pK());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams pK() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.ML.add(0, textView);
    }

    public void ai(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m.c(this.mContext, t.ds100));
        if (z) {
            this.MH.setVisibility(0);
            int c = m.c(this.mContext, t.ds50);
            int c2 = m.c(this.mContext, t.ds40);
            layoutParams.setMargins(c2, m.c(this.mContext, t.ds20), c2, c);
            this.MG.setLayoutParams(layoutParams);
            return;
        }
        this.MH.setVisibility(8);
        int c3 = m.c(this.mContext, t.ds50);
        int c4 = m.c(this.mContext, t.ds40);
        layoutParams.setMargins(c4, c3, c4, c3);
        this.MG.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.MU = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.MT = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location pL;
        if (z && (pL = pL()) != null) {
            hVar.MY = pL;
        }
        this.MP.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location pL;
        if (z && (pL = pL()) != null) {
            hVar.MY = pL;
        }
        this.MP.put(i, hVar);
    }

    private Location pL() {
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

    public void b(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.MN = onClickListener;
        }
    }

    public void pM() {
        int size = this.ML.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView t = t(y.share_weixin_timeline, u.icon_unite_share_friend);
                t.setVisibility(4);
                this.ML.add(t);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.MJ.addView(this.ML.get(i2));
            } else {
                this.MK.addView(this.ML.get(i2));
            }
        }
    }

    public void show() {
        if (!j.fh()) {
            m.showToast(TbadkApplication.m251getInst(), y.share_on_no_network);
            return;
        }
        pM();
        this.Bf = new AlertDialog.Builder(this.mContext).create();
        this.Bf.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.a(this.Bf, (Activity) this.mContext);
        }
        Window window = this.Bf.getWindow();
        window.setWindowAnimations(z.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.MU);
        window.setContentView(this.HS);
        kU();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Bf.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Bf != null) {
            this.MQ = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.Bf, (Activity) this.mContext);
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
        if (this.MR && id != v.btnShareCancel && id != v.btnCopy) {
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.Bf, (Activity) this.mContext);
            }
            com.baidu.tbadk.coreExtra.util.a.a((Activity) this.mContext, y.plugin_share_not_install, new f(this), new g(this));
            return;
        }
        dismiss();
        if (this.MP.size() != 0) {
            if (view.getId() == v.btnShareCancel || !this.MQ) {
                this.MQ = true;
                i iVar = new i(this.mContext, this.MU);
                if (id == v.btnShareCancel) {
                    cI("share_cancel");
                    this.MU.pH();
                } else if (id == v.btnCopy && this.MN != null) {
                    this.MN.onClick(this.MH);
                }
                if (i == u.icon_unite_share_weixin) {
                    cI("share_to_weixin");
                    cs(3);
                    h cr = cr(3);
                    if (cr != null) {
                        iVar.a(cr);
                    }
                } else if (i == u.icon_unite_share_friend) {
                    cI("share_to_pyq");
                    cs(2);
                    h cr2 = cr(2);
                    if (cr2 != null) {
                        iVar.b(cr2);
                    }
                } else if (i == u.icon_unite_share_qqzon) {
                    cI("share_to_qzone");
                    cs(4);
                    h cr3 = cr(4);
                    if (cr3 != null) {
                        iVar.c(cr3);
                    }
                } else if (i == u.icon_unite_share_tencent) {
                    cI("share_to_qweibo");
                    cs(5);
                    h cr4 = cr(5);
                    if (cr4 != null) {
                        iVar.d(cr4);
                    }
                } else if (i == u.icon_unite_share_sina) {
                    cI("share_to_sweibo");
                    cs(6);
                    h cr5 = cr(6);
                    if (cr5 != null) {
                        iVar.e(cr5);
                    }
                } else if (i == u.icon_unite_share_renren) {
                    cI("share_to_renren");
                    cs(7);
                    h cr6 = cr(7);
                    if (cr6 != null) {
                        iVar.f(cr6);
                    }
                }
            }
        }
    }

    private h cr(int i) {
        h hVar = this.MP.get(i);
        if (hVar == null) {
            return this.MP.get(1);
        }
        return hVar;
    }

    private void cs(int i) {
        if (i <= 7 && i > 0) {
            this.MQ = true;
            if (this.MT != null) {
                String str = this.MT.get(i);
                if (!ay.aA(str)) {
                    cI(str);
                }
            }
        }
    }

    private void cI(String str) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, new Object[0]);
    }

    private void kU() {
        int size = this.ML.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.ML.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), s.cp_cont_f);
        }
        int paddingLeft = this.ME.getPaddingLeft();
        aw.h(this.MF, u.bg_dailog);
        aw.h((View) this.ME, u.bg_unite_popup_share_up);
        aw.b(this.ME, s.share_to, 1);
        aw.h((View) this.MG, u.btn_w_square);
        aw.b(this.MG, s.share_to, 3);
        aw.h((View) this.MH, u.btn_blue_bg);
        aw.b(this.MH, s.cp_cont_g, 3);
        aw.h(this.MI, s.cp_bg_line_b);
        this.ME.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = aw.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        aw.b(textView, i2, 1);
    }
}
