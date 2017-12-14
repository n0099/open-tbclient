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
    private ArrayList<b> aMD;
    private int aMF;
    private int aMG;
    private TbPageContext<?> abX;
    private int padding;
    private int aMw = -1;
    private int rowSize = 0;
    private int ajY = aj.getColor(d.C0096d.common_color_10043);
    private int aME = aj.getColor(d.C0096d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aMD = null;
        this.abX = null;
        this.padding = 0;
        this.abX = tbPageContext;
        this.aMD = new ArrayList<>();
        this.aMF = l.f(tbPageContext.getPageActivity(), d.e.ds1);
        this.aMG = l.f(this.abX.getPageActivity(), d.e.ds4);
        this.padding = l.f(this.abX.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMD != null) {
            return this.aMD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMD == null || i >= this.aMD.size()) {
            return null;
        }
        return this.aMD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0078a c0078a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0078a = new C0078a();
            c0078a.axX = (LinearLayout) view.findViewById(d.g.photo_container);
            c0078a.aMH = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0078a = (C0078a) view.getTag();
        }
        if (fu(i) == 1) {
            c0078a.axX.setPadding(0, this.padding, 0, 0);
        } else if (fu(i) == 2) {
            c0078a.axX.setPadding(0, 0, 0, this.padding);
        } else {
            c0078a.axX.setPadding(0, 0, 0, 0);
        }
        c0078a.aMH.setDrawerType(0);
        c0078a.aMH.setBorderSurroundContent(true);
        c0078a.aMH.setDrawBorder(true);
        if (itemViewType == 0) {
            c0078a.aMH.setBorderColor(this.ajY);
            c0078a.aMH.setBorderWidth(this.aMF);
        } else {
            c0078a.aMH.setBorderColor(this.aME);
            c0078a.aMH.setBorderWidth(this.aMG);
        }
        c0078a.aMH.setDefaultResource(d.f.transparent_bg);
        c0078a.aMH.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0078a.aMH.startLoad(this.aMD.get(i).getUrl(), 10, false);
        view.setTag(c0078a);
        return view;
    }

    public int fu(int i) {
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
        return i == this.aMw ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aMD = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fv(int i) {
        this.aMw = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0078a {
        TbImageView aMH;
        LinearLayout axX;

        private C0078a() {
        }
    }
}
