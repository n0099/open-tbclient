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
    private ArrayList<b> aLh;
    private int aLj;
    private int aLk;
    private TbPageContext<?> abm;
    private int padding;
    private int aKZ = -1;
    private int aLl = 0;
    private int ajj = aj.getColor(d.e.common_color_10043);
    private int aLi = aj.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aLh = null;
        this.abm = null;
        this.padding = 0;
        this.abm = tbPageContext;
        this.aLh = new ArrayList<>();
        this.aLj = l.f(tbPageContext.getPageActivity(), d.f.ds1);
        this.aLk = l.f(this.abm.getPageActivity(), d.f.ds4);
        this.padding = l.f(this.abm.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLh != null) {
            return this.aLh.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLh == null || i >= this.aLh.size()) {
            return null;
        }
        return this.aLh.get(i);
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
            view = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0064a = new C0064a();
            c0064a.awM = (LinearLayout) view.findViewById(d.h.photo_container);
            c0064a.aLm = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (fv(i) == 1) {
            c0064a.awM.setPadding(0, this.padding, 0, 0);
        } else if (fv(i) == 2) {
            c0064a.awM.setPadding(0, 0, 0, this.padding);
        } else {
            c0064a.awM.setPadding(0, 0, 0, 0);
        }
        c0064a.aLm.setDrawerType(0);
        c0064a.aLm.setBorderSurroundContent(true);
        c0064a.aLm.setDrawBorder(true);
        if (itemViewType == 0) {
            c0064a.aLm.setBorderColor(this.ajj);
            c0064a.aLm.setBorderWidth(this.aLj);
        } else {
            c0064a.aLm.setBorderColor(this.aLi);
            c0064a.aLm.setBorderWidth(this.aLk);
        }
        c0064a.aLm.setDefaultResource(d.g.transparent_bg);
        c0064a.aLm.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0064a.aLm.c(this.aLh.get(i).getUrl(), 10, false);
        view.setTag(c0064a);
        return view;
    }

    public int fv(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLl - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aKZ ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<b> arrayList) {
        this.aLh = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLl = arrayList.size() / 4;
            } else {
                this.aLl = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fw(int i) {
        this.aKZ = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a {
        TbImageView aLm;
        LinearLayout awM;

        private C0064a() {
        }
    }
}
