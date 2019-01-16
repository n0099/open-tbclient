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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<b> biR;
    private int biT;
    private int biU;
    private TbPageContext<?> mContext;
    private int padding;
    private int biK = -1;
    private int rowSize = 0;
    private int aGI = al.getColor(e.d.common_color_10043);
    private int biS = al.getColor(e.d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.biR = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.biR = new ArrayList<>();
        this.biT = l.h(tbPageContext.getPageActivity(), e.C0210e.ds1);
        this.biU = l.h(this.mContext.getPageActivity(), e.C0210e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), e.C0210e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.biR != null) {
            return this.biR.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.biR == null || i >= this.biR.size()) {
            return null;
        }
        return this.biR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0176a c0176a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.recommend_system_photo_item, viewGroup, false);
            c0176a = new C0176a();
            c0176a.aVi = (LinearLayout) view.findViewById(e.g.photo_container);
            c0176a.biV = (TbImageView) view.findViewById(e.g.photo);
        } else {
            c0176a = (C0176a) view.getTag();
        }
        if (gn(i) == 1) {
            c0176a.aVi.setPadding(0, this.padding, 0, 0);
        } else if (gn(i) == 2) {
            c0176a.aVi.setPadding(0, 0, 0, this.padding);
        } else {
            c0176a.aVi.setPadding(0, 0, 0, 0);
        }
        c0176a.biV.setDrawerType(0);
        c0176a.biV.setBorderSurroundContent(true);
        c0176a.biV.setDrawBorder(true);
        if (itemViewType == 0) {
            c0176a.biV.setBorderColor(this.aGI);
            c0176a.biV.setBorderWidth(this.biT);
        } else {
            c0176a.biV.setBorderColor(this.biS);
            c0176a.biV.setBorderWidth(this.biU);
        }
        c0176a.biV.setDefaultResource(e.f.transparent_bg);
        c0176a.biV.setDefaultErrorResource(e.f.icon_default_avatar100);
        c0176a.biV.startLoad(this.biR.get(i).getUrl(), 10, false);
        view.setTag(c0176a);
        return view;
    }

    public int gn(int i) {
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
        return i == this.biK ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.biR = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void go(int i) {
        this.biK = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0176a {
        LinearLayout aVi;
        TbImageView biV;

        private C0176a() {
        }
    }
}
