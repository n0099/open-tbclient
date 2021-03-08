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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private List<GiftCommonList.GiftItem> bbf;
    private RelativeLayout.LayoutParams jWZ;
    private Context mContext;
    private int mSelectedPosition = -1;

    public a(Context context) {
        this.mContext = context;
        this.jWZ = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.bbf = list;
        notifyDataSetChanged();
    }

    public void cR(int i) {
        this.mSelectedPosition = i;
    }

    public int FY() {
        return this.mSelectedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbf == null) {
            return 0;
        }
        return this.bbf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bk */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bbf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0747a c0747a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            C0747a c0747a2 = new C0747a();
            c0747a2.jXa = (TbImageView) view.findViewById(R.id.image);
            c0747a2.jXb = view.findViewById(R.id.mask);
            c0747a2.eoT = (TextView) view.findViewById(R.id.name);
            c0747a2.jXc = (TextView) view.findViewById(R.id.price);
            view.setTag(c0747a2);
            c0747a = c0747a2;
        } else {
            c0747a = (C0747a) view.getTag();
        }
        c0747a.jXb.setLayoutParams(this.jWZ);
        ap.setBackgroundResource(view, R.color.CAM_X0201);
        ap.setViewTextColor(c0747a.eoT, R.color.CAM_X0105, 1);
        ap.setViewTextColor(c0747a.jXc, R.color.CAM_X0301, 1);
        if (i == this.mSelectedPosition) {
            ap.setBackgroundResource(c0747a.jXb, R.drawable.chx_box_gift_s);
        } else {
            c0747a.jXb.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            c0747a.eoT.setText(item.getName());
            c0747a.jXc.setText(String.format(this.mContext.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            c0747a.jXa.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.gift.buyGift.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0747a {
        public TextView eoT;
        public TbImageView jXa;
        public View jXb;
        public TextView jXc;

        private C0747a() {
        }
    }
}
