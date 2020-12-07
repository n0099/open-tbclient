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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private int gVq;
    private Context mContext;
    private ArrayList<g> eOt = new ArrayList<>();
    private double gVr = -1.0d;

    public b(Context context) {
        this.mContext = context;
    }

    public void a(List<g> list, double d) {
        if (list != null && this.gVr != d) {
            this.eOt.clear();
            this.eOt.addAll(list);
            notifyDataSetChanged();
            this.gVr = d;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eOt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eOt.get(i);
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
            aVar.gVs.setText(gVar.GY() + " x" + gVar.Ha());
            aVar.gVt.setText(com.baidu.tieba.ala.headline.a.fm(Long.parseLong(gVar.Ha()) * Long.parseLong(gVar.getPrice())));
            if (!gVar.getThumbnail_url().equals(aVar.giz.getUrl())) {
                aVar.giz.startLoad(gVar.getThumbnail_url(), 10, false);
                aVar.giz.setTag(gVar.getThumbnail_url());
            }
            if (this.gVq == i) {
                aVar.rootView.setBackgroundResource(a.e.sdk_get_headline_item_bg_stroke);
            } else {
                aVar.rootView.setBackgroundResource(0);
            }
        }
        return view;
    }

    public int bXx() {
        return this.gVq;
    }

    public void vT(int i) {
        this.gVq = i;
    }

    public void bXy() {
        this.gVr = -1.0d;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView gVs;
        public TextView gVt;
        public TbImageView giz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gVs = (TextView) view.findViewById(a.f.get_view_gift_item_info);
            this.gVt = (TextView) view.findViewById(a.f.get_view_gift_item_cost);
            this.giz = (TbImageView) view.findViewById(a.f.get_view_gift_item_image);
            this.giz.setDefaultBgResource(a.e.sdk_shape_transparent);
        }
    }
}
