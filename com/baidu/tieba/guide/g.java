package com.baidu.tieba.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import java.util.List;
/* loaded from: classes.dex */
public final class g extends BaseAdapter {
    private List<InterestFrsData.Card> a;
    private Context b;
    private ab c;
    private View.OnClickListener d;

    public g(Context context) {
        this.b = context;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void a(ab abVar) {
        this.c = abVar;
    }

    public final void a(List<InterestFrsData.Card> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_user_img_item, viewGroup, false);
            jVar = new j(this, (byte) 0);
            jVar.b = (TbImageView) view.findViewById(com.baidu.tieba.a.h.pic);
            jVar.c = (ImageView) view.findViewById(com.baidu.tieba.a.h.select_icon);
            jVar.d = (RelativeLayout) view.findViewById(com.baidu.tieba.a.h.lay_select);
            jVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.tv_fname);
            jVar.a = (FrameLayout) view.findViewById(com.baidu.tieba.a.h.pic_layout);
            jVar.a.setOnClickListener(this.d);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        jVar.b.setTag(null);
        jVar.d.setTag(null);
        jVar.e.setText("");
        jVar.a.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            ImageView imageView = jVar.c;
            if (card.getIs_like() == 1) {
                imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_s));
            } else {
                imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_pic_n));
            }
            jVar.d.setTag(card);
            jVar.a.setTag(card);
            jVar.b.setTag(card.getIcon_url());
            jVar.e.setText(card.getFname());
            this.c.b(card.getIcon_url(), new h(this, viewGroup));
        }
        return view;
    }
}
