package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Dp;
    private ArrayList<i> aAC;
    private int aAF;
    private int aAG;
    private int padding;
    private int aAu = -1;
    private int rowSize = 0;
    private int aAD = av.getColor(u.d.common_color_10043);
    private int aAE = av.getColor(u.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aAC = null;
        this.Dp = null;
        this.padding = 0;
        this.Dp = tbPageContext;
        this.aAC = new ArrayList<>();
        this.aAF = k.c(tbPageContext.getPageActivity(), u.e.ds1);
        this.aAG = k.c(this.Dp.getPageActivity(), u.e.ds4);
        this.padding = k.c(this.Dp.getPageActivity(), u.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAC != null) {
            return this.aAC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aAC == null || i >= this.aAC.size()) {
            return null;
        }
        return this.aAC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.amL = (LinearLayout) view.findViewById(u.g.photo_container);
            aVar.aAH = (TbImageView) view.findViewById(u.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eT(i) == 1) {
            aVar.amL.setPadding(0, this.padding, 0, 0);
        } else if (eT(i) == 2) {
            aVar.amL.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.amL.setPadding(0, 0, 0, 0);
        }
        aVar.aAH.setDrawerType(0);
        aVar.aAH.setBorderSurroundContent(true);
        aVar.aAH.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aAH.setBorderColor(this.aAD);
            aVar.aAH.setBorderWidth(this.aAF);
        } else {
            aVar.aAH.setBorderColor(this.aAE);
            aVar.aAH.setBorderWidth(this.aAG);
        }
        aVar.aAH.setDefaultResource(u.f.transparent_bg);
        aVar.aAH.setDefaultErrorResource(u.f.icon_default_avatar100);
        aVar.aAH.c(this.aAC.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eT(int i) {
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
        return i == this.aAu ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<i> arrayList) {
        this.aAC = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eU(int i) {
        this.aAu = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aAH;
        LinearLayout amL;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
