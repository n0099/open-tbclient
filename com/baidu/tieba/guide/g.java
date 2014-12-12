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
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private View.OnClickListener MY;
    private Context mContext;
    private List<InterestFrsData.Card> mData;

    public g(Context context) {
        this.mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.MY = onClickListener;
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
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, x.new_user_img_item, viewGroup, false);
            hVar = new h(this, null);
            hVar.aNk = (TbImageView) view.findViewById(com.baidu.tieba.w.pic);
            hVar.apW = (ImageView) view.findViewById(com.baidu.tieba.w.select_icon);
            hVar.apX = (RelativeLayout) view.findViewById(com.baidu.tieba.w.lay_select);
            hVar.UT = (TextView) view.findViewById(com.baidu.tieba.w.tv_fname);
            hVar.aNj = (FrameLayout) view.findViewById(com.baidu.tieba.w.pic_layout);
            hVar.aNj.setOnClickListener(this.MY);
            view.setTag(hVar);
        } else {
            hVar = (h) view.getTag();
        }
        hVar.aNk.setTag(null);
        hVar.apX.setTag(null);
        hVar.UT.setText("");
        hVar.aNj.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(hVar.apW, card.getIs_like() == 1);
            hVar.apX.setTag(card);
            hVar.aNj.setTag(card);
            hVar.aNk.setTag(card.getIcon_url());
            hVar.aNk.d(card.getIcon_url(), 21, false);
            hVar.UT.setText(card.getFname());
        }
        return view;
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_s));
        }
    }
}
