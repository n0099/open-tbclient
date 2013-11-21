package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragmentActivity f1449a;
    private View.OnClickListener i;
    private View.OnLongClickListener j;
    private Boolean b = false;
    private com.baidu.tieba.data.ae c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private boolean k = false;

    public n(BaseFragmentActivity baseFragmentActivity) {
        this.f1449a = null;
        this.f1449a = baseFragmentActivity;
        a();
    }

    public void a() {
        this.d = UtilHelper.a((Context) this.f1449a, 3.0f);
        this.e = UtilHelper.a((Context) this.f1449a, 6.0f);
        this.g = UtilHelper.a((Context) this.f1449a, 8.0f);
        this.f = UtilHelper.a((Context) this.f1449a, 10.0f);
        this.h = UtilHelper.a((Context) this.f1449a, 12.0f);
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        this.c = aeVar;
        c();
        notifyDataSetChanged();
    }

    private void c() {
        if (this.c != null && this.c.a() != null && this.c.a().size() > 6) {
            this.k = false;
        } else {
            this.k = true;
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
        s sVar = null;
        int ap = TiebaApplication.g().ap();
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            if (view == null) {
                view = a((cd) null);
            }
            cd cdVar = 0 == 0 ? (cd) view.getTag() : null;
            if (cdVar != null && this.c != null && this.c.a() != null) {
                this.f1449a.a().a(ap == 1);
                this.f1449a.a().a(view);
                b(ap, cdVar);
                a(i, cdVar);
                if (i >= 0) {
                    if (i * 2 < this.c.a().size()) {
                        a(this.c.a().get(i * 2), cdVar);
                    }
                    if ((i * 2) + 1 < this.c.a().size()) {
                        cdVar.f.b.setVisibility(0);
                        a(this.c.a().get((i * 2) + 1), cdVar.f);
                    } else {
                        cdVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                sVar = new s(this.f1449a, this.f1449a.getString(R.string.login_block_tip), this.f1449a.getResources().getString(R.string.login_home_tab), 1);
                view = sVar.e();
                view.setTag(sVar);
            }
            if (sVar == null) {
                sVar = (s) view.getTag();
            }
            sVar.b(ap);
        }
        return view;
    }

    private void a(int i, cd cdVar) {
        if (i == 0) {
            cdVar.f1437a.setPadding(this.f, this.h, this.f, 0);
        } else {
            cdVar.f1437a.setPadding(this.f, this.g, this.f, 0);
        }
    }

    private View a(cd cdVar) {
        View inflate = LayoutInflater.from(this.f1449a).inflate(R.layout.home_like_item, (ViewGroup) null);
        cd cdVar2 = new cd();
        cdVar2.f1437a = (LinearLayout) inflate;
        cdVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        cdVar2.b = (RelativeLayout) inflate.findViewById(R.id.item_left);
        cdVar2.b.setOnClickListener(this.i);
        cdVar2.b.setOnLongClickListener(this.j);
        cdVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        cdVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        cdVar2.f = new cd();
        cdVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        cdVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.item_right);
        cdVar2.f.b.setOnClickListener(this.i);
        cdVar2.f.b.setOnLongClickListener(this.j);
        cdVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        cdVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(cdVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, cd cdVar) {
        if (cdVar != null && cdVar.b(i)) {
            if (i == 1) {
                com.baidu.tieba.util.bd.e(cdVar.b, (int) R.drawable.home_like_item_bg_1);
                com.baidu.tieba.util.bd.e(cdVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            com.baidu.tieba.util.bd.e(cdVar.b, (int) R.drawable.home_like_item_bg);
            com.baidu.tieba.util.bd.e(cdVar.f.b, (int) R.drawable.home_like_item_bg);
        }
    }

    public int b() {
        if (!this.b.booleanValue()) {
            return 0;
        }
        if (this.c == null || this.c.a() == null || this.c.a().size() == 0) {
            return 2;
        }
        if (this.c.a().size() <= 6 && this.k) {
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
        this.i = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.j = onLongClickListener;
    }

    private void a(com.baidu.tieba.data.ad adVar, cd cdVar) {
        if (adVar != null && cdVar != null) {
            int d = adVar.d();
            cdVar.b.setTag(adVar);
            cdVar.c.setText(adVar.b());
            if (adVar.c() == 0) {
                cdVar.e.setVisibility(8);
            } else {
                cdVar.e.setVisibility(0);
            }
            if (d == 0) {
                cdVar.d.setVisibility(4);
                return;
            }
            cdVar.d.setVisibility(0);
            cdVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(d));
            cdVar.d.setText(String.valueOf(adVar.d()));
        }
    }

    public void a(com.baidu.tieba.data.r rVar) {
        a(this.b);
        a(rVar.d());
    }
}
