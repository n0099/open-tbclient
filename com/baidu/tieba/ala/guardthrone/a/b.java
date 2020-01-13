package com.baidu.tieba.ala.guardthrone.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.guardthrone.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private List<a.b.C0433b> mList = new ArrayList();

    public b(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.b.C0433b> list) {
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
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_rank_item_layout, (ViewGroup) null);
            aVar = new a();
            aVar.eEV = (TextView) view.findViewById(a.g.tv_rank_label);
            aVar.eEW = (HeadImageView) view.findViewById(a.g.avatar_rank);
            aVar.eEX = (TextView) view.findViewById(a.g.tv_rank_name);
            aVar.eEY = (TextView) view.findViewById(a.g.tv_rank_score);
            a(aVar.eEW);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a.b.C0433b c0433b = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0433b != null) {
            aVar.eEV.setText(c0433b.rank);
            aVar.eEW.startLoad(c0433b.portrait, 12, false);
            aVar.eEX.setText(c0433b.nickname);
            aVar.eEY.setText(this.mContext.getResources().getString(a.i.score_value, com.baidu.tieba.ala.guardthrone.e.a.yg(c0433b.score)));
        }
        return view;
    }

    private void a(HeadImageView headImageView) {
        headImageView.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        headImageView.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* loaded from: classes2.dex */
    private class a {
        public TextView eEV;
        public HeadImageView eEW;
        public TextView eEX;
        public TextView eEY;

        private a() {
        }
    }
}
