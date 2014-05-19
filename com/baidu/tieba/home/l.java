package com.baidu.tieba.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.ac;
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.x;
import com.baidu.tieba.data.y;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.core.e a;
    private com.baidu.tieba.data.n g;
    private boolean h;
    private boolean i;
    private ab j;
    private View.OnClickListener k;
    private View.OnLongClickListener l;
    private y b = null;
    private am c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private View.OnClickListener m = new m(this);

    public void a(boolean z) {
        this.i = z;
    }

    public l(com.baidu.tbadk.core.e eVar) {
        this.a = null;
        this.a = eVar;
        this.j = new ab(this.a);
        a();
    }

    public void a() {
        this.e = com.baidu.adp.lib.util.h.a((Context) this.a, 8.0f);
        this.d = com.baidu.adp.lib.util.h.a((Context) this.a, 10.0f);
        this.f = com.baidu.adp.lib.util.h.a((Context) this.a, 12.0f);
    }

    public void a(y yVar) {
        this.b = yVar;
    }

    public void a(am amVar) {
        this.c = amVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int size2;
        int i = 0;
        if (this.b == null) {
            return 0;
        }
        if (this.b.a() != null && (size2 = this.b.a().size()) > 0) {
            i = size2 > 500 ? 250 : (size2 + 1) / 2;
        }
        if (this.c != null && this.c.a() != null && (size = this.c.a().size()) > 0) {
            i = size > 500 ? 250 : i + 1 + ((size + 1) / 2);
        }
        if (this.h) {
            i++;
        }
        return this.i ? i + 1 : i;
    }

    public int b() {
        int size;
        if (this.b.a() == null || (size = this.b.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int c() {
        int size;
        if (this.c == null || this.c.a() == null || (size = this.c.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.a().get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int c = (c() + 1) / 2;
        if (this.h && i == 0) {
            return 2;
        }
        if (this.i) {
            if (this.h && i == 1) {
                return 1;
            }
            if (!this.h && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - c) - 1) {
            return 0;
        }
        if (i == (getCount() - c) - 1) {
            return c > 0 ? 4 : 0;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.home_like_guide, (ViewGroup) null);
            if (b() <= 4) {
                inflate.setVisibility(0);
            } else {
                inflate.setVisibility(8);
            }
            inflate.setOnClickListener(this.m);
            a(inflate);
            return inflate;
        } else if (itemViewType == 2) {
            View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.home_like_item_banner, (ViewGroup) null);
            ((BannerView) inflate2.findViewById(com.baidu.tieba.r.home_like_banner_view)).a(this.g.f().a(), this.g.f().b(), "enter_forum_banner_date", 259200000L);
            return inflate2;
        } else if (itemViewType == 0) {
            if (this.h) {
                i--;
            }
            if (this.i) {
                i--;
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (view == null) {
                view = a((s) null);
            }
            s sVar = 0 == 0 ? (s) view.getTag() : null;
            if (sVar != null && this.b != null && this.b.a() != null) {
                this.a.a().a(skinType == 1);
                this.a.a().a(view);
                b(skinType, sVar);
                a(i, sVar);
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), sVar);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        sVar.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), sVar.f);
                        return view;
                    }
                    sVar.f.b.setVisibility(4);
                    return view;
                }
                return view;
            }
            return view;
        } else if (itemViewType == 4) {
            View inflate3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.home_new_recommend_notice, (ViewGroup) null);
            if (c() > 0) {
                inflate3.setVisibility(0);
            } else {
                inflate3.setVisibility(8);
            }
            a(inflate3);
            return inflate3;
        } else if (itemViewType == 3) {
            if (this.h) {
                i--;
            }
            if (this.i) {
                i--;
            }
            int b = (i - 1) - ((b() + 1) / 2);
            int skinType2 = TbadkApplication.m252getInst().getSkinType();
            View a = a((t) null);
            t tVar = 0 == 0 ? (t) a.getTag() : null;
            if (tVar != null && this.c != null && this.c.a() != null) {
                this.a.a().a(skinType2 == 1);
                this.a.a().a(a);
                if (b >= 0) {
                    if (b * 2 < this.c.a().size()) {
                        a(this.c.a().get(b * 2), tVar);
                    }
                    if ((b * 2) + 1 < this.c.a().size()) {
                        tVar.f.b.setVisibility(0);
                        a(this.c.a().get((b * 2) + 1), tVar.f);
                        return a;
                    }
                    tVar.f.b.setVisibility(4);
                    return a;
                }
                return a;
            }
            return a;
        } else {
            return view;
        }
    }

    private void a(View view) {
        this.a.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.a().a(view);
    }

    private void a(int i, s sVar) {
        if (i == 0) {
            sVar.a.setPadding(this.d, this.f, this.d, 0);
        } else {
            sVar.a.setPadding(this.d, this.e, this.d, 0);
        }
    }

    private View a(s sVar) {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.home_like_item, (ViewGroup) null);
        s sVar2 = new s();
        sVar2.a = (LinearLayout) inflate;
        sVar2.e = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_icon_sign1);
        sVar2.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.r.item_left);
        sVar2.b.setOnClickListener(this.k);
        sVar2.b.setOnLongClickListener(this.l);
        sVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.r.home_lv_like_forum1);
        sVar2.d = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_lv_like_grade1);
        sVar2.f = new s();
        sVar2.f.e = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_icon_sign2);
        sVar2.f.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.r.item_right);
        sVar2.f.b.setOnClickListener(this.k);
        sVar2.f.b.setOnLongClickListener(this.l);
        sVar2.f.c = (TextView) inflate.findViewById(com.baidu.tieba.r.home_lv_like_forum2);
        sVar2.f.d = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_lv_like_grade2);
        inflate.setTag(sVar2);
        return inflate;
    }

    private View a(t tVar) {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.home_recommend_item, (ViewGroup) null);
        t tVar2 = new t();
        tVar2.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.home_recommend_container);
        tVar2.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.r.recommend_item_left);
        tVar2.b.setOnClickListener(this.k);
        tVar2.d = (TextView) inflate.findViewById(com.baidu.tieba.r.left_bar_name);
        tVar2.e = (TextView) inflate.findViewById(com.baidu.tieba.r.left_focus_num);
        tVar2.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.left_bar_pic);
        tVar2.f = new t();
        tVar2.f.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.r.recommend_item_right);
        tVar2.f.b.setOnClickListener(this.k);
        tVar2.f.d = (TextView) inflate.findViewById(com.baidu.tieba.r.right_bar_name);
        tVar2.f.e = (TextView) inflate.findViewById(com.baidu.tieba.r.right_focus_num);
        tVar2.f.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.right_bar_pic);
        inflate.setTag(tVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, s sVar) {
        if (sVar != null && sVar.b(i)) {
            if (i == 1) {
                bc.e(sVar.b, com.baidu.tieba.q.home_like_item_bg_1);
                bc.e(sVar.f.b, com.baidu.tieba.q.home_like_item_bg_1);
                return;
            }
            bc.e(sVar.b, com.baidu.tieba.q.home_like_item_bg);
            bc.e(sVar.f.b, com.baidu.tieba.q.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.l = onLongClickListener;
    }

    private void a(x xVar, s sVar) {
        if (xVar != null && sVar != null) {
            int d = xVar.d();
            sVar.b.setTag(xVar);
            sVar.c.setText(xVar.b());
            if (xVar.c() == 0) {
                sVar.e.setVisibility(8);
            } else {
                sVar.e.setVisibility(0);
            }
            if (d == 0) {
                sVar.d.setVisibility(4);
                return;
            }
            sVar.d.setVisibility(0);
            sVar.d.setBackgroundResource(com.baidu.tbadk.core.util.g.b(d));
            sVar.d.setText(String.valueOf(xVar.d()));
        }
    }

    private void a(ac acVar, t tVar) {
        if (acVar != null && tVar != null) {
            tVar.b.setTag(acVar);
            tVar.d.setText(acVar.a());
            tVar.e.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.u.enter_forum_recommend_focus)) + String.valueOf(acVar.b()));
            if (!TextUtils.isEmpty(acVar.c())) {
                tVar.c.setTag(acVar.c());
                this.j.b(acVar.c(), new n(this, tVar));
            }
        }
    }

    public void a(com.baidu.tieba.data.n nVar) {
        this.g = nVar;
        if (nVar.f() != null && nVar.f().a() != null) {
            this.h = true;
        } else {
            this.h = false;
        }
        a(nVar.g());
        a(nVar.b());
        notifyDataSetChanged();
    }
}
