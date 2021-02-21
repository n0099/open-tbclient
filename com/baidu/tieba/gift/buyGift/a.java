package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<GiftCommonList.GiftItem> aZE;
    private RelativeLayout.LayoutParams jUX;
    private Context mContext;
    private int mSelectedPosition = -1;

    public a(Context context) {
        this.mContext = context;
        this.jUX = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.aZE = list;
        notifyDataSetChanged();
    }

    public void cQ(int i) {
        this.mSelectedPosition = i;
    }

    public int FV() {
        return this.mSelectedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZE == null) {
            return 0;
        }
        return this.aZE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bh */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aZE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0741a c0741a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            C0741a c0741a2 = new C0741a();
            c0741a2.jUY = (TbImageView) view.findViewById(R.id.image);
            c0741a2.jUZ = view.findViewById(R.id.mask);
            c0741a2.enq = (TextView) view.findViewById(R.id.name);
            c0741a2.jVa = (TextView) view.findViewById(R.id.price);
            view.setTag(c0741a2);
            c0741a = c0741a2;
        } else {
            c0741a = (C0741a) view.getTag();
        }
        c0741a.jUZ.setLayoutParams(this.jUX);
        ap.setBackgroundResource(view, R.color.CAM_X0201);
        ap.setViewTextColor(c0741a.enq, R.color.CAM_X0105, 1);
        ap.setViewTextColor(c0741a.jVa, R.color.CAM_X0301, 1);
        if (i == this.mSelectedPosition) {
            ap.setBackgroundResource(c0741a.jUZ, R.drawable.chx_box_gift_s);
        } else {
            c0741a.jUZ.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            c0741a.enq.setText(item.getName());
            c0741a.jVa.setText(String.format(this.mContext.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            c0741a.jUY.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.gift.buyGift.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0741a {
        public TextView enq;
        public TbImageView jUY;
        public View jUZ;
        public TextView jVa;

        private C0741a() {
        }
    }
}
