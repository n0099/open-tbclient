package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context a;
    private List<com.baidu.tbadk.coreExtra.relationship.b> b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private int h;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.a = context;
        this.e = this.a.getResources().getColor(r.cp_cont_b);
        this.f = this.a.getResources().getColor(r.cp_cont_b_1);
        this.g = this.a.getResources().getColor(r.cp_cont_c);
        this.h = this.a.getResources().getColor(r.cp_cont_c_1);
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(boolean z) {
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 3;
        }
        return this.b.size() + 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (i < 3 || i >= getCount()) {
            return null;
        }
        return this.b.get(i - 3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 5;
        }
        if (i != 2) {
            if (item == null) {
                return 4;
            }
            return (!TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.b()) && TextUtils.isEmpty(item.d())) ? 2 : 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.a = (ImageView) view.findViewById(u.addresslist_new_friend_icon);
                dVar4.b = (ImageView) view.findViewById(u.addresslist_new_friend_new_icon);
                dVar4.c = (TextView) view.findViewById(u.addresslist_new_friend_text);
                dVar4.d = view.findViewById(u.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            dVar3.a.setImageResource(z ? t.icon_new_friend_1 : t.icon_new_friend);
            if (this.d) {
                dVar3.b.setVisibility(0);
                dVar3.b.setImageResource(z ? t.icon_news_down_bar_one_1 : t.icon_news_down_bar_one);
            } else {
                dVar3.b.setVisibility(8);
            }
            dVar3.c.setTextColor(z ? this.f : this.e);
            dVar3.d.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
            view.setBackgroundResource(z ? t.addresslist_item_bg_1 : t.addresslist_item_bg);
            a((TextView) view.findViewById(u.addresslist_new_friend_message), this.c);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.a = (ImageView) view.findViewById(u.addresslist_new_friend_icon);
                dVar5.b = (ImageView) view.findViewById(u.addresslist_new_friend_new_icon);
                dVar5.c = (TextView) view.findViewById(u.addresslist_new_friend_text);
                dVar5.d = view.findViewById(u.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            dVar2.a.setImageResource(z ? t.icon_add_friend_1 : t.icon_add_friend);
            dVar2.b.setVisibility(8);
            dVar2.c.setTextColor(z ? this.f : this.e);
            dVar2.c.setText(this.a.getResources().getString(x.find_new_friend));
            dVar2.d.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
            view.setBackgroundResource(z ? t.addresslist_item_bg_1 : t.addresslist_item_bg);
            ((TextView) view.findViewById(u.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.a = (ImageView) view.findViewById(u.addresslist_my_groups_icon);
                dVar6.c = (TextView) view.findViewById(u.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.a.setImageResource(z ? t.icon_me_group_1 : t.icon_me_group);
            dVar.c.setTextColor(z ? this.f : this.e);
            view.setBackgroundResource(z ? t.addresslist_item_bg_1 : t.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.e.b.a().a(this.a, v.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.a = (TextView) view.findViewById(u.addresslist_group_item_key);
                    cVar2.b = view.findViewById(u.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.f() != null) {
                    cVar.a.setText(item.f());
                }
                cVar.a.setTextColor(z ? this.h : this.g);
                cVar.b.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.e.b.a().a(this.a, v.addresslist_child_item, null);
                    bVar2.a = (HeadImageView) view.findViewById(u.addresslist_child_item_icon);
                    bVar2.b = (TextView) view.findViewById(u.addresslist_child_item_name);
                    bVar2.c = view.findViewById(u.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.b() != null) {
                    bVar.b.setText(item.b());
                    bVar.a.a(item.d(), 12, false);
                }
                bVar.b.setTextColor(z ? this.f : this.e);
                bVar.c.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
                view.setBackgroundResource(z ? t.addresslist_item_bg_1 : t.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    private void a(TextView textView, int i) {
        int i2;
        int i3;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setVisibility(0);
        textView.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(z ? r.top_msg_num_night : r.top_msg_num_day));
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = t.icon_news_head_prompt_one;
            i3 = t.icon_news_head_prompt_one_1;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = t.icon_news_head_prompt_two;
            i3 = t.icon_news_head_prompt_two_1;
        } else {
            textView.setText("99+");
            i2 = t.icon_news_head_prompt_two;
            i3 = t.icon_news_head_prompt_two_1;
        }
        textView.setBackgroundResource(z ? i3 : i2);
    }
}
