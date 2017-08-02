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
    private ArrayList<b> aKY;
    private int aLa;
    private int aLb;
    private TbPageContext<?> aaS;
    private int padding;
    private int aKQ = -1;
    private int aLc = 0;
    private int alS = ai.getColor(d.e.common_color_10043);
    private int aKZ = ai.getColor(d.e.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aKY = null;
        this.aaS = null;
        this.padding = 0;
        this.aaS = tbPageContext;
        this.aKY = new ArrayList<>();
        this.aLa = k.g(tbPageContext.getPageActivity(), d.f.ds1);
        this.aLb = k.g(this.aaS.getPageActivity(), d.f.ds4);
        this.padding = k.g(this.aaS.getPageActivity(), d.f.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKY != null) {
            return this.aKY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aKY == null || i >= this.aKY.size()) {
            return null;
        }
        return this.aKY.get(i);
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
            view = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.recommend_system_photo_item, viewGroup, false);
            c0063a = new C0063a();
            c0063a.axn = (LinearLayout) view.findViewById(d.h.photo_container);
            c0063a.aLd = (TbImageView) view.findViewById(d.h.photo);
        } else {
            c0063a = (C0063a) view.getTag();
        }
        if (fj(i) == 1) {
            c0063a.axn.setPadding(0, this.padding, 0, 0);
        } else if (fj(i) == 2) {
            c0063a.axn.setPadding(0, 0, 0, this.padding);
        } else {
            c0063a.axn.setPadding(0, 0, 0, 0);
        }
        c0063a.aLd.setDrawerType(0);
        c0063a.aLd.setBorderSurroundContent(true);
        c0063a.aLd.setDrawBorder(true);
        if (itemViewType == 0) {
            c0063a.aLd.setBorderColor(this.alS);
            c0063a.aLd.setBorderWidth(this.aLa);
        } else {
            c0063a.aLd.setBorderColor(this.aKZ);
            c0063a.aLd.setBorderWidth(this.aLb);
        }
        c0063a.aLd.setDefaultResource(d.g.transparent_bg);
        c0063a.aLd.setDefaultErrorResource(d.g.icon_default_avatar100);
        c0063a.aLd.c(this.aKY.get(i).getUrl(), 10, false);
        view.setTag(c0063a);
        return view;
    }

    public int fj(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aLc - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aKQ ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aKY = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aLc = arrayList.size() / 4;
            } else {
                this.aLc = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fk(int i) {
        this.aKQ = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        TbImageView aLd;
        LinearLayout axn;

        private C0063a() {
        }
    }
}
