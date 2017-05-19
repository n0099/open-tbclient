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
    private ArrayList<i> aIO;
    private int aIQ;
    private int aIR;
    private TbPageContext<?> aat;
    private int padding;
    private int aIG = -1;
    private int aIS = 0;
    private int akK = aq.getColor(w.e.common_color_10043);
    private int aIP = aq.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aIO = null;
        this.aat = null;
        this.padding = 0;
        this.aat = tbPageContext;
        this.aIO = new ArrayList<>();
        this.aIQ = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aIR = k.g(this.aat.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aat.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIO != null) {
            return this.aIO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIO == null || i >= this.aIO.size()) {
            return null;
        }
        return this.aIO.get(i);
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
            aVar.avI = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aIT = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fd(i) == 1) {
            aVar.avI.setPadding(0, this.padding, 0, 0);
        } else if (fd(i) == 2) {
            aVar.avI.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.avI.setPadding(0, 0, 0, 0);
        }
        aVar.aIT.setDrawerType(0);
        aVar.aIT.setBorderSurroundContent(true);
        aVar.aIT.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aIT.setBorderColor(this.akK);
            aVar.aIT.setBorderWidth(this.aIQ);
        } else {
            aVar.aIT.setBorderColor(this.aIP);
            aVar.aIT.setBorderWidth(this.aIR);
        }
        aVar.aIT.setDefaultResource(w.g.transparent_bg);
        aVar.aIT.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aIT.c(this.aIO.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fd(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aIS - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aIG ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aIO = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aIS = arrayList.size() / 4;
            } else {
                this.aIS = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fe(int i) {
        this.aIG = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aIT;
        LinearLayout avI;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
