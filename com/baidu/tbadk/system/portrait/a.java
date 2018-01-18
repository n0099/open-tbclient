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
    private TbPageContext<?> aQp;
    private ArrayList<b> bAC;
    private int bAE;
    private int bAF;
    private int padding;
    private int bAv = -1;
    private int rowSize = 0;
    private int aYj = aj.getColor(d.C0107d.common_color_10043);
    private int bAD = aj.getColor(d.C0107d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.bAC = null;
        this.aQp = null;
        this.padding = 0;
        this.aQp = tbPageContext;
        this.bAC = new ArrayList<>();
        this.bAE = l.s(tbPageContext.getPageActivity(), d.e.ds1);
        this.bAF = l.s(this.aQp.getPageActivity(), d.e.ds4);
        this.padding = l.s(this.aQp.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bAC != null) {
            return this.bAC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bAC == null || i >= this.bAC.size()) {
            return null;
        }
        return this.bAC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0090a c0090a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0090a = new C0090a();
            c0090a.bmo = (LinearLayout) view.findViewById(d.g.photo_container);
            c0090a.bAG = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0090a = (C0090a) view.getTag();
        }
        if (ip(i) == 1) {
            c0090a.bmo.setPadding(0, this.padding, 0, 0);
        } else if (ip(i) == 2) {
            c0090a.bmo.setPadding(0, 0, 0, this.padding);
        } else {
            c0090a.bmo.setPadding(0, 0, 0, 0);
        }
        c0090a.bAG.setDrawerType(0);
        c0090a.bAG.setBorderSurroundContent(true);
        c0090a.bAG.setDrawBorder(true);
        if (itemViewType == 0) {
            c0090a.bAG.setBorderColor(this.aYj);
            c0090a.bAG.setBorderWidth(this.bAE);
        } else {
            c0090a.bAG.setBorderColor(this.bAD);
            c0090a.bAG.setBorderWidth(this.bAF);
        }
        c0090a.bAG.setDefaultResource(d.f.transparent_bg);
        c0090a.bAG.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0090a.bAG.startLoad(this.bAC.get(i).getUrl(), 10, false);
        view.setTag(c0090a);
        return view;
    }

    public int ip(int i) {
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
        return i == this.bAv ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<b> arrayList) {
        this.bAC = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void iq(int i) {
        this.bAv = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0090a {
        TbImageView bAG;
        LinearLayout bmo;

        private C0090a() {
        }
    }
}
