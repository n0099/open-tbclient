package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.data.x;
import com.baidu.tieba.data.y;
/* loaded from: classes.dex */
public final class l extends BaseAdapter {
    private com.baidu.tbadk.core.e a;
    private int c;
    private int d;
    private int e;
    private com.baidu.tieba.data.n f;
    private boolean g;
    private boolean h;
    private View.OnClickListener i;
    private View.OnLongClickListener j;
    private y b = null;
    private View.OnClickListener k = new m(this);

    public final void a(boolean z) {
        this.h = z;
    }

    public l(com.baidu.tbadk.core.e eVar) {
        this.a = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.a = eVar;
        this.d = com.baidu.adp.lib.util.i.a((Context) this.a, 8.0f);
        this.c = com.baidu.adp.lib.util.i.a((Context) this.a, 10.0f);
        this.e = com.baidu.adp.lib.util.i.a((Context) this.a, 12.0f);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int size;
        int i = 0;
        if (this.b == null) {
            return 0;
        }
        if (this.b.a() != null && (size = this.b.a().size()) > 0) {
            if (size > 500) {
                i = 250;
            } else {
                i = (size + 1) / 2;
            }
        }
        if (this.g) {
            i++;
        }
        return this.h ? i + 1 : i;
    }

    public final int a() {
        int size;
        if (this.b.a() == null || (size = this.b.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.b.a().get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.h && i == getCount() - 1) {
            return 1;
        }
        if (this.g && i == 0) {
            return 2;
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        if (getItemViewType(i) == 1) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.home_like_guide, (ViewGroup) null);
            inflate.setOnClickListener(this.k);
            this.a.b().a(TbadkApplication.j().l() == 1);
            this.a.b().a(inflate);
            return inflate;
        } else if (getItemViewType(i) == 2) {
            View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.home_like_item_banner, (ViewGroup) null);
            ((BannerView) inflate2.findViewById(com.baidu.tieba.a.h.home_like_banner_view)).a(this.f.e().a(), this.f.e().b(), "enter_forum_banner_date", 259200000L);
            return inflate2;
        } else if (getItemViewType(i) == 0) {
            if (this.g) {
                i--;
            }
            int l = TbadkApplication.j().l();
            if (view == null) {
                View inflate3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.home_like_item, (ViewGroup) null);
                r rVar = new r();
                rVar.a = (LinearLayout) inflate3;
                rVar.e = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.forum_icon_sign1);
                rVar.b = (RelativeLayout) inflate3.findViewById(com.baidu.tieba.a.h.item_left);
                rVar.b.setOnClickListener(this.i);
                rVar.b.setOnLongClickListener(this.j);
                rVar.c = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.home_lv_like_forum1);
                rVar.d = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.forum_lv_like_grade1);
                rVar.f = new r();
                rVar.f.e = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.forum_icon_sign2);
                rVar.f.b = (RelativeLayout) inflate3.findViewById(com.baidu.tieba.a.h.item_right);
                rVar.f.b.setOnClickListener(this.i);
                rVar.f.b.setOnLongClickListener(this.j);
                rVar.f.c = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.home_lv_like_forum2);
                rVar.f.d = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.forum_lv_like_grade2);
                inflate3.setTag(rVar);
                view = inflate3;
            }
            r rVar2 = (r) view.getTag();
            if (rVar2 != null && this.b != null && this.b.a() != null) {
                this.a.b().a(l == 1);
                this.a.b().a(view);
                if (rVar2 != null) {
                    if (l == rVar2.a()) {
                        z = false;
                    } else {
                        rVar2.a(l);
                        z = true;
                    }
                    if (z) {
                        if (l == 1) {
                            ba.e(rVar2.b, com.baidu.tieba.a.g.home_like_item_bg_1);
                            ba.e(rVar2.f.b, com.baidu.tieba.a.g.home_like_item_bg_1);
                        } else {
                            ba.e(rVar2.b, com.baidu.tieba.a.g.home_like_item_bg);
                            ba.e(rVar2.f.b, com.baidu.tieba.a.g.home_like_item_bg);
                        }
                    }
                }
                if (i == 0) {
                    rVar2.a.setPadding(this.c, this.e, this.c, 0);
                } else {
                    rVar2.a.setPadding(this.c, this.d, this.c, 0);
                }
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), rVar2);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        rVar2.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), rVar2.f);
                        return view;
                    }
                    rVar2.f.b.setVisibility(4);
                    return view;
                }
                return view;
            }
            return view;
        } else {
            return view;
        }
    }

    public final void b() {
        notifyDataSetChanged();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.j = onLongClickListener;
    }

    private static void a(x xVar, r rVar) {
        if (xVar != null && rVar != null) {
            int d = xVar.d();
            rVar.b.setTag(xVar);
            rVar.c.setText(xVar.b());
            if (xVar.c() == 0) {
                rVar.e.setVisibility(8);
            } else {
                rVar.e.setVisibility(0);
            }
            if (d == 0) {
                rVar.d.setVisibility(4);
                return;
            }
            rVar.d.setVisibility(0);
            rVar.d.setBackgroundResource(com.baidu.tbadk.core.util.g.b(d));
            rVar.d.setText(String.valueOf(xVar.d()));
        }
    }

    public final void a(com.baidu.tieba.data.n nVar) {
        this.f = nVar;
        if (nVar.e() != null && nVar.e().a() != null) {
            this.g = true;
        } else {
            this.g = false;
        }
        this.b = nVar.f();
        notifyDataSetChanged();
    }
}
