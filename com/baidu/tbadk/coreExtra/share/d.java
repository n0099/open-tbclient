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
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.j;
import com.baidu.tbadk.k;
import com.baidu.tbadk.l;
import com.baidu.tbadk.m;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
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
        this.c = this.a.inflate(k.share_dialog_content, (ViewGroup) null);
        this.d = (TextView) this.c.findViewById(j.share_dialog_title);
        this.e = this.c.findViewById(j.share_dialog_content);
        this.l = (Button) this.c.findViewById(j.btnShareCancel);
        this.l.setOnClickListener(this);
        this.f = (TextView) this.c.findViewById(j.iconWeixinTimeline);
        this.f.setOnClickListener(this);
        this.g = (TextView) this.c.findViewById(j.iconWeixin);
        this.g.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(j.iconQZone);
        this.h.setOnClickListener(this);
        this.i = (TextView) this.c.findViewById(j.iconQQWeibo);
        this.i.setOnClickListener(this);
        this.j = (TextView) this.c.findViewById(j.iconSinaWeibo);
        this.j.setOnClickListener(this);
        this.k = (TextView) this.c.findViewById(j.iconRenren);
        this.k.setOnClickListener(this);
        this.o = (LinearLayout) this.c.findViewById(j.customViewBox);
        this.m = (LinearLayout) this.c.findViewById(j.share_dialog_line_1);
        this.n = (LinearLayout) this.c.findViewById(j.share_dialog_line_2);
        if (((BdSocialShareSdkDelegate) com.baidu.tbplugin.k.a().a(BdSocialShareSdkDelegate.class)) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public final void a(SparseArray<String> sparseArray) {
        this.s = sparseArray;
    }

    public final void a(f fVar, boolean z) {
        Location b = b();
        if (b != null) {
            fVar.e = b;
        }
        this.q.put(1, fVar);
    }

    public final void a(int i, f fVar, boolean z) {
        Location b = b();
        if (b != null) {
            fVar.e = b;
        }
        this.q.put(3, fVar);
    }

    private Location b() {
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

    public final void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            this.o.addView(view);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            this.o.setVisibility(0);
        }
    }

    public final void a() {
        if (!UtilHelper.a()) {
            i.a(this.b, l.share_on_no_network);
            return;
        }
        this.p = new AlertDialog.Builder(this.b).create();
        this.p.setCanceledOnTouchOutside(true);
        this.p.show();
        Window window = this.p.getWindow();
        window.setWindowAnimations(m.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a aVar = this.t;
        if (aVar != null) {
            this.t = aVar;
        }
        window.setContentView(this.c);
        a(this.f, com.baidu.tbadk.i.icon_unite_share_friend, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_friend_1, com.baidu.tbadk.g.share_to_1);
        a(this.g, com.baidu.tbadk.i.icon_unite_share_weixin, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_weixin_1, com.baidu.tbadk.g.share_to_1);
        a(this.h, com.baidu.tbadk.i.icon_unite_share_qqzon, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_qqzon_1, com.baidu.tbadk.g.share_to_1);
        a(this.i, com.baidu.tbadk.i.icon_unite_share_tencent, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_tencent_1, com.baidu.tbadk.g.share_to_1);
        a(this.j, com.baidu.tbadk.i.icon_unite_share_sina, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_sina_1, com.baidu.tbadk.g.share_to_1);
        a(this.k, com.baidu.tbadk.i.icon_unite_share_renren, com.baidu.tbadk.g.share_to, com.baidu.tbadk.i.icon_unite_share_renren_1, com.baidu.tbadk.g.share_to_1);
        int paddingLeft = this.d.getPaddingLeft();
        if (TbadkApplication.j().l() == 1) {
            this.e.setBackgroundResource(com.baidu.tbadk.i.bg_unite_popup_share_down_1);
            this.d.setBackgroundResource(com.baidu.tbadk.i.bg_unite_popup_share_up_1);
            this.d.setTextColor(this.b.getResources().getColor(com.baidu.tbadk.g.share_to_1));
            this.l.setBackgroundResource(com.baidu.tbadk.i.btn_w_square_1);
            this.l.setTextColor(this.b.getResources().getColor(com.baidu.tbadk.g.share_to_1));
        } else {
            this.e.setBackgroundResource(com.baidu.tbadk.i.bg_unite_popup_share_down);
            this.d.setBackgroundResource(com.baidu.tbadk.i.bg_unite_popup_share_up);
            this.d.setTextColor(this.b.getResources().getColor(com.baidu.tbadk.g.share_to));
            this.l.setBackgroundResource(com.baidu.tbadk.i.btn_w_square);
            this.l.setTextColor(this.b.getResources().getColor(com.baidu.tbadk.g.share_to));
        }
        this.d.setPadding(paddingLeft, 0, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.p != null) {
            this.r = false;
            this.p.dismiss();
        }
        if (this.q.size() != 0) {
            if (view.getId() == j.btnShareCancel || !this.r) {
                this.r = true;
                g gVar = new g(this.b, this.t);
                int id = view.getId();
                if (id == j.btnShareCancel) {
                    a("share_cancel");
                    a aVar = this.t;
                } else if (id == j.iconWeixin) {
                    a("share_to_weixin");
                    b(3);
                    f a = a(3);
                    if (a != null) {
                        gVar.a(a);
                    }
                } else if (id == j.iconWeixinTimeline) {
                    a("share_to_pyq");
                    b(2);
                    f a2 = a(2);
                    if (a2 != null) {
                        gVar.b(a2);
                    }
                } else if (id == j.iconQZone) {
                    a("share_to_qzone");
                    b(4);
                    f a3 = a(4);
                    if (a3 != null) {
                        gVar.c(a3);
                    }
                } else if (id == j.iconQQWeibo) {
                    a("share_to_qweibo");
                    b(5);
                    f a4 = a(5);
                    if (a4 != null) {
                        gVar.d(a4);
                    }
                } else if (id == j.iconSinaWeibo) {
                    a("share_to_sweibo");
                    b(6);
                    f a5 = a(6);
                    if (a5 != null) {
                        gVar.e(a5);
                    }
                } else if (id == j.iconRenren) {
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
                if (!bc.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        TiebaStatic.a(this.b, str, "click", 1, new Object[0]);
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int l = TbadkApplication.j().l();
        if (l != 1) {
            i3 = i;
        }
        if (l != 1) {
            i4 = i2;
        }
        Drawable drawable = this.b.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextColor(this.b.getResources().getColor(i4));
    }
}
