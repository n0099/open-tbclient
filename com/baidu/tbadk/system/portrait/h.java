package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<i> aBS;
    private int aBV;
    private int aBW;
    private TbPageContext<?> mContext;
    private int padding;
    private int aBK = -1;
    private int rowSize = 0;
    private int aBT = as.getColor(n.d.black_alpha10);
    private int aBU = as.getColor(n.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aBS = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aBS = new ArrayList<>();
        this.aBV = k.d(tbPageContext.getPageActivity(), n.e.ds1);
        this.aBW = k.d(this.mContext.getPageActivity(), n.e.ds4);
        this.padding = k.d(this.mContext.getPageActivity(), n.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aBS != null) {
            return this.aBS.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aBS == null || i >= this.aBS.size()) {
            return null;
        }
        return this.aBS.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.container = (LinearLayout) view.findViewById(n.g.photo_container);
            aVar.aBX = (TbImageView) view.findViewById(n.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eI(i) == 1) {
            aVar.container.setPadding(0, this.padding, 0, 0);
        } else if (eI(i) == 2) {
            aVar.container.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.container.setPadding(0, 0, 0, 0);
        }
        aVar.aBX.setDrawerType(0);
        aVar.aBX.setBorderSurroundContent(true);
        aVar.aBX.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aBX.setBorderColor(this.aBT);
            aVar.aBX.setBorderWidth(this.aBV);
        } else {
            aVar.aBX.setBorderColor(this.aBU);
            aVar.aBX.setBorderWidth(this.aBW);
        }
        aVar.aBX.setDefaultResource(n.f.icon_default_avatar100);
        aVar.aBX.d(this.aBS.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eI(int i) {
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
        return i == this.aBK ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.aBS = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eJ(int i) {
        this.aBK = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aBX;
        LinearLayout container;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
