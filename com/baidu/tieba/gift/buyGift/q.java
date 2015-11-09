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
    private int bmS = -1;
    private List<GiftCommonList.GiftItem> bni;
    private RelativeLayout.LayoutParams bnj;
    private Context mContext;

    public q(Context context) {
        this.mContext = context;
        this.bnj = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(i.d.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.bni = list;
        notifyDataSetChanged();
    }

    public void gN(int i) {
        this.bmS = i;
    }

    public int QL() {
        return this.bmS;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bni == null) {
            return 0;
        }
        return this.bni.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gO */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bni.get(i);
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
            aVar2.bnk = (TbImageView) view.findViewById(i.f.image);
            aVar2.bnl = view.findViewById(i.f.mask);
            aVar2.aCf = (TextView) view.findViewById(i.f.name);
            aVar2.bnm = (TextView) view.findViewById(i.f.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.bnl.setLayoutParams(this.bnj);
        an.i(view, i.c.cp_bg_line_d);
        an.b(aVar.aCf, i.c.cp_cont_b, 1);
        an.b(aVar.bnm, i.c.cp_cont_h, 1);
        if (i == this.bmS) {
            an.i(aVar.bnl, i.e.chx_box_gift_s);
        } else {
            aVar.bnl.setBackgroundResource(i.c.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            aVar.aCf.setText(item.getName());
            aVar.bnm.setText(String.format(this.mContext.getString(i.h.tdou_price_format), Integer.valueOf(item.getPrice())));
            aVar.bnk.d(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        public TextView aCf;
        public TbImageView bnk;
        public View bnl;
        public TextView bnm;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }
}
