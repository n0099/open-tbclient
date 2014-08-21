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
    private List<InterestFrsData.Card> a;
    private Context b;
    private View.OnClickListener c;

    public g(Context context) {
        this.b = context;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(List<InterestFrsData.Card> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.new_user_img_item, viewGroup, false);
            hVar = new h(this, null);
            hVar.b = (TbImageView) view.findViewById(com.baidu.tieba.u.pic);
            hVar.c = (ImageView) view.findViewById(com.baidu.tieba.u.select_icon);
            hVar.d = (RelativeLayout) view.findViewById(com.baidu.tieba.u.lay_select);
            hVar.e = (TextView) view.findViewById(com.baidu.tieba.u.tv_fname);
            hVar.a = (FrameLayout) view.findViewById(com.baidu.tieba.u.pic_layout);
            hVar.a.setOnClickListener(this.c);
            view.setTag(hVar);
        } else {
            hVar = (h) view.getTag();
        }
        hVar.b.setTag(null);
        hVar.d.setTag(null);
        hVar.e.setText("");
        hVar.a.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(hVar.c, card.getIs_like() == 1);
            hVar.d.setTag(card);
            hVar.a.setTag(card);
            hVar.b.setTag(card.getIcon_url());
            hVar.b.a(card.getIcon_url(), 21, false);
            hVar.e.setText(card.getFname());
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.icon_startpage2_add_ba_s));
        }
    }
}
