package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<GiftCommonList.GiftItem> bmE;
    private RelativeLayout.LayoutParams bmF;
    private int bmo = -1;
    private Context mContext;

    public q(Context context) {
        this.mContext = context;
        this.bmF = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(i.d.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.bmE = list;
        notifyDataSetChanged();
    }

    public void gA(int i) {
        this.bmo = i;
    }

    public int Qp() {
        return this.bmo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bmE == null) {
            return 0;
        }
        return this.bmE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gB */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bmE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.gift_list_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bmG = (TbImageView) view.findViewById(i.f.image);
            aVar2.bmH = view.findViewById(i.f.mask);
            aVar2.aDl = (TextView) view.findViewById(i.f.name);
            aVar2.bmI = (TextView) view.findViewById(i.f.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.bmH.setLayoutParams(this.bmF);
        an.i(view, i.c.cp_bg_line_d);
        an.b(aVar.aDl, i.c.cp_cont_b, 1);
        an.b(aVar.bmI, i.c.cp_cont_h, 1);
        if (i == this.bmo) {
            an.i(aVar.bmH, i.e.chx_box_gift_s);
        } else {
            aVar.bmH.setBackgroundResource(i.c.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            aVar.aDl.setText(item.getName());
            aVar.bmI.setText(String.format(this.mContext.getString(i.h.tdou_price_format), Integer.valueOf(item.getPrice())));
            aVar.bmG.d(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public TextView aDl;
        public TbImageView bmG;
        public View bmH;
        public TextView bmI;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }
}
