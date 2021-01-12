package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private List<GiftCommonList.NumInfo> aWX;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public void J(List<GiftCommonList.NumInfo> list) {
        this.aWX = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aWX == null) {
            return 1;
        }
        return this.aWX.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AT */
    public GiftCommonList.NumInfo getItem(int i) {
        if (this.aWX == null || i < 0 || i >= getCount() - 1) {
            return null;
        }
        return this.aWX.get(i);
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_num_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.aWY = (TextView) view.findViewById(R.id.text);
            aVar2.bPy = view.findViewById(R.id.divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ao.setBackgroundResource(view, R.drawable.list_item_selector);
        ao.setViewTextColor(aVar.aWY, R.color.CAM_X0105, 1);
        ao.setBackgroundColor(aVar.bPy, R.color.CAM_X0204);
        GiftCommonList.NumInfo item = getItem(i);
        if (getItemViewType(i) == 1) {
            aVar.aWY.setText(R.string.custom_num);
            aVar.bPy.setVisibility(4);
        } else if (item != null) {
            aVar.aWY.setText((item.getNum() <= 0 ? 1 : item.getNum()) + (item.getName() == null ? "" : item.getName()));
            aVar.bPy.setVisibility(0);
        } else {
            aVar.aWY.setText("");
            aVar.bPy.setVisibility(0);
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private class a {
        public TextView aWY;
        public View bPy;

        private a() {
        }
    }
}
