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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.ac;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.x;
import com.baidu.tieba.data.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private BaseFragmentActivity a;
    private com.baidu.tieba.data.n g;
    private boolean h;
    private boolean i;
    private ab j;
    private View.OnClickListener k;
    private View.OnLongClickListener l;
    private BannerView m;
    private y b = null;
    private an c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private View.OnClickListener n = new n(this);

    public void a(boolean z) {
        this.i = z;
    }

    public m(BaseFragmentActivity baseFragmentActivity) {
        this.a = null;
        this.a = baseFragmentActivity;
        this.j = new ab(this.a);
        a();
    }

    public void a() {
        this.e = com.baidu.adp.lib.util.k.a((Context) this.a, 8.0f);
        this.d = com.baidu.adp.lib.util.k.a((Context) this.a, 10.0f);
        this.f = com.baidu.adp.lib.util.k.a((Context) this.a, 12.0f);
    }

    public void a(y yVar) {
        this.b = yVar;
    }

    public void a(an anVar) {
        this.c = anVar;
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
            view = LayoutInflater.from(this.a).inflate(w.home_like_guide, (ViewGroup) null);
            if (b() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.n);
            a(view);
        } else if (itemViewType == 2) {
            if (this.m == null) {
                view = LayoutInflater.from(this.a).inflate(w.home_like_item_banner, (ViewGroup) null);
                this.m = (BannerView) view.findViewById(com.baidu.tieba.v.home_like_banner_view);
            }
            this.m.a("enter_bar_bck", "");
            this.m.b(this.g.f().a(), this.g.f().b());
        } else if (itemViewType == 0) {
            if (this.h) {
                i--;
            }
            if (this.i) {
                i--;
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (view == null) {
                view = a((t) null);
            }
            t tVar = 0 == 0 ? (t) view.getTag() : null;
            if (tVar != null && this.b != null && this.b.a() != null) {
                this.a.a().a(skinType == 1);
                this.a.a().a(view);
                b(skinType, tVar);
                a(i, tVar);
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), tVar);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        tVar.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), tVar.f);
                    } else {
                        tVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = LayoutInflater.from(this.a).inflate(w.home_new_recommend_notice, (ViewGroup) null);
            if (c() > 0) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            a(view);
        } else if (itemViewType == 3) {
            if (this.h) {
                i--;
            }
            if (this.i) {
                i--;
            }
            int b = (i - 1) - ((b() + 1) / 2);
            int skinType2 = TbadkApplication.m252getInst().getSkinType();
            view = a((u) null);
            u uVar = 0 == 0 ? (u) view.getTag() : null;
            if (uVar != null && this.c != null && this.c.a() != null) {
                this.a.a().a(skinType2 == 1);
                this.a.a().a(view);
                if (b >= 0) {
                    if (b * 2 < this.c.a().size()) {
                        a(this.c.a().get(b * 2), uVar);
                    }
                    if ((b * 2) + 1 < this.c.a().size()) {
                        uVar.f.b.setVisibility(0);
                        a(this.c.a().get((b * 2) + 1), uVar.f);
                    } else {
                        uVar.f.b.setVisibility(4);
                    }
                }
            }
        }
        return view;
    }

    private void a(View view) {
        this.a.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.a().a(view);
    }

    private void a(int i, t tVar) {
        if (i == 0) {
            tVar.a.setPadding(this.d, this.f, this.d, 0);
        } else {
            tVar.a.setPadding(this.d, this.e, this.d, 0);
        }
    }

    private View a(t tVar) {
        View inflate = LayoutInflater.from(this.a).inflate(w.home_like_item, (ViewGroup) null);
        t tVar2 = new t();
        tVar2.a = (LinearLayout) inflate;
        tVar2.e = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign1);
        tVar2.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_left);
        tVar2.b.setOnClickListener(this.k);
        tVar2.b.setOnLongClickListener(this.l);
        tVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum1);
        tVar2.d = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade1);
        tVar2.f = new t();
        tVar2.f.e = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign2);
        tVar2.f.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_right);
        tVar2.f.b.setOnClickListener(this.k);
        tVar2.f.b.setOnLongClickListener(this.l);
        tVar2.f.c = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum2);
        tVar2.f.d = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade2);
        inflate.setTag(tVar2);
        return inflate;
    }

    private View a(u uVar) {
        View inflate = LayoutInflater.from(this.a).inflate(w.home_recommend_item, (ViewGroup) null);
        u uVar2 = new u();
        uVar2.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.home_recommend_container);
        uVar2.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_left);
        uVar2.b.setOnClickListener(this.k);
        uVar2.d = (TextView) inflate.findViewById(com.baidu.tieba.v.left_bar_name);
        uVar2.e = (TextView) inflate.findViewById(com.baidu.tieba.v.left_focus_num);
        uVar2.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.left_bar_pic);
        uVar2.f = new u();
        uVar2.f.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_right);
        uVar2.f.b.setOnClickListener(this.k);
        uVar2.f.d = (TextView) inflate.findViewById(com.baidu.tieba.v.right_bar_name);
        uVar2.f.e = (TextView) inflate.findViewById(com.baidu.tieba.v.right_focus_num);
        uVar2.f.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.right_bar_pic);
        inflate.setTag(uVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, t tVar) {
        if (tVar != null && tVar.b(i)) {
            if (i == 1) {
                be.e(tVar.b, com.baidu.tieba.u.home_like_item_bg_1);
                be.e(tVar.f.b, com.baidu.tieba.u.home_like_item_bg_1);
                return;
            }
            be.e(tVar.b, com.baidu.tieba.u.home_like_item_bg);
            be.e(tVar.f.b, com.baidu.tieba.u.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.l = onLongClickListener;
    }

    private void a(x xVar, t tVar) {
        if (xVar != null && tVar != null) {
            int d = xVar.d();
            tVar.b.setTag(xVar);
            tVar.c.setText(xVar.b());
            if (xVar.c() == 0) {
                tVar.e.setVisibility(8);
            } else {
                tVar.e.setVisibility(0);
            }
            if (d == 0) {
                tVar.d.setVisibility(4);
                return;
            }
            tVar.d.setVisibility(0);
            tVar.d.setBackgroundResource(com.baidu.tbadk.core.util.g.b(d));
            tVar.d.setText(String.valueOf(xVar.d()));
        }
    }

    private void a(ac acVar, u uVar) {
        if (acVar != null && uVar != null) {
            uVar.b.setTag(acVar);
            uVar.d.setText(acVar.a());
            uVar.e.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.y.enter_forum_recommend_focus)) + String.valueOf(acVar.b()));
            if (!TextUtils.isEmpty(acVar.c())) {
                uVar.c.setTag(acVar.c());
                this.j.b(acVar.c(), new o(this, uVar));
            }
        }
    }

    public void a(com.baidu.tieba.data.n nVar) {
        this.g = nVar;
        if (this.m != null) {
            this.m.b();
        }
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
