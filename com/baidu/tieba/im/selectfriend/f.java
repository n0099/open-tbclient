package com.baidu.tieba.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> Mu;
    private int ahc = s.cp_cont_b;
    private int ahd = s.cp_cont_c;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.Mu = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Mu == null) {
            return 0;
        }
        return this.Mu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dI */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.Mu == null || i < 0 || i >= this.Mu.size()) {
            return null;
        }
        return this.Mu.get(i);
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
        if (!TextUtils.isEmpty(item.pC()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        h hVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        TbadkApplication.m251getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof h)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.select_friend_group_item, null);
                h hVar2 = new h(this, null);
                hVar2.ahk = (TextView) view.findViewById(v.addresslist_group_item_key);
                hVar2.UM = view.findViewById(v.addresslist_group_item_divider);
                view.setTag(hVar2);
                hVar = hVar2;
            } else {
                hVar = (h) view.getTag();
            }
            if (item.pC() != null) {
                hVar.ahk.setText(item.pC());
            }
            aw.b(hVar.ahk, this.ahd, 1);
            aw.i(hVar.UM, s.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof g)) {
                g gVar2 = new g(this, null);
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.select_friend_child_item, null);
                gVar2.agZ = (HeadImageView) view.findViewById(v.addresslist_child_item_icon);
                gVar2.aha = (TextView) view.findViewById(v.addresslist_child_item_name);
                gVar2.UM = view.findViewById(v.addresslist_child_item_divider);
                view.setTag(gVar2);
                gVar = gVar2;
            } else {
                gVar = (g) view.getTag();
            }
            if (item.getUserName() != null) {
                gVar.aha.setText(item.getUserName());
                gVar.agZ.c(item.getUserPortrait(), 12, false);
            }
            aw.b(gVar.aha, this.ahc, 1);
            aw.h(gVar.UM, s.cp_bg_line_b);
            aw.h(view, u.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
