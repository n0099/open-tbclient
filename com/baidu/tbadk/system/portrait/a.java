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
    private ArrayList<b> aLu;
    private int aLw;
    private int aLx;
    private TbPageContext<?> abz;
    private int padding;
    private int aLm = -1;
    private int aLy = 0;
    private int ajv = aj.getColor(d.e.common_color_10043);
    private int aLv = aj.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aLu = null;
        this.abz = null;
        this.padding = 0;
        this.abz = tbPageContext;
        this.aLu = new ArrayList<>();
        this.aLw = l.f(tbPageContext.getPageActivity(), d.f.ds1);
        this.aLx = l.f(this.abz.getPageActivity(), d.f.ds4);
        this.padding = l.f(this.abz.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLu != null) {
            return this.aLu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLu == null || i >= this.aLu.size()) {
            return null;
        }
        return this.aLu.get(i);
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
            view = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0064a = new C0064a();
            c0064a.awY = (LinearLayout) view.findViewById(d.h.photo_container);
            c0064a.aLz = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (fw(i) == 1) {
            c0064a.awY.setPadding(0, this.padding, 0, 0);
        } else if (fw(i) == 2) {
            c0064a.awY.setPadding(0, 0, 0, this.padding);
        } else {
            c0064a.awY.setPadding(0, 0, 0, 0);
        }
        c0064a.aLz.setDrawerType(0);
        c0064a.aLz.setBorderSurroundContent(true);
        c0064a.aLz.setDrawBorder(true);
        if (itemViewType == 0) {
            c0064a.aLz.setBorderColor(this.ajv);
            c0064a.aLz.setBorderWidth(this.aLw);
        } else {
            c0064a.aLz.setBorderColor(this.aLv);
            c0064a.aLz.setBorderWidth(this.aLx);
        }
        c0064a.aLz.setDefaultResource(d.g.transparent_bg);
        c0064a.aLz.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0064a.aLz.c(this.aLu.get(i).getUrl(), 10, false);
        view.setTag(c0064a);
        return view;
    }

    public int fw(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLy - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aLm ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<b> arrayList) {
        this.aLu = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLy = arrayList.size() / 4;
            } else {
                this.aLy = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fx(int i) {
        this.aLm = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a {
        TbImageView aLz;
        LinearLayout awY;

        private C0064a() {
        }
    }
}
