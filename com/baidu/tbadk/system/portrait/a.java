package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aMn;
    private int aMp;
    private int aMq;
    private TbPageContext<?> acp;
    private int padding;
    private int aMf = -1;
    private int aMr = 0;
    private int anl = ai.getColor(d.e.common_color_10043);
    private int aMo = ai.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aMn = null;
        this.acp = null;
        this.padding = 0;
        this.acp = tbPageContext;
        this.aMn = new ArrayList<>();
        this.aMp = k.g(tbPageContext.getPageActivity(), d.f.ds1);
        this.aMq = k.g(this.acp.getPageActivity(), d.f.ds4);
        this.padding = k.g(this.acp.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMn != null) {
            return this.aMn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMn == null || i >= this.aMn.size()) {
            return null;
        }
        return this.aMn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0063a c0063a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0063a = new C0063a();
            c0063a.ayE = (LinearLayout) view.findViewById(d.h.photo_container);
            c0063a.aMs = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0063a = (C0063a) view.getTag();
        }
        if (fl(i) == 1) {
            c0063a.ayE.setPadding(0, this.padding, 0, 0);
        } else if (fl(i) == 2) {
            c0063a.ayE.setPadding(0, 0, 0, this.padding);
        } else {
            c0063a.ayE.setPadding(0, 0, 0, 0);
        }
        c0063a.aMs.setDrawerType(0);
        c0063a.aMs.setBorderSurroundContent(true);
        c0063a.aMs.setDrawBorder(true);
        if (itemViewType == 0) {
            c0063a.aMs.setBorderColor(this.anl);
            c0063a.aMs.setBorderWidth(this.aMp);
        } else {
            c0063a.aMs.setBorderColor(this.aMo);
            c0063a.aMs.setBorderWidth(this.aMq);
        }
        c0063a.aMs.setDefaultResource(d.g.transparent_bg);
        c0063a.aMs.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0063a.aMs.c(this.aMn.get(i).getUrl(), 10, false);
        view.setTag(c0063a);
        return view;
    }

    public int fl(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aMr - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aMf ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aMn = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aMr = arrayList.size() / 4;
            } else {
                this.aMr = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fm(int i) {
        this.aMf = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        TbImageView aMs;
        LinearLayout ayE;

        private C0063a() {
        }
    }
}
