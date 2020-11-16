package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.guardthrone.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private List<a.b.C0654b> mList = new ArrayList();

    public b(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.b.C0654b> list) {
        if (this.mList != null) {
            this.mList.clear();
            this.mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_guard_throne_rank_item_layout, (ViewGroup) null);
            aVar = new a();
            aVar.gJs = (TextView) view.findViewById(a.f.tv_rank_label);
            aVar.gJt = (HeadImageView) view.findViewById(a.f.avatar_rank);
            aVar.gJu = (TextView) view.findViewById(a.f.tv_rank_name);
            aVar.gJv = (TextView) view.findViewById(a.f.tv_rank_score);
            a(aVar.gJt);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a.b.C0654b c0654b = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0654b != null) {
            aVar.gJs.setText(c0654b.rank);
            aVar.gJt.startLoad(c0654b.portrait, 12, false);
            aVar.gJu.setText(c0654b.nickname);
            aVar.gJv.setText(this.mContext.getResources().getString(a.h.score_value, com.baidu.tieba.ala.guardthrone.e.a.GW(c0654b.score)));
        }
        return view;
    }

    private void a(HeadImageView headImageView) {
        headImageView.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        headImageView.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* loaded from: classes4.dex */
    private class a {
        public TextView gJs;
        public HeadImageView gJt;
        public TextView gJu;
        public TextView gJv;

        private a() {
        }
    }
}
