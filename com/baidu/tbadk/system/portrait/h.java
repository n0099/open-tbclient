package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<i> azh;
    private int azk;
    private int azl;
    private TbPageContext<?> mContext;
    private int padding;
    private int aza = -1;
    private int rowSize = 0;
    private int azi = am.getColor(i.c.black_alpha10);
    private int azj = am.getColor(i.c.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.azh = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.azh = new ArrayList<>();
        this.azk = k.d(tbPageContext.getPageActivity(), i.d.ds1);
        this.azl = k.d(this.mContext.getPageActivity(), i.d.ds4);
        this.padding = k.d(this.mContext.getPageActivity(), i.d.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azh != null) {
            return this.azh.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.azh == null || i >= this.azh.size()) {
            return null;
        }
        return this.azh.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.container = (LinearLayout) view.findViewById(i.f.photo_container);
            aVar.azm = (TbImageView) view.findViewById(i.f.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eC(i) == 1) {
            aVar.container.setPadding(0, this.padding, 0, 0);
        } else if (eC(i) == 2) {
            aVar.container.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.container.setPadding(0, 0, 0, 0);
        }
        aVar.azm.setDrawerType(0);
        aVar.azm.setBorderSurroundContent(true);
        aVar.azm.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.azm.setBorderColor(this.azi);
            aVar.azm.setBorderWidth(this.azk);
        } else {
            aVar.azm.setBorderColor(this.azj);
            aVar.azm.setBorderWidth(this.azl);
        }
        aVar.azm.setDefaultResource(i.e.icon_default_avatar100);
        aVar.azm.d(this.azh.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eC(int i) {
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
        return i == this.aza ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.azh = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eD(int i) {
        this.aza = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView azm;
        LinearLayout container;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
