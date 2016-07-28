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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> DQ;
    private ArrayList<i> aBs;
    private int aBv;
    private int aBw;
    private int padding;
    private int aBk = -1;
    private int rowSize = 0;
    private int aBt = av.getColor(u.d.common_color_10043);
    private int aBu = av.getColor(u.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aBs = null;
        this.DQ = null;
        this.padding = 0;
        this.DQ = tbPageContext;
        this.aBs = new ArrayList<>();
        this.aBv = k.c(tbPageContext.getPageActivity(), u.e.ds1);
        this.aBw = k.c(this.DQ.getPageActivity(), u.e.ds4);
        this.padding = k.c(this.DQ.getPageActivity(), u.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aBs != null) {
            return this.aBs.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aBs == null || i >= this.aBs.size()) {
            return null;
        }
        return this.aBs.get(i);
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
            view = LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.anA = (LinearLayout) view.findViewById(u.g.photo_container);
            aVar.aBx = (TbImageView) view.findViewById(u.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eT(i) == 1) {
            aVar.anA.setPadding(0, this.padding, 0, 0);
        } else if (eT(i) == 2) {
            aVar.anA.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.anA.setPadding(0, 0, 0, 0);
        }
        aVar.aBx.setDrawerType(0);
        aVar.aBx.setBorderSurroundContent(true);
        aVar.aBx.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aBx.setBorderColor(this.aBt);
            aVar.aBx.setBorderWidth(this.aBv);
        } else {
            aVar.aBx.setBorderColor(this.aBu);
            aVar.aBx.setBorderWidth(this.aBw);
        }
        aVar.aBx.setDefaultResource(u.f.transparent_bg);
        aVar.aBx.setDefaultErrorResource(u.f.icon_default_avatar100);
        aVar.aBx.c(this.aBs.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eT(int i) {
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
        return i == this.aBk ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aBs = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eU(int i) {
        this.aBk = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aBx;
        LinearLayout anA;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
