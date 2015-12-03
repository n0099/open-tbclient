package com.baidu.tieba.gift.giftTab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<com.baidu.tbadk.core.data.l> buL;
    private int buv = -1;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<com.baidu.tbadk.core.data.l> list) {
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
    /* renamed from: ht */
    public com.baidu.tbadk.core.data.l getItem(int i) {
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
            a aVar2 = new a(null);
            aVar2.buN = (TbImageView) view.findViewById(n.f.image);
            aVar2.buN.setDefaultBgResource(n.e.transparent_bg);
            aVar2.bvc = (TbImageView) view.findViewById(n.f.mark_icon_iamge);
            aVar2.bvc.setDefaultBgResource(n.e.transparent_bg);
            aVar2.bvc.setDefaultResource(n.e.transparent_bg);
            aVar2.buO = view.findViewById(n.f.mask);
            aVar2.aER = (TextView) view.findViewById(n.f.name);
            aVar2.buP = (TextView) view.findViewById(n.f.price);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        as.b(aVar.aER, n.c.cp_cont_b, 1);
        if (i == this.buv) {
            as.i(aVar.buO, n.e.chx_box_gift_s);
        } else {
            aVar.buO.setBackgroundResource(n.c.transparent);
        }
        com.baidu.tbadk.core.data.l item = getItem(i);
        if (item != null) {
            aVar.aER.setText(item.getName());
            aVar.buN.d(item.getThumbnailUrl(), 10, false);
            aVar.bvc.d(item.rT(), 10, false);
            if (item.rS() == 5) {
                aVar.buP.setVisibility(8);
            } else if (item.rS() == 3) {
                aVar.buP.setVisibility(0);
                aVar.buP.setText(ao.d(item.rV(), false));
            } else {
                aVar.buP.setVisibility(0);
                aVar.buP.setText(ao.d(item.rR(), false));
            }
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        public TextView aER;
        public TbImageView buN;
        public View buO;
        public TextView buP;
        public TbImageView bvc;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
