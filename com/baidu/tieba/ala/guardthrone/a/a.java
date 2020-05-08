package com.baidu.tieba.ala.guardthrone.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardthrone.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<a.C0497a.C0498a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0497a.C0498a> list) {
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
        C0496a c0496a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0496a = new C0496a();
            c0496a.eyE = (TextView) view.findViewById(a.g.tv_text);
            c0496a.fnT = (TbImageView) view.findViewById(a.g.iv_pic);
            c0496a.fnT.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0496a);
        } else {
            c0496a = (C0496a) view.getTag();
        }
        a.C0497a.C0498a c0498a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0498a != null) {
            c0496a.eyE.setText(c0498a.text);
            c0496a.fnT.startLoad(c0498a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0496a {
        public TextView eyE;
        public TbImageView fnT;

        private C0496a() {
        }
    }
}
