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
    private List<a.C0441a.C0442a> mList = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setList(List<a.C0441a.C0442a> list) {
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
        C0440a c0440a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_guard_throne_privilege_item_layout, (ViewGroup) null);
            c0440a = new C0440a();
            c0440a.dYm = (TextView) view.findViewById(a.g.tv_text);
            c0440a.eJb = (TbImageView) view.findViewById(a.g.iv_pic);
            c0440a.eJb.setDefaultBgResource(a.f.ala_guard_throne_privilege_corner_bg);
            view.setTag(c0440a);
        } else {
            c0440a = (C0440a) view.getTag();
        }
        a.C0441a.C0442a c0442a = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (c0442a != null) {
            c0440a.dYm.setText(c0442a.text);
            c0440a.eJb.startLoad(c0442a.pic, 10, false);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0440a {
        public TextView dYm;
        public TbImageView eJb;

        private C0440a() {
        }
    }
}
