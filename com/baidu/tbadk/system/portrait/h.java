package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Gf;
    private ArrayList<i> aEN;
    private int aEQ;
    private int aER;
    private int padding;
    private int aEF = -1;
    private int rowSize = 0;
    private int aEO = at.getColor(r.d.common_color_10043);
    private int aEP = at.getColor(r.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aEN = null;
        this.Gf = null;
        this.padding = 0;
        this.Gf = tbPageContext;
        this.aEN = new ArrayList<>();
        this.aEQ = k.e(tbPageContext.getPageActivity(), r.e.ds1);
        this.aER = k.e(this.Gf.getPageActivity(), r.e.ds4);
        this.padding = k.e(this.Gf.getPageActivity(), r.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEN != null) {
            return this.aEN.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aEN == null || i >= this.aEN.size()) {
            return null;
        }
        return this.aEN.get(i);
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
            view = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.arj = (LinearLayout) view.findViewById(r.g.photo_container);
            aVar.aES = (TbImageView) view.findViewById(r.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fj(i) == 1) {
            aVar.arj.setPadding(0, this.padding, 0, 0);
        } else if (fj(i) == 2) {
            aVar.arj.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.arj.setPadding(0, 0, 0, 0);
        }
        aVar.aES.setDrawerType(0);
        aVar.aES.setBorderSurroundContent(true);
        aVar.aES.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aES.setBorderColor(this.aEO);
            aVar.aES.setBorderWidth(this.aEQ);
        } else {
            aVar.aES.setBorderColor(this.aEP);
            aVar.aES.setBorderWidth(this.aER);
        }
        aVar.aES.setDefaultResource(r.f.transparent_bg);
        aVar.aES.setDefaultErrorResource(r.f.icon_default_avatar100);
        aVar.aES.c(this.aEN.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fj(int i) {
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
        return i == this.aEF ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.aEN = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fk(int i) {
        this.aEF = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aES;
        LinearLayout arj;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
