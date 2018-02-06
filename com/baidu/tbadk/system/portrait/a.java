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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> aRR;
    private ArrayList<b> bCO;
    private int bCQ;
    private int bCR;
    private int padding;
    private int bCH = -1;
    private int rowSize = 0;
    private int bab = aj.getColor(d.C0140d.common_color_10043);
    private int bCP = aj.getColor(d.C0140d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.bCO = null;
        this.aRR = null;
        this.padding = 0;
        this.aRR = tbPageContext;
        this.bCO = new ArrayList<>();
        this.bCQ = l.t(tbPageContext.getPageActivity(), d.e.ds1);
        this.bCR = l.t(this.aRR.getPageActivity(), d.e.ds4);
        this.padding = l.t(this.aRR.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCO != null) {
            return this.bCO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bCO == null || i >= this.bCO.size()) {
            return null;
        }
        return this.bCO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0114a c0114a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0114a = new C0114a();
            c0114a.boK = (LinearLayout) view.findViewById(d.g.photo_container);
            c0114a.bCS = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0114a = (C0114a) view.getTag();
        }
        if (im(i) == 1) {
            c0114a.boK.setPadding(0, this.padding, 0, 0);
        } else if (im(i) == 2) {
            c0114a.boK.setPadding(0, 0, 0, this.padding);
        } else {
            c0114a.boK.setPadding(0, 0, 0, 0);
        }
        c0114a.bCS.setDrawerType(0);
        c0114a.bCS.setBorderSurroundContent(true);
        c0114a.bCS.setDrawBorder(true);
        if (itemViewType == 0) {
            c0114a.bCS.setBorderColor(this.bab);
            c0114a.bCS.setBorderWidth(this.bCQ);
        } else {
            c0114a.bCS.setBorderColor(this.bCP);
            c0114a.bCS.setBorderWidth(this.bCR);
        }
        c0114a.bCS.setDefaultResource(d.f.transparent_bg);
        c0114a.bCS.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0114a.bCS.startLoad(this.bCO.get(i).getUrl(), 10, false);
        view.setTag(c0114a);
        return view;
    }

    public int im(int i) {
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
        return i == this.bCH ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<b> arrayList) {
        this.bCO = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void in(int i) {
        this.bCH = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0114a {
        TbImageView bCS;
        LinearLayout boK;

        private C0114a() {
        }
    }
}
