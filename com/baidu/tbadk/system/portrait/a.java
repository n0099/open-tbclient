package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> cVh;
    private ArrayList<b> dFV;
    private int dFX;
    private int dFY;
    private int padding;
    private int dFO = -1;
    private int rowSize = 0;
    private int der = am.getColor(R.color.common_color_10043);
    private int dFW = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.dFV = null;
        this.cVh = null;
        this.padding = 0;
        this.cVh = tbPageContext;
        this.dFV = new ArrayList<>();
        this.dFX = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.dFY = l.getDimens(this.cVh.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cVh.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dFV != null) {
            return this.dFV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dFV == null || i >= this.dFV.size()) {
            return null;
        }
        return this.dFV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0395a c0395a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0395a = new C0395a();
            c0395a.dtk = (LinearLayout) view.findViewById(R.id.photo_container);
            c0395a.dFZ = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0395a = (C0395a) view.getTag();
        }
        if (mP(i) == 1) {
            c0395a.dtk.setPadding(0, this.padding, 0, 0);
        } else if (mP(i) == 2) {
            c0395a.dtk.setPadding(0, 0, 0, this.padding);
        } else {
            c0395a.dtk.setPadding(0, 0, 0, 0);
        }
        c0395a.dFZ.setDrawerType(0);
        c0395a.dFZ.setBorderSurroundContent(true);
        c0395a.dFZ.setDrawBorder(true);
        if (itemViewType == 0) {
            c0395a.dFZ.setBorderColor(this.der);
            c0395a.dFZ.setBorderWidth(this.dFX);
        } else {
            c0395a.dFZ.setBorderColor(this.dFW);
            c0395a.dFZ.setBorderWidth(this.dFY);
        }
        c0395a.dFZ.setDefaultResource(R.drawable.transparent_bg);
        c0395a.dFZ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0395a.dFZ.startLoad(this.dFV.get(i).getUrl(), 10, false);
        view.setTag(c0395a);
        return view;
    }

    public int mP(int i) {
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
        return i == this.dFO ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.dFV = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void mQ(int i) {
        this.dFO = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0395a {
        TbImageView dFZ;
        LinearLayout dtk;

        private C0395a() {
        }
    }
}
