package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aLQ;
    private int aLS;
    private int aLT;
    private TbPageContext<?> abI;
    private int padding;
    private int aLJ = -1;
    private int aLU = 0;
    private int ajF = aj.getColor(d.C0080d.common_color_10043);
    private int aLR = aj.getColor(d.C0080d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aLQ = null;
        this.abI = null;
        this.padding = 0;
        this.abI = tbPageContext;
        this.aLQ = new ArrayList<>();
        this.aLS = l.f(tbPageContext.getPageActivity(), d.e.ds1);
        this.aLT = l.f(this.abI.getPageActivity(), d.e.ds4);
        this.padding = l.f(this.abI.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLQ != null) {
            return this.aLQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLQ == null || i >= this.aLQ.size()) {
            return null;
        }
        return this.aLQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0064a c0064a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0064a = new C0064a();
            c0064a.axj = (LinearLayout) view.findViewById(d.g.photo_container);
            c0064a.aLV = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (fw(i) == 1) {
            c0064a.axj.setPadding(0, this.padding, 0, 0);
        } else if (fw(i) == 2) {
            c0064a.axj.setPadding(0, 0, 0, this.padding);
        } else {
            c0064a.axj.setPadding(0, 0, 0, 0);
        }
        c0064a.aLV.setDrawerType(0);
        c0064a.aLV.setBorderSurroundContent(true);
        c0064a.aLV.setDrawBorder(true);
        if (itemViewType == 0) {
            c0064a.aLV.setBorderColor(this.ajF);
            c0064a.aLV.setBorderWidth(this.aLS);
        } else {
            c0064a.aLV.setBorderColor(this.aLR);
            c0064a.aLV.setBorderWidth(this.aLT);
        }
        c0064a.aLV.setDefaultResource(d.f.transparent_bg);
        c0064a.aLV.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0064a.aLV.startLoad(this.aLQ.get(i).getUrl(), 10, false);
        view.setTag(c0064a);
        return view;
    }

    public int fw(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLU - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aLJ ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aLQ = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLU = arrayList.size() / 4;
            } else {
                this.aLU = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fx(int i) {
        this.aLJ = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a {
        TbImageView aLV;
        LinearLayout axj;

        private C0064a() {
        }
    }
}
