package com.baidu.tieba.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> SQ;
    private int apl = t.cp_cont_b;
    private int apm = t.cp_cont_c;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.SQ = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SQ == null) {
            return 0;
        }
        return this.SQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ei */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (this.SQ == null || i < 0 || i >= this.SQ.size()) {
            return null;
        }
        return this.SQ.get(i);
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
        if (!TextUtils.isEmpty(item.th()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
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
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.select_friend_group_item, null);
                i iVar2 = new i(this, null);
                iVar2.apv = (TextView) view.findViewById(w.addresslist_group_item_key);
                iVar2.abo = view.findViewById(w.addresslist_group_item_divider);
                view.setTag(iVar2);
                iVar = iVar2;
            } else {
                iVar = (i) view.getTag();
            }
            if (item.th() != null) {
                iVar.apv.setText(item.th());
            }
            bc.b(iVar.apv, this.apm, 1);
            bc.j(iVar.abo, t.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof h)) {
                h hVar2 = new h(this, null);
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.select_friend_child_item, null);
                hVar2.aph = (HeadImageView) view.findViewById(w.addresslist_child_item_icon);
                hVar2.apj = (TextView) view.findViewById(w.addresslist_child_item_name);
                hVar2.abo = view.findViewById(w.addresslist_child_item_divider);
                view.setTag(hVar2);
                hVar = hVar2;
            } else {
                hVar = (h) view.getTag();
            }
            if (item.getUserName() != null) {
                hVar.apj.setText(item.getUserName());
                hVar.aph.d(item.getUserPortrait(), 12, false);
            }
            bc.b(hVar.apj, this.apl, 1);
            bc.i(hVar.abo, t.cp_bg_line_b);
            bc.i(view, v.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
