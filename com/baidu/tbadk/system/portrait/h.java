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
    private ArrayList<i> aIL;
    private int aIO;
    private int aIP;
    private TbPageContext<?> aaY;
    private int padding;
    private int aID = -1;
    private int aIQ = 0;
    private int aIM = aq.getColor(w.e.common_color_10043);
    private int aIN = aq.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aIL = null;
        this.aaY = null;
        this.padding = 0;
        this.aaY = tbPageContext;
        this.aIL = new ArrayList<>();
        this.aIO = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aIP = k.g(this.aaY.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aaY.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL != null) {
            return this.aIL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
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
            view = LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.avE = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aIR = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fh(i) == 1) {
            aVar.avE.setPadding(0, this.padding, 0, 0);
        } else if (fh(i) == 2) {
            aVar.avE.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.avE.setPadding(0, 0, 0, 0);
        }
        aVar.aIR.setDrawerType(0);
        aVar.aIR.setBorderSurroundContent(true);
        aVar.aIR.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aIR.setBorderColor(this.aIM);
            aVar.aIR.setBorderWidth(this.aIO);
        } else {
            aVar.aIR.setBorderColor(this.aIN);
            aVar.aIR.setBorderWidth(this.aIP);
        }
        aVar.aIR.setDefaultResource(w.g.transparent_bg);
        aVar.aIR.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aIR.c(this.aIL.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fh(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aIQ - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aID ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aIL = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aIQ = arrayList.size() / 4;
            } else {
                this.aIQ = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fi(int i) {
        this.aID = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aIR;
        LinearLayout avE;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
