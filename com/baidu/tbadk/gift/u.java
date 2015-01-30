package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private int aaQ = -1;
    private List<GiftCommonList.GiftItem> abi;
    private RelativeLayout.LayoutParams abj;
    private Context mContext;

    public u(Context context) {
        this.mContext = context;
        this.abj = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.abi = list;
        notifyDataSetChanged();
    }

    public void ds(int i) {
        this.aaQ = i;
    }

    public int wc() {
        return this.aaQ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abi == null) {
            return 0;
        }
        return this.abi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dt */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.abi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.gift_list_item, null);
            v vVar2 = new v(this, null);
            vVar2.abk = (TbImageView) view.findViewById(com.baidu.tieba.w.image);
            vVar2.abl = view.findViewById(com.baidu.tieba.w.mask);
            vVar2.abm = (TextView) view.findViewById(com.baidu.tieba.w.name);
            vVar2.abn = (TextView) view.findViewById(com.baidu.tieba.w.price);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.abl.setLayoutParams(this.abj);
        bc.i(view, com.baidu.tieba.t.cp_bg_line_d);
        bc.b(vVar.abm, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(vVar.abn, com.baidu.tieba.t.cp_cont_h, 1);
        if (i == this.aaQ) {
            bc.i(vVar.abl, com.baidu.tieba.v.chx_box_gift_s);
        } else {
            vVar.abl.setBackgroundResource(com.baidu.tieba.t.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            vVar.abm.setText(item.getName());
            vVar.abn.setText(String.format(this.mContext.getString(z.tdou_price_format), Integer.valueOf(item.getPrice())));
            vVar.abk.d(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
