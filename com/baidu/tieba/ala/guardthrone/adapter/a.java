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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<a.C0651a.C0652a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0651a.C0652a> list) {
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
        C0650a c0650a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0650a = new C0650a();
            c0650a.eUF = (TextView) view.findViewById(a.f.tv_text);
            c0650a.gJq = (TbImageView) view.findViewById(a.f.iv_pic);
            c0650a.gJq.setDefaultBgResource(a.e.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0650a);
        } else {
            c0650a = (C0650a) view.getTag();
        }
        a.C0651a.C0652a c0652a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0652a != null) {
            c0650a.eUF.setText(c0652a.text);
            c0650a.gJq.startLoad(c0652a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0650a {
        public TextView eUF;
        public TbImageView gJq;

        private C0650a() {
        }
    }
}
