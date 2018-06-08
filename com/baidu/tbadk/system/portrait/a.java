package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aVd;
    private int aVf;
    private int aVg;
    private TbPageContext<?> mContext;
    private int padding;
    private int aUW = -1;
    private int rowSize = 0;
    private int atC = al.getColor(d.C0141d.common_color_10043);
    private int aVe = al.getColor(d.C0141d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aVd = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aVd = new ArrayList<>();
        this.aVf = l.e(tbPageContext.getPageActivity(), d.e.ds1);
        this.aVg = l.e(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.e(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVd != null) {
            return this.aVd.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVd == null || i >= this.aVd.size()) {
            return null;
        }
        return this.aVd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0120a c0120a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.recommend_system_photo_item, viewGroup, false);
            c0120a = new C0120a();
            c0120a.aHv = (LinearLayout) view.findViewById(d.g.photo_container);
            c0120a.aVh = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0120a = (C0120a) view.getTag();
        }
        if (fo(i) == 1) {
            c0120a.aHv.setPadding(0, this.padding, 0, 0);
        } else if (fo(i) == 2) {
            c0120a.aHv.setPadding(0, 0, 0, this.padding);
        } else {
            c0120a.aHv.setPadding(0, 0, 0, 0);
        }
        c0120a.aVh.setDrawerType(0);
        c0120a.aVh.setBorderSurroundContent(true);
        c0120a.aVh.setDrawBorder(true);
        if (itemViewType == 0) {
            c0120a.aVh.setBorderColor(this.atC);
            c0120a.aVh.setBorderWidth(this.aVf);
        } else {
            c0120a.aVh.setBorderColor(this.aVe);
            c0120a.aVh.setBorderWidth(this.aVg);
        }
        c0120a.aVh.setDefaultResource(d.f.transparent_bg);
        c0120a.aVh.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0120a.aVh.startLoad(this.aVd.get(i).getUrl(), 10, false);
        view.setTag(c0120a);
        return view;
    }

    public int fo(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.rowSize - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aUW ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<b> arrayList) {
        this.aVd = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fp(int i) {
        this.aUW = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0120a {
        LinearLayout aHv;
        TbImageView aVh;

        private C0120a() {
        }
    }
}
