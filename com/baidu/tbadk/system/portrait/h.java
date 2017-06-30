package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<i> aJQ;
    private int aJS;
    private int aJT;
    private TbPageContext<?> aat;
    private int padding;
    private int aJI = -1;
    private int aJU = 0;
    private int alo = as.getColor(w.e.common_color_10043);
    private int aJR = as.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aJQ = null;
        this.aat = null;
        this.padding = 0;
        this.aat = tbPageContext;
        this.aJQ = new ArrayList<>();
        this.aJS = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aJT = k.g(this.aat.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aat.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJQ != null) {
            return this.aJQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aJQ == null || i >= this.aJQ.size()) {
            return null;
        }
        return this.aJQ.get(i);
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
            view = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.awv = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aJV = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fg(i) == 1) {
            aVar.awv.setPadding(0, this.padding, 0, 0);
        } else if (fg(i) == 2) {
            aVar.awv.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.awv.setPadding(0, 0, 0, 0);
        }
        aVar.aJV.setDrawerType(0);
        aVar.aJV.setBorderSurroundContent(true);
        aVar.aJV.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aJV.setBorderColor(this.alo);
            aVar.aJV.setBorderWidth(this.aJS);
        } else {
            aVar.aJV.setBorderColor(this.aJR);
            aVar.aJV.setBorderWidth(this.aJT);
        }
        aVar.aJV.setDefaultResource(w.g.transparent_bg);
        aVar.aJV.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aJV.c(this.aJQ.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fg(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aJU - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aJI ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aJQ = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aJU = arrayList.size() / 4;
            } else {
                this.aJU = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fh(int i) {
        this.aJI = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aJV;
        LinearLayout awv;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
