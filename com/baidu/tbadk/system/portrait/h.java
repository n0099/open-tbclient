package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> Gf;
    private ArrayList<i> aEg;
    private int aEj;
    private int aEk;
    private int padding;
    private int aDY = -1;
    private int aEl = 0;
    private int aEh = ar.getColor(r.d.common_color_10043);
    private int aEi = ar.getColor(r.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aEg = null;
        this.Gf = null;
        this.padding = 0;
        this.Gf = tbPageContext;
        this.aEg = new ArrayList<>();
        this.aEj = k.e(tbPageContext.getPageActivity(), r.e.ds1);
        this.aEk = k.e(this.Gf.getPageActivity(), r.e.ds4);
        this.padding = k.e(this.Gf.getPageActivity(), r.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEg != null) {
            return this.aEg.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aEg == null || i >= this.aEg.size()) {
            return null;
        }
        return this.aEg.get(i);
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
            view = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.aqM = (LinearLayout) view.findViewById(r.g.photo_container);
            aVar.aEm = (TbImageView) view.findViewById(r.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fj(i) == 1) {
            aVar.aqM.setPadding(0, this.padding, 0, 0);
        } else if (fj(i) == 2) {
            aVar.aqM.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.aqM.setPadding(0, 0, 0, 0);
        }
        aVar.aEm.setDrawerType(0);
        aVar.aEm.setBorderSurroundContent(true);
        aVar.aEm.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aEm.setBorderColor(this.aEh);
            aVar.aEm.setBorderWidth(this.aEj);
        } else {
            aVar.aEm.setBorderColor(this.aEi);
            aVar.aEm.setBorderWidth(this.aEk);
        }
        aVar.aEm.setDefaultResource(r.f.transparent_bg);
        aVar.aEm.setDefaultErrorResource(r.f.icon_default_avatar100);
        aVar.aEm.c(this.aEg.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fj(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aEl - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aDY ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.aEg = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aEl = arrayList.size() / 4;
            } else {
                this.aEl = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fk(int i) {
        this.aDY = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aEm;
        LinearLayout aqM;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
