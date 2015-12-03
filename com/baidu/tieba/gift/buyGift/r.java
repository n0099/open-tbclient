package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private List<GiftCommonList.NumInfo> buR;
    private Context mContext;

    public r(Context context) {
        this.mContext = context;
    }

    public void aK(List<GiftCommonList.NumInfo> list) {
        this.buR = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.buR == null) {
            return 1;
        }
        return this.buR.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hs */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.buR == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.buR.get(i);
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
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.gift_num_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.buS = (TextView) view.findViewById(n.f.text);
            aVar2.Yb = view.findViewById(n.f.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        as.i(view, n.e.list_item_selector);
        as.b(aVar.buS, n.c.cp_cont_b, 1);
        as.j(aVar.Yb, n.c.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.buS.setText(n.i.custom_num);
            aVar.Yb.setVisibility(4);
        } else if (item != null) {
            aVar.buS.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            aVar.Yb.setVisibility(0);
        } else {
            aVar.buS.setText("");
            aVar.Yb.setVisibility(0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public View Yb;
        public TextView buS;

        private a() {
        }

        /* synthetic */ a(r rVar, a aVar) {
            this();
        }
    }
}
