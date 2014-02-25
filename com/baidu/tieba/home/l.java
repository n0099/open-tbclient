package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tieba.k a;
    private boolean f;
    private View.OnClickListener g;
    private View.OnLongClickListener h;
    private com.baidu.tieba.data.ae b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private View.OnClickListener i = new m(this);

    public void a(boolean z) {
        this.f = z;
    }

    public l(com.baidu.tieba.k kVar) {
        this.a = null;
        this.a = kVar;
        a();
    }

    public void a() {
        this.d = BdUtilHelper.a((Context) this.a, 8.0f);
        this.c = BdUtilHelper.a((Context) this.a, 10.0f);
        this.e = BdUtilHelper.a((Context) this.a, 12.0f);
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        this.b = aeVar;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int i = 0;
        if (this.b == null) {
            return 0;
        }
        if (this.b.a() != null && (size = this.b.a().size()) > 0) {
            i = size > 500 ? 250 : (size + 1) / 2;
        }
        return this.f ? i + 1 : i;
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

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.a().get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.f && i == getCount() + (-1)) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 1) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_like_guide, (ViewGroup) null);
            inflate.setOnClickListener(this.i);
            a(inflate);
            return inflate;
        } else if (getItemViewType(i) == 0) {
            int al = TiebaApplication.g().al();
            if (view == null) {
                view = a((ax) null);
            }
            ax axVar = 0 == 0 ? (ax) view.getTag() : null;
            if (axVar != null && this.b != null && this.b.a() != null) {
                this.a.a().a(al == 1);
                this.a.a().a(view);
                b(al, axVar);
                a(i, axVar);
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), axVar);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        axVar.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), axVar.f);
                        return view;
                    }
                    axVar.f.b.setVisibility(4);
                    return view;
                }
                return view;
            }
            return view;
        } else {
            return view;
        }
    }

    private void a(View view) {
        this.a.a().a(TiebaApplication.g().al() == 1);
        this.a.a().a(view);
    }

    private void a(int i, ax axVar) {
        if (i == 0) {
            axVar.a.setPadding(this.c, this.e, this.c, 0);
        } else {
            axVar.a.setPadding(this.c, this.d, this.c, 0);
        }
    }

    private View a(ax axVar) {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
        ax axVar2 = new ax();
        axVar2.a = (LinearLayout) inflate;
        axVar2.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
        axVar2.b = (RelativeLayout) inflate.findViewById(R.id.item_left);
        axVar2.b.setOnClickListener(this.g);
        axVar2.b.setOnLongClickListener(this.h);
        axVar2.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
        axVar2.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
        axVar2.f = new ax();
        axVar2.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
        axVar2.f.b = (RelativeLayout) inflate.findViewById(R.id.item_right);
        axVar2.f.b.setOnClickListener(this.g);
        axVar2.f.b.setOnLongClickListener(this.h);
        axVar2.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
        axVar2.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
        inflate.setTag(axVar2);
        return inflate;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void b(int i, ax axVar) {
        if (axVar != null && axVar.b(i)) {
            if (i == 1) {
                bq.e(axVar.b, (int) R.drawable.home_like_item_bg_1);
                bq.e(axVar.f.b, (int) R.drawable.home_like_item_bg_1);
                return;
            }
            bq.e(axVar.b, (int) R.drawable.home_like_item_bg);
            bq.e(axVar.f.b, (int) R.drawable.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.h = onLongClickListener;
    }

    private void a(com.baidu.tieba.data.ad adVar, ax axVar) {
        if (adVar != null && axVar != null) {
            int d = adVar.d();
            axVar.b.setTag(adVar);
            axVar.c.setText(adVar.b());
            if (adVar.c() == 0) {
                axVar.e.setVisibility(8);
            } else {
                axVar.e.setVisibility(0);
            }
            if (d == 0) {
                axVar.d.setVisibility(4);
                return;
            }
            axVar.d.setVisibility(0);
            axVar.d.setBackgroundResource(com.baidu.tieba.util.n.b(d));
            axVar.d.setText(String.valueOf(adVar.d()));
        }
    }

    public void a(com.baidu.tieba.data.s sVar) {
        a(sVar.e());
    }
}
