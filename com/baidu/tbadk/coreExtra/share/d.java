package com.baidu.tbadk.coreExtra.share;

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
import com.baidu.adp.lib.util.h;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
import com.baidu.tbadk.tbplugin.m;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
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
    private final Button l;
    private final LinearLayout m;
    private final LinearLayout n;
    private final LinearLayout o;
    private AlertDialog p;
    private SparseArray<String> s;
    private final SparseArray<f> q = new SparseArray<>(7);
    private boolean r = false;
    private a t = new e(this);

    public d(Context context) {
        this.b = context;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = this.a.inflate(s.share_dialog_content, (ViewGroup) null);
        this.d = (TextView) this.c.findViewById(r.share_dialog_title);
        this.e = this.c.findViewById(r.share_dialog_content);
        this.l = (Button) this.c.findViewById(r.btnShareCancel);
        this.l.setOnClickListener(this);
        this.f = (TextView) this.c.findViewById(r.iconWeixinTimeline);
        this.f.setOnClickListener(this);
        this.g = (TextView) this.c.findViewById(r.iconWeixin);
        this.g.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(r.iconQZone);
        this.h.setOnClickListener(this);
        this.i = (TextView) this.c.findViewById(r.iconQQWeibo);
        this.i.setOnClickListener(this);
        this.j = (TextView) this.c.findViewById(r.iconSinaWeibo);
        this.j.setOnClickListener(this);
        this.k = (TextView) this.c.findViewById(r.iconRenren);
        this.k.setOnClickListener(this);
        this.o = (LinearLayout) this.c.findViewById(r.customViewBox);
        this.m = (LinearLayout) this.c.findViewById(r.share_dialog_line_1);
        this.n = (LinearLayout) this.c.findViewById(r.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) m.a().b(BdSocialShareSdkDelegate.class)) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
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

    public void a(f fVar, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            fVar.e = c;
        }
        this.q.put(1, fVar);
    }

    public void a(int i, f fVar, boolean z) {
        Location c;
        if (z && (c = c()) != null) {
            fVar.e = c;
        }
        this.q.put(i, fVar);
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

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            this.o.addView(view);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            this.o.setVisibility(0);
        }
    }

    public void a() {
        if (!UtilHelper.isNetOk()) {
            h.a(this.b, u.share_on_no_network);
            return;
        }
        this.p = new AlertDialog.Builder(this.b).create();
        this.p.setCanceledOnTouchOutside(true);
        this.p.show();
        Window window = this.p.getWindow();
        window.setWindowAnimations(v.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a(this.t);
        window.setContentView(this.c);
        d();
    }

    public void b() {
        if (this.p != null) {
            this.r = false;
            this.p.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b();
        if (this.q.size() != 0) {
            if (view.getId() == r.btnShareCancel || !this.r) {
                this.r = true;
                g gVar = new g(this.b, this.t);
                int id = view.getId();
                if (id == r.btnShareCancel) {
                    a("share_cancel");
                    this.t.b();
                } else if (id == r.iconWeixin) {
                    a("share_to_weixin");
                    b(3);
                    f a = a(3);
                    if (a != null) {
                        gVar.a(a);
                    }
                } else if (id == r.iconWeixinTimeline) {
                    a("share_to_pyq");
                    b(2);
                    f a2 = a(2);
                    if (a2 != null) {
                        gVar.b(a2);
                    }
                } else if (id == r.iconQZone) {
                    a("share_to_qzone");
                    b(4);
                    f a3 = a(4);
                    if (a3 != null) {
                        gVar.c(a3);
                    }
                } else if (id == r.iconQQWeibo) {
                    a("share_to_qweibo");
                    b(5);
                    f a4 = a(5);
                    if (a4 != null) {
                        gVar.d(a4);
                    }
                } else if (id == r.iconSinaWeibo) {
                    a("share_to_sweibo");
                    b(6);
                    f a5 = a(6);
                    if (a5 != null) {
                        gVar.e(a5);
                    }
                } else if (id == r.iconRenren) {
                    a("share_to_renren");
                    b(7);
                    f a6 = a(7);
                    if (a6 != null) {
                        gVar.f(a6);
                    }
                }
            }
        }
    }

    private f a(int i) {
        f fVar = this.q.get(i);
        if (fVar == null) {
            return this.q.get(1);
        }
        return fVar;
    }

    private void b(int i) {
        if (i <= 7 && i > 0) {
            this.r = true;
            if (this.s != null) {
                String str = this.s.get(i);
                if (!be.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        TiebaStatic.eventStat(this.b, str, "click", 1, new Object[0]);
    }

    private void d() {
        a(this.f, q.icon_unite_share_friend, o.share_to, q.icon_unite_share_friend_1, o.share_to_1);
        a(this.g, q.icon_unite_share_weixin, o.share_to, q.icon_unite_share_weixin_1, o.share_to_1);
        a(this.h, q.icon_unite_share_qqzon, o.share_to, q.icon_unite_share_qqzon_1, o.share_to_1);
        a(this.i, q.icon_unite_share_tencent, o.share_to, q.icon_unite_share_tencent_1, o.share_to_1);
        a(this.j, q.icon_unite_share_sina, o.share_to, q.icon_unite_share_sina_1, o.share_to_1);
        a(this.k, q.icon_unite_share_renren, o.share_to, q.icon_unite_share_renren_1, o.share_to_1);
        int paddingLeft = this.d.getPaddingLeft();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.e.setBackgroundResource(q.bg_unite_popup_share_down_1);
            this.d.setBackgroundResource(q.bg_unite_popup_share_up_1);
            this.d.setTextColor(this.b.getResources().getColor(o.share_to_1));
            this.l.setBackgroundResource(q.btn_w_square_1);
            this.l.setTextColor(this.b.getResources().getColor(o.share_to_1));
        } else {
            this.e.setBackgroundResource(q.bg_unite_popup_share_down);
            this.d.setBackgroundResource(q.bg_unite_popup_share_up);
            this.d.setTextColor(this.b.getResources().getColor(o.share_to));
            this.l.setBackgroundResource(q.btn_w_square);
            this.l.setTextColor(this.b.getResources().getColor(o.share_to));
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
