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
    private ArrayList<i> aIt;
    private int aIw;
    private int aIx;
    private TbPageContext<?> aaI;
    private int padding;
    private int aIl = -1;
    private int aIy = 0;
    private int aIu = aq.getColor(w.e.common_color_10043);
    private int aIv = aq.getColor(w.e.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aIt = null;
        this.aaI = null;
        this.padding = 0;
        this.aaI = tbPageContext;
        this.aIt = new ArrayList<>();
        this.aIw = k.g(tbPageContext.getPageActivity(), w.f.ds1);
        this.aIx = k.g(this.aaI.getPageActivity(), w.f.ds4);
        this.padding = k.g(this.aaI.getPageActivity(), w.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIt != null) {
            return this.aIt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIt == null || i >= this.aIt.size()) {
            return null;
        }
        return this.aIt.get(i);
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
            view = LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.avm = (LinearLayout) view.findViewById(w.h.photo_container);
            aVar.aIz = (TbImageView) view.findViewById(w.h.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fe(i) == 1) {
            aVar.avm.setPadding(0, this.padding, 0, 0);
        } else if (fe(i) == 2) {
            aVar.avm.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.avm.setPadding(0, 0, 0, 0);
        }
        aVar.aIz.setDrawerType(0);
        aVar.aIz.setBorderSurroundContent(true);
        aVar.aIz.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aIz.setBorderColor(this.aIu);
            aVar.aIz.setBorderWidth(this.aIw);
        } else {
            aVar.aIz.setBorderColor(this.aIv);
            aVar.aIz.setBorderWidth(this.aIx);
        }
        aVar.aIz.setDefaultResource(w.g.transparent_bg);
        aVar.aIz.setDefaultErrorResource(w.g.icon_default_avatar100);
        aVar.aIz.c(this.aIt.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fe(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aIy - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aIl ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<i> arrayList) {
        this.aIt = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aIy = arrayList.size() / 4;
            } else {
                this.aIy = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ff(int i) {
        this.aIl = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aIz;
        LinearLayout avm;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
