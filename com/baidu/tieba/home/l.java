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
public final class l extends BaseAdapter {
    private com.baidu.tieba.k a;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private View.OnClickListener g;
    private View.OnLongClickListener h;
    private com.baidu.tieba.data.ae b = null;
    private View.OnClickListener i = new m(this);

    public final void a(boolean z) {
        this.f = z;
    }

    public l(com.baidu.tieba.k kVar) {
        this.a = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.a = kVar;
        this.d = BdUtilHelper.a((Context) this.a, 8.0f);
        this.c = BdUtilHelper.a((Context) this.a, 10.0f);
        this.e = BdUtilHelper.a((Context) this.a, 12.0f);
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
        return this.f ? i + 1 : i;
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
        return (this.f && i == getCount() + (-1)) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        if (getItemViewType(i) == 1) {
            view = LayoutInflater.from(this.a).inflate(R.layout.home_like_guide, (ViewGroup) null);
            view.setOnClickListener(this.i);
            this.a.a().a(TiebaApplication.g().ae() == 1);
            this.a.a().a(view);
        } else if (getItemViewType(i) == 0) {
            int ae = TiebaApplication.g().ae();
            if (view == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
                ax axVar = new ax();
                axVar.a = (LinearLayout) inflate;
                axVar.e = (TextView) inflate.findViewById(R.id.forum_icon_sign1);
                axVar.b = (RelativeLayout) inflate.findViewById(R.id.item_left);
                axVar.b.setOnClickListener(this.g);
                axVar.b.setOnLongClickListener(this.h);
                axVar.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
                axVar.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
                axVar.f = new ax();
                axVar.f.e = (TextView) inflate.findViewById(R.id.forum_icon_sign2);
                axVar.f.b = (RelativeLayout) inflate.findViewById(R.id.item_right);
                axVar.f.b.setOnClickListener(this.g);
                axVar.f.b.setOnLongClickListener(this.h);
                axVar.f.c = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
                axVar.f.d = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
                inflate.setTag(axVar);
                view = inflate;
            }
            ax axVar2 = (ax) view.getTag();
            if (axVar2 != null && this.b != null && this.b.a() != null) {
                this.a.a().a(ae == 1);
                this.a.a().a(view);
                if (axVar2 != null) {
                    if (ae == axVar2.a()) {
                        z = false;
                    } else {
                        axVar2.a(ae);
                        z = true;
                    }
                    if (z) {
                        if (ae == 1) {
                            bq.e(axVar2.b, (int) R.drawable.home_like_item_bg_1);
                            bq.e(axVar2.f.b, (int) R.drawable.home_like_item_bg_1);
                        } else {
                            bq.e(axVar2.b, (int) R.drawable.home_like_item_bg);
                            bq.e(axVar2.f.b, (int) R.drawable.home_like_item_bg);
                        }
                    }
                }
                if (i == 0) {
                    axVar2.a.setPadding(this.c, this.e, this.c, 0);
                } else {
                    axVar2.a.setPadding(this.c, this.d, this.c, 0);
                }
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), axVar2);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        axVar2.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), axVar2.f);
                    } else {
                        axVar2.f.b.setVisibility(4);
                    }
                }
            }
        }
        return view;
    }

    public final void b() {
        notifyDataSetChanged();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.h = onLongClickListener;
    }

    private static void a(com.baidu.tieba.data.ad adVar, ax axVar) {
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

    public final void a(com.baidu.tieba.data.s sVar) {
        this.b = sVar.e();
        notifyDataSetChanged();
    }
}
