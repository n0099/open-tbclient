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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int cCA;
    private ArrayList<b> cCx;
    private int cCz;
    private TbPageContext<?> mContext;
    private int padding;
    private int cCq = -1;
    private int rowSize = 0;
    private int bXR = am.getColor(R.color.common_color_10043);
    private int cCy = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cCx = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.cCx = new ArrayList<>();
        this.cCz = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cCA = l.g(this.mContext.getPageActivity(), R.dimen.ds4);
        this.padding = l.g(this.mContext.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cCx != null) {
            return this.cCx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cCx == null || i >= this.cCx.size()) {
            return null;
        }
        return this.cCx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0261a c0261a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0261a = new C0261a();
            c0261a.coi = (LinearLayout) view.findViewById(R.id.photo_container);
            c0261a.cCB = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0261a = (C0261a) view.getTag();
        }
        if (kW(i) == 1) {
            c0261a.coi.setPadding(0, this.padding, 0, 0);
        } else if (kW(i) == 2) {
            c0261a.coi.setPadding(0, 0, 0, this.padding);
        } else {
            c0261a.coi.setPadding(0, 0, 0, 0);
        }
        c0261a.cCB.setDrawerType(0);
        c0261a.cCB.setBorderSurroundContent(true);
        c0261a.cCB.setDrawBorder(true);
        if (itemViewType == 0) {
            c0261a.cCB.setBorderColor(this.bXR);
            c0261a.cCB.setBorderWidth(this.cCz);
        } else {
            c0261a.cCB.setBorderColor(this.cCy);
            c0261a.cCB.setBorderWidth(this.cCA);
        }
        c0261a.cCB.setDefaultResource(R.drawable.transparent_bg);
        c0261a.cCB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0261a.cCB.startLoad(this.cCx.get(i).getUrl(), 10, false);
        view.setTag(c0261a);
        return view;
    }

    public int kW(int i) {
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
        return i == this.cCq ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void A(ArrayList<b> arrayList) {
        this.cCx = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kX(int i) {
        this.cCq = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0261a {
        TbImageView cCB;
        LinearLayout coi;

        private C0261a() {
        }
    }
}
