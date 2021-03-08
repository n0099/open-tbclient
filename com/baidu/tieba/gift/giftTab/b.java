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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private List<ai> bbf;
    private Context mContext;
    private int mSelectedPosition = -1;

    public b(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<ai> list) {
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
    /* renamed from: Bm */
    public ai getItem(int i) {
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
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jXa = (TbImageView) view.findViewById(R.id.image);
            aVar2.jXa.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jXl = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            aVar2.jXl.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jXl.setDefaultResource(R.drawable.transparent_bg);
            aVar2.jXb = view.findViewById(R.id.mask);
            aVar2.eoT = (TextView) view.findViewById(R.id.name);
            aVar2.jXc = (TextView) view.findViewById(R.id.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ap.setViewTextColor(aVar.eoT, R.color.CAM_X0105, 1);
        if (i == this.mSelectedPosition) {
            ap.setBackgroundResource(aVar.jXb, R.drawable.chx_box_gift_s);
        } else {
            aVar.jXb.setBackgroundResource(R.color.common_color_10022);
        }
        ai item = getItem(i);
        if (item != null) {
            aVar.eoT.setText(item.name);
            aVar.jXa.startLoad(item.thumbnailUrl, 10, false);
            aVar.jXl.startLoad(item.ePs, 10, false);
            if (item.aJs == 5) {
                aVar.jXc.setVisibility(8);
            } else if (item.aJs == 3) {
                aVar.jXc.setVisibility(0);
                aVar.jXc.setText(g.m(item.ePt, false));
            } else {
                aVar.jXc.setVisibility(0);
                aVar.jXc.setText(g.m(item.price, false));
            }
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private static class a {
        public TextView eoT;
        public TbImageView jXa;
        public View jXb;
        public TextView jXc;
        public TbImageView jXl;

        private a() {
        }
    }
}
