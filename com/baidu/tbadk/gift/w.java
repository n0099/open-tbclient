package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.gift.GiftCommonList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private List<GiftCommonList.NumInfo> UK;
    private Context mContext;

    public w(Context context) {
        this.mContext = context;
    }

    public void o(List<GiftCommonList.NumInfo> list) {
        this.UK = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.UK == null) {
            return 1;
        }
        return this.UK.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cO */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.UK == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.UK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == getCount() + (-1) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        x xVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.gift_num_item, null);
            x xVar2 = new x(this, null);
            xVar2.UL = (TextView) view.findViewById(com.baidu.tieba.v.text);
            xVar2.UM = view.findViewById(com.baidu.tieba.v.divider);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        aw.h(view, com.baidu.tieba.u.list_item_selector);
        aw.b(xVar.UL, com.baidu.tieba.s.cp_cont_b, 1);
        aw.i(xVar.UM, com.baidu.tieba.s.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            xVar.UL.setText(com.baidu.tieba.y.custom_num);
            xVar.UM.setVisibility(4);
        } else if (item != null) {
            xVar.UL.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            xVar.UM.setVisibility(0);
        } else {
            xVar.UL.setText("");
            xVar.UM.setVisibility(0);
        }
        return view;
    }
}
