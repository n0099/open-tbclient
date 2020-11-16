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
    private int gMd;
    private Context mContext;
    private ArrayList<g> eHj = new ArrayList<>();
    private double gMe = -1.0d;

    public b(Context context) {
        this.mContext = context;
    }

    public void a(List<g> list, double d) {
        if (list != null && this.gMe != d) {
            this.eHj.clear();
            this.eHj.addAll(list);
            notifyDataSetChanged();
            this.gMe = d;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eHj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eHj.get(i);
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
            aVar.gMf.setText(gVar.Fl() + " x" + gVar.Fn());
            aVar.gMg.setText(com.baidu.tieba.ala.headline.a.eI(Long.parseLong(gVar.Fn()) * Long.parseLong(gVar.getPrice())));
            if (!gVar.getThumbnail_url().equals(aVar.gan.getUrl())) {
                aVar.gan.startLoad(gVar.getThumbnail_url(), 10, false);
                aVar.gan.setTag(gVar.getThumbnail_url());
            }
            if (this.gMd == i) {
                aVar.rootView.setBackgroundResource(a.e.sdk_get_headline_item_bg_stroke);
            } else {
                aVar.rootView.setBackgroundResource(0);
            }
        }
        return view;
    }

    public int bTO() {
        return this.gMd;
    }

    public void vm(int i) {
        this.gMd = i;
    }

    public void bTP() {
        this.gMe = -1.0d;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView gMf;
        public TextView gMg;
        public TbImageView gan;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gMf = (TextView) view.findViewById(a.f.get_view_gift_item_info);
            this.gMg = (TextView) view.findViewById(a.f.get_view_gift_item_cost);
            this.gan = (TbImageView) view.findViewById(a.f.get_view_gift_item_image);
            this.gan.setDefaultBgResource(a.e.sdk_shape_transparent);
        }
    }
}
