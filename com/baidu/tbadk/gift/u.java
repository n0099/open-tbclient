package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private List<GiftCommonList.GiftItem> UD;
    private RelativeLayout.LayoutParams UE;
    private int Uk = -1;
    private Context mContext;

    public u(Context context) {
        this.mContext = context;
        this.UE = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.UD = list;
        notifyDataSetChanged();
    }

    public void cM(int i) {
        this.Uk = i;
    }

    public int sg() {
        return this.Uk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.UD == null) {
            return 0;
        }
        return this.UD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cN */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.UD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.gift_list_item, null);
            v vVar2 = new v(this, null);
            vVar2.UF = (TbImageView) view.findViewById(com.baidu.tieba.v.image);
            vVar2.UG = view.findViewById(com.baidu.tieba.v.mask);
            vVar2.UH = (TextView) view.findViewById(com.baidu.tieba.v.name);
            vVar2.UI = (TextView) view.findViewById(com.baidu.tieba.v.price);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.UG.setLayoutParams(this.UE);
        aw.h(view, com.baidu.tieba.s.cp_bg_line_d);
        aw.b(vVar.UH, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(vVar.UI, com.baidu.tieba.s.cp_cont_h, 1);
        if (i == this.Uk) {
            aw.h(vVar.UG, com.baidu.tieba.u.chx_box_gift_s);
        } else {
            vVar.UG.setBackgroundResource(com.baidu.tieba.s.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            vVar.UH.setText(item.getName());
            vVar.UI.setText(String.format(this.mContext.getString(com.baidu.tieba.y.tdou_price_format), Integer.valueOf(item.getPrice())));
            vVar.UF.c(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
