package com.baidu.tbadk.coreExtra.share;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private SparseArray<String> A;
    private final LayoutInflater a;
    private final Context b;
    private final View c;
    private final TextView d;
    private final View e;
    private final TextView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final Button n;
    private final Button o;
    private final View p;
    private final LinearLayout q;
    private final LinearLayout r;
    private View.OnClickListener s;
    private View.OnClickListener t;
    private View.OnClickListener u;
    private final LinearLayout v;
    private AlertDialog w;
    private boolean z;
    private final SparseArray<h> x = new SparseArray<>(7);
    private boolean y = false;
    private a B = new e(this);

    public d(Context context) {
        this.b = context;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = this.a.inflate(v.share_dialog_content, (ViewGroup) null);
        this.d = (TextView) this.c.findViewById(u.share_dialog_title);
        this.e = this.c.findViewById(u.share_dialog_content);
        this.p = this.c.findViewById(u.line);
        this.n = (Button) this.c.findViewById(u.btnShareCancel);
        this.n.setOnClickListener(this);
        this.o = (Button) this.c.findViewById(u.btnCopy);
        this.o.setOnClickListener(this);
        this.f = (TextView) this.c.findViewById(u.iconQunZu);
        this.f.setOnClickListener(this);
        this.m = (TextView) this.c.findViewById(u.forum_friend);
        this.m.setOnClickListener(this);
        this.g = (TextView) this.c.findViewById(u.iconWeixinTimeline);
        this.g.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(u.iconWeixin);
        this.h.setOnClickListener(this);
        this.i = (TextView) this.c.findViewById(u.iconQZone);
        this.i.setOnClickListener(this);
        this.j = (TextView) this.c.findViewById(u.iconQQWeibo);
        this.j.setOnClickListener(this);
        this.k = (TextView) this.c.findViewById(u.iconSinaWeibo);
        this.k.setOnClickListener(this);
        this.l = (TextView) this.c.findViewById(u.iconRenren);
        this.l.setOnClickListener(this);
        this.v = (LinearLayout) this.c.findViewById(u.customViewBox);
        this.q = (LinearLayout) this.c.findViewById(u.share_dialog_line_1);
        this.r = (LinearLayout) this.c.findViewById(u.share_dialog_line_2);
        com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("BdSocialShareSdk");
        if ((a != null ? (BdSocialShareSdkDelegate) a.a(BdSocialShareSdkDelegate.class) : null) == null) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
        } else if (a != null && !a.c()) {
            this.z = true;
        }
    }

    public void a(boolean z) {
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.B = aVar;
        }
    }

    public void a(SparseArray<String> sparseArray) {
        this.A = sparseArray;
    }

    public void a(h hVar, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            hVar.e = c;
        }
        this.x.put(1, hVar);
    }

    public void a(int i, h hVar, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            hVar.e = c;
        }
        this.x.put(i, hVar);
    }

    private Location c() {
        LocationManager locationManager = (LocationManager) this.b.getSystemService("location");
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

    public void a(String str, Drawable drawable, View.OnClickListener onClickListener) {
        if (str != null) {
            this.f.setText(str);
        }
        if (drawable != null) {
            this.f.setCompoundDrawables(null, drawable, null, null);
        }
        if (onClickListener != null) {
            this.t = onClickListener;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.s = onClickListener;
        }
    }

    public void a() {
        if (!UtilHelper.isNetOk()) {
            j.a(this.b, x.share_on_no_network);
            return;
        }
        this.w = new AlertDialog.Builder(this.b).create();
        this.w.setCanceledOnTouchOutside(true);
        if (this.b instanceof Activity) {
            com.baidu.adp.lib.e.d.a(this.w, (Activity) this.b);
        }
        Window window = this.w.getWindow();
        window.setWindowAnimations(y.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.B);
        window.setContentView(this.c);
        d();
    }

    public void b() {
        if (this.w != null) {
            this.y = false;
            if (this.b instanceof Activity) {
                com.baidu.adp.lib.e.d.b(this.w, (Activity) this.b);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.z && id != u.btnShareCancel && id != u.btnCopy) {
            this.w.dismiss();
            com.baidu.tbadk.coreExtra.c.a.a((Activity) this.b, x.plugin_share_not_install, new f(this), new g(this));
            return;
        }
        b();
        if (this.x.size() != 0) {
            if (view.getId() == u.btnShareCancel || !this.y) {
                this.y = true;
                i iVar = new i(this.b, this.B);
                if (id == u.btnShareCancel) {
                    a("share_cancel");
                    this.B.b();
                } else if (id == u.iconQunZu) {
                    if (this.t != null) {
                        this.t.onClick(this.f);
                    }
                } else if (id == u.btnCopy) {
                    if (this.s != null) {
                        this.s.onClick(this.o);
                    }
                } else if (id == u.iconWeixin) {
                    a("share_to_weixin");
                    b(3);
                    h a = a(3);
                    if (a != null) {
                        iVar.a(a);
                    }
                } else if (id == u.iconWeixinTimeline) {
                    a("share_to_pyq");
                    b(2);
                    h a2 = a(2);
                    if (a2 != null) {
                        iVar.b(a2);
                    }
                } else if (id == u.iconQZone) {
                    a("share_to_qzone");
                    b(4);
                    h a3 = a(4);
                    if (a3 != null) {
                        iVar.c(a3);
                    }
                } else if (id == u.iconQQWeibo) {
                    a("share_to_qweibo");
                    b(5);
                    h a4 = a(5);
                    if (a4 != null) {
                        iVar.d(a4);
                    }
                } else if (id == u.iconSinaWeibo) {
                    a("share_to_sweibo");
                    b(6);
                    h a5 = a(6);
                    if (a5 != null) {
                        iVar.e(a5);
                    }
                } else if (id == u.iconRenren) {
                    a("share_to_renren");
                    b(7);
                    h a6 = a(7);
                    if (a6 != null) {
                        iVar.f(a6);
                    }
                } else if (id == u.forum_friend && this.u != null) {
                    this.u.onClick(this.m);
                }
            }
        }
    }

    private h a(int i) {
        h hVar = this.x.get(i);
        if (hVar == null) {
            return this.x.get(1);
        }
        return hVar;
    }

    private void b(int i) {
        if (i <= 7 && i > 0) {
            this.y = true;
            if (this.A != null) {
                String str = this.A.get(i);
                if (!ba.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        TiebaStatic.eventStat(this.b, str, "click", 1, new Object[0]);
    }

    @SuppressLint({"ResourceAsColor"})
    private void d() {
        a(this.f, t.icon_unite_share_qunzu, r.cp_cont_f, t.icon_unite_share_qunzu_1, r.cp_cont_f_1);
        a(this.m, t.icon_unite_share_baf, r.cp_cont_f, t.icon_unite_share_baf_1, r.cp_cont_f_1);
        a(this.g, t.icon_unite_share_friend, r.cp_cont_f, t.icon_unite_share_friend_1, r.cp_cont_f_1);
        a(this.h, t.icon_unite_share_weixin, r.cp_cont_f, t.icon_unite_share_weixin_1, r.cp_cont_f_1);
        a(this.i, t.icon_unite_share_qqzon, r.cp_cont_f, t.icon_unite_share_qqzon_1, r.cp_cont_f_1);
        a(this.j, t.icon_unite_share_tencent, r.cp_cont_f, t.icon_unite_share_tencent_1, r.cp_cont_f_1);
        a(this.k, t.icon_unite_share_sina, r.cp_cont_f, t.icon_unite_share_sina_1, r.cp_cont_f_1);
        a(this.l, t.icon_unite_share_renren, r.cp_cont_f, t.icon_unite_share_renren_1, r.cp_cont_f_1);
        int paddingLeft = this.d.getPaddingLeft();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.e.setBackgroundResource(t.bg_dailog_1);
            this.d.setBackgroundResource(t.bg_unite_popup_share_up_1);
            this.d.setTextColor(this.b.getResources().getColor(r.share_to_1));
            this.n.setBackgroundResource(t.btn_w_square_1);
            this.n.setTextColor(this.b.getResources().getColor(r.share_to_1));
            this.o.setBackgroundResource(t.btn_blue_bg_1);
            this.o.setTextColor(this.b.getResources().getColor(r.cp_cont_g_1));
            this.p.setBackgroundResource(r.cp_bg_line_b_1);
        } else {
            this.e.setBackgroundResource(t.bg_dailog);
            this.d.setBackgroundResource(t.bg_unite_popup_share_up);
            this.d.setTextColor(this.b.getResources().getColor(r.share_to));
            this.n.setBackgroundResource(t.btn_w_square);
            this.n.setTextColor(this.b.getResources().getColor(r.share_to));
            this.o.setBackgroundResource(t.btn_blue_bg);
            this.o.setTextColor(this.b.getResources().getColor(r.cp_cont_g));
            this.p.setBackgroundResource(r.cp_bg_line_b);
        }
        this.d.setPadding(paddingLeft, 0, 0, 0);
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != 1) {
            i3 = i;
        }
        if (skinType != 1) {
            i4 = i2;
        }
        Drawable drawable = this.b.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextColor(this.b.getResources().getColor(i4));
    }
}
