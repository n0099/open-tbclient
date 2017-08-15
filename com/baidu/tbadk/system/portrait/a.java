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
    private ArrayList<b> aMo;
    private int aMq;
    private int aMr;
    private TbPageContext<?> acr;
    private int padding;
    private int aMg = -1;
    private int aMs = 0;
    private int anm = ai.getColor(d.e.common_color_10043);
    private int aMp = ai.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aMo = null;
        this.acr = null;
        this.padding = 0;
        this.acr = tbPageContext;
        this.aMo = new ArrayList<>();
        this.aMq = k.g(tbPageContext.getPageActivity(), d.f.ds1);
        this.aMr = k.g(this.acr.getPageActivity(), d.f.ds4);
        this.padding = k.g(this.acr.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMo != null) {
            return this.aMo.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMo == null || i >= this.aMo.size()) {
            return null;
        }
        return this.aMo.get(i);
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
            view = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0063a = new C0063a();
            c0063a.ayF = (LinearLayout) view.findViewById(d.h.photo_container);
            c0063a.aMt = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0063a = (C0063a) view.getTag();
        }
        if (fl(i) == 1) {
            c0063a.ayF.setPadding(0, this.padding, 0, 0);
        } else if (fl(i) == 2) {
            c0063a.ayF.setPadding(0, 0, 0, this.padding);
        } else {
            c0063a.ayF.setPadding(0, 0, 0, 0);
        }
        c0063a.aMt.setDrawerType(0);
        c0063a.aMt.setBorderSurroundContent(true);
        c0063a.aMt.setDrawBorder(true);
        if (itemViewType == 0) {
            c0063a.aMt.setBorderColor(this.anm);
            c0063a.aMt.setBorderWidth(this.aMq);
        } else {
            c0063a.aMt.setBorderColor(this.aMp);
            c0063a.aMt.setBorderWidth(this.aMr);
        }
        c0063a.aMt.setDefaultResource(d.g.transparent_bg);
        c0063a.aMt.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0063a.aMt.c(this.aMo.get(i).getUrl(), 10, false);
        view.setTag(c0063a);
        return view;
    }

    public int fl(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aMs - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aMg ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aMo = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aMs = arrayList.size() / 4;
            } else {
                this.aMs = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fm(int i) {
        this.aMg = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        TbImageView aMt;
        LinearLayout ayF;

        private C0063a() {
        }
    }
}
