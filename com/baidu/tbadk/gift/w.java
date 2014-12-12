package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private List<GiftCommonList.NumInfo> aaO;
    private Context mContext;

    public w(Context context) {
        this.mContext = context;
    }

    public void s(List<GiftCommonList.NumInfo> list) {
        this.aaO = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaO == null) {
            return 1;
        }
        return this.aaO.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dm */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.aaO == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.aaO.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.gift_num_item, null);
            x xVar2 = new x(this, null);
            xVar2.aaP = (TextView) view.findViewById(com.baidu.tieba.w.text);
            xVar2.aaQ = view.findViewById(com.baidu.tieba.w.divider);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        ax.i(view, com.baidu.tieba.v.list_item_selector);
        ax.b(xVar.aaP, com.baidu.tieba.t.cp_cont_b, 1);
        ax.j(xVar.aaQ, com.baidu.tieba.t.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            xVar.aaP.setText(z.custom_num);
            xVar.aaQ.setVisibility(4);
        } else if (item != null) {
            xVar.aaP.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            xVar.aaQ.setVisibility(0);
        } else {
            xVar.aaP.setText("");
            xVar.aaQ.setVisibility(0);
        }
        return view;
    }
}
