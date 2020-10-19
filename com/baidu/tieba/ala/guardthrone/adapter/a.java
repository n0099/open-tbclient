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
    private List<a.C0623a.C0624a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0623a.C0624a> list) {
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
        C0622a c0622a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0622a = new C0622a();
            c0622a.eHj = (TextView) view.findViewById(a.g.tv_text);
            c0622a.gtS = (TbImageView) view.findViewById(a.g.iv_pic);
            c0622a.gtS.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0622a);
        } else {
            c0622a = (C0622a) view.getTag();
        }
        a.C0623a.C0624a c0624a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0624a != null) {
            c0622a.eHj.setText(c0624a.text);
            c0622a.gtS.startLoad(c0624a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0622a {
        public TextView eHj;
        public TbImageView gtS;

        private C0622a() {
        }
    }
}
