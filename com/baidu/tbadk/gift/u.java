package com.baidu.tbadk.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.gift.GiftCommonList;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private List<GiftCommonList.GiftItem> aaH;
    private RelativeLayout.LayoutParams aaI;
    private int aap = -1;
    private Context mContext;

    public u(Context context) {
        this.mContext = context;
        this.aaI = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds450) - 8) / 2);
    }

    public void setGiftItems(List<GiftCommonList.GiftItem> list) {
        this.aaH = list;
        notifyDataSetChanged();
    }

    public void dk(int i) {
        this.aap = i;
    }

    public int vJ() {
        return this.aap;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaH == null) {
            return 0;
        }
        return this.aaH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dl */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aaH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.gift_list_item, null);
            v vVar2 = new v(this, null);
            vVar2.aaJ = (TbImageView) view.findViewById(com.baidu.tieba.w.image);
            vVar2.aaK = view.findViewById(com.baidu.tieba.w.mask);
            vVar2.aaL = (TextView) view.findViewById(com.baidu.tieba.w.name);
            vVar2.aaM = (TextView) view.findViewById(com.baidu.tieba.w.price);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.aaK.setLayoutParams(this.aaI);
        ax.i(view, com.baidu.tieba.t.cp_bg_line_d);
        ax.b(vVar.aaL, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(vVar.aaM, com.baidu.tieba.t.cp_cont_h, 1);
        if (i == this.aap) {
            ax.i(vVar.aaK, com.baidu.tieba.v.chx_box_gift_s);
        } else {
            vVar.aaK.setBackgroundResource(com.baidu.tieba.t.transparent);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            vVar.aaL.setText(item.getName());
            vVar.aaM.setText(String.format(this.mContext.getString(z.tdou_price_format), Integer.valueOf(item.getPrice())));
            vVar.aaJ.d(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
