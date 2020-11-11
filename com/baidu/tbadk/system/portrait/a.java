package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eIc;
    private ArrayList<b> fxU;
    private int fxW;
    private int fxX;
    private int padding;
    private int fxN = -1;
    private int rowSize = 0;
    private int eRQ = ap.getColor(R.color.common_color_10043);
    private int fxV = ap.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.fxU = null;
        this.eIc = null;
        this.padding = 0;
        this.eIc = tbPageContext;
        this.fxU = new ArrayList<>();
        this.fxW = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fxX = l.getDimens(this.eIc.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eIc.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxU != null) {
            return this.fxU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fxU == null || i >= this.fxU.size()) {
            return null;
        }
        return this.fxU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0597a c0597a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0597a = new C0597a();
            c0597a.fkc = (LinearLayout) view.findViewById(R.id.photo_container);
            c0597a.fxY = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0597a = (C0597a) view.getTag();
        }
        if (rP(i) == 1) {
            c0597a.fkc.setPadding(0, this.padding, 0, 0);
        } else if (rP(i) == 2) {
            c0597a.fkc.setPadding(0, 0, 0, this.padding);
        } else {
            c0597a.fkc.setPadding(0, 0, 0, 0);
        }
        c0597a.fxY.setDrawerType(0);
        c0597a.fxY.setBorderSurroundContent(true);
        c0597a.fxY.setDrawBorder(true);
        if (itemViewType == 0) {
            c0597a.fxY.setBorderColor(this.eRQ);
            c0597a.fxY.setBorderWidth(this.fxW);
        } else {
            c0597a.fxY.setBorderColor(this.fxV);
            c0597a.fxY.setBorderWidth(this.fxX);
        }
        c0597a.fxY.setDefaultResource(R.drawable.transparent_bg);
        c0597a.fxY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0597a.fxY.startLoad(this.fxU.get(i).getUrl(), 10, false);
        view.setTag(c0597a);
        return view;
    }

    public int rP(int i) {
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
        return i == this.fxN ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fxU = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void rQ(int i) {
        this.fxN = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0597a {
        LinearLayout fkc;
        TbImageView fxY;

        private C0597a() {
        }
    }
}
