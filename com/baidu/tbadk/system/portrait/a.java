package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aWa;
    private int aWc;
    private int aWd;
    private TbPageContext<?> mContext;
    private int padding;
    private int aVT = -1;
    private int rowSize = 0;
    private int atT = am.getColor(d.C0140d.common_color_10043);
    private int aWb = am.getColor(d.C0140d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aWa = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aWa = new ArrayList<>();
        this.aWc = l.f(tbPageContext.getPageActivity(), d.e.ds1);
        this.aWd = l.f(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.f(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aWa != null) {
            return this.aWa.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aWa == null || i >= this.aWa.size()) {
            return null;
        }
        return this.aWa.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0118a = new C0118a();
            c0118a.aIs = (LinearLayout) view.findViewById(d.g.photo_container);
            c0118a.aWe = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0118a = (C0118a) view.getTag();
        }
        if (fq(i) == 1) {
            c0118a.aIs.setPadding(0, this.padding, 0, 0);
        } else if (fq(i) == 2) {
            c0118a.aIs.setPadding(0, 0, 0, this.padding);
        } else {
            c0118a.aIs.setPadding(0, 0, 0, 0);
        }
        c0118a.aWe.setDrawerType(0);
        c0118a.aWe.setBorderSurroundContent(true);
        c0118a.aWe.setDrawBorder(true);
        if (itemViewType == 0) {
            c0118a.aWe.setBorderColor(this.atT);
            c0118a.aWe.setBorderWidth(this.aWc);
        } else {
            c0118a.aWe.setBorderColor(this.aWb);
            c0118a.aWe.setBorderWidth(this.aWd);
        }
        c0118a.aWe.setDefaultResource(d.f.transparent_bg);
        c0118a.aWe.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0118a.aWe.startLoad(this.aWa.get(i).getUrl(), 10, false);
        view.setTag(c0118a);
        return view;
    }

    public int fq(int i) {
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
        return i == this.aVT ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.aWa = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fr(int i) {
        this.aVT = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0118a {
        LinearLayout aIs;
        TbImageView aWe;

        private C0118a() {
        }
    }
}
