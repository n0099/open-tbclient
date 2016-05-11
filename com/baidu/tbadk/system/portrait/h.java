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
    private TbPageContext<?> Do;
    private ArrayList<i> azK;
    private int azN;
    private int azO;
    private int padding;
    private int azC = -1;
    private int azP = 0;
    private int azL = at.getColor(t.d.black_alpha10);
    private int azM = at.getColor(t.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.azK = null;
        this.Do = null;
        this.padding = 0;
        this.Do = tbPageContext;
        this.azK = new ArrayList<>();
        this.azN = k.c(tbPageContext.getPageActivity(), t.e.ds1);
        this.azO = k.c(this.Do.getPageActivity(), t.e.ds4);
        this.padding = k.c(this.Do.getPageActivity(), t.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azK != null) {
            return this.azK.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.azK == null || i >= this.azK.size()) {
            return null;
        }
        return this.azK.get(i);
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
            view = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.amf = (LinearLayout) view.findViewById(t.g.photo_container);
            aVar.azQ = (TbImageView) view.findViewById(t.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eP(i) == 1) {
            aVar.amf.setPadding(0, this.padding, 0, 0);
        } else if (eP(i) == 2) {
            aVar.amf.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.amf.setPadding(0, 0, 0, 0);
        }
        aVar.azQ.setDrawerType(0);
        aVar.azQ.setBorderSurroundContent(true);
        aVar.azQ.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.azQ.setBorderColor(this.azL);
            aVar.azQ.setBorderWidth(this.azN);
        } else {
            aVar.azQ.setBorderColor(this.azM);
            aVar.azQ.setBorderWidth(this.azO);
        }
        aVar.azQ.setDefaultResource(t.f.transparent_bg);
        aVar.azQ.setDefaultErrorResource(t.f.icon_default_avatar100);
        aVar.azQ.c(this.azK.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eP(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.azP - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.azC ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void r(ArrayList<i> arrayList) {
        this.azK = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.azP = arrayList.size() / 4;
            } else {
                this.azP = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eQ(int i) {
        this.azC = i;
    }

    /* loaded from: classes.dex */
    private class a {
        LinearLayout amf;
        TbImageView azQ;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
