package com.baidu.tieba.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> So;
    private int aos = t.cp_cont_b;
    private int aot = t.cp_cont_c;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.So = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.So == null) {
            return 0;
        }
        return this.So.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ec */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.So == null || i < 0 || i >= this.So.size()) {
            return null;
        }
        return this.So.get(i);
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
        if (!TextUtils.isEmpty(item.sW()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        i iVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        TbadkCoreApplication.m255getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof i)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.select_friend_group_item, null);
                i iVar2 = new i(this, null);
                iVar2.aoB = (TextView) view.findViewById(w.addresslist_group_item_key);
                iVar2.aaQ = view.findViewById(w.addresslist_group_item_divider);
                view.setTag(iVar2);
                iVar = iVar2;
            } else {
                iVar = (i) view.getTag();
            }
            if (item.sW() != null) {
                iVar.aoB.setText(item.sW());
            }
            ax.b(iVar.aoB, this.aot, 1);
            ax.j(iVar.aaQ, t.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof h)) {
                h hVar2 = new h(this, null);
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.select_friend_child_item, null);
                hVar2.aop = (HeadImageView) view.findViewById(w.addresslist_child_item_icon);
                hVar2.aoq = (TextView) view.findViewById(w.addresslist_child_item_name);
                hVar2.aaQ = view.findViewById(w.addresslist_child_item_divider);
                view.setTag(hVar2);
                hVar = hVar2;
            } else {
                hVar = (h) view.getTag();
            }
            if (item.getUserName() != null) {
                hVar.aoq.setText(item.getUserName());
                hVar.aop.d(item.getUserPortrait(), 12, false);
            }
            ax.b(hVar.aoq, this.aos, 1);
            ax.i(hVar.aaQ, t.cp_bg_line_b);
            ax.i(view, v.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
