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
    private ArrayList<b> aLV;
    private int aLX;
    private int aLY;
    private TbPageContext<?> aby;
    private int padding;
    private int aLN = -1;
    private int aLZ = 0;
    private int amG = aj.getColor(d.e.common_color_10043);
    private int aLW = aj.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aLV = null;
        this.aby = null;
        this.padding = 0;
        this.aby = tbPageContext;
        this.aLV = new ArrayList<>();
        this.aLX = k.g(tbPageContext.getPageActivity(), d.f.ds1);
        this.aLY = k.g(this.aby.getPageActivity(), d.f.ds4);
        this.padding = k.g(this.aby.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLV != null) {
            return this.aLV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLV == null || i >= this.aLV.size()) {
            return null;
        }
        return this.aLV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0066a c0066a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0066a = new C0066a();
            c0066a.axR = (LinearLayout) view.findViewById(d.h.photo_container);
            c0066a.aMa = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0066a = (C0066a) view.getTag();
        }
        if (fl(i) == 1) {
            c0066a.axR.setPadding(0, this.padding, 0, 0);
        } else if (fl(i) == 2) {
            c0066a.axR.setPadding(0, 0, 0, this.padding);
        } else {
            c0066a.axR.setPadding(0, 0, 0, 0);
        }
        c0066a.aMa.setDrawerType(0);
        c0066a.aMa.setBorderSurroundContent(true);
        c0066a.aMa.setDrawBorder(true);
        if (itemViewType == 0) {
            c0066a.aMa.setBorderColor(this.amG);
            c0066a.aMa.setBorderWidth(this.aLX);
        } else {
            c0066a.aMa.setBorderColor(this.aLW);
            c0066a.aMa.setBorderWidth(this.aLY);
        }
        c0066a.aMa.setDefaultResource(d.g.transparent_bg);
        c0066a.aMa.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0066a.aMa.c(this.aLV.get(i).getUrl(), 10, false);
        view.setTag(c0066a);
        return view;
    }

    public int fl(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLZ - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aLN ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aLV = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLZ = arrayList.size() / 4;
            } else {
                this.aLZ = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fm(int i) {
        this.aLN = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066a {
        TbImageView aMa;
        LinearLayout axR;

        private C0066a() {
        }
    }
}
