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
    private List<GiftCommonList.NumInfo> bmK;
    private Context mContext;

    public r(Context context) {
        this.mContext = context;
    }

    public void az(List<GiftCommonList.NumInfo> list) {
        this.bmK = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bmK == null) {
            return 1;
        }
        return this.bmK.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gC */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.bmK == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.bmK.get(i);
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
            aVar2.bmL = (TextView) view.findViewById(i.f.text);
            aVar2.Xl = view.findViewById(i.f.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        an.i(view, i.e.list_item_selector);
        an.b(aVar.bmL, i.c.cp_cont_b, 1);
        an.j(aVar.Xl, i.c.cp_bg_line_b);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.bmL.setText(i.h.custom_num);
            aVar.Xl.setVisibility(4);
        } else if (item != null) {
            aVar.bmL.setText(String.valueOf(item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            aVar.Xl.setVisibility(0);
        } else {
            aVar.bmL.setText("");
            aVar.Xl.setVisibility(0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public View Xl;
        public TextView bmL;

        private a() {
        }

        /* synthetic */ a(r rVar, a aVar) {
            this();
        }
    }
}
