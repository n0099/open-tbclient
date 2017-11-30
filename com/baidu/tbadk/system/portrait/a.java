package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private int aMB;
    private int aMC;
    private ArrayList<b> aMz;
    private TbPageContext<?> acd;
    private int padding;
    private int aMs = -1;
    private int aMD = 0;
    private int akb = aj.getColor(d.C0082d.common_color_10043);
    private int aMA = aj.getColor(d.C0082d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aMz = null;
        this.acd = null;
        this.padding = 0;
        this.acd = tbPageContext;
        this.aMz = new ArrayList<>();
        this.aMB = l.f(tbPageContext.getPageActivity(), d.e.ds1);
        this.aMC = l.f(this.acd.getPageActivity(), d.e.ds4);
        this.padding = l.f(this.acd.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMz != null) {
            return this.aMz.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMz == null || i >= this.aMz.size()) {
            return null;
        }
        return this.aMz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0064a c0064a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0064a = new C0064a();
            c0064a.axS = (LinearLayout) view.findViewById(d.g.photo_container);
            c0064a.aME = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (fu(i) == 1) {
            c0064a.axS.setPadding(0, this.padding, 0, 0);
        } else if (fu(i) == 2) {
            c0064a.axS.setPadding(0, 0, 0, this.padding);
        } else {
            c0064a.axS.setPadding(0, 0, 0, 0);
        }
        c0064a.aME.setDrawerType(0);
        c0064a.aME.setBorderSurroundContent(true);
        c0064a.aME.setDrawBorder(true);
        if (itemViewType == 0) {
            c0064a.aME.setBorderColor(this.akb);
            c0064a.aME.setBorderWidth(this.aMB);
        } else {
            c0064a.aME.setBorderColor(this.aMA);
            c0064a.aME.setBorderWidth(this.aMC);
        }
        c0064a.aME.setDefaultResource(d.f.transparent_bg);
        c0064a.aME.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0064a.aME.startLoad(this.aMz.get(i).getUrl(), 10, false);
        view.setTag(c0064a);
        return view;
    }

    public int fu(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.aMD - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aMs ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aMz = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.aMD = arrayList.size() / 4;
            } else {
                this.aMD = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fv(int i) {
        this.aMs = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a {
        TbImageView aME;
        LinearLayout axS;

        private C0064a() {
        }
    }
}
