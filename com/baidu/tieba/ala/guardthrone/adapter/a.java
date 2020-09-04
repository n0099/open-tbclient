package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardthrone.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<a.C0610a.C0611a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0610a.C0611a> list) {
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
        C0609a c0609a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0609a = new C0609a();
            c0609a.esU = (TextView) view.findViewById(a.g.tv_text);
            c0609a.ges = (TbImageView) view.findViewById(a.g.iv_pic);
            c0609a.ges.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0609a);
        } else {
            c0609a = (C0609a) view.getTag();
        }
        a.C0610a.C0611a c0611a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0611a != null) {
            c0609a.esU.setText(c0611a.text);
            c0609a.ges.startLoad(c0611a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0609a {
        public TextView esU;
        public TbImageView ges;

        private C0609a() {
        }
    }
}
