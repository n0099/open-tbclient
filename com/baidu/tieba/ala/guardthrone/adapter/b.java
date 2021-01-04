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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private List<a.b.C0659b> mList = new ArrayList();

    public b(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.b.C0659b> list) {
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
            aVar.hes = (TextView) view.findViewById(a.f.tv_rank_label);
            aVar.het = (HeadImageView) view.findViewById(a.f.avatar_rank);
            aVar.heu = (TextView) view.findViewById(a.f.tv_rank_name);
            aVar.hev = (TextView) view.findViewById(a.f.tv_rank_score);
            a(aVar.het);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a.b.C0659b c0659b = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0659b != null) {
            aVar.hes.setText(c0659b.rank);
            aVar.het.startLoad(c0659b.portrait, 12, false);
            aVar.heu.setText(c0659b.nickname);
            aVar.hev.setText(this.mContext.getResources().getString(a.h.score_value, com.baidu.tieba.ala.guardthrone.e.a.HK(c0659b.score)));
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

    /* loaded from: classes11.dex */
    private class a {
        public TextView hes;
        public HeadImageView het;
        public TextView heu;
        public TextView hev;

        private a() {
        }
    }
}
