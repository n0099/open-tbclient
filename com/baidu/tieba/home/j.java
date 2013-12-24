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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private BaseFragmentActivity a;
    private com.baidu.tieba.data.ae b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private View.OnClickListener f;
    private View.OnLongClickListener g;

    public j(BaseFragmentActivity baseFragmentActivity) {
        this.a = null;
        this.a = baseFragmentActivity;
        a();
    }

    public void a() {
        this.d = com.baidu.adp.lib.h.g.a((Context) this.a, 8.0f);
        this.c = com.baidu.adp.lib.h.g.a((Context) this.a, 10.0f);
        this.e = com.baidu.adp.lib.h.g.a((Context) this.a, 12.0f);
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        this.b = aeVar;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.b == null || this.b.a() == null || (size = this.b.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 250;
        }
        return (size + 1) / 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        by byVar;
        int an = TiebaApplication.h().an();
        if (view == null) {
            view = a((by) null);
        }
        if (0 != 0) {
            byVar = null;
        } else {
            byVar = (by) view.getTag();
        }
        if (byVar != null && this.b != null && this.b.a() != null) {
            this.a.a().a(an == 1);
            this.a.a().a(view);
            b(an, byVar);
            a(i, byVar);
            if (i >= 0) {
                if (i * 2 < this.b.a().size()) {
                    a(this.b.a().get(i * 2), byVar);
                }
                if ((i * 2) + 1 < this.b.a().size()) {
                    byVar.f.b.setVisibility(0);
                    a(this.b.a().get((i * 2) + 1), byVar.f);
                } else {
                    byVar.f.b.setVisibility(4);
                }
            }
        }
        return view;
    }

    private void a(int i, by byVar) {
        if (i == 0) {
            byVar.a.setPadding(this.c, this.e, this.c, 0);
        } else {
            byVar.a.setPadding(this.c, this.d, this.c, 0);
        }
    }

    private View a(by byVar) {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
        by byVar2 = new by();
        byVar2.a = (LinearLayout) inflate;
        byVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        byVar2.b = (RelativeLayout) inflate.findViewById(R.id.item_left);
        byVar2.b.setOnClickListener(this.f);
        byVar2.b.setOnLongClickListener(this.g);
        byVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        byVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        byVar2.f = new by();
        byVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        byVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.item_right);
        byVar2.f.b.setOnClickListener(this.f);
        byVar2.f.b.setOnLongClickListener(this.g);
        byVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        byVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(byVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, by byVar) {
        if (byVar != null && byVar.b(i)) {
            if (i == 1) {
                com.baidu.tieba.util.bb.e(byVar.b, (int) R.drawable.home_like_item_bg_1);
                com.baidu.tieba.util.bb.e(byVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            com.baidu.tieba.util.bb.e(byVar.b, (int) R.drawable.home_like_item_bg);
            com.baidu.tieba.util.bb.e(byVar.f.b, (int) R.drawable.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.g = onLongClickListener;
    }

    private void a(com.baidu.tieba.data.ad adVar, by byVar) {
        if (adVar != null && byVar != null) {
            int d = adVar.d();
            byVar.b.setTag(adVar);
            byVar.c.setText(adVar.b());
            if (adVar.c() == 0) {
                byVar.e.setVisibility(8);
            } else {
                byVar.e.setVisibility(0);
            }
            if (d == 0) {
                byVar.d.setVisibility(4);
                return;
            }
            byVar.d.setVisibility(0);
            byVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(d));
            byVar.d.setText(String.valueOf(adVar.d()));
        }
    }

    public void a(com.baidu.tieba.data.r rVar) {
        a(rVar.d());
    }
}
