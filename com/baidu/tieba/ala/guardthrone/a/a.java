package com.baidu.tieba.ala.guardthrone.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardthrone.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<a.C0430a.C0431a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0430a.C0431a> list) {
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
        C0429a c0429a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0429a = new C0429a();
            c0429a.dTT = (TextView) view.findViewById(a.g.tv_text);
            c0429a.eET = (TbImageView) view.findViewById(a.g.iv_pic);
            c0429a.eET.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0429a);
        } else {
            c0429a = (C0429a) view.getTag();
        }
        a.C0430a.C0431a c0431a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0431a != null) {
            c0429a.dTT.setText(c0431a.text);
            c0429a.eET.startLoad(c0431a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0429a {
        public TextView dTT;
        public TbImageView eET;

        private C0429a() {
        }
    }
}
