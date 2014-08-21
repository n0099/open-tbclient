package com.baidu.tieba.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private Context a;
    private List<com.baidu.tbadk.coreExtra.relationship.b> b;
    private int c;
    private int d;
    private int e;
    private int f;

    public d(Context context) {
        this.a = context;
        this.c = this.a.getResources().getColor(r.cp_cont_b);
        this.d = this.a.getResources().getColor(r.cp_cont_b_1);
        this.e = this.a.getResources().getColor(r.cp_cont_c);
        this.f = this.a.getResources().getColor(r.cp_cont_c_1);
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (item == null) {
            return 2;
        }
        if (!TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.b()) && TextUtils.isEmpty(item.d())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        f fVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof f)) {
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.select_friend_group_item, null);
                f fVar2 = new f(this, null);
                fVar2.a = (TextView) view.findViewById(u.addresslist_group_item_key);
                fVar2.b = view.findViewById(u.addresslist_group_item_divider);
                view.setTag(fVar2);
                fVar = fVar2;
            } else {
                fVar = (f) view.getTag();
            }
            if (item.f() != null) {
                fVar.a.setText(item.f());
            }
            fVar.a.setTextColor(z ? this.f : this.e);
            fVar.b.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                e eVar2 = new e(this, null);
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.select_friend_child_item, null);
                eVar2.a = (HeadImageView) view.findViewById(u.addresslist_child_item_icon);
                eVar2.b = (TextView) view.findViewById(u.addresslist_child_item_name);
                eVar2.c = view.findViewById(u.addresslist_child_item_divider);
                view.setTag(eVar2);
                eVar = eVar2;
            } else {
                eVar = (e) view.getTag();
            }
            if (item.b() != null) {
                eVar.b.setText(item.b());
                eVar.a.a(item.d(), 12, false);
            }
            eVar.b.setTextColor(z ? this.d : this.c);
            eVar.c.setBackgroundResource(z ? r.cp_bg_line_b_1 : r.cp_bg_line_b);
            view.setBackgroundResource(z ? t.select_friend_item_bg_1 : t.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
