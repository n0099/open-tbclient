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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
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
    private final Button MK;
    private final LinearLayout MN;
    private final LinearLayout MO;
    private View.OnClickListener MQ;
    private final LinearLayout MR;
    private boolean MU;
    private SparseArray<String> MW;
    private SparseArray<com.baidu.tbadk.coreExtra.data.f> MX;
    private final Context mContext;
    private final SparseArray<h> MS = new SparseArray<>(7);
    private boolean MT = false;
    private final int MV = 8;
    private a MY = new e(this);
    private final List<TextView> MP = new ArrayList();
    private final View HT = com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_dialog_content, null);
    private final TextView MH = (TextView) this.HT.findViewById(v.share_dialog_title);
    private final View MI = this.HT.findViewById(v.share_dialog_content);
    private final View ML = this.HT.findViewById(v.line);
    private final Button MJ = (Button) this.HT.findViewById(v.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.MJ.setOnClickListener(this);
        this.MK = (Button) this.HT.findViewById(v.btnCopy);
        this.MK.setOnClickListener(this);
        s(y.share_weixin_timeline, u.icon_unite_share_friend);
        s(y.share_weixin, u.icon_unite_share_weixin);
        s(y.share_qzone, u.icon_unite_share_qqzon);
        s(y.share_qweibo, u.icon_unite_share_tencent);
        s(y.share_sina_weibo, u.icon_unite_share_sina);
        s(y.share_renren, u.icon_unite_share_renren);
        this.MR = (LinearLayout) this.HT.findViewById(v.customViewBox);
        this.MN = (LinearLayout) this.HT.findViewById(v.share_dialog_line_1);
        this.MO = (LinearLayout) this.HT.findViewById(v.share_dialog_line_2);
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_SOCIAL_SHARE);
        if ((pluginByName != null ? (BdSocialShareSdkDelegate) pluginByName.getClassInstance(BdSocialShareSdkDelegate.class) : null) == null) {
            this.MN.setVisibility(8);
            this.MO.setVisibility(8);
        } else if (pluginByName != null && !pluginByName.checkEnable()) {
            this.MU = true;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.MJ.setOnClickListener(onClickListener);
        }
    }

    private TextView s(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkApplication.m251getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(pM());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.MP.add(textView);
        return textView;
    }

    public TextView t(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), w.share_icon_text, null);
        textView.setCompoundDrawables(null, TbadkApplication.m251getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(pM());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams pM() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.MP.add(0, textView);
    }

    public void ai(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m.c(this.mContext, t.ds100));
        if (z) {
            this.MK.setVisibility(0);
            int c = m.c(this.mContext, t.ds50);
            int c2 = m.c(this.mContext, t.ds40);
            layoutParams.setMargins(c2, m.c(this.mContext, t.ds20), c2, c);
            this.MJ.setLayoutParams(layoutParams);
            return;
        }
        this.MK.setVisibility(8);
        int c3 = m.c(this.mContext, t.ds50);
        int c4 = m.c(this.mContext, t.ds40);
        layoutParams.setMargins(c4, c3, c4, c3);
        this.MJ.setLayoutParams(layoutParams);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.MY = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.MW = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location pN;
        if (z && (pN = pN()) != null) {
            hVar.Nc = pN;
        }
        this.MS.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location pN;
        if (z && (pN = pN()) != null) {
            hVar.Nc = pN;
        }
        this.MS.put(i, hVar);
    }

    private Location pN() {
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
            this.MQ = onClickListener;
        }
    }

    public void pO() {
        int size = this.MP.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView t = t(y.share_weixin_timeline, u.icon_unite_share_friend);
                t.setVisibility(4);
                this.MP.add(t);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.MN.addView(this.MP.get(i2));
            } else {
                this.MO.addView(this.MP.get(i2));
            }
        }
    }

    public void show() {
        if (!j.fh()) {
            m.showToast(TbadkApplication.m251getInst(), y.share_on_no_network);
            return;
        }
        pO();
        this.Bf = new AlertDialog.Builder(this.mContext).create();
        this.Bf.setCanceledOnTouchOutside(true);
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.a(this.Bf, (Activity) this.mContext);
        }
        Window window = this.Bf.getWindow();
        window.setWindowAnimations(z.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.MY);
        window.setContentView(this.HT);
        kU();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.Bf.setOnDismissListener(onDismissListener);
    }

    public void dismiss() {
        if (this.Bf != null) {
            this.MT = false;
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
        if (this.MU && id != v.btnShareCancel && id != v.btnCopy) {
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.g.j.b(this.Bf, (Activity) this.mContext);
            }
            com.baidu.tbadk.coreExtra.util.a.a((Activity) this.mContext, y.plugin_share_not_install, new f(this), new g(this));
            return;
        }
        dismiss();
        if (this.MS.size() != 0) {
            if (view.getId() == v.btnShareCancel || !this.MT) {
                this.MT = true;
                i iVar = new i(this.mContext, this.MY);
                if (id == v.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    this.MY.pJ();
                } else if (id == v.btnCopy && this.MQ != null) {
                    this.MQ.onClick(this.MK);
                }
                if (i == u.icon_unite_share_weixin) {
                    f("share_to_weixin", new Object[0]);
                    cs(3);
                    h cr = cr(3);
                    if (cr != null) {
                        iVar.a(cr);
                    }
                } else if (i == u.icon_unite_share_friend) {
                    f("share_to_pyq", new Object[0]);
                    cs(2);
                    h cr2 = cr(2);
                    if (cr2 != null) {
                        iVar.b(cr2);
                    }
                } else if (i == u.icon_unite_share_qqzon) {
                    f("share_to_qzone", new Object[0]);
                    cs(4);
                    h cr3 = cr(4);
                    if (cr3 != null) {
                        iVar.c(cr3);
                    }
                } else if (i == u.icon_unite_share_tencent) {
                    f("share_to_qweibo", new Object[0]);
                    cs(5);
                    h cr4 = cr(5);
                    if (cr4 != null) {
                        iVar.d(cr4);
                    }
                } else if (i == u.icon_unite_share_sina) {
                    f("share_to_sweibo", new Object[0]);
                    cs(6);
                    h cr5 = cr(6);
                    if (cr5 != null) {
                        iVar.e(cr5);
                    }
                } else if (i == u.icon_unite_share_renren) {
                    f("share_to_renren", new Object[0]);
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
        h hVar = this.MS.get(i);
        if (hVar == null) {
            return this.MS.get(1);
        }
        return hVar;
    }

    private void cs(int i) {
        if (i <= 7 && i > 0) {
            this.MT = true;
            if (this.MX != null) {
                com.baidu.tbadk.coreExtra.data.f fVar = this.MX.get(i);
                if (!StringUtils.isNull(fVar.oA()) && fVar.oB() != null && fVar.oB().size() > 0) {
                    f(fVar.oA(), fVar.oB());
                    return;
                }
            }
            if (this.MW != null) {
                String str = this.MW.get(i);
                if (!az.aA(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void kU() {
        int size = this.MP.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.MP.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), s.cp_cont_f);
        }
        int paddingLeft = this.MH.getPaddingLeft();
        aw.h(this.MI, u.bg_dailog);
        aw.h((View) this.MH, u.bg_unite_popup_share_up);
        aw.b(this.MH, s.share_to, 1);
        aw.h((View) this.MJ, u.btn_w_square);
        aw.b(this.MJ, s.share_to, 3);
        aw.h((View) this.MK, u.btn_blue_bg);
        aw.b(this.MK, s.cp_cont_g, 3);
        aw.h(this.ML, s.cp_bg_line_b);
        this.MH.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = aw.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        aw.b(textView, i2, 1);
    }

    public void b(SparseArray<com.baidu.tbadk.coreExtra.data.f> sparseArray) {
        this.MX = sparseArray;
    }
}
