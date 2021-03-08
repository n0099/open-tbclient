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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private int hhf;
    private Context mContext;
    private ArrayList<g> eXu = new ArrayList<>();
    private double hhg = -1.0d;

    public b(Context context) {
        this.mContext = context;
    }

    public void a(List<g> list, double d) {
        if (list != null && this.hhg != d) {
            this.eXu.clear();
            this.eXu.addAll(list);
            notifyDataSetChanged();
            this.hhg = d;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eXu.get(i);
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
            aVar.hhh.setText(gVar.DV() + " x" + gVar.DZ());
            aVar.hhi.setText(com.baidu.tieba.ala.headline.a.fs(Long.parseLong(gVar.DZ()) * Long.parseLong(gVar.getPrice())));
            if (gVar.getThumbnail_url().equals(aVar.gsX.getUrl())) {
                Log.d("bugbye", "bugbye");
            } else {
                aVar.gsX.startLoad(gVar.getThumbnail_url(), 10, false);
                aVar.gsX.setTag(gVar.getThumbnail_url());
            }
            if (this.hhf == i) {
                aVar.rootView.setBackgroundResource(a.e.sdk_get_headline_item_bg_stroke);
            } else {
                aVar.rootView.setBackgroundResource(0);
            }
        }
        return view;
    }

    public int bXd() {
        return this.hhf;
    }

    public void uG(int i) {
        this.hhf = i;
    }

    public void bXe() {
        this.hhg = -1.0d;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TbImageView gsX;
        public TextView hhh;
        public TextView hhi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hhh = (TextView) view.findViewById(a.f.get_view_gift_item_info);
            this.hhi = (TextView) view.findViewById(a.f.get_view_gift_item_cost);
            this.gsX = (TbImageView) view.findViewById(a.f.get_view_gift_item_image);
            this.gsX.setDefaultBgResource(a.e.sdk_shape_transparent);
        }
    }
}
