package com.baidu.tieba.gift.giftTab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private List<ah> aWy;
    private Context mContext;
    private int mSelectedPosition = -1;

    public b(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<ah> list) {
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
    /* renamed from: AT */
    public ah getItem(int i) {
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
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jNi = (TbImageView) view.findViewById(R.id.image);
            aVar2.jNi.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jNt = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            aVar2.jNt.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jNt.setDefaultResource(R.drawable.transparent_bg);
            aVar2.jNj = view.findViewById(R.id.mask);
            aVar2.eli = (TextView) view.findViewById(R.id.name);
            aVar2.jNk = (TextView) view.findViewById(R.id.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ao.setViewTextColor(aVar.eli, R.color.CAM_X0105, 1);
        if (i == this.mSelectedPosition) {
            ao.setBackgroundResource(aVar.jNj, R.drawable.chx_box_gift_s);
        } else {
            aVar.jNj.setBackgroundResource(R.color.common_color_10022);
        }
        ah item = getItem(i);
        if (item != null) {
            aVar.eli.setText(item.name);
            aVar.jNi.startLoad(item.thumbnailUrl, 10, false);
            aVar.jNt.startLoad(item.eLF, 10, false);
            if (item.aFw == 5) {
                aVar.jNk.setVisibility(8);
            } else if (item.aFw == 3) {
                aVar.jNk.setVisibility(0);
                aVar.jNk.setText(g.m(item.eLG, false));
            } else {
                aVar.jNk.setVisibility(0);
                aVar.jNk.setText(g.m(item.price, false));
            }
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private static class a {
        public TextView eli;
        public TbImageView jNi;
        public View jNj;
        public TextView jNk;
        public TbImageView jNt;

        private a() {
        }
    }
}
