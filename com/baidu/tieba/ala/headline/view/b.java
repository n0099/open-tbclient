package com.baidu.tieba.ala.headline.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.gift.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<g> eTF = new ArrayList<>();
    private double hcA = -1.0d;
    private int hcz;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public void a(List<g> list, double d) {
        if (list != null && this.hcA != d) {
            this.eTF.clear();
            this.eTF.addAll(list);
            notifyDataSetChanged();
            this.hcA = d;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_get_headline_gift_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        g gVar = (g) getItem(i);
        if (gVar != null) {
            aVar.hcB.setText(gVar.CD() + " x" + gVar.CG());
            aVar.hcC.setText(com.baidu.tieba.ala.headline.a.fm(Long.parseLong(gVar.CG()) * Long.parseLong(gVar.getPrice())));
            if (!gVar.getThumbnail_url().equals(aVar.gor.getUrl())) {
                aVar.gor.startLoad(gVar.getThumbnail_url(), 10, false);
                aVar.gor.setTag(gVar.getThumbnail_url());
            }
            if (this.hcz == i) {
                aVar.rootView.setBackgroundResource(a.e.sdk_get_headline_item_bg_stroke);
            } else {
                aVar.rootView.setBackgroundResource(0);
            }
        }
        return view;
    }

    public int bWm() {
        return this.hcz;
    }

    public void uy(int i) {
        this.hcz = i;
    }

    public void bWn() {
        this.hcA = -1.0d;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TbImageView gor;
        public TextView hcB;
        public TextView hcC;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hcB = (TextView) view.findViewById(a.f.get_view_gift_item_info);
            this.hcC = (TextView) view.findViewById(a.f.get_view_gift_item_cost);
            this.gor = (TbImageView) view.findViewById(a.f.get_view_gift_item_image);
            this.gor.setDefaultBgResource(a.e.sdk_shape_transparent);
        }
    }
}
