package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> LS;
    private ArrayList<i> ayY;
    private int azb;
    private int azc;
    private int padding;
    private int ayR = -1;
    private int rowSize = 0;
    private int ayZ = al.getColor(i.c.black_alpha10);
    private int aza = al.getColor(i.c.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.ayY = null;
        this.LS = null;
        this.padding = 0;
        this.LS = tbPageContext;
        this.ayY = new ArrayList<>();
        this.azb = k.d(tbPageContext.getPageActivity(), i.d.ds1);
        this.azc = k.d(this.LS.getPageActivity(), i.d.ds4);
        this.padding = k.d(this.LS.getPageActivity(), i.d.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ayY != null) {
            return this.ayY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ayY == null || i >= this.ayY.size()) {
            return null;
        }
        return this.ayY.get(i);
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
            view = LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.container = (LinearLayout) view.findViewById(i.f.photo_container);
            aVar.azd = (TbImageView) view.findViewById(i.f.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (et(i) == 1) {
            aVar.container.setPadding(0, this.padding, 0, 0);
        } else if (et(i) == 2) {
            aVar.container.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.container.setPadding(0, 0, 0, 0);
        }
        aVar.azd.setDrawerType(0);
        aVar.azd.setBorderSurroundContent(true);
        aVar.azd.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.azd.setBorderColor(this.ayZ);
            aVar.azd.setBorderWidth(this.azb);
        } else {
            aVar.azd.setBorderColor(this.aza);
            aVar.azd.setBorderWidth(this.azc);
        }
        aVar.azd.setDefaultResource(i.e.icon_default_avatar100);
        aVar.azd.d(this.ayY.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int et(int i) {
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
        return i == this.ayR ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.ayY = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eu(int i) {
        this.ayR = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView azd;
        LinearLayout container;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
