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
    private ArrayList<b> beE;
    private int beG;
    private int beH;
    private TbPageContext<?> mContext;
    private int padding;
    private int bex = -1;
    private int rowSize = 0;
    private int aCF = al.getColor(e.d.common_color_10043);
    private int beF = al.getColor(e.d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.beE = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.beE = new ArrayList<>();
        this.beG = l.h(tbPageContext.getPageActivity(), e.C0200e.ds1);
        this.beH = l.h(this.mContext.getPageActivity(), e.C0200e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), e.C0200e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.beE != null) {
            return this.beE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.beE == null || i >= this.beE.size()) {
            return null;
        }
        return this.beE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0166a c0166a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.recommend_system_photo_item, viewGroup, false);
            c0166a = new C0166a();
            c0166a.aQY = (LinearLayout) view.findViewById(e.g.photo_container);
            c0166a.beI = (TbImageView) view.findViewById(e.g.photo);
        } else {
            c0166a = (C0166a) view.getTag();
        }
        if (fY(i) == 1) {
            c0166a.aQY.setPadding(0, this.padding, 0, 0);
        } else if (fY(i) == 2) {
            c0166a.aQY.setPadding(0, 0, 0, this.padding);
        } else {
            c0166a.aQY.setPadding(0, 0, 0, 0);
        }
        c0166a.beI.setDrawerType(0);
        c0166a.beI.setBorderSurroundContent(true);
        c0166a.beI.setDrawBorder(true);
        if (itemViewType == 0) {
            c0166a.beI.setBorderColor(this.aCF);
            c0166a.beI.setBorderWidth(this.beG);
        } else {
            c0166a.beI.setBorderColor(this.beF);
            c0166a.beI.setBorderWidth(this.beH);
        }
        c0166a.beI.setDefaultResource(e.f.transparent_bg);
        c0166a.beI.setDefaultErrorResource(e.f.icon_default_avatar100);
        c0166a.beI.startLoad(this.beE.get(i).getUrl(), 10, false);
        view.setTag(c0166a);
        return view;
    }

    public int fY(int i) {
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
        return i == this.bex ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.beE = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fZ(int i) {
        this.bex = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0166a {
        LinearLayout aQY;
        TbImageView beI;

        private C0166a() {
        }
    }
}
