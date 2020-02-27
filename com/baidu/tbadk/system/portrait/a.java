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
    private TbPageContext<?> cVg;
    private ArrayList<b> dFU;
    private int dFW;
    private int dFX;
    private int padding;
    private int dFN = -1;
    private int rowSize = 0;
    private int deq = am.getColor(R.color.common_color_10043);
    private int dFV = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.dFU = null;
        this.cVg = null;
        this.padding = 0;
        this.cVg = tbPageContext;
        this.dFU = new ArrayList<>();
        this.dFW = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.dFX = l.getDimens(this.cVg.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cVg.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dFU != null) {
            return this.dFU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dFU == null || i >= this.dFU.size()) {
            return null;
        }
        return this.dFU.get(i);
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
            view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0395a = new C0395a();
            c0395a.dtj = (LinearLayout) view.findViewById(R.id.photo_container);
            c0395a.dFY = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0395a = (C0395a) view.getTag();
        }
        if (mP(i) == 1) {
            c0395a.dtj.setPadding(0, this.padding, 0, 0);
        } else if (mP(i) == 2) {
            c0395a.dtj.setPadding(0, 0, 0, this.padding);
        } else {
            c0395a.dtj.setPadding(0, 0, 0, 0);
        }
        c0395a.dFY.setDrawerType(0);
        c0395a.dFY.setBorderSurroundContent(true);
        c0395a.dFY.setDrawBorder(true);
        if (itemViewType == 0) {
            c0395a.dFY.setBorderColor(this.deq);
            c0395a.dFY.setBorderWidth(this.dFW);
        } else {
            c0395a.dFY.setBorderColor(this.dFV);
            c0395a.dFY.setBorderWidth(this.dFX);
        }
        c0395a.dFY.setDefaultResource(R.drawable.transparent_bg);
        c0395a.dFY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0395a.dFY.startLoad(this.dFU.get(i).getUrl(), 10, false);
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
        return i == this.dFN ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.dFU = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void mQ(int i) {
        this.dFN = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0395a {
        TbImageView dFY;
        LinearLayout dtj;

        private C0395a() {
        }
    }
}
