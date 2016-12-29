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
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ai;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    public static String anh = "";
    private AlertDialog VA;
    private TextView amX;
    private final LinearLayout amZ;
    private final LinearLayout ana;
    private View.OnClickListener anc;
    private SparseArray<String> anf;
    private SparseArray<o> ang;
    private final Context mContext;
    private final SparseArray<f> and = new SparseArray<>(8);
    private boolean ane = false;
    private boolean ani = true;
    private com.baidu.tbadk.coreExtra.share.a anj = new e(this);
    private final List<TextView> anb = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_dialog_content, (ViewGroup) null);
    private final TextView amU = (TextView) this.mRootView.findViewById(r.g.share_dialog_title);
    private final View amV = this.mRootView.findViewById(r.g.share_dialog_content);
    private final View amY = this.mRootView.findViewById(r.g.line);
    private final TextView amW = (TextView) this.mRootView.findViewById(r.g.btnShareCancel);

    public d(Context context) {
        this.mContext = context;
        this.amW.setOnClickListener(this);
        A(r.j.share_weixin, r.f.icon_weixin);
        A(r.j.share_weixin_timeline, r.f.icon_weixin_q);
        A(r.j.share_qzone, r.f.icon_qq_zone);
        A(r.j.share_qq_friends, r.f.icon_qq_share);
        A(r.j.share_sina_weibo, r.f.icon_sina);
        this.amZ = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_1);
        this.ana = (LinearLayout) this.mRootView.findViewById(r.g.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) PluginCenter.getInstance().getSocialShareClassInstance()) == null) {
            this.amZ.setVisibility(8);
            this.ana.setVisibility(8);
        }
    }

    private TextView A(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(At());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.anb.add(textView);
        return textView;
    }

    public TextView B(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.m9getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(At());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams At() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public int Au() {
        if (this.anb == null) {
            return 0;
        }
        return this.anb.size();
    }

    public void a(TextView textView, View.OnClickListener onClickListener) {
        this.anb.add(0, textView);
        if (onClickListener != null) {
            textView.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.anb.size() && i >= 0) {
            this.anb.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener anl;

        public a(View.OnClickListener onClickListener) {
            this.anl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.anl != null) {
                this.anl.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.ani = z;
    }

    public void a(com.baidu.tbadk.coreExtra.share.a aVar) {
        if (aVar != null) {
            this.anj = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.anf = sparseArray;
    }

    public void a(f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.and.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location location;
        if (z && (location = getLocation()) != null) {
            fVar.location = location;
        }
        this.and.put(i, fVar);
    }

    private Location getLocation() {
        if (ae.X(this.mContext)) {
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
            this.anc = onClickListener;
        }
    }

    public void Av() {
        if (this.ani) {
            this.amX = A(r.j.share_copy, r.f.icon_copy_link);
        }
        int size = this.anb.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView B = B(r.j.share_weixin_timeline, r.f.icon_weixin_q);
                B.setVisibility(4);
                this.anb.add(B);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.amZ.addView(this.anb.get(i2));
            } else {
                this.ana.addView(this.anb.get(i2));
            }
        }
    }

    public void show() {
        if (!i.gm()) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_on_no_network);
        } else if (PluginCenter.getInstance().getSocialShareClassInstance() == null) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.plugin_share_install_failure);
        } else {
            Av();
            this.VA = new AlertDialog.Builder(this.mContext).create();
            this.VA.setCanceledOnTouchOutside(true);
            if (this.mContext instanceof Activity) {
                j.a(this.VA, (Activity) this.mContext);
            }
            Window window = this.VA.getWindow();
            window.setWindowAnimations(r.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            a(this.anj);
            window.setContentView(this.mRootView);
            Aw();
        }
    }

    public void dismiss() {
        if (this.VA != null) {
            this.ane = false;
            if (this.mContext instanceof Activity) {
                j.b(this.VA, (Activity) this.mContext);
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
        if (this.and.size() != 0) {
            if (view.getId() == r.g.btnShareCancel || !this.ane) {
                this.ane = true;
                h hVar = new h(this.mContext, this.anj);
                f ef = ef(1);
                if (id == r.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    this.anj.Aq();
                }
                if (i == r.f.icon_weixin) {
                    k("share_to_weixin", new Object[0]);
                    eg(3);
                    f ef2 = ef(3);
                    a(ef2, 4);
                    if (ef2 != null) {
                        if (ef2.imageUri != null) {
                            anh = ef2.imageUri.toString();
                        }
                        hVar.c(ef2);
                    }
                } else if (i == r.f.icon_weixin_q) {
                    k("share_to_pyq", new Object[0]);
                    eg(2);
                    f ef3 = ef(2);
                    a(ef3, 3);
                    if (ef3 != null) {
                        if (ef3.ann) {
                            ef3.content = "【" + ef3.title + "】 " + ef3.content;
                        }
                        if (ef3.imageUri != null) {
                            anh = ef3.imageUri.toString();
                        }
                        hVar.d(ef3);
                    }
                } else if (i == r.f.icon_qq_zone) {
                    if (ai.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qzone", new Object[0]);
                        eg(4);
                        f ef4 = ef(4);
                        a(ef4, 5);
                        if (ef4 != null) {
                            hVar.f(ef4);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.j.share_qq_not_install)).tj();
                } else if (i == r.f.icon_qq_weibo) {
                    k("share_to_qweibo", new Object[0]);
                    eg(5);
                    f ef5 = ef(5);
                    a(ef5, 6);
                    if (ef5 != null) {
                        if (!ef5.anm) {
                            ef5.content = b(ef5);
                        }
                        hVar.g(ef5);
                    }
                } else if (i == r.f.icon_sina) {
                    k("share_to_sweibo", new Object[0]);
                    eg(6);
                    f ef6 = ef(6);
                    a(ef6, 7);
                    if (ef6 != null) {
                        if (!ef6.anm) {
                            ef6.content = b(ef6);
                        }
                        hVar.h(ef6);
                    }
                } else if (i == r.f.icon_renren) {
                    k("share_to_renren", new Object[0]);
                    eg(7);
                    f ef7 = ef(7);
                    a(ef7, 8);
                    if (ef7 != null) {
                        if (!ef7.anm) {
                            ef7.content = b(ef7);
                        }
                        hVar.i(ef7);
                    }
                } else if (i == r.f.icon_qq_share) {
                    if (ai.isInstalledPackage(this.mContext, MobileQQ.PACKAGE_NAME)) {
                        k("share_to_qq_friend", new Object[0]);
                        eg(8);
                        f ef8 = ef(8);
                        a(ef8, 9);
                        if (ef8 != null) {
                            hVar.e(ef8);
                            return;
                        }
                        return;
                    }
                    BdToast.a(this.mContext, this.mContext.getText(r.j.share_qq_not_install)).tj();
                } else if (i == r.f.icon_copy_link) {
                    a(ef, 10);
                    if (this.anc != null) {
                        this.anc.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.az(ef.linkUrl);
                        k.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(r.j.copy_pb_url_success));
                    }
                    if (ef != null && ef.anm) {
                        i(8, ef.anr);
                    }
                }
            }
        }
    }

    private f ef(int i) {
        f fVar = this.and.get(i);
        if (fVar == null) {
            return this.and.get(1);
        }
        return fVar;
    }

    private void eg(int i) {
        if (i <= 8 && i > 0) {
            this.ane = true;
            if (this.ang != null) {
                o oVar = this.ang.get(i);
                if (!StringUtils.isNull(oVar.xN()) && oVar.xO() != null && oVar.xO().size() > 0) {
                    k(oVar.xN(), oVar.xO());
                    return;
                }
            }
            if (this.anf != null) {
                String str = this.anf.get(i);
                if (!av.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void i(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(f fVar, int i) {
        if (fVar != null && fVar.extData != null) {
            if (fVar.ann) {
                TiebaStatic.log(new at("c10125").ab("fid", fVar.extData).s("obj_type", i));
            } else if (fVar.ano) {
                TiebaStatic.log(new at("c10125").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.anp) {
                TiebaStatic.log(new at("c10427").ab("tid", fVar.extData).s("obj_type", i));
            } else if (fVar.anm) {
                i(i, fVar.anr);
            } else if (fVar.anq) {
                TiebaStatic.log(new at("c10125").s("obj_param1", 7).s("obj_type", i).ab("fid", fVar.extData));
            }
        }
    }

    private void Aw() {
        int size = this.anb.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.anb.get(i);
            a(textView, ((Integer) textView.getTag()).intValue(), r.d.cp_cont_j);
        }
        int paddingLeft = this.amU.getPaddingLeft();
        ar.k(this.amV, r.d.common_color_10010);
        ar.k(this.amU, r.f.bg_unite_popup_share_up);
        ar.c(this.amU, r.d.common_color_10039, 1);
        ar.c(this.amW, r.d.cp_cont_f, 1);
        ar.k(this.amW, r.f.dialog_single_button_bg_selector);
        ar.k(this.amY, r.d.cp_bg_line_a);
        this.amU.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ar.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ar.c(textView, i2, 1);
    }

    public void b(SparseArray<o> sparseArray) {
        this.ang = sparseArray;
    }

    private String b(f fVar) {
        String str = "【" + fVar.title + "】 " + fVar.content;
        fVar.content = str;
        return str;
    }
}
