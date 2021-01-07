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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<ah> bbm;
    private Context mContext;
    private int mSelectedPosition = -1;

    public b(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<ah> list) {
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
    /* renamed from: CA */
    public ah getItem(int i) {
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
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.gift_list_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jRN = (TbImageView) view.findViewById(R.id.image);
            aVar2.jRN.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jRY = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            aVar2.jRY.setDefaultBgResource(R.drawable.transparent_bg);
            aVar2.jRY.setDefaultResource(R.drawable.transparent_bg);
            aVar2.jRO = view.findViewById(R.id.mask);
            aVar2.epX = (TextView) view.findViewById(R.id.name);
            aVar2.jRP = (TextView) view.findViewById(R.id.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ao.setViewTextColor(aVar.epX, R.color.CAM_X0105, 1);
        if (i == this.mSelectedPosition) {
            ao.setBackgroundResource(aVar.jRO, R.drawable.chx_box_gift_s);
        } else {
            aVar.jRO.setBackgroundResource(R.color.common_color_10022);
        }
        ah item = getItem(i);
        if (item != null) {
            aVar.epX.setText(item.name);
            aVar.jRN.startLoad(item.thumbnailUrl, 10, false);
            aVar.jRY.startLoad(item.eQq, 10, false);
            if (item.aKj == 5) {
                aVar.jRP.setVisibility(8);
            } else if (item.aKj == 3) {
                aVar.jRP.setVisibility(0);
                aVar.jRP.setText(g.l(item.eQr, false));
            } else {
                aVar.jRP.setVisibility(0);
                aVar.jRP.setText(g.l(item.price, false));
            }
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private static class a {
        public TextView epX;
        public TbImageView jRN;
        public View jRO;
        public TextView jRP;
        public TbImageView jRY;

        private a() {
        }
    }
}
