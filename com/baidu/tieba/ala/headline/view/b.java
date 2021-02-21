package com.baidu.tieba.ala.headline.view;

import android.content.Context;
import android.util.Log;
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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private int hfw;
    private Context mContext;
    private ArrayList<g> eVV = new ArrayList<>();
    private double hfx = -1.0d;

    public b(Context context) {
        this.mContext = context;
    }

    public void a(List<g> list, double d) {
        if (list != null && this.hfx != d) {
            this.eVV.clear();
            this.eVV.addAll(list);
            notifyDataSetChanged();
            this.hfx = d;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eVV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eVV.get(i);
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
            aVar.hfy.setText(gVar.DS() + " x" + gVar.DW());
            aVar.hfz.setText(com.baidu.tieba.ala.headline.a.fs(Long.parseLong(gVar.DW()) * Long.parseLong(gVar.getPrice())));
            if (gVar.getThumbnail_url().equals(aVar.gro.getUrl())) {
                Log.d("bugbye", "bugbye");
            } else {
                aVar.gro.startLoad(gVar.getThumbnail_url(), 10, false);
                aVar.gro.setTag(gVar.getThumbnail_url());
            }
            if (this.hfw == i) {
                aVar.rootView.setBackgroundResource(a.e.sdk_get_headline_item_bg_stroke);
            } else {
                aVar.rootView.setBackgroundResource(0);
            }
        }
        return view;
    }

    public int bWX() {
        return this.hfw;
    }

    public void uE(int i) {
        this.hfw = i;
    }

    public void bWY() {
        this.hfx = -1.0d;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public TbImageView gro;
        public TextView hfy;
        public TextView hfz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hfy = (TextView) view.findViewById(a.f.get_view_gift_item_info);
            this.hfz = (TextView) view.findViewById(a.f.get_view_gift_item_cost);
            this.gro = (TbImageView) view.findViewById(a.f.get_view_gift_item_image);
            this.gro.setDefaultBgResource(a.e.sdk_shape_transparent);
        }
    }
}
