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
    private List<a.C0639a.C0640a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0639a.C0640a> list) {
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
        C0638a c0638a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0638a = new C0638a();
            c0638a.ePF = (TextView) view.findViewById(a.g.tv_text);
            c0638a.gDW = (TbImageView) view.findViewById(a.g.iv_pic);
            c0638a.gDW.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0638a);
        } else {
            c0638a = (C0638a) view.getTag();
        }
        a.C0639a.C0640a c0640a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0640a != null) {
            c0638a.ePF.setText(c0640a.text);
            c0638a.gDW.startLoad(c0640a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0638a {
        public TextView ePF;
        public TbImageView gDW;

        private C0638a() {
        }
    }
}
