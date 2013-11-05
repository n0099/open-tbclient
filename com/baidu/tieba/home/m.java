package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1362a;
    private View.OnClickListener h;
    private View.OnLongClickListener i;
    private Boolean b = false;
    private com.baidu.tieba.data.af c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean j = false;

    public m(com.baidu.tieba.j jVar) {
        this.f1362a = null;
        this.f1362a = jVar;
        a();
    }

    public void a() {
        this.d = UtilHelper.a((Context) this.f1362a, 3.0f);
        this.e = UtilHelper.a((Context) this.f1362a, 6.0f);
        this.f = UtilHelper.a((Context) this.f1362a, 10.0f);
        this.g = UtilHelper.a((Context) this.f1362a, 30.0f);
    }

    public void a(com.baidu.tieba.data.af afVar) {
        this.c = afVar;
        c();
        notifyDataSetChanged();
    }

    private void c() {
        if (this.c != null && this.c.a() != null && this.c.a().size() > 6) {
            this.j = false;
        } else {
            this.j = true;
        }
    }

    public void a(Boolean bool) {
        this.b = bool;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.c == null) {
            return 0;
        }
        if (this.b.booleanValue()) {
            if (this.c.a() == null || (size = this.c.a().size()) <= 0) {
                return 0;
            }
            if (size > 500) {
                return 250;
            }
            return (size + 1) / 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = null;
        int as = TiebaApplication.g().as();
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            if (view == null) {
                view = a((ay) null);
            }
            ay ayVar = 0 == 0 ? (ay) view.getTag() : null;
            if (ayVar != null && this.c != null && this.c.a() != null) {
                this.f1362a.m().a(as == 1);
                this.f1362a.m().a(view);
                b(as, ayVar);
                a(i, ayVar);
                if (i >= 0) {
                    if (i * 2 < this.c.a().size()) {
                        a(this.c.a().get(i * 2), ayVar);
                    }
                    if ((i * 2) + 1 < this.c.a().size()) {
                        ayVar.f.b.setVisibility(0);
                        a(this.c.a().get((i * 2) + 1), ayVar.f);
                    } else {
                        ayVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                pVar = new p(this.f1362a, this.f1362a.getString(R.string.login_block_tip), this.f1362a.getResources().getString(R.string.login_home_tab), 1);
                view = pVar.e();
                view.setTag(pVar);
            }
            if (pVar == null) {
                pVar = (p) view.getTag();
            }
            pVar.b(as);
        }
        return view;
    }

    private void a(int i, ay ayVar) {
        if (i == 0) {
            ayVar.f1349a.setPadding(this.e, this.f, this.e, 0);
        } else if (i == getCount() - 1) {
            ayVar.f1349a.setPadding(this.e, this.d, this.e, this.g);
        } else {
            ayVar.f1349a.setPadding(this.e, this.d, this.e, 0);
        }
    }

    private View a(ay ayVar) {
        View inflate = LayoutInflater.from(this.f1362a).inflate(R.layout.home_like_item, (ViewGroup) null);
        ay ayVar2 = new ay();
        ayVar2.f1349a = (LinearLayout) inflate;
        ayVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        ayVar2.b = (RelativeLayout) inflate.findViewById(R.id.first);
        ayVar2.b.setOnClickListener(this.h);
        ayVar2.b.setOnLongClickListener(this.i);
        ayVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        ayVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        ayVar2.f = new ay();
        ayVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        ayVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.second);
        ayVar2.f.b.setOnClickListener(this.h);
        ayVar2.f.b.setOnLongClickListener(this.i);
        ayVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        ayVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(ayVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, ay ayVar) {
        if (ayVar != null && ayVar.b(i)) {
            if (i == 1) {
                bb.e(ayVar.b, (int) R.drawable.home_like_item_bg_1);
                bb.e(ayVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            bb.e(ayVar.b, (int) R.drawable.home_like_item_bg);
            bb.e(ayVar.f.b, (int) R.drawable.home_like_item_bg);
        }
    }

    public int b() {
        if (!this.b.booleanValue()) {
            return 0;
        }
        if (this.c == null || this.c.a() == null || this.c.a().size() == 0) {
            return 2;
        }
        if (this.c.a().size() <= 6 && this.j) {
            return 3;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return !this.b.booleanValue() ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.i = onLongClickListener;
    }

    private void a(com.baidu.tieba.data.ae aeVar, ay ayVar) {
        if (aeVar != null && ayVar != null) {
            int d = aeVar.d();
            ayVar.b.setTag(aeVar);
            ayVar.c.setText(a(aeVar));
            if (aeVar.c() == 0) {
                ayVar.e.setVisibility(4);
            } else {
                ayVar.e.setVisibility(0);
            }
            if (d == 0) {
                ayVar.d.setVisibility(4);
                return;
            }
            ayVar.d.setVisibility(0);
            ayVar.d.setBackgroundResource(com.baidu.tieba.util.e.b(d));
            ayVar.d.setText(String.valueOf(aeVar.d()));
        }
    }

    private String a(com.baidu.tieba.data.ae aeVar) {
        String b = aeVar.b();
        double d = 0.0d;
        String str = "";
        for (int i = 0; i < b.length(); i++) {
            char charAt = b.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                d += 0.5d;
            } else {
                d += 1.0d;
            }
            if (d <= 5.0d) {
                str = str + charAt;
            } else {
                return str + "...";
            }
        }
        return str;
    }

    public void a(com.baidu.tieba.data.r rVar) {
        a(this.b);
        a(rVar.a());
    }
}
