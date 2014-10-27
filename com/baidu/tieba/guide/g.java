package com.baidu.tieba.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private View.OnClickListener Ie;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public g(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Ie = onClickListener;
    }

    public void setData(List<InterestFrsData.Card> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.new_user_img_item, viewGroup, false);
            hVar = new h(this, null);
            hVar.aLc = (TbImageView) view.findViewById(com.baidu.tieba.v.pic);
            hVar.aiA = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
            hVar.aiB = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
            hVar.Pd = (TextView) view.findViewById(com.baidu.tieba.v.tv_fname);
            hVar.aLb = (FrameLayout) view.findViewById(com.baidu.tieba.v.pic_layout);
            hVar.aLb.setOnClickListener(this.Ie);
            view.setTag(hVar);
        } else {
            hVar = (h) view.getTag();
        }
        hVar.aLc.setTag(null);
        hVar.aiB.setTag(null);
        hVar.Pd.setText("");
        hVar.aLb.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(hVar.aiA, card.getIs_like() == 1);
            hVar.aiB.setTag(card);
            hVar.aLb.setTag(card);
            hVar.aLc.setTag(card.getIcon_url());
            hVar.aLc.c(card.getIcon_url(), 21, false);
            hVar.Pd.setText(card.getFname());
        }
        return view;
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
        }
    }
}
