package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> dPv;
    private ArrayList<b> eDC;
    private int eDE;
    private int eDF;
    private int padding;
    private int eDv = -1;
    private int rowSize = 0;
    private int dXd = an.getColor(R.color.common_color_10043);
    private int eDD = an.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.eDC = null;
        this.dPv = null;
        this.padding = 0;
        this.dPv = tbPageContext;
        this.eDC = new ArrayList<>();
        this.eDE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.eDF = l.getDimens(this.dPv.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.dPv.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eDC != null) {
            return this.eDC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eDC == null || i >= this.eDC.size()) {
            return null;
        }
        return this.eDC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0500a c0500a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0500a = new C0500a();
            c0500a.eqD = (LinearLayout) view.findViewById(R.id.photo_container);
            c0500a.eDG = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0500a = (C0500a) view.getTag();
        }
        if (oc(i) == 1) {
            c0500a.eqD.setPadding(0, this.padding, 0, 0);
        } else if (oc(i) == 2) {
            c0500a.eqD.setPadding(0, 0, 0, this.padding);
        } else {
            c0500a.eqD.setPadding(0, 0, 0, 0);
        }
        c0500a.eDG.setDrawerType(0);
        c0500a.eDG.setBorderSurroundContent(true);
        c0500a.eDG.setDrawBorder(true);
        if (itemViewType == 0) {
            c0500a.eDG.setBorderColor(this.dXd);
            c0500a.eDG.setBorderWidth(this.eDE);
        } else {
            c0500a.eDG.setBorderColor(this.eDD);
            c0500a.eDG.setBorderWidth(this.eDF);
        }
        c0500a.eDG.setDefaultResource(R.drawable.transparent_bg);
        c0500a.eDG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0500a.eDG.startLoad(this.eDC.get(i).getUrl(), 10, false);
        view.setTag(c0500a);
        return view;
    }

    public int oc(int i) {
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
        return i == this.eDv ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.eDC = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void od(int i) {
        this.eDv = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0500a {
        TbImageView eDG;
        LinearLayout eqD;

        private C0500a() {
        }
    }
}
