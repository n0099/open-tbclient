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
    private ArrayList<i> aIB;
    private int aID;
    private int aIE;
    private TbPageContext<?> aas;
    private int padding;
    private int aIt = -1;
    private int aIF = 0;
    private int akA = aq.getColor(w.e.common_color_10043);
    private int aIC = aq.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aIB = null;
        this.aas = null;
        this.padding = 0;
        this.aas = tbPageContext;
        this.aIB = new ArrayList<>();
        this.aID = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aIE = k.g(this.aas.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aas.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIB != null) {
            return this.aIB.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIB == null || i >= this.aIB.size()) {
            return null;
        }
        return this.aIB.get(i);
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
            view = LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.avs = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aIG = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fe(i) == 1) {
            aVar.avs.setPadding(0, this.padding, 0, 0);
        } else if (fe(i) == 2) {
            aVar.avs.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.avs.setPadding(0, 0, 0, 0);
        }
        aVar.aIG.setDrawerType(0);
        aVar.aIG.setBorderSurroundContent(true);
        aVar.aIG.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aIG.setBorderColor(this.akA);
            aVar.aIG.setBorderWidth(this.aID);
        } else {
            aVar.aIG.setBorderColor(this.aIC);
            aVar.aIG.setBorderWidth(this.aIE);
        }
        aVar.aIG.setDefaultResource(w.g.transparent_bg);
        aVar.aIG.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aIG.c(this.aIB.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fe(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aIF - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aIt ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aIB = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aIF = arrayList.size() / 4;
            } else {
                this.aIF = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ff(int i) {
        this.aIt = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aIG;
        LinearLayout avs;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
