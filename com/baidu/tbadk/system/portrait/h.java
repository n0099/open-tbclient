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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> MX;
    private ArrayList<i> aDG;
    private int aDJ;
    private int aDK;
    private int padding;
    private int aDy = -1;
    private int rowSize = 0;
    private int aDH = at.getColor(t.d.black_alpha10);
    private int aDI = at.getColor(t.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aDG = null;
        this.MX = null;
        this.padding = 0;
        this.MX = tbPageContext;
        this.aDG = new ArrayList<>();
        this.aDJ = k.c(tbPageContext.getPageActivity(), t.e.ds1);
        this.aDK = k.c(this.MX.getPageActivity(), t.e.ds4);
        this.padding = k.c(this.MX.getPageActivity(), t.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDG != null) {
            return this.aDG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aDG == null || i >= this.aDG.size()) {
            return null;
        }
        return this.aDG.get(i);
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
            view = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.aqr = (LinearLayout) view.findViewById(t.g.photo_container);
            aVar.aDL = (TbImageView) view.findViewById(t.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fk(i) == 1) {
            aVar.aqr.setPadding(0, this.padding, 0, 0);
        } else if (fk(i) == 2) {
            aVar.aqr.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.aqr.setPadding(0, 0, 0, 0);
        }
        aVar.aDL.setDrawerType(0);
        aVar.aDL.setBorderSurroundContent(true);
        aVar.aDL.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aDL.setBorderColor(this.aDH);
            aVar.aDL.setBorderWidth(this.aDJ);
        } else {
            aVar.aDL.setBorderColor(this.aDI);
            aVar.aDL.setBorderWidth(this.aDK);
        }
        aVar.aDL.setDefaultResource(t.f.transparent_bg);
        aVar.aDL.setDefaultErrorResource(t.f.icon_default_avatar100);
        aVar.aDL.c(this.aDG.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fk(int i) {
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
        return i == this.aDy ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<i> arrayList) {
        this.aDG = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fl(int i) {
        this.aDy = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aDL;
        LinearLayout aqr;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
