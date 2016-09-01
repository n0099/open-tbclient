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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Gd;
    private int aEC;
    private int aED;
    private ArrayList<i> aEz;
    private int padding;
    private int aEr = -1;
    private int rowSize = 0;
    private int aEA = av.getColor(t.d.common_color_10043);
    private int aEB = av.getColor(t.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aEz = null;
        this.Gd = null;
        this.padding = 0;
        this.Gd = tbPageContext;
        this.aEz = new ArrayList<>();
        this.aEC = k.e(tbPageContext.getPageActivity(), t.e.ds1);
        this.aED = k.e(this.Gd.getPageActivity(), t.e.ds4);
        this.padding = k.e(this.Gd.getPageActivity(), t.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEz != null) {
            return this.aEz.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aEz == null || i >= this.aEz.size()) {
            return null;
        }
        return this.aEz.get(i);
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
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.aqH = (LinearLayout) view.findViewById(t.g.photo_container);
            aVar.aEE = (TbImageView) view.findViewById(t.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fh(i) == 1) {
            aVar.aqH.setPadding(0, this.padding, 0, 0);
        } else if (fh(i) == 2) {
            aVar.aqH.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.aqH.setPadding(0, 0, 0, 0);
        }
        aVar.aEE.setDrawerType(0);
        aVar.aEE.setBorderSurroundContent(true);
        aVar.aEE.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aEE.setBorderColor(this.aEA);
            aVar.aEE.setBorderWidth(this.aEC);
        } else {
            aVar.aEE.setBorderColor(this.aEB);
            aVar.aEE.setBorderWidth(this.aED);
        }
        aVar.aEE.setDefaultResource(t.f.transparent_bg);
        aVar.aEE.setDefaultErrorResource(t.f.icon_default_avatar100);
        aVar.aEE.c(this.aEz.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fh(int i) {
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
        return i == this.aEr ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aEz = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fi(int i) {
        this.aEr = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aEE;
        LinearLayout aqH;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
