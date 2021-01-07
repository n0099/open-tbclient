package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<GiftCommonList.GiftItem> bbm;
    private RelativeLayout.LayoutParams jRM;
    private Context mContext;
    private int mSelectedPosition = -1;

    public a(Context context) {
        this.mContext = context;
        this.jRM = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.bbm = list;
        notifyDataSetChanged();
    }

    public void er(int i) {
        this.mSelectedPosition = i;
    }

    public int IA() {
        return this.mSelectedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbm == null) {
            return 0;
        }
        return this.bbm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cy */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bbm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0756a c0756a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            C0756a c0756a2 = new C0756a();
            c0756a2.jRN = (TbImageView) view.findViewById(R.id.image);
            c0756a2.jRO = view.findViewById(R.id.mask);
            c0756a2.epX = (TextView) view.findViewById(R.id.name);
            c0756a2.jRP = (TextView) view.findViewById(R.id.price);
            view.setTag(c0756a2);
            c0756a = c0756a2;
        } else {
            c0756a = (C0756a) view.getTag();
        }
        c0756a.jRO.setLayoutParams(this.jRM);
        ao.setBackgroundResource(view, R.color.CAM_X0201);
        ao.setViewTextColor(c0756a.epX, R.color.CAM_X0105, 1);
        ao.setViewTextColor(c0756a.jRP, R.color.CAM_X0301, 1);
        if (i == this.mSelectedPosition) {
            ao.setBackgroundResource(c0756a.jRO, R.drawable.chx_box_gift_s);
        } else {
            c0756a.jRO.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            c0756a.epX.setText(item.getName());
            c0756a.jRP.setText(String.format(this.mContext.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            c0756a.jRN.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.gift.buyGift.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0756a {
        public TextView epX;
        public TbImageView jRN;
        public View jRO;
        public TextView jRP;

        private C0756a() {
        }
    }
}
