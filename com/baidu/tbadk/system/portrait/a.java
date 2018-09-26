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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aZp;
    private int aZr;
    private int aZs;
    private TbPageContext<?> mContext;
    private int padding;
    private int aZi = -1;
    private int rowSize = 0;
    private int axg = al.getColor(e.d.common_color_10043);
    private int aZq = al.getColor(e.d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aZp = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aZp = new ArrayList<>();
        this.aZr = l.h(tbPageContext.getPageActivity(), e.C0141e.ds1);
        this.aZs = l.h(this.mContext.getPageActivity(), e.C0141e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), e.C0141e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZp != null) {
            return this.aZp.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aZp == null || i >= this.aZp.size()) {
            return null;
        }
        return this.aZp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0118a c0118a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.recommend_system_photo_item, viewGroup, false);
            c0118a = new C0118a();
            c0118a.aLG = (LinearLayout) view.findViewById(e.g.photo_container);
            c0118a.aZt = (TbImageView) view.findViewById(e.g.photo);
        } else {
            c0118a = (C0118a) view.getTag();
        }
        if (fB(i) == 1) {
            c0118a.aLG.setPadding(0, this.padding, 0, 0);
        } else if (fB(i) == 2) {
            c0118a.aLG.setPadding(0, 0, 0, this.padding);
        } else {
            c0118a.aLG.setPadding(0, 0, 0, 0);
        }
        c0118a.aZt.setDrawerType(0);
        c0118a.aZt.setBorderSurroundContent(true);
        c0118a.aZt.setDrawBorder(true);
        if (itemViewType == 0) {
            c0118a.aZt.setBorderColor(this.axg);
            c0118a.aZt.setBorderWidth(this.aZr);
        } else {
            c0118a.aZt.setBorderColor(this.aZq);
            c0118a.aZt.setBorderWidth(this.aZs);
        }
        c0118a.aZt.setDefaultResource(e.f.transparent_bg);
        c0118a.aZt.setDefaultErrorResource(e.f.icon_default_avatar100);
        c0118a.aZt.startLoad(this.aZp.get(i).getUrl(), 10, false);
        view.setTag(c0118a);
        return view;
    }

    public int fB(int i) {
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
        return i == this.aZi ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.aZp = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fC(int i) {
        this.aZi = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0118a {
        LinearLayout aLG;
        TbImageView aZt;

        private C0118a() {
        }
    }
}
