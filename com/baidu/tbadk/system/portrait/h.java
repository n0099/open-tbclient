package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Fp;
    private ArrayList<i> aCW;
    private int aCZ;
    private int aDa;
    private int padding;
    private int aCO = -1;
    private int aDb = 0;
    private int aCX = ap.getColor(r.e.common_color_10043);
    private int aCY = ap.getColor(r.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aCW = null;
        this.Fp = null;
        this.padding = 0;
        this.Fp = tbPageContext;
        this.aCW = new ArrayList<>();
        this.aCZ = k.e(tbPageContext.getPageActivity(), r.f.ds1);
        this.aDa = k.e(this.Fp.getPageActivity(), r.f.ds4);
        this.padding = k.e(this.Fp.getPageActivity(), r.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aCW != null) {
            return this.aCW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aCW == null || i >= this.aCW.size()) {
            return null;
        }
        return this.aCW.get(i);
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
            view = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.apS = (LinearLayout) view.findViewById(r.h.photo_container);
            aVar.aDc = (TbImageView) view.findViewById(r.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fk(i) == 1) {
            aVar.apS.setPadding(0, this.padding, 0, 0);
        } else if (fk(i) == 2) {
            aVar.apS.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.apS.setPadding(0, 0, 0, 0);
        }
        aVar.aDc.setDrawerType(0);
        aVar.aDc.setBorderSurroundContent(true);
        aVar.aDc.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aDc.setBorderColor(this.aCX);
            aVar.aDc.setBorderWidth(this.aCZ);
        } else {
            aVar.aDc.setBorderColor(this.aCY);
            aVar.aDc.setBorderWidth(this.aDa);
        }
        aVar.aDc.setDefaultResource(r.g.transparent_bg);
        aVar.aDc.setDefaultErrorResource(r.g.icon_default_avatar100);
        aVar.aDc.c(this.aCW.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fk(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aDb - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aCO ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.aCW = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aDb = arrayList.size() / 4;
            } else {
                this.aDb = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fl(int i) {
        this.aCO = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aDc;
        LinearLayout apS;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
