package com.baidu.tieba.gift.giftTab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<ai> aZE;
    private Context mContext;
    private int mSelectedPosition = -1;

    public b(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<ai> list) {
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
    /* renamed from: Bj */
    public ai getItem(int i) {
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
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jUK = (TbImageView) view.findViewById(R.id.image);
            aVar2.jUK.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jUV = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            aVar2.jUV.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jUV.setDefaultResource(R.drawable.transparent_bg);
            aVar2.jUL = view.findViewById(R.id.mask);
            aVar2.enq = (TextView) view.findViewById(R.id.name);
            aVar2.jUM = (TextView) view.findViewById(R.id.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ap.setViewTextColor(aVar.enq, R.color.CAM_X0105, 1);
        if (i == this.mSelectedPosition) {
            ap.setBackgroundResource(aVar.jUL, R.drawable.chx_box_gift_s);
        } else {
            aVar.jUL.setBackgroundResource(R.color.common_color_10022);
        }
        ai item = getItem(i);
        if (item != null) {
            aVar.enq.setText(item.name);
            aVar.jUK.startLoad(item.thumbnailUrl, 10, false);
            aVar.jUV.startLoad(item.eNR, 10, false);
            if (item.aHS == 5) {
                aVar.jUM.setVisibility(8);
            } else if (item.aHS == 3) {
                aVar.jUM.setVisibility(0);
                aVar.jUM.setText(g.m(item.eNS, false));
            } else {
                aVar.jUM.setVisibility(0);
                aVar.jUM.setText(g.m(item.price, false));
            }
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private static class a {
        public TextView enq;
        public TbImageView jUK;
        public View jUL;
        public TextView jUM;
        public TbImageView jUV;

        private a() {
        }
    }
}
