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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<b> csO;
    private int csQ;
    private int csR;
    private TbPageContext<?> mContext;
    private int padding;
    private int csH = -1;
    private int rowSize = 0;
    private int bOT = al.getColor(d.C0277d.common_color_10043);
    private int csP = al.getColor(d.C0277d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.csO = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.csO = new ArrayList<>();
        this.csQ = l.h(tbPageContext.getPageActivity(), d.e.ds1);
        this.csR = l.h(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.csO != null) {
            return this.csO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.csO == null || i >= this.csO.size()) {
            return null;
        }
        return this.csO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0244a c0244a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0244a = new C0244a();
            c0244a.ceG = (LinearLayout) view.findViewById(d.g.photo_container);
            c0244a.csS = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0244a = (C0244a) view.getTag();
        }
        if (ka(i) == 1) {
            c0244a.ceG.setPadding(0, this.padding, 0, 0);
        } else if (ka(i) == 2) {
            c0244a.ceG.setPadding(0, 0, 0, this.padding);
        } else {
            c0244a.ceG.setPadding(0, 0, 0, 0);
        }
        c0244a.csS.setDrawerType(0);
        c0244a.csS.setBorderSurroundContent(true);
        c0244a.csS.setDrawBorder(true);
        if (itemViewType == 0) {
            c0244a.csS.setBorderColor(this.bOT);
            c0244a.csS.setBorderWidth(this.csQ);
        } else {
            c0244a.csS.setBorderColor(this.csP);
            c0244a.csS.setBorderWidth(this.csR);
        }
        c0244a.csS.setDefaultResource(d.f.transparent_bg);
        c0244a.csS.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0244a.csS.startLoad(this.csO.get(i).getUrl(), 10, false);
        view.setTag(c0244a);
        return view;
    }

    public int ka(int i) {
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
        return i == this.csH ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void x(ArrayList<b> arrayList) {
        this.csO = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kb(int i) {
        this.csH = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0244a {
        LinearLayout ceG;
        TbImageView csS;

        private C0244a() {
        }
    }
}
