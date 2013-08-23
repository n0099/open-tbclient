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
    private com.baidu.tieba.g f1187a;
    private View.OnClickListener h;
    private View.OnLongClickListener i;
    private Boolean b = false;
    private com.baidu.tieba.data.af c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean j = false;

    public j(com.baidu.tieba.g gVar) {
        this.f1187a = null;
        this.f1187a = gVar;
        a();
    }

    public void a() {
        this.d = UtilHelper.a((Context) this.f1187a, 3.0f);
        this.e = UtilHelper.a((Context) this.f1187a, 6.0f);
        this.f = UtilHelper.a((Context) this.f1187a, 10.0f);
        this.g = UtilHelper.a((Context) this.f1187a, 30.0f);
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
        z zVar = null;
        int an = TiebaApplication.g().an();
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            if (view == null) {
                view = a((bf) null);
            }
            bf bfVar = 0 == 0 ? (bf) view.getTag() : null;
            if (bfVar != null && this.c != null && this.c.a() != null) {
                b(an, bfVar);
                a(i, bfVar);
                if (i >= 0) {
                    if (i * 2 < this.c.a().size()) {
                        a((com.baidu.tieba.data.ae) this.c.a().get(i * 2), bfVar);
                    }
                    if ((i * 2) + 1 < this.c.a().size()) {
                        bfVar.f.b.setVisibility(0);
                        a((com.baidu.tieba.data.ae) this.c.a().get((i * 2) + 1), bfVar.f);
                    } else {
                        bfVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                zVar = new z(this.f1187a, this.f1187a.getString(R.string.login_block_tip), this.f1187a.getResources().getString(R.string.login_home_tab), 1);
                view = zVar.c();
                view.setTag(zVar);
            }
            if (zVar == null) {
                zVar = (z) view.getTag();
            }
            zVar.b(an);
        }
        return view;
    }

    private void a(int i, bf bfVar) {
        if (i == 0) {
            bfVar.f1178a.setPadding(this.e, this.f, this.e, 0);
        } else if (i == getCount() - 1) {
            bfVar.f1178a.setPadding(this.e, this.d, this.e, this.g);
        } else {
            bfVar.f1178a.setPadding(this.e, this.d, this.e, 0);
        }
    }

    private View a(bf bfVar) {
        View inflate = LayoutInflater.from(this.f1187a).inflate(R.layout.home_like_item, (ViewGroup) null);
        bf bfVar2 = new bf();
        bfVar2.f1178a = (LinearLayout) inflate;
        bfVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        bfVar2.b = (RelativeLayout) inflate.findViewById(R.id.first);
        bfVar2.b.setOnClickListener(this.h);
        bfVar2.b.setOnLongClickListener(this.i);
        bfVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        bfVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        bfVar2.f = new bf();
        bfVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        bfVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.second);
        bfVar2.f.b.setOnClickListener(this.h);
        bfVar2.f.b.setOnLongClickListener(this.i);
        bfVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        bfVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(bfVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, bf bfVar) {
        if (bfVar != null && bfVar.b(i)) {
            if (i == 1) {
                com.baidu.tieba.util.ao.g(bfVar.b, (int) R.drawable.home_like_item_bg_1);
                bfVar.e.setBackgroundResource(R.drawable.ico_sign_1);
                bfVar.f.e.setBackgroundResource(R.drawable.ico_sign_1);
                bfVar.c.setTextColor(-8682095);
                com.baidu.tieba.util.ao.g(bfVar.f.b, (int) R.drawable.home_like_item_bg_1);
                bfVar.f.c.setTextColor(-8682095);
                bfVar.d.setTextColor(-2171170);
                bfVar.f.d.setTextColor(-2171170);
                return;
            }
            com.baidu.tieba.util.ao.g(bfVar.b, (int) R.drawable.home_like_item_bg);
            bfVar.e.setBackgroundResource(R.drawable.ico_sign);
            bfVar.f.e.setBackgroundResource(R.drawable.ico_sign);
            bfVar.c.setTextColor(-14277082);
            com.baidu.tieba.util.ao.g(bfVar.f.b, (int) R.drawable.home_like_item_bg);
            bfVar.f.c.setTextColor(-14277082);
            bfVar.d.setTextColor(-1);
            bfVar.f.d.setTextColor(-1);
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

    private void a(com.baidu.tieba.data.ae aeVar, bf bfVar) {
        if (aeVar != null && bfVar != null) {
            int d = aeVar.d();
            bfVar.b.setTag(aeVar);
            bfVar.c.setText(a(aeVar));
            if (aeVar.c() == 0) {
                bfVar.e.setVisibility(4);
            } else {
                bfVar.e.setVisibility(0);
            }
            if (d == 0) {
                bfVar.d.setVisibility(4);
                return;
            }
            bfVar.d.setVisibility(0);
            bfVar.d.setBackgroundResource(com.baidu.tieba.util.e.b(d));
            bfVar.d.setText(String.valueOf(aeVar.d()));
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
