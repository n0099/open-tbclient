package com.baidu.tieba.gift.buyGift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<GiftCommonList.GiftItem> buL;
    private RelativeLayout.LayoutParams buM;
    private int buv = -1;
    private Context mContext;

    public q(Context context) {
        this.mContext = context;
        this.buM = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(n.d.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.buL = list;
        notifyDataSetChanged();
    }

    public void hq(int i) {
        this.buv = i;
    }

    public int Tb() {
        return this.buv;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.buL == null) {
            return 0;
        }
        return this.buL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hr */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.buL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.gift_list_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.buN = (TbImageView) view.findViewById(n.f.image);
            aVar2.buO = view.findViewById(n.f.mask);
            aVar2.aER = (TextView) view.findViewById(n.f.name);
            aVar2.buP = (TextView) view.findViewById(n.f.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.buO.setLayoutParams(this.buM);
        as.i(view, n.c.cp_bg_line_d);
        as.b(aVar.aER, n.c.cp_cont_b, 1);
        as.b(aVar.buP, n.c.cp_cont_h, 1);
        if (i == this.buv) {
            as.i(aVar.buO, n.e.chx_box_gift_s);
        } else {
            aVar.buO.setBackgroundResource(n.c.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            aVar.aER.setText(item.getName());
            aVar.buP.setText(String.format(this.mContext.getString(n.i.tdou_price_format), Integer.valueOf(item.getPrice())));
            aVar.buN.d(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public TextView aER;
        public TbImageView buN;
        public View buO;
        public TextView buP;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }
}
