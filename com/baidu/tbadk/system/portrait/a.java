package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aLS;
    private int aLU;
    private int aLV;
    private TbPageContext<?> aby;
    private int padding;
    private int aLK = -1;
    private int aLW = 0;
    private int amE = aj.getColor(d.e.common_color_10043);
    private int aLT = aj.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aLS = null;
        this.aby = null;
        this.padding = 0;
        this.aby = tbPageContext;
        this.aLS = new ArrayList<>();
        this.aLU = k.f(tbPageContext.getPageActivity(), d.f.ds1);
        this.aLV = k.f(this.aby.getPageActivity(), d.f.ds4);
        this.padding = k.f(this.aby.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLS != null) {
            return this.aLS.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLS == null || i >= this.aLS.size()) {
            return null;
        }
        return this.aLS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0065a c0065a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0065a = new C0065a();
            c0065a.axO = (LinearLayout) view.findViewById(d.h.photo_container);
            c0065a.aLX = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0065a = (C0065a) view.getTag();
        }
        if (fl(i) == 1) {
            c0065a.axO.setPadding(0, this.padding, 0, 0);
        } else if (fl(i) == 2) {
            c0065a.axO.setPadding(0, 0, 0, this.padding);
        } else {
            c0065a.axO.setPadding(0, 0, 0, 0);
        }
        c0065a.aLX.setDrawerType(0);
        c0065a.aLX.setBorderSurroundContent(true);
        c0065a.aLX.setDrawBorder(true);
        if (itemViewType == 0) {
            c0065a.aLX.setBorderColor(this.amE);
            c0065a.aLX.setBorderWidth(this.aLU);
        } else {
            c0065a.aLX.setBorderColor(this.aLT);
            c0065a.aLX.setBorderWidth(this.aLV);
        }
        c0065a.aLX.setDefaultResource(d.g.transparent_bg);
        c0065a.aLX.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0065a.aLX.c(this.aLS.get(i).getUrl(), 10, false);
        view.setTag(c0065a);
        return view;
    }

    public int fl(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLW - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aLK ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aLS = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLW = arrayList.size() / 4;
            } else {
                this.aLW = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fm(int i) {
        this.aLK = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0065a {
        TbImageView aLX;
        LinearLayout axO;

        private C0065a() {
        }
    }
}
