package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private List<GiftCommonList.NumInfo> abp;
    private Context mContext;

    public w(Context context) {
        this.mContext = context;
    }

    public void s(List<GiftCommonList.NumInfo> list) {
        this.abp = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abp == null) {
            return 1;
        }
        return this.abp.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: du */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.abp == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.abp.get(i);
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
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.gift_num_item, null);
            x xVar2 = new x(this, null);
            xVar2.abq = (TextView) view.findViewById(com.baidu.tieba.w.text);
            xVar2.abr = view.findViewById(com.baidu.tieba.w.divider);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        bc.i(view, com.baidu.tieba.v.list_item_selector);
        bc.b(xVar.abq, com.baidu.tieba.t.cp_cont_b, 1);
        bc.j(xVar.abr, com.baidu.tieba.t.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            xVar.abq.setText(z.custom_num);
            xVar.abr.setVisibility(4);
        } else if (item != null) {
            xVar.abq.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            xVar.abr.setVisibility(0);
        } else {
            xVar.abq.setText("");
            xVar.abr.setVisibility(0);
        }
        return view;
    }
}
