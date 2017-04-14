package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<i> aIJ;
    private int aIM;
    private int aIN;
    private TbPageContext<?> aaX;
    private int padding;
    private int aIB = -1;
    private int aIO = 0;
    private int aIK = aq.getColor(w.e.common_color_10043);
    private int aIL = aq.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aIJ = null;
        this.aaX = null;
        this.padding = 0;
        this.aaX = tbPageContext;
        this.aIJ = new ArrayList<>();
        this.aIM = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aIN = k.g(this.aaX.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aaX.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIJ != null) {
            return this.aIJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIJ == null || i >= this.aIJ.size()) {
            return null;
        }
        return this.aIJ.get(i);
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
            view = LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.avC = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aIP = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fh(i) == 1) {
            aVar.avC.setPadding(0, this.padding, 0, 0);
        } else if (fh(i) == 2) {
            aVar.avC.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.avC.setPadding(0, 0, 0, 0);
        }
        aVar.aIP.setDrawerType(0);
        aVar.aIP.setBorderSurroundContent(true);
        aVar.aIP.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aIP.setBorderColor(this.aIK);
            aVar.aIP.setBorderWidth(this.aIM);
        } else {
            aVar.aIP.setBorderColor(this.aIL);
            aVar.aIP.setBorderWidth(this.aIN);
        }
        aVar.aIP.setDefaultResource(w.g.transparent_bg);
        aVar.aIP.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aIP.c(this.aIJ.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fh(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aIO - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aIB ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aIJ = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aIO = arrayList.size() / 4;
            } else {
                this.aIO = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fi(int i) {
        this.aIB = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aIP;
        LinearLayout avC;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
