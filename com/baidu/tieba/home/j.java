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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1219a;
    private View.OnClickListener h;
    private View.OnLongClickListener i;
    private Boolean b = false;
    private com.baidu.tieba.data.af c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean j = false;

    public j(com.baidu.tieba.j jVar) {
        this.f1219a = null;
        this.f1219a = jVar;
        a();
    }

    public void a() {
        this.d = UtilHelper.a((Context) this.f1219a, 3.0f);
        this.e = UtilHelper.a((Context) this.f1219a, 6.0f);
        this.f = UtilHelper.a((Context) this.f1219a, 10.0f);
        this.g = UtilHelper.a((Context) this.f1219a, 30.0f);
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
        l lVar = null;
        int ap = TiebaApplication.g().ap();
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            if (view == null) {
                view = a((ar) null);
            }
            ar arVar = 0 == 0 ? (ar) view.getTag() : null;
            if (arVar != null && this.c != null && this.c.a() != null) {
                this.f1219a.l().a(ap == 1);
                this.f1219a.l().a(view);
                b(ap, arVar);
                a(i, arVar);
                if (i >= 0) {
                    if (i * 2 < this.c.a().size()) {
                        a(this.c.a().get(i * 2), arVar);
                    }
                    if ((i * 2) + 1 < this.c.a().size()) {
                        arVar.f.b.setVisibility(0);
                        a(this.c.a().get((i * 2) + 1), arVar.f);
                    } else {
                        arVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                lVar = new l(this.f1219a, this.f1219a.getString(R.string.login_block_tip), this.f1219a.getResources().getString(R.string.login_home_tab), 1);
                view = lVar.c();
                view.setTag(lVar);
            }
            if (lVar == null) {
                lVar = (l) view.getTag();
            }
            lVar.b(ap);
        }
        return view;
    }

    private void a(int i, ar arVar) {
        if (i == 0) {
            arVar.f1209a.setPadding(this.e, this.f, this.e, 0);
        } else if (i == getCount() - 1) {
            arVar.f1209a.setPadding(this.e, this.d, this.e, this.g);
        } else {
            arVar.f1209a.setPadding(this.e, this.d, this.e, 0);
        }
    }

    private View a(ar arVar) {
        View inflate = LayoutInflater.from(this.f1219a).inflate(R.layout.home_like_item, (ViewGroup) null);
        ar arVar2 = new ar();
        arVar2.f1209a = (LinearLayout) inflate;
        arVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        arVar2.b = (RelativeLayout) inflate.findViewById(R.id.first);
        arVar2.b.setOnClickListener(this.h);
        arVar2.b.setOnLongClickListener(this.i);
        arVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        arVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        arVar2.f = new ar();
        arVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        arVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.second);
        arVar2.f.b.setOnClickListener(this.h);
        arVar2.f.b.setOnLongClickListener(this.i);
        arVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        arVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(arVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, ar arVar) {
        if (arVar != null && arVar.b(i)) {
            if (i == 1) {
                com.baidu.tieba.util.as.e(arVar.b, (int) R.drawable.home_like_item_bg_1);
                com.baidu.tieba.util.as.e(arVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            com.baidu.tieba.util.as.e(arVar.b, (int) R.drawable.home_like_item_bg);
            com.baidu.tieba.util.as.e(arVar.f.b, (int) R.drawable.home_like_item_bg);
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

    private void a(com.baidu.tieba.data.ae aeVar, ar arVar) {
        if (aeVar != null && arVar != null) {
            int d = aeVar.d();
            arVar.b.setTag(aeVar);
            arVar.c.setText(a(aeVar));
            if (aeVar.c() == 0) {
                arVar.e.setVisibility(4);
            } else {
                arVar.e.setVisibility(0);
            }
            if (d == 0) {
                arVar.d.setVisibility(4);
                return;
            }
            arVar.d.setVisibility(0);
            arVar.d.setBackgroundResource(com.baidu.tieba.util.e.b(d));
            arVar.d.setText(String.valueOf(aeVar.d()));
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
                str = String.valueOf(str) + charAt;
            } else {
                return String.valueOf(str) + "...";
            }
        }
        return str;
    }

    public void a(com.baidu.tieba.data.q qVar) {
        a(this.b);
        a(qVar.a());
    }
}
