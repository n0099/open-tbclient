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
    private ArrayList<b> aMp;
    private int aMr;
    private int aMs;
    private TbPageContext<?> acr;
    private int padding;
    private int aMh = -1;
    private int aMt = 0;
    private int anm = ai.getColor(d.e.common_color_10043);
    private int aMq = ai.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aMp = null;
        this.acr = null;
        this.padding = 0;
        this.acr = tbPageContext;
        this.aMp = new ArrayList<>();
        this.aMr = k.g(tbPageContext.getPageActivity(), d.f.ds1);
        this.aMs = k.g(this.acr.getPageActivity(), d.f.ds4);
        this.padding = k.g(this.acr.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMp != null) {
            return this.aMp.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMp == null || i >= this.aMp.size()) {
            return null;
        }
        return this.aMp.get(i);
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
            c0063a.ayG = (LinearLayout) view.findViewById(d.h.photo_container);
            c0063a.aMu = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0063a = (C0063a) view.getTag();
        }
        if (fl(i) == 1) {
            c0063a.ayG.setPadding(0, this.padding, 0, 0);
        } else if (fl(i) == 2) {
            c0063a.ayG.setPadding(0, 0, 0, this.padding);
        } else {
            c0063a.ayG.setPadding(0, 0, 0, 0);
        }
        c0063a.aMu.setDrawerType(0);
        c0063a.aMu.setBorderSurroundContent(true);
        c0063a.aMu.setDrawBorder(true);
        if (itemViewType == 0) {
            c0063a.aMu.setBorderColor(this.anm);
            c0063a.aMu.setBorderWidth(this.aMr);
        } else {
            c0063a.aMu.setBorderColor(this.aMq);
            c0063a.aMu.setBorderWidth(this.aMs);
        }
        c0063a.aMu.setDefaultResource(d.g.transparent_bg);
        c0063a.aMu.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0063a.aMu.c(this.aMp.get(i).getUrl(), 10, false);
        view.setTag(c0063a);
        return view;
    }

    public int fl(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aMt - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aMh ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aMp = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aMt = arrayList.size() / 4;
            } else {
                this.aMt = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fm(int i) {
        this.aMh = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        TbImageView aMu;
        LinearLayout ayG;

        private C0063a() {
        }
    }
}
