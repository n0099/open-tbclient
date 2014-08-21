package com.baidu.tbadk.coreExtra.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final Context a;
    private final View b;
    private final TextView c;
    private final View d;
    private final Resources e;
    private final Button f;
    private final Button g;
    private final View h;
    private final LinearLayout i;
    private final LinearLayout j;
    private View.OnClickListener l;
    private final LinearLayout m;
    private AlertDialog n;
    private boolean q;
    private SparseArray<String> s;
    private final SparseArray<h> o = new SparseArray<>(7);
    private boolean p = false;
    private final int r = 8;
    private a t = new e(this);
    private final List<TextView> k = new ArrayList();

    public d(Context context) {
        this.a = context;
        this.e = this.a.getResources();
        this.b = com.baidu.adp.lib.e.b.a().a(context, v.share_dialog_content, null);
        this.c = (TextView) this.b.findViewById(u.share_dialog_title);
        this.d = this.b.findViewById(u.share_dialog_content);
        this.h = this.b.findViewById(u.line);
        this.f = (Button) this.b.findViewById(u.btnShareCancel);
        this.f.setOnClickListener(this);
        this.g = (Button) this.b.findViewById(u.btnCopy);
        this.g.setOnClickListener(this);
        a(x.share_weixin_timeline, t.icon_unite_share_friend);
        a(x.share_weixin, t.icon_unite_share_weixin);
        a(x.share_qzone, t.icon_unite_share_qqzon);
        a(x.share_qweibo, t.icon_unite_share_tencent);
        a(x.share_sina_weibo, t.icon_unite_share_sina);
        a(x.share_renren, t.icon_unite_share_renren);
        this.m = (LinearLayout) this.b.findViewById(u.customViewBox);
        this.i = (LinearLayout) this.b.findViewById(u.share_dialog_line_1);
        this.j = (LinearLayout) this.b.findViewById(u.share_dialog_line_2);
        com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("BdSocialShareSdk");
        if ((a != null ? (BdSocialShareSdkDelegate) a.a(BdSocialShareSdkDelegate.class) : null) == null) {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        } else if (a != null && !a.c()) {
            this.q = true;
        }
    }

    public TextView a(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.e.b.a().a(this.a, v.share_icon_text, null);
        textView.setCompoundDrawables(null, this.e.getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(a());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.k.add(textView);
        return textView;
    }

    public TextView b(int i, int i2) {
        TextView textView = (TextView) com.baidu.adp.lib.e.b.a().a(this.a, v.share_icon_text, null);
        textView.setCompoundDrawables(null, this.e.getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(a());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void a(TextView textView) {
        this.k.add(0, textView);
    }

    public void a(boolean z) {
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.t = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.s = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location e;
        if (z && (e = e()) != null) {
            hVar.e = e;
        }
        this.o.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location e;
        if (z && (e = e()) != null) {
            hVar.e = e;
        }
        this.o.put(i, hVar);
    }

    private Location e() {
        LocationManager locationManager = (LocationManager) this.a.getSystemService("location");
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

    public void a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.l = onClickListener;
        }
    }

    public void b() {
        int size = this.k.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView b = b(x.share_weixin_timeline, t.icon_unite_share_friend);
                b.setVisibility(4);
                this.k.add(b);
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            if (i2 < 4) {
                this.i.addView(this.k.get(i2));
            } else {
                this.j.addView(this.k.get(i2));
            }
        }
    }

    public void c() {
        if (!UtilHelper.isNetOk()) {
            j.a(this.a, x.share_on_no_network);
            return;
        }
        b();
        this.n = new AlertDialog.Builder(this.a).create();
        this.n.setCanceledOnTouchOutside(true);
        if (this.a instanceof Activity) {
            com.baidu.adp.lib.e.e.a(this.n, (Activity) this.a);
        }
        Window window = this.n.getWindow();
        window.setWindowAnimations(y.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.t);
        window.setContentView(this.b);
        f();
    }

    public void d() {
        if (this.n != null) {
            this.p = false;
            if (this.a instanceof Activity) {
                com.baidu.adp.lib.e.e.b(this.n, (Activity) this.a);
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
        if (this.q && id != u.btnShareCancel && id != u.btnCopy) {
            if (this.a instanceof Activity) {
                com.baidu.adp.lib.e.e.b(this.n, (Activity) this.a);
            }
            com.baidu.tbadk.coreExtra.c.a.a((Activity) this.a, x.plugin_share_not_install, new f(this), new g(this));
            return;
        }
        d();
        if (this.o.size() != 0) {
            if (view.getId() == u.btnShareCancel || !this.p) {
                this.p = true;
                i iVar = new i(this.a, this.t);
                if (id == u.btnShareCancel) {
                    a("share_cancel");
                    this.t.b();
                } else if (id == u.btnCopy && this.l != null) {
                    this.l.onClick(this.g);
                }
                if (i == t.icon_unite_share_weixin) {
                    a("share_to_weixin");
                    b(3);
                    h a = a(3);
                    if (a != null) {
                        iVar.a(a);
                    }
                } else if (i == t.icon_unite_share_friend) {
                    a("share_to_pyq");
                    b(2);
                    h a2 = a(2);
                    if (a2 != null) {
                        iVar.b(a2);
                    }
                } else if (i == t.icon_unite_share_qqzon) {
                    a("share_to_qzone");
                    b(4);
                    h a3 = a(4);
                    if (a3 != null) {
                        iVar.c(a3);
                    }
                } else if (i == t.icon_unite_share_tencent) {
                    a("share_to_qweibo");
                    b(5);
                    h a4 = a(5);
                    if (a4 != null) {
                        iVar.d(a4);
                    }
                } else if (i == t.icon_unite_share_sina) {
                    a("share_to_sweibo");
                    b(6);
                    h a5 = a(6);
                    if (a5 != null) {
                        iVar.e(a5);
                    }
                } else if (i == t.icon_unite_share_renren) {
                    a("share_to_renren");
                    b(7);
                    h a6 = a(7);
                    if (a6 != null) {
                        iVar.f(a6);
                    }
                }
            }
        }
    }

    private h a(int i) {
        h hVar = this.o.get(i);
        if (hVar == null) {
            return this.o.get(1);
        }
        return hVar;
    }

    private void b(int i) {
        if (i <= 7 && i > 0) {
            this.p = true;
            if (this.s != null) {
                String str = this.s.get(i);
                if (!ba.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        TiebaStatic.eventStat(this.a, str, "click", 1, new Object[0]);
    }

    @SuppressLint({"ResourceAsColor"})
    private void f() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.k.get(i);
            Integer num = (Integer) textView.getTag();
            a(textView, num.intValue(), r.cp_cont_f, ay.a(this.a, num.intValue()), r.cp_cont_f_1);
        }
        int paddingLeft = this.c.getPaddingLeft();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.d.setBackgroundResource(t.bg_dailog_1);
            this.c.setBackgroundResource(t.bg_unite_popup_share_up_1);
            this.c.setTextColor(this.a.getResources().getColor(r.share_to_1));
            this.f.setBackgroundResource(t.btn_w_square_1);
            this.f.setTextColor(this.a.getResources().getColor(r.share_to_1));
            this.g.setBackgroundResource(t.btn_blue_bg_1);
            this.g.setTextColor(this.a.getResources().getColor(r.cp_cont_g_1));
            this.h.setBackgroundResource(r.cp_bg_line_b_1);
        } else {
            this.d.setBackgroundResource(t.bg_dailog);
            this.c.setBackgroundResource(t.bg_unite_popup_share_up);
            this.c.setTextColor(this.a.getResources().getColor(r.share_to));
            this.f.setBackgroundResource(t.btn_w_square);
            this.f.setTextColor(this.a.getResources().getColor(r.share_to));
            this.g.setBackgroundResource(t.btn_blue_bg);
            this.g.setTextColor(this.a.getResources().getColor(r.cp_cont_g));
            this.h.setBackgroundResource(r.cp_bg_line_b);
        }
        this.c.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != 1) {
            i3 = i;
        }
        if (skinType != 1) {
            i4 = i2;
        }
        Drawable drawable = this.a.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextColor(this.a.getResources().getColor(i4));
    }
}
