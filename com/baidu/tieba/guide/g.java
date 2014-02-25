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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private List<InterestFrsData.Card> a;
    private Context b;
    private com.baidu.tieba.util.i c;
    private View.OnClickListener d;

    public g(Context context) {
        this.b = context;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(com.baidu.tieba.util.i iVar) {
        this.c = iVar;
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
        j jVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.new_user_img_item, viewGroup, false);
            jVar = new j(this, null);
            jVar.b = (TbImageView) view.findViewById(R.id.pic);
            jVar.c = (ImageView) view.findViewById(R.id.select_icon);
            jVar.d = (RelativeLayout) view.findViewById(R.id.lay_select);
            jVar.e = (TextView) view.findViewById(R.id.tv_fname);
            jVar.a = (FrameLayout) view.findViewById(R.id.pic_layout);
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
            a(jVar.c, card.getIs_like() == 1);
            jVar.d.setTag(card);
            jVar.a.setTag(card);
            jVar.b.setTag(card.getIcon_url());
            jVar.e.setText(card.getFname());
            this.c.b(card.getIcon_url(), new h(this, viewGroup));
        }
        return view;
    }

    public void a(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.b.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
        }
    }
}
