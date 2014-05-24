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
public class h extends BaseAdapter {
    private List<InterestFrsData.Card> a;
    private Context b;
    private ab c;
    private View.OnClickListener d;

    public h(Context context) {
        this.b = context;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(ab abVar) {
        this.c = abVar;
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
        k kVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_user_img_item, viewGroup, false);
            kVar = new k(this, null);
            kVar.b = (TbImageView) view.findViewById(com.baidu.tieba.v.pic);
            kVar.c = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
            kVar.d = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
            kVar.e = (TextView) view.findViewById(com.baidu.tieba.v.tv_fname);
            kVar.a = (FrameLayout) view.findViewById(com.baidu.tieba.v.pic_layout);
            kVar.a.setOnClickListener(this.d);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        kVar.b.setTag(null);
        kVar.d.setTag(null);
        kVar.e.setText("");
        kVar.a.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            a(kVar.c, card.getIs_like() == 1);
            kVar.d.setTag(card);
            kVar.a.setTag(card);
            kVar.b.setTag(card.getIcon_url());
            kVar.e.setText(card.getFname());
            this.c.b(card.getIcon_url(), new i(this, viewGroup));
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
        }
    }
}
