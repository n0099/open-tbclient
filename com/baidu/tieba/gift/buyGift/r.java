package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private List<GiftCommonList.NumInfo> bno;
    private Context mContext;

    public r(Context context) {
        this.mContext = context;
    }

    public void aD(List<GiftCommonList.NumInfo> list) {
        this.bno = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bno == null) {
            return 1;
        }
        return this.bno.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gP */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.bno == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.bno.get(i);
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
            view = LayoutInflater.from(this.mContext).inflate(i.g.gift_num_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bnp = (TextView) view.findViewById(i.f.text);
            aVar2.Xo = view.findViewById(i.f.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        an.i(view, i.e.list_item_selector);
        an.b(aVar.bnp, i.c.cp_cont_b, 1);
        an.j(aVar.Xo, i.c.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.bnp.setText(i.h.custom_num);
            aVar.Xo.setVisibility(4);
        } else if (item != null) {
            aVar.bnp.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            aVar.Xo.setVisibility(0);
        } else {
            aVar.bnp.setText("");
            aVar.Xo.setVisibility(0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public View Xo;
        public TextView bnp;

        private a() {
        }

        /* synthetic */ a(r rVar, a aVar) {
            this();
        }
    }
}
