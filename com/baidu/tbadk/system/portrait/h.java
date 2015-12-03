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
    private ArrayList<i> aAl;
    private int aAo;
    private int aAp;
    private TbPageContext<?> mContext;
    private int padding;
    private int aAd = -1;
    private int rowSize = 0;
    private int aAm = as.getColor(n.c.black_alpha10);
    private int aAn = as.getColor(n.c.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aAl = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aAl = new ArrayList<>();
        this.aAo = k.d(tbPageContext.getPageActivity(), n.d.ds1);
        this.aAp = k.d(this.mContext.getPageActivity(), n.d.ds4);
        this.padding = k.d(this.mContext.getPageActivity(), n.d.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAl != null) {
            return this.aAl.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aAl == null || i >= this.aAl.size()) {
            return null;
        }
        return this.aAl.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.container = (LinearLayout) view.findViewById(n.f.photo_container);
            aVar.aAq = (TbImageView) view.findViewById(n.f.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (eO(i) == 1) {
            aVar.container.setPadding(0, this.padding, 0, 0);
        } else if (eO(i) == 2) {
            aVar.container.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.container.setPadding(0, 0, 0, 0);
        }
        aVar.aAq.setDrawerType(0);
        aVar.aAq.setBorderSurroundContent(true);
        aVar.aAq.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aAq.setBorderColor(this.aAm);
            aVar.aAq.setBorderWidth(this.aAo);
        } else {
            aVar.aAq.setBorderColor(this.aAn);
            aVar.aAq.setBorderWidth(this.aAp);
        }
        aVar.aAq.setDefaultResource(n.e.icon_default_avatar100);
        aVar.aAq.d(this.aAl.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int eO(int i) {
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
        return i == this.aAd ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<i> arrayList) {
        this.aAl = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void eP(int i) {
        this.aAd = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aAq;
        LinearLayout container;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
