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
public class k extends BaseAdapter {
    private BaseFragmentActivity a;
    private com.baidu.tieba.data.af b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private View.OnClickListener f;
    private View.OnLongClickListener g;

    public k(BaseFragmentActivity baseFragmentActivity) {
        this.a = null;
        this.a = baseFragmentActivity;
        a();
    }

    public void a() {
        this.d = com.baidu.adp.lib.g.g.a((Context) this.a, 8.0f);
        this.c = com.baidu.adp.lib.g.g.a((Context) this.a, 10.0f);
        this.e = com.baidu.adp.lib.g.g.a((Context) this.a, 12.0f);
    }

    public void a(com.baidu.tieba.data.af afVar) {
        this.b = afVar;
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
        ca caVar;
        int al = TiebaApplication.h().al();
        if (view == null) {
            view = a((ca) null);
        }
        if (0 != 0) {
            caVar = null;
        } else {
            caVar = (ca) view.getTag();
        }
        if (caVar != null && this.b != null && this.b.a() != null) {
            this.a.a().a(al == 1);
            this.a.a().a(view);
            b(al, caVar);
            a(i, caVar);
            if (i >= 0) {
                if (i * 2 < this.b.a().size()) {
                    a(this.b.a().get(i * 2), caVar);
                }
                if ((i * 2) + 1 < this.b.a().size()) {
                    caVar.f.b.setVisibility(0);
                    a(this.b.a().get((i * 2) + 1), caVar.f);
                } else {
                    caVar.f.b.setVisibility(4);
                }
            }
        }
        return view;
    }

    private void a(int i, ca caVar) {
        if (i == 0) {
            caVar.a.setPadding(this.c, this.e, this.c, 0);
        } else {
            caVar.a.setPadding(this.c, this.d, this.c, 0);
        }
    }

    private View a(ca caVar) {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
        ca caVar2 = new ca();
        caVar2.a = (LinearLayout) inflate;
        caVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        caVar2.b = (RelativeLayout) inflate.findViewById(R.id.item_left);
        caVar2.b.setOnClickListener(this.f);
        caVar2.b.setOnLongClickListener(this.g);
        caVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        caVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        caVar2.f = new ca();
        caVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        caVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.item_right);
        caVar2.f.b.setOnClickListener(this.f);
        caVar2.f.b.setOnLongClickListener(this.g);
        caVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        caVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(caVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, ca caVar) {
        if (caVar != null && caVar.b(i)) {
            if (i == 1) {
                com.baidu.tieba.util.bs.e(caVar.b, (int) R.drawable.home_like_item_bg_1);
                com.baidu.tieba.util.bs.e(caVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            com.baidu.tieba.util.bs.e(caVar.b, (int) R.drawable.home_like_item_bg);
            com.baidu.tieba.util.bs.e(caVar.f.b, (int) R.drawable.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.g = onLongClickListener;
    }

    private void a(com.baidu.tieba.data.ae aeVar, ca caVar) {
        if (aeVar != null && caVar != null) {
            int d = aeVar.d();
            caVar.b.setTag(aeVar);
            caVar.c.setText(aeVar.b());
            if (aeVar.c() == 0) {
                caVar.e.setVisibility(8);
            } else {
                caVar.e.setVisibility(0);
            }
            if (d == 0) {
                caVar.d.setVisibility(4);
                return;
            }
            caVar.d.setVisibility(0);
            caVar.d.setBackgroundResource(com.baidu.tieba.util.n.b(d));
            caVar.d.setText(String.valueOf(aeVar.d()));
        }
    }

    public void a(com.baidu.tieba.data.r rVar) {
        a(rVar.d());
    }
}
