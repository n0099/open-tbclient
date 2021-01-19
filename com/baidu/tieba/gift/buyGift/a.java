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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private List<GiftCommonList.GiftItem> aWy;
    private RelativeLayout.LayoutParams jNh;
    private Context mContext;
    private int mSelectedPosition = -1;

    public a(Context context) {
        this.mContext = context;
        this.jNh = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.aWy = list;
        notifyDataSetChanged();
    }

    public void cL(int i) {
        this.mSelectedPosition = i;
    }

    public int EF() {
        return this.mSelectedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aWy == null) {
            return 0;
        }
        return this.aWy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AR */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aWy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0739a c0739a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            C0739a c0739a2 = new C0739a();
            c0739a2.jNi = (TbImageView) view.findViewById(R.id.image);
            c0739a2.jNj = view.findViewById(R.id.mask);
            c0739a2.eli = (TextView) view.findViewById(R.id.name);
            c0739a2.jNk = (TextView) view.findViewById(R.id.price);
            view.setTag(c0739a2);
            c0739a = c0739a2;
        } else {
            c0739a = (C0739a) view.getTag();
        }
        c0739a.jNj.setLayoutParams(this.jNh);
        ao.setBackgroundResource(view, R.color.CAM_X0201);
        ao.setViewTextColor(c0739a.eli, R.color.CAM_X0105, 1);
        ao.setViewTextColor(c0739a.jNk, R.color.CAM_X0301, 1);
        if (i == this.mSelectedPosition) {
            ao.setBackgroundResource(c0739a.jNj, R.drawable.chx_box_gift_s);
        } else {
            c0739a.jNj.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            c0739a.eli.setText(item.getName());
            c0739a.jNk.setText(String.format(this.mContext.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            c0739a.jNi.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.gift.buyGift.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0739a {
        public TextView eli;
        public TbImageView jNi;
        public View jNj;
        public TextView jNk;

        private C0739a() {
        }
    }
}
