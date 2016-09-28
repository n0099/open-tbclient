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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Gd;
    private ArrayList<i> aDX;
    private int aEa;
    private int aEb;
    private int padding;
    private int aDP = -1;
    private int rowSize = 0;
    private int aDY = av.getColor(r.d.common_color_10043);
    private int aDZ = av.getColor(r.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aDX = null;
        this.Gd = null;
        this.padding = 0;
        this.Gd = tbPageContext;
        this.aDX = new ArrayList<>();
        this.aEa = k.e(tbPageContext.getPageActivity(), r.e.ds1);
        this.aEb = k.e(this.Gd.getPageActivity(), r.e.ds4);
        this.padding = k.e(this.Gd.getPageActivity(), r.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDX != null) {
            return this.aDX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aDX == null || i >= this.aDX.size()) {
            return null;
        }
        return this.aDX.get(i);
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
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.aqp = (LinearLayout) view.findViewById(r.g.photo_container);
            aVar.aEc = (TbImageView) view.findViewById(r.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fg(i) == 1) {
            aVar.aqp.setPadding(0, this.padding, 0, 0);
        } else if (fg(i) == 2) {
            aVar.aqp.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.aqp.setPadding(0, 0, 0, 0);
        }
        aVar.aEc.setDrawerType(0);
        aVar.aEc.setBorderSurroundContent(true);
        aVar.aEc.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aEc.setBorderColor(this.aDY);
            aVar.aEc.setBorderWidth(this.aEa);
        } else {
            aVar.aEc.setBorderColor(this.aDZ);
            aVar.aEc.setBorderWidth(this.aEb);
        }
        aVar.aEc.setDefaultResource(r.f.transparent_bg);
        aVar.aEc.setDefaultErrorResource(r.f.icon_default_avatar100);
        aVar.aEc.c(this.aDX.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fg(int i) {
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
        return i == this.aDP ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aDX = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fh(int i) {
        this.aDP = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aEc;
        LinearLayout aqp;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
